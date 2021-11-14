public class WatterBottle {
    int waterLevel = 0;

    public WatterBottle() {
    }
    public String fillWater(){
        this.waterLevel = 100;
        return "Your water bottle is completely full.";}

    public void drinkWater(){
        this.waterLevel = this.waterLevel - 25;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public String getWaterLevelString(){
        return ( "Your water bottle is " + getWaterLevel() + "% full.");
    }
}
