//package JavaProgram;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
* 
* @author 93754
*
*/

public class ManagerLogin
{
	private JFrame loginFrame = new JFrame("Management System");
	private JLabel welcomeLabel = new JLabel("Welcome to Scooter Managemnet System",JLabel.CENTER);	
	private JLabel addUserLabel =  new JLabel("<HTML><U>Add a User</U></HTML>",JLabel.CENTER);
	private JLabel viewScooterLabel = new JLabel("<HTML><U>Check Scooter Usage</U></HTML>",JLabel.CENTER);
	private JLabel viewUserLabel = new JLabel("<HTML><U>Check User Usage</U></HTML>",JLabel.CENTER);
	private JLabel revokeLabel = new JLabel("<HTML><U>Revoke Consumer</U></HTML>",JLabel.CENTER);
	private JPanel mainPanel = new JPanel(null);
	private JButton back = new JButton("Back");

	public static void main(String []args)
	{
		ManagerLogin managementGUI = new ManagerLogin();
	}

	public ManagerLogin()
	{
		generateFrame();
		
	}
	
	/**
	 * setting the frame attribute and add the components into the frame
	 */
	private void generateFrame()
	{
		loginFrame.setSize(800, 500);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		generateMainPanel();
		loginFrame.getContentPane().add(mainPanel,BorderLayout.CENTER);
		loginFrame.setVisible(true);
		
		//Change the postion of the UI
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
      int w = screensize.width/5;
      int h = screensize.height/5;
      loginFrame.setLocation(w, h);
	}
	
	/**
	 * add the components into the main panels
	 */
	private void generateMainPanel()
	{
		addActionListeners();
		settingColors();
		settingBounds();
		mainPanel.add(welcomeLabel);
		mainPanel.add(addUserLabel);
		mainPanel.add(viewScooterLabel);
		mainPanel.add(viewUserLabel);
		mainPanel.add(revokeLabel);
		mainPanel.add(back);	
	}

	/**
	 * adding actionlisteners
	 */
	private void addActionListeners()
	{
		addUserLabel.addMouseListener(new AddUserListener());
		viewScooterLabel.addMouseListener(new ViewScooterListener());
		viewUserLabel.addMouseListener(new ViewUserListener());
		revokeLabel.addMouseListener(new RevokeListener());
		back.addActionListener(new BackListener());
	}
	
	/**
	 * setting the colors of the label
	 */
	private void settingColors()
	{
		//addUserLabel.setForeground(Color.BLUE);
		//viewScooterLabel.setForeground(Color.BLUE);
		//viewUserLabel.setForeground(Color.BLUE);
		//revokeLabel.setForeground(Color.BLUE);
		
		welcomeLabel.setForeground(Color.BLUE);
		welcomeLabel.setFont(new Font("Dialog", 1, 35));
		addUserLabel.setFont(new Font("Dialog", 1, 20));
		viewScooterLabel.setFont(new Font("Dialog", 1, 20));
		viewUserLabel.setFont(new Font("Dialog", 1, 20));
		revokeLabel.setFont(new Font("Dialog", 1, 20));
		
	}
	
	/**
	 * setting the bounds
	 */
	private void settingBounds()
	{
		welcomeLabel.setBounds(0,20 ,800, 100);
		addUserLabel.setBounds(150, 110, 400, 130);
		viewScooterLabel.setBounds(160,160,400,130);
		viewUserLabel.setBounds(150, 210, 400, 130);
		revokeLabel.setBounds(150, 260, 400, 130);
		
		back.setSize(80,30);
      back.setLocation(10,10);	
	}
	
	class AddUserListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			loginFrame.dispose();
			// ���������û�����
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
	
	class ViewScooterListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			loginFrame.dispose();
			new ScooterUsage();
			//���ò鿴scooter��Ϣ����
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
	
	class ViewUserListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//���ò鿴�û���Ϣ����
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
	
	class RevokeListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			loginFrame.dispose();
			new Revoke();
			// TODO Auto-generated method stub
			//���ó����û�����
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
	
	class BackListener implements ActionListener
	{
     public void actionPerformed(ActionEvent e) {
     if(e.getSource()==back)
	   {
	       loginFrame.dispose();
       //function choose
		   mangerlogin ml=new mangerlogin();
     }
  }
	}
	
	
}
