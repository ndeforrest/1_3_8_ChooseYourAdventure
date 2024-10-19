import java.util.Scanner;

public class ChooseYourOwnAdventure {

    // Rohan's moves stats
    private static double rohanRoundhouseLand = 0.85;
    private static double rohanSpinkickLand = 0.10;
    private static double rohanBackideLand = 0.50;
    private static double rohanFrontLand = 0.80;
    private static double rohanSlideUpLand = 0.75;
    private static double rohanJabLand = 0.90;
    private static double rohanCrossLand = 0.85;
    private static double rohanHookLand = 0.60;
    private static double rohanCatch = 0.40;
    private static double rohanThrow = 0.70;

    // Nolan's moves stats
    private static double nolanRoundhouseLand = 0.85;
    private static double nolanSpinkickLand = 0.50;
    private static double nolanBackideLand = 0.90;
    private static double nolanFrontLand = 0.30;
    private static double nolanSlideUpLand = 0.15;
    private static double nolanJabLand = 0.90;
    private static double nolanCrossLand = 0.85;
    private static double nolanHookLand = 0.60;
    private static double nolanCatch = 0.70;
    private static double nolanThrow = 0.40;

    // Odds of attack
    private static double rohanKickChance = 0.60;
    private static double nolanKickChance = 0.70;
    private static double rohanPunchChance = 0.50;
    private static double nolanPunchChance = 0.60;
    private static double rohanAdvanceChance = 0.60;
    private static double nolanAdvanceChance = 0.30;

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // Trait strings
        String rohanTraits = "Power: 4/5\nSpeed: 2/5\nFleibility: 3/5\nRange: 5/5";
        String nolanTraits = "Power: 3/5\nSpeed: 5/5\nFleibility: 4/5\nRange: 2/5";

        // START GAME
        System.out.println(
                "--------------------------------------\nWelcome to Kung Jung Mu Sul! I'm Sir Nick. Would you like to spar?");
        String start = scan.nextLine();
        if (start.equalsIgnoreCase("yes")) {
            System.out.println("Great! Get your sparring gear on!");
        } else {
            System.out.println("Too bad! Get your sparring gear on!");
        }

        // Color choice
        System.out.println("Do you want a red or blue chestguard?");
        String chestguardColor = scan.nextLine();
        if (chestguardColor.equalsIgnoreCase("red")) {
            System.out.println("Your name is Rohan. Here are your traits: \n" + rohanTraits);
            rohan(); // go to Rohan's start method
        } else if (chestguardColor.equalsIgnoreCase("blue")) {
            System.out.println("Your name is Nolan. Here are your traits: \n" + nolanTraits);
            nolan(); // go to Nolan's start method
        } else {
            System.out.println("No one in Kung Jung Mu Sul uses a " + chestguardColor
                    + " colored chestguard. GET OUT! says Sir Nick. Bye!"); // End game if neither red nor blue is
                                                                            // picked
        }
    }

    // WHEN YOU PLAY AS ROHAN
    public static void rohan() {
        System.out.println("Do you have your mouthguard in, Rohan?");
        while (!((scan.nextLine()).equalsIgnoreCase("yes"))) { // repeat until user inputs yes
            System.out.println(
                    "WRONG! Rohan always has his mouthguard in! Ill let you try again. Do you have your mouthguard in, Rohan?");
        }
        System.out.println("Ok, 3, 2, 1 *ding ding ding* SPAR!");
        System.out.println("Are you on your toes? 'yes' or 'no'");

        String statusToes = scan.nextLine();
        // if user inputs yes to statusToes
        if (statusToes.equalsIgnoreCase("yes")) {
            System.out.println("Good job, at least you're staying on your toes!");
            System.out.println(
                    "Now, what do you want to do? You are currently out of range. Options include 'nothing', 'advance', or 'stupid wild kick', or make your own move up.");

            // user input for "what to do"?
            String firstMove = scan.nextLine();
            // if user picks none of the three options
            while (!(firstMove.equalsIgnoreCase("stupid wild kick") || firstMove.equalsIgnoreCase("nothing")
                    || firstMove.equals("advance"))) {
                System.out.println("What kind of stupid idea is that? Thats dumb! Pick again.");
                firstMove = scan.nextLine(); // get input again
            }
            // if the user inputs 'nothig' to "what to do?"
            while (firstMove.equalsIgnoreCase("nothing")) {
                double randomAdvanceChance = Math.random();
                // if the random chance is greater than nolan's chance of advancing, nolan will
                // advance
                if (randomAdvanceChance >= nolanAdvanceChance) {
                    System.out.println("Heads up! Nolan moved in. You're now in range.");
                    firstMove = "not nothing"; // in order to exit while loop
                    range();
                    // if random chance is less than nolan's chance of advanging, then no one
                    // advanced
                } else {
                    System.out.println(
                            "NEITHER OF YOU DID ANYTHING? Lets go, we're here to spar, not make friends. Rohan, choose another option.");
                    firstMove = scan.nextLine();
                }
            }
            // if user inputs 'stupid wild kick' to "what to do?"
            if (firstMove.equalsIgnoreCase("stupid wild kick")) {
                System.out.println("What was that! That was awful!");
                wildKick(); // go to wild kick method
            }
            // if user inputs 'advance' to "what to do?"
            else if (firstMove.equalsIgnoreCase("advance")) {
                System.out.println("Great job! You moved in to range! Now what?");
                range();
            }

            // if user inputs 'no' to statusToes
        } else {
            System.out.println(
                    "ROHAN! Why aren't you on your toes? Nolan just kicked you in the chest and you fell over! YOU LOSE!");
        }

    }

    // WHEN YOU PLAY AS NOLAN
    public static void nolan() {

    }

    public static void range() {

    }

    public static void punch() {

    }

    public static void wildKick() {

    }

    public static void wrestle() {

    }

}