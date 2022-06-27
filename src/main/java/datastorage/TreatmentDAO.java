package datastorage;

import model.Treatment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//language=SQL

public class TreatmentDAO extends DAOimp<Treatment> {

    public TreatmentDAO(Connection conn) {
        super(conn);
    }

    @Override
    protected String getCreateStatementString(Treatment treatment) {
        return String.format("INSERT INTO treatment (pid, cid, treatment_date, begin, end, description, remarks) VALUES " +
                "(%d, %d, '%s', '%s', '%s', '%s', '%s')", treatment.getPid(), treatment.getCid(), treatment.getDate(),
                treatment.getBegin(), treatment.getEnd(), treatment.getDescription(), treatment.getRemarks());
    }

    @Override
    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT * FROM treatment WHERE tid = %d", key);
    }

    @Override
    protected Treatment getInstanceFromResultSet(ResultSet result) throws SQLException {
        Treatment t = new Treatment(result.getLong(1), result.getLong(2),
                result.getLong(3), result.getDate(4).toLocalDate(),
                result.getTime(5).toLocalTime(), result.getTime(6).toLocalTime(),
                result.getString(7), result.getString(8));
        return t;
    }

    @Override
    protected String getReadAllStatementString() {
        return "SELECT * FROM treatment";
    }

    @Override
    protected ArrayList<Treatment> getListFromResultSet(ResultSet result) throws SQLException {
        ArrayList<Treatment> list = new ArrayList<>();
        Treatment t;
        while (result.next()) {
            t = new Treatment(result.getLong(1), result.getLong(2),
                    result.getLong(3), result.getDate(4).toLocalDate(),
                    result.getTime(5).toLocalTime(), result.getTime(6).toLocalTime(),
                    result.getString(7), result.getString(8));
            list.add(t);
        }
        return list;
    }

    @Override
    protected String getUpdateStatementString(Treatment treatment) {
        return String.format("UPDATE treatment SET pid = %d, treatment_date ='%s', begin = '%s', end = '%s'," +
                "description = '%s', remarks = '%s' WHERE tid = %d", treatment.getPid(), treatment.getDate(),
                treatment.getBegin(), treatment.getEnd(), treatment.getDescription(), treatment.getRemarks(),
                treatment.getTid());
    }

    @Override
    protected String getDeleteStatementString(long key) {
        return String.format("Delete FROM treatment WHERE tid= %d", key);
    }

    public List<Treatment> readTreatmentsByPid(long pid) throws SQLException {
        ArrayList<Treatment> list;
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(getReadAllTreatmentsOfOnePatientByPid(pid));
        list = getListFromResultSet(result);
        return list;
    }

    private String getReadAllTreatmentsOfOnePatientByPid(long key){
        return String.format("SELECT * FROM treatment WHERE pid = %d", key);
    }

    public void deleteByPid(long key) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate(String.format("Delete FROM treatment WHERE pid= %d", key));
    }
}