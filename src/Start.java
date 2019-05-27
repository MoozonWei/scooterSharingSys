import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**Add Start GUI
 * This is a GUI interface for the begining
 * for users and managers
 * which can choose the station and for manager to login with correct password and ID
 * 
 * version 2.0
 * @author Qinuo Yao
 */
public class Start {
    public static void main(String[] args) {
        ArrayList<Manager> managerList = new ArrayList<>();
        startUI sUI = new startUI();
    }
}

/**Inner class to realize the action listener
 * It generate the start frame and action performed method
 * for the different buttons 
 *  
 */
class startUI extends JFrame implements ActionListener {
    JPanel mainpanel;
    JFrame frame;
    JButton buttonS1;
    JButton buttonS2;
    JButton buttonS3;
    JButton buttonMSys;

    /**
     * Constructor
     * set the layout, size and bound 
     */
    public startUI() {
        frame = new JFrame();
        mainpanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainpanel.setBackground(Color.darkGray);
        frame.getContentPane().add(BorderLayout.CENTER, mainpanel);
        frame.setSize(184, 377);
        frame.setVisible(true);
        mainpanel.setLayout(null);


        //Change the postion of the UI
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = screensize.width / 5;
        int h = screensize.height / 5;
        frame.setLocation(w, h);

        buttonS1 = new JButton("Station A");
        buttonS2 = new JButton("Station B");
        buttonS3 = new JButton("Station C");
        buttonMSys = new JButton("Manage System");

        buttonS1.addActionListener(this);
        buttonS1.setSize(156, 50);
        buttonS1.setLocation(10, 10);
        mainpanel.add(buttonS1);

        buttonS2.addActionListener(this);
        buttonS2.setSize(156, 50);
        buttonS2.setLocation(10, 70);
        mainpanel.add(buttonS2);

        buttonS3.addActionListener(this);
        buttonS3.setSize(156, 50);
        buttonS3.setLocation(10, 130);
        mainpanel.add(buttonS3);

        buttonMSys.addActionListener(this);
        buttonMSys.setSize(156, 50);
        buttonMSys.setLocation(10, 287);
        mainpanel.add(buttonMSys);
    }

    //the action performed methods for different buttons
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonMSys) {
            frame.dispose();
            mangerlogin ml = new mangerlogin();
        } else if (e.getSource() == buttonS1) {
            frame.dispose();
            StationGUI s = new StationGUI(0);
        } else if (e.getSource() == buttonS2) {
            frame.dispose();
            StationGUI s = new StationGUI(1);
        } else if (e.getSource() == buttonS3) {
            frame.dispose();
            StationGUI s = new StationGUI(2);
        }
    }

}

/**Inner class to realize the action listener
 * It generate the manager login frame and action performed method
 * for the different buttons 
 *  
 */

class mangerlogin extends JFrame implements ActionListener {

	JPanel mainpanel;
    JFrame frame;
    JButton buttonCom;
    JButton back;
    JTextField fieldID;
    JTextField fieldPW;
    ArrayList<Manager> managerList = ListJsonSwitch.jsonToManager();

    /**
     * Constructor
     * set the layout, size and bound 
     */
    public mangerlogin() {

    	frame = new JFrame();
        mainpanel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, mainpanel);
        frame.setSize(400, 300);
        frame.setVisible(true);
        mainpanel.setLayout(null);

        //Change the postion of the UI
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = screenSize.width / 5;
        int h = screenSize.height / 5;
        frame.setLocation(w, h);

        JLabel lblManagerLogin = new JLabel("Manager Login");
        lblManagerLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblManagerLogin.setFont(new Font("΢���ź�", Font.BOLD, 22));
        lblManagerLogin.setSize(372, 37);
        lblManagerLogin.setLocation(20, 43);
        mainpanel.add(lblManagerLogin);

        JLabel label2 = new JLabel("Please enter your ID and password.");
        label2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setSize(372, 25);
        label2.setLocation(15, 74);
        mainpanel.add(label2);

        JLabel label3 = new JLabel("ID:");
        label3.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        label3.setSize(68, 25);
        label3.setLocation(47, 130);
        mainpanel.add(label3);

        JLabel label4 = new JLabel("Password:");
        label4.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        label4.setSize(68, 25);
        label4.setLocation(47, 160);
        mainpanel.add(label4);

        buttonCom = new JButton("Login");
        buttonCom.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        buttonCom.addActionListener(this);
        buttonCom.setSize(100, 30);
        buttonCom.setLocation(140, 200);
        mainpanel.add(buttonCom);

        back = new JButton("Back");
        back.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        back.addActionListener(this);
        back.setSize(80, 30);
        back.setLocation(10, 10);
        mainpanel.add(back);

        fieldID = new JTextField(6);
        fieldID.setSize(150, 25);
        fieldID.setLocation(120, 130);
        mainpanel.add(fieldID);

        fieldPW = new JTextField(6);
        fieldPW.setSize(150, 25);
        fieldPW.setLocation(120, 160);
        mainpanel.add(fieldPW);

    }

    public void actionPerformed(ActionEvent e) {

    	// if the manager press the confirm button
    	if (e.getSource() == buttonCom) {
   
            String str = ManSysOp.checkManagerLogin(managerList, fieldID.getText(), fieldPW.getText());
            JOptionPane.showMessageDialog(null, str, "Manager Login", JOptionPane.PLAIN_MESSAGE);
            if (str == "Login successful!") {
                frame.dispose();
                ListJsonSwitch.ManagerToJson(managerList);
                ManagerLogin managerLogin = new ManagerLogin();
            }
        } 
    	// if the manager press the back button
    	else if (e.getSource() == back) {
            frame.dispose();
            startUI sUI = new startUI();
        }
    }

}
