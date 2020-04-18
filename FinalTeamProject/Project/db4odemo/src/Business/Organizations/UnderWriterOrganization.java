/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;

import Business.Role.BusinessManagerRole;
import Business.Role.Role;
import Business.Role.UnderWriterRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class UnderWriterOrganization extends Organization{

    public UnderWriterOrganization() {
        super(Organization.Type.UnderWriter.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new UnderWriterRole());
        return roles;
    }
     
}