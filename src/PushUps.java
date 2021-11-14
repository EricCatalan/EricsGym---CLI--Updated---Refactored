public class PushUps  extends Exercise{
    private double  amountPerSet = 0;
    private double amountOfSets =0;
    private String walkUp = "You walk over to the corner of the gym where there are mats on the floor. "+ '\n';
    public PushUps() {
        super("PushUps", "Core");
    }
    private final double AVERAGE_CALORIE_BURNED_PER_PUSHUP = .45; // Used mean of .3 and .6
    private double caloriesBurned = 0;

    //Used this for calories
    //https://burned-calories.com/sport/push-ups


    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    @Override
    public void workout() {
        caloriesBurned = (this.amountOfSets * this.amountPerSet) * AVERAGE_CALORIE_BURNED_PER_PUSHUP;
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
    public String exit(){
        return "You get up off the floor and wipe the sweat off your forehead. What would you like to do next? ";
    }

}
