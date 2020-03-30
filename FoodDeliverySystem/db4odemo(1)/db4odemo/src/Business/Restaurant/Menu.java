/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Network.Location;

/**
 *
 * @author samarth
 */
public class Menu {
    private Location Network;
    private Restaurant Restaurant;

    public Menu( Location network, Restaurant restaurant,String menuItem,String description, String price, String isAvailable){
     this.Network=network;
     this.Restaurant=restaurant;
     this.menuItem=menuItem;
     this.description=description;
     this.price=price;
     this.Isavailable=isAvailable;
     
     }
    
    
    public Location getNetwork() {
        return Network;
    }

    public void setNetwork(Location Network) {
        this.Network = Network;
    }

    public Restaurant getRestaurant() {
        return Restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.Restaurant = restaurant;
    }
    private String menuItem;
    private String price;
    private String Isavailable;
     private String description;
     
     
            

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIsavailable() {
        return Isavailable;
    }

    public void setIsavailable(String Isavailable) {
        this.Isavailable = Isavailable;
    }
   
    
    
     @Override
    public String toString() {
        return menuItem;
    }
}
