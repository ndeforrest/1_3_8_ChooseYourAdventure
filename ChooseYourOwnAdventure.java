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
            System.out.println("Your name is Rohan. You are 6'1\" tall, and weigh 160 lbs. Here are your skills: \n"
                    + rohanTraits);
            rohan(); // go to Rohan's start method
        } else if (chestguardColor.equalsIgnoreCase("blue")) {
            System.out.println("Your name is Nolan. You are 5'6\" tall, and weigh 130 lbs. Here are your skills: \n"
                    + nolanTraits);
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
                    "You are currently out of range. You can do 'nothing', 'advance', 'stupid wild kick', or make your own move up.");

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
                if (randomAdvanceChance <= nolanAdvanceChance) {
                    System.out.println("Heads up! Nolan moved in. You're now in range.");
                    firstMove = "not nothing"; // in order to exit while loop
                    rangeRohan();
                    // if random chance is less than nolan's chance of advanging, then no one
                    // advanced
                } else {
                    System.out.println(
                            "(Nolan did not move in)\nNEITHER OF YOU DID ANYTHING? Lets go, we're here to spar, not make friends. Rohan, choose another option.");
                    firstMove = scan.nextLine();
                }
            }
            // if user inputs 'stupid wild kick' to "what to do?"
            if (firstMove.equalsIgnoreCase("stupid wild kick")) {
                System.out.println("What was that! That was awful!");
                wildKickRohan(); // go to wild kick method
            }
            // if user inputs 'advance' to "what to do?"
            else if (firstMove.equalsIgnoreCase("advance")) {
                System.out.println("Great job! You moved in to range! Now what?");
                rangeRohan();
            }

        }
        // if user inputs 'no' to statusToes
        else {
            System.out.println(
                    "ROHAN! Why aren't you on your toes? Nolan just kicked you in the chest and you fell over! YOU LOSE!");
        }

    }

    // WHEN YOU PLAY AS NOLAN
    public static void nolan() {
        System.out.println("Do you have your mouthguard in, Nolan?");
        String mouthguardStatus = scan.nextLine();
        // If user input for "do you have a mouthguard" is neither yes nor no, while
        // loop until it is yes ot no
        while (!(mouthguardStatus.equalsIgnoreCase("yes") || mouthguardStatus.equalsIgnoreCase("no"))) {
            System.out.println("Nolan, I asked you a simple question! Answer it with a yes or no you imbicile.");
            mouthguardStatus = scan.nextLine();
        }
        // if user input for "do you have a mouthguard" is no: end program
        if (mouthguardStatus.equalsIgnoreCase("no")) {
            System.out.println("NOLAN YOU IDIOT! I'VE TOLD YOU TOO MANY TIMES TO USE YOUR MOUTHGUARD. GET OUT!!");
        }
        // if user input for "do you have a mouthguard" is yes, continue program
        else if (mouthguardStatus.equalsIgnoreCase("yes")) {
            System.out.println("Finally, you brought your mouthguard. Maybe you're not as much of an idiot today.");
            System.out.println("Ok, 3, 2, 1 *ding ding ding* SPAR!");
            System.out.println("Now, are you on your toes? 'yes' or 'no'");
            // User input for if on toes
            String statusOnToes = scan.nextLine();
            // if user does not input yes for "if on toes", while loop until yes
            while (!statusOnToes.equalsIgnoreCase("yes")) {
                System.out.println("FALSE! Nolan's always on his toes. Answer again.");
                statusOnToes = scan.nextLine(); // to exit while loop
            }
            // if user inputs yes for "if on toes": continue with more program
            if (statusOnToes.equalsIgnoreCase("yes")) {
                System.out.println(
                        "Ok, now let's fight! What do you want to do? You could do 'nothing', 'advance', 'stupid wild kick', or make your own move up.");
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
                    // if the random chance is greater than rohan's chance of advancing, rohan
                    // advances
                    if (randomAdvanceChance <= rohanAdvanceChance) {
                        System.out.println("Heads up! Rohan moved in. You're now in range.");
                        firstMove = "not nothing"; // in order to exit while loop
                        rangeNolan();
                        // if random chance is less than rohan's chance of advanging, then no one
                        // advanced
                    } else {
                        System.out.println(
                                "(Rohan did not move in)\nNEITHER OF YOU DID ANYTHING? Lets go, we're here to spar, not make friends. Nolan, choose another option.");
                        firstMove = scan.nextLine();
                    }
                }
                // if user inputs 'stupid wild kick' to "what to do?"
                if (firstMove.equalsIgnoreCase("stupid wild kick")) {
                    System.out.println("What was that! That was awful!");
                    wildKickNolan(); // go to wild kick method
                }
                // if user inputs 'advance' to "what to do?"
                else if (firstMove.equalsIgnoreCase("advance")) {
                    System.out.println("Great job! You moved in to range! Now what?");
                    rangeNolan();
                }
            }
        }
    }

    public static void rangeRohan() {
        System.out.println("Ok, you're in kicking range. What are you gonna do? 'advance', 'kick' or 'stay'");
        String rangeInput = scan.nextLine();
        while (!(rangeInput.equalsIgnoreCase("advance") || rangeInput.equalsIgnoreCase("kick") || rangeInput.equalsIgnoreCase("stay") || rangeInput.equalsIgnoreCase("nothing"))) {
            System.out.println("What the heck was that!! Try again!");
            rangeInput = scan.nextLine();
        }
        while (rangeInput.equalsIgnoreCase("stay") || rangeInput.equalsIgnoreCase("nothing")) {
            double randomAdvanceChance = Math.random();
            // if the random chance is less than nolan's chance of advancing, nolan will
            // advance
            if (randomAdvanceChance <= nolanAdvanceChance) {
                System.out.println("Heads up! Nolan stepped in to the inside.");
                rangeInput = "not nothing"; // in order to exit while loop
                punchRohan();
                // if random chance is greater than nolan's chance of advanging, then nolan didnt advanced
            } else {
                System.out.println(
                        "(Nolan did not move in)\nCOME ON ROHAN YOU'RE IN RANGE. Let's goooo pick up the pace!");
                rangeInput = scan.nextLine();
            }
        }
        if (rangeInput.equalsIgnoreCase("advance")) {
            System.out.println("Ok, that's a decision.");
            punchRohan();
        }
        else if (rangeInput.equalsIgnoreCase("kick")) {
            double oppChance = Math.random();
            if (oppChance <= nolanKickChance) {
                System.out.println("You're killing me! you both tried to kick at the same time and clashed shins. Oof! Now center up and keep going.");
                rangeRohan();
            }
            else {
                System.out.println("Which kick do you want to use? 'roundhouse', 'head spin' 'backside' 'front' or 'slide-up side'");
                String kickChoice = scan.nextLine();
                if(kickChoice.equalsIgnoreCase("roundhouse")){
                    double chanceLand = Math.random();
                    System.out.println("Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.");
                    if(chanceLand <= rohanRoundhouseLand){
                        System.out.println("Point: Rohan. Great kick, I taught you well. YOU WIN!");
                    }
                    else{
                        System.out.println("Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                }
                else if(kickChoice.equalsIgnoreCase("head spin")){
                    double chanceLand = Math.random();
                    System.out.println("Rotate your hips halfway around. Make sure to look over your shoulder and spot your target. Try to hit eith the heel. Let's see if you can do it.");
                    if(chanceLand <= rohanSpinkickLand){
                        System.out.println("Point: Rohan. Great aim to the head, I taught you well. YOU WIN!");
                    }
                    else{
                        System.out.println("Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                }
                else if(kickChoice.equalsIgnoreCase("backside")){
                    double chanceLand = Math.random();
                    System.out.println("Pivot your front foot halfway. While standing and turned, spot the target. Don't make this a spin kick. Now try it.");
                    if(chanceLand <= rohanBackideLand){
                        System.out.println("Point: Rohan. Great kick, super strong. YOU WIN!");
                    }
                    else{
                        System.out.println("Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                }
                else if(kickChoice.equalsIgnoreCase("front")){
                    double chanceLand = Math.random();
                    System.out.println("Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.");
                    if(chanceLand <= rohanFrontLand){
                        System.out.println("Point: Rohan. Great kick, I'm the best teacher. YOU WIN!");
                    }
                    else{
                        System.out.println("You messed it up, somehow. You missed");
                        punchRohan();
                    }
                }
                else if(kickChoice.equalsIgnoreCase("slide-up side")){
                    double chanceLand = Math.random();
                    System.out.println("Bring your back foot to your front foot. Then, bring your front food up, and kick to the chest. Remember to pivot your foot.");
                    if(chanceLand <= rohanSlideUpLand){
                        System.out.println("Point: Rohan. Great kick, I taught you well. YOU WIN!");
                    }
                    else{
                        System.out.println("Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                }
                else {
                    System.out.println("You gotta stop making up dumb kicks like that. I'm done. You're acting just like Tino. GET OUT!");
                }
            }
        }
    }

    public static void punchRohan() {
    
    }

    public static void wildKickRohan() {
        double catchChance = Math.random();
        if (catchChance <= nolanCatch) {
            System.out.println("You buffoon! Nolan caught the kick!");
            double throwChance = Math.random();
            if (throwChance <= nolanThrow) {
                System.out.println(
                        "And he threw you to the ground!! That's why you don't do stupid stuff like that, Rohan!");
                System.out.println("YOU LOSE!!!");
            } else {
                System.out.println(
                        "But you toughed it out, and didn't let Nolan throw you. Good job. Now break it up! Let's re-center back to in range.");
                rangeRohan();
            }
        } else {
            System.out.println(
                    "You're lucky that Nolan didn't catch that. You would have been done. But now you're in punching range.");
            punchRohan();
        }
    }

    public static void wrestleRohan() {

    }

    public static void rangeNolan() {
        System.out.println("Ok, you're in kicking range. What are you gonna do? 'advance', 'kick' or 'stay'");
        String rangeInput = scan.nextLine();
        while (!(rangeInput.equalsIgnoreCase("advance") || rangeInput.equalsIgnoreCase("kick") || rangeInput.equalsIgnoreCase("stay") || rangeInput.equalsIgnoreCase("nothing"))) {
            System.out.println("What was that, Nolan!! Try again!");
            rangeInput = scan.nextLine();
        }
        while (rangeInput.equalsIgnoreCase("stay") || rangeInput.equalsIgnoreCase("nothing")) {
            double randomAdvanceChance = Math.random();
            // if the random chance is less than rohan's chance of advancing, rohan will
            // advance
            if (randomAdvanceChance <= rohanAdvanceChance) {
                System.out.println("Heads up! Rohan stepped in to the inside.");
                rangeInput = "not nothing"; // in order to exit while loop
                punchNolan();
                // if random chance is greater than nolan's chance of advanging, then nolan didnt advanced
            } else {
                System.out.println(
                        "(Rohan did not move in)\nCOME ON NOLAN YOU'RE IN RANGE. Stop being lazy!");
                rangeInput = scan.nextLine();
            }
        }
        if (rangeInput.equalsIgnoreCase("advance")) {
            System.out.println("Ok, that's a decision. Good luck trying to punch Rohan.");
            punchNolan();
        }
        else if (rangeInput.equalsIgnoreCase("kick")) {
            double oppChance = Math.random();
            if (oppChance <= rohanKickChance) {
                System.out.println("You're killing me! you both tried to kick at the same time and clashed shins. Dummys! Now center up and keep going.");
                rangeNolan();
            }
            else {
                System.out.println("Which kick do you want to use? 'roundhouse', 'head spin' 'backside' 'front' or 'slide-up side'");
                String kickChoice = scan.nextLine();
                if(kickChoice.equalsIgnoreCase("roundhouse")){
                    double chanceLand = Math.random();
                    System.out.println("Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.");
                    if(chanceLand <= nolanRoundhouseLand){
                        System.out.println("Point: Nolan. Great kick, I taught you well. YOU WIN!");
                    }
                    else{
                        System.out.println("Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                }
                else if(kickChoice.equalsIgnoreCase("head spin")){
                    double chanceLand = Math.random();
                    System.out.println("Rotate your hips halfway around. Make sure to look over your shoulder and spot your target. Try to hit eith the heel. Let's see if you can do it.");
                    if(chanceLand <= nolanSpinkickLand){
                        System.out.println("Point: Nolan. Great aim to the head, I taught you well. YOU WIN!");
                    }
                    else{
                        System.out.println("Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                }
                else if(kickChoice.equalsIgnoreCase("backside")){
                    double chanceLand = Math.random();
                    System.out.println("Pivot your front foot halfway. While standing and turned, spot the target. Don't make this a spin kick. Now try it.");
                    if(chanceLand <= nolanBackideLand){
                        System.out.println("Point: Nolan. Great kick, super strong. YOU WIN!");
                    }
                    else{
                        System.out.println("Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                }
                else if(kickChoice.equalsIgnoreCase("front")){
                    double chanceLand = Math.random();
                    System.out.println("Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.");
                    if(chanceLand <= nolanFrontLand){
                        System.out.println("Point: Nolan. Great kick, I'm the best teacher. YOU WIN!");
                    }
                    else{
                        System.out.println("You messed it up, somehow. You missed");
                        punchNolan();
                    }
                }
                else if(kickChoice.equalsIgnoreCase("slide-up side")){
                    double chanceLand = Math.random();
                    System.out.println("Bring your back foot to your front foot. Then, bring your front food up, and kick to the chest. Remember to pivot your foot.");
                    if(chanceLand <= nolanSlideUpLand){
                        System.out.println("Point: Nolan. Great kick, I taught you well. YOU WIN!");
                    }
                    else{
                        System.out.println("Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                }
                else {
                    System.out.println("You gotta stop making up dumb kicks like that. I'm done. You're acting just like Tino. GET OUT!");
                }
            }
        }
    }

    public static void punchNolan() {

    }

    public static void wildKickNolan() {
        double catchChance = Math.random();
        if (catchChance <= rohanCatch) {
            System.out.println("You idiot! Rohan caught the kick!");
            double throwChance = Math.random();
            if (throwChance <= rohanThrow) {
                System.out.println(
                        "And he threw you to the ground!! You have no chance in close combat with someone bigger than you like Rohan!");
                System.out.println("YOU LOSE!!!");
            } else {
                System.out.println(
                        "I don't know how, but you got out of Rohan catching your kick. Let's re-center back to in range.");
                rangeNolan();
            }
        } else {
            System.out.println(
                    "At least Rohan didn't catch that. Still, don't be stupid. You're in punching range now, so let's see what you can do.");
            punchNolan();
        }
    }

    public static void wrestleNolan() {

    }

}