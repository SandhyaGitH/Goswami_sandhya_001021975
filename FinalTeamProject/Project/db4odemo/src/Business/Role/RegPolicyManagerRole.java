/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
//import Business.Organizations.BusinessManagementOrganization;
//import Business.Organizations.ProductManagementOrganization;
import Business.Organizations.Organization;
import Business.Organizations.RegulatoryPolicyManagementOrganization;
import Business.UserAccount.UserAccount;
import userinterface.RegPolicyManagerRole.RegPolicyManagerWorkAreaJPane;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class RegPolicyManagerRole extends Role{

  /*  @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ProductManagerAreaJPanel(userProcessContainer, account, (ProductManagementOrganization)organization, enterprise);
    } */
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
      return new RegPolicyManagerWorkAreaJPane(userProcessContainer, account,enterprise,(RegulatoryPolicyManagementOrganization)organization ,business);
        //return new BusinessManagerWorkAreaJPane(userProcessContainer, account, organization, enterprise);
    }

  /*  @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business.Organization organization, Enterprise enterprise, EcoSystem business) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } */

   
    
    
}
