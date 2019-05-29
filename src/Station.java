import java.util.ArrayList;

public class Station {
    private char stationName = 0;                    // the name of the station (A, B, C)
    private boolean[] slots;        // the condition of every slots in this station (0---there is no scooter in this slots, 1---there is a scooter in this slot)
    private boolean[] lights;       // 1---on, 0---off

    // constructor
    public Station() {
        slots = new boolean[8];
        lights = new boolean[8];
    }
    public Station(char stationName){
        this.setStationName(stationName);
        slots = new boolean[8];
        lights = new boolean[8];
    }
    // getters
    public char getStationName() {                   // return the name of the station
        return stationName;
    }
    public boolean getSlot(int i) {                // return a boolean value of the i-th slot
        return slots[i];
    }
    public boolean getLight(int i) {               // return a boolean value of the i-th light
        return lights[i];
    }
    public int gvMeAScooter() {      // return i means there's a scooter in slot[i], 8 means there's no more scooter
        int i;
        for (i = 0; i < 8; i++) {
            if (getSlot(i))            // ������slot���г��ͷ���i
                break;
        }                           // ѭ������ʱ��������;û��break����û���ҵ�������ʱiֵΪ8
        return i;
    }
    public int gvAnEmptySlot() {     // return i means it's empty in slot[i], 8 means no more empty slot
        int i;
        for (i = 0; i < 8; i++) {
            if (!getSlot(i))           // ������slot���޳��ͷ���i
                break;
        }                           // ѭ������ʱ��������;û��break����û���ҵ���λ����ʱiֵΪ8
        return i;
    }
    // setters
    public void setStationName(char stationName) {
        this.stationName = stationName;
    }
    public void setSlot(int i, boolean j) {        // set the i-th slot to j (true/false)
        if (i < 8 && i >= 0)
            this.slots[i] = j;
    }
    public void setLight(int i, boolean j) {       // set the i-th light to j (true/false)
        if (i < 8 && i >= 0)
            this.lights[i] = j;
    }

    @Override
    public String toString() {
        return ("station name: " + this.getStationName() + "\n" +
                "slots condition: " + "0[" + this.getSlot(0) + "] 1[" + this.getSlot(1) + "] " +
                                      "2[" + this.getSlot(2) + "] 3[" + this.getSlot(3) + "] " +
                                      "4[" + this.getSlot(4) + "] 5[" + this.getSlot(5) + "] " +
                                      "6[" + this.getSlot(6) + "] 7[" + this.getSlot(7) + "]\n" +
                "lights condition: " + "0[" + this.getLight(0) + "] 1[" + this.getLight(1) + "] " +
                                       "2[" + this.getLight(2) + "] 3[" + this.getLight(3) + "] " +
                                       "4[" + this.getLight(4) + "] 5[" + this.getLight(5) + "] " +
                                       "6[" + this.getLight(6) + "] 7[" + this.getLight(7) + "]" + "\n");
    }

    public static void main(String args[]) {
    	Station stationA=new Station('A');
    	ArrayList<Station> stationList = ListJsonSwitch.jsonToStation();
    	stationA=stationList.get(0);
    	
    	ListJsonSwitch.StationToJson(stationList);
    }
}
