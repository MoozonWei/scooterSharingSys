import java.util.ArrayList;

public class ManSysOp {

    public static String checkLogin(ArrayList<Manager> managerArrayList, String ID, String passwd){
        for (Manager manager : managerArrayList) {
            if(manager.getID()==ID){
                if(manager.getPasswd()==passwd)
                    return "Login successful!";                        // 找到ID，密码正确
                else
                    return "Wrong password!";                       // 找到ID，密码错误
            }
        }
        return "ID not found!";                                   // 没找到ID
    }
    // add a user
    public static User addUser(ArrayList<AllPpInSchl> allPpInSchlArrayList, String QMNo, String email){
        /*
            1. 检查所给的QMNo在不在学校的系统中（即遍历AllPpInSchl的ArrayList），如果不在UI显示相关信息
            2. 检查所给邮箱是不是符合邮箱规则
            3. 在所有检查都通过之后创建一个新的User类，然后将所添加的信息写入和学生原有的信息写入该类，最后返回这个新创建的类
         */
        return null;
    }
    // check station condition
    public static boolean[] stationCondition(Station station, char stationName) {
        /*
            1. 首先先判断要查询的是哪个车站
            2. 返回该车站的车位信息（即将返回slot[]）
         */
        return null;
    }
    // check user usage
    public static ArrayList<Usage> checkUsageByQMNo(ArrayList<Usage> usageArrayList, String QMNo) {
        /*
            1. 创建一个新的ArrayList result用来存储需要查询的usage结果
            2. 遍历usageArrayList中的元素，将与要查询的QMNo相符合的查询结果add到新创建的ArrayList result中
            3. 返回包含所有查询信息的ArrayList result
         */
        return null;
    }
    public static ArrayList<Usage> checkUsageByTime(ArrayList<Usage> usageArrayList, String dateInString) {
        /*
            1. 创建一个新的ArrayList result用来存储需要查询的usage结果
            2. 遍历usageArrayList中的元素，将与要查询的时间日期相符合的查询结果add到新创建的ArrayList result中
            3. 返回包含所有查询信息的ArrayList result
         */
        return null;
    }
    // user revocation
    public static boolean revokeUser(ArrayList<User> userArrayList, String QMNo) {
        /*
            1. 先判断所给的QMNo是不是User之一，如果不是返回false，操作失败；如果是的则继续以下操作
            2. 遍历userArrayList中的所有User，找到学号与QMNo一致的用户，然后删除它，然后返回true表示删除成功

            注意：这里的userArrayList应该是一个系统开始时就加载好的 全局变量！（i guess...）
         */
        return true;
    }

    public static void main(String args[]){
        // test loginCheck()
        Manager manager1 = new Manager("123456", "123456", "Manager", "One");
        Manager manager2 = new Manager("654321", "654321", "Manager", "Two");
        ArrayList<Manager> managerArrayList = new ArrayList<>();
        managerArrayList.add(manager1);
        managerArrayList.add(manager2);
        System.out.println(ManSysOp.checkLogin(managerArrayList,"12345678","12345678"));
        System.out.println(ManSysOp.checkLogin(managerArrayList,"87654321","12345678"));

        // test addUser()


    }
}
