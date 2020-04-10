/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;
import Business.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class RestaurantDirectory {
     private ArrayList<Restaurant> restaurantList;
   

    public ArrayList<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(ArrayList<Restaurant> enterpriseList) {
        this.restaurantList = enterpriseList;
    }
    
    public RestaurantDirectory(){
        restaurantList=new ArrayList<Restaurant>();
    }
    
    //Create enterprise
    public Restaurant createAndAddRestaurant(String name,String type){
        Restaurant restaurant=new Restaurant(name);
       // restaurant.setName(name);
        //if(type==Restaurant.EnterpriseType.Hospital){
         //   restaurant=new HospitalEnterprise(name);
            restaurantList.add(restaurant);
       // }
        return restaurant;
    }

}
