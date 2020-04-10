/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;

import Business.Role.BusinessManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class BusinessManagementOrganization extends Organization{

    public BusinessManagementOrganization() {
        super(Organization.Type.BusinessManagement.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new BusinessManagerRole());
        return roles;
    }
     
}