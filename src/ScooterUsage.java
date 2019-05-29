//package JavaProgram;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ScooterUsage extends JFrame{
	
	JFrame jf = new JFrame(); 
	JPanel p1=new JPanel();
	JPanel p2=new JPanel(new GridLayout(5,3));
	JPanel p3=new JPanel();
	JPanel p4=new JPanel(new GridLayout(3,9));
	JButton b1 = new JButton("Back");
	
	ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();
	 
	JLabel l0 = new JLabel("");
	JLabel l1 = new JLabel("Check Scooter Usage");
	JLabel l2 = new JLabel("No. of Avalible Scooters");
	JLabel l3 = new JLabel("No. of Empty Slots");
	JLabel l4 = new JLabel("Station A");
	JLabel l5 = new JLabel("Station B");
	JLabel l6 = new JLabel("Station C");
	JLabel l7 = new JLabel("Total");
	JLabel l8 = new JLabel("No. of Currently Used Scooters");
	//����8��label�Ǵ���scooter������
	JLabel l9 = new JLabel("");
	JLabel l10 = new JLabel("");
	JLabel l11 = new JLabel("");
	JLabel l12 = new JLabel("");
	JLabel l13 = new JLabel("");
	JLabel l14 = new JLabel("");
	JLabel l15 = new JLabel("");
	JLabel l16 = new JLabel("");
	JLabel l17 = new JLabel("Position");
	JLabel l18 = new JLabel("1");
	JLabel l19 = new JLabel("2");
	JLabel l20 = new JLabel("3");
	JLabel l21 = new JLabel("4");
	JLabel l22 = new JLabel("5");
	JLabel l23 = new JLabel("6");
	JLabel l24 = new JLabel("7");
	JLabel l25 = new JLabel("8");
	JLabel l26 = new JLabel("Scooter");
	JLabel l27 = new JLabel("");
	JLabel l28 = new JLabel("");
	JLabel l29 = new JLabel("");
	JLabel l30 = new JLabel("");
	JLabel l31 = new JLabel("");
	JLabel l32 = new JLabel("");
	JLabel l33 = new JLabel("");
	JLabel l34 = new JLabel("");
	JLabel l35 = new JLabel("State");
	JLabel l36 = new JLabel("");
	JLabel l37 = new JLabel("");
	JLabel l38 = new JLabel("");
	JLabel l39 = new JLabel("");
	JLabel l40 = new JLabel("");
	JLabel l41 = new JLabel("");
	JLabel l42 = new JLabel("");
	JLabel l43 = new JLabel("");
	
	
	
	public ScooterUsage () {
		
		 jf.setSize(800,700);
		 jf.setLocation(300,0); 
		 
		 p1.setBounds(0,0,800,70);
		 p2.setBounds(0,80,800,300);
		 p3.setBounds(20,400,780,40);
		 p4.setBounds(0,450,800,200);
		 l1.setBounds(325,30,150,40);
		
		 
		 p1.setLayout(null);
		 
		 jf.setLayout(null);
		 
		 l0.setBorder(BorderFactory.createLineBorder(Color.black));
		 l2.setBorder(BorderFactory.createLineBorder(Color.black));
		 l3.setBorder(BorderFactory.createLineBorder(Color.black));
		 l4.setBorder(BorderFactory.createLineBorder(Color.black));
		 l5.setBorder(BorderFactory.createLineBorder(Color.black));
		 l6.setBorder(BorderFactory.createLineBorder(Color.black));
		 l7.setBorder(BorderFactory.createLineBorder(Color.black));
		
		 l9.setBorder(BorderFactory.createLineBorder(Color.black));
		 l10.setBorder(BorderFactory.createLineBorder(Color.black));
		 l11.setBorder(BorderFactory.createLineBorder(Color.black));
		 l12.setBorder(BorderFactory.createLineBorder(Color.black));
		 l13.setBorder(BorderFactory.createLineBorder(Color.black));
		 l14.setBorder(BorderFactory.createLineBorder(Color.black));
		 l15.setBorder(BorderFactory.createLineBorder(Color.black));
		 l16.setBorder(BorderFactory.createLineBorder(Color.black));
		 l17.setBorder(BorderFactory.createLineBorder(Color.black));
		 l18.setBorder(BorderFactory.createLineBorder(Color.black));
		 l19.setBorder(BorderFactory.createLineBorder(Color.black));
		 l20.setBorder(BorderFactory.createLineBorder(Color.black));
		 l21.setBorder(BorderFactory.createLineBorder(Color.black));
		 l22.setBorder(BorderFactory.createLineBorder(Color.black));
		 l23.setBorder(BorderFactory.createLineBorder(Color.black));
		 l24.setBorder(BorderFactory.createLineBorder(Color.black));
		 l25.setBorder(BorderFactory.createLineBorder(Color.black));
		 l26.setBorder(BorderFactory.createLineBorder(Color.black));
		 l27.setBorder(BorderFactory.createLineBorder(Color.black));
		 l28.setBorder(BorderFactory.createLineBorder(Color.black));
		 l29.setBorder(BorderFactory.createLineBorder(Color.black));
		 l30.setBorder(BorderFactory.createLineBorder(Color.black));
		 l31.setBorder(BorderFactory.createLineBorder(Color.black));
		 l32.setBorder(BorderFactory.createLineBorder(Color.black));
		 l33.setBorder(BorderFactory.createLineBorder(Color.black));
		 l34.setBorder(BorderFactory.createLineBorder(Color.black));
		 l35.setBorder(BorderFactory.createLineBorder(Color.black));
		 l36.setBorder(BorderFactory.createLineBorder(Color.black));
		 l37.setBorder(BorderFactory.createLineBorder(Color.black));
		 l38.setBorder(BorderFactory.createLineBorder(Color.black));
		 l39.setBorder(BorderFactory.createLineBorder(Color.black));
		 l40.setBorder(BorderFactory.createLineBorder(Color.black));
		 l41.setBorder(BorderFactory.createLineBorder(Color.black));
		 l42.setBorder(BorderFactory.createLineBorder(Color.black));
		 l43.setBorder(BorderFactory.createLineBorder(Color.black));
		 int count=0,count1=0,count2=0;
		 Station stationA=stationList.get(0);
		 Station stationB=stationList.get(1);
		 Station stationC=stationList.get(2);
		// 1---there is a scooter in this slot
		 for(int i=0;i<8;i++) {
			 if(stationA.getSlot(i)) {
				 count++;
			 }
		 }
		 l9.setText(count+"");
		 l10.setText((8-count)+"");
		 
		 for(int i=0;i<8;i++) {
			 if(stationB.getSlot(i)) {
				 count1++;
			 }
		 }
		 l11.setText(count1+"");
		 l12.setText((8-count1)+"");
		 
		 for(int i=0;i<8;i++) {
			 if(stationC.getSlot(i)) {
				 count2++;
			 }
		 }
		 l13.setText(count2+"");
		 l14.setText((8-count2)+"");
		 
		 l15.setText((count+count1+count2)+"");
		 l16.setText((24-count-count1-count2)+"");
		 
		p1.add(l1);
		p2.add(l0);
		p2.add(l2);
		p2.add(l3);
		p2.add(l4);
		p2.add(l9);
		p2.add(l10);
		p2.add(l5);
		p2.add(l11);
		p2.add(l12);
		p2.add(l6);
		p2.add(l13);
		p2.add(l14);
		p2.add(l7);
		p2.add(l15);
		p2.add(l16);
		p3.add(l8);
		p4.add(l17);
		p4.add(l18);
		p4.add(l19);
		p4.add(l20);
		p4.add(l21);
		p4.add(l22);
		p4.add(l23);
		p4.add(l24);
		p4.add(l25);
		p4.add(l26);
		p4.add(l27);
		p4.add(l28);
		p4.add(l29);
		p4.add(l30);
		p4.add(l31);
		p4.add(l32);
		p4.add(l33);
		p4.add(l34);
		p4.add(l35);
		p4.add(l36);
		p4.add(l37);
		p4.add(l38);
		p4.add(l39);
		p4.add(l40);
		p4.add(l41);
		p4.add(l42);
		p4.add(l43);
		
		
		
		jf.add(p1);
		jf.add(p2);
		//jf.add(p3);
		//jf.add(p4);
		
		
		
		 ListJsonSwitch.StationToJson(stationList);
		 
		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jf.setVisible(true);
		
		p1.add(b1);
		b1.setSize(80,30);
      b1.setLocation(10,10);	
      b1.addActionListener(new BackListener());
      
      
	}
	
	
	  

		
	public static void main(String[] args) {
		ScooterUsage  mygui2=new ScooterUsage ();
		
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
  }
	}


}
