import java.text.SimpleDateFormat;
import java.util.Date;

public class Usage {
    public String pickUpTime = "";
    public String returnTime = "";
    public int userQMNo = 0;


    // 设置（当前时间为）取车时间，目前没有返回值
    public void setPiTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        pickUpTime = df.format(new Date());// new Date()为获取当前系统时间

    }

    // 设置（当前时间为）还车时间，目前没有返回值
    public void setReturnTime (){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        returnTime = df.format(new Date());// new Date()为获取当前系统时间

    }

    // main函数测试代码功能
    public static void main(String args[]) {
        System.out.println("zhishidiyihang");
        Usage u1 = new Usage();
        u1.setPiTime();
        System.out.println(u1.pickUpTime);
        try
        {
            Thread.currentThread().sleep(5000);//毫秒
        }
        catch(Exception e){}
        u1.setReturnTime();
        System.out.println(u1.returnTime);
    }
}
