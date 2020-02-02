/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author ranranhe
 */
public class VitalSigns {

    private double temperature;
    private double bloodPressure;
    private int pulse;
    private String date;
    private double maxBP;
    private double minBP;

    public double getMaxBP() {
        return maxBP;
    }

    public void setMaxBP(double maxBP) {
        this.maxBP = maxBP;
    }

    public double getMinBP() {
        return minBP;
    }

    public void setMinBP(double minBP) {
        this.minBP = minBP;
    }
    
    private String groupType;
    private int ageLower ;
    private int ageUpper;
    private  int respiratoryRateLower;
    private  int respiratoryRateUpper;
    private  int heartRateLower;
    private  int heartRateUpper;
    private int bloodPressureUpper;
    private int bloodPressureLower;
    private  int weightInKgsLower;
    private  int weightInKgsUpper;
    private  float weightInPndsLower;
    private  int weightInPndsUpper;

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public int getAgeLower() {
        return ageLower;
    }

    public void setAgeLower(int ageLower) {
        this.ageLower = ageLower;
    }

    public int getAgeUpper() {
        return ageUpper;
    }

    public void setAgeUpper(int ageUpper) {
        this.ageUpper = ageUpper;
    }

    public int getRespiratoryRateLower() {
        return respiratoryRateLower;
    }

    public void setRespiratoryRateLower(int respiratoryRateLower) {
        this.respiratoryRateLower = respiratoryRateLower;
    }

    public int getRespiratoryRateUpper() {
        return respiratoryRateUpper;
    }

    public void setRespiratoryRateUpper(int respiratoryRateUpper) {
        this.respiratoryRateUpper = respiratoryRateUpper;
    }

    public int getHeartRateLower() {
        return heartRateLower;
    }

    public void setHeartRateLower(int heartRateLower) {
        this.heartRateLower = heartRateLower;
    }

    public int getHeartRateUpper() {
        return heartRateUpper;
    }

    public void setHeartRateUpper(int heartRateUpper) {
        this.heartRateUpper = heartRateUpper;
    }

    public int getBloodPressureUpper() {
        return bloodPressureUpper;
    }

    public void setBloodPressureUpper(int bloodPressureUpper) {
        this.bloodPressureUpper = bloodPressureUpper;
    }

    public int getBloodPressureLower() {
        return bloodPressureLower;
    }

    public void setBloodPressureLower(int bloodPressureLower) {
        this.bloodPressureLower = bloodPressureLower;
    }

    public int getWeightInKgsLower() {
        return weightInKgsLower;
    }

    public void setWeightInKgsLower(int weightInKgsLower) {
        this.weightInKgsLower = weightInKgsLower;
    }

    public int getWeightInKgsUpper() {
        return weightInKgsUpper;
    }

    public void setWeightInKgsUpper(int weightInKgsUpper) {
        this.weightInKgsUpper = weightInKgsUpper;
    }

    public float getWeightInPndsLower() {
        return weightInPndsLower;
    }

    public void setWeightInPndsLower(float weightInPndsLower) {
        this.weightInPndsLower = weightInPndsLower;
    }

    public int getWeightInPndsUpper() {
        return weightInPndsUpper;
    }

    public void setWeightInPndsUpper(int weightInPndsUpper) {
        this.weightInPndsUpper = weightInPndsUpper;
    }
    
    

    public VitalSigns(double temperature, double bloodPressure, int pulse, String date) {
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
        this.pulse = pulse;
        this.date = date;
    }

    public VitalSigns() {
    }

    public double getTemperature() {
        return this.temperature;
    }

    public double getBloodPressure() {
        return this.bloodPressure;
    }

    public int getPulse() {
        return this.pulse;
    }

    public String getDate() {
        return this.date;
    }

    public void setTemperature(double temp) {
        this.temperature = temp;
    }

    public void setBloodPressure(double blood) {
        this.bloodPressure = blood;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.date;
    }

}
