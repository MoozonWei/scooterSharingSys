import java.util.ArrayList;
import java.util.regex.Pattern;


public class ManSysOp {

    /**
     * Check if ID does exist & if the password is correct
     *
     * @param managerArrayList Database
     * @param ID               The input ID
     * @param passwd           The input password
     * @return Prompt message
     */
    public static String checkManagerLogin(ArrayList<Manager> managerArrayList, String ID, String passwd) {
        for (Manager manager : managerArrayList) {
            System.out.println(manager.getID());
            if (manager.getID().equals(ID)) {
                if (manager.getPasswd().equals(passwd))
                    return "Login successful!";
                else
                    return "Wrong password!";
            }
        }
        return "ID not found!";
    }

    /**
     * Check if the QMID exist
     *
     * @param QMID      The input QMID
     * @param usageList Database
     * @return Return true if exist, and return false if not exist
     */
    public static boolean checkID(String QMID, ArrayList<Usage> usageList) {
        boolean judge = true;
        System.out.println(QMID);
        for (Usage usage : usageList) {
            System.out.println(usage.getUserQMNo());
            if (usage.getUserQMNo().equals(QMID)) {
                judge = true;
                break;
            } else
                judge = false;
        }
        return judge;

    }

    /**
     * Add a user and provide check and prompt message
     *
     * @param QMID     QMID
     * @param fname    First name
     * @param lname    Last name
     * @param email    Email address
     * @param identity Identity
     * @param userList Database
     * @return Prompt message
     */
    public static String addUser(String QMID, String fname, String lname, String email, boolean identity, ArrayList<User> userList) {

        if (QMID.isEmpty() || fname.isEmpty() || lname.isEmpty() || email.isEmpty()) {
            return "Please don't have any blanks.";
        }
        if (Pattern.matches("[0-9]{9}", QMID) == false) {
            return "Please enter your QMID in right format (9 digits).";
        }
        for (User user : userList) {
            if (user.getQMNo().equals(QMID)) {
                return "You have already been registered.";
            }
        }
        if (Pattern.matches(".*@.*", email) == false) {
            return "Please enter your email address in right format.";
        }
        userList.add(new User(QMID, fname, lname, email, identity));
        return "Add user successfully!";
    }

    /**
     * Revoke user
     *
     * @param QMID      QMID
     * @param userList  Database
     * @param usageList Database
     * @return Return true if success & Return false if failed
     */
    public static boolean revokeUser(String QMID, ArrayList<User> userList, ArrayList<Usage> usageList) {
        boolean judge = true;
        for (User user : userList) {
            if (user.getQMNo().equals(QMID)) {

                judge = true;
                userList.remove(user);

                break;

            } else
                judge = false;
        }
        for (Usage usage : usageList) {
            if (usage.getUserQMNo().equals(QMID)) {

                judge = true;
                usageList.remove(usage);
                break;

            } else
                judge = false;
        }
        return judge;

    }

    public static void main(String args[]) {
        // test loginCheck()
        Manager manager1 = new Manager("123456", "123456", "Manager", "One");
        Manager manager2 = new Manager("654321", "654321", "Manager", "Two");
        ArrayList<Manager> managerArrayList = new ArrayList<>();
        managerArrayList.add(manager1);
        managerArrayList.add(manager2);
        System.out.println(ManSysOp.checkManagerLogin(managerArrayList, "123456", "12345678"));
        System.out.println(ManSysOp.checkManagerLogin(managerArrayList, "87654321", "12345678"));

        ArrayList<User> userList = new ArrayList<>();
        userList = ListJsonSwitch.jsonToUser();
        System.out.println(userList.toString());

        // test addUser()
    }
}