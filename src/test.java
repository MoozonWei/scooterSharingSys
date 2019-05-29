import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class test extends JFrame
{
   private JButton btn = new JButton("Start");
   private JLabel label = new JLabel();
   private int time = 30;
   test() {
      setSize(500,300);
      setLayout(new FlowLayout());
      add(btn);
      add(label);
      btn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
               new Thread(new MyThread()).start();
         }
      });
      setVisible(true);
  }

class MyThread implements Runnable 
{
   public void run() {
   while (time > 0)
   {
      time--;
      label.setText(time + "");
      try
         {
          Thread.sleep(1000); 
         }
      catch (Exception e)
         {
          e.printStackTrace();
         }

   }

   test.this.dispose();
   }
   };
public static void main(String[] args) 
   {
     new test();
   }

} 
