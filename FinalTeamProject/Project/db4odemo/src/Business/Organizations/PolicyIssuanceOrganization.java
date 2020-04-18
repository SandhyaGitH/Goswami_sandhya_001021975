/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;

import Business.Role.BusinessManagerRole;
import Business.Role.PolicyIssuerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class PolicyIssuanceOrganization extends Organization{

    public PolicyIssuanceOrganization() {
        super(Organization.Type.PolicyIssuance.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PolicyIssuerRole());
        return roles;
    }
     
}