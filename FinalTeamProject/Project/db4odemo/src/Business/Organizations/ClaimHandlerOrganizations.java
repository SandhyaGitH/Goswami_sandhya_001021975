/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;

//import Business.Organization;
import Business.Role.ClaimHandlerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class ClaimHandlerOrganizations extends Organization{

    public ClaimHandlerOrganizations() {
        super(Organization.Type.ClaimHandler.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ClaimHandlerRole());
        return roles;
    }
     
}