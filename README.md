# scooterSharingSys

## CONTENTS

#### 	1. WHAT IS THE PROJECT ABOUT?

  This is a project about scooter sharing system of QMUL.


#### 	2. FILE STRUCTURE

  - scr
    
  - jsonFile
    
  - xmind

#### 	3. ENTITY CLASSES

  - AllPpInSchl.java

  - User.java

  - Manager.java

  - Station.java

  - Usage.java

#### 	4. CONTROL CLASSES

- ManSysOp.java
- ListJsonSwitch.java





## 1. WHAT IS THE PROJECT ABOUT?

This is a campus scooter sharing system





## 2. FILE STRUCTURE

- #### scr

  All the source codes are in this directory

- #### jsonFile

  *allPeo.json	manager.json	station.json	usage.json	user.json*

- #### xmind

  All the logic graphs are in this directory

## 3. ENTITY CLASSES

- #### AllPpInSchl.java

  ```java
  public class AllPpInSchl {
      public int QMNo;
      public String fName;
      public String lName;
      
      // constructor
      public AllPpInSchl() 
      public AllPpInSchl(String QMNo, String fName, String lName)
  }
  ```

  

- #### User.java

  ```java
  public class User {
      public String QMNo;
      public String fName;
      public String lName;
      public String email;
      public boolean fineOrNot;
      
      // constructor
      public User()
      public User(String QMNo, String fName, String lName)
      public User(String QMNo, String fName, String lName, String email)
  }
  
  ```

- ####  Manager.java

  ```java
  public class Manager {
      private String ID;
      private String passwd;
      private String fName;
      private String lName;
      
      // constructor
      public Manager()
      public Manager(String ID, String passwd, String fName, String lName)
  }
  ```

- #### Station.java

  ```java
  public class Station {
      private char stationName;
      private boolean[] slots;
      private boolean[] lights;
      
      // constructor
      public Station()
      public Station(char stationName)
      
      // functional methods
      public int gvMeAScooter()
      public int gvAnEmptySlot()
      public void pickUpScooter()
      public void returnScooter()
  ```

- #### Usage.java

  ```java
  public class Usage {
      public String userQMNo;
      public String pickUpTime = null;
      public String returnTime = null;
      
      // constructor
      public Usage()
      public Usage(String userQMNo)
  }
  ```






## 4. CONTROL CLASSES

- #### ManSysOp.java

  ```java
  public class ManSysOp {
      
      public static boolean loginCheck(ArrayList<Manager> managerArrayList, String ID, String passwd)
          
  }
  ```

  

- #### ListJsonSwitch.java

  ```java
  public class ListJsonSwitch {
      private static String allPeoFileName = "jsonFile\\allPeo.json";
      private static String userFileName = "jsonFile\\user.json";
      private static String managerFileName = "jsonFile\\manager.json";
      private static String stationFileName = "jsonFile\\station.json";
      private static String usageFileName = "jsonFile\\usage.json";
  
      // read & write
      private static void writeStringToJson(String jsonString, String fileName)
      private static String readStringFromJson(String fileName)
      // toJson
      public static void AllPpToJson(ArrayList<AllPpInSchl> AllPpArrayList)
      public static void UserToJson(ArrayList<User> UserArrayList)
      public static void ManagerToJson(ArrayList<Manager> ManagerArrayList)
      public static void StationToJson(ArrayList<Station> StationArrayList)
      public static void UsageToJson(ArrayList<Usage> UsageArrayList)
      // fromJson
      public static ArrayList<AllPpInSchl> jsonToAllPp()
      public static ArrayList<User> jsonToUser()
      public static ArrayList<Manager> jsonToManager()
      public static ArrayList<Station> jsonToStation()
      public static ArrayList<Usage> jsonToUsage()
  }
  ```




