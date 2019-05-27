import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


/**Return GUI
 * This is a GUI interface for users 
 * when they want to return a scooter from the station
 * it can inform the information and the countdown
 * 
 * version 2.0
 * @author Cong Li
 */
public class ReturnInfo extends JFrame {
    private int time = 30;
    public int number1;
    // the array list of station, user and usage
    ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();
    ArrayList<User> userList = ListJsonSwitch.jsonToUser();
    ArrayList<Usage> usageList = ListJsonSwitch.jsonToUsage();
    Station stationA = new Station();
    int check = 1;
    JFrame jf = new JFrame();
    JPanel p1 = new JPanel();

    JLabel l1 = new JLabel("Please Return Your Scooter Quickly!");
    JLabel l3 = new JLabel("30");

    JButton b3 = new JButton("Return");
    Thread t = new Thread(new MyThread());
     
    /**
     * Constructor
     * @param availableSlot 
     * @param QMID 
     * @param name 
     * the integer of the number of available slot, the string of QMID and the integer of station name
     */
    public ReturnInfo(int availableSlot, String QMID, int name) {
        this.number1 = name;
        StationGUI newgui = new StationGUI(name);
        newgui.t1.setEditable(false);
        newgui.back.setEnabled(false);
        newgui.confirm.setEnabled(false);
        //judge which the station you choose
        if (name == 0) {
            stationA = stationList.get(0);
        } else if (name == 1) {
            stationA = stationList.get(1);
        } else {
            stationA = stationList.get(2);

        }

        jf.setSize(348, 500);
        jf.setLocation(300, 0);

        p1.setLayout(null);

        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(54, 253, 222, 80);
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setFont(new Font("微软雅黑", Font.BOLD, 99));
        l3.setBounds(54, 27, 222, 216);
        b3.setBounds(54, 383, 222, 50);
        l3.setBorder(null);

        p1.add(l1);
        p1.add(l3);
        p1.add(b3);

        jf.getContentPane().add(p1);
        // and the thread to execute the count down
        
        Thread t = new Thread(new MyThread());
        t.start();

        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                t.stop();
                for (int i = 0; i < 8; i++) {
                    stationA.setLight(i, false);
                }
                
                //update to the usagelist and userlist
                stationA.setSlot(availableSlot, true);
                if (number1 == 0) {
                    stationA.setStationName('A');
                } else if (number1 == 1) {
                    stationA.setStationName('B');
                } else if (number1 == 2) {
                    stationA.setStationName('C');
                }
                stationList.set(number1, stationA);

                ListJsonSwitch.StationToJson(stationList);
                newgui.jf.dispose();
                StationGUI newgui1 = new StationGUI(name);
                Usage usage1 = new Usage();
                JOptionPane.showMessageDialog(null, "Return Successfully!!", "PickupInfo", JOptionPane.PLAIN_MESSAGE);
                
                //set the usage QMID. return time, return station
                for (Usage usage : usageList) {
                    if (usage.getUserQMNo().equals(QMID)) {
                        if (usage.getReturnTime() == null) {
                            usage.setReturnTime();
                            char str;
                            if (number1 == 0) {
                                str = 'A';
                            } else if (number1 == 1) {
                                str = 'B';
                            } else {
                                str = 'C';
                            }
                            usage.setReturnStation(str);                           
                            usage.calUsageTime();
                            usage1 = usage;
                          

                        }

                    }
                }

                //set the user fine and pay status and set the minutes to get the fine
                for (User user : userList) {
                    if (user.getQMNo().equals(QMID)) {
                        if (Integer.parseInt(usage1.getUsageTime()) > 3) {
                            usage1.setFineStatus(true);
                            user.setFineOrNot(true);
                            user.setPayStatus(false);
                        } else {
                            user.setFineOrNot(false);
                            user.setPayStatus(false);
                        }
                    }
                }

                ListJsonSwitch.UsageToJson(usageList);
                ListJsonSwitch.UserToJson(userList);
                jf.dispose();

             
            }

        });

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    /**Inner class to realize the thread
     * It can count down the 30s unless you press the button
     * 
     */
    class MyThread implements Runnable {
        public void run() {
            while (time > 0) {
                time--;
                l3.setText(time + "");
                try {
                    Thread.sleep(1000);//1s

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            if (time == 0) {
            	// update to the station
                for (int i = 0; i < 8; i++) {
                    stationA.setLight(i, false);
                }
                stationList.set(number1, stationA);
                ListJsonSwitch.StationToJson(stationList);
                StationGUI newgui1 = new StationGUI(number1);
                JOptionPane.showMessageDialog(null, "Time Out!", "PickupInfo", JOptionPane.PLAIN_MESSAGE);
                jf.dispose();
            }

        }
    }

}

