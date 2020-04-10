/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;
import Business.Organization;
import Business.Role.Role;
import java.util.ArrayList;
//import Business.Organization.OrganizationDirectory;
/**
 *
 * @author harold
 */

    
public  class Restaurant extends Organization{ 
//private RestaurantType restaurantType;
private String name;
private String Location;
private String RestaurantType;
private MenuDirectory menuDirectory;
private ArrayList<Menu> menuList;
   
//private OrganizationDirectory organizationDirectory;
//public enum RestaurantType{
//        Hospital("Hospital");
//        
//        private String value;
//        
//        private RestaurantType(String value){
//            this.value=value;
//        }
//        public String getValue() {
//            return value;
//        }
//        @Override
//        public String toString(){
//        return value;
//    }
//    }

    public MenuDirectory getMenuDirectory() {
        return menuDirectory;
    }
  /*  public ArrayList<Menu> getMenuDirectory() {
        return menuList = (ArrayList<Menu>).menuDirectory ;//menuDirectory;
    } */

    public void setMenuDirectory(MenuDirectory menuDirectory) {
        this.menuDirectory = menuDirectory;
    }

    public String getRestaurantType() {
        return RestaurantType;
    }

    public void setRestaurantType(String RestaurantType) {
        this.RestaurantType = RestaurantType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
    public Restaurant(String name){
        super(name);
        this.name=name;
       // this.enterpriseType=type;
        //organizationDirectory=new OrganizationDirectory();
        menuDirectory= new MenuDirectory();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
