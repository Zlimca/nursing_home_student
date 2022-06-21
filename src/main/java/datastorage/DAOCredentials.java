package datastorage;

import model.Credentials;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Login
public class CredentialsDAO extends DAOimp<Credentials> {

    public CredentialsDAO(Connection conn) {
        super(conn);
    }

    @Override
    protected String getCreateStatementString(Credentials credentials) {
        return String.format("INSERT INTO credentials (prid, username, password) VALUES ('%s', '%s', '%s')",
                credentials.getPrid(), credentials.getUsername(), credentials.getPassword());
    }

    @Override
    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT * FROM credentials WHERE cid = %d", key);
    }

    @Override
    protected Credentials getInstanceFromResultSet(ResultSet set) throws SQLException {
        return null;
    }

    @Override
    protected String getReadAllStatementString() {
        return "SELECT * FROM credentials";
    }

    @Override
    protected ArrayList<Credentials> getListFromResultSet(ResultSet set) throws SQLException {
        return null;
    }

    @Override
    protected String getUpdateStatementString(Credentials credentials) {

        return String.format("UPDATE credentials SET username = '%s', password = '%s' WHERE cid = %d", credentials.getUsername(), credentials.getPassword(), credentials.getcid());
    }

    @Override
    protected String getDeleteStatementString(long key) { return String.format("Delete FROM credentials WHERE cid=%d", key);
    }

}
