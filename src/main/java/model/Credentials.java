package model;

import java.util.ArrayList;
import java.util.List;

public class Credentials {
//Login
    private long credentialsid;
    private long prid;
    private final String username;
    private final String password;
    private final String salt;
    private final boolean firstlogin;

    private final List<Credentials> allCredentials = new ArrayList<>();

    public Credentials(String username, String password, String salt, boolean firstlogin){
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.firstlogin = firstlogin;
    }

    /**
     * constructs a patient from the given params.
     *
     * @param credentialsid credentialsId
     * @param prid PersonId
     * @param username Username
     * @param password Password
     * @param salt Salt
     * @param firstlogin firstlogin
     */
    public Credentials(long credentialsid, long prid, String username, String password, String salt, boolean firstlogin){
        this.credentialsid = credentialsid;
        this.prid = prid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.firstlogin = firstlogin;
    }
    public long getCredentialsid(){ return credentialsid;}
    public long getPrid() { return prid;}
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getSalt(){ return salt;}
    public boolean isFirstlogin(){return firstlogin;}

    public boolean add(Credentials credentials) {
        if (!this.allCredentials.contains(credentials)) {
            this.allCredentials.add(credentials);
            return true;
        }
        return false;
    }
}
