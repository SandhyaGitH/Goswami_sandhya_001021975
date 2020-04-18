/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CustomerPolicy;

import Business.Employee.*;
import Business.WorkQueue.CustomerProductWorkRequest;

/**
 *
 * @author raunak
 */
public class Policy {
    
    private String policyIdStr;
    private String InsuranceName;
    private String enterpriseName;
    private String BrokerEnterpriseName;
    private CustomerProductWorkRequest custProdWQ;

    public String getInsuranceName() {
        return InsuranceName;
    }

    public void setInsuranceName(String InsuranceName) {
        this.InsuranceName = InsuranceName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getBrokerEnterpriseName() {
        return BrokerEnterpriseName;
    }

    public void setBrokerEnterpriseName(String BrokerEnterpriseName) {
        this.BrokerEnterpriseName = BrokerEnterpriseName;
    }

    public CustomerProductWorkRequest getCustProdWQ() {
        return custProdWQ;
    }

    public void setCustProdWQ(CustomerProductWorkRequest custProdWQ) {
        this.custProdWQ = custProdWQ;
    }
    private int id;
    private static int count = 1;
    private String customerName;
    private String customerMail;
    public Policy() {
        id = count;
        policyIdStr= Integer.toString(id) ;
        count++;
    }

    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.InsuranceName = name;
    }

    
    public String getName() {
        return InsuranceName;
    }

    @Override
    public String toString() {
        return policyIdStr;
    }
    
    
}
