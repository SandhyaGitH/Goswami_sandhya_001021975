/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;

//import Business.Role.BusinessManagerRole;
import Business.Role.RegVehicleInsuranceManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class VehicleInsuranceRegulatoryOrganization extends Organization{

    public VehicleInsuranceRegulatoryOrganization() {
        super(Organization.Type.VehicleInsRegulatory.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RegVehicleInsuranceManagerRole());
        return roles;
    }
     
}