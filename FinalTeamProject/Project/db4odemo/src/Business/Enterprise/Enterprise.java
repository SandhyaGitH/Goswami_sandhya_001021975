/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organizations.Organization;
import Business.Organizations.OrganizationDirectory;

/**
 *
 * @author Anish
 */
public abstract class Enterprise extends Organization {
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizaionDirectory;

    public OrganizationDirectory getOrganizaionDirectory() {
        return organizaionDirectory;
    }
    
    public enum EnterpriseType{
              
        InsuranceCompany("Insurance Company"),
        InsuranceRegulator("Insurance Regulator"),
        Hospitals("Hospitals");
        
        
        private String value;
        
        private EnterpriseType(String value){
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
        @Override
        public String toString(){
            return value;
        }
        
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
    
    
    
    public Enterprise (String name, EnterpriseType type){
        super(name);
        this.enterpriseType = type;
        organizaionDirectory = new OrganizationDirectory();
    }
    
}
