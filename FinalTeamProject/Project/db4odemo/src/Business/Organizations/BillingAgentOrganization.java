/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;

import Business.Role.BillingAgentRole;
import Business.Role.BusinessManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class BillingAgentOrganization extends Organization{

    public BillingAgentOrganization() {
        super(Organization.Type.BillingAgent.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new BillingAgentRole());
        return roles;
    }
     
}