/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;


import Business.Role.HPaymentManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class HospitalPaymentManagementOrganization extends Organization{

    public HospitalPaymentManagementOrganization() {
        super(Organization.Type.PaymentManagement.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HPaymentManagerRole());
        return roles;
    }
     
}