/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CustomerPolicy;

//import Business.Customer.*;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class PolicyDirectory {
    
    private ArrayList<Policy> policyList;

    public PolicyDirectory() {
        policyList = new ArrayList();
    }

    public ArrayList<Policy> getPolicyList() {
        return policyList;
    }
    
    public Policy createPolicy(Policy policy){
        //Policy policy = new Policy();
       // policy.setName(name);
       // policy.setCustomerName(customerName);
       if(policyList==null)
       policyList = new ArrayList();
        policyList.add(policy);
        return policy;
    }
}