package model;

public class Credentials {
//Login
    private long credentials_id;
    private long prid; // person
    private String user_name;
    private String password;
    private String salt;
    private boolean first_login;


    public Credentials(long prid, String user_name, String password, String salt, boolean first_login){
        this.prid = prid;
        this.user_name = user_name;
        this.password = password;
        this.salt = salt;
        this.first_login = first_login;
    }

    public Credentials(long credentials_id, long prid, String user_name, String password, String salt, boolean first_login){
        this.credentials_id = credentials_id;
        this.prid = prid;
        this.user_name = user_name;
        this.password = password;
        this.salt = salt;
        this.first_login = first_login;
    }
    public long getCredentials_id(){ return credentials_id;}
    public long getPrid() { return prid;}
    public String getUser_name(){
        return user_name;
    }
    public String getPassword(){
        return password;
    }
    public String getSalt(){ return salt;}
    public boolean isFirst_login(){return first_login;}


}
