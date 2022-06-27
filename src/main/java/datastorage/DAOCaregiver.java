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
public class DAOCaregiver extends DAOimp<Caregiver> {

    /**
     * constructs Onbject. Calls the Constructor from <code>DAOImp</code> to store the connection.
     * @param conn
     */
    public DAOCaregiver(Connection conn) {
        super(conn);
    }

    /**
     * generates a <code>INSERT INTO</code>-Statement for a given patient
     * @param caregiver for which a specific INSERT INTO is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getCreateStatementString(Caregiver caregiver) {
        String query1 = String.format("SELECT PRID FROM person INSERT INTO person (firstname, surname, dateOfBirth) VALUES('%s', '%s', '%s')",
                caregiver.getFirstName(), caregiver.getSurname(), caregiver.getDateOfBirth());
        String query2 = String.format("INSERT INTO patient (prid, permission_id, phonenumber) VALUES (IDENTITY(), '%s', '%s')",
                caregiver.getTelephone());
        return query1 + '\n' + query2;
    }

    /**
     * generates a <code>select</code>-Statement for a given key
     * @param key for which a specific SELECTis to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT caregiver.*, person.* FROM patient INNER JOIN person ON caregiver.prid WHERE cid = %d", key);
    }

    /**
     * maps a <code>ResultSet</code> to a <code>Caregiver</code>
     * @param result ResultSet with a single row. Columns will be mapped to a caregiver-object.
     * @return caregiver with the data from the resultSet.
     */
    @Override
    protected Caregiver getInstanceFromResultSet(ResultSet result) throws SQLException {
        Caregiver c;
        c = new Caregiver( result.getInt("CID"), result.getInt("PRID"), result.getString("FIRSTNAME"),
                    result.getString("SURNAME"), result.getDate("DATEOFBIRTH").toLocalDate(),
                    result.getLong("PERMISSION_ID"), result.getInt("PHONENUMBER"));
        return c;
    }

    /**
     * generates a <code>SELECT</code>-Statement for all caregivers.
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getReadAllStatementString() {
        return "SELECT caregiver.*, person.* FROM caregiver INNER JOIN person ON caregiver.prid = person.prid";
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
            //long cid, long prId,String firstName, String surname, LocalDate dateOfBirth, long permission_id, int telephone
            c = new Caregiver( result.getInt("CID"), result.getInt("PRID"), result.getString("FIRSTNAME"),
                    result.getString("SURNAME"), result.getDate("DATEOFBIRTH").toLocalDate(),
                    result.getLong("PERMISSION_ID"), result.getInt("PHONENUMBER"));
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
        String query1 = String.format("UPDATE person SET firstname = '%s', surname = '%s', dateOfBirth = '%s' WHERE"  +
               "PRID = (SELECT pid FROM patient WHERE pid = '%s')",
                caregiver.getFirstName(), caregiver.getSurname(), caregiver.getDateOfBirth(), caregiver.getCid());
        String query2 = String.format("UPDATE caregiver SET permission_id = '%s', phonenumber = '%s'WHERE cid = %d",
                caregiver.getPermission_id(), caregiver.getTelephone());
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
