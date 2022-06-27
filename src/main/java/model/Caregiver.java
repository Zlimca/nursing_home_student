package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Caregiver extends Person{

        private long cid;
        private long prId;
        private LocalDate dateOfBirth;
        private long permission_id;

        private String phoneNumber;

        private List<Caregiver> allCaregivers = new ArrayList<Caregiver>();

    /**
     * constructs a patient from the given params.
     *
     * @param firstName
     * @param surname
     * @param dateOfBirth
     * @param permission_id
     * @param phoneNumber
     */
    public Caregiver(String firstName, String surname, LocalDate dateOfBirth, long permission_id, String phoneNumber) {
        super(firstName, surname, dateOfBirth);
        this.permission_id = permission_id;
        this.phoneNumber = phoneNumber;
    }

       /**
        * constructs a patient from the given params.
        * @param cid
        * @param prId
        * @param firstName
        * @param surname
        * @param dateOfBirth
        * @param permission_id
        * @param phoneNumber
        */
       public Caregiver(long cid, long prId, String firstName, String surname, LocalDate dateOfBirth, long permission_id, String phoneNumber) {
           super(prId, firstName, surname, dateOfBirth);
           this.cid = cid;
           this.permission_id = permission_id;
           this.phoneNumber = phoneNumber;
       }

    /**
     *
         * @return caregiver id
         */
        public long getCid() {
            return cid;
        }

        /**
        *
        * @return person id
        */
        public long getPrId() {
        return prId;
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
        * @return permission_id as string
        */
        public long getPermission_id(){ return permission_id;}

        /**
         * adds a caregiver to the treatment-list, if it does not already contain it.
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
            return "Caregiver" + "\nID: " + this.cid +
                    "\nFirstname: " + this.getFirstName() +
                    "\nSurname: " + this.getSurname() +
                    "\nBirthday: " + this.getDateOfBirth() +
                    "\nPermission_id: " + this.permission_id +
                    "\nPhoneNumber: " + this.phoneNumber +
                    "\n";
        }
    }

