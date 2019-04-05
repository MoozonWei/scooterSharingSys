import java.util.ArrayList;

public class StationController {
    // 借车前检查
    public static String pickUpChecking(ArrayList<Usage> usageArrayList, ArrayList<User> userArrayList, String QMNo) {
        /*
            此函数分为两个部分，第一部分，检查刷卡用户是否是可以借车的用户，第二部分检查刷卡的人是否有罚款还未还清
            1. 遍历userArrayList，寻找是否有与所给QMNo一致的用户，如果没有返回相应信息，表示该用户不在userArrayList中
            2. 接着检查该用户的user.fineOrNot的值是true还是false
            3. false：返回信息提示该用户还有罚款未交
            4. true： 接着遍历usageArrayList中寻找有没有returnTime为null且学号等于QMNo的记录（表明该用户上一部车还没还）
            5. 有：   返回信息表示不能一张卡接两部车（也可以加上小功能显示上一部车的使用时间）
            6. 无：   表示该用户既是有效用户，有没有罚款记录，也没有在借多辆车----->可以借车（配合pickUpScooter()使用）
         */
        return null;
    }
    // 取车
    public static String pickUpScooter(String QMNo, Station station) {
        /*
            1. 找一个空闲的车，如果没有可以接的车了就返回相应的提示信息
            2. 如果有车可以借：闪灯----->计时开始----->是否拿走？----拿走---->该slot设为false---->添加一个Usage----->返回提示信息
                                                       |
                                                       |----没拿走---->返回提示信息
         */
        int availableSlot = station.gvMeAScooter();
        if (availableSlot >= 0 && availableSlot < 8) {
            station.setLights(availableSlot, true);             // 在可以取车的位置亮灯
            // 计时，
        } else {
            // 没有车了
            return "no more scooter";
        }
    }
    // 还车前检查
    public static String returnChecking(ArrayList<Usage> usageArrayList, String QMNo) {
        /*
            此函数分为两个部分，第一部分，检查刷卡用户是否是有效用户，第二部分检查刷卡的人还车的时间判断是否需要罚款
            1. 遍历usageArrayList，寻找是否有与所给QMNo一致的且usage.，如果没有返回相应信息，表示该用户不在userArrayList中
            2. 否则接着检查该用户的user.fineOrNot的值是true还是false
            3. false：返回信息提示该用户还有罚款未交
            4. true： 返回null表示该用户目前可以借车，并配合pickUpScooter()使用
         */
        return null;
    }
    // 还车
    public void returnScooter() {
        /*
            1.
            1. 先找到一个空闲的车位，如果没有空闲的车位了就返回相应的提示信息
            2. 如果有车可以借：闪灯----->计时开始----->是否拿走？----拿走---->该slot设为false---->添加一个Usage----->返回提示信息
                                                       |
                                                       |----没拿走---->返回提示信息
         */
    }
}
