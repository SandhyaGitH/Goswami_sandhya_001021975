/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author samarth
 */
public class TestCases {
   public VitalSigns vitalSigns;
    public TestCases(String GroupType, String patientCondition)
    {
       BuildTestCases( GroupType, patientCondition);
    }
    
    private void BuildTestCases(String GroupType, String patientCondition)
    {
       vitalSigns= new VitalSigns();
       if(patientCondition=="Normal")
       {
       if(GroupType=="Newborn")
       {
           vitalSigns.setGroupType("Newborn");
      vitalSigns.setAge(0); // In months
      vitalSigns.setRespiratoryRate(40);
      vitalSigns.setHeartRate(130);
      vitalSigns.setBloodPressure(60);
      vitalSigns.setWeightInKgs(3);
      vitalSigns.setWeightInPnds(5);
       }
       if(GroupType=="Infant")
       {
           vitalSigns.setGroupType("Infant");
      vitalSigns.setAge(3); // In Months
      vitalSigns.setRespiratoryRate(25);
      vitalSigns.setHeartRate(90);
      vitalSigns.setBloodPressure(80);
      vitalSigns.setWeightInKgs(6);
      vitalSigns.setWeightInPnds(11);
       }
       if(GroupType=="Toddler")
       {
           vitalSigns.setGroupType("Toddler");
      vitalSigns.setAge(14); // In months 
      vitalSigns.setRespiratoryRate(25);
      vitalSigns.setHeartRate(80);
      vitalSigns.setBloodPressure(110);
      vitalSigns.setWeightInKgs(10);
      vitalSigns.setWeightInPnds(31);
       }
       if(GroupType=="Preschooler")
       {
           vitalSigns.setGroupType("Preschooler");
      vitalSigns.setAge(48);// In months 
      vitalSigns.setRespiratoryRate(30);
      vitalSigns.setHeartRate(120);
      vitalSigns.setBloodPressure(110);
      vitalSigns.setWeightInKgs(18);
      vitalSigns.setWeightInPnds(40);
       }
        if(GroupType=="School Age")
       {
           vitalSigns.setGroupType("School Age");
      vitalSigns.setAge(144);// In months 
      vitalSigns.setRespiratoryRate(20);
      vitalSigns.setHeartRate(70);
      vitalSigns.setBloodPressure(80);
      vitalSigns.setWeightInKgs(20);
      vitalSigns.setWeightInPnds(41);
       }
         if(GroupType=="Adolescent" )
       {
           vitalSigns.setGroupType("Adolescent");
      vitalSigns.setAge(168);// In months 
      vitalSigns.setRespiratoryRate(20);
      vitalSigns.setHeartRate(105);
      vitalSigns.setBloodPressure(120);
      vitalSigns.setWeightInKgs(51);
      vitalSigns.setWeightInPnds(111);
       }
       }
       else if(patientCondition=="Abnormal")
       {
            if(GroupType=="Newborn")
       {
           vitalSigns.setGroupType("Newborn");
      vitalSigns.setAge(0); // In months
      vitalSigns.setRespiratoryRate(400);
      vitalSigns.setHeartRate(130);
      vitalSigns.setBloodPressure(60);
      vitalSigns.setWeightInKgs(3);
      vitalSigns.setWeightInPnds(5);
       }
       if(GroupType=="Infant")
       {
           vitalSigns.setGroupType("Infant");
      vitalSigns.setAge(3); // In Months
      vitalSigns.setRespiratoryRate(205);
      vitalSigns.setHeartRate(90);
      vitalSigns.setBloodPressure(80);
      vitalSigns.setWeightInKgs(6);
      vitalSigns.setWeightInPnds(11);
       }
       if(GroupType=="Toddler")
       {
           vitalSigns.setGroupType("Toddler");
      vitalSigns.setAge(14); // In months 
      vitalSigns.setRespiratoryRate(25);
      vitalSigns.setHeartRate(800);
      vitalSigns.setBloodPressure(190);
      vitalSigns.setWeightInKgs(100);
      vitalSigns.setWeightInPnds(31);
       }
       if(GroupType=="Preschooler")
       {
           vitalSigns.setGroupType("Preschooler");
      vitalSigns.setAge(48);// In months 
      vitalSigns.setRespiratoryRate(30);
      vitalSigns.setHeartRate(120);
      vitalSigns.setBloodPressure(210);
      vitalSigns.setWeightInKgs(18);
      vitalSigns.setWeightInPnds(40);
       }
        if(GroupType=="School Age")
       {
           vitalSigns.setGroupType("School Age");
      vitalSigns.setAge(144);// In months 
      vitalSigns.setRespiratoryRate(10);
      vitalSigns.setHeartRate(70);
      vitalSigns.setBloodPressure(80);
      vitalSigns.setWeightInKgs(20);
      vitalSigns.setWeightInPnds(41);
       }
         if(GroupType=="Adolescent" )
       {
           vitalSigns.setGroupType("Adolescent");
      vitalSigns.setAge(168);// In months 
      vitalSigns.setRespiratoryRate(20);
      vitalSigns.setHeartRate(195);
      vitalSigns.setBloodPressure(120);
      vitalSigns.setWeightInKgs(51);
      vitalSigns.setWeightInPnds(111);
       }
       }
        //return vitalSigns;
    }
}
