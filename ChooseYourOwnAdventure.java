import java.util.Scanner;

public class ChooseYourOwnAdventure {

    final private static String LINE = "-----------------------------\n";

    // Rohan's moves stats
    final private static double ROHAN_ROUNDHOUSE_LAND = 0.85;
    final private static double ROHAN_SPINKICK_LAND = 0.10;
    final private static double ROHAN_BACKSIDE_LAND = 0.50;
    final private static double ROHAN_FRONT_LAND = 0.80;
    final private static double ROHAN_SLIDE_LAND = 0.75;
    final private static double ROHAN_JAB_LAND = 0.90;
    final private static double ROHAN_CROSS_LAND = 0.85;
    final private static double ROHAN_HOOK_LAND = 0.60;
    final private static double ROHAN_CATCH = 0.40;
    final private static double ROHAN_THROW = 0.80;

    // Nolan's moves stats
    final private static double NOLAN_ROUNDHOUSE_LAND = 0.85;
    final private static double NOLAN_SPINKICK_LAND = 0.50;
    final private static double NOLAN_BACKSIDE_LAND = 0.90;
    final private static double NOLAN_FRONT_LAND = 0.30;
    final private static double NOLAN_SLIDE_LAND = 0.15;
    final private static double NOLAN_JAB_LAND = 0.90;
    final private static double NOLAN_CROSS_LAND = 0.85;
    final private static double NOLAN_HOOK_LAND = 0.60;
    final private static double NOLAN_CATCH = 0.70;
    final private static double NOLAN_THROW = 0.40;

    // Odds of attack
    // private static double ROHAN_KICK CHANCE = 0.60; //not in use for this version
    // of program
    // private static double NOLAN_KICK_CHANCE = 0.70; //not in use for this version
    // of program
    final private static double ROHAN_PUNCH_CHANCE = 0.50;
    final private static double NOLAN_PUNCH_CHANCE = 0.60;
    final private static double ROHAN_ADVANCE_CHANCE = 0.60;
    final private static double NOLAN_ADVANCE_CHANCE = 0.30;
    final private static double NOLAN_THROW_CHANCE = 0.30;
    final private static double ROHAN_THROW_CHANCE = 0.80;

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // Trait strings
        String rohanTraits = "Power: 4/5\nSpeed: 2/5\nFleibility: 3/5\nRange: 5/5";
        String nolanTraits = "Power: 3/5\nSpeed: 5/5\nFleibility: 4/5\nRange: 2/5";

        // START GAME
        System.out.println(
                LINE + "Welcome to Kung Jung Mu Sul! I'm Sir Nick, I'm your instructior for sparring.\nIf I ask a yes or no question, answer yes or no. Or, if there are many answers, I'll give the best options. After you answer every question, ther will be a line seperating the old vs new stuff I say. It looks like this:\n"
                        + LINE + "Now, would you like to spar?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println(LINE + "Great! Get your sparring gear on!");
        } else {
            System.out.println(LINE + "Too bad! Get your sparring gear on!");
        }

