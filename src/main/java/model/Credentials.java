package model;

public class Credentials {
//Login
    private long cid; //CredentialsId?
    private long prid; // person
    private String username;
    private String password;

    public Credentials(long prid, String username, String password){
        this.prid = prid;
        this.username = username;
        this.password = password;
    }

    public Credentials(long cid, long prid, String username, String password){
        this.cid = cid;
        this.username = username;
        this.password = password;
    }
    public long getcid() {
        return cid;
    }
    public long getPrid() { return prid;}
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }


}
