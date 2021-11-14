public class StairMachine extends Exercise{
    private String walkUp = "You just walked up to the Stair Machine: "+ '\n';
    private double stepsPerMinute=0;
    private double minutes=0;
    private double caloriesBurned = 0;
    private final double MET_VALUE_OF_SLOW_STAIRS = 4;
    private final double MET_VALUE_OF_MEDIUM_STAIRS = 6.4;
    private final double MET_VALUE_OF_FAST_STAIRS = 8.8;
    private final double AVERAGE_PERSON_WEIGHT_IN_KG = (181/2.2);

    public double getCaloriesBurned() {
        return caloriesBurned;
    }
//Formulas from here
//https://captaincalculator.com/health/calorie/calories-burned-stairs-calculator/
    @Override
    public void workout() {
        if(this.stepsPerMinute <= 58){
            caloriesBurned = ((MET_VALUE_OF_SLOW_STAIRS * AVERAGE_PERSON_WEIGHT_IN_KG * 3.5) /200.0)*this.minutes;
        }else if (this.stepsPerMinute >58 && this.stepsPerMinute <=116){
            caloriesBurned = ((MET_VALUE_OF_MEDIUM_STAIRS * AVERAGE_PERSON_WEIGHT_IN_KG * 3.5) /200.0) * this.minutes;
        }else{
            caloriesBurned = ((MET_VALUE_OF_FAST_STAIRS * AVERAGE_PERSON_WEIGHT_IN_KG * 3.5) /200.0) * this.minutes;
        }

    }

    public StairMachine(){
        super("Stair Machine", "Lower Body");
    }

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }
    public String getWalkUp() {
        return walkUp;
    }

    public double getStepsPerMinute() {
        return stepsPerMinute;
    }

    public void setStepsPerMinute(double stepsPerMinute) {
        this.stepsPerMinute = stepsPerMinute;
    }
    public String stepsPerMinuteInput(){
        return "Please enter your steps per minute: ";
    }

    public boolean setSPMValid(double stepsPerMinute){
        boolean validSpeed = false;
        if (stepsPerMinute <=174 && stepsPerMinute >=0){
            validSpeed = true;
        }else {validSpeed=false;}
        return validSpeed;
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
        return "Please enter the amount of minutes you are going to be using the Stair Machine for: ";
    }
    public String exit(){
        return "You wiped down the Stair Machine.  What would you like to do next?: ";
    }

    public String sphHelp (){
        return "Please enter a SPM between 0-174";}

}
