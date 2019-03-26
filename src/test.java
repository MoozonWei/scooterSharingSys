import java.io.*;
import java.util.ArrayList;

import com.google.gson.*;

public class test {
    public static void main(String args[]) throws IOException {
        AllPpInSchl a = new AllPpInSchl();
        a.QMNo = 12345678;
        a.fName = "david";
        a.lName = "wei";

        AllPpInSchl b = new AllPpInSchl();
        b.QMNo = 12345678;
        b.fName = "david";
        b.lName = "wei";

        ArrayList<AllPpInSchl> AllList = new ArrayList<>();
        AllList.add(a);
        AllList.add(b);

        // 将对象a转化为字符串json
        Gson gson = new Gson();
        String json = gson.toJson(AllList);

        System.out.println(json);

        // 将字符串json写入文件user.json中
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("allPeo.json", false));
            out.write(json);
            out.close();
        } catch (IOException e) {
        }

        // 将文件中的数据转化为String
        StringBuffer str=new StringBuffer("");
        File file=new File("allPeo.json");
        try {
            FileReader fr=new FileReader(file);
            int ch = 0;
            while((ch = fr.read())!=-1 )
            {
                System.out.print((char)ch);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File reader出错");
        }

        System.out.println("\n" + str);

        // 将String中的内容反序列化成ArrayList


    }
}
