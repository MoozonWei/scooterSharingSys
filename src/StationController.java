import java.util.ArrayList;

public class StationController {
    // 借车前检查
    /*
        此处分为两个部分，第一部分，检查刷卡用户是否是可以借车的用户，第二部分检查刷卡的人是否有罚款还未还清
        1. 遍历userArrayList，寻找是否有与所给QMNo一致的用户，如果没有返回相应信息，表示该用户不在userArrayList中
        2. 接着检查该用户的user.fineOrNot的值是true还是false
        3. false：返回信息提示该用户还有罚款未交
        4. true： 接着遍历usageArrayList中寻找有没有returnTime为null且学号等于QMNo的记录（表明该用户上一部车还没还）
        5. 有：   返回信息表示不能一张卡接两部车（也可以加上小功能显示上一部车的使用时间）
        6. 无：   表示该用户既是有效用户，有没有罚款记录，也没有在借多辆车----->可以借车（配合pickUpScooter()使用）
     */
    public static boolean userChecking(ArrayList<User> userArrayList, String QMNo) {
        for(User user : userArrayList) {
            if(user.getQMNo() == QMNo)
                return true;
        }
        return false;
    }

    public static boolean fineChecking(ArrayList<User> userArrayList, String QMNo) {
        for(User user : userArrayList) {
            if(user.getQMNo() == QMNo) {
                if(user.isFineOrNot())
                    return true;
            }
        }
        return false;
    }

    public static boolean usageChecking(ArrayList<Usage> usageArrayList, String QMNo) {
        for(Usage usage : usageArrayList) {
            if(usage.getUserQMNo() == QMNo) {
                if(usage.getReturnTime() == null)
                    return true;                        // allow
            }
        }
        return false;                                   // not allow
    }

    // 取车
    /*
        1. 找一个空闲的车，如果没有可以接的车了就返回相应的提示信息
        2. 如果有车可以借：闪灯----->计时开始----->是否拿走？----拿走---->该slot设为false---->添加一个Usage----->返回提示信息
                                                       |
                                                       |----没拿走---->返回提示信息
    */
    public static boolean pickUpScooter(String QMNo, Station station, ArrayList<Usage> usageArrayList) {
        long beginTime = System.currentTimeMillis();//开始时间
        long overTime = 60 * 1000;//运行时间

        int availableSlot = station.gvMeAScooter();
        if (availableSlot >= 0 && availableSlot < 8) {
            station.setLights(availableSlot, true);             // 在可以取车的位置亮灯
            // 计时，
            while(true) {
                long nowTime = System.currentTimeMillis();
                if((nowTime - beginTime) > overTime){
                    station.setLights(availableSlot, false);
                    return false;
                }
                else if(station.getSlots(availableSlot) == false) {
                    Usage usage = new Usage(QMNo);
                    usage.setPiTime();
                    station.setLights(availableSlot, false);
                    return true;
                }
            }
        }
        return false;
    }


    // 还车前检查
     /*
            此函数分为两个部分，第一部分，检查刷卡用户是否是有效用户，第二部分检查刷卡的人还车的时间判断是否需要罚款
            1. 遍历usageArrayList，寻找是否有与所给QMNo一致的且usage.，如果没有返回相应信息，表示该用户不在userArrayList中
            2. 否则接着检查该用户的user.fineOrNot的值是true还是false
            3. false：返回信息提示该用户还有罚款未交
            4. true： 返回null表示该用户目前可以借车，并配合pickUpScooter()使用
         */
    public static String returnChecking(ArrayList<Usage> usageArrayList, String QMNo) {

        return null;
    }



    // 还车
    /*
        1. 先找到一个空闲的车位，如果没有空闲的车位了就返回相应的提示信息
        2. 如果有车可以借：闪灯----->计时开始----->是否拿走？----拿走---->该slot设为false---->添加一个Usage----->返回提示信息
                                                   |
                                                   |----没拿走---->返回提示信息
    */
    public void returnScooter() {

    }
}
