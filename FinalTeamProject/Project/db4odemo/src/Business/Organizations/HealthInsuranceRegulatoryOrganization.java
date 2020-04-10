/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;

import Business.Role.BusinessManagerRole;
import Business.Role.RegHealthInsuranceManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class HealthInsuranceRegulatoryOrganization extends Organization{

    public HealthInsuranceRegulatoryOrganization() {
        super(Organization.Type.HealthInsRegulatory.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RegHealthInsuranceManagerRole());
        return roles;
    }
     
}