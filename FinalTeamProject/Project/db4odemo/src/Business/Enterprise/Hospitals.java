/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;
import Business.Role.Role;

/**
 *
 * @author Anish
 */
public class Hospitals extends Enterprise {
    
    public Hospitals(String name){
        super(name,Enterprise.EnterpriseType.Hospitals);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
