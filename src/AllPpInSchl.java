/**
 * This is an entity class that defines all people in school
 *
 * @author Zihan Wei
 */

public class AllPpInSchl {
    private String QMNo;           // qm number
    private String fName;       // first name
    private String lName;       // last name

    // constructor
    public AllPpInSchl() {
        this.setQMNo(null);
        this.setfName(null);
        this.setlName(null);
    }

    public AllPpInSchl(String QMNo, String fName, String lName) {
        this.setQMNo(QMNo);
        this.setfName(fName);
        this.setlName(lName);
    }

    // getters
    public String getQMNo() {
        return this.QMNo;
    }

    public String getfName() {
        return this.fName;
    }

    public String getlName() {
        return this.lName;
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

    @Override
    public String toString() {
        return ("QMNo: " + this.getQMNo() + "\n" +
                "fName: " + this.getfName() + "\n" +
                "lName: " + this.getlName() + "\n");
    }
}
