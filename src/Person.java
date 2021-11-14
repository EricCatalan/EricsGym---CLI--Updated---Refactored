public class Person {
    private int lowerBodyLevel = 0;
    private int coreLevel = 0;
    private int upperBodyLevel = 0;
    private String name = "";
    private String prompt = "\nPlease enter your name: ";
    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrompt() {
        return prompt;
    }

    public int getLowerBodyLevel() {
        return lowerBodyLevel;
    }

    public void setLowerBodyLevel(int lowerBodyLevel) {
        this.lowerBodyLevel = this.lowerBodyLevel + lowerBodyLevel;
    }

    public int getCoreLevel() {
        return coreLevel;
    }

    public void setCoreLevel(int coreLevel) {
        this.coreLevel = coreLevel + this.coreLevel;
    }

    public int getUpperBodyLevel() {
        return upperBodyLevel;
    }

    public void setUpperBodyLevel(int upperBodyLevel) {
        this.upperBodyLevel = upperBodyLevel + this.upperBodyLevel;
    }

    public void mentalBoost(){
        this.upperBodyLevel = this.upperBodyLevel - 1;
        this.coreLevel = this.coreLevel - 1;
        this.lowerBodyLevel = this.lowerBodyLevel - 1;
    }
}
