import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Usage {
    private String userQMNo;
    private String pickUpTime = null;
    private String returnTime = null;
    private String usageTime=null;
    private boolean fineStatus=false;  // does this user need to pay the fine first? (0---no, 1---yes)
    private boolean payStatus=false; 
    private char pickUpStation = 0;
    private char returnStation = 0;

    // constructor
    public Usage() {
        this.setUserQMNo(null);
    }
    public Usage(String userQMNo) {
        this.setUserQMNo(userQMNo);
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
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        pickUpTime = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��

    }
    public void setReturnTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        returnTime = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��

    }
    
    public void calUsageTime() throws ParseException {
    	
    	SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   	    SimpleDateFormat simpleFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	Date fromDate3 = simpleFormat.parse(this.getPickUpTime());  
    	Date toDate3 = simpleFormat1.parse(this.getReturnTime());
    	long pickUptime = fromDate3.getTime();  
    	long returntime = toDate3.getTime();
    	int uasgetime = (int) ((returntime - pickUptime) / (1000 * 60)); 
    	this.usageTime=String.valueOf(uasgetime);
    	
   	
    }
    public String getUsageTime() {
    	return usageTime;
    }
    
    public void setPaystatus(boolean payStatus) {
    	this.payStatus=payStatus;
    }
    public boolean getpaystatus() {
    	return this.payStatus;
    }

    public void setFineStatus(boolean fineStatus) {
    	this.fineStatus=fineStatus;
    }
    public boolean getFineStatus() {
    	return this.fineStatus;
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
                "return time: " + this.getReturnTime() + "\n"+
                "pick up station: " + this.getPickUpStation() + "\n" +
                "return station: " + this.getReturnStation() + "\n"+
                "fine status: "+this.getFineStatus()+"\n"+
                "payStatus: "+this.getpaystatus()+"\n");
    }

    // main�������Դ��빦��
    public static void main(String args[]) throws ParseException {
    	ArrayList<Usage> usageList=new ArrayList<>();
    	usageList=ListJsonSwitch.jsonToUsage();
    	
        Usage u1 = new Usage("111111111");
        u1.setPiTime();
        System.out.println(u1.getPickUpTime());
        try {
            Thread.currentThread().sleep(5000);//����
        } catch (Exception e) {
        }
        u1.setReturnTime();
        System.out.println(u1.getReturnTime());
        u1.calUsageTime();
        u1.setFineStatus(true);
        u1.setPaystatus(false);
        
        usageList.add(u1);
        
        Usage u2 = new Usage("789429472");
        u2.setPiTime();
        System.out.println(u1.getPickUpTime());
        try {
            Thread.currentThread().sleep(10000);//����
        } catch (Exception e) {
        }
        u2.setReturnTime();
        System.out.println(u2.getReturnTime());
        
        usageList.add(u2);
        ListJsonSwitch.UsageToJson(usageList);
    }
}
