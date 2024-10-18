import java.util.Scanner;

public class ChooseYourOwnAdventure {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Trait strings
        String rohanTraits = "Power: 4/5\nSpeed: 2/5\nFleibility: 3/5\nRange: 5/5";
        String nolanTraits = "Power: 3/5\nSpeed: 5/5\nFleibility: 4/5\nRange: 2/5";

        //Rohan's moves stats
        double rohanRoundhouseLand = 0.85;
        double rohanSpinkickLand = 0.10;
        double rohanBackideLand = 0.50;
        double rohanFrontLand = 0.80;
        double rohanSlideUpLand = 0.75;
        double rohanJabLand = 0.90;
        double rohanCrossLand = 0.85;
        double rohanHookLand = 0.60;
        double rohanCatch = 0.60;
        double rohanThrow = 0.85;

        //Nolan's moves stats
        double nolanRoundhouseLand = 0.85;
        double nolanSpinkickLand = 0.50;
        double nolanBackideLand = 0.90;
        double nolanFrontLand = 0.30;
        double nolanSlideUpLand = 0.15;
        double nolanJabLand = 0.90;
        double nolanCrossLand = 0.85;
        double nolanHookLand = 0.60;
        double nolanCatch = 0.70;
        double nolanThrow = 70;

        //Odds of attack
        double rohanKickChance = 0.60;
        double nolanKickChance = 0.70;
        double rohanPunchChance = 0.50;
        double nolanPunchChance = 0.60;
        double rohanAdvanceChance = 0.60;
        double nolanAdvanceChance = 0.30;

        //START GAME
        System.out.println("Would you like to spar?");
        String start = scan.nextLine();
        if (start.equalsIgnoreCase("yes")) {
            System.out.println("Great! Get your sparring gear on!");
        }
        else {
            System.out.println("Too bad! Sir Nick says \"Get your sparring gear on!\"");
        }

        System.out.println("Do you want a red or blue chestguard?");
        String chestguardColor = scan.nextLine();
        if (chestguardColor.equalsIgnoreCase("red")) {
            System.out.println("Your name is Rohan. Here are your traits: \n" + rohanTraits);
        }
        else if (chestguardColor.equalsIgnoreCase("blue")) {
            System.out.println("Your name is Nolan. Here are your traits: \n" + nolanTraits);
        }
        else {
            System.out.println("\"No one in Kung Jung Mu Sul uses a " + chestguardColor + " colored chestguard. GET OUT!\" says Sir Nick. Bye!");
        }
    }
}