//package JavaProgram;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import JavaProgram.ManagerLogin.AddUserListener;
//import JavaProgram.ManagerLogin.RevokeListener;
//import JavaProgram.ManagerLogin.ViewScooterListener;
//import JavaProgram.ManagerLogin.ViewUserListener;

import javax.swing.JTextField;

public class UserUsage extends JFrame {

    private JFrame frame;
    private JLabel viewUserLabel = new JLabel("Check User Usage", JLabel.CENTER);
    private JLabel IDLabel = new JLabel("QMID:", JLabel.CENTER);
    private JTextField IDText = new JTextField();
    private DefaultTableModel model;
    private JTable table;
    private JButton addBtn;
    private JPanel mainPanel = new JPanel(null);
    private JScrollPane checkTable;
    private JButton back = new JButton("Back");
    private JButton email = new JButton("Send Email");
    ArrayList<Usage> usageList;

    public UserUsage() {

        String[][][][][][][] datas = {};
        String[] titles = {"Pick Up Time", "Return Time", "Usage Time(min)", "Fine Status", "Penalty Status", "Pick up Station", "Return Station"};
        model = new DefaultTableModel(datas, titles);
        table = new JTable(model);
        addBtn = new JButton("Confirm");
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        checkTable = new JScrollPane(table);
        generateMainPanel();

        usageList = ListJsonSwitch.jsonToUsage();

        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                while (model.getRowCount() > 0) {
                    model.removeRow(model.getRowCount() - 1);
                }
                boolean check = ManSysOp.checkID(IDText.getText(), usageList);
                String str = "The ID does not exist! Please check again!";
                if (check == true) {
                    for (Usage usage : usageList) {
                        if (usage.getUserQMNo().equals(IDText.getText())) {

                            model.addRow(new String[]{usage.getPickUpTime(), usage.getReturnTime(), usage.getUsageTime(), String.valueOf(usage.getFineStatus()), String.valueOf(usage.getPayStatus()), String.valueOf(usage.getPickUpStation()), String.valueOf(usage.getReturnStation())});
                            ListJsonSwitch.UsageToJson(usageList);

                        }
                    }
                } else {

                    JOptionPane.showMessageDialog(null, str, "Check User Usage", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        email.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                boolean check = ManSysOp.checkID(IDText.getText(), usageList);
                String str = "The ID does not exist! Please check again!";
                if (check == true) {
                    for (Usage usage : usageList) {
                        if (usage.getUserQMNo().equals(IDText.getText())) {
                            try {
                                if (sendEmail(usage) < 7) {
                                    System.out.println(usage.toString());
                                }
                            } catch (ParseException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }


                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, str, "Check User Usage", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });


        setSize(890, 501);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public int sendEmail(Usage u) throws ParseException {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat simpleFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date fromDate3 = simpleFormat.parse(u.getPickUpTime());
        Date toDate3 = new Date();

        long pickUptime = fromDate3.getTime();
        long nowtime = toDate3.getTime();
        int uasgetime = (int) ((nowtime - pickUptime) / (1000 * 60 * 60 * 24));
        return uasgetime;

    }

    private void generateMainPanel() {
        settingColors();
        settingBounds();
        mainPanel.add(viewUserLabel);
        mainPanel.add(IDLabel);
        mainPanel.add(IDText);
        mainPanel.add(addBtn);
        mainPanel.add(checkTable);
        mainPanel.add(back);
        mainPanel.add(email);
    }


    /**
     * setting the colors of the label
     */
    private void settingColors() {

        viewUserLabel.setFont(new java.awt.Font("Dialog", 1, 35));
        IDLabel.setFont(new java.awt.Font("Dialog", 1, 20));


    }

    /**
     * setting the bounds
     */
    private void settingBounds() {
        viewUserLabel.setBounds(243, 10, 387, 60);
        IDLabel.setBounds(65, 80, 94, 30);
        addBtn.setBounds(541, 80, 112, 30);
        IDText.setBounds(162, 80, 353, 30);
        checkTable.setBounds(10, 120, 862, 341);

        back.setSize(80, 30);
        back.setLocation(10, 10);
        back.addActionListener(new BackListener());

        email.setSize(112, 30);
        email.setLocation(685, 80);
        email.addActionListener(new BackListener());
    }

    public static void main(String[] args) {
        new UserUsage();
    }


    private String getRandomData() {
        String source = "0123456789abcdefghijklmnopqrstuvwxyz";
        int len = source.length();
        Random random = new Random(System.currentTimeMillis());
        return MessageFormat.format("{0}{0}{0}", source.charAt(random.nextInt(len)));
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                dispose();
                ManagerLogin ml = new ManagerLogin();
            }
        }
    }
}

