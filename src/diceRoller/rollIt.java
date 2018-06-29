package diceRoller;
import java.util.Scanner;

public class rollIt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the dice you want to roll: ");
        String diceInput = scanner.next();

        String diceInputElements[] = diceInput.split("d");


        int numberOfDice = Integer.parseInt(diceInputElements[0]);
        int diceSides = Integer.parseInt(diceInputElements[1]);
        double diceResult = 0;

        if(numberOfDice <= 100) {
            if(numberOfDice >= 1) {
                if(diceSides <= 100) {
                    if(diceSides >= 2) {
                        String bonusOutput = "";
                        int i = 0;
                        while(i < numberOfDice) {
                            diceResult = Math.random() * diceSides;
                            i++;
                            bonusOutput += Math.round(diceResult) + " ";
                        }

                        long diceOutput = Math.round(diceResult);

                        System.out.println(diceInput + " = " + diceOutput + ": " + bonusOutput);
                    } else {
                        System.out.println("You might want to check your inputs. You can't have more than 100 or less than 1 dice, and you can't have more than 100 or less than 2 sides to each dice.");
                    }
                    } else {
                    System.out.println("You might want to check your inputs. You can't have more than 100 or less than 1 dice, and you can't have more than 100 or less than 2 sides to each dice.");
                }
                } else {
                System.out.println("You might want to check your inputs. You can't have more than 100 or less than 1 dice, and you can't have more than 100 or less than 2 sides to each dice.");
            }
            } else {
            System.out.println("You might want to check your inputs. You can't have more than 100 or less than 1 dice, and you can't have more than 100 or less than 2 sides to each dice.");
        }
    }
}

