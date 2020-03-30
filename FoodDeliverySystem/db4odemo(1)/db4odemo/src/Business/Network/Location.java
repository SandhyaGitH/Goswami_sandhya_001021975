/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;
import Business.Restaurant.RestaurantDirectory;


/**
 *
 * @author MyPC1
 */
public class Location {
    private String name;
    private RestaurantDirectory restaurantDirectory;
    
    public Location(String name){
        this.name= name;
        restaurantDirectory=new RestaurantDirectory();
    }
    public Location(){
        
        restaurantDirectory=new RestaurantDirectory();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestaurantDirectory getRestaurantDirectory() {
        return restaurantDirectory;
    }
    
    /*public RestaurantDirectory getNetworkRestaurantList(String Location) {
        return restaurantDirectory;
    } */
    @Override
    public String toString(){
        return name;
    }
    
}

