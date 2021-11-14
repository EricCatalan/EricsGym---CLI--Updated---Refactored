import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private PrintWriter out;
    private Scanner in;
    public boolean isADouble = false;
    private Double validDoubleInput ;
    private String userInput;

    public String getUserInput() {
        return userInput;
    }

    public boolean isADouble() {
        return isADouble;
    }

    public Menu (InputStream input, OutputStream output){
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    public Object getUserInputCLI (){
        Object choice = null;
        userInput = in.nextLine();
        try{
            choice = Double.valueOf(userInput);
            isADouble = true;

        }catch (NumberFormatException nfe){

        }
        if (choice == null){
            choice = userInput;
        }
       return choice;
        }

        public void displayExList(List<Exercise> exercises){
            System.out.println("");
        for (Exercise ex: exercises){
            System.out.println(ex.getName()); }
        }

        public Object getExercise(){
            System.out.println("");
        System.out.println("What workout would you like to start? ");
        userInput = in.nextLine();
        return  userInput;
        }

        public Object fillWater(){
            System.out.println("You need to fill your water bottle to continue: ");
            userInput = in.nextLine();
            return userInput;
        }
    }

