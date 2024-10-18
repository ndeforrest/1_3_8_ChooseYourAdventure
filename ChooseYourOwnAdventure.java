import java.lang.Math;
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
    }
}