import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableColumn;

import JavaProject.PickupInfo.MyThread;
public class ReturnInfo extends JFrame {
	private int time = 30;
	ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();
	ArrayList<User> userList = ListJsonSwitch.jsonToUser();
	ArrayList<Usage> usageList = ListJsonSwitch.jsonToUsage();
	Station stationA=new Station();
	int check=1;
	JPanel p1=new JPanel();
	
	JLabel l1=new JLabel("Please Return Your Scooter Quickly!");
	JLabel l2=new JLabel("Time Remaining");
	JLabel l3=new JLabel("30");
	
	JButton b1 = new JButton("<");//���˼�
	JButton b2 = new JButton(">");//ǰ����
	JButton b3 = new JButton("Return");
	Thread t=new Thread(new MyThread());
	//StationGUI newgui=new StationGUI();
	public int number1;
	
	
	
	public ReturnInfo(int availableSlot,String QMID,int name)  {
		this.number1=name;
		StationGUI newgui=new StationGUI(name);
		newgui.t1.setEditable(false);
		if(name==0) {
			stationA=stationList.get(0);
		}
		else if(name==1) {
			stationA=stationList.get(1);
		}
		else {
			stationA=stationList.get(2);
		
		}
		
		JFrame jf=new JFrame();
		 jf.setSize(800,500);
		 jf.setLocation(300,0); 
		
		 p1.setLayout(null);
		 
		 b1.setBounds(0,0,20,20);
		 b2.setBounds(20,0,20,20);
		 l1.setBounds(290,30,300,100);
		 l2.setBounds(325,100,130,100);
		 l3.setBounds(455, 130, 30, 30);
		 b3.setBounds(300, 230, 200, 50);
		 l3.setBorder(BorderFactory.createLineBorder(Color.black));
		 
		 p1.add(l1);
		 p1.add(l2);
		 p1.add(l3);
		 //p1.add(b1);
		 //p1.add(b2);
		 p1.add(b3);
		 
		 jf.add(p1);
		 
		 t.start();
	     //t.join();
	     
		 b3.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e)
	         {
	        	 
	        	 t.stop();//ʹ��Thread.stop()��������ݲ�ͬ����������Դû��ʱ�رյ�Σ�գ�����Ӧ�ò���
	        	 //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	             //System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
	        	 for(int i=0;i<8;i++) {
	        		 stationA.setLight(i, false);
	        	 }
	        	 
	        	 stationA.setSlot(availableSlot, true);
	        	 if(number1==0) {
	        		 stationA.setStationName('A');
	        	 }
	        	 else if(number1==1) {
	        		 stationA.setStationName('B');
	        	 }
	        	 else if(number1==2) {
	        		 stationA.setStationName('C');
	        	 }
	        	 stationList.set(number1, stationA);
	        	 
	        	 ListJsonSwitch.StationToJson(stationList);
	        	 newgui.jf.dispose();
	        	 StationGUI newgui1=new StationGUI(name);
			     Usage usage1=new Usage();
	        	 JOptionPane.showMessageDialog(null, "Return Successfully!!","PickupInfo",JOptionPane.PLAIN_MESSAGE);
	        	 for(Usage usage:usageList) {
	         		if(usage.getUserQMNo().equals(QMID)) {
	         			if(usage.getReturnTime()==null) {
	         				usage1=usage;
		         			usage.setReturnTime();
		         			char str;
	        	        	 if(number1==0) {
	        	        		 str='A';
	        	        	 }
	        	        	 else if(number1==1) {
	        	        		 str='B';
	        	        	 }
	        	        	 else {
	        	        		 str='C';
	        	        	 }
	        	        	 usage.setReturnStation(str);
		         			try {
								usage.calUsageTime();
								
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		         			
	         			}
	         			
	         		}
	        	 }
	        	
	        	 for(User user:userList) {
      				if(user.getQMNo().equals(QMID)) {
      					if(Integer.parseInt(usage1.getUsageTime())>0) {
      						usage1.setFineStatus(true);
      	      				user.setFineOrNot(true);
      	      				user.setpaystatus(false);
      	      			}
      					else {
      						user.setFineOrNot(false);
      	      				user.setpaystatus(false);
      					}
      				}
	        	 }
      			   
	        	 ListJsonSwitch.UsageToJson(usageList);
	        	 ListJsonSwitch.UserToJson(userList);
	        	 jf.dispose();
	        	 
	        	 //��ʱ����usage��Ϣ��station��Ϣ��user��Ϣ
	        	 
	         }
		        
		 });
		 
		 
//		 public class StopTest2 {
//			    private static AtomicBoolean running = new AtomicBoolean(true);
//
//			    public static void main(String[] args) {
//			        try {
//			            Thread t0 = new Thread(() -> {
//			                while (StopTest2.running.get()) {
//			                    System.out.println("thread->" + Thread.currentThread().getName()
//			                            + " run");
//			                }
//			                System.out.println("thread->" + Thread.currentThread().getName()+  " stop");
//			            });
//
//			            t0.start();
//			            Thread.sleep(1000);
//			            StopTest2.running.set(false);
//			        } catch (Throwable t) {
//			            System.out.println("Caught in main: " + t);
//			            t.printStackTrace();
//			        }
//			    }
//			}
			/*
			thread->Thread-0 run
			thread->Thread-0 run
			thread->Thread-0 run
			thread->Thread-0 run
			thread->Thread-0 run
			thread->Thread-0 run
			thread->Thread-0 stop
			*/

		
		 
		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jf.setVisible(true);
		
	}

	  
	class MyThread implements Runnable 
	{
	   public void run() {
	   while (time > 0)
	   {
	      time--;
	      l3.setText(time + "");
	      try
	         {
	          Thread.sleep(1000); 
	          
	         }
	      catch (Exception e)
	         {
	          e.printStackTrace();
	         }

	   }
	   if(time==0) {
		   //check=0;
		   for(int i=0;i<8;i++) {
      		 stationA.setLight(i, false);
      	 }
		  stationList.set(number1, stationA);
      	 ListJsonSwitch.StationToJson(stationList);
      	 StationGUI newgui1=new StationGUI(number1);
		 JOptionPane.showMessageDialog(null, "Time Out!","PickupInfo",JOptionPane.PLAIN_MESSAGE);
		   
	   }

	   //test.this.dispose();
	   }
	   };
//	public static void main(String[] args) {
//		ReturnInfo myJs2=new ReturnInfo();
//		
//	}
}

