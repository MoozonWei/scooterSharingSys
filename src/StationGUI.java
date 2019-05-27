import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**Station GUI for three different stations
 * This is a GUI interface for the stations for users
 * which can pick up or return a scooter
 * with existed ID and check fine status
 * 
 * version 2.0
 * @author Cong Li,Qinuo Yao, Minghao Hu,Zihan Wei
 */

public class StationGUI extends JFrame implements ActionListener {

    // the list for station, user, usage
    ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<Usage> usageList = new ArrayList<>();
    public int number;
    Station stationA;

    JFrame jf = new JFrame();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();

    JButton back = new JButton("Back");
    JButton confirm = new JButton("Confirm");

    JLabel station = new JLabel("Station", JLabel.CENTER);
    JLabel l2 = new JLabel(" ", JLabel.CENTER);
    JLabel qmid = new JLabel("QMID", JLabel.CENTER);
    JLabel available_slot = new JLabel("Available Scooters:", JLabel.RIGHT);
    JLabel empty_slot = new JLabel("Empty Slots:", JLabel.RIGHT);
    JLabel asnbr = new JLabel("", JLabel.CENTER);
    JLabel esnbr = new JLabel("", JLabel.CENTER);

    //the 8 position for scooters and slots
    JLabel position = new JLabel("Position", JLabel.CENTER);
    JLabel position_1 = new JLabel("1", JLabel.CENTER);
    JLabel position_2 = new JLabel("2", JLabel.CENTER);
    JLabel position_3 = new JLabel("3", JLabel.CENTER);
    JLabel position_4 = new JLabel("4", JLabel.CENTER);
    JLabel position_5 = new JLabel("5", JLabel.CENTER);
    JLabel position_6 = new JLabel("6", JLabel.CENTER);
    JLabel position_7 = new JLabel("7", JLabel.CENTER);
    JLabel position_8 = new JLabel("8", JLabel.CENTER);
    JLabel scooter = new JLabel("Scooter", JLabel.CENTER);
    JLabel slot1 = new JLabel("slot1", JLabel.CENTER);
    JLabel slot2 = new JLabel("slot2", JLabel.CENTER);
    JLabel slot3 = new JLabel("slot3", JLabel.CENTER);
    JLabel slot4 = new JLabel("slot4", JLabel.CENTER);
    JLabel slot5 = new JLabel("slot5", JLabel.CENTER);
    JLabel slot6 = new JLabel("slot6", JLabel.CENTER);
    JLabel slot7 = new JLabel("slot7", JLabel.CENTER);
    JLabel slot8 = new JLabel("slot8", JLabel.CENTER);

    JTextField t1 = new JTextField();//scan the ID
    
    // the pictures for the bulb, lock and unlock to represent the actual scene
    ImageIcon[] bulb = { new ImageIcon("bulb.jpg"), new ImageIcon("bulb.jpg"), new ImageIcon("bulb.jpg"),
			new ImageIcon("bulb.jpg"), new ImageIcon("bulb.jpg"), new ImageIcon("bulb.jpg"), new ImageIcon("bulb.jpg"),
			new ImageIcon("bulb.jpg"), };

	JLabel bulbshow = new JLabel("Bulb");

