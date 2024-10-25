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
    private static double nolanThrow = 0.70;

    // Odds of attack
    private static double rohanKickChance = 0.60;
    private static double nolanKickChance = 0.70;
    private static double rohanPunchChance = 0.50;
    private static double nolanPunchChance = 0.60;
    private static double rohanAdvanceChance = 0.60;
    private static double nolanAdvanceChance = 0.30;
    private static double nolanThrowChance = 0.30;
    private static double rohanThrowChance = 0.80;

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
                    "ROHAN! Why aren't you on your toes? Nolan just kicked you in the chest and you fell over!");
            System.out.println("You lost by Nolan's roundhouse kick");
            lose();
        }

    }

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
        while (!(rangeInput.equalsIgnoreCase("advance") || rangeInput.equalsIgnoreCase("kick")
                || rangeInput.equalsIgnoreCase("stay") || rangeInput.equalsIgnoreCase("nothing"))) {
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
                // if random chance is greater than nolan's chance of advanging, then nolan
                // didnt advanced
            } else {
                System.out.println(
                        "(Nolan did not move in)\nCOME ON ROHAN YOU'RE IN RANGE. Let's goooo pick up the pace!");
                rangeInput = scan.nextLine();
            }
        }
        if (rangeInput.equalsIgnoreCase("advance")) {
            System.out.println("Ok, that's a decision.");
            punchRohan();
        } else if (rangeInput.equalsIgnoreCase("kick")) {
            double oppChance = Math.random();
            if (oppChance <= nolanKickChance) {
                System.out.println(
                        "You're killing me! you both tried to kick at the same time and clashed shins. Oof! Now center up and keep going.");
                rangeRohan();
            } else {
                System.out.println(
                        "Which kick do you want to use? 'roundhouse', 'head spin' 'backside' 'front' or 'slide-up side'");
                String kickChoice = scan.nextLine();
                if (kickChoice.equalsIgnoreCase("roundhouse")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            "Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.");
                    if (chanceLand <= rohanRoundhouseLand) {
                        System.out.println("Point: Rohan. Great kick, I taught you well. YOU");
                        win();
                    } else {
                        System.out.println("Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                } else if (kickChoice.equalsIgnoreCase("head spin")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            "Rotate your hips halfway around. Make sure to look over your shoulder and spot your target. Try to hit eith the heel. Let's see if you can do it.");
                    if (chanceLand <= rohanSpinkickLand) {
                        System.out.println("Point: Rohan. Great aim to the head, I taught you well.");
                        win();
                    } else {
                        System.out.println("Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                } else if (kickChoice.equalsIgnoreCase("backside")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            "Pivot your front foot halfway. While standing and turned, spot the target. Don't make this a spin kick. Now try it.");
                    if (chanceLand <= rohanBackideLand) {
                        System.out.println("Point: Rohan. Great kick, super strong.");
                        win();
                    } else {
                        System.out.println("Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                } else if (kickChoice.equalsIgnoreCase("front")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            "Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.");
                    if (chanceLand <= rohanFrontLand) {
                        System.out.println("Point: Rohan. Great kick, I'm the best teacher. YOU");
                        win();
                    } else {
                        System.out.println("You messed it up, somehow. You missed");
                        punchRohan();
                    }
                } else if (kickChoice.equalsIgnoreCase("slide-up side")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            "Bring your back foot to your front foot. Then, bring your front food up, and kick to the chest. Remember to pivot your foot.");
                    if (chanceLand <= rohanSlideUpLand) {
                        System.out.println("Point: Rohan. Great kick, I taught you well.");
                        win();
                    } else {
                        System.out.println("Oof, your technique sucks! You missed");
                        punchRohan();
                    }
                } else {
                    System.out.println(
                            "You gotta stop making up dumb kicks like that. I'm done. You're acting just like Tino. GET OUT!");
                }
            }
        }
    }

    public static void punchRohan() {
        System.out.println(
                "Ok, you're in punching range. Keep it loose.\n What do you want to do: 'punch', nothing' 'advance' or 'block'");
        String statusPunch = scan.nextLine();
        while (!(statusPunch.equalsIgnoreCase("punch") || statusPunch.equalsIgnoreCase("nothing")
                || statusPunch.equalsIgnoreCase("stay") || statusPunch.equalsIgnoreCase("advance")
                || statusPunch.equalsIgnoreCase("block"))) {
            System.out.println(
                    "What the heck was that? Nolan can punch your teeth out! So don't do dumb stuff like that. Try again.");
            statusPunch = scan.nextLine();
        }
        if (statusPunch.equalsIgnoreCase("advance")) {
            System.out.println("Good choice, you can probably beat Nolan in closer");
            wrestleRohan();
        } else if (statusPunch.equalsIgnoreCase("block")) {
            double randomPunchChance = Math.random();
            if (randomPunchChance <= nolanPunchChance) {
                System.out.println("(Nolan did punch)\nGood block! Don't stop, you're still in this.");
                punchRohan();
            } else {
                System.out.println(
                        "(Nolan did not punch)\nWhat are you blocking? The air?? You know what, Nolan, throw this joker out.");
                System.out.println("You lost by Sir Nick being mad at you because you're stupid");
                lose();
            }
        } else if (statusPunch.equalsIgnoreCase("nothing") || statusPunch.equalsIgnoreCase("stay")) {
            double randomPunchChance = Math.random();
            if (randomPunchChance <= nolanPunchChance) {
                double newRandomPunchChance = Math.random();
                if (newRandomPunchChance <= ((nolanJabLand + nolanCrossLand + nolanHookLand) / 3)) {
                    System.out.println("ROHAN! Why didn't you block! Nolan just punched you in the face!");
                    System.out.println("You lost by Sir Nick being mad at you because you're stupid");
                    lose();
                } else {
                    System.out.println("Nolan threw a punch and missed! He moved a little bit closer into range.");
                    wrestleRohan();
                }
            } else {
                System.out.println("YALL ARE IN PUNCHING RANGE! DO SOMETHING");
                punchRohan();
            }
        } else if (statusPunch.equalsIgnoreCase("punch")) {
            System.out.println(
                    "Alright, what kind of punch do you want to throw? Some good options are 'jab', 'cross', or 'hook'");
            String punchType = scan.nextLine();
            if (Math.random() <= rohanJabLand && Math.random() <= nolanPunchChance && Math.random() <= nolanJabLand) {
                System.out.println("OOF! You both tried to punch at the same time, and both hit eachother! DOUBLE KO!");
                System.out.println("You lost because neither you nor Nolan were smart enough to block");
                lose();
            }
            while (!(punchType.equalsIgnoreCase("jab") || punchType.equalsIgnoreCase("cross")
                    || punchType.equalsIgnoreCase("hook"))) {
                System.out.println(
                        "Rohan I swear, I've had enough of your stupidity. For the last time, stop making a fool of yourself! GET OUT!");
                System.out.println("You lost by Sir Nick being mad at you because you're stupid");
                System.out.println("You lost via Sir Nick");
                lose();
                punchType = "exit while loop";
            }
            if (punchType.equalsIgnoreCase("jab")) {
                System.out.println(
                        "Ok, easiest punch. Your front arm goes straight out. Rotate a little bit. Don't swing to much, you're just trying to tag him.");
                double landChance = Math.random();
                if (landChance <= rohanJabLand) {
                    System.out.println(
                            "(You landed the jab)\nOoh, good jab Rohan! You finally listened to me. Great match!");
                    win();
                } else {
                    System.out.println(
                            "(You missed the jab)\nRohan, you should have listened to me! You moved in a bit closer");
                    wrestleRohan();
                }

            }
            if (punchType.equalsIgnoreCase("cross")) {
                System.out.println(
                        "Ok, medium punch. Bend your rear knee to rotate your back shoulder to the front. Bring your rear hand straigt out, and straight back. A little bit more power in this one");
                double landChance = Math.random();
                if (landChance <= rohanCrossLand) {
                    System.out.println(
                            "(You landed the cross)\nOoh, good cross Rohan! You finally listened to me. Great match!");
                    win();
                } else {
                    System.out.println(
                            "(You missed the cross)\nRohan, you should have listened to me! When you missed, you moved in a bit closer");
                    wrestleRohan();
                }

            }
            if (punchType.equalsIgnoreCase("hook")) {
                System.out.println(
                        "Ok, hardest punch. The biggest part is not over-rotating. You're gonna use the front hand. Remember to bring your elbow up, and keep your arm parallel to the ground as you punch.");
                double landChance = Math.random();
                if (landChance <= rohanHookLand) {
                    System.out.println(
                            "(You landed the hook)\nOoh, good hook Rohan! You finally listened to me. Great match!");
                    win();
                } else {
                    System.out.println(
                            "(You missed the hook)\nRohan, you should have listened to me! You moved in a bit closer");
                    wrestleRohan();
                }

            }
        }
    }

    public static void wildKickRohan() {
        double catchChance = Math.random();
        if (catchChance <= nolanCatch) {
            System.out.println("You buffoon! Nolan caught the kick!");
            double throwChance = Math.random();
            if (throwChance <= nolanThrow) {
                System.out.println(
                        "And he threw you to the ground!! That's why you don't do stupid stuff like that, Rohan!");
                lose();
                System.out.println("You lost by Nolan throwing you after catching a kick");
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
                    "*sigh* I wish I wouldn't have such stupid students. Pick another move. There's only two options.");
            wrestleChoice = scan.nextLine();
        }
        if (wrestleChoice.equalsIgnoreCase("throw")) {
            if (Math.random() <= nolanThrowChance) {
                System.out.println("(Nolan also tried to throw)\n");
                double randomThrowNolan = Math.random();
                double randomThrowRohan = Math.random();
                if (randomThrowNolan <= nolanThrow && randomThrowRohan >= rohanThrow) {
                    System.out.println("ROHAN! How in the world did you let Nolan beat you in wrestling?");
                    System.out.println("You lost because Nolan was smarter while tripping you.");
                    lose();
                } else if (randomThrowNolan >= nolanThrow && randomThrowRohan <= rohanThrow) {
                    System.out.println(
                            "Good job Rohan! It would have been bad if you had lost that matchup. Good round.");
                    win();
                } else {
                    System.out.println(
                            "Break it up! You both tried to throw at the same time and got stuffed up. It's been a long match. Do you wanna 'continue' or 'rest'");
                    String response = scan.nextLine();
                    if (response.equalsIgnoreCase("relax")) {
                        System.out.println(
                                "Fine, I'll take pity on you. Great round, both of you. Now go rest up, and get ready for another round later.");
                    } else {
                        System.out.println(
                                "That's what I like to hear! Now, you're gonna start in kicking range.\n3, 2, 1, GO!");
                        rangeRohan();
                    }
                }
            } else {
                if (Math.random() <= rohanThrow) {
                    System.out.println(
                            "Good throw Rohan! Nolan didn't stand a chance. Way to use your strength. Great round!");
                    win();
                } else {
                    System.out.println(
                            "(You failed the throw)\nYou're killing me Rohan! You were so close to getting him! You're still in nthere, so don't give up.");
                    wrestleRohan();
                }
            }
        } else if (wrestleChoice.equalsIgnoreCase("stay") || wrestleChoice.equalsIgnoreCase("nothing")) {
            if (Math.random() <= nolanThrowChance) {
                System.out.println("(Nolan came in to throw)");
                if (Math.random() <= nolanThrow) {
                    System.out.println(
                            "(And you did nothing)\nRohan! How did you let Nolan just walk up and take you down? Use your strength next time");
                    System.out.println("You lost because you didn't try to fight Nolan when he took you down.");
                    lose();
                } else {
                    System.out.println(
                            "(But he failed)\nRohan, that was close man. You should not let Nolan in that close next time. Remember, you're still in close");
                    wrestleRohan();
                }
            } else {
                System.out.println("Stop hugging and throw the other person! Both of you! CMON!");
                wrestleRohan();
            }
        } else if (wrestleChoice.equalsIgnoreCase("back up")) {
            System.out.println("Alright, you backed out into punching range");
            punchRohan();
        }
    }

    public static void rangeNolan() {
        System.out.println("Ok, you're in kicking range. What are you gonna do? 'advance', 'kick' or 'stay'");
        String rangeInput = scan.nextLine();
        while (!(rangeInput.equalsIgnoreCase("advance") || rangeInput.equalsIgnoreCase("kick")
                || rangeInput.equalsIgnoreCase("stay") || rangeInput.equalsIgnoreCase("nothing"))) {
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
                // if random chance is greater than nolan's chance of advanging, then nolan
                // didnt advanced
            } else {
                System.out.println(
                        "(Rohan did not move in)\nCOME ON NOLAN YOU'RE IN RANGE. Stop being lazy!");
                rangeInput = scan.nextLine();
            }
        }
        if (rangeInput.equalsIgnoreCase("advance")) {
            System.out.println("Ok, that's a decision. Good luck trying to punch Rohan.");
            punchNolan();
        } else if (rangeInput.equalsIgnoreCase("kick")) {
            double oppChance = Math.random();
            if (oppChance <= rohanKickChance) {
                System.out.println(
                        "You're killing me! you both tried to kick at the same time and clashed shins. Dummys! Now center up and keep going.");
                rangeNolan();
            } else {
                System.out.println(
                        "Which kick do you want to use? 'roundhouse', 'head spin' 'backside' 'front' or 'slide-up side'");
                String kickChoice = scan.nextLine();
                if (kickChoice.equalsIgnoreCase("roundhouse")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            "Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.");
                    if (chanceLand <= nolanRoundhouseLand) {
                        System.out.println("Point: Nolan. Great kick, I taught you well.");
                        win();
                    } else {
                        System.out.println("Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                } else if (kickChoice.equalsIgnoreCase("head spin")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            "Rotate your hips halfway around. Make sure to look over your shoulder and spot your target. Try to hit eith the heel. Let's see if you can do it.");
                    if (chanceLand <= nolanSpinkickLand) {
                        System.out.println("Point: Nolan. Great aim to the head, I taught you well.");
                        win();
                    } else {
                        System.out.println("Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                } else if (kickChoice.equalsIgnoreCase("backside")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            "Pivot your front foot halfway. While standing and turned, spot the target. Don't make this a spin kick. Now try it.");
                    if (chanceLand <= nolanBackideLand) {
                        System.out.println("Point: Nolan. Great kick, super strong.");
                        win();
                    } else {
                        System.out.println("Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                } else if (kickChoice.equalsIgnoreCase("front")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            "Pivot your front foot, rotate your hips and throw your back leg around. Lets see if you land it.");
                    if (chanceLand <= nolanFrontLand) {
                        System.out.println("Point: Nolan. Great kick, I'm the best teacher.");
                        win();
                    } else {
                        System.out.println("You messed it up, somehow. You missed");
                        punchNolan();
                    }
                } else if (kickChoice.equalsIgnoreCase("slide-up side")) {
                    double chanceLand = Math.random();
                    System.out.println(
                            "Bring your back foot to your front foot. Then, bring your front food up, and kick to the chest. Remember to pivot your foot.");
                    if (chanceLand <= nolanSlideUpLand) {
                        System.out.println("Point: Nolan. Great kick, I taught you well.");
                        win();
                    } else {
                        System.out.println("Oof, your technique sucks! You missed");
                        punchNolan();
                    }
                } else {
                    System.out.println(
                            "You gotta stop making up dumb kicks like that. I'm done. You're acting just like Tino. GET OUT!");
                }
            }
        }
    }

    public static void punchNolan() {
        System.out.println(
                "Ok, you're in punching range. Keep it loose.\n What do you want to do: 'punch', nothing' 'advance' or 'block'");
        String statusPunch = scan.nextLine();
        while (!(statusPunch.equalsIgnoreCase("punch") || statusPunch.equalsIgnoreCase("nothing")
                || statusPunch.equalsIgnoreCase("stay") || statusPunch.equalsIgnoreCase("advance")
                || statusPunch.equalsIgnoreCase("block"))) {
            System.out.println(
                    "What the heck was that? Rohan can punch your teeth out! So don't do dumb stuff like that. Try again.");
            statusPunch = scan.nextLine();
        }
        if (statusPunch.equalsIgnoreCase("advance")) {
            System.out.println("Umm, ok? Try to wrestle Rohan? Interesting choice.");
            wrestleNolan();
        } else if (statusPunch.equalsIgnoreCase("block")) {
            double randomPunchChance = Math.random();
            if (randomPunchChance <= rohanPunchChance) {
                System.out.println("(Rohan did punch)\nGood block! Don't stop, you're still in this.");
                punchNolan();
            } else {
                System.out.println(
                        "(Rohan did not punch)\nWhat are you blocking? The air?? You know what, Rohan, throw this joker out.");
                System.out.println("You lost because Sir Nick was mad at you because you're stupid");
                lose();

            }
        } else if (statusPunch.equalsIgnoreCase("nothing") || statusPunch.equalsIgnoreCase("stay")) {
            double randomPunchChance = Math.random();
            if (randomPunchChance <= rohanPunchChance) {
                double newRandomPunchChance = Math.random();
                if (newRandomPunchChance <= ((rohanJabLand + rohanCrossLand + rohanHookLand) / 3)) {
                    System.out.println("NOLAN! Why didn't you block! Rohan just punched you in the face!");
                    lose();
                    System.out.println("You lost by Rohan punching you in the face");
                } else {
                    System.out.println("Rohan threw a punch and missed! He moved a little bit closer into range.");
                    wrestleNolan();
                }
            } else {
                System.out.println("YALL ARE IN PUNCHING RANGE! DO SOMETHING");
                punchNolan();
            }
        } else if (statusPunch.equalsIgnoreCase("punch")) {
            System.out.println(
                    "Alright, what kind of punch do you want to throw? Some good options are 'jab', 'cross', or 'hook'");
            String punchType = scan.nextLine();
            if (Math.random() <= nolanJabLand && Math.random() <= rohanPunchChance && Math.random() <= rohanJabLand) {
                System.out.println("OOF! You both tried to punch at the same time, and both hit eachother! DOUBLE KO!");
                System.out.println("You lost because neither you nor Rohan were smart enough to block");
                lose();
            }
            while (!(punchType.equalsIgnoreCase("jab") || punchType.equalsIgnoreCase("cross")
                    || punchType.equalsIgnoreCase("hook"))) {
                System.out.println(
                        "Nolan I swear, I've had enough of your stupidity. For the last time, stop making a fool of yourself! GET OUT!");
                System.out.println("You lost by Sir Nick being mad at you because you're stupid");
                lose();
                System.out.println("You lost via Sir Nick");
                punchType = "exit while loop";
            }
            if (punchType.equalsIgnoreCase("jab")) {
                System.out.println(
                        "Ok, easiest punch. Your front arm goes straight out. Rotate a little bit. Don't swing to much, you're just trying to tag him.");
                double landChance = Math.random();
                if (landChance <= nolanJabLand) {
                    System.out.println(
                            "(You landed the jab)\nOoh, good jab NOlan! You finally listened to me. Great match!");
                    win();
                } else {
                    System.out.println(
                            "(You missed the jab)\nNolan, you should have listened to me! You moved in a bit closer");
                    wrestleNolan();
                }

            }
            if (punchType.equalsIgnoreCase("cross")) {
                System.out.println(
                        "Ok, medium punch. Bend your rear knee to rotate your back shoulder to the front. Bring your rear hand straigt out, and straight back. A little bit more power in this one");
                double landChance = Math.random();
                if (landChance <= nolanCrossLand) {
                    System.out.println(
                            "(You landed the cross)\nOoh, good cross Nolan! You finally listened to me. Great match!");
                    win();
                } else {
                    System.out.println(
                            "(You missed the cross)\nNolan, you should have listened to me! When you missed, you moved in a bit closer");
                    wrestleNolan();
                }

            }
            if (punchType.equalsIgnoreCase("hook")) {
                System.out.println(
                        "Ok, hardest punch. The biggest part is not over-rotating. You're gonna use the front hand. Remember to bring your elbow up, and keep your arm parallel to the ground as you punch.");
                double landChance = Math.random();
                if (landChance <= nolanHookLand) {
                    System.out.println(
                            "(You landed the hook)\nOoh, good hook Nolan! You finally listened to me. Great match!");
                    win();
                } else {
                    System.out.println(
                            "(You missed the hook)\nRohan, you should have listened to me! You moved in a bit closer");
                    wrestleNolan();
                }

            }
        }
    }

    public static void wildKickNolan() {
        double catchChance = Math.random();
        if (catchChance <= rohanCatch) {
            System.out.println("You idiot! Rohan caught the kick!");
            double throwChance = Math.random();
            if (throwChance <= rohanThrow) {
                System.out.println(
                        "And he threw you to the ground!! You have no chance in close combat with someone bigger than you like Rohan!");
                System.out.println("You lost because Rohan is a beast and threw you to the ground with no problem");
                lose();
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
        System.out.println(
                "Ok, you're all the way in to grappling range. You can either 'throw', 'back up' or do 'nothing'");
        String wrestleChoice = scan.nextLine();
        while (!(wrestleChoice.equalsIgnoreCase("throw") || wrestleChoice.equalsIgnoreCase("nothing")
                || wrestleChoice.equalsIgnoreCase("stay") || wrestleChoice.equalsIgnoreCase("back up"))) {
            System.out.println(
                    "*sigh* I don't get paid enough for you idiots. Pick another move.");
            wrestleChoice = scan.nextLine();
        }
        if (wrestleChoice.equalsIgnoreCase("throw")) {
            if (Math.random() <= rohanThrowChance) {
                System.out.println("(Rohan also tried to throw)\n");
                double randomThrowRohan = Math.random();
                double randomThrowNolan = Math.random();
                if (randomThrowRohan <= rohanThrow && randomThrowNolan >= nolanThrow) {
                    System.out.println(
                            "Nolan, you can't beat Rohan in a close wrestle. You gotta stop trying or you'll be thrown to the ground like that again.");
                    System.out.println("You lost because Rohan is a beast.");
                    lose();
                } else if (randomThrowNolan >= nolanThrow && randomThrowRohan <= rohanThrow) {
                    System.out.println(
                            "Great job Nolan! I'm surprised you could beat Rohan when you're both fighting for a throw. Good round.");
                    win();
                } else {
                    System.out.println(
                            "Break it up! You both tried to throw at the same time and got stuffed up. It's been a long match. Do you wanna 'continue' or 'rest'");
                    String response = scan.nextLine();
                    if (response.equalsIgnoreCase("relax")) {
                        System.out.println(
                                "Fine, I'll take pity on you. Great round, both of you. Now go rest up, and get ready for another round later.");
                    } else {
                        System.out.println(
                                "That's what I like to hear! Now, you're gonna start in kicking range.\n3, 2, 1, GO!");
                        rangeNolan();
                    }
                }
            } else {
                if (Math.random() <= nolanThrow) {
                    System.out.println("Good throw Nolan! Way to use your technique, and trip Rohan up. Great round!");
                    win();
                } else {
                    System.out.println(
                            "(You failed the throw)\nGood try Nolan. Shake it off and try again. You're still in there, so don't give up.");
                    wrestleNolan();
                }
            }
        } else if (wrestleChoice.equalsIgnoreCase("stay") || wrestleChoice.equalsIgnoreCase("nothing")) {
            if (Math.random() <= rohanThrowChance) {
                System.out.println("(Rohan came in to throw)");
                if (Math.random() <= rohanThrow) {
                    System.out.println(
                            "(And you did nothing)\nNolan! How did you let Rohan just walk up and take you down? Use your strength next time");
                    System.out.println(
                            "You lost because you didn't try to fight Rohan when he picked you up and threw you across the room, because he's a beast");
                    lose();
                } else {
                    System.out.println(
                            "(But he failed)\nNolan, that was close man. You should not let Rohan in that close next time. He's strong, so he can beat you easy. Remember, you're still in close");
                    wrestleNolan();
                }
            } else {
                System.out.println("Stop hugging and throw the other person! Both of you! CMON!");
                wrestleNolan();
            }
        } else if (wrestleChoice.equalsIgnoreCase("back up")) {
            System.out.println("Alright, you backed out into punching range");
            punchNolan();
        }
    }

    public static void lose() {
        System.out
                .println("\\ \\  / /  .---------,  | |     | |       | |         ,----------,  ,--------,  |--------,");
        System.out
                .println(" \\ \\/ /   | ,-----, |  | |     | |       | |         | ,------, |  | ,------'  | ,------'");
        System.out.println("  \\  /    | |     | |  | |     | |       | |         | |      | |  | |______   | |______");
        System.out.println("  |  |    | |     | |  | |     | |       | |         | |      | |  |______  |  |  ______|");
        System.out.println("  |  |    | |     | |  | |     | |       | |         | |      | |         | |  | |");
        System.out.println("  |  |    | |_____| |  | |_____| |       | |______   | |______| |  _______| |  | |_______");
        System.out.println("  |  |    |_________|  |_________|       |________|  |__________|  |________|  |________|");

    }

    public static void win() {
        System.out.println(
                "\\ \\  / /  .---------,  | |     | |       \\ \\                  / /  | |  |   \\     | |");
        System.out.println(
                " \\ \\/ /   | ,-----, |  | |     | |        \\ \\                / /   | |  | |\\ \\    | |");
        System.out.println(
                "  \\  /    | |     | |  | |     | |         \\ \\              / /    | |  | | \\ \\   | |");
        System.out.println(
                "  |  |    | |     | |  | |     | |          \\ \\    ____    / /     | |  | |  \\ \\  | |");
        System.out.println(
                "  |  |    | |     | |  | |     | |           \\ \\  / /\\ \\  / /      | |  | |   \\ \\ | |");
        System.out.println(
                "  |  |    | |_____| |  | |_____| |            \\ \\/ /  \\ \\/ /       | |  | |    \\ \\| |");
        System.out.println(
                "  |  |    |_________|  |_________|             \\__/     \\_/        | |  | |     \\___|");

    }
}