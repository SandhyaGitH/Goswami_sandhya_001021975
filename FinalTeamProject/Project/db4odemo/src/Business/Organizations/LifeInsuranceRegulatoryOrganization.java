/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;

import Business.Role.BusinessManagerRole;
import Business.Role.RegLifeInsuranceManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class LifeInsuranceRegulatoryOrganization extends Organization{

    public LifeInsuranceRegulatoryOrganization() {
        super(Organization.Type.LifeInsRegulatory.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RegLifeInsuranceManagerRole());
        return roles;
    }
     
}