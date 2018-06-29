package diceRoller;
import java.util.Scanner;

public class rollIt {

    public static void main(String[] args) {
        String inBuffer = ReadInput();

        if(VerifySyntax(inBuffer) == true && ValidInput(Integer.parseInt(SplitInput(inBuffer)[0]), Integer.parseInt(SplitInput(inBuffer)[1])) == true) {
            RollAction(Integer.parseInt(SplitInput(inBuffer)[0]), Integer.parseInt(SplitInput(inBuffer)[1]), inBuffer);
        }

        main(null);
    }

    public static boolean ValidInput(int dVal, int sVal) {
        if(dVal <= 100 && dVal >= 1 && sVal <= 100 && sVal >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void RollAction(int dVal, int sVal, String rawInput) {

        double diceResult = 0;

        String bonusOutput = "";
            int i = 0;
            while (i < dVal) {
                diceResult = Math.random() * sVal;
                i++;
                bonusOutput += Math.round(diceResult) + " ";
            }

            long diceOutput = Math.round(diceResult);

            System.out.println(rawInput + " = " + diceOutput + ": " + bonusOutput);
            main(null);
    }

    public static void DisplaySyntax() {
        System.out.println("Use [XdX], X being a number of your choosing. The X before the d says how many dice to roll. The X after the d says how many sides there are to each dice.");
        main(null);
    }

    public static String ReadInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my dice roller. Type a dice you want to roll or exit using the command [q]");
        System.out.println("To view the correct syntax for this program, type [syn]");
        System.out.println("Enter the dice you want to roll: ");
        return scanner.next();
    }

    public static boolean VerifySyntax(String userInput) {
        if(userInput.equals("syn")) {
            DisplaySyntax();
        }

        if(!userInput.contains("d")) {
            if(userInput.equals("q") | userInput.equals("Q")) {
                System.exit(0);
            } else {
                System.out.println("Input has an incorrect format. Use [*d*] to roll a dice, or [q] to quit the program");
                main(null);
            }
        }

        String diceInputElements[] = userInput.split("d");
        try {
            int numberOfDice = Integer.parseInt(diceInputElements[0]);
        } catch(java.lang.NumberFormatException e)  {
            System.out.println("Input has an incorrect format. Use [*d*] to roll a dice, or [q] to quit the program");
           return false;
        }

        try {
            int diceSides = Integer.parseInt(diceInputElements[1]);
        } catch(java.lang.NumberFormatException e)  {
            System.out.println("Input has an incorrect format. Use [*d*] to roll a dice, or [q] to quit the program");
            return false;
        }

        return true;
    }

    public static String[] SplitInput(String userInput) {
        return userInput.split("d");
    }
}

