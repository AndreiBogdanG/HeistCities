import java.util.Scanner;

public class Character {
    private static String name;
    private static String newCity;
    private static int cash;

    private static int startingCash;
    private static int days = 0;
    private static final int maxDays = 365;
    static Scanner scanner = new Scanner(System.in);
    static City city = new City();
    static Bank bank = new Bank();

// method to create the intro and the character:

    public void initCharacter() {
        Menu.intro();
        System.out.println();
        System.out.print(Colors.blue() + "             Hello! What's your name? " + Colors.reset());
        name = scanner.nextLine();
        System.out.println();
        System.out.println("            Where are you from?");
        System.out.print("(");
        newCity = city.setFirstCity();
        cash = 1000;
        startingCash = cash;
        System.out.println();
        System.out.println("Welcome to " + newCity + ", " + name + "! You have " + startingCash + " Euro in your pockets.");
        System.out.println("Press ENTER to start making money...");
        scanner.nextLine();
    }

// method to check balance:
    public void checkBalance(){
        int totalMoney = bank.getBankAccount() + getCash();
        System.out.println("You now have a total of " + totalMoney +" Euro: " + bank.getBankAccount() +" in your bank account and " + getCash() + " in your pockets.");
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return newCity;
    }

    public static int getDays() {
        return days;
    }

    public static void setDays(int days) {
        Character.days = days;
    }

    public static int getCash() {
        return cash;
    }

    public static int getTotalMoney() {
        return cash + bank.getBankAccount();
    }





    public static void setCash(int cash) {
        Character.cash = cash;
    }

    public static int getMaxDays() {
        return maxDays;
    }

    public void setCity(String city) {
        newCity = city;
    }

    public static int getStartingCash() {
        return startingCash;
    }
}
