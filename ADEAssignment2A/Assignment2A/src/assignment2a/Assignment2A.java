/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2a;
import Business.VitalSigns;
import Business.Patient;
import Business.TestCases;

/**
 *
 * @author samarth
 */
public class Assignment2A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // VitalSigns VSPatient ;
      //  VSPatient.setAge(0);
      CallTests();
        
    }
    
    private static void CallTests()
    {
        Patient P = new Patient();
        String TestName ;
        TestCases Tc;
        boolean result;
      //Testcase 1 
      TestName = "Testcase 1: ";
      Tc = new TestCases("Newborn", "Normal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
      if (result ==true)
             { System.out.println(TestName+" Patient is Normal Newborn");}
      else if (result == false)
      {System.out.println("Patient is Abnormal Newborn");}
     
      //Testcase 2 
      TestName = "Testcase 2: ";
      Tc = new TestCases("Infant", "Normal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Infant");}
     else if (result == false)
     {System.out.println("Patient is Abnormal Infant");}
     
      //Testcase 3
      TestName = "Testcase 3: ";
      Tc = new TestCases("Toddler", "Normal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Toddler");}
     else if (result == false)
     {System.out.println("Patient is Abnormal Toddler");}
     
      //Testcase 4
      TestName = "Testcase 4: ";
      Tc = new TestCases("Preschooler", "Normal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Preschooler");}
     else if (result == false)
     {System.out.println("Patient is Abnormal Preschooler");}
     
      //Testcase 5
      TestName = "Testcase 5: ";
      Tc = new TestCases("School Age", "Normal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal School Age");}
     else if (result == false)
     {System.out.println("Patient is Abnormal School Age");}
     
     //Testcase 6
      TestName = "Testcase 6: ";
      Tc = new TestCases("Adolescent", "Normal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Adolescent");}
     else if (result == false)
     {System.out.println("Patient is Abnormal Adolescent");}
     
     //Testcase 1 
      TestName = "Abnormal Testcase 1: ";
      Tc = new TestCases("Newborn", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
      if (result ==true)
             { System.out.println(TestName+" Patient is Normal Newborn");}
      else if (result == false)
      {System.out.println("Patient is Abnormal Newborn");}
     
      //Testcase 2 
      TestName = "Abnormal Testcase 2: ";
      Tc = new TestCases("Infant", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Infant");}
     else if (result == false)
     {System.out.println("Patient is Abnormal Infant");}
     
      //Testcase 3
      TestName = "Abnormal Testcase 3: ";
      Tc = new TestCases("Toddler", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Toddler");}
     else if (result == false)
     {System.out.println("Patient is Abnormal Toddler");}
     
      //Testcase 4
      TestName = "Abnormal Testcase 4: ";
      Tc = new TestCases("Preschooler", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Preschooler");}
     else if (result == false)
     {System.out.println("Patient is Abnormal Preschooler");}
     
      //Testcase 5
      TestName = "Abnormal Testcase 5: ";
      Tc = new TestCases("School Age", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal School Age");}
     else if (result == false)
     {System.out.println("Patient is Abnormal School Age");}
     
     //Testcase 6
      TestName = "Abnormal Testcase 6: ";
      Tc = new TestCases("Adolescent", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Adolescent");}
     else if (result == false)
     {System.out.println("Patient is Abnormal Adolescent");}
    }
    
}
