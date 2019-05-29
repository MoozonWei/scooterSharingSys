import java.util.ArrayList;
import java.util.regex.Pattern;


public class ManSysOp {

    public static String checkManagerLogin(ArrayList<Manager> managerArrayList, String ID, String passwd){
        for (Manager manager : managerArrayList) {
        	System.out.println(manager.getID());
            if(manager.getID().equals(ID)){
                if(manager.getPasswd().equals(passwd))
                    return "Login successful!";                        // �ҵ�ID��������ȷ
                else
                    return "Wrong password!";                       // �ҵ�ID���������
            }
        }
        return "ID not found!";                                   // û�ҵ�ID
    }
    
    public static boolean checkID(String QMID,ArrayList<Usage> usageList) {
    	boolean judge=true;
    	System.out.println(QMID);
    	for(Usage usage:usageList) {
    		System.out.println(usage.getUserQMNo());
    		if(usage.getUserQMNo().equals(QMID)) {
    			judge=true;
    			break;
    			
    			
    		}
    		else
    			judge=false;
    	}
    	return judge;
    	
    }
 // add a user
    public static String addUser(String QMID,String fname,String lname,String email,boolean identity,ArrayList<User> userList){
        /*
            1. ���������QMNo�ڲ���ѧУ��ϵͳ�У�������AllPpInSchl��ArrayList�����������UI��ʾ�����Ϣ
            2. ������������ǲ��Ƿ����������
            3. �����м�鶼ͨ��֮�󴴽�һ���µ�User�࣬Ȼ������ӵ���Ϣд���ѧ��ԭ�е���Ϣд����࣬��󷵻�����´�������
         */
    	if(QMID.isEmpty()||fname.isEmpty()||lname.isEmpty()||email.isEmpty()) {
			return "Please don't have any blanks. ";                           //��������пյ�
		}
		if(Pattern.matches("[0-9]{9}", QMID)==false ) {
			return "Please enter your QMID in right format (9 digits).";       //QMID���Ǿ�λ����
		}
		for(User user : userList) {
			if(user.getQMNo().equals(QMID)){
                    return "You have already been registed.";                  //��QMID��ע��       
            }
		}
		if(Pattern.matches(".*@.*", email)==false) {
			return "Please enter your email address in right format.";         //��������ʽ
		}
		userList.add(new User(QMID,fname,lname,email,identity));
		return "Add user successfully!";                                       //�ɹ�ע��
    }
    
    
    public static boolean revokeUser(String QMID,ArrayList<User> userList,ArrayList<Usage> usageList) {
    	 /*
        1. ���ж�������QMNo�ǲ���User֮һ��������Ƿ���false������ʧ�ܣ�����ǵ���������²���
        2. ����userArrayList�е�����User���ҵ�ѧ����QMNoһ�µ��û���Ȼ��ɾ������Ȼ�󷵻�true��ʾɾ���ɹ�

        ע�⣺�����userArrayListӦ����һ��ϵͳ��ʼʱ�ͼ��غõ� ȫ�ֱ�������i guess...��
     */
    	boolean judge=true;
        for(User user : userList)
        {
            if(user.getQMNo().equals(QMID))
            {
                
                judge=true;
                userList.remove(user);
               
                break;
                
            }
            else
            	judge=false;
        }
        //��ôɾ������ʹ�ü�¼
        for(Usage usage : usageList)
        {
            if(usage.getUserQMNo().equals(QMID))
            {
                
                judge=true;
                usageList.remove(usage);
                break;
                
            }
            else
            	judge=false;
        }
        return judge;
    	
    }
    //ɾ��ʹ�ü�¼
    
    
    // check station condition
    public static boolean[] stationCondition(Station station, char stationName) {
        /*
            1. �������ж�Ҫ��ѯ�����ĸ���վ
            2. ���ظó�վ�ĳ�λ��Ϣ����������slot[]��
         */
        return null;
    }
    
    // check user usage
    public static ArrayList<Usage> checkUsageByQMNo(ArrayList<Usage> usageArrayList, String QMNo) {
        /*
            1. ����һ���µ�ArrayList result�����洢��Ҫ��ѯ��usage���
            2. ����usageArrayList�е�Ԫ�أ�����Ҫ��ѯ��QMNo����ϵĲ�ѯ���add���´�����ArrayList result��
            3. ���ذ������в�ѯ��Ϣ��ArrayList result
         */
        return null;
    }
    
    //�������ƣ���ѯָ�����ڵ�ʹ�����
    public static ArrayList<Usage> checkUsageByTime(ArrayList<Usage> usageArrayList, String dateInString) {
        /*
            1. ����һ���µ�ArrayList result�����洢��Ҫ��ѯ��usage���
            2. ����usageArrayList�е�Ԫ�أ�����Ҫ��ѯ��ʱ����������ϵĲ�ѯ���add���´�����ArrayList result��
            3. ���ذ������в�ѯ��Ϣ��ArrayList result
         */
        return null;
    }
    
    public static void main(String args[]){
        // test loginCheck()
        Manager manager1 = new Manager("123456", "123456", "Manager", "One");
        Manager manager2 = new Manager("654321", "654321", "Manager", "Two");
        ArrayList<Manager> managerArrayList = new ArrayList<>();
        managerArrayList.add(manager1);
        managerArrayList.add(manager2);
        System.out.println(ManSysOp.checkManagerLogin(managerArrayList,"123456","12345678"));
        System.out.println(ManSysOp.checkManagerLogin(managerArrayList,"87654321","12345678"));
        
        ArrayList<User> userList = new ArrayList<>();
        userList=ListJsonSwitch.jsonToUser();
        System.out.println(userList.toString());
        
        // test addUser()
    }
}
