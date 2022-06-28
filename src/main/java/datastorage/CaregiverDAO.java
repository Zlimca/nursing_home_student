package datastorage;

import model.Caregiver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

//language=SQL

/**
 * Implements the Interface <code>DAOImp</code>. Overrides methods to generate specific patient-SQL-queries.
 */
public class CaregiverDAO extends DAOimp<Caregiver> {

    /**
     * constructs Onbject. Calls the Constructor from <code>DAOImp</code> to store the connection.
     *
     * @param conn Connection
     */
    public CaregiverDAO(Connection conn) {
        super(conn);
    }

    /**
     * generates a <code>INSERT INTO</code>-Statement for a given patient
     *
     * @param caregiver for which a specific INSERT INTO is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getCreateStatementString(Caregiver caregiver) {
        String query1 = String.format("INSERT INTO person(firstname, surname, dateOfBirth) " +
                        "VALUES('%s', '%s', '%s');",
                caregiver.getFirstname(), caregiver.getSurname(), caregiver.getDateOfBirth());
        String query2 = "INSERT INTO caregiver(prid, credentials_id, permission_id, phonenumber) " +
                "SELECT PRID, 1, 1, null " +
                "FROM person;";
        String query3 = String.format("UPDATE caregiver " +
                "SET " +
                "credentials_id = %d, permission_id = %d, phonenumber = '%s' " +
                "WHERE cid = (SELECT * " +
                "FROM (SELECT MAX(cid) " +
                "FROM caregiver))",
                caregiver.getCredentialsId(), caregiver.getPermissionId(), caregiver.getPhoneNumber());
        return query1 + '\n' + query2 + '\n' + query3;
    }

    /**
     * generates a <code>select</code>-Statement for a given key
     *
     * @param key for which a specific SELECTis to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT caregiver.*, person.FIRSTNAME, person.SURNAME, person.DATEOFBIRTH " +
                "FROM caregiver " +
                "INNER JOIN person ON caregiver.prid = person.prid " +
                "WHERE cid = %d", key);
    }

    /**
     * maps a <code>ResultSet</code> to a <code>Caregiver</code>
     *
     * @param result ResultSet with a single row. Columns will be mapped to a caregiver-object.
     * @return caregiver with the data from the resultSet.
     */
    @Override
    protected Caregiver getInstanceFromResultSet(ResultSet result) throws SQLException {
        long cid = result.getInt(1);
        long prid = result.getInt(2);
        String firstname = result.getString(6);
        String surname = result.getString(7);
        LocalDate dateOfBirth = result.getDate(8).toLocalDate();
        long permissionId = result.getInt(3);
        String phonenumber = result.getString(5);
        long credentialsId = result.getInt(4);
        Caregiver c;
        c = new Caregiver(cid, prid, firstname,surname,dateOfBirth,permissionId,phonenumber,credentialsId);
        return c;
    }

    /**
     * generates a <code>SELECT</code>-Statement for all caregivers.
     *
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getReadAllStatementString() {
        return "SELECT caregiver.*, person.FIRSTNAME, person.SURNAME, person.DATEOFBIRTH " +
                "FROM caregiver " +
                "INNER JOIN person ON caregiver.prid = person.prid";
    }

    /**
     * maps a <code>ResultSet</code> to a <code>Caregiver-List</code>
     *
     * @param result ResultSet with a multiple rows. Data will be mapped to caregiver-object.
     * @return ArrayList with caregivers from the resultSet.
     */
    @Override
    protected ArrayList<Caregiver> getListFromResultSet(ResultSet result) throws SQLException {
        ArrayList<Caregiver> list = new ArrayList<>();
        Caregiver c;
        while (result.next()) {
            long cid = result.getInt(1);
            long prid = result.getInt(2);
            String firstname = result.getString(6);
            String surname = result.getString(7);
            LocalDate dateOfBirth = result.getDate(8).toLocalDate();
            long permissionId = result.getInt(3);
            String phonenumber = result.getString(5);
            long credentialsId = result.getInt(4);
             c = new Caregiver(cid, prid, firstname,surname,dateOfBirth,permissionId,phonenumber,credentialsId);
            list.add(c);
        }
        return list;
    }

    /**
     * generates a <code>UPDATE</code>-Statement for a given patient
     *
     * @param caregiver for which a specific update is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getUpdateStatementString(Caregiver caregiver) {
        String query1 = String.format("UPDATE person SET firstname = '%s', surname = '%s', dateOfBirth = '%s' WHERE" +
                        "PRID = %d",
                caregiver.getFirstname(), caregiver.getSurname(), caregiver.getDateOfBirth(), caregiver.getPrId());
        String query2 = String.format("UPDATE caregiver SET permission_id = '%s', phonenumber = '%s'WHERE cid = %d",
                caregiver.getPermissionId(), caregiver.getPhoneNumber(), caregiver.getCId());
        return query1 + '\n' + query2;

    }

    /**
     * generates a <code>delete</code>-Statement for a given key
     *
     * @param key for which a specific DELETE is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getDeleteStatementString(long key) {
        String query1 = String.format("DELETE FROM person " +
                        "WHERE prid = (SELECT caregiver.prid " +
                        "FROM caregiver " +
                        "WHERE caregiver.prid = %d)",
                key);
        String query2 = String.format("DELETE FROM caregiver WHERE cid=%d", key);
        String query3 = String.format("DELETE FROM credentials WHERE credentials_id = (SELECT caregiver.credentials_id FROM caregiver WHERE caregiver.credentials_id = %d)", key);
        return query1 + '\n' + query2 + '\n' + query3;
    }
}
