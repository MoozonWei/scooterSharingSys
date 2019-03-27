# scooterSharingSys

[TOC]

## 1. WHAT IS THE PROJECT ABOUT?

This is a campus scooter sharing system

## 2. FILES

- #### scr

  All the source codes are in this directory

- #### xmind

  All the logic graphs are in this directory

## 3. ENTITY CLASSES

- #### AllPpInSchl.java

  ```java
  public class AllPpInSchl {
      public int QMNo;
      public String fName;
      public String lName;
  }
  ```

  

- #### User.java

  ```java
  public class User {
      public int QMNo;
      public String fName;
      public String lName;
      public String email;
      public boolean fineOrNot;
  }
  
  ```

- ####  Manager.java

  ```java
  public class Manager {
      private String fName;
      private String lName;
      private String ID;
      private String passwd;
  }
  ```

- #### Station.java

  ```java
  public class Station {
      private char stationName;
      private boolean[] slots = new boolean[8];
      private boolean[] lights = new boolean[8];
      
      public int gvMeAScooter()
      public int gvAnEmptySlot()
      public void pickUpScooter()
      public void returnScooter()
  ```

- #### Usage.java

  ```java
  public class Usage {
      public String pickUpTime = "";
      public String returnTime = "";
      public int userQMNo = 0;
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
      private static String allPeoFileName = "allPeo.json";
      private static String userFileName = "user.json";
      private static String managerFileName = "manager.json";
      private static String stationFileName = "station.json";
      private static String usageFileName = "usage.json";
  
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

  
