/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;
import Business.Enterprise.Enterprise;
import Business.Network.Location;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        idStr= Integer.toString(id) +generateId();
        count++;
    }
private String generateId(){
         Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hhmmssMs");
        String datetime = ft.format(dNow);
        return datetime;
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