	JLabel[] bulblabel = { new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER),
			new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER), };// This label is used to store image.

	ImageIcon[] lock = { new ImageIcon("lock.jpg"), new ImageIcon("lock.jpg"), new ImageIcon("lock.jpg"),
			new ImageIcon("lock.jpg"), new ImageIcon("lock.jpg"), new ImageIcon("lock.jpg"), new ImageIcon("lock.jpg"),
			new ImageIcon("lock.jpg"), };
	
	ImageIcon unlock = new ImageIcon("unlock.jpg");

	JLabel lockshow = new JLabel("Lock");

	JLabel[] locklabel = { new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER),
			new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER), new JLabel("", JLabel.CENTER), };// This label is used to store image.

    //------------------------------------lock and buld------------------------------------//

	/**
     * Constructor
     * set the layout, size, font and bound 
     */
    public StationGUI (int name) {
        this.number = name;

        //judge which station you choose
        if (name == 0) {
            stationA = stationList.get(0);
            l2.setText("A");
        } else if (name == 1) {
            stationA = stationList.get(1);
            l2.setText("B");
        } else {
            stationA = stationList.get(2);
            l2.setText("C");

        }

        jf.setSize(810, 406);
        jf.setLocation(300, 0);

        p1.setBounds(0, 0, 800, 70);
        p2.setBounds(0, 80, 800, 190);
        p3.setBounds(407, 307, 380, 41);
        p4.setBorder(new LineBorder(new Color(0, 0, 0)));
        p4.setBounds(10, 307, 364, 41);
        station.setFont(new Font("微软雅黑", Font.PLAIN, 12));

        station.setBounds(325, 30, 130, 40);
        l2.setBounds(455, 30, 20, 40);
        qmid.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        qmid.setBounds(0, 0, 100, 41);
        available_slot.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        available_slot.setBounds(0, 0, 120, 41);
        empty_slot.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        empty_slot.setBounds(191, 0, 129, 41);
        asnbr.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        asnbr.setBounds(130, 0, 31, 41);
        esnbr.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        esnbr.setBounds(330, 0, 31, 41);
        t1.setBounds(117, 0, 263, 41);

        jf.getContentPane().setLayout(null);
        p1.setLayout(null);
        p3.setLayout(null);
        p4.setLayout(null);

        p3.setBorder(BorderFactory.createLineBorder(Color.black));

        p1.add(station);
        p1.add(l2);
        back.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        p1.add(back);
        confirm.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        p1.add(confirm);
        p2.setLayout(new GridLayout(4, 9, 0, 0));
        position.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        position.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(position);
        position_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        position_1.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(position_1);
        position_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        position_2.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(position_2);
        position_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        position_3.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(position_3);
        position_4.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        position_4.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(position_4);
        position_5.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        position_5.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(position_5);
        position_6.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        position_6.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(position_6);
        position_7.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        position_7.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(position_7);
        position_8.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        position_8.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(position_8);
        scooter.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        scooter.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(scooter);
        slot1.setFont(new Font("微软雅黑", Font.PLAIN, 12));

        slot1.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(slot1);
        slot2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        slot2.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(slot2);
        slot3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        slot3.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(slot3);
        slot4.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        slot4.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(slot4);
        slot5.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        slot5.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(slot5);
        slot6.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        slot6.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(slot6);
        slot7.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        slot7.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(slot7);
        slot8.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        slot8.setBorder(BorderFactory.createLineBorder(Color.black));
        p2.add(slot8);

        p3.add(qmid);
        p3.add(t1);

        p4.add(available_slot);
        p4.add(empty_slot);
        p4.add(asnbr);
        p4.add(esnbr);

        jf.getContentPane().add(p1);
        jf.getContentPane().add(p2);
        jf.getContentPane().add(p3);
        jf.getContentPane().add(p4);


        back.setSize(80, 30);
        back.setLocation(10, 10);
        back.addActionListener(this);

        confirm.setSize(80, 30);
        confirm.setLocation(100, 10);
        confirm.addActionListener(this);

        /**
         * get the slot information
         */
        if (stationA.getSlot(0) == true)
            slot1.setText("true");
        else
            slot1.setText("false");

        if (stationA.getSlot(1) == true)
            slot2.setText("true");
        else
            slot2.setText("false");

        if (stationA.getSlot(2) == true)
            slot3.setText("true");
        else
            slot3.setText("false");

        if (stationA.getSlot(3) == true)
            slot4.setText("true");
        else
            slot4.setText("false");

        if (stationA.getSlot(4) == true)
            slot5.setText("true");
        else
            slot5.setText("false");

        if (stationA.getSlot(5) == true)
            slot6.setText("true");
        else
            slot6.setText("false");

        if (stationA.getSlot(6) == true)
            slot7.setText("true");
        else
            slot7.setText("false");

        if (stationA.getSlot(7) == true)
            slot8.setText("true");
        else
            slot8.setText("false");


        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (stationA.getSlot(i) == true) {
                count++;
            }
        }

        //set the UI information
        asnbr.setText(count + "");
        esnbr.setText((8 - count) + "");
        bulbshow.setBorder(new LineBorder(new Color(0, 0, 0)));
        bulbshow.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        bulbshow.setHorizontalAlignment(SwingConstants.CENTER);


        //add the bulb information according to the station light information
        p2.add(bulbshow);
        		
		int lightNo=-1;
		 for(int i=0;i<8;i++)
		 {
		 	bulblabel[i].setIcon(bulb[i]);
		 	bulblabel[i].setBorder(BorderFactory.createLineBorder(Color.black));
		    p2.add(bulblabel[i]);
		    if(stationA.getLight(i)==false) {
		    	bulblabel[i].setVisible(false);
		    }
		    else {
		    	bulblabel[i].setVisible(true);
		    	lightNo=i;
		    }
		    
		 }
		lockshow.setBorder(new LineBorder(new Color(0, 0, 0)));
		lockshow.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lockshow.setHorizontalAlignment(SwingConstants.CENTER);

		p2.add(lockshow);
		//add the lock information according to the station light information
		for (int i = 0; i < 8; i++) {
			locklabel[i].setIcon(lock[i]);
			locklabel[i].setBorder(BorderFactory.createLineBorder(Color.black));
			p2.add(locklabel[i]);
			System.out.println(stationA.getSlot(i));
			if (stationA.getLight(i) == false) {
				locklabel[i].setVisible(true);

			} else {
				locklabel[i].setIcon(unlock);
			
			}

		}




        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
        if(lightNo>=0&&lightNo<9){//Create a new thread if there is a light need to be lightning

			Thread clearthread = new Thread(new clearthread(lightNo,name));
           
			
			clearthread.start();//start
		}
    }
    /**Inner thread class
     * It can make the light to flash 
     * 
     */
    class clearthread implements Runnable{
		int lightNo;
		boolean live=true;
		int HP;
		int name;
		
		/**Clear thread constructor
	     * @param the integer of the number of light, the integer of the station name
	     * 
	     */
		public clearthread(int lightNo,int name){
			this.lightNo=lightNo;
			this.live=true;
			this.HP=43; //750ms on loop
			this.name=name;
		}
		/**Run method
	     *
	     * make the bulb picture flash
	     */
		public void run(){
			System.out.println("light success");

			while(this.live){//Only when the thread is live,it will work.
				bulblabel[lightNo].setVisible(true);
				delay();
				bulblabel[lightNo].setVisible(false);
				delay();
				HP--;
				if(HP==0)
					this.live=false;
				live=getLive(this.name);//Judge whether it should live or not.
			}
			System.out.println("**----------This light thread died");
		}

		/**get thread live method
	     * to check which station light has to be flashed
	     * @return the boolean to judge whether the light is on
	     * 
	     */
		public boolean getLive(int na){
			ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();
			boolean lightJudge;
			char nameT;
			if(na==0)
				nameT='A';
			else if(na==1)
				nameT='B';
			else
				nameT='C';

			for (Station st : stationList) {
				if(st.getStationName()==nameT){
					if(!st.getLight(this.lightNo))
						return false;
				}
			}
			return true;
		}

		/**delay method
	     * to control the flash frequency of bulb picture
	     * 
	     */
		public void delay(){
			long startTime =  System.currentTimeMillis();
			while(true)
			{
				long endTime =  System.currentTimeMillis();
				long usedTime = (endTime-startTime);
				if(usedTime>350)
					break;
			}
		}
	}
    
    /**Action performed method
     * for pressing different buttons
     * 
     */
    public void actionPerformed(ActionEvent e) {
        String QMID = t1.getText();
        userList = ListJsonSwitch.jsonToUser();
        usageList = ListJsonSwitch.jsonToUsage();
        ArrayList<Usage> usageArrayList = ListJsonSwitch.jsonToUsage();
        ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();
        ArrayList<User> userArrayList = ListJsonSwitch.jsonToUser();

        if (e.getSource() == back) {
            jf.dispose();
            startUI sUI = new startUI();
        } else if (e.getSource() == confirm) {
            StationController.stationInAll(QMID, stationA, number, jf);
        }
    }

}    
