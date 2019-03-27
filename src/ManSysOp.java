import java.util.ArrayList;

public class ManSysOp {

    public static boolean loginCheck(ArrayList<Manager> managerArrayList, String ID, String passwd){
        for (Manager manager : managerArrayList) {
            if(manager.getID()==ID){
                if(manager.getPasswd()==passwd)
                    return true;                        // 找到ID，密码正确
                else
                    return false;                       // 找到ID，密码错误
            }
        }
        return false;                                   // 没找到ID
    }

    public static void main(String args[]){
        // test loginCheck()
        ArrayList<Manager> managerArrayList = new ArrayList<>();
        Manager managerA = new Manager();
        managerA.setID("12345678");
        managerA.setPasswd("12345678");
        managerA.setfName("David");
        managerA.setlName("Wei");
        Manager managerB = new Manager();
        managerB.setID("87654321");
        managerB.setPasswd("87654321");
        managerB.setfName("Moozon");
        managerB.setlName("Wei");
        managerArrayList.add(managerA);
        managerArrayList.add(managerB);
        System.out.println(ManSysOp.loginCheck(managerArrayList,"12345678","12345678"));
        System.out.println(ManSysOp.loginCheck(managerArrayList,"87654321","12345678"));

        //

    }
}
