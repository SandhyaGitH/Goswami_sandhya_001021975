/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organizations.ClaimHandlerOrganizations;
import Business.Organizations.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ClaimHandlerRole.ClaimHandlerWorkAreaJPane;

/**
 *
 * @author Sandhya 
 */
public class ClaimHandlerRole extends Role {

    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ClaimHandlerWorkAreaJPane(userProcessContainer, account, (ClaimHandlerOrganizations) organization, business);
        //return new BusinessManagerWorkAreaJPane(userProcessContainer, account, organization, enterprise);
    }

    
}
