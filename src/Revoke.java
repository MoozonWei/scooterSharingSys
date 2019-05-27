import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**Revoke user GUI
 * This is a GUI interface for managers to revoke user
 * for the input QMID
 * 
 * version 2.0
 * @author Minghao Hu
 */
public class Revoke extends JFrame {

    JFrame jf = new JFrame();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    JTextField t1 = new JTextField("");
    JLabel l1 = new JLabel("Revoke Account");
    JLabel l2 = new JLabel("QMID:");
    JButton b3 = new JButton("Confirm");
    JButton b1 = new JButton("Back");
    ArrayList<User> userArrayList = ListJsonSwitch.jsonToUser();
    ArrayList<Usage> usageArrayList = ListJsonSwitch.jsonToUsage();

    /**
     * Constructor
     * set the layout, size and bound 
     */
    public Revoke() {

    	GridLayout gl = new GridLayout(3, 1);
        jf.getContentPane().setLayout(gl);
        jf.setSize(500, 300);
        jf.setLocation(300, 200);
        l1.setFont(new Font("΢���ź�", Font.BOLD, 25));
        l1.setHorizontalAlignment(SwingConstants.CENTER);

        l1.setBounds(0, 0, 492, 90);
        l2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        l2.setBounds(125, 30, 50, 40);
        t1.setBounds(175, 30, 200, 40);
        b3.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        b3.setBounds(200, 30, 100, 40);
        b1.setFont(new Font("΢���ź�", Font.PLAIN, 12));

        b1.setSize(80, 30);
        b1.setLocation(10, 10);
        b1.addActionListener(new BackListener());
        b3.addActionListener(new BackListener());

        p1.setLayout(null);
        p2.setLayout(null);
        p3.setLayout(null);

        p1.add(l1);
        p1.add(b1);
        p2.add(l2);
        p2.add(t1);
        p3.add(b3);

        jf.getContentPane().add(p1);
        jf.getContentPane().add(p2);
        jf.getContentPane().add(p3);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        Revoke revoke = new Revoke();
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
            } else if (e.getSource().equals(b3)) {
            	// check if the user exists
                boolean check = ManSysOp.revokeUser(t1.getText(), userArrayList);
                String str = null;
                if (check == true) {
                    str = "revoke successfully!";
                } else
                    str = "The ID does not exist!";
                JOptionPane.showMessageDialog(null, str, "Revoke customer", JOptionPane.PLAIN_MESSAGE);

                ListJsonSwitch.UserToJson(userArrayList);
                ListJsonSwitch.UsageToJson(usageArrayList);

            }
        }
    }


}
