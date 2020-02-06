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
public class Patient {
     
private String PatientName ;
private ArrayList<VitalSigns> PVitals = new ArrayList<VitalSigns>();
//private String PvitalId;

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String PatientName) {
        this.PatientName = PatientName;
    }



    public ArrayList<VitalSigns> getPVitals() {
        return PVitals;
    }

    public void setPVitals(ArrayList<VitalSigns> PVitals) {
        this.PVitals = PVitals;
    }
    public void addPVitals(VitalSigns PVitals) {
        this.PVitals.add(PVitals);
    }

    public Boolean IsThisVitalNormal(String VitalName)
    { VitalSignStandards VSL = new VitalSignStandards() ;
        Boolean result =false;
        VitalSigns vs = new VitalSigns();
        int v = this.PVitals.size();
       vs= this.PVitals.get(v-1);
       int age =vs.getAge();
       VSL= GetStandards(age,VSL);
      /* if(age==0)
            VSL = new VitalSignStandards("Newborn");
       else if(age>=1 && age<=12)
            VSL = new VitalSignStandards("Infant");
      else  if(age>=12 && age<=36)
            VSL = new VitalSignStandards("Toddler");
      else  if(age>=36 && age<=60)
            VSL = new VitalSignStandards("Preschooler");
      else  if(age>=60 && age<=144)
            VSL = new VitalSignStandards("School Age");
      else // if(age>=144 )
            VSL = new VitalSignStandards("Adolescent"); */
      
    VitalSigns  StandardValues =  VSL.vitalSignStandardList.get(0);
       switch(VitalName)
       {
           
           case "RR":
               int RR = vs.getRespiratoryRate();
                  if(RR >=StandardValues.getRespiratoryRateLower()&& RR<=StandardValues.getRespiratoryRateUpper())
                  { result =true;}
                  break;
           case "HR" :
               int HR = vs.getHeartRate();
                  if(HR >=StandardValues.getHeartRateLower()&& HR<=StandardValues.getHeartRateUpper())
                  { result =true;}
                   break;
           case "BP":
                   int BP = vs.getBloodPressure();
                  if(BP >=StandardValues.getBloodPressureLower()&& BP<=StandardValues.getBloodPressureUpper())
                  { result =true;}
                   break;
           default :  break;
       }
        
        return result;
        
    }
     public boolean IsPatientNormal(VitalSigns Vs)
    {
        VitalSignStandards VSL =  new VitalSignStandards();
         int age =Vs.getAge();
       VSL= GetStandards(age,VSL);
      /* if(age==0)
            VSL = new VitalSignStandards("Newborn");
       else if(age>=1 && age<=12)
            VSL = new VitalSignStandards("Infant");
      else  if(age>=12 && age<=36)
            VSL = new VitalSignStandards("Toddler");
      else  if(age>=36 && age<=60)
            VSL = new VitalSignStandards("Preschooler");
      else  if(age>=60 && age<=144)
            VSL = new VitalSignStandards("School Age");
      else // if(age>=144 )
            VSL = new VitalSignStandards("Adolescent"); */
      
    VitalSigns  StandardValues =  VSL.vitalSignStandardList.get(0);
        boolean Isnormal= false;
      VitalSigns  VSArr =  VSL.vitalSignStandardList.get(0);
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
     
     private VitalSignStandards GetStandards(int age, VitalSignStandards VSL)
     {
         
         if(age==0)
         return   VSL = new VitalSignStandards("Newborn");
       else if(age>=1 && age<=12)
         return   VSL = new VitalSignStandards("Infant");
      else  if(age>=12 && age<=36)
        return    VSL = new VitalSignStandards("Toddler");
      else  if(age>=36 && age<=60)
         return   VSL = new VitalSignStandards("Preschooler");
      else  if(age>=60 && age<=144)
         return   VSL = new VitalSignStandards("School Age");
      else // if(age>=144 )
        return    VSL = new VitalSignStandards("Adolescent");
     
     }

}
