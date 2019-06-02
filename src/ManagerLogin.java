import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javafx.stage.WindowBuilder;

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

    public ManagerLogin() {
        generateFrame();
    }


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

    private void addActionListeners() {
        addUserLabel.addMouseListener(new AddUserListener());
        viewScooterLabel.addMouseListener(new ViewScooterListener());
        viewUserLabel.addMouseListener(new ViewUserListener());
        revokeLabel.addMouseListener(new RevokeListener());
        back.addActionListener(new BackListener());
    }

    private void settingColors() {
        addUserLabel.setFont(new Font("Dialog", 1, 20));
        viewScooterLabel.setFont(new Font("Dialog", 1, 20));
        viewUserLabel.setFont(new Font("Dialog", 1, 20));
        revokeLabel.setFont(new Font("Dialog", 1, 20));

    }

    private void settingBounds() {
        addUserLabel.setBounds(10, 56, 244, 39);
        viewScooterLabel.setBounds(10, 129, 244, 39);
        viewUserLabel.setBounds(10, 204, 244, 39);
        revokeLabel.setBounds(10, 278, 244, 39);

        back.setSize(80, 30);
        back.setLocation(10, 10);
    }

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

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                loginFrame.dispose();
                mangerlogin mangerlogin = new mangerlogin();
            }
        }
    }

}
