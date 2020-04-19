/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;
import Business.Enterprise.Enterprise;
import Business.Network.Location;

/**
 *
 * @author raunak
 */
public class InsuranceProductWorkRequest extends WorkRequest{
    
    private String testResult;
    private String productName;
    private String productDescription;
    private String premuim ;
    private String coverageAmount;
    private Location network;
    private Enterprise enterprise;
    private insuranceType insuranceType;
    private String ApprovalStage;
    private int ProductLaunchRequestId;
    private String ProductLaunchRequestIdStr;
    private static int count=1;
    
    public InsuranceProductWorkRequest()
    {
        ProductLaunchRequestId=count;
        ProductLaunchRequestIdStr=Integer.toString(ProductLaunchRequestId);
       count++;
    }

    public String getApprovalStage() {
        return ApprovalStage;
    }

    public void setApprovalStage(String ApprovalStage) {
        this.ApprovalStage = ApprovalStage;
    }

    public String getPremuim() {
        return premuim;
    }

    public void setPremuim(String premuim) {
        this.premuim = premuim;
    }

    public String getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(String coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public insuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(insuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Location getNetwork() {
        return network;
    }

    public void setNetwork(Location network) {
        this.network = network;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    public enum insuranceType{
        Health("Health Insurance"),
        Life("Life Insurance"),
     //   DeliveryMan("Delivery"),
        Vehicle("Vehicle Insurance");
        
        private String value;
        private insuranceType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
    @Override
    public String toString(){
        if(ProductLaunchRequestIdStr==null)
            return "";
        else return ProductLaunchRequestIdStr;
    }
    
    
}