        // Color choice
        System.out.println("Do you want a red or blue chestguard?");
        String chestguardColor = scan.nextLine();
        if (chestguardColor.equalsIgnoreCase("red")) {
            System.out.println(
                    LINE + "Your name is Rohan. You are 6'1\" tall, and weigh 160 lbs. Here are your skills: \n"
                            + rohanTraits);
            rohan(); // go to Rohan's start method
        } else if (chestguardColor.equalsIgnoreCase("blue")) {
            System.out.println(
                    LINE + "Your name is Nolan. You are 5'8.5\" tall, and weigh 135 lbs. Here are your skills: \n"
                            + nolanTraits);
            nolan(); // go to Nolan's start method
        } else {
            System.out.println(LINE + "No one in Kung Jung Mu Sul uses a " + chestguardColor
                    + " colored chestguard. GET OUT! says Sir Nick. Bye!"); // End game if neither red nor blue is
                                                                            // picked
            lose();
        }
    }

    public static void rohan() {
        System.out.println("Do you have your mouthguard in, Rohan?");
        while (!((scan.nextLine()).equalsIgnoreCase("yes"))) { // repeat until user inputs yes
            System.out.println(
                    LINE + "WRONG! Rohan always has his mouthguard in! Ill let you try again. Do you have your mouthguard in, Rohan?");
        }
        System.out.println("Ok, 3, 2, 1 *ding ding ding* SPAR!");
        System.out.println("Are you on your toes? 'yes' or 'no'");

        String statusToes = scan.nextLine();
        // if user inputs yes to statusToes
        if (statusToes.equalsIgnoreCase("yes")) {
            System.out.println(LINE + "Good job, at least you're staying on your toes!");
            System.out.println(
                    "You are currently out of range. You can do 'nothing', 'advance', 'stupid wild kick', or make your own move up.");

            // user input for "what to do"?
            String firstMove = scan.nextLine();
            // if user picks none of the three options
            while (!(firstMove.equalsIgnoreCase("stupid wild kick") || firstMove.equalsIgnoreCase("nothing")
                    || firstMove.equals("advance"))) {
                System.out.println(
                        LINE + "What kind of stupid idea is that? Thats dumb! Pick again.");
                firstMove = scan.nextLine(); // get input again
            }
            // if the user inputs 'nothig' to "what to do?"
            while (firstMove.equalsIgnoreCase("nothing")) {
                double randomAdvanceChance = Math.random();
                // if the random chance is greater than nolan's chance of advancing, nolan will
                // advance
                if (randomAdvanceChance <= NOLAN_ADVANCE_CHANCE) {
                    System.out.println(LINE + "Heads up! Nolan moved in. You're now in range.");
                    firstMove = "not nothing"; // in order to exit while loop
                    rangeRohan();
                    // if random chance is less than nolan's chance of advanging, then no one
                    // advanced
                } else {
                    System.out.println(
                            LINE + "(Nolan did not move in)\nNEITHER OF YOU DID ANYTHING? Lets go, we're here to spar, not make friends. Rohan, choose another option.");
                    firstMove = scan.nextLine();
                }
            }
            // if user inputs 'stupid wild kick' to "what to do?"
            if (firstMove.equalsIgnoreCase("stupid wild kick")) {
                System.out.println(LINE + "What was that! That was awful!");
                wildKickRohan(); // go to wild kick method
            }
            // if user inputs 'advance' to "what to do?"
            else if (firstMove.equalsIgnoreCase("advance")) {
                System.out.println(LINE + "Great job! You moved in to range! Now what?");
                rangeRohan();
            }

        }
        // if user inputs 'no' to statusToes
        else {
            System.out.println(
                    LINE + "ROHAN! Why aren't you on your toes? Nolan just kicked you in the chest and you fell over!");
            lose();
        }

    }

    public static void nolan() {
        System.out.println("Do you have your mouthguard in, Nolan?");
        String mouthguardStatus = scan.nextLine();
        // If user input for "do you have a mouthguard" is neither yes nor no, while
        // loop until it is yes ot no
        while (!(mouthguardStatus.equalsIgnoreCase("yes") || mouthguardStatus.equalsIgnoreCase("no"))) {
            System.out.println(
                    LINE + "Nolan, I asked you a simple question! Answer it with a yes or no you imbicile.");
            mouthguardStatus = scan.nextLine();
        }
        // if user input for "do you have a mouthguard" is no: end program
        if (mouthguardStatus.equalsIgnoreCase("no")) {
            System.out.println(
                    LINE + "NOLAN YOU IDIOT! I'VE TOLD YOU TOO MANY TIMES TO USE YOUR MOUTHGUARD. GET OUT!!");
            lose();
        }
        // if user input for "do you have a mouthguard" is yes, continue program
        else if (mouthguardStatus.equalsIgnoreCase("yes")) {
            System.out.println(
                    LINE + "Finally, you brought your mouthguard. Maybe you're not as much of an idiot today.");
            System.out.println("Ok, 3, 2, 1 *ding ding ding* SPAR!");
            System.out.println("Now, are you on your toes? 'yes' or 'no'");
            // User input for if on toes
            String statusOnToes = scan.nextLine();
            // if user does not input yes for "if on toes", while loop until yes
            while (!statusOnToes.equalsIgnoreCase("yes")) {
                System.out.println(LINE + "FALSE! Nolan's always on his toes. Answer again.");
                statusOnToes = scan.nextLine(); // to exit while loop
            }
            // if user inputs yes for "if on toes": continue with more program
            if (statusOnToes.equalsIgnoreCase("yes")) {
                System.out.println(
                        LINE + "Ok, now let's fight! What do you want to do? You could do 'nothing', 'advance', 'stupid wild kick', or make your own move up.");
                // user input for "what to do"?
                String firstMove = scan.nextLine();
                // if user picks none of the three options
                while (!(firstMove.equalsIgnoreCase("stupid wild kick") || firstMove.equalsIgnoreCase("nothing")
                        || firstMove.equals("advance"))) {
                    System.out.println(
                            LINE + "What kind of stupid idea is that? Thats dumb! Pick again.");
                    firstMove = scan.nextLine(); // get input again
                }
                // if the user inputs 'nothig' to "what to do?"
                while (firstMove.equalsIgnoreCase("nothing")) {
                    double randomAdvanceChance = Math.random();
                    // if the random chance is greater than rohan's chance of advancing, rohan
                    // advances
                    if (randomAdvanceChance <= ROHAN_ADVANCE_CHANCE) {
                        System.out.println(
                                LINE + "Heads up! Rohan moved in. You're now in range.");
                        firstMove = "not nothing"; // in order to exit while loop
                        rangeNolan();
                        // if random chance is less than rohan's chance of advanging, then no one
                        // advanced
                    } else {
                        System.out.println(
                                LINE + "(Rohan did not move in)\nNEITHER OF YOU DID ANYTHING? Lets go, we're here to spar, not make friends. Nolan, choose another option.");
                        firstMove = scan.nextLine();
                    }
                }
                // if user inputs 'stupid wild kick' to "what to do?"
                if (firstMove.equalsIgnoreCase("stupid wild kick")) {
                    System.out.println(LINE + "What was that! That was awful!");
                    wildKickNolan(); // go to wild kick method
                }
                // if user inputs 'advance' to "what to do?"
                else if (firstMove.equalsIgnoreCase("advance")) {
                    System.out.println(LINE + "Great job! You moved in to range! Now what?");
                    rangeNolan();
                }
            }
        }
    }

    public static void rangeRohan() {
        System.out.println(
                "Ok, you're in kicking range. What are you gonna do? 'advance', 'kick' or 'stay'");
        String rangeInput = scan.nextLine();
        while (!(rangeInput.equalsIgnoreCase("advance") || rangeInput.equalsIgnoreCase("kick")
                || rangeInput.equalsIgnoreCase("stay") || rangeInput.equalsIgnoreCase("nothing"))) {
            System.out.println(LINE + "What the heck was that!! Try again!");
            rangeInput = scan.nextLine();
        }
        while (rangeInput.equalsIgnoreCase("stay") || rangeInput.equalsIgnoreCase("nothing")) {
            double randomAdvanceChance = Math.random();
            // if the random chance is less than nolan's chance of advancing, nolan will
            // advance
            if (randomAdvanceChance <= NOLAN_ADVANCE_CHANCE) {
                System.out.println(LINE + "Heads up! Nolan stepped in to the inside.");
                rangeInput = "not nothing"; // in order to exit while loop
                punchRohan();
                // if random chance is greater than nolan's chance of advanging, then nolan
                // didnt advanced
            } else {
                System.out.println(
                        LINE + "(Nolan did not move in)\nCOME ON ROHAN YOU'RE IN RANGE. Let's goooo pick up the pace!");
                rangeInput = scan.nextLine();
            }
        }
        // when player advances, go into punch method
        if (rangeInput.equalsIgnoreCase("advance")) {
            System.out.println(LINE + "Ok, that's a decision.");
            punchRohan();
        }
        // when player kicks
        else if (rangeInput.equalsIgnoreCase("kick")) {
            double oppChance = Math.random(); // will use for chance of landing a kick
            // if nolan kicks also
            if (oppChance <= 0.25) { // assigned .25 for a low chance
                System.out.println(
                        LINE + "You're killing me! you both tried to kick at the same time and clashed shins. Oof! Now center up and keep going.");
                rangeRohan();
            }
            // if nolan does not kick: choose kick
            else {
                System.out.println(
                        LINE + "Which kick do you want to use? 'roundhouse', 'head spin' 'backside' 'front' or 'slide-up side'");
                String kickChoice = scan.nextLine();
                // if player chooses roundhouse kick
                if (kickChoice.equalsIgnoreCase("roundhouse")) {
                    double chanceLand = Math.random(); // will use for chance of landing kick
                    System.out.println(
                            LINE + "Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.\nHit enter to throw");
                    scan.nextLine();
                    if (chanceLand <= ROHAN_ROUNDHOUSE_LAND) { // if kick lands
                        System.out.println(
                                LINE + "Point: Rohan. Great kick, I taught you well.");
                        win();
                    } else { // kick does not land
                        System.out.println(LINE + "Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                } else if (kickChoice.equalsIgnoreCase("head spin")) {
                    double chanceLand = Math.random(); // will use for chance of landing kick
                    System.out.println(
                            LINE + "Rotate your hips halfway around. Make sure to look over your shoulder and spot your target. Try to hit with the heel. Let's see if you can do it.\n Hit enter to throw it.");
                    scan.nextLine();
                    if (chanceLand <= ROHAN_SPINKICK_LAND) { // if kick lands
                        System.out.println(
                                LINE + "Point: Rohan. Great aim to the head, I taught you well.");
                        win();
                    } else { // kick does not land
                        System.out.println(LINE + "Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                } else if (kickChoice.equalsIgnoreCase("backside")) {
                    double chanceLand = Math.random(); // will use for chance of landing kick
                    System.out.println(
                            LINE + "Pivot your front foot halfway. While standing and turned, spot the target. Don't make this a spin kick. Now try it.\nHit enter to throw.");
                    scan.nextLine();
                    if (chanceLand <= ROHAN_BACKSIDE_LAND) { // if kick lands
                        System.out.println(LINE + "Point: Rohan. Great kick, super strong.");
                        win();
                    } else { // kick does not land
                        System.out.println(LINE + "Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                } else if (kickChoice.equalsIgnoreCase("front")) {
                    double chanceLand = Math.random(); // will use for chance of landing kick
                    System.out.println(
                            LINE + "Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.\nHit enter to throw");
                    scan.nextLine();
                    if (chanceLand <= ROHAN_FRONT_LAND) { // if kick lands
                        System.out.println(
                                LINE + "Point: Rohan. Great kick, I'm the best teacher. YOU");
                        win();
                    } else { // kick does not land
                        System.out.println(LINE + "You messed it up, somehow. You missed");
                        punchRohan();
                    }
                } else if (kickChoice.equalsIgnoreCase("slide-up side")) {
                    double chanceLand = Math.random(); // will use for chance of landing kick
                    System.out.println(
                            LINE + "Bring your back foot to your front foot. Then, bring your front foot up, and kick to the chest. Remember to pivot your foot.\nHit enter to throw");
                    scan.nextLine();
                    if (chanceLand <= ROHAN_SLIDE_LAND) { // if kick lands
                        System.out
                                .println(LINE + "Point: Rohan. Great kick, I taught you well.");
                        win();
                    } else { // kick does not land
                        System.out.println(LINE + "Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                } else { // used as a buffer if player does not put in any of the options
                    System.out.println(
                            LINE + "You gotta stop making up dumb kicks like that. I'm done. You're acting just like Tino. GET OUT!");
                    lose();
                }
            }
        }
    }

    public static void punchRohan() {
        System.out.println(
                "Now you're in punching range. Keep it loose.\n What do you want to do: 'punch', nothing' 'advance', 'back up' or 'block'");
        String statusPunch = scan.nextLine();
        // while user input is none of the options
        while (!(statusPunch.equalsIgnoreCase("punch") || statusPunch.equalsIgnoreCase("nothing")
                || statusPunch.equalsIgnoreCase("stay") || statusPunch.equalsIgnoreCase("advance")
                || statusPunch.equalsIgnoreCase("block") || statusPunch.equalsIgnoreCase("back up"))) {
            System.out.println(
                    LINE + "What the heck was that? Nolan can punch your teeth out! So don't do dumb stuff like that. Try again.");
            statusPunch = scan.nextLine(); // redo scan to redo while loop
        }
        // user chooses advance
        if (statusPunch.equalsIgnoreCase("advance")) {
            System.out.println(LINE + "Good choice, you can probably beat Nolan in closer");
            wrestleRohan();
        }
        // user chooses back up
        else if (statusPunch.equalsIgnoreCase("back up")) {
            System.out.println(LINE + "Alright, you took a step back out of range");
            rangeRohan();
        }
        // user chooses block
        else if (statusPunch.equalsIgnoreCase("block")) {
            double randomPunchChance = Math.random();
            // if random number 0-1 is less than nolan punch chance(decimal), then the punch
            // did land
            if (randomPunchChance <= NOLAN_PUNCH_CHANCE) {
                System.out.println(
                        LINE + "(Nolan did punch)\nGood block! Don't stop, you're still in this.");
                punchRohan();
            }
            // if nolan did not punch
            else {
                System.out.println(
                        LINE + "(Nolan did not punch)\nWhat are you blocking? The air?? You know what, Nolan, throw this joker out.");
                lose();
            }
        }
        // user chooses to not do anything. "stay" programmed in to be robust
        else if (statusPunch.equalsIgnoreCase("nothing") || statusPunch.equalsIgnoreCase("stay")) {
            double randomPunchChance = Math.random();
            // random number 0-1 is less than nolan punch chance(decimal), punch was thrown
            if (randomPunchChance <= NOLAN_PUNCH_CHANCE) {
                double newRandomPunchChance = Math.random();
                // Do average chance of nolan landing a punch
                // if nolan does punch
                if (newRandomPunchChance <= ((NOLAN_JAB_LAND + NOLAN_CROSS_LAND + NOLAN_HOOK_LAND) / 3)) {
                    System.out.println(
                            LINE + "ROHAN! Why didn't you block! Nolan just punched you in the face!");
                    lose();
                }
                // nolan does not land punch
                else {
                    System.out.println(
                            LINE + "Nolan threw a punch and missed! He moved a little bit closer into range.");
                    wrestleRohan();
                }
            }
            // nolan does not punch
            else {
                System.out.println(LINE + "YALL ARE IN PUNCHING RANGE! DO SOMETHING");
                punchRohan();
            }
        }
        // user chooswes pumch
        else if (statusPunch.equalsIgnoreCase("punch")) {
            System.out.println(
                    LINE + "Alright, what kind of punch do you want to throw? Some good options are 'jab', 'cross', 'hook'");
            String punchType = scan.nextLine(); // get input
            // if rohan lands jab and nolan puches and nolan lands a punch(set as jab):
            // double KO
            if (Math.random() <= ROHAN_JAB_LAND && Math.random() <= NOLAN_PUNCH_CHANCE
                    && Math.random() <= NOLAN_JAB_LAND) {
                System.out.println(
                        LINE + "OOF! You both tried to punch at the same time, and both hit eachother! DOUBLE KO!");
                lose();
            }
            // if user does not choose any of the punches
            else {
                while (!(punchType.equalsIgnoreCase("jab") || punchType.equalsIgnoreCase("cross")
                        || punchType.equalsIgnoreCase("hook") || punchType.equals("exit"))) {
                    System.out.println(
                            LINE + "Rohan I swear, I've had enough of your stupidity. For the last time, stop making a fool of yourself! GET OUT!");
                    lose();
                    punchType = "exit"; // set punchType to "exit", will exit while loop, as exit is in the while
                                        // condition
                }
                // user chooses jab
                if (punchType.equalsIgnoreCase("jab")) {
                    System.out.println(
                            LINE + "Ok, easiest punch. Your front arm goes straight out. Rotate a little bit. Don't swing to much, you're just trying to tag him.\nHit enter to throw the punch");
                    scan.nextLine();
                    double landChance = Math.random();
                    // random number 0-1 is less than rohan land chance(decimal), punch did land
                    if (landChance <= ROHAN_JAB_LAND) {
                        System.out.println(
                                LINE + "(You landed the jab)\nOoh, good jab Rohan! You finally listened to me. Great match!");
                        win();
                    }
                    // punch did not land
                    else {
                        System.out.println(
                                LINE + "(You missed the jab)\nRohan, you should have listened to me! You moved in a bit closer");
                        wrestleRohan();
                    }

                }
                // user chooses cross
                if (punchType.equalsIgnoreCase("cross")) {
                    System.out.println(
                            LINE + "Ok, medium punch. Bend your rear knee to rotate your back shoulder to the front. Bring your rear hand straigt out, and straight back. A little bit more power in this one\nHit enter to throw the punch");
                    scan.nextLine();
                    double landChance = Math.random();
                    // random number 0-1 is less than rohan punch land(decimal), punch did land
                    if (landChance <= ROHAN_CROSS_LAND) {
                        System.out.println(
                                LINE + "(You landed the cross)\nOoh, good cross Rohan! You finally listened to me. Great match!");
                        win();
                    }
                    // punch did not land
                    else {
                        System.out.println(
                                LINE + "(You missed the cross)\nRohan, you should have listened to me! When you missed, you moved in a bit closer");
                        wrestleRohan();
                    }

                }
                if (punchType.equalsIgnoreCase("hook")) {
                    System.out.println(
                            LINE + "Ok, hardest punch. The biggest part is not over-rotating. You're gonna use the front hand. Remember to bring your elbow up, and keep your arm parallel to the ground as you punch.\nHit enter to throw the punch");
                    scan.nextLine();
                    double landChance = Math.random();
                    // random number 0-1 is less than rohan punch land(decimal), punch did land
                    if (landChance <= ROHAN_HOOK_LAND) {
                        System.out.println(
                                LINE + "(You landed the hook)\nOoh, good hook Rohan! You finally listened to me. Great match!");
                        win();
                    } else {
                        System.out.println(
                                LINE + "(You missed the hook)\nRohan, you should have listened to me! You moved in a bit closer");
                        wrestleRohan();
                    }

                }
            }
        }
    }

    public static void wildKickRohan() {
        double catchChance = Math.random();
        if (catchChance <= NOLAN_CATCH) { // if random chance is less than catching chance (as a decimal), sucessful
                                          // catch
            System.out.println("You buffoon! Nolan caught the kick!");
            double throwChance = Math.random();
            if (throwChance <= NOLAN_THROW) { // if random chance is less than throw chance (as a decimal), sucessful
                                              // throw
                System.out.println(
                        "And he threw you to the ground!! That's why you don't do stupid stuff like that, Rohan!");
                lose();
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
        System.out.println(
                "Ok, you're all the way in to grappling range. You can either 'throw', 'back up' or do 'nothing'");
        String wrestleChoice = scan.nextLine();
        while (!(wrestleChoice.equalsIgnoreCase("throw") || wrestleChoice.equalsIgnoreCase("nothing")
                || wrestleChoice.equalsIgnoreCase("stay") || wrestleChoice.equalsIgnoreCase("back up"))) {
            System.out.println(
                    LINE + "*sigh* I wish I wouldn't have such stupid students. Pick another move. There's only two options.");
            wrestleChoice = scan.nextLine(); // continue loop until one of given options is chosen
        }
        if (wrestleChoice.equalsIgnoreCase("throw")) {
            // if random number is less than decimal chance, sucessful throw
            if (Math.random() <= NOLAN_THROW_CHANCE) {
                System.out.println(LINE + "\n(Nolan also tried to throw)\n");
                double randomThrowNolan = Math.random();
                double randomThrowRohan = Math.random();
                // if nolan throws, and rohan fails throw
                if (randomThrowNolan <= NOLAN_THROW && randomThrowRohan > ROHAN_THROW) {
                    System.out.println("ROHAN! How in the world did you let Nolan beat you in wrestling?");
                    lose();
                }
                // if nolan fails and rohan suceeds
                else if (randomThrowNolan > NOLAN_THROW && randomThrowRohan <= ROHAN_THROW) {
                    System.out.println(
                            "Good job Rohan! It would have been bad if you had lost that matchup. Good round.");
                    win();
                }
                // if both suceed or both fail
                else {
                    System.out.println(
                            "Break it up! You both tried to throw at the same time and got stuffed up. It's been a long match. Do you wanna 'continue' or 'rest'");
                    String response = scan.nextLine();
                    if (response.equalsIgnoreCase("rest")) {
                        System.out.println(
                                LINE + "Fine, I'll take pity on you. Great round, both of you. Now go rest up, and get ready for another round later.");
                    } else {
                        System.out.println(
                                LINE + "That's what I like to hear! Now, you're gonna start in kicking range.\n3, 2, 1, GO!");
                        rangeRohan();
                    }
                }
            } else {
                // if random decimal 0-1 is less than ROHAN_THROW (decimal), throw sucessful
                if (Math.random() <= ROHAN_THROW) {
                    System.out.println(
                            LINE + "Good throw Rohan! Nolan didn't stand a chance. Way to use your strength. Great round!");
                    win();
                }
                // throw unsucessful
                else {
                    System.out.println(
                            LINE + "(You failed the throw)\nYou're killing me Rohan! You were so close to getting him! You're still in nthere, so don't give up.");
                    wrestleRohan();
                }
            }
        } else if (wrestleChoice.equalsIgnoreCase("stay") || wrestleChoice.equalsIgnoreCase("nothing")) {
            if (Math.random() <= NOLAN_THROW_CHANCE) { // if nolan tries to throw
                System.out.println(LINE + "(Nolan came in to throw)");
                if (Math.random() <= NOLAN_THROW) { // if nolan throw sucessful
                    System.out.println(
                            "(And you did nothing)\nRohan! How did you let Nolan just walk up and take you down? Use your strength next time");
                    lose();
                }
                // throw unsucessful
                else {
                    System.out.println(
                            "(But he failed)\nRohan, that was close man. You should not let Nolan in that close next time. Remember, you're still in close");
                    wrestleRohan();
                }
            }
            // does not try to throw
            else {
                System.out.println(LINE + "Stop hugging and throw the other person! Both of you! CMON!");
                wrestleRohan();
            }
        } else if (wrestleChoice.equalsIgnoreCase("back up")) {
            System.out.println(LINE + "Alright, you backed out into punching range");
            punchRohan();
        }
    }

    public static void rangeNolan() {
        System.out.println("Ok, you're in kicking range. What are you gonna do? 'advance', 'kick' or 'stay'");
        String rangeInput = scan.nextLine();
        while (!(rangeInput.equalsIgnoreCase("advance") || rangeInput.equalsIgnoreCase("kick")
                || rangeInput.equalsIgnoreCase("stay") || rangeInput.equalsIgnoreCase("nothing"))) {
            System.out.println(LINE + "What was that, Nolan!! Try again!");
            rangeInput = scan.nextLine(); // keep looping until answer is one of 3 given
        }
        while (rangeInput.equalsIgnoreCase("stay") || rangeInput.equalsIgnoreCase("nothing")) {
            double randomAdvanceChance = Math.random();
            // if the random chance is less than nolan's chance of advancing, rohan will
            // advance
            if (randomAdvanceChance <= ROHAN_ADVANCE_CHANCE) {
                System.out.println(LINE + "Heads up! Rohan stepped in to the inside.");
                rangeInput = "not nothing"; // in order to exit while loop
                punchNolan();
                // if random chance is greater than nolan's chance of advanging, then nolan
                // didnt advanced
            }
            // nolan does not advance due to random chance
            else {
                System.out.println(
                        LINE + "(Rohan did not move in)\nCOME ON NOLAN YOU'RE IN RANGE. Stop being lazy!");
                rangeInput = scan.nextLine(); // get input of rangeInput again
            }
        }
        // user input chooses advances
        if (rangeInput.equalsIgnoreCase("advance")) {
            System.out.println(LINE + "Ok, that's a decision. Good luck trying to punch Rohan.");
            punchNolan();
        }
        // user input is kick
        else if (rangeInput.equalsIgnoreCase("kick")) {
            double oppChance = Math.random();
            // chose 0.1 as a chance (10%) for other person to kick
            if (oppChance <= 0.1) {
                System.out.println(
                        LINE + "You're killing me! you both tried to kick at the same time and clashed shins. Dummys! Now center up and keep going.");
                rangeNolan();
            }
            // opponent does not kick
            else {
                System.out.println(
                        LINE + "Which kick do you want to use? 'roundhouse', 'head spin' 'backside' 'front' or 'slide-up side'");
                String kickChoice = scan.nextLine();// user input kick
                // user chooses roundhouse
                if (kickChoice.equalsIgnoreCase("roundhouse")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            LINE + "Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.\nHit enter to throw");
                    scan.nextLine(); // to delay all the text printed. Hit enter to throw
                    // if the random chance is less than nolan's chance of landing, nolan will land
                    // kick
                    if (chanceLand <= NOLAN_ROUNDHOUSE_LAND) {
                        System.out.println("Point: Nolan. Great kick, I taught you well.");
                        win();
                    }
                    // nolan does not land
                    else {
                        System.out.println(LINE + "Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                }
                // user inputs head spin for kick
                else if (kickChoice.equalsIgnoreCase("head spin")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            LINE + "Rotate your hips halfway around. Make sure to look over your shoulder and spot your target. Try to hit with the heel. Let's see if you can do it.\nHit enter to throw");
                    scan.nextLine(); // to delay all the text printed. Hit enter to throw
                    // if the random chance is less than nolan's chance of land, nolan will land
                    if (chanceLand <= NOLAN_SPINKICK_LAND) {
                        System.out.println("Point: Nolan. Great aim to the head, I taught you well.");
                        win();
                    }
                    // nolan does not land
                    else {
                        System.out.println(LINE + "Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                } else if (kickChoice.equalsIgnoreCase("backside")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            LINE + "Pivot your front foot halfway. While standing and turned, spot the target. Don't make this a spin kick. Now try it.\nHit enter to kick");
                    scan.nextLine(); // to delay all the text printed. Hit enter to throw
                    // if the random chance is less than nolan's chance of land, nolan will land
                    if (chanceLand <= NOLAN_BACKSIDE_LAND) {
                        System.out.println("Point: Nolan. Great kick, super strong.");
                        win();
                    }
                    // nolan does not land
                    else {
                        System.out.println(LINE + "Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                }
                // user chooses front kick
                else if (kickChoice.equalsIgnoreCase("front")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            LINE + "Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.\nHit enter to kick");
                    scan.nextLine(); // to delay all the text printed. Hit enter to throw
                    // if the random chance is less than nolan's chance of land, nolan will land
                    if (chanceLand <= NOLAN_FRONT_LAND) {
                        System.out.println("Point: Nolan. Great kick, I'm the best teacher.");
                        win();
                    }
                    // nolan does not land
                    else {
                        System.out.println(LINE + "You messed it up, somehow. You missed");
                        punchNolan();
                    }
                } else if (kickChoice.equalsIgnoreCase("slide-up side")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            LINE + "Bring your back foot to your front foot. Then, bring your front foot up, and kick to the chest. Remember to pivot your foot.\nHit enter to kick");
                    scan.nextLine(); // to delay all the text printed. Hit enter to throw
                    // if the random chance is less than nolan's chance of land, nolan will land
                    if (chanceLand <= NOLAN_SLIDE_LAND) {
                        System.out.println("Point: Nolan. Great kick, I taught you well.");
                        win();
                    }
                    // nolan does not land
                    else {
                        System.out.println(LINE + "Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                }
                // none of the kicks are chosen
                else {
                    System.out.println(
                            LINE + "You gotta stop making up dumb kicks like that. I'm done. You're acting just like Tino. GET OUT!");
                }
            }
        }
    }

    public static void punchNolan() {
        System.out.println(
                "Now you're in punching range. Keep it loose.\nWhat do you want to do: 'punch', nothing', 'advance', 'back up' or 'block'");
        String statusPunch = scan.nextLine(); // user input
        // if none of these ar user input
        while (!(statusPunch.equalsIgnoreCase("punch") || statusPunch.equalsIgnoreCase("nothing")
                || statusPunch.equalsIgnoreCase("stay") || statusPunch.equalsIgnoreCase("advance")
                || statusPunch.equalsIgnoreCase("block") || statusPunch.equalsIgnoreCase("back up"))) {
            System.out.println(
                    LINE + "What the heck was that? Rohan can punch your teeth out! So don't do dumb stuff like that. Try again.");
            statusPunch = scan.nextLine(); // get input again, stay in loop
        }
        // if user input advance
        if (statusPunch.equalsIgnoreCase("advance")) {
            System.out.println(LINE + "Umm, ok? Try to wrestle Rohan? Interesting choice.");
            wrestleNolan();
        }
        // user inputs back up
        else if (statusPunch.equalsIgnoreCase("back up")) {
            System.out.println(LINE + "Alright, you took a step back out of range");
            rangeNolan();
        }
        // user inputs block
        else if (statusPunch.equalsIgnoreCase("block")) {
            double randomPunchChance = Math.random();
            // if ROHAN_PUNCH_CHANCE is greater than the random double from 0-1, rohan does
            // punch
            if (randomPunchChance <= ROHAN_PUNCH_CHANCE) {
                System.out.println(LINE + "(Rohan did punch)\nGood block! Don't stop, you're still in this.");
                punchNolan();
            }
            // rohan does not punch
            else {
                System.out.println(
                        LINE + "(Rohan did not punch)\nWhat are you blocking? The air?? You know what, Rohan, throw this joker out.");
                lose();

            }
        }
        // if user input nothing or stay to be robust
        else if (statusPunch.equalsIgnoreCase("nothing") || statusPunch.equalsIgnoreCase("stay")) {
            double randomPunchChance = Math.random();
            // if ROHAN_PUNCH_CHANCE > greater than random double from 0-1, rohan punces
            if (randomPunchChance <= ROHAN_PUNCH_CHANCE) {
                double newRandomPunchChance = Math.random();
                // if random chance is less than the average chance of rohan landing a punch:
                // rohan lands punch
                if (newRandomPunchChance <= ((ROHAN_JAB_LAND + ROHAN_CROSS_LAND + ROHAN_HOOK_LAND) / 3)) {
                    System.out.println(LINE + "NOLAN! Why didn't you block! Rohan just punched you in the face!");
                    lose();
                }
                // rohan does not land
                else {
                    System.out
                            .println(LINE + "Rohan threw a punch and missed! He moved a little bit closer into range.");
                    wrestleNolan();
                }
            }
            // rohan does not try to punch
            else {
                System.out.println(LINE + "YALL ARE IN PUNCHING RANGE! DO SOMETHING");
                punchNolan();
            }
        } else if (statusPunch.equalsIgnoreCase("punch")) {
            System.out.println(
                    LINE + "Alright, what kind of punch do you want to throw? Some good options are 'jab', 'cross', or 'hook'");
            String punchType = scan.nextLine(); // get type of punch input
            // if nolan lands jab (most likely land) and rohan punches and rohan lands punch
            if (Math.random() <= NOLAN_JAB_LAND && Math.random() <= ROHAN_PUNCH_CHANCE
                    && Math.random() <= ROHAN_JAB_LAND) {
                System.out.println(
                        LINE + "OOF! You both tried to punch at the same time, and both hit eachother! DOUBLE KO!");
                lose();
            } else {
                // if user input is none of the options
                if (!(punchType.equalsIgnoreCase("jab") || punchType.equalsIgnoreCase("cross")
                        || punchType.equalsIgnoreCase("hook") || punchType.equals("exit"))) {
                    System.out.println(
                            LINE + "Nolan I swear, I've had enough of your stupidity. For the last time, stop making a fool of yourself! GET OUT!");
                    lose();
                }
                // user input is jab
                else if (punchType.equalsIgnoreCase("jab")) {
                    System.out.println(
                            LINE + "Ok, easiest punch. Your front arm goes straight out. Rotate a little bit. Don't swing to much, you're just trying to tag him.\nHit enter to punch");
                    scan.nextLine(); // user input: will not use. To delay all the text. Hit enter to throw punch
                    // if nolan land is greater than a random value 0-1, punch does land
                    double landChance = Math.random();
                    if (landChance <= NOLAN_JAB_LAND) {
                        System.out.println(
                                LINE + "(You landed the jab)\nOoh, good jab NOlan! You finally listened to me. Great match!");
                        win();
                    } else {
                        System.out.println(
                                LINE + "(You missed the jab)\nNolan, you should have listened to me! You moved in a bit closer");
                        wrestleNolan();
                    }

                }
                if (punchType.equalsIgnoreCase("cross")) {
                    System.out.println(
                            LINE + "Ok, medium punch. Bend your rear knee to rotate your back shoulder to the front. Bring your rear hand straigt out, and straight back. A little bit more power in this one.\nHit enter to punch");
                    scan.nextLine(); // user input: will not use. To delay all the text. Hit enter to throw punch
                    // if nolan land is greater than a random value 0-1, punch does land
                    double landChance = Math.random();
                    if (landChance <= NOLAN_CROSS_LAND) {
                        System.out.println(
                                LINE + "(You landed the cross)\nOoh, good cross Nolan! You finally listened to me. Great match!");
                        win();
                    } else {
                        System.out.println(
                                LINE + "(You missed the cross)\nNolan, you should have listened to me! When you missed, you moved in a bit closer");
                        wrestleNolan();
                    }

                }
                if (punchType.equalsIgnoreCase("hook")) {
                    System.out.println(
                            LINE + "Ok, hardest punch. The biggest part is not over-rotating. You're gonna use the front hand. Remember to bring your elbow up, and keep your arm parallel to the ground as you punch.\nHit enter to punch");
                    scan.nextLine(); // user input: will not use. To delay all the text. Hit enter to throw punch
                    // if nolan land is greater than a random value 0-1, punch does land
                    double landChance = Math.random();
                    if (landChance <= NOLAN_HOOK_LAND) {
                        System.out.println(
                                LINE + "(You landed the hook)\nOoh, good hook Nolan! You finally listened to me. Great match!");
                        win();
                    } else {
                        System.out.println(
                                LINE + "(You missed the hook)\nRohan, you should have listened to me! You moved in a bit closer");
                        wrestleNolan();
                    }

                }
            }
        }
    }

    public static void wildKickNolan() {
        double catchChance = Math.random();
        if (catchChance <= ROHAN_CATCH) { // rohan catches
            System.out.println("You idiot! Rohan caught the kick!");
            double throwChance = Math.random();
            if (throwChance <= ROHAN_THROW) { // roan sucessfully throws
                System.out.println(
                        "And he threw you to the ground!! You have no chance in close combat with someone bigger than you like Rohan!");
                lose();
            }
            // rohan fails throw
            else {
                System.out.println(
                        "I don't know how, but you got out of Rohan catching your kick. Let's re-center back to in range.");
                rangeNolan();
            }
        } else { // rohan does not catch
            System.out.println(
                    LINE + "At least Rohan didn't catch that. Still, don't be stupid. You missed, and fell in to punching range");
            punchNolan();
        }
    }

    public static void wrestleNolan() {
        System.out.println(
                "Ok, you're all the way in to grappling range. You can either 'throw', 'back up' or do 'nothing'");
        String wrestleChoice = scan.nextLine();
        while (!(wrestleChoice.equalsIgnoreCase("throw") || wrestleChoice.equalsIgnoreCase("nothing")
                || wrestleChoice.equalsIgnoreCase("stay") || wrestleChoice.equalsIgnoreCase("back up"))) {
            System.out.println(
                    LINE + "*sigh* I don't get paid enough for you idiots. Pick another move.");
            wrestleChoice = scan.nextLine(); // keep looping untill one of given options is chosen
        }
        if (wrestleChoice.equalsIgnoreCase("throw")) {
            if (Math.random() <= ROHAN_THROW_CHANCE) { // random chance rohan tries to throw
                System.out.println(LINE + "(Rohan also tried to throw)\n");
                double randomThrowRohan = Math.random();
                double randomThrowNolan = Math.random();
                // rohan suceeds and nolan fails
                if (randomThrowRohan <= ROHAN_THROW && randomThrowNolan > NOLAN_THROW) {
                    System.out.println(
                            "Nolan, you can't beat Rohan in a close wrestle. You gotta stop trying or you'll be thrown to the ground like that again.");
                    lose();
                }
                // nolan sucessfully throws, and rohan fails
                else if (randomThrowNolan > NOLAN_THROW && randomThrowRohan <= ROHAN_THROW) {
                    System.out.println(
                            "Great job Nolan! I'm surprised you could beat Rohan when you're both fighting for a throw. Good round.");
                    win();
                }
                // both 'suceed' or both fail
                else {
                    System.out.println(
                            "Break it up! You both tried to throw at the same time and got stuffed up. It's been a long match. Do you wanna 'continue' or 'rest'");
                    String response = scan.nextLine();
                    if (response.equalsIgnoreCase("rest")) {
                        System.out.println(
                                LINE + "Fine, I'll take pity on you. Great round, both of you. Now go rest up, and get ready for another round later.");
                    } else {
                        System.out.println(
                                LINE + "That's what I like to hear! Now, you're gonna start in kicking range.\n3, 2, 1, GO!");
                        rangeNolan();
                    }
                }
            }
            // rohan doesn't try throw
            else {
                if (Math.random() <= NOLAN_THROW) { // nolan sucessfully throws
                    System.out.println("Good throw Nolan! Way to use your technique, and trip Rohan up. Great round!");
                    win();
                }
                // nolan fails throw
                else {
                    System.out.println(
                            "(You failed the throw)\nGood try Nolan. Shake it off and try again. You're still in there, so don't give up.");
                    wrestleNolan();
                }
            }
        } else if (wrestleChoice.equalsIgnoreCase("stay") || wrestleChoice.equalsIgnoreCase("nothing")) {
            if (Math.random() <= ROHAN_THROW_CHANCE) {
                System.out.println(LINE + "(Rohan came in to throw)");
                // rohan suceeds throw
                if (Math.random() <= ROHAN_THROW) {
                    System.out.println(
                            "(And you did nothing)\nNolan! How did you let Rohan just walk up and take you down? Use your strength next time");
                    lose();
                }
                // rohan fails throw
                else {
                    System.out.println(
                            "(But he failed)\nNolan, that was close man. You should not let Rohan in that close next time. He's strong, so he can beat you easy. Remember, you're still in close");
                    wrestleNolan();
                }
            }
            // rohan does not throw
            else {
                System.out.println(LINE + "Stop hugging and throw the other person! Both of you! CMON!");
                wrestleNolan();
            }
        } else if (wrestleChoice.equalsIgnoreCase("back up")) {
            System.out.println(LINE + "Alright, you backed out into punching range");
            punchNolan();
        }
    }

    public static void lose() {
        System.out
                .println(
                        "\\ \\  / /  .---------,  | |     | |       | |         ,----------,  ,--------,  |--------,       _     _");
        System.out
                .println(
                        " \\ \\/ /   | ,-----, |  | |     | |       | |         | ,------, |  | ,------'  | ,------'      |_|   |_|");
        System.out.println("  \\  /    | |     | |  | |     | |       | |         | |      | |  | |______   | |______");
        System.out.println(
                "  |  |    | |     | |  | |     | |       | |         | |      | |  |______  |  |  ______|        ______");
        System.out.println(
                "  |  |    | |     | |  | |     | |       | |         | |      | |         | |  | |              /      \\");
        System.out.println(
                "  |  |    | |_____| |  | |_____| |       | |______   | |______| |  _______| |  | |_______      /        \\");
        System.out.println(
                "  |  |    |_________|  |_________|       |________|  |__________|  |________|  |________|     /          \\");

    }

    public static void win() {
        System.out.println(
                "\\ \\  / /  .---------,  | |     | |       \\ \\                  / /  | |  |   \\     | |        __________                    /|");
        System.out.println(
                " \\ \\/ /   | ,-----, |  | |     | |        \\ \\                / /   | |  | |\\ \\    | |        \\________/      |      |     / |");
        System.out.println(
                "  \\  /    | |     | |  | |     | |         \\ \\              / /    | |  | | \\ \\   | |         \\______/     --|------|--     |");
        System.out.println(
                "  |  |    | |     | |  | |     | |          \\ \\    ____    / /     | |  | |  \\ \\  | |           |  |         |      |       |");
        System.out.println(
                "  |  |    | |     | |  | |     | |           \\ \\  / /\\ \\  / /      | |  | |   \\ \\ | |           |  |       --|------|--     |");
        System.out.println(
                "  |  |    | |_____| |  | |_____| |            \\ \\/ /  \\ \\/ /       | |  | |    \\ \\| |           |  |         |      |       |");
        System.out.println(
                "  |  |    |_________|  |_________|             \\__/     \\_/        | |  | |     \\___|          /____\\                    -------");

    }
}