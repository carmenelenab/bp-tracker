package src.main.java.tracker.data;

import java.time.LocalDate;
import src.main.java.tracker.details.Gender;

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
            this.name = name;
            return this;
        }

        public InfoBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public InfoBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public InfoBuilder setBirthDate(LocalDate birthDate) {
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
