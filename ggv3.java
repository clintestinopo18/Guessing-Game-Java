import java.util.*;

public class ggv3 {

    Scanner sc = new Scanner(System.in);
    String resp;

        public static void intro(){
            System.out.println("----------------------------------");
            System.out.println("Let's play the Number Guessing Game");
            System.out.println();
            System.out.println("I'll think of a number in range 1..10");
            System.out.println("You will try to guess the number.");
            System.out.println();
            System.out.println("If you guess correctly, you will know.");
            System.out.println("Otherwise, I'll clue you to try higher/lower.");
            System.out.println();
            System.out.println("I have the number now. LET'S BEGIN!!!");
            System.out.println();

            

    }

    public static void intro2(){
            System.out.println("Let's play the Number Guessing Game");
            System.out.println("\nYou'll think of a number in range 1..N");
            System.out.print("What's our N (upper bound): ");
            System.out.println("I will try to guess the number.");
            System.out.println("\nIf I guess correctly, type C.");
            System.out.println("Otherwise, you'll clue me to try higher/lower.");
            System.out.println("Type H for Higher, L for Lower.");
            System.out.println("\nIf you have the number now, LET'S BEGIN!!!\n");
    }


    // Version 1 - User guesses
    public void version1() {
        do {
            intro();


            // Random number from 1 to 10
            int mysteryNumber = new Random().nextInt(10) + 1;

            int guess;
            int tries = 0;

            do {
                System.out.print("Your Guess? ");
                guess = sc.nextInt();
                tries++;

                if (guess < mysteryNumber) {
                    System.out.println("Try Higher!");
                } 
                else if (guess > mysteryNumber) {
                    System.out.println("Try Lower!");
                } 
                else {
                    System.out.println(guess + " is Correct!");
                }

            } while (guess != mysteryNumber);

            System.out.println();
            System.out.println("That took you " + tries + " tries!");

        do {
            System.out.print("\nTry Again (y/Y/n/N)? ");
            resp = sc.next();

            if (!resp.equalsIgnoreCase("y") && !resp.equalsIgnoreCase("n")) {
                System.out.println("Invalid input. Please enter y or n.");
            }
        } while (!resp.equalsIgnoreCase("y") && !resp.equalsIgnoreCase("n"));

        if (resp.equalsIgnoreCase("n")) {
            System.out.println("Thanks for playing!");
        }
        // --- end validation loop ---

    } while (resp.equalsIgnoreCase("y"));
}



    // Version 2 - Computer guesses
    public void version2() {
 
        do {
            intro2();
            System.out.println("----------------------------------");
            int LB = 1;
            int UB;
            System.out.print("What's our N (upper bound): ");
            UB = sc.nextInt();
            


            int ctr = 0;
            String fb;

            do {
                // Computer guesses the middle of the range
                int G = (UB + LB) / 2;

                System.out.print("Is it " + G + " (C/H/L)? ");
                fb = sc.next().toUpperCase();

                System.out.println("--------------------------------------");

                if (fb.equals("H")) {
                    LB = G + 1;
                } 
                else if (fb.equals("L")) {
                    UB = G - 1;
                } 
                else if (fb.equals("C")) {
                    System.out.println("I guessed it!");
                } 
                else {
                    System.out.println("Invalid input. Please enter C, H, or L.");
                }

                if (fb.equals("C") || fb.equals("H") || fb.equals("L")) {
                    ctr++;
                }

            } while (!fb.equals("C"));

            System.out.println("\nThat took me " + ctr + " tries!\n");

        do {
            System.out.print("\nTry Again (y/Y/n/N)? ");
            resp = sc.next();

            if (!resp.equalsIgnoreCase("y") && !resp.equalsIgnoreCase("n")) {
                System.out.println("Invalid input. Please enter y or n.");
            }
        } while (!resp.equalsIgnoreCase("y") && !resp.equalsIgnoreCase("n"));

        if (resp.equalsIgnoreCase("n")) {
            System.out.println("Thanks for playing!");
        }
        // --- end validation loop ---

    } while (resp.equalsIgnoreCase("y"));
    }

//-----------------------------------------------------------------------------------------------------------------

    // Main program
    public static void main(String[] args) {

        Main versions = new Main();
        do {
            System.out.println("==================================================");
            System.out.println("       ULTIMATE NUMBER GUESSING GAME");
            System.out.println("==================================================");
            System.out.println("Choose your game mode:");
            System.out.println("1 - Version 1: YOU guess the computer's number");
            System.out.println("2 - Version 2: COMPUTER guesses your number");
            System.out.println("3 - Exit Program");
            System.out.print("Enter your choice (1, 2, or 3): ");

            //version = for choosing either version 1, 2, or 3 (input)
            //versions = Main method
            int version = versions.sc.nextInt();

            if (version == 1) {
                versions.version1(); //Main method - version 1 
            } 
            else if (version == 2) {
                versions.version2(); //Main method - version 2
            } 
            else if (version == 3) {
                System.out.println("Thanks for playing!"); //Exit program
                break;
            } 
            else {
                System.out.println("Invalid choice!"); //loop to introduction again
            }
            
            if (version == 1 || version == 2) {
                System.out.println("\nReturning to main menu...\n"); 
            }

        } while (true);

    }
}
