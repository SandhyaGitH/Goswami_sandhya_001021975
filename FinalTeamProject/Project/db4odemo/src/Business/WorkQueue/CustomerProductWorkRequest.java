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
public class CustomerProductWorkRequest extends InsuranceProductWorkRequest{
    
    private String customerUserName;
    private String customerName;
    private String customerPhone;
    private String customerMailId;
    private int id;
    private String idStr;
    private static int count = 1;
    
    public CustomerProductWorkRequest() {
        id = count;
        idStr= Integer.toString(id) ;
        count++;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerMailId() {
        return customerMailId;
    }

    public void setCustomerMailId(String customerMailId) {
        this.customerMailId = customerMailId;
    }
       
    @Override
    public String toString(){
        if(idStr==null)
            return "";
        else return idStr;
    }
   /* 
    @Override
    public String toString(){
        return testResult;
    }
    */
    
}
