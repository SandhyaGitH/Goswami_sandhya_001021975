/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author raunak
 */
public class Employee {
    
    private String name;
    private int id;
    private static int count = 1;
    private String idStr;

    public Employee() {
        id = count;
        idStr= Integer.toString(id)+ generateId();
        count++;
    }

    public String getIdStr() {
        return idStr;
    }
private String generateId(){
         Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hhmmssMs");
        String datetime = ft.format(dNow);
        return datetime;
    }
    
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
