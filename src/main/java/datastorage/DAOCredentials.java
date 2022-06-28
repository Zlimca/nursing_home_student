package datastorage;


import model.Credentials;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Login

/**
 * Implements the Interface <code>DAOImp</code>. Overrides methods to generate specific patient-SQL-queries.
 */
public class DAOCredentials extends DAOimp<Credentials> {

    /**
     * constructs Onbject. Calls the Constructor from <code>DAOImp</code> to store the connection.
     * @param conn Connection
     */
    public DAOCredentials(Connection conn) {
        super(conn);
    }

    /**
     * generates a <code>INSERT INTO</code>-Statement for a given credential
     * @param credentials for which a specific INSERT INTO is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getCreateStatementString(Credentials credentials) {
        return String.format("INSERT INTO credentials (prid, user_name, password, salt, first_login) VALUES (%d, '%s', '%s', '%s',%b)",
                credentials.getPrid(), credentials.getUsername(), credentials.getPassword(), credentials.getSalt(), credentials.isFirstlogin());
    }

    /**
     * generates a <code>select</code>-Statement for a given key
     * @param key for which a specific SELECT is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getReadByIDStatementString(long key) {
        return String.format("SELECT * FROM credentials WHERE credentials_id = %d", key);
    }

    /**
     * maps a <code>ResultSet</code> to a <code>Credentials</code>
     * @param result ResultSet with a single row. Columns will be mapped to a credential-object.
     * @return credential with the data from the resultSet.
     */
    @Override
    protected Credentials getInstanceFromResultSet(ResultSet result) throws SQLException {
        Credentials c;
            c = new Credentials(result.getInt(1), result.getInt(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getBoolean(6));
        return c;
    }

    /**
     * generates a <code>SELECT</code>-Statement for all credentials.
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getReadAllStatementString() {
        return "SELECT * FROM credentials";
    }

    /**
     * maps a <code>ResultSet</code> to a <code>Credentials-List</code>
     * @param result ResultSet with a multiple rows. Data will be mapped to credentials-object.
     * @return ArrayList with credential from the resultSet.
     */
    @Override
    protected ArrayList<Credentials> getListFromResultSet(ResultSet result) throws SQLException {
        ArrayList<Credentials> list = new ArrayList<>();
        Credentials c;
        while (result.next()) {
            c = new Credentials(result.getInt(1), result.getInt(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getBoolean(6));
            list.add(c);
        }
        return list;
    }

    /**
     * generates a <code>UPDATE</code>-Statement for a given patient
     * @param credentials for which a specific update is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getUpdateStatementString(Credentials credentials) {

        return String.format("UPDATE credentials SET username = '%s', password = '%s' WHERE cid = %d", credentials.getUsername(), credentials.getPassword(), credentials.getCredentialsid());
    }

    /**
     * generates a <code>delete</code>-Statement for a given key
     * @param key for which a specific DELETE is to be created
     * @return <code>String</code> with the generated SQL.
     */
    @Override
    protected String getDeleteStatementString(long key) { return String.format("Delete FROM credentials WHERE cid=%d", key);
    }

}
