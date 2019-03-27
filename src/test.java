import java.io.*;               // 用于文件读写
import java.lang.reflect.Type;  // 用于Arraylist的gson反序列化
import java.util.ArrayList;     // gson
import com.google.gson.*;       // 用于Arraylist的gson反序列化
import com.google.gson.reflect.TypeToken;

public class test {

    public static void main(String args[]) throws IOException {

        AllPpInSchl a = new AllPpInSchl();
        a.QMNo = 12345678;
        a.fName = "David";
        a.lName = "Wei";
        AllPpInSchl b = new AllPpInSchl();
        b.QMNo = 87654321;
        b.fName = "Moozon";
        b.lName = "Wei";
        ArrayList<AllPpInSchl> AllList = new ArrayList<>();
        AllList.add(a);
        AllList.add(b);

        ListJsonSwitch.AllPpToJson(AllList);
        ArrayList<AllPpInSchl> AllList2 = ListJsonSwitch.jsonToAllPp();

        for(AllPpInSchl ap : AllList2){
            System.out.println(ap.QMNo + " " + ap.fName + " " + ap.lName );
        }
//
//        // 将对象a转化为字符串json
//        Gson gson = new Gson();
//        String json = gson.toJson(AllList);
//
//        System.out.println(json);
//
//        // 将字符串json写入文件user.json中
//        try {
//            BufferedWriter out = new BufferedWriter(new FileWriter("allPeo.json", false));
//            out.write(json);
//            out.close();
//        } catch (IOException e) {
//        }
//
//        // 将文件中的数据转化为String
//        String jsonString="";
//        File file=new File("allPeo.json");
//        try {
//            FileReader fr=new FileReader(file);
//            int ch = 0;
//            while((ch = fr.read())!=-1 )
//            {
//                jsonString = jsonString + (char)ch;
//            }
//            fr.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("File reader出错");
//        }
//
//        System.out.println("\n" + jsonString);
//
//        // 将String中的内容反序列化成ArrayList
//        Type type = new TypeToken<ArrayList<AllPpInSchl>>(){}.getType();
//        ArrayList<AllPpInSchl> list = new Gson().fromJson(jsonString,type); // 将StringBuffer类型的str先转化为String类型
//
//        // 打印反序列化之后生成的AllPpInSchl的ArrayList list中的所有属性
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).fName);
//            System.out.println(list.get(i).lName);
//            System.out.println(list.get(i).QMNo);
//            System.out.println();
//        }
    }
}
