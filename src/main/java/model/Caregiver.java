package model;

import java.time.LocalDate;

public class Caregiver extends Person {

    private long cId;
    private final long permissionId;

    private final String phoneNumber;

    /**
     * constructs a patient from the given params.
     *
     * @param firstname    Firstname
     * @param surname      Surname
     * @param dateOfBirth  Birthday
     * @param permissionId Permission ID
     * @param phoneNumber  Phone Number
     */
    public Caregiver(String firstname, String surname, LocalDate dateOfBirth, long permissionId, String phoneNumber) {
        super(firstname, surname, dateOfBirth);
        this.permissionId = permissionId;
        this.phoneNumber = phoneNumber;
    }

    /**
     * constructs a patient from the given params.
     *
     * @param cId          Caregiver ID
     * @param prId         Person ID
     * @param firstname    Firstname
     * @param surname      Surname
     * @param dateOfBirth  Birthday
     * @param permissionId Permission ID
     * @param phoneNumber  Phone Number
     */
    public Caregiver(long cId, long prId, String firstname, String surname, LocalDate dateOfBirth,
                     long permissionId, String phoneNumber) {
        super(prId, firstname, surname, dateOfBirth);
        this.cId = cId;
        this.permissionId = permissionId;
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return caregiver id
     */
    public long getCId() {
        return cId;
    }

    /**
     * @return telephone as string
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return permissionId as string
     */
    public long getPermissionId() {
        return permissionId;
    }

    /**
     * @return string-representation of the caregiver
     */
    public String toString() {
        return "Caregiver" +
                "\nID: " + this.cId +
                "\nFirstname: " + this.getFirstname() +
                "\nSurname: " + this.getSurname() +
                "\nBirthday: " + this.getDateOfBirth() +
                "\nPermission_id: " + this.permissionId +
                "\nPhoneNumber: " + this.phoneNumber +
                "\n";
    }
}

