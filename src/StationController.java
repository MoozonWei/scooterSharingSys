import java.util.ArrayList;

public class StationController {
    // ���
    /*
        �˴���Ϊ�������֣���һ���֣����ˢ���û��Ƿ��ǿ��Խ賵���û����ڶ����ּ��ˢ�������Ƿ��з��δ����
        1. ����userArrayList��Ѱ���Ƿ���������QMNoһ�µ��û������û�з�����Ӧ��Ϣ����ʾ���û�����userArrayList��
        2. ���ż����û���user.fineOrNot��ֵ��true����false
        3. false��������Ϣ��ʾ���û����з���δ��
        4. true�� ���ű���usageArrayList��Ѱ����û��returnTimeΪnull��ѧ�ŵ���QMNo�ļ�¼���������û���һ������û����
        5. �У�   ������Ϣ��ʾ����һ�ſ�����������Ҳ���Լ���С������ʾ��һ������ʹ��ʱ�䣩
        6. �ޣ�   ��ʾ���û�������Ч�û�����û�з����¼��Ҳû���ڽ������----->���Խ賵�����pickUpScooter()ʹ�ã�
     */	
    public static boolean userChecking(ArrayList<User> userArrayList, String QMNo) {
        for(User user : userArrayList) {
            if(user.getQMNo().equals(QMNo))
                return true;
        }
        return false;
    }

    public static boolean pickUpFineChecking(ArrayList<User> userArrayList, String QMNo) {
        for(User user : userArrayList) {
            if(user.getQMNo().equals(QMNo)) {
                if(user.isFineOrNot())
                    return true;
            }
        }
        return false;
    }

    public static boolean returnFineChecking(ArrayList<Usage> usageArrayList, String QMNo) {
        for(Usage usage : usageArrayList) {
            if(usage.getUserQMNo().equals(QMNo)) {
                if(usage.getReturnTime() == null)
                    return false;                        // there isn't any un-return scooter
            }
        }
        return true;
    }

    public static boolean usageChecking(ArrayList<Usage> usageArrayList, String QMNo) {
        for(Usage usage : usageArrayList) {
            if(usage.getUserQMNo().equals(QMNo)) {
            	
            		 if(usage.getReturnTime() == null)
                         return true;  
            	
                                     // there is a un-return scooter
            }
        }
        return false;                                   // there isn't any un-return scooter
    }

    public static int unfinishedUsage(ArrayList<Usage> usageArrayList, String QMNo) {
        for(Usage usage : usageArrayList) {
            if(usage.getUserQMNo().equals(QMNo)) {
                if(usage.getReturnTime() == null)
                    return usageArrayList.indexOf(usage);
            }
        }
        return -1;
    }

    // ȡ��
    /*
        1. ��һ�����еĳ������û�п��Խӵĳ��˾ͷ�����Ӧ����ʾ��Ϣ
        2. ����г����Խ裺����----->��ʱ��ʼ----->�Ƿ����ߣ�----����---->��slot��Ϊfalse---->���һ��Usage----->������ʾ��Ϣ
                                                       |
                                                       |----û����---->������ʾ��Ϣ
    */
    
    public static boolean pickUpScooter(String QMNo, Station station, ArrayList<Usage> usageArrayList) {
        long beginTime = System.currentTimeMillis();//��ʼʱ��
        long overTime = 60 * 1000;//����ʱ��
        char stationName = station.getStationName();

        int availableSlot = station.gvMeAScooter();
        if (availableSlot >= 0 && availableSlot < 8) {
            station.setLight(availableSlot, true);             // �ڿ���ȡ����λ������
            // ��ʱ��
            while(true) {
                long nowTime = System.currentTimeMillis();
                if((nowTime - beginTime) > overTime){
                    station.setLight(availableSlot, false);
                    return false;
                }
                else if(station.getSlot(availableSlot)) {
                    Usage usage = new Usage(QMNo, stationName);
                    usage.setPiTime();
                    usageArrayList.add(usage);
                    station.setLight(availableSlot, false);
                    station.setSlot(availableSlot, false);
                    return true;
                }
            }
        }
        return false;
    }

    // ����
    /*
        1. ���ҵ�һ�����еĳ�λ�����û�п��еĳ�λ�˾ͷ�����Ӧ����ʾ��Ϣ
        2. ����г����Խ裺����----->��ʱ��ʼ----->�Ƿ�����/��----����---->��slot��Ϊfalse---->���һ��Usage----->������ʾ��Ϣ
                                                   |
                                                   |----û����---->������ʾ��Ϣ
    */
    public static boolean returnScooter(String QMNo, Station station, ArrayList<Usage> usageArrayList) {
        long beginTime = System.currentTimeMillis();//��ʼʱ��
        long overTime = 60 * 1000;//����ʱ��
        char stationName = station.getStationName();

        int availableSlot = station.gvAnEmptySlot();
        if (availableSlot >= 0 && availableSlot < 8) {
            station.setLight(availableSlot, true);             // �ڿ��Ի�����λ������
            // ��ʱ��
            while(true) {
                long nowTime = System.currentTimeMillis();
                if((nowTime - beginTime) > overTime){
                    station.setLight(availableSlot, false);
                    return false;
                }
                else if(!station.getSlot(availableSlot)) {
                    int unfinishedIndex = unfinishedUsage(usageArrayList, QMNo);
                    usageArrayList.get(unfinishedIndex).setReturnTime();
                    usageArrayList.get(unfinishedIndex).setReturnStation(stationName);
                    station.setLight(availableSlot, false);
                    station.setSlot(availableSlot, true);
                    return true;
                }
            }
        }
        return false;
    }
}
