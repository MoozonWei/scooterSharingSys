import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class PickupInfo extends JFrame {

    private int time = 30;
    ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();
    ArrayList<User> userList = ListJsonSwitch.jsonToUser();
    ArrayList<Usage> usageList = ListJsonSwitch.jsonToUsage();
    Station stationA;
    JFrame jf = new JFrame();
    JPanel p1 = new JPanel();

    JLabel l1 = new JLabel("Please Pick Up Your Scooter Quickly!");
    JLabel l3 = new JLabel();

    JButton b1 = new JButton("<");
    JButton b2 = new JButton(">");
    JButton b3 = new JButton("Pick Up");

    private int number2;


    public PickupInfo (int availableSlot, String QMID, int name) {
        this.number2 = name;
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

        jf.setSize(334, 500);
        jf.setLocation(300, 0);

        p1.setLayout(null);

        b1.setBounds(0, 0, 20, 20);
        b2.setBounds(20, 0, 20, 20);
        l1.setBounds(55, 247, 300, 100);
        l3.setText("30");
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 99));
        l3.setBounds(55, 10, 200, 201);
        b3.setBounds(55, 357, 200, 50);
        l3.setBorder(null);

        p1.add(l1);
        p1.add(l3);
        p1.add(b3);

        jf.getContentPane().add(p1);
        Thread t = new Thread(new MyThread());
        t.start();

        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                t.stop();
                for (int i = 0; i < 8; i++) {
                    stationA.setLight(i, false);
                }

                stationA.setSlot(availableSlot, false);
                if (number2 == 0) {
                    stationA.setStationName('A');
                } else if (number2 == 1) {
                    stationA.setStationName('B');
                } else if (number2 == 2) {
                    stationA.setStationName('C');
                }
                stationList.set(number2, stationA);

                ListJsonSwitch.StationToJson(stationList);
                newgui.jf.dispose();
                StationGUI stationGUI = new StationGUI(number2);
                JOptionPane.showMessageDialog(null, "Pickup Successfully!!", "PickupInfo", JOptionPane.PLAIN_MESSAGE);

                Usage usage1 = new Usage();

                usage1.setPiTime();
                usage1.setUserQMNo(QMID);
                char str;
                if (number2 == 0) {
                    str = 'A';
                } else if (number2 == 1) {
                    str = 'B';
                } else {
                    str = 'C';
                }
                usage1.setPickUpStation(str);
                usageList.add(usage1);

                ListJsonSwitch.UsageToJson(usageList);
                ListJsonSwitch.UserToJson(userList);

                jf.dispose();
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
                stationList.set(number2, stationA);
                ListJsonSwitch.StationToJson(stationList);
                StationGUI newgui1 = new StationGUI(number2);
                JOptionPane.showMessageDialog(null, "Time Out!", "PickupInfo", JOptionPane.PLAIN_MESSAGE);
                jf.dispose();
            }

        }
    }
}

