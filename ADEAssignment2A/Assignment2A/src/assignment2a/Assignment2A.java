/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2a;
import Business.VitalSigns;
import Business.Patient;
import Business.TestCases;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author samarth
 */

public class Assignment2A {
static Scanner Sc = new Scanner(System.in);
public static VitalSigns Vs;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // VitalSigns VSPatient ;
      //  VSPatient.setAge(0);
      CallTests();
      CallCustumTests();
        
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
      {System.out.println(TestName+" Patient is Abnormal Newborn");}
     
      //Testcase 2 
      TestName = "Testcase 2: ";
      Tc = new TestCases("Infant", "Normal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Infant");}
     else if (result == false)
     {System.out.println(TestName+" Patient is Abnormal Infant");}
     
      //Testcase 3
      TestName = "Testcase 3: ";
      Tc = new TestCases("Toddler", "Normal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Toddler");}
     else if (result == false)
     {System.out.println(TestName+" Patient is Abnormal Toddler");}
     
      //Testcase 4
      TestName = "Testcase 4: ";
      Tc = new TestCases("Preschooler", "Normal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Preschooler");}
     else if (result == false)
     {System.out.println(TestName+" Patient is Abnormal Preschooler");}
     
      //Testcase 5
      TestName = "Testcase 5: ";
      Tc = new TestCases("School Age", "Normal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal School Age");}
     else if (result == false)
     {System.out.println(TestName+" Patient is Abnormal School Age");}
     
     //Testcase 6
      TestName = "Testcase 6: ";
      Tc = new TestCases("Adolescent", "Normal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Adolescent");}
     else if (result == false)
     {System.out.println(TestName+" Patient is Abnormal Adolescent");}
     
     //Testcase 1 
      TestName = "Abnormal Testcase 1: ";
      Tc = new TestCases("Newborn", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
      if (result ==true)
             { System.out.println(TestName+" Patient is Normal Newborn");}
      else if (result == false)
      {System.out.println(TestName+ " Patient is Abnormal Newborn");}
     
      //Testcase 2 
      TestName = "Abnormal Testcase 2: ";
      Tc = new TestCases("Infant", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Infant");}
     else if (result == false)
     {System.out.println(TestName+" Patient is Abnormal Infant");}
     
      //Testcase 3
      TestName = "Abnormal Testcase 3: ";
      Tc = new TestCases("Toddler", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Toddler");}
     else if (result == false)
     {System.out.println(TestName+" Patient is Abnormal Toddler");}
     
      //Testcase 4
      TestName = "Abnormal Testcase 4: ";
      Tc = new TestCases("Preschooler", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Preschooler");}
     else if (result == false)
     {System.out.println(TestName+" Patient is Abnormal Preschooler");}
     
      //Testcase 5
      TestName = "Abnormal Testcase 5: ";
      Tc = new TestCases("School Age", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal School Age");}
     else if (result == false)
     {System.out.println(TestName+" Patient is Abnormal School Age");}
     
     //Testcase 6
      TestName = "Abnormal Testcase 6: ";
      Tc = new TestCases("Adolescent", "Abnormal");
      result =  P.IsPatientNormal(Tc.vitalSigns);
     if (result ==true)
             { System.out.println(TestName+" Patient is Normal Adolescent");}
     else if (result == false)
     {System.out.println(TestName+ " Patient is Abnormal Adolescent");}
    }
    
    private static void CallCustumTests()
    {  Vs = new VitalSigns();
        System.out.println("----- Enter below entries for Manual Test----");
       // System.out.println("Name ");
       // String  name  = Sc.nextLine();
        System.out.println("Age (In months)");
        int age=0;
         try {
            age = Sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entered Value is not a valid number.");
            return;
        }
      //  int age = Sc.nextInt();
        Vs.setAge(age);
        if(age==0)
            Vs.setGroupType("Newborn");
       else if(age>=1 && age<=12)
            Vs.setGroupType("Infant");
      else  if(age>=12 && age<=36)
            Vs.setGroupType("Toddler");
      else  if(age>=36 && age<=60)
            Vs.setGroupType("Preschooler");
      else  if(age>=60 && age<=144)
            Vs.setGroupType("School Age");
      else  if(age>=144 )
            Vs.setGroupType("Adolescent");
      else {System.out.println("Invalid Input"); }
        
        System.out.println("Respiratory Rate (Number only)");
         try {
            Vs.setRespiratoryRate(Sc.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Entered Value is not a valid number.");
            return;
        }
       
        System.out.println("HeartRate Rate (Number only)");
        try {
            Vs.setHeartRate(Sc.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Entered Value is not a valid number.");
            return;
        }
        
        System.out.println("Blood Pressure (Number only)");
        try {
           Vs.setBloodPressure(Sc.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Entered Value is not a valid number.");
            return;
        }
        System.out.println("Weight In Kgs");
        try {
           Vs.setWeightInKgs(Sc.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Entered Value is not a valid number.");
            return;
        }
        
        System.out.println("Weight In Pounds (Number only)");
        try {
        Vs.setWeightInPnds(Sc.nextFloat());
        } catch (InputMismatchException e) {
            System.out.println("Entered Value is not a valid number.");
            return;
        }
        Patient P = new Patient();
      boolean  result =  P.IsPatientNormal(Vs);
      if (result ==true)
             { System.out.println(" Patient is Normal " + Vs.getGroupType());}
      else if (result == false)
      {System.out.println(" Patient is Abnormal " + Vs.getGroupType());}
      //  if()
        
        
    }
    
}
