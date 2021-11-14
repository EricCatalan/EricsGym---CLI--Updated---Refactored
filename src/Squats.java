public class Squats extends Exercise {

    private double  amountPerSet = 0;
    private double amountOfSets =0;
    private double minutes = 0;
    private String walkUp = "You find an isolated part of the gym where there is no one around. "+ '\n';
    private final double AVERAGE_PERSON_WEIGHT_IN_KG = (181/2.2);
    private final double MET_VALUE_OF_SQUATS = 5.5;
    private double caloriesBurned = 0;

//Calories burned formula pulled from here
//https://burned-calories.com/sport/squats

    @Override
    public void workout() {
        caloriesBurned = (AVERAGE_PERSON_WEIGHT_IN_KG * MET_VALUE_OF_SQUATS *0.0175 * this.minutes);
    }

    public Squats() {
        super("Squats", "Lower Body");
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

    public double getAmountPerSet() {
        return amountPerSet;
    }

    public String getWalkUp() {
        return walkUp;
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
    public boolean setMinutesValid(double minutes) {
        boolean validAmount = false;
        if (minutes > 0) {
            validAmount = true;
        } else {
            validAmount = false;
        }
        return validAmount;
    }
    public String minutesInput(){
        return "Please enter the amount of minutes you are going to be doing squats for: ";
    }
    public String exit(){
        return "You start shaking out your legs... they are burning. What would you like to do next? ";
    }

}
