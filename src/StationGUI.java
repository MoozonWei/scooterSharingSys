//package gui;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.TableColumn;

import JavaProject.ReturnInfo.MyThread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;

//GUI�Ľ���̫�label�����button����

public class StationGUI extends JFrame implements ActionListener{
	
	
	ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();
	ArrayList<User> userList = new ArrayList<>();
	ArrayList<Usage> usageList = new ArrayList<>();
	public int number;
	//Station stationA=stationList.get(0);
	Station stationA=new Station();
	
	JFrame jf = new JFrame(); 
	JPanel p1=new JPanel();
	JPanel p2=new JPanel(new GridLayout(5,9));
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	
	JButton b1 = new JButton("Back");
	JButton b2 = new JButton("Confirm");
	
	JLabel l1=new JLabel("Station");
	JLabel l2=new JLabel(" ");//Station���� ���ݲ�ѯ��station���ı����������ʾ
	JLabel l3=new JLabel("Scanner: Please enter your QMID");
	JLabel l4=new JLabel("QMID");
	JLabel l5=new JLabel("Available Scooters:");
	JLabel l6=new JLabel("Empty Slots:");
	JLabel asnbr=new JLabel("");//���õ�scooters������  ����ʵ�ֵ�ʱ�����ͨ�����������������ʾ����
	JLabel esnbr=new JLabel("");//�յ�slots������  ����ʵ�ֵ�ʱ�����ͨ�����������������ʾ����
	
	JLabel l7 = new JLabel("Position");
	JLabel l8 = new JLabel("1");
	JLabel l9 = new JLabel("2");
	JLabel l10 = new JLabel("3");
	JLabel l11 = new JLabel("4");
	JLabel l12 = new JLabel("5");
	JLabel l13 = new JLabel("6");
	JLabel l14 = new JLabel("7");
	JLabel l15 = new JLabel("8");
	JLabel l16 = new JLabel("Scooter");
	JLabel l17 = new JLabel("State");
	JLabel s1 = new JLabel("");
	JLabel s2 = new JLabel("");
	JLabel s3 = new JLabel("");
	JLabel s4 = new JLabel("");
	JLabel s5 = new JLabel("");
	JLabel s6 = new JLabel("");
	JLabel s7 = new JLabel("");
	JLabel s8 = new JLabel("");//��ǰ8��Ϊ�Ƿ��г���״̬��ʾ
	JLabel s9 = new JLabel("");
	JLabel s10 = new JLabel("");
	JLabel s11 = new JLabel("");
	JLabel s12 = new JLabel("");
	JLabel s13 = new JLabel("");
	JLabel s14 = new JLabel("");
	JLabel s15 = new JLabel("");
	JLabel s16 = new JLabel("");//���8��Ϊ�۵�״̬������ͨ���á����+8����ֱ���޸�
	
	
	
	JTextField t1 = new JTextField();//QMID�����
	
	//------------------------------------lock and buld------------------------------------//
	 ImageIcon[] bulb = {
            new ImageIcon("bulb.jpg"),
            new ImageIcon("bulb.jpg"),
            new ImageIcon("bulb.jpg"),
            new ImageIcon("bulb.jpg"),
            new ImageIcon("bulb.jpg"),
            new ImageIcon("bulb.jpg"),
            new ImageIcon("bulb.jpg"),
            new ImageIcon("bulb.jpg"),
        };
		
	JLabel bulbshow = new JLabel("Bulb:");
	
	JLabel[] bulblabel = {
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
	};//This label is used to store image.
	
	
	ImageIcon[] lock = {
            new ImageIcon("lock.jpg"),
            new ImageIcon("lock.jpg"),
            new ImageIcon("lock.jpg"),
            new ImageIcon("lock.jpg"),
            new ImageIcon("lock.jpg"),
            new ImageIcon("lock.jpg"),
            new ImageIcon("lock.jpg"),
            new ImageIcon("lock.jpg"),
        };
	
	ImageIcon unlock = new ImageIcon("unlock.jpg");
		
	JLabel lockshow = new JLabel("Lock:");
	
	JLabel[] locklabel = {
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
		new JLabel(""),
	};//This label is used to store image.
	
	//------------------------------------lock and buld------------------------------------//
	
