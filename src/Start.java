//package JavaProgram;

import java.awt. *;
import javax.swing. *;
import java.util. *;
import java.awt.event. *;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Start
{
	public static void main (String[] args) {
		ArrayList<Manager> managerList = new ArrayList<>();
		startUI sUI = new startUI();
	}
}

class startUI extends JFrame implements ActionListener{
	JPanel mainpanel;
	JFrame frame;
	JButton buttonS1;
	JButton buttonS2;
	JButton buttonS3;
	JButton buttonMSys;
	
	
	
	public  startUI() {
        frame = new JFrame();
		mainpanel = new JPanel();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainpanel.setBackground(Color.darkGray);
		frame.getContentPane().add(BorderLayout.CENTER, mainpanel);
		frame.setSize(800,500);
		frame.setVisible(true);
		mainpanel.setLayout(null);
		
		
		//Change the postion of the UI
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
      int w = screensize.width/5;
      int h = screensize.height/5;
      frame.setLocation(w, h);
		
		buttonS1 = new JButton("Station A");
		buttonS2 = new JButton("Station B");
		buttonS3 = new JButton("Station C");
	    buttonMSys = new JButton("Manage System");
		
		buttonS1.addActionListener(this);
		buttonS1.setSize(100,50);
      buttonS1.setLocation(120,100);
		mainpanel.add(buttonS1);
		
		buttonS2.addActionListener(this);
		buttonS2.setSize(100,50);
      buttonS2.setLocation(320,100);
		mainpanel.add(buttonS2);
		
		buttonS3.addActionListener(this);
		buttonS3.setSize(100,50);
      buttonS3.setLocation(520,100);
		mainpanel.add(buttonS3);
		
		buttonMSys.addActionListener(this);
		buttonMSys.setSize(200,50);
      buttonMSys.setLocation(270,300);
		mainpanel.add(buttonMSys);
	}
	
	public void actionPerformed(ActionEvent e) {
     if(e.getSource()==buttonMSys)
	   {
  	   frame.dispose();
       mangerlogin ml=new mangerlogin();
       
       
     }
	   else if(e.getSource()==buttonS1)
	   {
       frame.dispose();
       StationGUI s=new StationGUI(0);
     }
	   else if(e.getSource()==buttonS2)
	   {
       frame.dispose();
       StationGUI s=new StationGUI(1);
     }
	   else if(e.getSource()==buttonS3)
	   {
       frame.dispose();
       StationGUI s=new StationGUI(2);
     }
  }
	
}


class mangerlogin extends JFrame implements ActionListener{ 
	JPanel mainpanel;
	JFrame frame;
	JButton buttonCom;
	JButton back;
	JTextField fieldID;
	JTextField fieldPW;
	ArrayList<Manager> managerList = new ArrayList<>();
	
	public mangerlogin() {
		//System.out.println("hyyy");
      frame = new JFrame();
		mainpanel = new JPanel();
		
		managerList=ListJsonSwitch.jsonToManager();
		
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, mainpanel);
		frame.setSize(400,300);
		frame.setVisible(true);
		mainpanel.setLayout(null);
		
		//Change the postion of the UI
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
      int w = screensize.width/5;
      int h = screensize.height/5;
      frame.setLocation(w, h);
		
		JLabel label = new JLabel("-Welcome to Scooter Sharing Management System.-");
		label.setSize(300,25);
      label.setLocation(40,50);
		mainpanel.add(label);
		
		JLabel label2 = new JLabel("Please enter your ID and password.");
		label2.setSize(300,25);
      label2.setLocation(15,90);
		mainpanel.add(label2);
		
		JLabel label3 = new JLabel("ID:");
		label3.setSize(100,25);
      label3.setLocation(15,130);
		mainpanel.add(label3);
		
		JLabel label4 = new JLabel("Password:");
		label4.setSize(100,25);
      label4.setLocation(15,160);
		mainpanel.add(label4);
		
		buttonCom = new JButton("Comfrim");
		buttonCom.addActionListener(this);
		buttonCom.setSize(100,30);
      buttonCom.setLocation(140,200);
		mainpanel.add(buttonCom);
		
		back = new JButton("Back");
		back.addActionListener(this);
		back.setSize(80,30);
      back.setLocation(10,10);
		mainpanel.add(back);
		
		fieldID = new JTextField(6);
		fieldID.setSize(150,25);
      fieldID.setLocation(120,130);
		mainpanel.add(fieldID);
		
		fieldPW = new JTextField(6);
		fieldPW.setSize(150,25);
      fieldPW.setLocation(120,160);
		mainpanel.add(fieldPW);
		
		}
		
		public void actionPerformed(ActionEvent e) {
     if(e.getSource()==buttonCom)
	   {
    	 System.out.println(fieldID.getText());
    	 Object[] options ={ "OK", "NO" };
       String str=ManSysOp.checkManagerLogin(managerList, fieldID.getText(), fieldPW.getText());
       //int m = JOptionPane.showOptionDialog(null, str,"Manager Login" ,JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);


       JOptionPane.showMessageDialog(null, str,"Manager Login",JOptionPane.PLAIN_MESSAGE);  
       if(str=="Login successful!") {
    	   frame.dispose();
           //function choose
    	   ListJsonSwitch.ManagerToJson(managerList);
      	   ManagerLogin Ml = new ManagerLogin();
      	   
       }
  	   
     }
	   else if(e.getSource()==back)
	   {
	       frame.dispose();
       //function choose
		   startUI sUI = new startUI();
     }
  }

}
