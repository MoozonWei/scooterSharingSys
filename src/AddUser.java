import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**Add User GUI
 * This is a GUI interface for adding new users 
 * who can enter basic information to register as new users of the system 
 * 
 * version 2.0
 * @author Cong Li, Siyuan He
 */


public class AddUser extends JFrame implements ActionListener, MouseListener {
  private static final long serialVersionUID = 1L;
  private boolean identity;
  public JPanel panel = new JPanel();                        //The panel is to put some components in

  public JLabel regist = new JLabel("     Regist Customer");
  public JLabel Identity = new JLabel("*Identify:");
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

  ArrayList<User> userList = new ArrayList<>(); //the user arraylist
  
  /**
   * Constructor
   */
  public AddUser() {
      /**
       * Initialize the containers and components and set their size and location
       */
     
      userList = ListJsonSwitch.jsonToUser(); //from the json file the class
      
      getContentPane().setLayout(null);
      this.setTitle("Register");
      panel.setBounds(0, 0, 342, 355);
      getContentPane().add(panel);

      panel.setLayout(null);
      regist.setFont(new Font("微软雅黑", Font.BOLD, 24));
      regist.setHorizontalAlignment(SwingConstants.CENTER);
      regist.setBounds(0, 0, 342, 60);
      panel.add(regist);
      Identity.setHorizontalAlignment(SwingConstants.RIGHT);
      Identity.setFont(new Font("微软雅黑", Font.PLAIN, 12));

      Identity.setBounds(22, 70, 68, 30);
      panel.add(Identity);
      QMID.setHorizontalAlignment(SwingConstants.RIGHT);
      QMID.setFont(new Font("微软雅黑", Font.PLAIN, 12));
      QMID.setBounds(22, 120, 68, 30);
      panel.add(QMID);
      Name.setHorizontalAlignment(SwingConstants.RIGHT);
      Name.setFont(new Font("微软雅黑", Font.PLAIN, 12));
      Name.setBounds(22, 170, 68, 30);
      panel.add(Name);
      Email.setHorizontalAlignment(SwingConstants.RIGHT);
      Email.setFont(new Font("微软雅黑", Font.PLAIN, 12));
      Email.setBounds(22, 220, 68, 30);
      panel.add(Email);
      Mobile.setHorizontalAlignment(SwingConstants.RIGHT);
      Mobile.setFont(new Font("微软雅黑", Font.PLAIN, 12));
      Mobile.setBounds(22, 270, 68, 30);
      panel.add(Mobile);
      confirm.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      	}
      });
      confirm.setFont(new Font("微软雅黑", Font.PLAIN, 12));
      confirm.setBounds(117, 318, 120, 30);
      panel.add(confirm);
      jcb1.setFont(new Font("微软雅黑", Font.PLAIN, 12));

      jcb1.setBounds(117, 70, 120, 30);
      panel.add(jcb1);
      jcb1.addActionListener(this);

      qmid.setBounds(117, 120, 120, 30);
      panel.add(qmid);


      fname.setBounds(117, 170, 55, 30);
      panel.add(fname);
      lname.setBounds(182, 170, 55, 30);
      panel.add(lname);

      email.setBounds(117, 220, 120, 30);
      panel.add(email);
      mobile.setBounds(117, 270, 120, 30);
      panel.add(mobile);
      back.setFont(new Font("微软雅黑", Font.PLAIN, 12));

      back.addActionListener(this);
      back.setSize(80, 30);
      back.setLocation(10, 10);
      panel.add(back);

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocation(500, 160);
      this.setSize(350, 385);
      this.setVisible(true);

      /**
       * Add listeners for components
       */
      confirm.addMouseListener(this);
  }

  /**actionevent event
   * When you click the button
   * 
   * @param e actionevent
   */
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

 
  /**mouseclick event
   * When you click the text field
   * 
   * @param  e mouseevent
   */
  public void mouseClicked(MouseEvent e) {

	  /**JOptionPane.PLAIN_MESSAGE
       * When you click the text field
       */
      if (e.getSource().equals(confirm)) {
          String str = ManSysOp.addUser(qmid.getText(), fname.getText(), lname.getText(), email.getText(), identity, userList);
          JOptionPane.showMessageDialog(null, str, "Regist customer", JOptionPane.PLAIN_MESSAGE);
          if (str == "Add user successfully!") {
              System.out.println("save");
              ListJsonSwitch.UserToJson(userList);
              
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

