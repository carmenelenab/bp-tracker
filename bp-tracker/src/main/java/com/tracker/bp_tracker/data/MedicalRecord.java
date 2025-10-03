package com.tracker.bp_tracker.data;

import java.time.LocalDateTime;

public class MedicalRecord {
    private final int id;
    private final int systolicValue;
    private final int diastolicValue;
    private final int pulseValue;
    private final LocalDateTime dateTime;


    // public MedicalRecord(int recordId, int systolicValue, int diastolicValue, int pulseValue) {
    //     this.recordId = recordId;
    //     this.systolicValue = systolicValue;
    //     this.diastolicValue = diastolicValue;
    //     this.pulseValue = pulseValue;
    //     this.dateTime = LocalDateTime.now();
    // }

    private MedicalRecord(RecordBuilder builder) {
        this.id = builder.id;
        this.systolicValue = builder.systolicValue;
        this.diastolicValue = builder.diastolicValue;
        this.pulseValue = builder.pulseValue;
        this.dateTime = LocalDateTime.now();
    }

    public int getRecordId() {
        return id;
    }

    public int getSystolicValue() {
        return systolicValue;
    }

    public int getDiastolicValue() {
        return diastolicValue;
    }

    public int getPulseValue() {
        return pulseValue;
    }

    public static class RecordBuilder {
        private int id;
        private int systolicValue;
        private int diastolicValue;
        private int pulseValue;

        public RecordBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public RecordBuilder setSystolicValue(int systolicValue) {
            this.systolicValue = systolicValue;
            return this;
        }

        public RecordBuilder setDiastolicValue(int diastolicValue) {
            this.diastolicValue = diastolicValue;
            return this;
        }

        public RecordBuilder setPulseValue(int pulseValue) {
            this.pulseValue = pulseValue;
            return this;
        }

        public MedicalRecord build() {
            // Added validation to ensure that the values being set are non-negative
            if (systolicValue <= 0 || diastolicValue <= 0 || pulseValue <= 0) {
                throw new IllegalArgumentException("The value has to be greater than 0");
            }
            
            return new MedicalRecord(this);
        }
    }
}

