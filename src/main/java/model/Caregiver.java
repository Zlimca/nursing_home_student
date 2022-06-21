package model;

import utils.DateConverter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Caregiver extends Person{

        private long cid;
        private int telephone;

        private List<Caregiver> allCaregivers = new ArrayList<Caregiver>();

        /**
         * constructs a patient from the given params.
         * @param firstName
         * @param surname
         */
        public Caregiver(String firstName, String surname, int telephone) {
            super(firstName, surname);
            this.telephone = telephone;
        }
        public Caregiver(long cid, String firstName, String surname, int telephone) {
            super(firstName, surname);
            this.cid = cid;
            this.telephone = telephone;
        }

        /**
         *
         * @return patient id
         */
        public long getCid() {
            return cid;
        }

        /**
         *
         * @return telephone as string
         */
        public int getTelephone() {
            return telephone;
        }

        /**
         * adds a treatment to the treatment-list, if it does not already contain it.
         * @param caregiver Caregiver
         * @return true if the treatment was not already part of the list. otherwise false
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
         * @return string-representation of the patient
         */
        public String toString() {
            return "Patient" + "\nMNID: " + this.cid +
                    "\nFirstname: " + this.getFirstName() +
                    "\nSurname: " + this.getSurname() +
                    "\nBirthday: " + this.telephone +
                    "\n";
        }
    }

