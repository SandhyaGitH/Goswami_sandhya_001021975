/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2b_1;
import Business.VitalSigns;
import Business.Patient;
import java.util.ArrayList;
//import Business.TestCases;
import java.util.InputMismatchException;
import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeArray;
/**
 *
 * @author samarth
 */
public class Assignment2B_1 {
static Scanner Sc = new Scanner(System.in);
static Patient P = new Patient();
public static VitalSigns Vs;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CallCustumTests2();
    }
    
    
    private static void CallCustumTests()
    {      P = new Patient();
        Vs = new VitalSigns();
        System.out.println("----- Enter below entries for Manual Test----");
        System.out.println("Name ");
        String  name  = Sc.nextLine();
        P.setPatientName(name);
        int i =1;
        ArrayList<VitalSigns> Varr;
        while(i==1)
        {
           // i=0;
            Vs = new VitalSigns();
            
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
        Varr= new ArrayList<VitalSigns>();
        Varr.add(Vs);
   P.addPVitals(Vs);//PVitals(Varr);
           DisplayMenu();
          // Thread(3);
          System.out.println("Saved Successfully");
           String  Cases  = Sc.next().trim();
           while(Cases!="6"&& Cases!="1")
           {
        switch(Cases)
        { case "1":  i=1;break;
            case "2": 
             System.out.println("Please write one of the given VitalSign needs to be checked:");
             System.out.println("RR: for RespiratoryRate ");
             System.out.println("HR: for HeartRate ");
             System.out.println("BP: for BloodPressure ");
             String Vital=Sc.next();
             System.out.println();
              boolean  result1 =  P.IsThisVitalNormal(Vital);
                   if (result1 ==true)
                    { System.out.println(" Normal ");}
                   else if (result1 == false)
                     {System.out.println(" Abnormal " );}
                  // DisplayMenu();
            // DisplayMenu();
                    i=0;
            break;
            case "3":  
                  boolean  result =  P.IsPatientNormal(Vs);
                   if (result ==true)
                    { System.out.println(" Patient is Normal " + Vs.getGroupType());}
                   else if (result == false)
                     {System.out.println(" Patient is Abnormal " + Vs.getGroupType());}
                 //  DisplayMenu();
                  i=0; break;
            case "4" :   
                System.out.println(" Age |" + " RR  |"+ " HP  |"+ " BP |" + " WKG  |"+ " WIP   |");
               for(int k=0; k<P.getPVitals().size(); k++)
               {
                   System.out.println(P.getPVitals().get(k).getAge() + "    |"
                   + P.getPVitals().get(k).getRespiratoryRate()+ "    |"
                   + P.getPVitals().get(k).getHeartRate()+ "    |"
                           + P.getPVitals().get(k).getBloodPressure()+ "    |"
                           + P.getPVitals().get(k).getWeightInKgs()+ "    |"
                           + P.getPVitals().get(k).getWeightInPnds()+ "    |"
                   );
               }
                i=0;break;
            case "5":
                 System.out.println(" Age |" + " RR  |"+ " HP  |"+ " BP |" + " WKG  |"+ " WIP   |");
                 int LastIndex= P.getPVitals().size()-1;
               
                   System.out.println(P.getPVitals().get(LastIndex).getAge() + "    |"
                   + P.getPVitals().get(LastIndex).getRespiratoryRate()+ "    |"
                   + P.getPVitals().get(LastIndex).getHeartRate()+ "    |"
                           + P.getPVitals().get(LastIndex).getBloodPressure()+ "    |"
                           + P.getPVitals().get(LastIndex).getWeightInKgs()+ "    |"
                           + P.getPVitals().get(LastIndex).getWeightInPnds()+ "    |"
                   );
               
                 i=0;
                  break;      
            default:   break;
        }  
        DisplayMenu();
        Cases  = Sc.next();
           }
     //  System.out.println(P);
       // i=1;
        
      //  i=0;
          // System.out.println("3: to Exit. ");
      
    //  boolean  result =  P.IsPatientNormal(Vs);
    //  if (result ==true)
     //        { System.out.println(" Patient is Normal " + Vs.getGroupType());}
     // else if (result == false)
     // {System.out.println(" Patient is Abnormal " + Vs.getGroupType());}
      //  if()
        
        }
    }
    
    private static void DisplayMenu()
    {
        System.out.println("Please write one of the given values: ");
           System.out.println("1: for adding More VitalSigns ");
           System.out.println("2: For Testing purticuler vital is Normal or not ");
           System.out.println("3: For IsPatientNormal ");
           System.out.println("4: for VitalSign History ");
           System.out.println("5: for Current Vitals ");
    }
    
    
    
    private static VitalSigns setValues(VitalSigns Vs)
    {
        return  Vs = new VitalSigns();
    }
    private static void CallCustumTests2()
    {      P = new Patient();
       AddVitalSigns();
          // DisplayMenu();
          // Thread(3);
          String  Cases ="";
          while(true)
          {
              DisplayMenu();
               Cases  = Sc.next().trim();
                switch(Cases)
        { case "1":  AddVitalSigns();break;
            case "2": 
             System.out.println("Please write one of the given VitalSign needs to be checked:");
             System.out.println("RR: for RespiratoryRate ");
             System.out.println("HR: for HeartRate ");
             System.out.println("BP: for BloodPressure ");
             String Vital=Sc.next();
             System.out.println();
              boolean  result1 =  P.IsThisVitalNormal(Vital);
                   if (result1 ==true)
                    { System.out.println(" Normal ");}
                   else if (result1 == false)
                     {System.out.println(" Abnormal " );}
                  // DisplayMenu();
            // DisplayMenu();
                  //36  i=0;
            break;
            case "3":  
                  boolean  result =  P.IsPatientNormal(Vs);
                   if (result ==true)
                    { System.out.println(" Patient is Normal " + Vs.getGroupType());}
                   else if (result == false)
                     {System.out.println(" Patient is Abnormal " + Vs.getGroupType());}
                 //  DisplayMenu();
                 // i=0; 
                  break;
            case "4" :   
                System.out.println(" Age |" + " RR  |"+ " HP  |"+ " BP |" + " WKG  |"+ " WIP   |");
               for(int k=0; k<P.getPVitals().size(); k++)
               {
                   System.out.println(P.getPVitals().get(k).getAge() + "    |"
                   + P.getPVitals().get(k).getRespiratoryRate()+ "    |"
                   + P.getPVitals().get(k).getHeartRate()+ "    |"
                           + P.getPVitals().get(k).getBloodPressure()+ "    |"
                           + P.getPVitals().get(k).getWeightInKgs()+ "    |"
                           + P.getPVitals().get(k).getWeightInPnds()+ "    |"
                   );
               }
                //i=0;
                break;
            case "5":
                 System.out.println(" Age |" + " RR  |"+ " HP  |"+ " BP |" + " WKG  |"+ " WIP   |");
                 int LastIndex= P.getPVitals().size()-1;
               
                   System.out.println(P.getPVitals().get(LastIndex).getAge() + "    |"
                   + P.getPVitals().get(LastIndex).getRespiratoryRate()+ "    |"
                   + P.getPVitals().get(LastIndex).getHeartRate()+ "    |"
                           + P.getPVitals().get(LastIndex).getBloodPressure()+ "    |"
                           + P.getPVitals().get(LastIndex).getWeightInKgs()+ "    |"
                           + P.getPVitals().get(LastIndex).getWeightInPnds()+ "    |"
                   );
               
//                 i=0;
                  break;      
            default:   break;
        }  
          }
          
           
           
     //  System.out.println(P);
       // i=1;
        
      //  i=0;
          // System.out.println("3: to Exit. ");
      
    //  boolean  result =  P.IsPatientNormal(Vs);
    //  if (result ==true)
     //        { System.out.println(" Patient is Normal " + Vs.getGroupType());}
     // else if (result == false)
     // {System.out.println(" Patient is Abnormal " + Vs.getGroupType());}
      //  if()
        
        
    }
    
    private static void AddVitalSigns()
            {Vs = new VitalSigns();
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
      //  Varr= new ArrayList<VitalSigns>();
      //  Varr.add(Vs);
   P.addPVitals(Vs);
      System.out.println("Saved Successfully");
}
    
}
