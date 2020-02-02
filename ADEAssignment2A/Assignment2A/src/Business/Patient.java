/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author sandhya  goswami 
 * //test test test
 */
public class Patient {
    
    VitalSignStandards VSL;
    VitalSigns VSArr;
    public boolean IsPatientNormal(VitalSigns Vs)
    {
        boolean Isnormal= false;
      
        switch(Vs.getGroupType())
        {
            case "Newborn":
                 {
                     VSL = new VitalSignStandards("Newborn");
                     VSArr = VSL.vitalSignStandardList.get(0);
                     if((   (Vs.getAge()==0)&&
                             Vs.getRespiratoryRate()>=VSArr.getRespiratoryRateLower()&& Vs.getRespiratoryRate()<=VSArr.getRespiratoryRateUpper())  
                         && (Vs.getHeartRate()>=VSArr.getHeartRateLower()&& Vs.getHeartRate()<=VSArr.getHeartRateUpper())
                             && (Vs.getBloodPressure()>=VSArr.getBloodPressureLower()&& Vs.getBloodPressure()<=VSArr.getBloodPressureUpper())
                              && (Vs.getWeightInKgs()>=VSArr.getWeightInKgsLower()&& Vs.getWeightInKgs()<=VSArr.getWeightInKgsUpper())
                             && (Vs.getWeightInPnds()>=VSArr.getWeightInPndsLower()&& Vs.getWeightInPnds()<=VSArr.getWeightInPndsUpper())
                             
                             )
                     {Isnormal = true;}
                 }
                 break;
            case "Infant":
                VSL = new VitalSignStandards("Infant");
                     VSArr = VSL.vitalSignStandardList.get(0);
                     if((Vs.getAge()>=VSArr.getAgeLower()&& Vs.getAge()<=VSArr.getAgeUpper()
                           &&  Vs.getRespiratoryRate()>=VSArr.getRespiratoryRateLower()&& Vs.getRespiratoryRate()<=VSArr.getRespiratoryRateUpper())  
                         && (Vs.getHeartRate()>=VSArr.getHeartRateLower()&& Vs.getHeartRate()<=VSArr.getHeartRateUpper())
                             && (Vs.getBloodPressure()>=VSArr.getBloodPressureLower()&& Vs.getBloodPressure()<=VSArr.getBloodPressureUpper())
                              && (Vs.getWeightInKgs()>=VSArr.getWeightInKgsLower()&& Vs.getWeightInKgs()<=VSArr.getWeightInKgsUpper())
                             && (Vs.getWeightInPnds()>=VSArr.getWeightInPndsLower()&& Vs.getWeightInPnds()<=VSArr.getWeightInPndsUpper())
                             
                             )
                {Isnormal = true;}
            break;
            case "Toddler":
                VSL = new VitalSignStandards("Toddler");
                     VSArr = VSL.vitalSignStandardList.get(0);
                     if((Vs.getAge()>=VSArr.getAgeLower()&& Vs.getAge()<=VSArr.getAgeUpper()
                           &&  Vs.getRespiratoryRate()>=VSArr.getRespiratoryRateLower()&& Vs.getRespiratoryRate()<=VSArr.getRespiratoryRateUpper())  
                         && (Vs.getHeartRate()>=VSArr.getHeartRateLower()&& Vs.getHeartRate()<=VSArr.getHeartRateUpper())
                             && (Vs.getBloodPressure()>=VSArr.getBloodPressureLower()&& Vs.getBloodPressure()<=VSArr.getBloodPressureUpper())
                              && (Vs.getWeightInKgs()>=VSArr.getWeightInKgsLower()&& Vs.getWeightInKgs()<=VSArr.getWeightInKgsUpper())
                             && (Vs.getWeightInPnds()>=VSArr.getWeightInPndsLower()&& Vs.getWeightInPnds()<=VSArr.getWeightInPndsUpper())
                             
                             )
               {Isnormal = true;}
            break;
            case "Preschooler":
               VSL = new VitalSignStandards("Preschooler");
                     VSArr = VSL.vitalSignStandardList.get(0);
                     if((Vs.getAge()>=VSArr.getAgeLower()&& Vs.getAge()<=VSArr.getAgeUpper()
                             && Vs.getRespiratoryRate()>=VSArr.getRespiratoryRateLower()&& Vs.getRespiratoryRate()<=VSArr.getRespiratoryRateUpper())  
                         && (Vs.getHeartRate()>=VSArr.getHeartRateLower()&& Vs.getHeartRate()<=VSArr.getHeartRateUpper())
                             && (Vs.getBloodPressure()>=VSArr.getBloodPressureLower()&& Vs.getBloodPressure()<=VSArr.getBloodPressureUpper())
                              && (Vs.getWeightInKgs()>=VSArr.getWeightInKgsLower()&& Vs.getWeightInKgs()<=VSArr.getWeightInKgsUpper())
                             && (Vs.getWeightInPnds()>=VSArr.getWeightInPndsLower()&& Vs.getWeightInPnds()<=VSArr.getWeightInPndsUpper())
                             
                             )
                {Isnormal = true;}
            break;
            case "School Age":
               VSL = new VitalSignStandards("School Age");
                     VSArr = VSL.vitalSignStandardList.get(0);
                     if(( Vs.getAge()>=VSArr.getAgeLower()&& Vs.getAge()<=VSArr.getAgeUpper()
                             && Vs.getRespiratoryRate()>=VSArr.getRespiratoryRateLower()&& Vs.getRespiratoryRate()<=VSArr.getRespiratoryRateUpper())  
                         && (Vs.getHeartRate()>=VSArr.getHeartRateLower()&& Vs.getHeartRate()<=VSArr.getHeartRateUpper())
                             && (Vs.getBloodPressure()>=VSArr.getBloodPressureLower()&& Vs.getBloodPressure()<=VSArr.getBloodPressureUpper())
                              && (Vs.getWeightInKgs()>=VSArr.getWeightInKgsLower()&& Vs.getWeightInKgs()<=VSArr.getWeightInKgsUpper())
                             && (Vs.getWeightInPnds()>=VSArr.getWeightInPndsLower()&& Vs.getWeightInPnds()<=VSArr.getWeightInPndsUpper())
                             
                             )
               {Isnormal = true;}
            break;
             case "Adolescent":
               VSL = new VitalSignStandards("Adolescent");
                     VSArr = VSL.vitalSignStandardList.get(0);
                     if((Vs.getAge()>=VSArr.getAgeLower()&&Vs.getAge()<=VSArr.getAgeUpper()
                            && Vs.getRespiratoryRate()>=VSArr.getRespiratoryRateLower()&&Vs.getRespiratoryRate()<=VSArr.getRespiratoryRateUpper())  
                         && (Vs.getHeartRate()>=VSArr.getHeartRateLower()&& Vs.getHeartRate()<=VSArr.getHeartRateUpper())
                             && (Vs.getBloodPressure()>=VSArr.getBloodPressureLower()&& Vs.getBloodPressure()<=VSArr.getBloodPressureUpper())
                              && (Vs.getWeightInKgs()>=VSArr.getWeightInKgsLower())
                             && (Vs.getWeightInPnds()>=VSArr.getWeightInPndsLower())
                             
                             )
                {Isnormal = true;}
            break;

        }
        return Isnormal ;
    }
}
