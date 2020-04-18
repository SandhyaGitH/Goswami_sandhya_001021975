/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;

import Business.Employee.EmployeeDirectory;
import Business.Restaurant.MenuDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Anish
 */
public abstract class Organization {
    
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    
    public enum Type{
        InsuranceAdmin("Insurance Admin"),
        
        Customer("Customer"),
        
        CustomerAgent("Customer Agent"),
        UnderWriter("Underwriter"),
        BillingAgent("Billing Agent"),
        PolicyIssuance("Policy Issuance"),
        
        ProductManagement("Product management"),
        BusinessManagement("Business management"),
        
        RegulatoryAdmin("Regulatory Admin"),
        RegPolicyManagement("Regulatory Policy Management"),
        HealthInsRegulatory("Health Insurance Regulatory"),
        LifeInsRegulatory("Life Insurance Regulatory"),
        VehicleInsRegulatory("Vehicle Insurance Regulatory"),
        
        
        Admin("Admin Organization") {
        }, 
        WeCare("WeCare Organization"),
        Finance("Finance Organization"),
        Bank("Citizen Bank");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return  employeeDirectory;
    }

    
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
