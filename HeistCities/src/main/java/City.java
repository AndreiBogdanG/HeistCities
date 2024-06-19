import java.util.LinkedHashMap;
import java.util.Scanner;

public class City {
    LinkedHashMap<String, String> cities = new LinkedHashMap<>();
    private static String city;
    private static String currentCity;
    private static int gasPrice = 10;
    Bank bank = new Bank();
    Scanner scanner = new Scanner(System.in);
    Files file = new Files();
    Merchandise merchandise = new Merchandise();
    Police police = new Police();

// Method to nicely show all the available places:
    public void showCities() {
        cities = file.readCities();
        Sounds.playSound("pestetot");
        for (String city : cities.keySet()) {
           if (!String.valueOf(cities.lastEntry()).equals(city+"="+cities.get(city))){
                System.out.print(Colors.blue() + city + ", ");
            } else {
                System.out.print(city + Colors.reset() + ")");
            }
        }
    }

// Method to choose the initial city:
   public String setFirstCity(){
       showCities();
       System.out.println(" ");
       do {
           System.out.print("            Choose from the list above: ");
           city = scanner.nextLine();

       } while (!file.readCities().containsKey(city));
           currentCity = city;
           Character.setDays(Character.getDays() + 1);
        return city;
}

// Method to travel to another city:
    public String goToCity() {
            showCities();
            System.out.println(" ");
            do {
                System.out.print("Choose from the list above (or type \"X\" to cancel): ");
                city = scanner.nextLine();
                if (city.equalsIgnoreCase(currentCity)) {
                    System.out.println("You're already in " + currentCity + "!");
                } else if (city.equalsIgnoreCase("x")){
                    break;
                }
            } while (!file.readCities().containsKey(city) || city.equalsIgnoreCase(currentCity) );

            // find out the price of gas needed to travel:
            if (Character.getDays() != 0 && !city.equalsIgnoreCase("x")) {
                String coordXYold = file.cities.get(currentCity);
                int coordXold = coordXYold.charAt(0);
                int coordYold = coordXYold.charAt(1);
                String coordXYnew = file.cities.get(city);
                int coordXnew = coordXYnew.charAt(0);
                int coordYnew = coordXYnew.charAt(1);
                int distance = (Math.abs(coordXold - coordXnew) + Math.abs(coordYold - coordYnew));
                gasPrice = distance * 10;
            }
        System.out.println("Gas price: " + gasPrice + " Euro");
if ( !city.equalsIgnoreCase("x")) {
    Sounds.playSound("car");
    if (Menu.areYouSure(" you want to go to " + city)) {

        if (Character.getCash() >= gasPrice) {    // If you have money for gas:
            merchandise.modifyAllPrices();
            Bank.justRobbed = false;
            Merchandise.justStolen = false;
            currentCity = city;
            Character.setDays(Character.getDays() + 1);
            Character.setCash(Character.getCash() - gasPrice);

            // If there's any money in the bank account, add 3.5% interest
            if (bank.getBankAccount() > 0) {
                int interest = (int) Math.round((bank.getBankAccount() * 3.5) / 100);
                bank.setBankAccount(bank.getBankAccount() + interest);
            }
            police.randomPoliceCheck();

        } else {    // If you don't have money for gas
            System.out.println();

            if (Character.getCash() > 0) {
                System.out.println("Gas costs " + gasPrice + " Euro, but you only have " + Character.getCash() + ".");
            } else {
                System.out.println("Gas costs " + gasPrice + " Euro, but you don't have a cent in your pockets.");
            }

            System.out.println(Colors.yellow() + "You don't have enough money :(" + Colors.reset());
            System.out.println("Press ENTER to continue...");
            scanner.nextLine();
        }
    }
  }
        return currentCity;
    }
    public static String getCity() {
        return city;
    }
}


