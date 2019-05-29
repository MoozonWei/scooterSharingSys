import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

 

/**

 * ����ʱ

 */

public class Counter {

 

    private JFrame frame;

    private JLabel jl0;

 

    public static void main(String[] args) throws ParseException {

 

        new Counter().getTime("2017-09-20 21:06:00");

 

    }

 

    /* String -> Date */

    private Date String2Date(String dateStr) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {

            Date date = simpleDateFormat.parse(dateStr);

            return date;

        } catch (ParseException e) {

            e.printStackTrace();

        }

        return null;

    }

 

    /* ����ʱ����Ҫ����� */

    private void getTime(String dateStr) {

 

        Date end = String2Date(dateStr);

 

        long time = (end.getTime() - 1 - new Date().getTime()) / 1000; // �Զ��嵹��ʱʱ��

        long hour = 0;

        long minute = 0;

        long seconds = 0;

 

        while (time >= 0) {

            hour = time / 3600;

            minute = (time - hour * 3600) / 60;

            seconds = time - hour * 3600 - minute * 60;

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("<html><br>����").append(dateStr).append("����<br><br>")

                    .append(hour).append("ʱ ").append(minute).append("�� ").append(seconds).append("�� ")

                    .append("</html>");

            jl0.setText(stringBuilder.toString());

 

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            time--;

        }

 

    }

 

    /* ���� ʵ�ֽ���Ŀ��� GUI */

    public Counter() {

        frame = new JFrame("����ʱ");

        jl0 = new JLabel();

 

        init();

 

    }

 

    /* �����װ�� */

    private void init() {

        JPanel jp = new JPanel();

        jp.add(jl0);

 

        frame.add(jp);

 

        frame.setVisible(true);

        frame.setLocation(300, 400);

        frame.setSize(330, 200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

 

}
