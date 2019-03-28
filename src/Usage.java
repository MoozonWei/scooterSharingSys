import java.text.SimpleDateFormat;
import java.util.Date;

public class Usage {
    private String userQMNo;
    private String pickUpTime = null;
    private String returnTime = null;

    // constructor
    public Usage() {
        this.setUserQMNo(null);
    }
    public Usage(String userQMNo) {
        this.setUserQMNo(userQMNo);
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

    @Override
    public String toString() {
        return ("user QMNo: " + this.getUserQMNo() + "\n" +
                "pick up time: " + this.getPickUpTime() + "\n" +
                "return time: " + this.getReturnTime() + "\n");
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
