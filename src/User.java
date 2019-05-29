public class User{
    private String QMNo;        // qm number
    private String fName;       // first name
    private String lName;       // last name
    private String email;       // email address
    private boolean fineOrNot;  // does this user need to pay the fine first? (0---no, 1---yes)
    private boolean paystatus;  // does this user has pay the fine?(0---no,1---yes)
    private boolean identity;    //confirm the user identity (0---student, 1---staff)
    // constructor
    public User() {
        this.setQMNo(null);
        this.setfName(null);
        this.setlName(null);
        this.setEmail(null);
        this.setFineOrNot(false);
        this.setpaystatus(false);
    }
    public User(String QMNo, String fName, String lName) {
        this.setQMNo(QMNo);
        this.setfName(fName);
        this.setlName(lName);
        
    }
    public User(String QMNo, String fName, String lName, String email,boolean identity) {
        this.setQMNo(QMNo);
        this.setfName(fName);
        this.setlName(lName);
        this.setEmail(email);
        this.setIdentity(identity);
    }
    // getters
    public String getQMNo() {
        return QMNo;
    }
    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }
    public String getEmail() {
        return email;
    }
    public boolean isFineOrNot() {
        return fineOrNot;
    }
    // setters
    public void setQMNo(String QMNo) {
        this.QMNo = QMNo;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFineOrNot(boolean fineOrNot) {
        this.fineOrNot = fineOrNot;
    }
    
    public void setIdentity(boolean identity) {
    	this.identity=identity;
    }
    public boolean getIdentity() {
    	return this.identity;
    }
    
    public void setpaystatus(boolean paystatus) {
    	this.paystatus=paystatus;
    }
    public boolean getpaystatus() {
    	return this.paystatus;
    }
    @Override
    public String toString() {
        return ("QMNo: " + this.getQMNo() + "\n" +
                "fName: " + this.getfName() + "\n" +
                "lName: " + this.getlName() + "\n" +
                "email: " + this.getEmail() + "\n" +
                "identity"+ this.getIdentity()+"\n"+
                "fineOrNot: " + this.isFineOrNot() + "\n"+
                "payStatus: "+this.getpaystatus()+"\n");
    }
}
