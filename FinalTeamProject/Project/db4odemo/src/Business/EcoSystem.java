/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Business.Customer.Customer;
import Business.Customer.CustomerDirectory;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import Business.Network.Location;
//import Business.Network.Network;
import static Business.Organization.Type.Customer;
import Business.Restaurant.Restaurant;
import javax.swing.JOptionPane;
       

/**
 *
 * @author MyPC1
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private RestaurantDirectory restaurantDirectory;
    private CustomerDirectory customerDirectory;
    private DeliveryManDirectory deliveryManDirectory;

    public EcoSystem(RestaurantDirectory restaurantDirectory, CustomerDirectory customerDirectory, DeliveryManDirectory deliveryManDirectory) {

        this.restaurantDirectory =  restaurantDirectory;
        this.customerDirectory = customerDirectory;
        this.deliveryManDirectory = deliveryManDirectory;
    } 
     
     
     private EcoSystem(){
        super(null);
       networkList=new ArrayList<Location>();
       //networkList=new ArrayList<Location>();
       this.restaurantDirectory = new  RestaurantDirectory();
        this.customerDirectory = new CustomerDirectory();
        this.deliveryManDirectory = new  DeliveryManDirectory();
    }
    private ArrayList<Location> networkList;
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    public Location createAndAddNetwork(String name){
        Location network=new Location(name);
        networkList=getNetworkList();
        for (Location loc : getNetworkList()) {
            if(loc.getName().equals(name))
            { JOptionPane.showMessageDialog(null, "Location Already exist"); 
            return network;
            }
        }
        networkList.add(network);
        return network;
    }
    
    public Customer createAndAddCustDir(Customer customer){
        //Location network=new Location(customer);
        customerDirectory =getCustomerDirectory();
        for(int i=0;i<customerDirectory.getCustomerList().size();i++)
        {
          /*
            if(customerDirectory.getCustomerList().get(i).getUsername().equals(""))
            { JOptionPane.showMessageDialog(null, "Duplicate/empty username"); 
            return customer;
            } */
        } 
        customerDirectory.getCustomerList().add(customer);
        
        return customer;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    

  public ArrayList<Location> getNetworkList() {
      if(networkList!=null)
        return networkList;
      else return networkList=new ArrayList<Location>();
    }
  public CustomerDirectory getCustomerDirectory() {
      if(customerDirectory!=null)
        return customerDirectory;
      else return customerDirectory=new CustomerDirectory();
    }
/*public RestaurantDirectory getRestaurantList() {
      if(restaurantDirectory!=null)
        return restaurantDirectory;
      else return restaurantDirectory=new RestaurantDirectory();
    } */
    public void setNetworkList(ArrayList<Location> networkList) {
        this.networkList = networkList;
    }
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Location network:networkList){
            
        }
        return true;
    }
}