	public StationGUI(int name){
		this.number=name;

		if(name==0) {
		stationA=stationList.get(0);
		l2.setText("A");
	}
	else if(name==1) {
		stationA=stationList.get(1);
		l2.setText("B");
	}
	else {
		stationA=stationList.get(2);
		l2.setText("C");
	
	}
	
		 jf.setSize(800,700);
		 jf.setLocation(300,0); 
		 
		 p1.setBounds(0,0,800,70);//���������ǰ�����˺�station����
		 p2.setBounds(0,80,800,200);//station��ǰ״��
		 p3.setBounds(200, 400, 400, 150);//qmid����
		 p4.setBounds(0, 550, 800, 150);//��ѯ���
		 
		 l1.setBounds(325,30,130,40);
		 l2.setBounds(455,30,20,40);
		 l3.setBounds(150, 0, 200, 75);
		 l4.setBounds(0, 75, 100, 75);
		 l5.setBounds(0, 0, 150, 75);
		 l6.setBounds(0, 40, 150, 75);
		 asnbr.setBounds(150, 0, 200, 75);
		 esnbr.setBounds(150, 40, 200, 75);
		 t1.setBounds(100, 75, 300, 75);
		 
		 jf.setLayout(null);
		 p1.setLayout(null);
		 p3.setLayout(null);
		 p4.setLayout(null);
		 
		 l7.setBorder(BorderFactory.createLineBorder(Color.black));
		 l8.setBorder(BorderFactory.createLineBorder(Color.black));
		 l9.setBorder(BorderFactory.createLineBorder(Color.black));
		 l10.setBorder(BorderFactory.createLineBorder(Color.black));
		 l11.setBorder(BorderFactory.createLineBorder(Color.black));
		 l12.setBorder(BorderFactory.createLineBorder(Color.black));
		 l13.setBorder(BorderFactory.createLineBorder(Color.black));
		 l14.setBorder(BorderFactory.createLineBorder(Color.black));
		 l15.setBorder(BorderFactory.createLineBorder(Color.black));
		 l16.setBorder(BorderFactory.createLineBorder(Color.black));
		 l17.setBorder(BorderFactory.createLineBorder(Color.black));
		 
		 s1.setBorder(BorderFactory.createLineBorder(Color.black));
		 s2.setBorder(BorderFactory.createLineBorder(Color.black));
		 s3.setBorder(BorderFactory.createLineBorder(Color.black));
		 s4.setBorder(BorderFactory.createLineBorder(Color.black));
		 s5.setBorder(BorderFactory.createLineBorder(Color.black));
		 s6.setBorder(BorderFactory.createLineBorder(Color.black));
		 s7.setBorder(BorderFactory.createLineBorder(Color.black));
		 s8.setBorder(BorderFactory.createLineBorder(Color.black));
		 s9.setBorder(BorderFactory.createLineBorder(Color.black));
		 s10.setBorder(BorderFactory.createLineBorder(Color.black));
		 s11.setBorder(BorderFactory.createLineBorder(Color.black));
		 s12.setBorder(BorderFactory.createLineBorder(Color.black));
		 s13.setBorder(BorderFactory.createLineBorder(Color.black));
		 s14.setBorder(BorderFactory.createLineBorder(Color.black));
		 s15.setBorder(BorderFactory.createLineBorder(Color.black));
		 s16.setBorder(BorderFactory.createLineBorder(Color.black));

		 p3.setBorder(BorderFactory.createLineBorder(Color.black));
		 
		 p1.add(l1);
		 p1.add(l2);
		 p1.add(b1);
		 p1.add(b2);
		 
		 p2.add(l7);
		 p2.add(l8);
		 p2.add(l9);
		 p2.add(l10);
		 p2.add(l11);
		 p2.add(l12);
		 p2.add(l13);
		 p2.add(l14);
		 p2.add(l15);
		 p2.add(l16);
		 p2.add(s1);
		 p2.add(s2);
		 p2.add(s3);
		 p2.add(s4);
		 p2.add(s5);
		 p2.add(s6);
		 p2.add(s7);
		 p2.add(s8);
		 p2.add(l17); 
		 p2.add(s9);
		 p2.add(s10);
		 p2.add(s11);
		 p2.add(s12);
		 p2.add(s13);
		 p2.add(s14);
		 p2.add(s15);
		 p2.add(s16);
		 
		 if(stationA.getSlot(0)==true)
			 s1.setText("true");
		 else
			 s1.setText("false");
		 
		 if(stationA.getSlot(1)==true)
			 s2.setText("true");
		 else
			 s2.setText("false");
		 
		 if(stationA.getSlot(2)==true)
			 s3.setText("true");
		 else
			 s3.setText("false");
		 
		 if(stationA.getSlot(3)==true)
			 s4.setText("true");
		 else
			 s4.setText("false");
		 
		 if(stationA.getSlot(4)==true)
			 s5.setText("true");
		 else
			 s5.setText("false");
		 
		 if(stationA.getSlot(5)==true)
			 s6.setText("true");
		 else
			 s6.setText("false");
		 
		 if(stationA.getSlot(6)==true)
			 s7.setText("true");
		 else
			 s7.setText("false");
		 
		 if(stationA.getSlot(7)==true)
			 s8.setText("true");
		 else
			 s8.setText("false");
		 
		 
		 int count=0;
		 for(int i=0;i<8;i++) {
			 if(stationA.getSlot(i)==true) {
				 count++;
			 }
		 }
		 
		 asnbr.setText(count+"");
		 esnbr.setText((8-count)+"");
		 
		 
		 

		 //���������Խ��
//------------------------------------lock and buld------------------------------------//
		 //����дһ������
		 
		 p2.add(bulbshow); 
		 for(int i=0;i<8;i++)
		 {
		 	bulblabel[i].setIcon(bulb[i]);
		    p2.add(bulblabel[i]);
		    if(stationA.getLight(i)==false) {
		    	bulblabel[i].setVisible(false);
		    }
		    else {
		    	bulblabel[i].setVisible(true);
		    }
		    
		 }
		 
		 //-------------------This is just to simulate the lighting system---------------------
		 //int testRandomNum = (int)(1+Math.random()*(7-0+1));
		 // bulblabel[testRandomNum].setVisible(true);
		 
		 
		 p2.add(lockshow);		 
		 for(int i=0;i<8;i++)
		 {
		 	locklabel[i].setIcon(lock[i]);
		    p2.add(locklabel[i]);
		    System.out.println(stationA.getSlot(i));
		    if(stationA.getLight(i)==false) {
		    	locklabel[i].setVisible(true);
		    	
		    }
		    else {
		    	locklabel[i].setIcon(unlock);
		    	//locklabel[i].setVisible(false);
		    	
		    }
		    
		    
		 }
		 
		 //-------------------This is just to simulate the locking system---------------------
		
		 //locklabel[testRandomNum].setIcon(unlock);
		//ImageIcon unlock = new ImageIcon("unlock.jpg");
		 //locklabel[testRandomNum].setIcon(unlock);
		 
//------------------------------------lock and buld------------------------------------//
		 
		 p3.add(l3);
		 p3.add(l4);
		 p3.add(t1);
		 
		 p4.add(l5);
		 p4.add(l6);
		 p4.add(asnbr);
		 p4.add(esnbr);
		 
		 jf.add(p1);
		 jf.add(p2);
		 jf.add(p3);
		 jf.add(p4);
		 
		 
		
		 b1.setSize(80,30);
         b1.setLocation(10,10);	
         b1.addActionListener(this);
         //System.out.println("zheli");
         
         b2.setSize(80,30);
         b2.setLocation(100,10);	
         b2.addActionListener(this);
         //System.out.println("zhelirr");
         
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jf.setVisible(true);
         
         //b2.setBounds(300, 600, 80, 30);	
         //b2.addActionListener(new BackListener());
		 
		 
	}
//
//	public static void main(String[] args) {
//		StationGUI myStationGUI=new StationGUI();
//		
//	}
	
	
       public void actionPerformed(ActionEvent e) {
    	userList=ListJsonSwitch.jsonToUser();
    	usageList=ListJsonSwitch.jsonToUsage();
    	
       if(e.getSource()==b1)
	   {
	       jf.dispose();
         //function choose
		   startUI sUI = new startUI(); 
       }
       else if (e.getSource() == b2) {
    	   
    	   //��дһ������
    	   
           String QMID = t1.getText();
           // ���
           ArrayList<User> userArrayList = ListJsonSwitch.jsonToUser();
           /*1. ���QMID����*/
           if (t1.getText().length()==9) {
               /*2. ���QMID�Ƿ����*/
               if (StationController.userChecking(userArrayList, QMID)) {
            	  
            	   
                   /*3. ����ǽ賵���ǻ���*/
                   ArrayList<Usage> usageArrayList = ListJsonSwitch.jsonToUsage();
                   ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();
               //	Station stationA=stationList.get(0);
                   if (!StationController.usageChecking(usageArrayList, QMID)) {
                       // �賵������
                       /*
                       * ��������ʱ + ȡ��button
                       * */
                	 //����Ƿ��з���
                	 if(StationController.pickUpFineChecking(userList,QMID)==true) {
                		 JOptionPane.showMessageDialog(null, "Sorry , you are fined!", "Pick up Scooter", JOptionPane.PLAIN_MESSAGE);
                		 //��ʱ�����������
                		 
                		 //д�ڷ�������
                		 
                		//------------------------------------FineSystem------------------------------------//
                         JDialog fine=new JDialog(jf);
    		             fine.setModal(true);
    		             fine.setSize(480,200);
    		             fine.setLocationRelativeTo(jf);
    		             fine.setLayout(null);
    		             JButton pay = new JButton("Pay");
    	                 JLabel label = new JLabel("Please pay the fine so that your account won't be froze.");

    		             fine.add(pay);
    		             fine.add(label);
    		             label.setBounds(60,20,400,30);
    		             pay.setBounds(200,80,80,40);
    		             pay.addActionListener(new ActionListener()
    		             {
    			             public void actionPerformed(ActionEvent e) {
    			            	 
    			            	 //д��һ��������
                             //changing the fined status of user usage
    						 for(User user : userList) {
                                if(user.getQMNo().equals(QMID)) {
                                    user.setFineOrNot(false);
                                    user.setpaystatus(true);
                                    break;
                                   }
                              }
    						  
    						  for(Usage usage : usageArrayList) {
    							  
                                 if(usage.getUserQMNo().equals(QMID)) {
                                	 
                                	 if(usage.getFineStatus()==true) {
                                		
                                		 usage.setPaystatus(true);
                                		 usage.setFineStatus(false);
                                	
                                		 break; //������break
                                		 
                                	 }                                	 
                	                 
                              }
                                 
    		                 fine.dispose();
    						  }
    						  ListJsonSwitch.UsageToJson(usageArrayList);
                          
              	        	 ListJsonSwitch.UserToJson(userList);
                         }
    		               });
    		             fine.setVisible(true);
    //-----------------------------------FineSystem-----------------------------------//
    		             JOptionPane.showMessageDialog(null, "The fined has benn payed successfully", "Fine", JOptionPane.PLAIN_MESSAGE);						 						 
    				 
                    	 
                	 }
                	 //û�з����ʱ��
                	 else {
                		 
                		    int availableSlot = stationA.gvMeAScooter();
                        	System.out.println(availableSlot);
                            if (availableSlot >= 0 && availableSlot < 8) {
                         	    stationA.setLight(availableSlot, true);
                         	   System.out.println(stationA.getLight(availableSlot));
                         	   stationList.set(number, stationA);
                         	    //stationList.get(number)=stationA;
                                ListJsonSwitch.StationToJson(stationList);
                                ListJsonSwitch.UsageToJson(usageList);
               	        	    ListJsonSwitch.UserToJson(userList);
                                jf.dispose();
                                //StationGUI newgui=new StationGUI();                         	   
                         	   
                            	PickupInfo pi=new PickupInfo(availableSlot,QMID,number);
                            }
                            else {
                            	JOptionPane.showMessageDialog(null, "Sorry! There is no available slots,Please try another station", "Pick up Scooter", JOptionPane.PLAIN_MESSAGE);
                            }
                	 }
                   	
                   	//�ȼ���Ƿ��г�λ
                   	
                       //JOptionPane.showMessageDialog(null, "��װ���ǽ賵����ʱ", "�賵", JOptionPane.PLAIN_MESSAGE);
                   }
                   else {
                       // ����������
                       /*
                       * ��������ʱ + ����button
                       * */
                   	//�ȼ���Ƿ��п�λ
                   	 int availableSlot = stationA.gvAnEmptySlot();
                   	 System.out.println(availableSlot);
                        if (availableSlot >=0 && availableSlot < 8) {
                       	
                            stationA.setLight(availableSlot, true);
                            stationList.set(number, stationA);
                            ListJsonSwitch.StationToJson(stationList);
                            ListJsonSwitch.UsageToJson(usageList);
           	        	    ListJsonSwitch.UserToJson(userList);
                            jf.dispose();
                            //StationGUI newgui=new StationGUI();
                            
							ReturnInfo ri=new ReturnInfo(availableSlot,QMID,number);
							
					
                       	 
                       	 //ImageIcon lock = new ImageIcon("lock.jpg");
                       	 //locklabel[availableSlot].setIcon(lock);
                       	// bulblabel[availableSlot].setVisible(false);
                       
                        }
                        else {
                        
                       	 JOptionPane.showMessageDialog(null, "Sorry! There is no empty slots,Please try another station", "Pick up Scooter", JOptionPane.PLAIN_MESSAGE);
                        }
                       
                   }
               }
               else {
                   /*������*/
                   JOptionPane.showMessageDialog(null, "This QMID doesn't exist!", "Warning", JOptionPane.PLAIN_MESSAGE);
               }
           }
           else {
               /*��ʾQMID�ĳ��Ȳ���9λ*/
               JOptionPane.showMessageDialog(null, "QMID should be 9 digits!", "Warning", JOptionPane.PLAIN_MESSAGE);
           }
       }
   }
       
       
       
}    
