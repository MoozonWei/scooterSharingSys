public class User{
    private String QMNo;        // qm number
    private String fName;       // first name
    private String lName;       // last name
    private String email;       // email address
    private boolean fineOrNot;  // does this user need to pay the fine first? (0---no, 1---yes)

    // constructor
    public User() {
        this.setQMNo(null);
        this.setfName(null);
        this.setlName(null);
        this.setEmail(null);
        this.setFineOrNot(false);
    }
    public User(String QMNo, String fName, String lName) {
        this.setQMNo(QMNo);
        this.setfName(fName);
        this.setlName(lName);
    }
    public User(String QMNo, String fName, String lName, String email) {
        this.setQMNo(QMNo);
        this.setfName(fName);
        this.setlName(lName);
        this.setEmail(email);
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

    @Override
    public String toString() {
        return ("QMNo: " + this.getQMNo() + "\n" +
                "fName: " + this.getfName() + "\n" +
                "lName: " + this.getlName() + "\n" +
                "email: " + this.getEmail() + "\n" +
                "fineOrNot: " + this.isFineOrNot() + "\n");
    }
}
