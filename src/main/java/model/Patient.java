package model;

import java.time.LocalDate;

/**
 * Patients live in a NURSING home and are treated by nurses.
 */
public class Patient extends Person {
    private long pid;
    private String careLevel;
    private String roomNumber;

    /**
     * constructs a patient from the given params.
     *
     * @param firstName   Firstname
     * @param surname     Surname
     * @param dateOfBirth Birthday
     * @param careLevel   Care level
     * @param roomNumber  Room Number
     */
    public Patient(String firstName, String surname, LocalDate dateOfBirth, String careLevel, String roomNumber) {
        super(firstName, surname, dateOfBirth);
        this.careLevel = careLevel;
        this.roomNumber = roomNumber;
    }

    /**
     * constructs a patient from the given params.
     *
     * @param pid         Patient ID
     * @param prId        Person ID
     * @param firstname   Firstname
     * @param surname     Surname
     * @param dateOfBirth Birthday
     * @param careLevel   Care Level
     * @param roomNumber  Room Number
     */
    public Patient(long pid, long prId, String firstname, String surname, LocalDate dateOfBirth, String careLevel, String roomNumber) {
        super(prId, firstname, surname, dateOfBirth);
        this.pid = pid;
        this.careLevel = careLevel;
        this.roomNumber = roomNumber;
    }

    /**
     *
     * @return patient id
     */
    public long getPid() {
        return pid;
    }

    /**
     *
     * @return careLevel
     */
    public String getCareLevel() {
        return careLevel;
    }

    /**
     *
     * @param careLevel new care level
     */
    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }

    /**
     *
     * @return roomNumber as string
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber Room Number
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     *
     * @return string-representation of the patient
     */
    public String toString() {
        return "Patient" +
                "\nID: " + this.pid +
                "\nFirstname: " + this.getFirstname() +
                "\nSurname: " + this.getSurname() +
                "\nBirthday: " + this.getDateOfBirth() +
                "\nCarelevel: " + this.careLevel +
                "\nRoomnumber: " + this.roomNumber +
                "\n";
    }
}