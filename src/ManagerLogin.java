import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**Manager Login GUI
 * This is a GUI interface for managers to login into the system
 * who can do some operations for the system
 * such as add a user, check station status, check user usage and revoke consumer
 * 
 * version 2.0
 * @author Cong Li, Zihan Wei
 */

public class ManagerLogin {

    private JFrame loginFrame = new JFrame("Management System");
    private JLabel addUserLabel = new JLabel("Add a User", JLabel.CENTER);
    private JLabel viewScooterLabel = new JLabel("Check Station Status", JLabel.CENTER);
    private JLabel viewUserLabel = new JLabel("Check User Usage", JLabel.CENTER);
    private JLabel revokeLabel = new JLabel("Revoke Consumer", JLabel.CENTER);
    private JPanel mainPanel = new JPanel(null);
    private JButton back = new JButton("Back");

    public static void main(String[] args) {
        ManagerLogin w = new ManagerLogin();
    }

    /**
     * Constructor
     */
    public ManagerLogin() {
        generateFrame();
    }

    /**
     * method to generate a frame for UI
     */
    private void generateFrame() {
        loginFrame.setSize(282, 364);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
        generateMainPanel();
        loginFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        loginFrame.setVisible(true);

        //Change the postion of the UI
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = screensize.width / 5;
        int h = screensize.height / 5;
        loginFrame.setLocation(w, h);
    }
    
    /**
     * method to generate a main panel for UI
     */
    private void generateMainPanel() {
        addActionListeners();
        settingColors();
        settingBounds();
        mainPanel.add(addUserLabel);
        mainPanel.add(viewScooterLabel);
        mainPanel.add(viewUserLabel);
        mainPanel.add(revokeLabel);
        mainPanel.add(back);
    }
    /**
     * method to add listeners for the events
     */
    private void addActionListeners() {
        addUserLabel.addMouseListener(new AddUserListener());
        viewScooterLabel.addMouseListener(new ViewScooterListener());
        viewUserLabel.addMouseListener(new ViewUserListener());
        revokeLabel.addMouseListener(new RevokeListener());
        back.addActionListener(new BackListener());
    }
    
    /**
     * method to set colors for the labels
     */

    private void settingColors() {
        addUserLabel.setFont(new Font("Dialog", 1, 20));
        viewScooterLabel.setFont(new Font("Dialog", 1, 20));
        viewUserLabel.setFont(new Font("Dialog", 1, 20));
        revokeLabel.setFont(new Font("Dialog", 1, 20));

    }
    
    /**
     * method to set bounds for the labels
     */
    private void settingBounds() {
        addUserLabel.setBounds(10, 56, 244, 39);
        viewScooterLabel.setBounds(10, 129, 244, 39);
        viewUserLabel.setBounds(10, 204, 244, 39);
        revokeLabel.setBounds(10, 278, 244, 39);

        back.setSize(80, 30);
        back.setLocation(10, 10);
    }
    
    /**Inner class to realize the mouse listener
     * It includes the mouse click, press and other event methods
     * for the add user block
     * 
     */
    class AddUserListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            loginFrame.dispose();
            new AddUser();

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            addUserLabel.setForeground(Color.RED);

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            addUserLabel.setForeground(Color.BLUE);

        }

    }

    /**Inner class to realize the mouse listener
     * It includes the mouse click, press and other event methods
     * for the check scooter usage block
     * 
     */
    class ViewScooterListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            loginFrame.dispose();
            new ScooterUsage();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            viewScooterLabel.setForeground(Color.RED);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            viewScooterLabel.setForeground(Color.BLUE);

        }

    }

    /**Inner class to realize the mouse listener
     * It includes the mouse click, press and other event methods
     * for the check user usage block
     * 
     */
    class ViewUserListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            loginFrame.dispose();
            new UserUsage();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            viewUserLabel.setForeground(Color.RED);

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            viewUserLabel.setForeground(Color.BLUE);

        }

    }

    
    /**Inner class to realize the mouse listener
     * It includes the mouse click, press and other event methods
     * for the revoke user block
     * 
     */
    class RevokeListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            loginFrame.dispose();
            new Revoke();
            // TODO Auto-generated method stub
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            revokeLabel.setForeground(Color.RED);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            revokeLabel.setForeground(Color.BLUE);

        }

    }

    /**Inner class to realize the event listener
     * for the back button
     * 
     */
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                loginFrame.dispose();
                mangerlogin mangerlogin = new mangerlogin();
            }
        }
    }

}
