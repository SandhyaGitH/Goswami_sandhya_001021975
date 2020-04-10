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
public class ProductPuchaseWorkRequest extends InsuranceProductWorkRequest{
    
    private String stage; 
   // customer = 0:requested 01: cancelled 
    // customer agent = 1 : under customer aent ,10 :documentation Done ,11:Cancelled 
    // underWriter   = 2 : under underWriter  , 20 :done 21 :cancelled
    // 
   // billing agent =3 : under billing agent , 30 done , 31 cancelled 
    // policy issuer =4 : under policy issuer , 40 issued 
    
    //private String productName;
   // private String productDescription;
   // private String premuim ;
   
    
    
    
}
