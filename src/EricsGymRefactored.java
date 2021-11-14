import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EricsGymRefactored {
private Menu menu;
private List<Exercise> exercises = new ArrayList<>();
private SweatBank sweatBank = new SweatBank();
private Treadmill treadmill = new Treadmill();
private StairMachine stairMachine = new StairMachine();
private PushUps pushUps = new PushUps();
private Squats squats = new Squats();
private MirrorSelfie mirrorSelfie = new MirrorSelfie();
private Lunges lunges = new Lunges();
private Person person = new Person();
private Plank plank = new Plank();
private Bench bench = new Bench();
private double numberInput =0;
private WatterBottle userWaterBottle = new WatterBottle();
private String waterInput;
private String nameInput;


private File logFile = new File("log.txt");
private boolean loggingEnabled = true;
private Logger gymLog = null;


    public EricsGymRefactored(Menu menu) {
        this.menu = menu;

        exercises.add(treadmill);
        exercises.add(stairMachine);
        exercises.add(pushUps);
        exercises.add(squats);
        exercises.add(mirrorSelfie);
        exercises.add(lunges);
        exercises.add(plank);
        exercises.add(bench);
    }

    public void logSetUp(){
        try{
            gymLog = new Logger(logFile,true);
        }catch(Exception e){
            loggingEnabled = false;
        }
    }

    public void run(){
        logSetUp();
        enterGym();
        gymMenu();
        }

    public void enterGym(){
    System.out.println("Welcome to Eric's Gym");
    System.out.println("Enjoy your free water bottle.  You wont be able to work out when your water bottle is at 0%.");
    System.out.println("If you would like to leave, please type leave when prompted for next exercise. ");
    System.out.print("Please type Fill Water to start your workout: ");
    fillWaterEnter();
    }

    public void fillWaterEnter() {
        boolean start = false;
        while (!start) {
            try {
                waterInput = (String) menu.getUserInputCLI();
                if (waterInput.toLowerCase().equals("fill water")) {
                    while (person.getName().equals("")) {
                        try {
                            System.out.println(person.getPrompt());
                            nameInput = (String) menu.getUserInputCLI();
                            person.setName(nameInput);
                            start = true;
                        } catch (ClassCastException cce) {
                            System.out.println("Please don't enter a number: ");
                        }
                    }
                } else {
                    System.out.print("Please type Fill Water to start your workout: \n");
                }
            } catch (ClassCastException cce) {
                System.out.println("Please don't enter a number: ");
            }
        }

        if (waterInput.toLowerCase().equals("leave")) {
            System.out.println("Thanks for coming to Eric's Gym! ");
            System.exit(1);
        } else if (waterInput.toLowerCase().equals("fill water")) {
            System.out.println(userWaterBottle.fillWater());
        }
    }

    public void gymMenu() {
        while (true) {
            menu.displayExList(exercises);
            String choice = (String) menu.getExercise();
            if (userWaterBottle.getWaterLevel()==0 ) {
                needToFillWater();
            }else if(choice.toLowerCase().equals("fill water")){
                goToFillWater();
            }else if (choice.toLowerCase().equals("treadmill")) {
                goToTreadmill();
            } else if (choice.toLowerCase().equals("stair machine")) {
                goToStairMachine();
            } else if (choice.toLowerCase().equals("pushups")) {
                goToPushUps();
            } else if (choice.toLowerCase().equals("squats")) {
                goToSquats();
            } else if (choice.toLowerCase().equals("mirror selfie")) {
                goToMirrorSelfie();
            } else if (choice.toLowerCase().equals("lunges")) {
                goToLunges();
            } else if (choice.toLowerCase().equals("planks")) {
                goToPlanks();
            } else if (choice.toLowerCase().equals("bench")) {
                goToBench();
            } else if (choice.toLowerCase().equals("leave")) {
                leave();
            }else{
                 gymMenu();
            }
        }

    }

    public void goToTreadmill(){
        boolean usingTreadmill = true;
        System.out.println(treadmill.getWalkUp());
        while (usingTreadmill) {
            try {
                System.out.println(treadmill.speedInput());
                numberInput = (double) menu.getUserInputCLI();
                if (treadmill.setSpeedValid(numberInput)) {
                    treadmill.setSpeed(numberInput);
                    try {
                        System.out.println(treadmill.minuteInput());
                        numberInput = (double) menu.getUserInputCLI();
                        if (treadmill.setMinutesValid(numberInput)) {
                            treadmill.setMinutes(numberInput);
                            treadmill.workout();
                            person.setLowerBodyLevel(1);
                            if (person.getLowerBodyLevel() >= 6) {
                                System.out.println("Oh no! You over worked your lower body and had to leave!");
                                leave();
                            } else {
                                sweatBank.setCaloriesSweatOut((int) treadmill.getCaloriesBurned());
                                gymLog.log(treadmill.getSpeed() + " MPH", treadmill.getMinutes() + " minutes ", (int) treadmill.getCaloriesBurned() + " calories burned using the " + treadmill.getName(), sweatBank.getCaloriesSweatOut() + " total calories burned for " + person.getName());
                                userWaterBottle.drinkWater();
                                System.out.println('\n' + "You burned " + (int) treadmill.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! ");
                                System.out.println(userWaterBottle.getWaterLevelString() + '\n' + treadmill.exit());
                            }
                            usingTreadmill = false;
                            gymMenu();
                        } else {
                            System.out.println("Please enter a positive value: " + '\n');
                        }
                    } catch (ClassCastException cce) {
                        System.out.print("Please only enter a numerical value. " + '\n');
                    }
                } else {
                    System.out.println(treadmill.mphHelp());
                }
            } catch (ClassCastException cce) {
                System.out.print("Please only enter a numerical value. " + '\n');
            }
        }}

    public void goToStairMachine() {
        boolean usingStairMachine = true;
        System.out.println( stairMachine.getWalkUp());
        while(usingStairMachine){
                try {
                    System.out.println(stairMachine.stepsPerMinuteInput());
                    numberInput = (double) menu.getUserInputCLI();
                    if (stairMachine.setSPMValid(numberInput)) {
                        stairMachine.setStepsPerMinute(numberInput);
                            try {
                                System.out.println(stairMachine.minuteInput());
                                numberInput = (double) menu.getUserInputCLI();
                                if (stairMachine.setMinutesValid(numberInput)) {
                                    stairMachine.setMinutes(numberInput);
                                    stairMachine.workout();
                                    person.setLowerBodyLevel(1);
                                    if(person.getLowerBodyLevel()>=6){
                                        System.out.println("Oh no! You over worked your lower body and had to leave!");
                                        leave();
                                    }else{
                                        sweatBank.setCaloriesSweatOut((int) stairMachine.getCaloriesBurned());
                                        gymLog.log((int)stairMachine.getStepsPerMinute() + " SPM", (int)stairMachine.getMinutes() + " minutes ",(int)stairMachine.getCaloriesBurned() + " calories burned using " + stairMachine.getName(),sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName() );
                                        userWaterBottle.drinkWater();
                                        System.out.println('\n'+"You burned "+ (int) stairMachine.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! "  );
                                        System.out.println(userWaterBottle.getWaterLevelString() + '\n' + stairMachine.exit() );}
                                    usingStairMachine = false;
                                    gymMenu();
                                } else {
                                    System.out.println("Please enter a positive value: "+ '\n');

                                }
                            } catch (ClassCastException cce) {
                                System.out.print("Please only enter a numerical value. "+ '\n');
                            }
                    } else {
                        System.out.println(stairMachine.sphHelp());
                    }
                } catch (ClassCastException cce) {
                    System.out.print("Please only enter a numerical value. "+ '\n');
                }}
                }

    public void goToPushUps() {
        boolean doingPushUps = true;
        System.out.println(pushUps.getWalkUp());
        while(doingPushUps){
            try {
                System.out.println(pushUps.amountPerSetInput());
                numberInput = (double) menu.getUserInputCLI();
                if (pushUps.setAPSValid(numberInput)) {
                    pushUps.setAmountPerSet(numberInput);
                        try {
                            System.out.println(pushUps.amountOfSetInput());
                            numberInput = (double) menu.getUserInputCLI();
                            if (pushUps.setAOSValid(numberInput)) {
                                pushUps.setAmountOfSets(numberInput);
                                pushUps.workout();
                                person.setCoreLevel(1);
                                if (person.getCoreLevel() >= 6) {
                                    System.out.println("Oh no! You over worked your core and had to leave!");
                                    leave();
                                } else {
                                    sweatBank.setCaloriesSweatOut((int) pushUps.getCaloriesBurned());
                                    gymLog.log((int) pushUps.getAmountOfSets() + " Sets of " + (int) pushUps.getAmountPerSet(), " There are no minute restrictions. ", (int) pushUps.getCaloriesBurned() + " calories burned doing " + pushUps.getName() + " ", sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName());
                                    userWaterBottle.drinkWater();
                                    System.out.println('\n' + "You burned " + (int) pushUps.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! ");
                                    System.out.println(userWaterBottle.getWaterLevelString() + '\n' + pushUps.exit());
                                }
                                doingPushUps = false;
                                gymMenu();
                            } else {
                                System.out.println("Please enter a positive value: " + '\n');
                            }
                        } catch (ClassCastException cce) {
                            System.out.print("Please only enter a numerical value. " + '\n');
                        }
                } else {
                    System.out.println("Please enter a positive value: " + '\n');
                }
            } catch (ClassCastException cce) {
                System.out.print("Please only enter a numerical value. " + '\n');
            }
            }}

    public void goToSquats(){
        boolean doingSquats = true;
            System.out.println(squats.getWalkUp());
            while(doingSquats){
                try{
                    System.out.println(squats.amountPerSetInput());
                    numberInput = (double) menu.getUserInputCLI();
                    if(squats.setAPSValid( numberInput)){
                        squats.setAmountPerSet(numberInput);
                            try{
                                System.out.println(squats.amountOfSetInput());
                                numberInput = (double) menu.getUserInputCLI();
                                if(squats.setAOSValid(numberInput)){
                                    squats.setAmountOfSets( numberInput);
                                        try{
                                            System.out.println(squats.minutesInput());
                                            numberInput = (double) menu.getUserInputCLI();
                                            if(squats.setMinutesValid(numberInput)){
                                                squats.setMinutes( numberInput);
                                                squats.workout();
                                                person.setLowerBodyLevel(1);
                                                if(person.getLowerBodyLevel()>=6){
                                                    System.out.println("Oh no! You over worked your lower body and had to leave!");
                                                   leave();
                                                }else{
                                                    sweatBank.setCaloriesSweatOut((int)squats.getCaloriesBurned());
                                                    gymLog.log((int)squats.getAmountOfSets() + " Sets of " + (int)squats.getAmountPerSet(), squats.getMinutes() + " minutes ",(int)squats.getCaloriesBurned() + " calories burned doing " + squats.getName() + " ", sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName() );
                                                    userWaterBottle.drinkWater();
                                                    System.out.println('\n'+"You burned "+ (int) squats.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! "  );
                                                    System.out.println(userWaterBottle.getWaterLevelString() + '\n' + squats.exit() );}
                                                    doingSquats = false;
                                                    gymMenu();}
                                            else{
                                                System.out.println("Please enter a positive value: "+ '\n');
                                            }}catch (ClassCastException cce){
                                            System.out.print("Please only enter a numerical value. "+ '\n');
                                        }
                                } else{
                                    System.out.println("Please enter a positive value: "+ '\n');
                                }
                            }catch (ClassCastException cce){
                                System.out.print("Please only enter a numerical value. "+ '\n');
                            }
                        }
                    else{
                        System.out.println("Please enter a positive value: "+ '\n');
                    }
                }
                catch (ClassCastException cce) {
                    System.out.print("Please only enter a numerical value. " + '\n');
                }}
    }

    public void goToLunges(){
        boolean doingLunges = true;
            System.out.println( lunges.getWalkUp());
            while(doingLunges){
                try{
                    System.out.println(lunges.amountPerSetInput());
                    numberInput = (double) menu.getUserInputCLI();
                    if(lunges.setAPSValid( numberInput)){
                        lunges.setAmountPerSet(numberInput);
                            try{
                                System.out.println(lunges.amountOfSetInput());
                                numberInput = (double) menu.getUserInputCLI();
                                if(lunges.setAOSValid(numberInput)){
                                    lunges.setAmountOfSets( numberInput);
                                        try{
                                            System.out.println(lunges.minutesInput());
                                            numberInput = (double) menu.getUserInputCLI();
                                            if(lunges.setMinutesValid(numberInput)){
                                                lunges.setMinutes( numberInput);
                                                lunges.workout();
                                                person.setLowerBodyLevel(1);
                                                if(person.getLowerBodyLevel()>=6){
                                                    System.out.println("Oh no! You over worked your lower body and had to leave!");
                                                    leave();
                                                }else{
                                                    sweatBank.setCaloriesSweatOut((int)lunges.getCaloriesBurned());
                                                    gymLog.log((int)lunges.getAmountOfSets() + " Sets of " + (int)lunges.getAmountPerSet(), " for " +(int)lunges.getMinutes() + " minutes ",(int) lunges.getCaloriesBurned() + " calories burned doing  " + lunges.getName() + " ",sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName() );
                                                    userWaterBottle.drinkWater();
                                                    System.out.println('\n'+"You burned "+ (int) lunges.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! "  );
                                                    System.out.println(userWaterBottle.getWaterLevelString() + '\n' + lunges.exit() );}
                                                    doingLunges = false;
                                                    gymMenu();}
                                            else{
                                                System.out.println("Please enter a positive value: "+ '\n');
                                            }}catch (ClassCastException cce){
                                            System.out.print("Please only enter a numerical value. "+ '\n');
                                        }
                                }
                                else{
                                    System.out.println("Please enter a positive value: "+ '\n');
                                }
                            }catch (ClassCastException cce){
                                System.out.print("Please only enter a numerical value. "+ '\n');
                            }
                        }
                    else{
                        System.out.println("Please enter a positive value: "+ '\n');
                    }
                }
                catch (ClassCastException cce){
                    System.out.print("Please only enter a numerical value. "+ '\n');
                }}
    }

    public void goToMirrorSelfie(){
        System.out.println( mirrorSelfie.getWalkUp());
        person.mentalBoost();
        gymLog.log("1 picture taken ", "in no time! ","No calories were burned but " + person.getName() + " burned ",sweatBank.getCaloriesSweatOut() + " total calories" );
           gymMenu();
    }

    public void needToFillWater(){
        boolean didTheyFill = false;
        while(!didTheyFill){
        String input = (String) menu.fillWater();
        if(input.toLowerCase().equals("fill water")){
            System.out.println(userWaterBottle.fillWater());
            didTheyFill=true;
            gymMenu();
        }else if( input.toLowerCase().equals("leave")){
            leave();
        }
    }}

    public void goToFillWater(){
        System.out.println(userWaterBottle.fillWater());
        gymMenu();
    }

    public void goToPlanks(){
        boolean doingPlanks = true;
            System.out.println(plank.getWalkUp());
            while(doingPlanks){
                try {
                    System.out.println(plank.minuteInput());
                    numberInput = (double) menu.getUserInputCLI();
                    if (plank.setMinutesValid(numberInput)) {
                        plank.setMinutes(numberInput);
                        plank.workout();
                        person.setCoreLevel(1);
                        if(person.getCoreLevel()>=6){
                            System.out.println("Oh no! You over worked your core and had to leave!");
                            leave();
                        }else{
                            userWaterBottle.drinkWater();
                            sweatBank.setCaloriesSweatOut((int) plank.getCaloriesBurned());
                            gymLog.log("Planks arent rep'd based. " + person.getName() + " did ", plank.getMinutes() + " minutes ",(int)plank.getCaloriesBurned() + " calories burned doing " + plank.getName() + " ",sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName() );
                            System.out.println('\n' + "You burned " + (int) plank.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! ");
                            System.out.println(userWaterBottle.getWaterLevelString() + '\n' + plank.exit());}
                            doingPlanks = false;
                            gymMenu();
                    } else {
                        System.out.println("Please enter a positive value: " + '\n');
                    }
                } catch (ClassCastException cce) {
                    System.out.print("Please only enter a numerical value. " + '\n');
                }}
        }

    public void goToBench(){
        boolean doingBench = true;
                 System.out.println( bench.getWalkUp());
                 while (doingBench){
                 try{
                    System.out.println(bench.amountPerSetInput());
                    numberInput = (double) menu.getUserInputCLI();
                    if(bench.setAPSValid( numberInput)){
                        bench.setAmountPerSet(numberInput);
                            try{
                                System.out.println(bench.amountOfSetInput());
                                numberInput = (double) menu.getUserInputCLI();
                                if(bench.setAOSValid(numberInput)){
                                    bench.setAmountOfSets( numberInput);
                                        try{
                                            System.out.println(bench.minuteInput());
                                            numberInput = (double) menu.getUserInputCLI();
                                            if(bench.setMinutesValid(numberInput)){
                                                bench.setMinutes( numberInput);
                                                bench.workout();
                                                person.setUpperBodyLevel(1);
                                                if(person.getUpperBodyLevel()>=6){
                                                    System.out.println("Oh no! You over worked your upper body and had to leave!");
                                                    leave();
                                                }else{
                                                    sweatBank.setCaloriesSweatOut((int)bench.getCaloriesBurned());
                                                    gymLog.log((int)bench.getAmountOfSets() + " Sets of " + (int)bench.getAmountPerSet(), bench.getMinutes() + " minutes ",(int)bench.getCaloriesBurned() + " calories burned using " + bench.getName(),sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName() );
                                                    userWaterBottle.drinkWater();
                                                    System.out.println('\n'+"You burned "+ (int) bench.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! "  );
                                                    System.out.println(userWaterBottle.getWaterLevelString() + '\n' + bench.exit() );}
                                                    doingBench = false;
                                                    gymMenu(); }
                                            else{
                                                System.out.println("Please enter a positive value: "+ '\n');
                                            }}catch (ClassCastException cce){
                                            System.out.print("Please only enter a numerical value. "+ '\n');
                                        }
                                }
                                else{
                                    System.out.println("Please enter a positive value: "+ '\n');
                                }
                            }catch (ClassCastException cce){
                                System.out.print("Please only enter a numerical value. "+ '\n');
                            }
                        }
                    else{
                        System.out.println("Please enter a positive value: "+ '\n');
                    }
                }
                catch (ClassCastException cce){
                    System.out.print("Please only enter a numerical value. "+ '\n');
                }
                }}

    public void leave(){
        System.out.println("Thanks for coming to Eric's Gym! ");
        System.out.println( person.getName()+  " you did amazing! Your total workout burned " + sweatBank.getCaloriesSweatOut() + " calories!");
        gymLog.closeLog();
        System.exit(1);
    }

    public static void main(String[] args) {
	    Menu menu = new Menu(System.in, System.out);
	    EricsGymRefactored ERG = new EricsGymRefactored(menu);
	    ERG.run();    }
}
