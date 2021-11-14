public class Plank extends Exercise{

    //Average Calorie Burned For 180lbs
    //https://www.healthline.com/health/exercise-fitness/how-many-calories-does-planking-burn#calories-burned

    private String walkUp = "You get set up in a corner and pull out your timer.  ";
    private double minutes = 0;
    private double caloriesBurned = 0;
    private final double caloriesBurnedPerMinute = 4;

    @Override
    public void workout() {
        caloriesBurned = caloriesBurnedPerMinute * this.minutes;
    }

    public Plank() {
    super("Planks", "Core");
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public String getWalkUp() {
        return walkUp;
    }

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
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
        return "Please enter the amount of minutes you are going to be planking for? ";
    }
    public String exit(){
        return "You get back to your feet. What would you like to do next? ";
    }
}
