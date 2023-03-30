/**
 * Filename: Cafe.java
 * Description: The Cafe class is a subclass of the superclass, Building. It stores information about the building and cafe inventory.
 * @author Logan Hankla
 * Date: 27 March 2023
 */

 public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
    
    /** The Cafe constructor creates a new Cafe that inherits from the Building class.
     * @param name The name of the Cafe
     * @param address The address of the Cafe
     * @param nFloors The number of floors in the Cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = 200;
        this.nSugarPackets = 175;
        this.nCreams = 109;
        this.nCups = 47;
    }

    /** This method is used to sell coffee, altering the inventory after a sale is made.
     * @param size The number of ounces of coffee in the sale
     * @param nSugarPackets The number of sugar packets in the sale
     * @param nCreams The number of cream splashes in the sale
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces >= size){
            if(this.nSugarPackets >= nSugarPackets){
                if(this.nCreams >= nCreams){
                    if(this.nCups >= 1){
                        this.nCoffeeOunces -= size;
                        this.nSugarPackets -= nSugarPackets;
                        this.nCreams -= nCreams;
                        this.nCups -= 1;
                    } else{
                        this.restock(0, 0, 0, 47);
                    }
                } else{ 
                    this.restock(0, 0, 109, 0);
                }
            } else{
                this.restock(0, 175, 0, 0);
            }
        } else{
            this.restock(200, 0, 0, 0);
        }
    }

    /** This method restocks the inventory as needed.
     * @param nCoffeeOunces The number of ounces of coffee to restock
     * @param nSugarPackets The number of sugar packets to restock
     * @param nCreams The number of splashes of cream to restock
     * @param nCups The number of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }
    
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "2 Chapin Way", 1);
        compass.sellCoffee(6, 2, 2);
        compass.sellCoffee(53, 2, 68);
        compass.sellCoffee(100, 56, 55);
        System.out.println("Coffee in Stock (oz): " + compass.nCoffeeOunces);
        System.out.println("Sugar in Stock: " + compass.nSugarPackets);
        System.out.println("Creams in Stock: " + compass.nCreams);
        System.out.println("Cups in Stock: " + compass.nCups);
    }
    
}
