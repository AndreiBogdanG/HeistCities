import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    Character character = new Character();
    String option;
    boolean correct;

    // method to get a y/n prompt with "are you sure" question:
    public static boolean areYouSure(String action) {
        String choice;
        boolean yesNo;
        do {
            System.out.print("Are you sure " + action + "? (Y/N) ");
            choice = scanner.nextLine();
            yesNo = choice.equalsIgnoreCase("y");

        } while (!choice.equalsIgnoreCase("y") & !choice.equalsIgnoreCase("n"));
        return yesNo;
    }

// method to get a y/n prompt with "do you want" question:
    public static boolean doYouWant(String action) {
        String choice;
        boolean yesNo;
        do {
            System.out.print("Do you want to " + action + "? (Y/N) ");
            choice = scanner.nextLine();
            yesNo = choice.equalsIgnoreCase("y");

        } while (!choice.equalsIgnoreCase("y") & !choice.equalsIgnoreCase("n"));
        return yesNo;
    }

// method to read the City menu
    public String cityMenu() {
        clearScreen();

        switch (character.getCity()){
            case "Bucuresti":
                Sounds.playSound("bucuresti");
                break;
            case "Constanta":
                Sounds.playSound("coasta");
                break;
            case "Arad":
                Sounds.playSound("arad");
                break;
            case "Timisoara":
                Sounds.playSound("timisoara");
                break;
            case "Targu Jiu":
                Sounds.playSound("targu_jiu");
                break;
            case "Galati":
                Sounds.playSound("galati");
                break;
            case "Pitesti":
                Sounds.playSound("pitesti");
                break;
            case "Suceava":
                Sounds.playSound("bistrita_bacau_suceava");
                break;
            case "Craiova":
                Sounds.playSound("craiova");
                break;
            default:
                Sounds.playSound("traffic");
        }

        System.out.println(" ");
        if (Character.getDays() < Character.getMaxDays() - 1) {
            System.out.println("          Day " + Character.getDays() + ":");
        } else {
            System.out.println(Colors.red() + "         LAST DAY:" + Colors.reset());
        }
        System.out.println("    WELCOME TO FABULOUS");
        System.out.println(Colors.red() + "--------- " + Colors.yellowBright() + character.getCity() + Colors.red() + " ---------" + Colors.reset());

        if (Merchandise.justStolen) {
            System.out.println(Colors.black() + "1. Market closed (police investigation)." + Colors.reset());
        } else {
            System.out.println("1. Go to Market.");
        }
        if (Bank.justRobbed) {
            System.out.println(Colors.black() + "2. Bank closed (police investigation)." + Colors.reset());
        } else {
            System.out.println("2. Go to Bank.");
        }
        System.out.println("3. Go to Casino.");
        System.out.println("4. Cash & inventory.");

        if (Character.getDays() < Character.getMaxDays() - 1) {
            System.out.println("5. Leave City.");
        } else {
            System.out.println(Colors.black() + "4. Leave city." + Colors.reset());
        }
        if (Character.getDays() < Character.getMaxDays() - 1) {
            System.out.println("X. Give up and exit game.");
        } else {
            System.out.println("X. Time to pack your stuff and " + Colors.yellow() + "Exit game." + Colors.reset());
        }
        System.out.println(Colors.red() + "---------------------------" + Colors.reset());

        do {
            System.out.print("What would you like to do? ");
            option = scanner.nextLine();
            switch (option) {
                case "1", "2", "3", "4", "5", "x", "X", "$3":
                    correct = true;
                    break;
                default:
                    correct = false;
                    break;
            }

        } while (!correct);
        return option;
    }

    // method to read the Bank menu
    public String bankMenu() {
        clearScreen();
        System.out.println(Colors.red() + "----------" + Colors.yellow() + " B A N K" + Colors.red() + " --------" + Colors.reset());
        System.out.println("1. Deposit cash.");
        System.out.println("2. Withdraw cash.");
        System.out.println("3. Bank balance.");
        System.out.println("4. Count your cash.");
        System.out.println("5. Rob the bank.");
        System.out.println("6. Leave bank.");
        System.out.println(Colors.red() + "---------------------------" + Colors.reset());

        do {
            System.out.print("What would you like to do? ");
            option = scanner.nextLine();
            switch (option) {
                case "1", "2", "3", "4", "5", "6":
                    correct = true;
                    break;
                default:
                    correct = false;
                    break;
            }
        } while (!correct);
        return option;
    }

