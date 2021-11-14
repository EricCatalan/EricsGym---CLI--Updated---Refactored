public class Bench extends Exercise{

    private double minutes = 0;
    private String walkUp = "You find an empty bench and lay down. "+ '\n';
    private final double AVERAGE_PERSON_WEIGHT_IN_KG = (181/2.2);
    private final double AVERAGE_CALORIES_BURNED_PER_MIN = (399/6); // This is the mean of 266-532 range per hour
    private double caloriesBurned = 0;
    private double  amountPerSet = 0;
    private double amountOfSets =0;


    @Override
    public void workout() {
        caloriesBurned = (this.minutes * AVERAGE_CALORIES_BURNED_PER_MIN);
    }

    //Calories per Hour
    // https://www.livestrong.com/article/446824-how-many-calories-do-i-burn-when-i-bench-press/
    public Bench() {
        super("Bench", "Upper Body");
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
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

    public boolean setMinutesValid(double minutes){
        boolean validMinutes = false;
        if(minutes >0){
            validMinutes = true;
        }else {
            validMinutes=false;
        }return validMinutes;
    }
    public String minuteInput(){
        return "Please enter the amount of minutes you are going to be benching for: ";
    }
    public String exit(){
        return "You put all the weights back.  What would you like to do next?: ";
    }

    public double getAmountPerSet() {
        return amountPerSet;
    }

    public void setAmountPerSet(double amountPerSet) {
        this.amountPerSet = amountPerSet;
    }

    public double getAmountOfSets() {
        return amountOfSets;
    }

    public void setAmountOfSets(double amountOfSets) {
        this.amountOfSets = amountOfSets;
    }
    public boolean setAOSValid(double amountOfSets){
        boolean validAmount = false;
        if (amountOfSets >0){
            validAmount = true;
        }else {validAmount=false;}
        return validAmount;
    }
    public String amountOfSetInput(){
        return "Please enter the amount of sets: ";
    }
    public boolean setAPSValid(double amountPerSet){
        boolean validAmount = false;
        if (amountPerSet >0){
            validAmount = true;
        }else {validAmount=false;}
        return validAmount;
    }
    public String amountPerSetInput(){
        return "Please enter the amount of reps per set: ";
    }
}
