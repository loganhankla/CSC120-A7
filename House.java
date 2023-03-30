/**
 * Filename: House.java
 * Description: The House class is a subclass of the superclass, Building. It stores information about the house & residents.
 * @author Logan Hankla
 * Date: 27 March 2023
 */

import java.util.ArrayList;

public class House extends Building {
  
  private ArrayList<String> residents; 
  private boolean hasDiningRoom; 

  /** The House constructor creates a new House that inherits from the Building class.
   * @param name The name of the new House.
   * @param address The address of the new House.
   * @param nFloors The number of floors in the new House.
   * @param diningRoom A boolean  for whether the House contains a dining room.
   */
  public House(String name, String address, int nFloors, boolean diningRoom) {
    //System.out.println("You have built a house: 🏠");
    super(name, address, nFloors); 
    this.residents = new ArrayList<String>(); 
    this.hasDiningRoom = diningRoom; 
  }

  /**This getter returns a boolean for whether or not a House has a dining room.
   * @return Whether the particular House has a dining room.
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /** This method returns the number of residents in the House based on the size of the ArrayList of residents.
   * @return Number of residents in House.
   */
  public int nResidents(){
    return this.residents.size();
  }

  /** This method allows a person to move in by adding them to the residents ArrayList if they are not already in there.
   * @param name Name of the person moving into the house.
   * @throws RuntimeException 
   */
  public void moveIn(String name){ 
    if(!this.residents.contains(name)){
      this.residents.add(name);
    } else{
      throw new RuntimeException(name + " already lives in this house.");
    }
  }

  /** This method allows a person to move out of the House by removing them from the residents ArrayList after checking if they are currently a resident.
   * @param name Name of the resident moving out
   * @return Name of resident moving
   * @throws RuntimeException
   */
  public String moveOut(String name){ 
    if(isResident(name)){
      this.residents.remove(name);
      return name;
    } else{
      throw new RuntimeException("This person does not live in this house.");
    }
  }

/** This method checks whether a person is a current resident in the house.
 * @param person The person we see if is a resident
 * @return boolean for whether the person is a resident
 */
  public boolean isResident(String person){ 
    if(this.residents.contains(person)){
      return true;
    } else{
      return false;
    }
  }

/** This toString method creates a description of the House.
 * @return Description of house
 */
  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.residents.size() + " residents in this house. ";
    description += "This house";
    if (this.hasDiningRoom){
      description += " has";

    } else {
      description += " does not have";
    }
    description += " a dining room.";
    return description;
  }

  public static void main(String[] args) {
    House wilson = new House("Wilson House", "16 Kensington Ave", 4, true);
    wilson.moveIn("Claire");
    System.out.println(wilson.hasDiningRoom());
    System.out.println(wilson.nResidents());
    System.out.println(wilson.isResident("Claire"));
    wilson.moveOut("Claire");
    System.out.println(wilson.isResident("Claire"));
    //wilson.moveOut("Logan");
    System.out.println(wilson);
  }
}