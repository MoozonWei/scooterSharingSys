import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *  1. ArrayList to *.json
 *    AllPpToJson
 *    UserToJson
 *    ManagerToJson
 *    StationToJson
 *    UsageToJson
 *  2. *.json to ArrayList
 *    jsonToAllPp
 *    jsonToUser
 *    jsonToManager
 *    jsonToStation
 *    jsonToUsage
 *
 * @author Zihan WEI
 */

public class ListJsonSwitch {
    private static String allPeoFileName = "jsonFile\\allPeo.json";
    private static String userFileName = "jsonFile\\user.json";
    private static String managerFileName = "jsonFile\\manager.json";
    private static String stationFileName = "jsonFile\\station.json";
    private static String usageFileName = "jsonFile\\usage.json";

    // read & write

    /**
     * Write String into .json file
     *
     * @param jsonString The string you want to write into the file
     * @param fileName Filename of that json file
     */
    private static void writeStringToJson(String jsonString, String fileName) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, false));
            out.write(jsonString);
            out.close();
        } catch (IOException e) {
        }
    }

    /**
     * Read string from json file
     *
     * @param fileName File name of that json file
     * @return The string that you read from the file
     */
    private static String readStringFromJson(String fileName) {
        String jsonString = "";
        File file = new File(fileName);
        try {
            FileReader fr = new FileReader(file);
            int ch = 0;
            while ((ch = fr.read()) != -1)
                jsonString += (char) ch;
            fr.close();
        } catch (IOException e) {
        }
        return jsonString;
    }

    // toJson

    /**
     * Write array list of AllPpInSchl into json file
     *
     * @param AllPpArrayList Array list of AllPpInSchl
     */
    public static void AllPpToJson(ArrayList<AllPpInSchl> AllPpArrayList){
        Gson gson = new Gson();
        String jsonString = gson.toJson(AllPpArrayList);
        writeStringToJson(jsonString,allPeoFileName);
    }

    /**
     * Write array list of User into json file
     *
     * @param UserArrayList Array list of User
     */
    public static void UserToJson(ArrayList<User> UserArrayList){
        Gson gson = new Gson();
        String jsonString = gson.toJson(UserArrayList);
        writeStringToJson(jsonString,userFileName);
    }


    /**
     * Write array list of Manager into json file
     *
     * @param ManagerArrayList Array list of Manager
     */
    public static void ManagerToJson(ArrayList<Manager> ManagerArrayList){
        Gson gson = new Gson();
        String jsonString = gson.toJson(ManagerArrayList);
        writeStringToJson(jsonString,managerFileName);
    }

    /**
     * Write array list of Station into json file
     *
     * @param StationArrayList Array list of Station
     */
    public static void StationToJson(ArrayList<Station> StationArrayList){
        Gson gson = new Gson();
        String jsonString = gson.toJson(StationArrayList);
        writeStringToJson(jsonString,stationFileName);
    }

    /**
     * Write array list of Usage into json file
     *
     * @param UsageArrayList Array list of Usage
     */
    public static void UsageToJson(ArrayList<Usage> UsageArrayList){
        Gson gson = new Gson();
        String jsonString = gson.toJson(UsageArrayList);
        writeStringToJson(jsonString,usageFileName);
    }

    // fromJson

    /**
     * Read array list from json file
     *
     * @return ArrayList
     */
    public static ArrayList<AllPpInSchl> jsonToAllPp(){
        String jsonString = readStringFromJson(allPeoFileName);
        Type type = new TypeToken<ArrayList<AllPpInSchl>>(){}.getType();
        ArrayList<AllPpInSchl> AllPpArrayList = new Gson().fromJson(jsonString,type);
        return AllPpArrayList;
    }

    /**
     * Read array list from json file
     *
     * @return ArrayList
     */
    public static ArrayList<User> jsonToUser(){
        String jsonString = readStringFromJson(userFileName);
        Type type = new TypeToken<ArrayList<User>>(){}.getType();
        ArrayList<User> UserArrayList = new Gson().fromJson(jsonString,type);
        return UserArrayList;
    }

    /**
     * Read array list from json file
     *
     * @return ArrayList
     */
    public static ArrayList<Manager> jsonToManager(){
        String jsonString = readStringFromJson(managerFileName);
        Type type = new TypeToken<ArrayList<Manager>>(){}.getType();
        ArrayList<Manager> ManagerArrayList = new Gson().fromJson(jsonString,type);
        return ManagerArrayList;
    }

    /**
     * Read array list from json file
     *
     * @return ArrayList
     */
    public static ArrayList<Station> jsonToStation(){
        String jsonString = readStringFromJson(stationFileName);
        Type type = new TypeToken<ArrayList<Station>>(){}.getType();
        ArrayList<Station> StationArrayList = new Gson().fromJson(jsonString,type);
        return StationArrayList;
    }

    /**
     * Read array list from json file
     *
     * @return ArrayList
     */
    public static ArrayList<Usage> jsonToUsage(){
        String jsonString = readStringFromJson(usageFileName);
        Type type = new TypeToken<ArrayList<Usage>>(){}.getType();
        ArrayList<Usage> UsageArrayList = new Gson().fromJson(jsonString,type);
        return UsageArrayList;
    }

}
