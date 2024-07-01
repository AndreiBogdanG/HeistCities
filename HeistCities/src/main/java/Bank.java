import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    private static int bankAccount;
    private int cash;
    private boolean isNumber;
    Random random = new Random();
    Actions action = new Actions();
    Scanner scanner = new Scanner(System.in);
    Police police = new Police();
    static boolean justRobbed = false;

    // method to deposit cast into your bank account
    public void deposit() {
        do {
            System.out.print("You have " + Character.getCash() + " Euro. How much would you like to deposit? ");
            try {
                cash = Integer.parseInt(scanner.nextLine());
                isNumber = true;
            } catch (NumberFormatException ex) {
                isNumber = false;
            }
        } while (!isNumber | cash > Character.getCash());

        if (cash == 0) {
            System.out.println("Changed your mind? No problem!");
        } else {
            bankAccount = bankAccount + cash;
            Sounds.playSound("cashreg");
            Character.setCash(Character.getCash() - cash);
        }
    }

    // method to withdraw cash from your bank account
    public void withdraw() {
        do {
            System.out.print("You have " + bankAccount + " Euro. How much would you like to withdraw? ");
            try {
                cash = Integer.parseInt(scanner.nextLine());
                isNumber = true;
            } catch (NumberFormatException ex) {
                isNumber = false;
            }
        } while (!isNumber | cash > bankAccount);

        if (cash == 0) {
            System.out.println("Changed your mind? No problem!");
        } else {
            bankAccount = bankAccount - cash;
            Sounds.playSound("cashreg");
            Character.setCash(Character.getCash() + cash);
        }
    }

    // Method to rob the bank:
    // returns 0 if you fail and get caught, or a random sum of money if you succeed;
    public int robBank() {
        int loot = 0;
        int chances;
        boolean areYouSure;

        // Look around and see what chances you've got to succeed. Then ask yourself if you really want to do it:
        chances = random.nextInt(0, 100);
        Sounds.playSound("posibil");
        System.out.print("You're thinking: ");
        if (chances < 15) {
            System.out.println("\"Look at all these armed guards! It's impossible!\"");
        } else if (chances < 25) {
            System.out.println("\"Wow, I must be crazy to try to rob this bank!\"");
        } else if (chances < 50) {
            System.out.println("\"I don't know if I should take the chances...\"");
        } else if (chances < 75) {
            System.out.println("\"The question is: do I feel lucky today?!?\"");
        } else if (chances < 90) {
            System.out.println("\"It's like stealing candy from a baby... \"");
        } else if (chances <= 100) {
            System.out.println("\"This money is practically mine...\"");
        }
        areYouSure = Menu.areYouSure("you want to rob the bank");

        if (areYouSure) {
            justRobbed = true;
            if (action.doYouFeelLuckyToday(chances)) {
            if (Character.getCash() == 0) {
                loot = random.nextInt(2000, 5000);
            } else {
                loot = random.nextInt((int) (Character.getTotalMoney() * 0.5), Character.getTotalMoney() * 2);
            }
                System.out.println();
                Sounds.playSound("raid");
                System.out.println("Wow, you managed to rob the bank! You have stolen " + loot + " Euro");
                Character.setCash(Character.getCash() + loot);
            } else {
                police.chase();
            }
        } else {
            System.out.println("Winner winner, chicken dinner... Maybe next time.");
        }
        return loot;
    }

    //getters and setters:
    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        Bank.bankAccount = bankAccount;
    }

    public int getCash() {
        return cash;
    }
}



