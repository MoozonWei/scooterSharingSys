public class Station {
    private char stationName;                        // the name of the station (A, B, C)
    private boolean[] slots = new boolean[8];        // the condition of every slots in this station (0---there is no scooter in this slots, 1---there is a scooter in this slot)
    private boolean[] lights = new boolean[8];       // 1---on, 0---off

    // getters
    public char getStationName(){                   // return the name of the station
        return stationName;
    }

    public boolean getSlots(int i) {                // return a boolean value of the i-th slot
        return slots[i];
    }

    public boolean getLights(int i) {               // return a boolean value of the i-th light
        return lights[i];
    }

    // setters
    public void setSlots(int i, boolean j) {        // set the i-th slot to j (true/false)
        if(i<8 && i>=0)
            this.slots[i] = j;
    }

    public void setLights(int i, boolean j) {       // set the i-th light to j (true/false)
        if(i<8 && i>=0)
            this.lights[i] = j;
    }

    // functional methods
    public int gvMeAScooter(){                          // return i means there's a scooter in slot[i], 8 means there's no more scooter
        int i;
        for(i=0;i<8;i++){
            if(slots[i])
                break;
        }
        return i;
    }

    public int gvAnEmptySlot(){
        int i;
        for(i=0;i<8;i++){
            if(lights[i])
                break;
        }
        return i;
    }

    public void pickUpScooter(){
        int availableSlot=this.gvMeAScooter();
        if(availableSlot>=0 && availableSlot<8){
            this.setLights(availableSlot,true);             // 在可以取车的位置亮灯
            // 计时，
        }else {
            // 没有车了
        }
    }

    public void returnScooter(){

    }
}
