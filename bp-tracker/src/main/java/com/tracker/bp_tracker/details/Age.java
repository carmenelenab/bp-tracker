package com.tracker.bp_tracker.details;

public enum Age {
    CHILD,
    TEENAGER,
    ADULT,
    SENIOR;

    public static Age fromInt(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        
        if (age < 13) {
            return CHILD;
        } else if (age < 20) {
            return TEENAGER;
        } else if (age < 65) {
            return ADULT;
        } else {
            return SENIOR;
        }
    }

}
