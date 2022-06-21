package model;

import java.time.LocalDate;

public abstract class Person {
    private long prId;
    private String firstName;
    private String surname;
    private LocalDate dateOfBirth;

    public Person(String firstName, String surname, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(long prId, String firstName, String surname, LocalDate dateOfBirth) {
        this.prId = prId;
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth(){ return dateOfBirth;}
    public void setDateOfBirth(LocalDate dateOfBirth){ this.dateOfBirth = dateOfBirth;}

    public long getPrId() {
        return prId;
    }
}
