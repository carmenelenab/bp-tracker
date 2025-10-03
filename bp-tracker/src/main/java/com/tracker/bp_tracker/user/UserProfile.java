package com.tracker.bp_tracker.user;

public class UserProfile {
    private int id;
    private String privateData;
    private String medicalRecord;

    public UserProfile(int id, String privateData, String medicalRecord) {
        this.id = id;
        this.privateData = privateData;
        this.medicalRecord = medicalRecord;
    }

    public int getId() {
        return id;
    }

    public String getPrivateData() {
        return privateData;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String newReport) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMedicalRecord'");
    }

}
