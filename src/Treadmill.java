public class Treadmill extends Exercise {
    // https://www.livestrong.com/article/34973-calculate-treadmill-calories/
    //Formulas from here

    //Instance Variables


    private double speed;
    private String walkUp = "You just walked up to the treadmill. " + '\n';
    private double minutes=0;
    private final double AVERAGE_PERSON_WEIGHT_IN_KG = (181/2.2);
    private final double MPH_TO_METERS = 26.8;
    private double caloriesBurned = 0;
    private final double STANDARD_GRADE = .01;
    private double oxygenUsed = 0;
    private double caloriePerMinute = 0;

    public double getCaloriesBurned() {
        return caloriesBurned;
    }
    @Override
    public void workout(){
        //Walking Speed
        if(this.speed <= 3.7){
            oxygenUsed = (0.1 * (this.speed * MPH_TO_METERS)) + (1.8 * (this.speed * MPH_TO_METERS) * STANDARD_GRADE) + 3.5;
        }else{
            oxygenUsed = (0.2 * (this.speed * MPH_TO_METERS)) + (.9 * (this.speed * MPH_TO_METERS) * STANDARD_GRADE) + 3.5;
        }
        caloriePerMinute = ((oxygenUsed * AVERAGE_PERSON_WEIGHT_IN_KG)/ 200);
        caloriesBurned = caloriePerMinute * this.minutes;

    }


    //Getters

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }

    public String getWalkUp() {
        return walkUp;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    //Constructor
    public Treadmill() {
        super("Treadmill", "Lower Body");
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public boolean setSpeedValid(double inputSpeed){
        boolean validSpeed = false;
        if (inputSpeed <=12 && inputSpeed >=0){
            validSpeed = true;
        }else {validSpeed=false;}
    return validSpeed;
    }

    public String mphHelp (){
        return "Please enter a MPH between 0-12";}

    public String speedInput(){
        return "Please enter the speed (In mph):";
    }
    public boolean setMinutesValid(double minutes){
        boolean validMinutes = false;
        if(minutes >0){
            validMinutes = true;
        }else {
            validMinutes=false;
        }return validMinutes;
    }
    public String minuteInput(){
        return "Please enter the amount of minutes you are going to be using the treadmill for: ";
    }
    public String exit(){
        return "You wiped down the treadmill.  What would you like to do next?: ";
    }

}