import java.util.Scanner;

public class ChooseYourOwnAdventure {

    //Rohan's moves stats
    private static double rohanRoundhouseLand = 0.85;
    private static double rohanSpinkickLand = 0.10;
    private static double rohanBackideLand = 0.50;
    private static double rohanFrontLand = 0.80;
    private static double rohanSlideUpLand = 0.75;
    private static double rohanJabLand = 0.90;
    private static double rohanCrossLand = 0.85;
    private static double rohanHookLand = 0.60;
    private static double rohanCatch = 0.60;
    private static double rohanThrow = 0.85;
    
    //Nolan's moves stats
    private static double nolanRoundhouseLand = 0.85;
    private static double nolanSpinkickLand = 0.50;
    private static double nolanBackideLand = 0.90;
    private static double nolanFrontLand = 0.30;
    private static double nolanSlideUpLand = 0.15;
    private static double nolanJabLand = 0.90;
    private static double nolanCrossLand = 0.85;
    private static double nolanHookLand = 0.60;
    private static double nolanCatch = 0.70;
    private static double nolanThrow = 70;
    
    //Odds of attack
    private static double rohanKickChance = 0.60;
    private static double nolanKickChance = 0.70;
    private static double rohanPunchChance = 0.50;
    private static double nolanPunchChance = 0.60;
    private static double rohanAdvanceChance = 0.60;
    private static double nolanAdvanceChance = 0.30;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Trait strings
        String rohanTraits = "Power: 4/5\nSpeed: 2/5\nFleibility: 3/5\nRange: 5/5";
        String nolanTraits = "Power: 3/5\nSpeed: 5/5\nFleibility: 4/5\nRange: 2/5";

        //START GAME
        System.out.println("Welcome to Kung Jung Mu Sul! Sir Nick says that you're late. He's very intimidating. Would you like to spar?");
        String start = scan.nextLine();
        if (start.equalsIgnoreCase("yes")) {
            System.out.println("Great! Get your sparring gear on!");
        }
        else {
            System.out.println("Too bad! Sir Nick says \"Get your sparring gear on!\"");
        }

        //Color choice
        System.out.println("Do you want a red or blue chestguard?");
        String chestguardColor = scan.nextLine();
        if (chestguardColor.equalsIgnoreCase("red")) {
            System.out.println("Your name is Rohan. Here are your traits: \n" + rohanTraits);
            rohan();
        }
        else if (chestguardColor.equalsIgnoreCase("blue")) {
            System.out.println("Your name is Nolan. Here are your traits: \n" + nolanTraits);
            nolan();
        }
        else {
            System.out.println("\"No one in Kung Jung Mu Sul uses a " + chestguardColor + " colored chestguard. GET OUT!\" says Sir Nick. Bye!");
        }
    }

    //WHEN YOU PLAY AS ROHAN
    public static void rohan() {
        

    }

    //WHEN YOU PLAY AS NOLAN
    public static void nolan() {
        
    }
}