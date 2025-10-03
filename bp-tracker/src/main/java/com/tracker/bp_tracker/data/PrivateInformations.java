package com.tracker.bp_tracker.data;

import java.time.LocalDate;

import com.tracker.bp_tracker.details.Gender;

public class PrivateInformations {

    private final int id;
    private final String name;
    private final String surname;
    private final Gender gender;
    private final LocalDate birthDate;

    private PrivateInformations(InfoBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.gender = builder.gender;
        this.birthDate = builder.birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public static class InfoBuilder {

        private int id;
        private String name;
        private String surname;
        private Gender gender;
        private LocalDate birthDate;

        public InfoBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public InfoBuilder setName(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("The name cannot be null or blank!");
            }
            this.name = name;
            return this;
        }

        public InfoBuilder setSurname(String surname) {
            if (surname == null || surname.isBlank()) {
                throw new IllegalArgumentException("The surname cannot be null or blank!");
            }
            this.surname = surname;
            return this;
        }

        public InfoBuilder setGender(Gender gender) {
            if (gender == null) {
                throw new IllegalArgumentException("The gender cannot be null!");
            }
            this.gender = gender;
            return this;
        }

        public InfoBuilder setBirthDate(LocalDate birthDate) {
            if (birthDate == null) {
                throw new IllegalArgumentException("The birth date cannot be null!");
            }
            if (birthDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("The birth date cannot be in the future!");
            }
            this.birthDate = birthDate;
            return this;
        }

        public PrivateInformations build() {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            if (surname == null || surname.isEmpty()) {
                throw new IllegalArgumentException("Surname cannot be null or empty");
            }
            if (birthDate == null || birthDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Invalid birth date");
            }
            return new PrivateInformations(this);
        }
    }
}
