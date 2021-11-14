public class Lunges extends Exercise {
    private double  amountPerSet = 0;
    private double amountOfSets =0;
    private double minutes = 0;
    private String walkUp = "You find an isolated part of the gym where there is no one around. "+ '\n';
    private final double AVERAGE_PERSON_WEIGHT_IN_KG = (181/2.2);
    private final double MET_VALUE_OF_LUNGES = 4;
    private double caloriesBurned = 0;

    //Formula for calories
    //https://burned-calories.com/sport/lunges

    @Override
    public void workout() {
        caloriesBurned = (AVERAGE_PERSON_WEIGHT_IN_KG * MET_VALUE_OF_LUNGES * .0175 * this.minutes);
    }

    public Lunges() {
        super("Lunges", "Lower Body");
    }

    public void setAmountPerSet(double amountPerSet) {
        this.amountPerSet = amountPerSet;
    }

    public void setAmountOfSets(double amountOfSets) {
        this.amountOfSets = amountOfSets;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }

    public double getAmountPerSet() {
        return amountPerSet;
    }

    public double getAmountOfSets() {
        return amountOfSets;
    }

    public double getMinutes() {
        return minutes;
    }

    public String getWalkUp() {
        return walkUp;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
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
        return "You walk off the tingling in your quads. What would you like to do next? ";
    }
}
