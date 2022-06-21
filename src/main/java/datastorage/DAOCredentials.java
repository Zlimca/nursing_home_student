package datastorage;

import model.Credentials;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Login
public class DAOCredentials extends DAOimp<Credentials> {

    public DAOCredentials(Connection conn) {
        super(conn);
    }

    @Override
    protected String getCreateStatementString(Credentials credentials) {
        return String.format("INSERT INTO credentials (prid, user_name, password, salt, first_login) VALUES ('%s', '%s', '%s','%s', '%s','%s')",
                credentials.getPrid(), credentials.getUser_name(), credentials.getPassword(), credentials.getSalt(), credentials.isFirst_login());
    }

    @Override
    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT * FROM credentials WHERE credentials_id = %d", key);
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

        return String.format("UPDATE credentials SET username = '%s', password = '%s' WHERE cid = %d", credentials.getUser_name(), credentials.getPassword(), credentials.getCredentials_id());
    }

    @Override
    protected String getDeleteStatementString(long key) { return String.format("Delete FROM credentials WHERE cid=%d", key);
    }

}
