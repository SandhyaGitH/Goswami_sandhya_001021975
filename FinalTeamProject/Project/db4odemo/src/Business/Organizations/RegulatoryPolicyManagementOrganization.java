/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;

import Business.Role.BusinessManagerRole;
import Business.Role.RegPolicyManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class RegulatoryPolicyManagementOrganization extends Organization{

    public RegulatoryPolicyManagementOrganization() {
        super(Organization.Type.RegPolicyManagement.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RegPolicyManagerRole());
        return roles;
    }
     
}