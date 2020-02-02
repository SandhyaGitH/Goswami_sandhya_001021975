/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author samarth
 */
public class VitalSignStandards {
    public ArrayList<VitalSigns> vitalSignStandardList =    new ArrayList<VitalSigns>();
    public VitalSignStandards(String groupType){
    
         VitalSigns VS = new VitalSigns();
           // VS.temperature=0.0D;
           if (groupType=="Newborn")
           {
           VS.setGroupType("Newborn");
           VS.setAgeLower(0);
           VS.setAgeUpper(0);
           VS.setRespiratoryRateLower(30);
           VS.setRespiratoryRateUpper(50);
           VS.setHeartRateLower(120);
           VS.setHeartRateUpper(160);
           VS.setBloodPressureLower(50);
           VS.setBloodPressureUpper(70);
           VS.setWeightInKgsLower(2);
           VS.setWeightInKgsUpper(3);
           VS.setWeightInPndsLower(4.5f);
           VS.setWeightInPndsUpper(7);
           vitalSignStandardList.add(VS);
           }
           else if (groupType=="Infant")
           {
           VS.setGroupType("Infant");
           VS.setAgeLower(1);
           VS.setAgeUpper(12);
           VS.setRespiratoryRateLower(20);
           VS.setRespiratoryRateUpper(30);
           VS.setHeartRateLower(80);
           VS.setHeartRateUpper(140);
           VS.setBloodPressureLower(70);
           VS.setBloodPressureUpper(100);
           VS.setWeightInKgsLower(4);
           VS.setWeightInKgsUpper(10);
           VS.setWeightInPndsLower(9);
           VS.setWeightInPndsUpper(22);
           vitalSignStandardList.add(VS);
           }
           else if (groupType=="Toddler")
           {
           VS.setGroupType("Toddler");
           VS.setAgeLower(12);
           VS.setAgeUpper(36);
           VS.setRespiratoryRateLower(20);
           VS.setRespiratoryRateUpper(30);
           VS.setHeartRateLower(80);
           VS.setHeartRateUpper(130);
           VS.setBloodPressureLower(80);
           VS.setBloodPressureUpper(110);
           VS.setWeightInKgsLower(10);
           VS.setWeightInKgsUpper(14);
           VS.setWeightInPndsLower(22);
           VS.setWeightInPndsUpper(31);
           vitalSignStandardList.add(VS);
           
           }
           else if (groupType=="Preschooler")
           {
           VS.setGroupType("Preschooler");
           VS.setAgeLower(36);
           VS.setAgeUpper(60);
           VS.setRespiratoryRateLower(20);
           VS.setRespiratoryRateUpper(30);
           VS.setHeartRateLower(80);
           VS.setHeartRateUpper(120);
           VS.setBloodPressureLower(80);
           VS.setBloodPressureUpper(110);
           VS.setWeightInKgsLower(14);
           VS.setWeightInKgsUpper(18);
           VS.setWeightInPndsLower(31);
           VS.setWeightInPndsUpper(40);
           vitalSignStandardList.add(VS);
            }
           else if (groupType=="School Age")
           {
           VS.setGroupType("School Age");
           VS.setAgeLower(60);
           VS.setAgeUpper(144);
           VS.setRespiratoryRateLower(20);
           VS.setRespiratoryRateUpper(30);
           VS.setHeartRateLower(70);
           VS.setHeartRateUpper(110);
           VS.setBloodPressureLower(80);
           VS.setBloodPressureUpper(120);
           VS.setWeightInKgsLower(20);
           VS.setWeightInKgsUpper(42);
           VS.setWeightInPndsLower(41);
           VS.setWeightInPndsUpper(92);
           vitalSignStandardList.add(VS);
            }
           else if (groupType=="Adolescent")
           {
           VS.setGroupType("Adolescent");
           VS.setAgeLower(144);
           VS.setAgeUpper(1000);
           VS.setRespiratoryRateLower(12);
           VS.setRespiratoryRateUpper(20);
           VS.setHeartRateLower(55);
           VS.setHeartRateUpper(105);
           VS.setBloodPressureLower(110);
           VS.setBloodPressureUpper(120);
           VS.setWeightInKgsLower(50);
         //  VS.setWeightInKgsUpper(42);
           VS.setWeightInPndsLower(110);
          // VS.setWeightInPndsUpper(92);
           vitalSignStandardList.add(VS);
           }
}
    
}
