/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;
import Business.CustomerPolicy.Policy;
import Business.Enterprise.Enterprise;
import Business.Network.Location;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author raunak
 */
public class HospitalPaymentSettlementWorkRequest extends WorkRequest{
    
    private String testResult;   
    private String Diagnosis;
    private String BillAmout;
    private String HospitalName;

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String HospitalName) {
        this.HospitalName = HospitalName;
    }
    private int settlementRequestId;
    private String settlementRequestIdStr;
    private static int count=1;

    public String getSettlementRequestIdStr() {
        return settlementRequestIdStr;
    }
    private String generateId(){
         Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hhmmssMs");
        String datetime = ft.format(dNow);
        return datetime;
    }
    
    public HospitalPaymentSettlementWorkRequest()
    {
        settlementRequestId=count;
        settlementRequestIdStr=Integer.toString(settlementRequestId)+ generateId();
       count++;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String Diagnosis) {
        this.Diagnosis = Diagnosis;
    }

    public String getBillAmout() {
        return BillAmout;
    }

    public void setBillAmout(String BillAmout) {
        this.BillAmout = BillAmout;
    }
    private String ApprovalStage;
    private Policy policy;

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public String getApprovalStage() {
        return ApprovalStage;
    }

    public void setApprovalStage(String ApprovalStage) {
        this.ApprovalStage = ApprovalStage;
    }

   

  
   
   
    
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
    @Override
    public String toString(){
        return settlementRequestIdStr;
    }
    
    
}
