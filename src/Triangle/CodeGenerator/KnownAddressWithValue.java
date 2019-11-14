/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.CodeGenerator;

/**
 *
 * @author Esteban
 */
public class KnownAddressWithValue extends RuntimeEntity{

  public KnownAddressWithValue(){
    super();
    
  }
  
  public KnownAddressWithValue (int size, int level, int displacement, int value) {
    super(size);
    address = new ObjectAddress(level, displacement);
    this.value = value;
  }

  public ObjectAddress address;
  public int value;
  
}
