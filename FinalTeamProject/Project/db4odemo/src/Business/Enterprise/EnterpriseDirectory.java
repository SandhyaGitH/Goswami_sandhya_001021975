/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;



import java.util.ArrayList;

/**
 *
 * @author Anish
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList = new ArrayList<Enterprise>();
    }
    
    //create Enterprise
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if(null != type)switch (type) {
            case InsuranceCompany:
                enterprise = new InsuranceCompany(name);
                enterpriseList.add(enterprise);
                break;       
            case InsuranceRegulator:
                  enterprise = new InsuranceRegulator(name);
                enterpriseList.add(enterprise);
                break;
            case Hospitals:
                enterprise = new Hospitals(name);
                enterpriseList.add(enterprise);
                break;
                case  InsuranceBroker:
                  enterprise = new InsuranceBroker(name);
                enterpriseList.add(enterprise);
                break;
            default:
                break;
        }
        
         /*  else if(type == Enterprise.EnterpriseType.MariettaIndustrialEnterprise){
        enterprise = new MariettaIndustrialEnterprise(name);
        enterpriseList.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.Government){
        enterprise = new GovernmentEnterprise(name);
        enterpriseList.add(enterprise);
        }  */
         
        return enterprise;
    }
    
}
