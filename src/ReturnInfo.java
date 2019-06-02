import java.text.ParseException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ReturnInfo extends JFrame {
    private int time = 30;
    ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();
    ArrayList<User> userList = ListJsonSwitch.jsonToUser();
    ArrayList<Usage> usageList = ListJsonSwitch.jsonToUsage();
    Station stationA = new Station();
    int check = 1;
    JFrame jf = new JFrame();
    JPanel p1 = new JPanel();

    JLabel l1 = new JLabel("Please Return Your Scooter Quickly!");
    JLabel l3 = new JLabel("30");

    JButton b1 = new JButton("<");//锟斤拷锟剿硷拷
    JButton b2 = new JButton(">");//前锟斤拷锟斤拷
    JButton b3 = new JButton("Return");
    Thread t = new Thread(new MyThread());
    //StationGUI newgui=new StationGUI();
    public int number1;


    public ReturnInfo(int availableSlot, String QMID, int name) {
        this.number1 = name;
        StationGUI newgui = new StationGUI(name);
        newgui.t1.setEditable(false);
        newgui.back.setEnabled(false);
        newgui.confirm.setEnabled(false);
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

        b1.setBounds(0, 0, 20, 20);
        b2.setBounds(20, 0, 20, 20);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(54, 253, 222, 80);
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setFont(new Font("微软雅黑", Font.BOLD, 99));
        l3.setBounds(54, 27, 222, 216);
        b3.setBounds(54, 383, 222, 50);
        l3.setBorder(null);

        p1.add(l1);
        p1.add(l3);
        //p1.add(back);
        //p1.add(confirm);
        p1.add(b3);

        jf.getContentPane().add(p1);

        t.start();
        //t.join();

        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                t.stop();//使锟斤拷Thread.stop()锟斤拷锟斤拷锟斤拷锟斤拷莶锟酵拷锟斤拷锟斤拷锟斤拷锟斤拷锟皆疵伙拷锟绞憋拷乇盏锟轿ｏ拷眨锟斤拷锟斤拷锟接︼拷貌锟斤拷锟�
                //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//锟斤拷锟斤拷锟斤拷锟节革拷式
                //System.out.println(df.format(new Date()));// new Date()为锟斤拷取锟斤拷前系统时锟斤拷
                for (int i = 0; i < 8; i++) {
                    stationA.setLight(i, false);
                }

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
                            try {
                                usage.calUsageTime();
                                usage1 = usage;
                            } catch (ParseException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }

                        }

                    }
                }

                for (User user : userList) {
                    if (user.getQMNo().equals(QMID)) {
                        if (Integer.parseInt(usage1.getUsageTime()) > 0) {
                            usage1.setFineStatus(true);
                            user.setFineOrNot(true);
                            user.setpaystatus(false);
                        } else {
                            user.setFineOrNot(false);
                            user.setpaystatus(false);
                        }
                    }
                }

                ListJsonSwitch.UsageToJson(usageList);
                ListJsonSwitch.UserToJson(userList);
                jf.dispose();

                //锟斤拷时锟斤拷锟斤拷usage锟斤拷息锟斤拷station锟斤拷息锟斤拷user锟斤拷息

            }

        });

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }


    class MyThread implements Runnable {
        public void run() {
            while (time > 0) {
                time--;
                l3.setText(time + "");
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            if (time == 0) {
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

