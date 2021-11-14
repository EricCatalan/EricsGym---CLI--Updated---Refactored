public class SweatBank {
   public int caloriesSweatOut = 0;

    public int getCaloriesSweatOut() {
        return caloriesSweatOut;
    }

    public void setCaloriesSweatOut(int caloriesSweatOut) {
        this.caloriesSweatOut =(this.caloriesSweatOut + caloriesSweatOut);
    }
}
