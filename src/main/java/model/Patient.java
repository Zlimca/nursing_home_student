package model;

import utils.DateConverter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Patients live in a NURSING home and are treated by nurses.
 */
public class Patient extends Person {
    private long pid;
    private long prId;
    private LocalDate dateOfBirth;
    private String careLevel;
    private String roomNumber;
    private List<Treatment> allTreatments = new ArrayList<Treatment>();

    /**
     * constructs a patient from the given params.
     * @param firstName
     * @param surname
     * @param dateOfBirth
     * @param careLevel
     * @param roomNumber
     */
    public Patient(String firstName, String surname, LocalDate dateOfBirth, String careLevel, String roomNumber) {
        super(firstName, surname, dateOfBirth);
        this.careLevel = careLevel;
        this.roomNumber = roomNumber;
    }

    /**
     * constructs a patient from the given params.
     * @param pid
     * @param firstName
     * @param surname
     * @param dateOfBirth
     * @param careLevel
     * @param roomNumber
     */
    public Patient(long pid, long prId, String firstName, String surname, LocalDate dateOfBirth, String careLevel, String roomNumber) {
        super(prId, firstName, surname, dateOfBirth);
        this.pid = pid;
        //this.prId = prId;
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
     * @return date of birth as a string
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * convert given param to a localDate and store as new <code>birthOfDate</code>
     * @param dateOfBirth as string in the following format: YYYY-MM-DD
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = DateConverter.convertStringToLocalDate(dateOfBirth);
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
     *
     * @param roomNumber
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * adds a treatment to the treatment-list, if it does not already contain it.
     * @param m Treatment
     * @return true if the treatment was not already part of the list. otherwise false
     */
    public boolean add(Treatment m) {
        if (!this.allTreatments.contains(m)) {
            this.allTreatments.add(m);
            return true;
        }
        return false;
    }

    /**
     *
     * @return string-representation of the patient
     */
    public String toString() {
        return "Patient" + "\nID: " + this.pid +
                "\nFirstname: " + this.getFirstName() +
                "\nSurname: " + this.getSurname() +
                "\nBirthday: " + this.dateOfBirth +
                "\nCarelevel: " + this.careLevel +
                "\nRoomnumber: " + this.roomNumber +
                "\n";
    }
}