public class Station {
    private char stationName = 'Z';                    // the name of the station (A, B, C)
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
    public boolean getSlots(int i) {                // return a boolean value of the i-th slot
        return slots[i];
    }
    public boolean getLights(int i) {               // return a boolean value of the i-th light
        return lights[i];
    }
    // setters
    public void setStationName(char stationName) {
        this.stationName = stationName;
    }
    public void setSlots(int i, boolean j) {        // set the i-th slot to j (true/false)
        if (i < 8 && i >= 0)
            this.slots[i] = j;
    }
    public void setLights(int i, boolean j) {       // set the i-th light to j (true/false)
        if (i < 8 && i >= 0)
            this.lights[i] = j;
    }

    @Override
    public String toString() {
        return ("station name: " + this.getStationName() + "\n" +
                "slots condition: " + "0[" + this.getSlots(0) + "] 1[" + this.getSlots(1) + "] " +
                                      "2[" + this.getSlots(2) + "] 3[" + this.getSlots(3) + "] " +
                                      "4[" + this.getSlots(4) + "] 5[" + this.getSlots(5) + "] " +
                                      "6[" + this.getSlots(6) + "] 7[" + this.getSlots(7) + "]\n" +
                "lights condition: " + "0[" + this.getLights(0) + "] 1[" + this.getLights(1) + "] " +
                                       "2[" + this.getLights(2) + "] 3[" + this.getLights(3) + "] " +
                                       "4[" + this.getLights(4) + "] 5[" + this.getLights(5) + "] " +
                                       "6[" + this.getLights(6) + "] 7[" + this.getLights(7) + "]" + "\n");
    }

    // functional methods
    public int gvMeAScooter() {      // return i means there's a scooter in slot[i], 8 means there's no more scooter
        int i;
        for (i = 0; i < 8; i++) {
            if (getSlots(i))            // 遍历找slot，有车就返回i
                break;
        }                           // 循环结束时，表明中途没有break，即没有找到车，此时i值为8
        return i;
    }

    public int gvAnEmptySlot() {     // return i means it's empty in slot[i], 8 means no more empty slot
        int i;
        for (i = 0; i < 8; i++) {
            if (!getSlots(i))           // 遍历找slot，无车就返回i
                break;
        }                           // 循环结束时，表明中途没有break，即没有找到空位，此时i值为8
        return i;
    }

    public void pickUpScooter() {
        int availableSlot = this.gvMeAScooter();
        if (availableSlot >= 0 && availableSlot < 8) {
            this.setLights(availableSlot, true);             // 在可以取车的位置亮灯
            // 计时，
        } else {
            // 没有车了
        }
    }

    public void returnScooter() {

    }
}
