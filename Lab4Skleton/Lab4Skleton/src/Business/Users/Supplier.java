/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.Abstract.User;
import Business.Product;
import Business.ProductDirectory;

/**
 *
 * @author AEDSpring2019
 */
public class Supplier extends User implements Comparable<Customer>{
    
    private ProductDirectory directory;
    
    public Supplier(String password, String userName) {
        super(password, userName, "SUPPLIER");
        directory = new ProductDirectory();
    }

    public ProductDirectory getDirectory() {
        return directory;
    }

    public void setDirectory(ProductDirectory directory) {
        this.directory = directory;
    }

/*    @Override
    public int compareTo(Supplier o) {
        return o.getUserName().compareTo(this.getUserName());
    }
*/

    @Override
    public String toString() {
        return getUserName(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean verify(String password){
        if(password.equals(getPassword()))
            return true;
        return false;
    }
    
    public boolean confirmPassword(String password1, String password2){
        if(password1.equals(password2))
            return true;
        return false;
    }

    @Override
    public int compareTo(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
