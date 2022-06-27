package model;

import java.time.LocalDate;

public abstract class Person {
    private long prId;
    private String firstname;
    private String surname;
    private LocalDate dateOfBirth;

    public Person(String firstname, String surname, LocalDate dateOfBirth) {
        this.firstname = firstname;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(long prId, String firstname, String surname, LocalDate dateOfBirth) {
        this.prId = prId;
        this.firstname = firstname;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
