import java.util.ArrayList;     // gson

public class test {

    public static void main(String args[]) {

        // add AllPp
        AllPpInSchl allPpInSchl1 = new AllPpInSchl("12345678", "David", "Wei");
        AllPpInSchl allPpInSchl2 = new AllPpInSchl("87654321", "Moozon", "Wei");
        ArrayList<AllPpInSchl> AllList = new ArrayList<>();
        AllList.add(allPpInSchl1);
        AllList.add(allPpInSchl2);
        ListJsonSwitch.AllPpToJson(AllList);
        ArrayList<AllPpInSchl> AllList2 = ListJsonSwitch.jsonToAllPp();
        System.out.println("All people in school:\n");
        for (AllPpInSchl ap : AllList2) {
            System.out.println(ap.toString());
        }
        System.out.println("----------------------------------------------------\n");

        // add User
        User user1 = new User("88888888", "David", "Wei");
        User user2 = new User("87654321", "Moozon", "Wei");
        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(user1);
        userArrayList.add(user2);
        ListJsonSwitch.UserToJson(userArrayList);
        ArrayList<User> UserList1 = ListJsonSwitch.jsonToUser();
        System.out.println("Users:\n");
        for(User us : UserList1){
            System.out.println(us.toString());
        }
        System.out.println("----------------------------------------------------\n");

        // add Manager
        Manager manager1 = new Manager("123456", "123456", "Manager", "One");
        Manager manager2 = new Manager("654321", "654321", "Manager", "Two");
        ArrayList<Manager> managerArrayList = new ArrayList<>();
        managerArrayList.add(manager1);
        managerArrayList.add(manager2);
        ListJsonSwitch.ManagerToJson(managerArrayList);
        ArrayList<Manager> managerArrayList1 = ListJsonSwitch.jsonToManager();
        System.out.println("Managers:\n");
        for(Manager mng : managerArrayList1){
            System.out.println(mng.toString());
        }
        System.out.println("----------------------------------------------------\n");

        // add Station
        Station stationA = new Station('A');
        Station stationB = new Station('B');
        Station stationC = new Station('C');
        ArrayList<Station> stationArrayList = new ArrayList<>();
        stationArrayList.add(stationA);
        stationArrayList.add(stationB);
        stationArrayList.add(stationC);
        ListJsonSwitch.StationToJson(stationArrayList);
        ArrayList<Station> stationArrayList1 = ListJsonSwitch.jsonToStation();
        System.out.println("Station:\n");
        for(Station station : stationArrayList1){
            System.out.println(station.toString());
        }
        System.out.println("----------------------------------------------------\n");

        // add Usage
        Usage usage1 = new Usage("12345678");   usage1.setPiTime(); usage1.setReturnTime();
        Usage usage2 = new Usage("12345678");   usage2.setPiTime(); usage2.setReturnTime();
        Usage usage3 = new Usage("87654321");   usage3.setPiTime(); usage3.setReturnTime();
        ArrayList<Usage> usageArrayList = new ArrayList<>();
        usageArrayList.add(usage1);
        usageArrayList.add(usage2);
        usageArrayList.add(usage3);
        ListJsonSwitch.UsageToJson(usageArrayList);
        ArrayList<Usage> usageArrayList1 = ListJsonSwitch.jsonToUsage();
        System.out.println("Usage:\n");
        for(Usage usage : usageArrayList1){
            System.out.println(usage.toString());
        }
        System.out.println("----------------------------------------------------\n");
    }
}
