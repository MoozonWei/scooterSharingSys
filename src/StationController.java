import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StationController {

    /**
     * Check if this QMNo exist in database
     *
     * @param userArrayList Database
     * @param QMNo QMID
     * @return Exist ---- true; Not exist ---- false
     */
    public static boolean userExistChecking(ArrayList<User> userArrayList, String QMNo) {
        for (User user : userArrayList) {
            if (user.getQMNo().equals(QMNo))
                return true;
        }
        return false;
    }

    /**
     * Check if this user has an unpaid fine
     *
     * @param userArrayList
     * @param QMNo
     * @return Yes --- true; No --- false
     */
    public static boolean pickUpFineChecking(ArrayList<User> userArrayList, String QMNo) {
        for (User user : userArrayList) {
            if (user.getQMNo().equals(QMNo)) {
                if (user.isFineOrNot())
                    return true;
            }
        }
        return false;
    }

    /**
     * Check if there is an un-return usage in the database
     *
     * @param usageArrayList Database
     * @param QMNo QMID
     * @return Yes --- true; No --- false
     */
    public static boolean unReturnedUsageChecking(ArrayList<Usage> usageArrayList, String QMNo) {
        for (Usage usage : usageArrayList) {
            if (usage.getUserQMNo().equals(QMNo)) {
                if (usage.getReturnTime() == null)
                    return true;                        // there is a un-return scooter
            }
        }
        return false;                                   // there isn't any un-return scooter
    }

    /**
     * Do all the work when a user pick up a scooter
     *
     * @param QMID QMID
     * @param stationA Station
     * @param stationNumber Station number: 0 --- A; 1 --- B; 2 --- C
     * @param jf JFrame
     */
    public static void pickUpScooter(String QMID, Station stationA, int stationNumber, JFrame jf) {

        ArrayList<Usage> usageArrayList = ListJsonSwitch.jsonToUsage();
        ArrayList<Station> stationArrayList = ListJsonSwitch.jsonToStation();
        ArrayList<User> userArrayList = ListJsonSwitch.jsonToUser();

        int availableSlot = stationA.gvMeAScooter();
        System.out.println(availableSlot);
        if (availableSlot >= 0 && availableSlot < 8) {
            stationA.setLight(availableSlot, true);
            System.out.println(stationA.getLight(availableSlot));
            stationArrayList.set(stationNumber, stationA);
            ListJsonSwitch.StationToJson(stationArrayList);
            ListJsonSwitch.UsageToJson(usageArrayList);
            ListJsonSwitch.UserToJson(userArrayList);
            jf.dispose();

            PickupInfo pickupInfo = new PickupInfo(availableSlot, QMID, stationNumber);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry! There is no available slots,Please try another station", "Pick up Scooter", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Do all the work when a user return a scooter
     *
     * @param QMID QMID
     * @param stationA Station
     * @param stationNumber Station number: 0 --- A; 1 --- B; 2 --- C
     * @param jf JFrame
     */
    public static void returnScooter(String QMID, Station stationA, int stationNumber, JFrame jf) {

        ArrayList<Usage> usageArrayList = ListJsonSwitch.jsonToUsage();
        ArrayList<Station> stationArrayList = ListJsonSwitch.jsonToStation();
        ArrayList<User> userArrayList = ListJsonSwitch.jsonToUser();

        int availableSlot = stationA.gvAnEmptySlot();
        System.out.println(availableSlot);
        if (availableSlot >= 0 && availableSlot < 8) {

            stationA.setLight(availableSlot, true);
            stationArrayList.set(stationNumber, stationA);
            ListJsonSwitch.StationToJson(stationArrayList);
            ListJsonSwitch.UsageToJson(usageArrayList);
            ListJsonSwitch.UserToJson(userArrayList);
            jf.dispose();

            ReturnInfo returnInfo = new ReturnInfo(availableSlot, QMID, stationNumber);

        } else {
            JOptionPane.showMessageDialog(null, "Sorry! There is no empty slots,Please try another station", "Pick up Scooter", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Do all the work when a user has to pay fine
     *
     * @param QMID QMID
     * @param jf JFrame
     */
    public static void payFine(String QMID, JFrame jf) {

        ArrayList<Usage> usageArrayList = ListJsonSwitch.jsonToUsage();
        ArrayList<Station> stationArrayList = ListJsonSwitch.jsonToStation();
        ArrayList<User> userArrayList = ListJsonSwitch.jsonToUser();

        JDialog fine = new JDialog(jf);
        fine.setModal(true);
        fine.setSize(480, 200);
        fine.setLocationRelativeTo(jf);
        fine.setLayout(null);
        JButton pay = new JButton("Pay");
        JLabel label = new JLabel("Please pay the fine so that your account won't be froze.");

        fine.add(pay);
        fine.add(label);
        label.setBounds(60, 20, 400, 30);
        pay.setBounds(200, 80, 80, 40);
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //changing the fined status of user usage
                for (User user : userArrayList) {
                    if (user.getQMNo().equals(QMID)) {
                        user.setFineOrNot(false);
                        user.setPayStatus(true);
                        break;
                    }
                }
                for (Usage usage : usageArrayList) {
                    if (usage.getUserQMNo().equals(QMID)) {
                        if (usage.getFineStatus() == true) {
                            usage.setPayStatus(true);
                            usage.setFineStatus(false);
                            break;
                        }
                    }
                    fine.dispose();
                }
                ListJsonSwitch.UsageToJson(usageArrayList);
                ListJsonSwitch.UserToJson(userArrayList);
            }
        });
        fine.setVisible(true);
        //-----------------------------------FineSystem-----------------------------------//
        JOptionPane.showMessageDialog(null, "The fined has benn payed successfully", "Fine", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Handle most of the logic in StationGUI
     *
     * @param QMID QMID
     * @param stationA Station
     * @param stationNumber Station number: 0 --- A; 1 --- B; 2 --- C
     * @param jf JFrame
     */
    public static void stationInAll(String QMID, Station stationA, int stationNumber, JFrame jf) {

        ArrayList<Usage> usageArrayList = ListJsonSwitch.jsonToUsage();
        ArrayList<Station> stationArrayList = ListJsonSwitch.jsonToStation();
        ArrayList<User> userArrayList = ListJsonSwitch.jsonToUser();

        if (QMID.length() != 9) {
            JOptionPane.showMessageDialog(null, "QMID should be 9 digits!", "Warning", JOptionPane.PLAIN_MESSAGE);
        } else if (!StationController.userExistChecking(userArrayList, QMID)) {
            JOptionPane.showMessageDialog(null, "This QMID doesn't exist!", "Warning", JOptionPane.PLAIN_MESSAGE);
        } else if (!StationController.unReturnedUsageChecking(usageArrayList, QMID)) {
            if (StationController.pickUpFineChecking(userArrayList, QMID) == true) {
                JOptionPane.showMessageDialog(null, "Sorry , you are fined!", "Pick up Scooter", JOptionPane.PLAIN_MESSAGE);
                StationController.payFine(QMID, jf);

            } else {
                StationController.pickUpScooter(QMID, stationA, stationNumber, jf);
            }
        } else {
            StationController.returnScooter(QMID, stationA, stationNumber, jf);
        }

    }
}
