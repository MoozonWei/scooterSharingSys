//package JavaProgram;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class AddUser extends JFrame implements ActionListener, MouseListener {
    private static final long serialVersionUID = 1L;
    private boolean identity;
    public JPanel panel = new JPanel();                        //The panel is to put some components in

    public JLabel regist = new JLabel("Regist Co stomer");
    public JLabel Identify = new JLabel("*Identify:");
    public JLabel QMID = new JLabel("*QMID:");
    public JLabel Name = new JLabel("*Name:");
    public JLabel Email = new JLabel("*Email");
    public JLabel Mobile = new JLabel("*Mobile:");

    public JButton back = new JButton("Back");
    public JButton confirm = new JButton("Confirm");
    String[] ct = {"Student", "Staff"};
    @SuppressWarnings("rawtypes")
    public JComboBox jcb1 = new JComboBox(ct);
    //The text field is to input your answer
    public JTextField qmid = new JTextField(10);
    public JTextField fname = new JTextField(10);
    public JTextField lname = new JTextField(10);
    public JTextField email = new JTextField(10);
    public JTextField mobile = new JTextField(10);

    ArrayList<User> userList = new ArrayList<>();
    //ArrayList<Usage> usageArrayList=new ArrayList<>();

    /**
     * Constructor
     */
    public AddUser() {
        /**
         * Initialize the containers and components and set their size and location
         */
        //JFrame.setSize(900,900);
        userList = ListJsonSwitch.jsonToUser();
        //usageArrayList=ListJsonSwitch.jsonToUsage();

        this.setLayout(null);
        this.setTitle("Regist Customer");
        panel.setBounds(20, 0, 300, 400);
        //panel2.setBounds(0,260,300,200);
        this.add(panel);

        panel.setLayout(null);
        regist.setBounds(100, 20, 260, 30);
        panel.add(regist);

        Identify.setBounds(10, 70, 120, 30);
        panel.add(Identify);
        QMID.setBounds(10, 120, 120, 30);
        panel.add(QMID);
        Name.setBounds(10, 170, 120, 30);
        panel.add(Name);
        Email.setBounds(10, 220, 120, 30);
        panel.add(Email);
        Mobile.setBounds(10, 270, 120, 30);
        panel.add(Mobile);
        confirm.setBounds(80, 320, 120, 30);
        panel.add(confirm);

        jcb1.setBounds(150, 70, 120, 30);
        panel.add(jcb1);
        jcb1.addActionListener(this);

        qmid.setBounds(150, 120, 120, 30);
        panel.add(qmid);


        fname.setBounds(150, 170, 55, 30);
        panel.add(fname);
        lname.setBounds(215, 170, 55, 30);
        panel.add(lname);

        email.setBounds(150, 220, 120, 30);
        panel.add(email);
        mobile.setBounds(150, 270, 120, 30);
        panel.add(mobile);

        back.addActionListener(this);
        back.setSize(80, 30);
        back.setLocation(10, 10);
        panel.add(back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500, 160);
        this.setSize(350, 400);
        this.setVisible(true);

        /**
         * Add listeners for components
         */
        confirm.addMouseListener(this);

    }

    //�ж��û������
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            dispose();
            ManagerLogin managementGUI = new ManagerLogin();
        } else if (e.getSource() == confirm) {
            //function of comfirming
            String item = (String) jcb1.getSelectedItem();
            if (item == "Student")
                identity = false;
            else
                identity = true;
        }

    }


    public void mouseClicked(MouseEvent e) {

        /**JOptionPane.PLAIN_MESSAGE
         * When you click the text field
         */
        if (e.getSource().equals(confirm)) {
            String str = ManSysOp.addUser(qmid.getText(), fname.getText(), lname.getText(), email.getText(), identity, userList);
            JOptionPane.showMessageDialog(null, str, "Regist customer", JOptionPane.PLAIN_MESSAGE);
            if (str == "Add user successfully!") {
                System.out.println("save");
                //usageArrayList.add(new Usage(qmid.getText()));
                ListJsonSwitch.UserToJson(userList);
                //ListJsonSwitch.UsageToJson(usageArrayList);
            }
        }

    }


    public static void main(String[] args) {
        new AddUser();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }


}

