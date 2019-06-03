/**
 * This is an entity class that defines managers
 *
 * @author Zihan Wei
 */

public class Manager {
    private String ID;
    private String passwd;
    private String fName;
    private String lName;

    // constructor
    public Manager() {
        this.setID(null);
        this.setPasswd(null);
        this.setfName(null);
        this.setlName(null);
    }
    public Manager(String ID, String passwd, String fName, String lName) {
        this.setID(ID);
        this.setPasswd(passwd);
        this.setfName(fName);
        this.setlName(lName);
    }
    // getter
    public String getID() {
        return this.ID;
    }
    public String getPasswd() {
        return this.passwd;
    }
    public String getfName() {
        return this.fName;
    }
    public String getlName() {
        return this.lName;
    }
    // setters
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return ("ID: " + this.getID() + "\n" +
                "passwd: " + this.getPasswd() + "\n" +
                "fName: " + this.getfName() + "\n" +
                "lName: " + this.getlName() + "\n");
    }
}
