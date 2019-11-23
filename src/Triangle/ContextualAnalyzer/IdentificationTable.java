/*
 * @(#)IdentificationTable.java                2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.ContextualAnalyzer;

import Triangle.AbstractSyntaxTrees.Declaration;
import Triangle.AbstractSyntaxTrees.Identifier;
import java.util.ArrayList;
import java.util.Objects;

public final class IdentificationTable {

  private int level;
  private int recLevel;
  private IdEntry latest;
  public ArrayList<PendingCall> pendingCalls;
  public ArrayList<FutureCallExpression> futureCallExpressions;

  public IdentificationTable () {
    level = recLevel = 0;
    latest = null;
    pendingCalls = new ArrayList<>();
    futureCallExpressions = new ArrayList<>();
  }

  public IdentificationTable(IdentificationTable oldIdTable){
    this.level = oldIdTable.level;
    this.latest = oldIdTable.latest;
    this.futureCallExpressions = oldIdTable.futureCallExpressions;
    //this.recLevel = oldIdTable.recLevel;
    //this.pendingCalls = oldIdTable.pendingCalls;
  }
  // Opens a new level in the identification table, 1 higher than the
  // current topmost level.

  public void openScope () {

    level ++;
  }

  // Closes the topmost level in the identification table, discarding
  // all entries belonging to that level.

  public void closeScope () {

    IdEntry entry, local;

    // Presumably, idTable.level > 0.
    entry = this.latest;
    while (entry.level == this.level){
      local = entry;
      entry = local.previous;
    }
    this.level--;
    this.latest = entry;
  }

  // Makes a new entry in the identification table for the given identifier
  // and attribute. The new entry belongs to the current level.
  // duplicated is set to to true iff there is already an entry for the
  // same identifier at the current level.

  public void enter (String id, Declaration attr) {

    IdEntry entry = this.latest;
    boolean present = false, searching = true;

    // Check for duplicate entry ...
    while (searching) {
      if (entry == null || entry.level < this.level)
        searching = false;
      else if (entry.id.equals(id)) {
        present = true;
        searching = false;
       } else
       entry = entry.previous;
    }

    attr.duplicated = present;
    // Add new entry ...
    entry = new IdEntry(id, attr, this.level, this.latest);
    this.latest = entry;
  }

  // Finds an entry for the given identifier in the identification table,
  // if any. If there are several entries for that identifier, finds the
  // entry at the highest level, in accordance with the scope rules.
  // Returns null iff no entry is found.
  // otherwise returns the attribute field of the entry found.

  public Declaration retrieve (String id) {

    IdEntry entry;
    Declaration attr = null;
    boolean present = false, searching = true;

    entry = this.latest;
    while (searching) {
      if (entry == null)
        searching = false;
      else if (entry.id.equals(id)) {
        present = true;
        searching = false;
        attr = entry.attr;
      } else
        entry = entry.previous;
    }

    return attr;
  }
  
  // Finds an entry for the given identifier in the identification table,
  // if any. If there are several entries for that identifier, finds the
  // entry at the highest level, in accordance with the scope rules.
  // Returns null iff no entry is found.
  // otherwise returns the attribute field of the entry found. 
  // This method is capable of filtering types of Declarations, it is used 
  // when the same operator is defined for both Unary and Binary Expressions
  public Declaration retrieve (String id, Class decClass) {

    IdEntry entry;
    Declaration attr = null;
    boolean searching = true;

    entry = this.latest;
    while (searching) {
      if (entry == null)
        searching = false;
      else if (entry.attr.getClass() == decClass && entry.id.equals(id)) {
        searching = false;
        attr = entry.attr;
      } else
        entry = entry.previous;
    }

    return attr;
  }
  
  /**
   * This method is used to collapse the current scope on the previous scope
   * Is only used in LocalVarDeclaration
   */
  public void closeLocalScope(){
    
     IdEntry entry = this.latest, local = entry, localEntry;

    // Presumably, idTable.level > 0.
    // First, I need to point local towards the first declaration in this scope
    
    while (entry.level == this.level) {
      local = entry;
      local.level = local.level-2;
      entry = local.previous;
    }
    
    //Now, I need to skip all the entries belonging to the previous scope (local variables' scope)
    while (entry.level == this.level-1) {
      localEntry = entry;
      entry = localEntry.previous;
    }
    
    //Now I anchor the entries I defined by using local declarations to the level they were in
    local.previous = entry;
    
    //And submit the changes in the scope level
    this.level = level-2;
  }

  public void openRecursiveScope(){
    recLevel++;
  }

  public void closeRecursiveScope(){
    recLevel--;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getRecLevel() {
    return recLevel;
  }

  public void setRecLevel(int recLevel) {
    this.recLevel = recLevel;
  }

  public void addPendingCall(PendingCall pendingCall){
    pendingCalls.add(pendingCall);
  }

  public void addFutureCallExp(FutureCallExpression ast){
    this.futureCallExpressions.add(ast);
  }

  public ArrayList<PendingCall> checkPendingCalls(Identifier pfId){

    ArrayList<PendingCall> toVisit = new ArrayList<>();
    //(When the program access this method,it does it in the level of the routine's body, so it's needed to subtract 1
    //to get the level of its declaration)
    int declLevel = level -1;

    for(PendingCall c : pendingCalls)
      //Check if the call's level is deeper than the level of the declaration.
      if (c.getLevel() > declLevel && c.getProcFuncIdentifier().equals(pfId))
        toVisit.add(c);

    pendingCalls.removeAll(toVisit);

    return toVisit;
  }

}
