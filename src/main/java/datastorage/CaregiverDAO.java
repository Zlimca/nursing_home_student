package datastorage;

import model.Caregiver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//language=SQL

/**
 * Implements the Interface <code>DAOImp</code>. Overrides methods to generate specific patient-SQL-queries.
 */
public class CaregiverDAO extends DAOimp<Caregiver> {

    /**
     * constructs Onbject. Calls the Constructor from <code>DAOImp</code> to store the connection.
     *
     * @param conn
     */
    public CaregiverDAO(Connection conn) {
        super(conn);
    }

    /**
     * generates a <code>INSERT INTO</code>-Statement for a given careiver
     * @param caregiver for which a specific INSERT INTO is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getCreateStatementString(Caregiver caregiver) {
        String query1 = String.format("SELECT PRID FROM person INSERT INTO person (firstname, surname, dateOfBirth) VALUES('%s', '%s', '%s')",
                caregiver.getFirstname(), caregiver.getSurname(), caregiver.getDateOfBirth());
        String query2 = String.format("INSERT INTO caregiver (prid, permission_id, phonenumber) VALUES (IDENTITY(), '%s', '%s')",
                caregiver.getPermissionId(), caregiver.getPhoneNumber());
        return query1 + '\n' + query2;
    }

    /**
     * generates a <code>select</code>-Statement for a given key
     * @param key for which a specific SELECTis to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT caregiver.*, person.FIRSTNAME, person.SURNAME, person.DATEOFBIRTH FROM patient INNER JOIN person ON caregiver.prid WHERE cid = %d", key);
    }

    /**
     * maps a <code>ResultSet</code> to a <code>Caregiver</code>
     * @param result ResultSet with a single row. Columns will be mapped to a caregiver-object.
     * @return caregiver with the data from the resultSet.
     */
    @Override
    protected Caregiver getInstanceFromResultSet(ResultSet result) throws SQLException {
        Caregiver c;
        c = new Caregiver(result.getInt(1), result.getInt(2), result.getString(5),
                result.getString(6), result.getDate(7).toLocalDate(),
                result.getLong(3), result.getString(4), result.getInt(8));
        return c;
    }

    /**
     * generates a <code>SELECT</code>-Statement for all caregivers.
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getReadAllStatementString() {
        return "SELECT caregiver.*, person.FIRSTNAME, person.SURNAME, person.DATEOFBIRTH FROM caregiver INNER JOIN person ON caregiver.prid = person.prid";
    }

    /**
     * maps a <code>ResultSet</code> to a <code>Caregiver-List</code>
     * @param result ResultSet with a multiple rows. Data will be mapped to caregiver-object.
     * @return ArrayList with caregivers from the resultSet.
     */
    @Override
    protected ArrayList<Caregiver> getListFromResultSet(ResultSet result) throws SQLException {
        ArrayList<Caregiver> list = new ArrayList<>();
        Caregiver c;
        while (result.next()) {
            //long cid, long prId,String firstName, String surname, LocalDate dateOfBirth, long permission_id, string phonenumber
            c = new Caregiver(result.getInt(1), result.getInt(2), result.getString(5),
                    result.getString(6), result.getDate(7).toLocalDate(),
                    result.getLong(3), result.getString(4), result.getInt(8));
            list.add(c);
        }
        return list;
    }

    /**
     * generates a <code>UPDATE</code>-Statement for a given patient
     * @param caregiver for which a specific update is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getUpdateStatementString(Caregiver caregiver) {
        String query1 = String.format("UPDATE person SET firstname = '%s', surname = '%s', dateOfBirth = '%s' WHERE" +
                        "PRID = (SELECT pid FROM patient WHERE pid = '%s')",
                caregiver.getFirstname(), caregiver.getSurname(), caregiver.getDateOfBirth(), caregiver.getCId());
        String query2 = String.format("UPDATE caregiver SET permission_id = '%s', phonenumber = '%s'WHERE cid = %d",
                caregiver.getPermissionId(), caregiver.getPhoneNumber(), caregiver.getCId());
        return query1 + '\n' + query2;

            }

    /**
     * generates a <code>delete</code>-Statement for a given key
     * @param key for which a specific DELETE is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getDeleteStatementString(long key) {
        String query1 = String.format("DELETE FROM person WHERE prid = (SELECT caregiver.prid FROM caregiver WHERE caregiver.prid = %d)", key);
        String query2 = String.format("DELETE FROM caregiver WHERE cid=%d", key);
        return query1 + '\n' + query2;
    }
}
