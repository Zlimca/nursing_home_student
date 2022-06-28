package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Caregiver extends Person {

    private long cId;
    private long permissionId;
    private long credentialsId;

    private String phoneNumber;

    private List<Caregiver> allCaregivers = new ArrayList<Caregiver>();

    /**
     * constructs a patient from the given params.
     *
     * @param firstname
     * @param surname
     * @param dateOfBirth
     * @param permissionId
     * @param phoneNumber
     */
    public Caregiver(String firstname, String surname, LocalDate dateOfBirth, long permissionId, String phoneNumber) {
        super(firstname, surname, dateOfBirth);
        this.permissionId = permissionId;
        this.phoneNumber = phoneNumber;
    }

    /**
     * constructs a patient from the given params.
     *
     * @param cId
     * @param prId
     * @param firstname
     * @param surname
     * @param dateOfBirth
     * @param permissionId
     * @param phoneNumber
     */
    public Caregiver(long cId, long prId, String firstname, String surname, LocalDate dateOfBirth,
                     long permissionId, String phoneNumber, long credentialsId) {
        super(prId, firstname, surname, dateOfBirth);
        this.cId = cId;
        this.permissionId = permissionId;
        this.credentialsId = credentialsId;
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return caregiver id
     */
    public long getcId() {
        return cId;
    }

    /**
         *
         * @return telephone as string
         */
        public String getPhoneNumber() {
            return phoneNumber;
        }

    /**
     *
     * @return permissionId as string
     */
    public long getPermissionId() {
        return permissionId;
    }

    /**
         * adds a caregiver to the caregiver-list, if it does not already contain it.
         * @param caregiver Caregiver
         * @return true if the caregiver was not already part of the list. otherwise false
         */
        public boolean add(Caregiver caregiver) {
            if (!this.allCaregivers.contains(caregiver)) {
                this.allCaregivers.add(caregiver);
                return true;
            }
            return false;
        }

        /**
         *
         * @return string-representation of the caregiver
         */
        public String toString() {
            return "Caregiver" + "\nID: " + this.cId +
                    "\nFirstname: " + this.getFirstname() +
                    "\nSurname: " + this.getSurname() +
                    "\nBirthday: " + this.getDateOfBirth() +
                    "\nPermission_id: " + this.permissionId +
                    "\nPhoneNumber: " + this.phoneNumber +
                    "\n";
        }
    }

