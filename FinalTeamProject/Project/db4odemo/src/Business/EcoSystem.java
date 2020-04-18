/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Customer.Customer;
import Business.Customer.CustomerDirectory;
import Business.CustomerPolicy.Policy;
import Business.CustomerPolicy.PolicyDirectory;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.Enterprise.Enterprise;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import Business.Network.Location;
//import Business.Network.Network;
import static Business.Organization.Type.Customer;
import Business.Restaurant.Restaurant;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;

/**
 *
 * @author MyPC1
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private RestaurantDirectory restaurantDirectory;
    private CustomerDirectory customerDirectory;
    private DeliveryManDirectory deliveryManDirectory;
    private PolicyDirectory policyDirectory;

    public EcoSystem(RestaurantDirectory restaurantDirectory, CustomerDirectory customerDirectory, DeliveryManDirectory deliveryManDirectory ,PolicyDirectory policyDirectory) {

        this.restaurantDirectory = restaurantDirectory;
        this.customerDirectory = customerDirectory;
        this.deliveryManDirectory = deliveryManDirectory;
        this.policyDirectory = policyDirectory;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<Location>();
        //networkList=new ArrayList<Location>();
        this.restaurantDirectory = new RestaurantDirectory();
        this.customerDirectory = new CustomerDirectory();
        this.deliveryManDirectory = new DeliveryManDirectory();
        this.policyDirectory = new PolicyDirectory();
    }
    private ArrayList<Location> networkList;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    public Location createAndAddNetwork(String name) {
        Location network = new Location(name);
        networkList = getNetworkList();
        for (Location loc : getNetworkList()) {
            if (loc.getName().equals(name)) {
                JOptionPane.showMessageDialog(null, "Location Already exist");
                return network;
            }
        }
        networkList.add(network);
        return network;
    }

    public Customer createAndAddCustDir(Customer customer) {
        //Location network=new Location(customer);
        customerDirectory = getCustomerDirectory();
        for (int i = 0; i < customerDirectory.getCustomerList().size(); i++) {
            /*
            if(customerDirectory.getCustomerList().get(i).getUsername().equals(""))
            { JOptionPane.showMessageDialog(null, "Duplicate/empty username"); 
            return customer;
            } */
        }
        customerDirectory.getCustomerList().add(customer);

        return customer;
    }

    public CustomerDirectory getCustomerDirectory() {
        if (customerDirectory != null) {
            return customerDirectory;
        } else {
            return customerDirectory = new CustomerDirectory();
        }
    }
    
    public PolicyDirectory getCustPolicyDirectory() {
        if (policyDirectory != null) {
            return policyDirectory;
        } else {
            return policyDirectory = new PolicyDirectory();
        }
    }
    
    public Policy addCustPolicy(Policy policy) {
        
         policyDirectory = getCustPolicyDirectory();
         policyDirectory.getPolicyList().add(policy);

        return policy;
       
    } 

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public ArrayList<Location> getNetworkList() {
        if (networkList != null) {
            return networkList;
        } else {
            return networkList = new ArrayList<Location>();
        }
    }

    /*public RestaurantDirectory getRestaurantList() {
      if(restaurantDirectory!=null)
        return restaurantDirectory;
      else return restaurantDirectory=new RestaurantDirectory();
    } */
    public void setNetworkList(ArrayList<Location> networkList) {
        this.networkList = networkList;
    }

    public boolean checkIfUserIsUnique(String userName) {
        boolean isUnique;
        isUnique = this.getUserAccountDirectory().checkIfUsernameIsUnique(userName);

        if (isUnique) {
            for (Location network : this.getNetworkList()) {
                for (Enterprise entp : network.getEnterpriseDirectory().getEnterpriseList()) {

                    for (UserAccount userAccount : entp.getUserAccountDirectory().getUserAccountList()) {
                        if (userAccount.getUsername().equals(userName)) {
                            //JOptionPane.showMessageDialog(null, "Duplicate Username");
                            isUnique = false;

                        }

                    }
                    for (Business.Organizations.Organization org : entp.getOrganizaionDirectory().getOrganizationList()) {
                        for (UserAccount userAccount : org.getUserAccountDirectory().getUserAccountList()) {
                            if (userAccount.getUsername().equals(userName)) {
                                //JOptionPane.showMessageDialog(null, "Duplicate Username");
                                isUnique = false;

                            }

                        }
                    }
                }
            }
        }
        return isUnique;
    }

}
