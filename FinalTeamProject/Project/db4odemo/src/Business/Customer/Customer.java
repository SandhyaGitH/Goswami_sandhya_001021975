/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

/**
 *
 * @author harold
 */
public class Customer {
    
    private String Location;
    private String name;
    private String Username;
    private String Address;
    private String customerRating;
    private String customerEmail;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
     private int customerId;
     private String customerIdStr;
    private static int customerCount = 1;
    

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Customer(String Location, String name, String Username, String Address, String customerRating) {
        this.Location = Location;
        this.name = name;
        this.Username = Username;
        this.Address = Address;
        this.customerRating = customerRating;
    }

    /*public Customer()
    {} */
     
    public Customer()
    {
        customerId = customerCount;
        customerIdStr=Integer.toString(customerId);
        customerCount++;
    }
    
    public int getCustomerId() {
        return customerId;
    }
    
    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }
    
    @Override
    public String toString() {
        if(customerIdStr==null)
            return customerIdStr="";
        else  return customerIdStr;
    }
}
