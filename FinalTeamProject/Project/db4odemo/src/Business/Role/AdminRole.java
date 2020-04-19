/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;

import Business.Organizations.Organization;
//import Business.Restaurant.Restaurant;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
//import userinterface.EnterpriseAdminRole.AdminWorkAreaJPanel;
import userinterface.AdministrativeRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class AdminRole extends Role{

   /* @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        return new AdminWorkAreaJPanel(userProcessContainer);
    } */
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
       // return new AdminWorkAreaJPanel(userProcessContainer, enterprise,business,account);
       return new AdminWorkAreaJPanel(userProcessContainer, enterprise, business);
    }
    
    
}
