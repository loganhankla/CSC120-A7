/**
 * Filename: Library.java
 * Description: The Library class is a subclass of the Building superclass. It stores information about the building and book collection.
 * @author Logan Hankla
 * Date: 27 March 2023
 */

import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /** The Library constructor creates a new Library that inherits from the Building class.
   * @param name The name of the library  
   * @param address The address of the library
   * @param nFloors The number of floors in the library
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
    this.collection = new Hashtable<String, Boolean>();
  }

  public Library(String name, String address, int nFloors){
    this(name, address, nFloors, nFloors > 1);

  }

  public void showOptions() {
    super.showOptions();
    System.out.println("+ addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection()");
  }

  //below copied from Building
 /*  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  } */

  public void goToFloor(int floorNum){ //?? check
    if(this.hasElevator()){
      super.goToFloor(floorNum);
    } else{
      throw new RuntimeException("This library doesn't have an elevator. Use goUp() or goDown() instead.");
    }
  }

  /** This method adds a book to the collection by adding the title as a key in the Hashtable collection and true as the value.
   * @param title The title of the book added to the collection
   */
  public void addTitle(String title){
    this.collection.put(title, true);
  }

  /** This methods removes a title from the collection after checking whether it is currently part of the collection.
   * @param title The title of the book being removed from the collection
   * @return The title of the book being removed from the collection
   * @throws RuntimeException
   */
  public String removeTitle(String title){
    if(containsTitle(title)){
      this.collection.remove(title);
      return title;
    } else{
      throw new RuntimeException("This book is not currently in the collection.");
    }
  }

  /** This method allows a title to be checked out from the collection, changing the value of the title key to false.
   * @param title The title of the book being checked out
   * @throws RuntimeException
   */
  public void checkOut(String title){
    if(isAvailable(title)){
      this.collection.replace(title, false);
    } else{
      throw new RuntimeException("This book is not currently available.");
    }
  }

  /** This methods allows a title to be returned to the collection, changing the value of the title key to true.
   * @param title The title of the book being returned
   * @throws RuntimeException
   */
  public void returnBook(String title){
    if(containsTitle(title)){
      this.collection.replace(title, true);
    } else{
      throw new RuntimeException("This book is not currently part of the library's collection.");
    }
  }

  /** This method checks whether the collection contains a given title.
   * @param title The title of the book we want to see if is in the collection
   * @return Boolean for whether the collection contains the book
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  }

  public boolean hasElevator(){
    return this.hasElevator;
  }

  /** This method checks whether a given book is available to be checked out.
   * @param title The title of the book we're checking
   * @return Boolean for whether the book is available
   */
  public boolean isAvailable(String title){
    if(this.collection.get(title)){
      return true;
    } else{
      return false;
    }
  }

  /** This method prints the current contents of the collection, including whether a given book is available.
   */
  public void printCollection(){
    for(String title : this.collection.keySet()){
      System.out.println("Title: " + title + " | Available: " + this.collection.get(title));
    }
  }

  public static void main(String[] args) {
    Library neilson = new Library("Neilson Library", "1 Chapin Way", 4, false);
    neilson.addTitle("Great Expectations");
    neilson.addTitle("On Such a Full Sea");
    neilson.addTitle("The Other Black Girl");
    neilson.printCollection();
    neilson.removeTitle("Great Expectations");
    neilson.checkOut("On Such a Full Sea");
    neilson.checkOut("The Other Black Girl");
    neilson.returnBook("On Such a Full Sea");
    System.out.println("Second print: ");
    neilson.printCollection();
    System.out.println(neilson.hasElevator());
  }
  
}