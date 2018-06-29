package diceRoller;
import java.util.Scanner;

public class rollIt {

    public static void main(String[] args) {
        RollAction();
    }


    public static boolean ValidInput(int dVal, int sVal) {
        if(dVal <= 100 && dVal >= 1 && sVal <= 100 && sVal >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void RollAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the dice you want to roll: ");
        String diceInput = scanner.next();

        if(diceInput.equals("q") | diceInput.equals("Q")) {
            System.exit(0);
        }

        String diceInputElements[] = diceInput.split("d");

        int numberOfDice = Integer.parseInt(diceInputElements[0]);
        int diceSides = Integer.parseInt(diceInputElements[1]);
        double diceResult = 0;

        if(ValidInput(numberOfDice, diceSides) == true) {
            String bonusOutput = "";
            int i = 0;
            while (i < numberOfDice) {
                diceResult = Math.random() * diceSides;
                i++;
                bonusOutput += Math.round(diceResult) + " ";
            }

            long diceOutput = Math.round(diceResult);

            System.out.println(diceInput + " = " + diceOutput + ": " + bonusOutput);
            RollAction();
        } else {
            System.out.println("Sorry, invalid input.");
            RollAction();
        }

    }
}

