import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**Scooter usage GUI
 * This is a GUI interface for managers to check scooter usage
 * 
 * version 2.0
 * @author Minghao Hu
 */

public class ScooterUsage extends JFrame {

    JFrame jf = new JFrame();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel(new GridLayout(5, 3));
    JButton b1 = new JButton("Back");
    ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();

    JLabel upper_left = new JLabel("");
    JLabel check_scooter_usage = new JLabel("Check Scooter Usage");
    JLabel no_of_available_scooters = new JLabel("No. of Avalible Scooters");
    JLabel no_of_empty_slots = new JLabel("No. of Empty Slots");
    JLabel station_a = new JLabel("Station A");
    JLabel station_b = new JLabel("Station B");
    JLabel station_c = new JLabel("Station C");
    JLabel total = new JLabel("Total");
    JLabel aa = new JLabel("");
    JLabel ae = new JLabel("");
    JLabel ba = new JLabel("");
    JLabel be = new JLabel("");
    JLabel ca = new JLabel("");
    JLabel ce = new JLabel("");
    JLabel ta = new JLabel("");
    JLabel te = new JLabel("");

    /**
     * Constructor
     * set the layout, size and bound 
     */
    public ScooterUsage() {

        jf.setSize(550, 326);
        jf.setLocation(300, 0);
        p1.setBounds(0, 0, 533, 70);
        p2.setBounds(10, 80, 523, 206);
        check_scooter_usage.setFont(new Font("΢���ź�", Font.BOLD, 25));
        check_scooter_usage.setHorizontalAlignment(SwingConstants.CENTER);
        check_scooter_usage.setBounds(0, 0, 533, 70);
        p1.setLayout(null);
        jf.getContentPane().setLayout(null);
        upper_left.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        upper_left.setHorizontalAlignment(SwingConstants.CENTER);
        
        // set the scooter and slot label font and border
        upper_left.setBorder(BorderFactory.createLineBorder(Color.black));
        no_of_available_scooters.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        no_of_available_scooters.setHorizontalAlignment(SwingConstants.CENTER);
        no_of_available_scooters.setBorder(BorderFactory.createLineBorder(Color.black));
        no_of_empty_slots.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        no_of_empty_slots.setHorizontalAlignment(SwingConstants.CENTER);
        no_of_empty_slots.setBorder(BorderFactory.createLineBorder(Color.black));
        station_a.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        station_a.setHorizontalAlignment(SwingConstants.CENTER);
        station_a.setBorder(BorderFactory.createLineBorder(Color.black));
        station_b.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        station_b.setHorizontalAlignment(SwingConstants.CENTER);
        station_b.setBorder(BorderFactory.createLineBorder(Color.black));
        station_c.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        station_c.setHorizontalAlignment(SwingConstants.CENTER);
        station_c.setBorder(BorderFactory.createLineBorder(Color.black));
        total.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        total.setHorizontalAlignment(SwingConstants.CENTER);
        total.setBorder(BorderFactory.createLineBorder(Color.black));
        aa.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        aa.setHorizontalAlignment(SwingConstants.CENTER);
        aa.setBorder(BorderFactory.createLineBorder(Color.black));
        ae.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        ae.setHorizontalAlignment(SwingConstants.CENTER);
        ae.setBorder(BorderFactory.createLineBorder(Color.black));
        ba.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        ba.setHorizontalAlignment(SwingConstants.CENTER);
        ba.setBorder(BorderFactory.createLineBorder(Color.black));
        be.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        be.setHorizontalAlignment(SwingConstants.CENTER);
        be.setBorder(BorderFactory.createLineBorder(Color.black));
        ca.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        ca.setHorizontalAlignment(SwingConstants.CENTER);
        ca.setBorder(BorderFactory.createLineBorder(Color.black));
        ce.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        ce.setHorizontalAlignment(SwingConstants.CENTER);
        ce.setBorder(BorderFactory.createLineBorder(Color.black));
        ta.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        ta.setHorizontalAlignment(SwingConstants.CENTER);
        ta.setBorder(BorderFactory.createLineBorder(Color.black));
        te.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        te.setHorizontalAlignment(SwingConstants.CENTER);
        te.setBorder(BorderFactory.createLineBorder(Color.black));
        
        // get the three station status
        int count = 0, count1 = 0, count2 = 0;
        Station stationA = stationList.get(0);
        Station stationB = stationList.get(1);
        Station stationC = stationList.get(2);

        // 1---there is a scooter in this slot
        for (int i = 0; i < 8; i++)
            if (stationA.getSlot(i)) count++;
        aa.setText(count + "");
        ae.setText((8 - count) + "");

       // 2---there is a scooter in this slot
        for (int i = 0; i < 8; i++)
            if (stationB.getSlot(i)) count1++;
        ba.setText(count1 + "");
        be.setText((8 - count1) + "");

        // 3---there is a scooter in this slot
        for (int i = 0; i < 8; i++)
            if (stationC.getSlot(i)) count2++;
        ca.setText(count2 + "");
        ce.setText((8 - count2) + "");

        ta.setText((count + count1 + count2) + "");
        te.setText((24 - count - count1 - count2) + "");


        p1.add(check_scooter_usage);
        p2.add(upper_left);
        p2.add(no_of_available_scooters);
        p2.add(no_of_empty_slots);
        p2.add(station_a);
        p2.add(aa);
        p2.add(ae);
        p2.add(station_b);
        p2.add(ba);
        p2.add(be);
        p2.add(station_c);
        p2.add(ca);
        p2.add(ce);
        p2.add(total);
        p2.add(ta);
        p2.add(te);

        jf.getContentPane().add(p1);
        jf.getContentPane().add(p2);

        ListJsonSwitch.StationToJson(stationList);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        b1.setFont(new Font("΢���ź�", Font.PLAIN, 12));

        p1.add(b1);
        b1.setSize(80, 30);
        b1.setLocation(10, 10);
        b1.addActionListener(new BackListener());


    }


    public static void main(String[] args) {
    	ScooterUsage scooterUsage = new ScooterUsage();

    }
 
    /**Inner class to realize the button listener
     * It includes the action perform method
     * when you press the button
     * 
     */
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                jf.dispose();
                //function choose
                ManagerLogin ml = new ManagerLogin();
            }
        }
    }

}
