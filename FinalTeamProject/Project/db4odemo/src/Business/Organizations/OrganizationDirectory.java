/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organizations;


//import static System.Organization.Organization.Type.IndustrialEmissionManagement;
import java.util.ArrayList;

/**
 *
 * @author Anish
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;
    // OrganizationDirectory 
    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.ProductManagement.getValue())){
            organization = new ProductManagementOrganization();
           
        }
        else if (type.getValue().equals(Organization.Type.BusinessManagement.getValue())){
            organization = new BusinessManagementOrganization();
         }
         else if (type.getValue().equals(Organization.Type.RegPolicyManagement.getValue())){
            organization = new RegulatoryPolicyManagementOrganization();
         }
        else if (type.getValue().equals(Organization.Type.HealthInsRegulatory.getValue())){
            organization = new HealthInsuranceRegulatoryOrganization();
         }
        else if (type.getValue().equals(Organization.Type.LifeInsRegulatory.getValue())){
            organization = new LifeInsuranceRegulatoryOrganization();
         }
        else if (type.getValue().equals(Organization.Type.VehicleInsRegulatory.getValue())){
            organization = new VehicleInsuranceRegulatoryOrganization();
         }
         else if (type.getValue().equals(Organization.Type.CustomerAgent.getValue())){
            organization = new CustomerAgentOrganization();
         }
         else if (type.getValue().equals(Organization.Type.BillingAgent.getValue())){
            organization = new BillingAgentOrganization();
         }
         else if (type.getValue().equals(Organization.Type.UnderWriter.getValue())){
            organization = new UnderWriterOrganization();
         }
         else if (type.getValue().equals(Organization.Type.PolicyIssuance.getValue())){
            organization = new PolicyIssuanceOrganization();
         }
        
       
       boolean orgExists=false;
      for(Organization org : organizationList)
      {
          if(org.getName().equals(type.getValue()))
          {   orgExists=true; break; }
      }
      if(orgExists==false)
      organizationList.add(organization);
      
        return organization;
    }

    
}
