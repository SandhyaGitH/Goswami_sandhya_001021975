/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class CustomerDirectory {
    private ArrayList<Customer> CustomerList;

    public CustomerDirectory() {
        CustomerList=new ArrayList<Customer>();
    }

    
    public ArrayList<Customer> getCustomerList() {
        return CustomerList;
    }

    public void setCustomerList(ArrayList<Customer> CustomerList) {
        this.CustomerList = CustomerList;
    }
    
    public ArrayList<Customer> createCustomer(Customer customer){
        if(CustomerList==null)
            CustomerList = new ArrayList<Customer>();
        CustomerList.add(customer);
        return CustomerList;
    } 
    
  /*   public Customer createCustomer(String name, String address, int phoneNumber, UserAccount userAccount){
        Customer c = new Customer();
        c.setCustName(name);
        c.setCustAddress(address);
        c.setCustPhoneNumber(phoneNumber);
        c.setUserAccount(userAccount);
        customerList.add(c);  
        return c;
    }*/
   
    
}
