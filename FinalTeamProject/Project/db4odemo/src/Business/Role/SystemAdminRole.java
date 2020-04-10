/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organizations.Organization;
//import Business.Restaurant.Restaurant;

import Business.UserAccount.UserAccount;
import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class SystemAdminRole extends Role{

  /*
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem system) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    } */

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);//To change body of generated methods, choose Tools | Templates.
    }
    
} 
