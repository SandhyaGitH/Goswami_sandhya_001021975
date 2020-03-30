/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;

import Business.Organization;
import Business.Role.DeliverManRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class DeliveryManOrganization extends Organization{

    public DeliveryManOrganization() {
        super(Organization.Type.DeliveryMan.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DeliverManRole());
        return roles;
    }
     
   
    
    
}
