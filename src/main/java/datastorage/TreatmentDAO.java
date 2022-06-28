package datastorage;

import model.Caregiver;
import model.Treatment;
import utils.DateConverter;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//language=SQL

/**
 * Implements the Interface <code>DAOImp</code>. Overrides methods to generate specific treatment-SQL-queries.
 */
public class TreatmentDAO extends DAOimp<Treatment> {

    /**
     * constructs Object. Calls the Constructor from <code>DAOImp</code> to store the connection.
     * @param conn Connection
     */
    public TreatmentDAO(Connection conn) {
        super(conn);
    }

    /**
     * generates a <code>INSERT INTO</code>-Statement for a given treatment
     * @param treatment for which a specific INSERT INTO is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getCreateStatementString(Treatment treatment) {
        return String.format("INSERT INTO treatment (pid, cid, treatment_date, begin, end, description, remarks) VALUES " +
                "(%d, %d, '%s', '%s:00', '%s:00', '%s', '%s')", treatment.getPid(), treatment.getCaregiverId(), treatment.getDate(),
                treatment.getBegin(), treatment.getEnd(), treatment.getDescription(), treatment.getRemarks());
    }

    /**
     * generates a <code>select</code>-Statement for a given key
     * @param key for which a specific SELECT is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT * FROM treatment WHERE tid = %d", key);
    }

    /**
     * maps a <code>ResultSet</code> to a <code>Treatment</code>
     * @param result ResultSet with a single row. Columns will be mapped to a treatment-object.
     * @return treatment with the data from the resultSet.
     */
    @Override
    protected Treatment getInstanceFromResultSet(ResultSet result) throws SQLException {
        Caregiver caregiver = new Caregiver(
                result.getLong(1), result.getLong(2), result.getString(3),
                result.getString(4), result.getDate(5).toLocalDate(), result.getLong(6),
                result.getString(7), result.getInt(8));
        // long cId, long prId, String firstname, String surname, LocalDate dateOfBirth, long permissionId, String phoneNumber
        Treatment t = new Treatment(result.getLong(1), result.getLong(2),
                caregiver, result.getDate(4).toLocalDate(),
                result.getTime(5).toLocalTime(), result.getTime(6).toLocalTime(),
                result.getString(7), result.getString(8));
        return t;
    }

    /**
     * generates a <code>SELECT</code>-Statement for all treatment.
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getReadAllStatementString() {
        return "SELECT treatment.*, " +
                "caregiver.prID, caregiver.permission_ID, caregiver.phoneNumber, " +
                "person.firstname, person.surname, person.dateOfBirth " +
                "FROM treatment " +
                "JOIN caregiver ON treatment.cid = caregiver.cid " +
                "JOIN person ON caregiver.prID = person.prID";
    }

    /**
     * maps a <code>ResultSet</code> to a <code>Treatment-List</code>
     * @param result ResultSet with a multiple rows. Data will be mapped to treatment-object.
     * @return ArrayList with treatment from the resultSet.
     */
    @Override
    protected ArrayList<Treatment> getListFromResultSet(ResultSet result) throws SQLException {
        ArrayList<Treatment> list = new ArrayList<>();
        Treatment t;
        Caregiver caregiver;
        while (result.next()) {
            long cId = result.getLong(3);
            long prId = result.getLong(9);
            String firstname = result.getString(12);
            String surname = result.getString(13);
            LocalDate dateOfBirth = checkDateForNull(result.getDate(14));
            long permissionId = result.getLong(10);
            String phoneNumber = result.getString(11);

            long tId = result.getLong(1);
            long pId = result.getLong(2);
            LocalDate date = checkDateForNull(result.getDate(4));
            LocalTime begin = checkTimeForNull(result.getTime(5));
            LocalTime end = checkTimeForNull(result.getTime(6));
            String description = result.getString(7);
            String remarks = result.getString(8);
            long credentialsId = result.getInt(9);
            // long cId, long prId, String firstname, String surname, LocalDate dateOfBirth, long permissionId, String phoneNumber
            caregiver = new Caregiver(cId, prId, firstname,surname, dateOfBirth, permissionId,phoneNumber, credentialsId);
            //long tid, long pid, Caregiver caregiver, LocalDate date, LocalTime begin, LocalTime end, String description, String remarks
            t = new Treatment(tId, pId, caregiver, date, begin, end, description, remarks);
            list.add(t);
        }
        return list;
    }

    /**
     * generates a <code>UPDATE</code>-Statement for a given treatment
     * @param treatment for which a specific update is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getUpdateStatementString(Treatment treatment) {
        return String.format("UPDATE treatment " +
                        "SET treatment_date ='%s', begin = '%s:00', end = '%s:00', description = '%s', remarks = '%s' " +
                        "WHERE tid = %d",
                treatment.getDate(), treatment.getBegin(), treatment.getEnd(),
                treatment.getDescription(), treatment.getRemarks(), treatment.getTid());
    }

    /**
     * generates a <code>delete</code>-Statement for a given key
     * @param key for which a specific DELETE is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getDeleteStatementString(long key) {
        return String.format("Delete FROM treatment WHERE tid= %d", key);
    }

    /**
     * reads all treatments by their
     * @param pid for which a specific DELETE is to be created
     * @return Arraylist with all treatments
     */
    public List<Treatment> readTreatmentsByPid(long pid) throws SQLException {
        ArrayList<Treatment> list;
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(getReadAllTreatmentsOfOnePatientByPid(pid));
        list = getListFromResultSet(result);
        return list;
    }

    public List<Treatment> readTreatmentsByCid(long cid) throws SQLException {
        ArrayList<Treatment> list;
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(getReadAllTreatmentsOfOnePatientByCid(cid));
        list = getListFromResultSet(result);
        return list;
    }

    private String getReadAllTreatmentsOfOnePatientByPid(long key){
        return String.format("SELECT treatment.*, " +
                "caregiver.prID, caregiver.permission_ID, caregiver.phoneNumber, " +
                "person.firstname, person.surname, person.dateOfBirth " +
                "FROM treatment " +
                "JOIN caregiver ON treatment.cid = caregiver.cid " +
                "JOIN person ON caregiver.prID = person.prID " +
                "WHERE pid = %d", key);
    }

    private String getReadAllTreatmentsOfOnePatientByCid(long key){
        return String.format("SELECT treatment.*, " +
                "caregiver.prID, caregiver.permission_ID, caregiver.phoneNumber, " +
                "person.firstname, person.surname, person.dateOfBirth " +
                "FROM treatment " +
                "JOIN caregiver ON treatment.cid = caregiver.cid " +
                "JOIN person ON caregiver.prID = person.prID " +
                "WHERE treatment.cid = %d", key);
    }

    public void deleteByPid(long key) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate(String.format("Delete FROM treatment WHERE pid= %d", key));
    }

    private LocalDate checkDateForNull(Date date) {
        if (date != null) {
            return date.toLocalDate();
        } else {
            return DateConverter.convertStringToLocalDate("0000-01-01");
        }
    }

    private LocalTime checkTimeForNull(Time time) {
        if (time != null) {
            return time.toLocalTime();
        } else {
            return DateConverter.convertStringToLocalTime("00:00:00");
        }
    }
}