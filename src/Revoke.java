//package JavaProgram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Revoke extends JFrame {
	
  JFrame jf = new JFrame(); 
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	
	JTextField t1 = new JTextField("");
	JLabel l1 = new JLabel("Revoke Awount");
	JLabel l2 = new JLabel("QMID:");
	JButton b3 = new JButton("Confirm");
	JButton b1 = new JButton("Back");
	ArrayList<User> userList = new ArrayList<>();
	ArrayList<Usage> usageList = ListJsonSwitch.jsonToUsage();
	//�ò���ɾ��ʹ�ü�¼ yes
	
	
public Revoke() {
	 
	 userList=ListJsonSwitch.jsonToUser();
	 GridLayout gl = new GridLayout(3,1);
	 jf.setLayout(gl); 
	 jf.setSize(500,300);
	 jf.setLocation(300,200); 
	 
	 l1.setBounds(200,30,100,40);
	 l2.setBounds(125,30,50,40);
	 t1.setBounds(175,30,200,40);
	 b3.setBounds(200,30,100,40);
	 
	 b1.setSize(80,30);
   b1.setLocation(10,10);	
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
	 
	 jf.add(p1);
	 jf.add(p2);
	 jf.add(p3);
	 
	 
	 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 jf.setVisible(true);
	
}

	public static void main(String[] args) {
		Revoke mygui=new Revoke();
		
	}
	
	   class BackListener implements ActionListener
	{
     public void actionPerformed(ActionEvent e) {
     if(e.getSource()==b1)
	   {
	       jf.dispose();
       //function choose
		   ManagerLogin ml=new ManagerLogin();
     }
     else if(e.getSource().equals(b3)) {
  		boolean check=ManSysOp.revokeUser(t1.getText(), userList,usageList);
  		String str=null;
  		if(check==true) {
  			str="revoke successfully!";
  		}
  		else
  			str="The ID does not exist!";
  		JOptionPane.showMessageDialog(null, str,"Revoke customer",JOptionPane.PLAIN_MESSAGE);  
  		
  		ListJsonSwitch.UserToJson(userList);
  		ListJsonSwitch.UsageToJson(usageList);
  		
       } 
     }
	}
	
	

}