// method to read the Bank menu
    public String marketMenu() {
        clearScreen();
        System.out.println(Colors.red() + "------------ " + Colors.yellow() + "M A R K E T " + Colors.red() + "------------" + Colors.reset());
        System.out.println("1. Buy items.");
        System.out.println("2. Sell items.");
        System.out.println("3. Check prices.");
        System.out.println("4. Steal something.");
        System.out.println("5. Leave market.");
        System.out.println(Colors.red() + "-------------------------------------" + Colors.reset());

        do {
            System.out.print("What would you like to do? ");
            option = scanner.nextLine();
            switch (option) {
                case "1", "2", "3", "4", "5":
                    correct = true;
                    break;
                default:
                    correct = false;
                    break;
            }

        } while (!correct);
        return option;
    }

// method to clear the screen:
    public static void clearScreen() {
        for (int i = 1; i < 50; i++) {
            System.out.println();
        }
    }
// Method to print the intro:

    public static void intro(){
        clearScreen();
        System.out.println(Colors.yellow() + "      __ ____________________  ____________________________");
        System.out.println("     / // / __/  _/ __/_  __/ / ___/  _/_  __/  _/ __/ __(_)");
        System.out.println("    / _  / _/_/ /_\\ \\  / /   / /___/ /  / / _/ // _/_\\ \\_ ");
        System.out.println("   /_//_/___/___/___/ /_/    \\___/___/ /_/ /___/___/___(_) ");
        System.out.println(Colors.blue() + "              ___  ____  __  ______   _  _________  ");
        System.out.println("             / _ \\/ __ \\/  |/  / _ | / |/ /  _/ _ | ");
        System.out.println(Colors.yellowBright() +"            / , _/ /_/ / /|_/ / __ |/    // // __ | ");
        System.out.println(Colors.red() + "           /_/|_|\\____/_/  /_/_/ |_/_/|_/___/_/ |_| " + Colors.green());
        System.out.println();

        System.out.println("    Welcome to " + Colors.yellowBright() + "\"Heist Cities: Romania\"," + Colors.green() + " where the path to riches ");
        System.out.println(" is paved with risk and cunning. Step into the shoes of a small-time");
        System.out.println("crook with big dreams, navigating the shadowy underworld of Romania's");
        System.out.println("bustling cities. From the ancient streets of Bucharest to the vibrant");
        System.out.println("  markets of Cluj-Napoca, your journey to wealth involves smuggling,");
        System.out.println("stealing, robbing, and gambling. Strategize your heists, outsmart the ");
        System.out.println("authorities, and turn every city into your playground. Are you ready to ");
        System.out.println("       become Romania's most notorious criminal mastermind? ");
        System.out.println("                 The heist of a lifetime awaits!");
    }

// Method with graphics to win the game:
    public void theEnd() {
        System.out.println();
        System.out.println(Colors.yellowBright() + "  _______ _    _ ______   ______ _   _ _____ ");
        System.out.println(" |__   __| |  | |  ____| |  ____| \\ | |  __ \\ ");
        System.out.println("    | |  | |__| | |__    | |__  |  \\| | |  | |");
        System.out.println("    | |  |  __  |  __|   |  __| | . ` | |  | |");
        System.out.println("    | |  | |  | | |____  | |____| |\\  | |__| |");
        System.out.println("    |_|  |_|  |_|______| |______|_| \\_|_____/ " + Colors.reset());
        System.out.println();
        Sounds.playSound("poveste");
        // If game is won:
        if (Character.getTotalMoney()>1000000) {
            System.out.println(Colors.blue() + " Wow, you did it!!! You are now a millionaire! ");
            System.out.println("It took you " + Character.getDays() + " days.");
            System.out.println(Colors.red() + "              Congratulations!" + Colors.green());
        }
        System.out.println(" I hope you had fun. See you in my next game!" + Colors.reset());
        System.out.println();
        System.out.println(Colors.green() + "         Press ENTER to exit game." + Colors.reset());
        scanner.nextLine();
    }
}
