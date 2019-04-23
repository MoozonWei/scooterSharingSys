import java.text.SimpleDateFormat;
import java.util.Date;

public class Usage {
    private String userQMNo;
    private String pickUpTime = null;
    private String returnTime = null;
    private char pickUpStation = 0;
    private char returnStation = 0;

    // constructor
    public Usage() {
        this.setUserQMNo(null);
    }

    public Usage(String userQMNo, char pickUpStation) {
        this.setUserQMNo(userQMNo);
        this.setPickUpStation(pickUpStation);
    }

    // getters
    public String getUserQMNo() {
        return userQMNo;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public char getPickUpStation() {
        return pickUpStation;
    }

    public char getReturnStation() {
        return returnStation;
    }

    // setters
    public void setUserQMNo(String userQMNo) {
        this.userQMNo = userQMNo;
    }

    public void setPiTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        pickUpTime = df.format(new Date());// new Date()为获取当前系统时间

    }

    public void setReturnTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        returnTime = df.format(new Date());// new Date()为获取当前系统时间

    }

    public void setPickUpStation(char pickUpStation) {
        this.pickUpStation = pickUpStation;
    }

    public void setReturnStation(char returnStation) {
        this.returnStation = returnStation;
    }

    @Override
    public String toString() {
        return ("user QMNo: " + this.getUserQMNo() + "\n" +
                "pick up time: " + this.getPickUpTime() + "\n" +
                "pick up station: " + this.getPickUpStation() + "\n" +
                "return time: " + this.getReturnTime() + "\n" +
                "return station: " + this.getReturnStation() + "\n");
    }

    // main函数测试代码功能
    public static void main(String args[]) {
        Usage u1 = new Usage();
        u1.setPiTime();
        System.out.println(u1.getPickUpTime());
        try {
            Thread.currentThread().sleep(5000);//毫秒
        } catch (Exception e) {
        }
        u1.setReturnTime();
        System.out.println(u1.getReturnTime());
    }
}
