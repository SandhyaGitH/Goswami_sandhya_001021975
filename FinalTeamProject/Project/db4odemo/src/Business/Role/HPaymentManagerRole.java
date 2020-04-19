/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organizations.HospitalPaymentManagementOrganization;

import Business.Organizations.Organization;
import Business.UserAccount.UserAccount;
//import userinterface.BusinessManagerRole.BusinessManagerWorkAreaJPane;
import javax.swing.JPanel;
import userinterface.HospitalPayment.PaymentSettlementAreaJPanel;

/**
 *
 * @author raunak
 */
public class HPaymentManagerRole extends Role{

  /*  @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ProductManagerAreaJPanel(userProcessContainer, account, (ProductManagementOrganization)organization, enterprise);
    } */
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
      return new PaymentSettlementAreaJPanel(userProcessContainer, account,business);
        //return new BusinessManagerWorkAreaJPane(userProcessContainer, account, organization, enterprise);
    }

  /*  @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Business.Organization organization, Enterprise enterprise, EcoSystem business) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } */

   
    
    
}
