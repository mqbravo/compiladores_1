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

import Triangle.AbstractSyntaxTrees.CallCommand;
import Triangle.AbstractSyntaxTrees.CallExpression;
import Triangle.AbstractSyntaxTrees.Declaration;
import Triangle.AbstractSyntaxTrees.Identifier;

import java.util.ArrayList;

public final class IdentificationTable {

  private int level;
  private int recLevel;
  private IdEntry latest;
  private ArrayList<CallExpression> pendingCallExp;
  private ArrayList<CallCommand> pendingCallCmd;

  public IdentificationTable () {
    level = recLevel = 0;
    latest = null;
    pendingCallExp = new ArrayList<>();
    pendingCallCmd = new ArrayList<>();
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
    do {
      local = entry;
      entry = local.previous;
    } while (entry.level == this.level);
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

  /**
   * This method is used to collapse the current scope on the previous scope
   * Is only used in LocalVarDeclaration
   */
  public void closeLocalScope(){
    
     IdEntry entry, local, localEntry;

    // Presumably, idTable.level > 0.
    // First, I need to point local towards the first declaration in this scope
    entry = this.latest;
    do {
      local = entry;
      local.level = local.level-2;
      entry = local.previous;
    } while (entry.level == this.level);
    
    //Now, I need to skip all the entries belonging to the previous scope (local variables' scope)
    do {
      localEntry = entry;
      entry = localEntry.previous;
    } while (entry.level == this.level-1);
    
    //Now I anchor the entries I defined by using local declarations to the level they were in
    local.previous = entry;
    
    //And submit the changes in the scope level
    this.level = level-2;
  }

  public void openRecursiveScope(){
    recLevel++;
  }

  public void closeRecursiveScope(){
    //TODO
  }

  public int getRecLevel(){
    return recLevel;
  }

  public void addPendingCallExpression(CallExpression callExpression){
    pendingCallExp.add(callExpression);
  }


  public void addPendingCallCommand(CallCommand callCommand){
    pendingCallCmd.add(callCommand);
  }

  public CallExpression checkPendingCallExp(Identifier pfId){
    CallExpression callExpression;

    for(CallExpression c : pendingCallExp){
      if (c.I.equals(pfId)) {
        callExpression = c;
        pendingCallExp.remove(c);
        return callExpression;
      }
    }

    return null;
  }

  public CallCommand checkPendingCallCmd(Identifier pfId){
    CallCommand callCommand;

    for(CallCommand c : pendingCallCmd){
      if (c.I.equals(pfId)) {
        callCommand = c;
        pendingCallCmd.remove(c);
        return callCommand;
      }
    }

    return null;
  }

}
