import java.util.*;

public class Merchandise {
    LinkedHashMap<String, Integer> currentMerch = new LinkedHashMap<>();
    LinkedHashMap<String, Integer> basicMerch = new LinkedHashMap<>();
    Files files = new Files();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Inventory inventory = new Inventory();
    Police police = new Police();
    String item;
    int quantity;
    int oldQuantity;
    int newQuantity;
    int paidCash;
    static boolean justStolen = false;
    Actions action = new Actions();

    public Merchandise() {
        initializeMerch();
    }

//method to initialize the current Merch:
    public void initializeMerch() {
        basicMerch = new LinkedHashMap<>(files.readMerch());
        currentMerch = new LinkedHashMap<>(files.readMerch());
    }

//method to nicely print all the merchandise with the corresponding price:
    public void printMerch(HashMap<String, Integer> merchList) {
        for (int i=1; i<50;i++){
            System.out.println();
        }
        System.out.println(Colors.green() + "Merchandise available at the market: " + Colors.reset());
        for (String merch : merchList.keySet()) {

        //here I check if the price is higher or lower than the reference price and change the color accordingly:

            if (merchList.get(merch)>(basicMerch.get(merch))){
                System.out.println(Colors.blue() + "↑ " + Colors.reset() + merch + " - " + merchList.get(merch) + " Euro");
            } else if (merchList.get(merch)<(basicMerch.get(merch))){
                System.out.println(Colors.red() + "↓ " + Colors.reset()  + merch + " - " + merchList.get(merch) + " Euro");
            } else {
                System.out.println("↔ " + merch + " - " + merchList.get(merch) + " Euro");
            }
        }
    }

//method to modify all the prices, with a random percent (0-50%):
    public void modifyAllPrices() {
        int oldPrice;
        int newPrice;
        boolean increasePrice;
        int percent;

        for (String item : currentMerch.keySet()) {
            oldPrice = currentMerch.get(item);
            increasePrice = random.nextBoolean();
            percent = random.nextInt(0, 50);

            if (increasePrice) {
                newPrice = oldPrice + (oldPrice * percent) / 100;
            } else {
                newPrice = oldPrice - (oldPrice * percent) / 100;
            }
            currentMerch.put(item, newPrice);
        }
    }

// method to buy an item:
    public void buyItem() {
        // first, check to see if you have enough money
        // ask which item to buy, then show the maximum amount you can afford
        int affordableQuantity;
        boolean isNumber;

    // repeat until choice = 0
     do {
         printMerch(currentMerch);
         do {
             do {
                 System.out.print("What would you like to buy with your " + Character.getCash() + " euro? (type \"nothing\" to exit) ");
                 item = scanner.nextLine();
                 if (Objects.equals(item, "0") || item.equalsIgnoreCase("nothing")) {
                     System.out.println("Changed your mind, have you?");
                     System.out.println("Press Enter key to continue...");
                     scanner.nextLine();
                     break;
                 }
             } while (!currentMerch.containsKey(item));

             if (item.equalsIgnoreCase("0") | item.equalsIgnoreCase("nothing")) {
                 affordableQuantity = 0;
                 break;
             }
             double price = currentMerch.get(item);
             affordableQuantity = (int) (Character.getCash() / price);
             if (affordableQuantity < 1) {
                 System.out.println("Not enough doe. Try something else.");
             }
         } while (affordableQuantity <= 0);

         if (item.equalsIgnoreCase("0") | item.equalsIgnoreCase("nothing")) {
             break;
         } else {

             System.out.print("You can afford " + affordableQuantity + ". ");

             do {
                 do {
                     System.out.print("How many would you like to buy? ");
                     try {
                         quantity = Integer.parseInt(scanner.nextLine());
                         isNumber = true;
                     } catch (NumberFormatException nfe) {
                         isNumber = false;
                     }
                 } while (!isNumber);
             } while (quantity > affordableQuantity);

             // update the inventory with the bought quantity:
             if (quantity != 0) {
                                  if (Inventory.inventory.get(item) != null) {
                     oldQuantity = Inventory.inventory.get(item);
                     newQuantity = oldQuantity + quantity;
                 } else {
                     newQuantity = quantity;
                 }
                 Inventory.inventory.put(item, newQuantity);

                 // take cash out of your stack to pay for the items:
                 int paidCash = quantity * currentMerch.get(item);
                 Character.setCash(Character.getCash() - paidCash);
                 System.out.println("You have " + Character.getCash() + " Euro left.");
                 System.out.println("Press Enter key to continue...");
                 scanner.nextLine();
             } else {
                 System.out.println("No biggie, maybe next time.");
                 System.out.println("Press Enter key to continue...");
                 scanner.nextLine();
             }
         }
     } while (true) ;
    }

    // method to sell an item:
    public void sellItem() {
        boolean isNumber;
        // if the inventory is empty, you can't sell!
        if (!inventory.emptyInventory()) {
            do {
                printMerch(currentMerch);
                System.out.println();
                inventory.showInventory();
                do {
                    System.out.print("What would you like to sell? ");
                    item = scanner.nextLine();
                    if (Objects.equals(item, "0") | item.equalsIgnoreCase("nothing")) {
                        System.out.println("Press Enter key to continue...");
                        scanner.nextLine();
                        break;
                    }

                } while (!Inventory.inventory.containsKey(item));
                if (!Objects.equals(item, "0") & !item.equalsIgnoreCase("nothing")) {
                    do {
                        do {
                            System.out.print("You currently have " + Inventory.inventory.get(item) + ". ");
                            System.out.print("How many do you want to sell? ");

                            try {
                                quantity = Integer.parseInt(scanner.nextLine());
                                isNumber = true;
                            } catch (NumberFormatException ex) {
                                isNumber = false;
                            }
                        } while (!isNumber);
                    } while (quantity > Inventory.inventory.get(item));

                    // take out the items from the inventory:
                    if (quantity != 0) {
                        oldQuantity = Inventory.inventory.get(item);
                        newQuantity = oldQuantity - quantity;
                        Inventory.inventory.put(item, newQuantity);
                        System.out.println("You sold " + quantity + " " + item + " and you now have " + newQuantity + " left.");
                        // add the money to your cash:
                        paidCash = quantity * currentMerch.get(item);    //!
                        Character.setCash(Character.getCash() + paidCash);
                        Sounds.playSound("cashreg");
                        System.out.println("You now have " + Character.getCash() + " Euro.");
                        System.out.println("Press Enter key to continue...");
                        scanner.nextLine();

                        // if remaining quantity is 0, delete the whole item:
                        if (newQuantity == 0) {
                            Inventory.inventory.remove(item);
                        }
                    }
                } else {
                    System.out.println("Bummer. Maybe next time!");
                    break;
                }
            } while (true);
        } else {
            System.out.println();
            System.out.println("You don't have any items. Whadda' ya' wanna sell, your soul?!? Press ENTER to go back...");
            scanner.nextLine();
        }
    }
// Method to steal from the market
    public void stealFromMarket(){
        int chances = random.nextInt(1,10);
        int merch = random.nextInt(1,12);
        int qty = random.nextInt(2,10);
        System.out.println("Number of people around you: " + (10-chances));
        if (Menu.areYouSure("you want to steal")){
            justStolen = true;
          if(action.doYouFeelLuckyToday(chances*10)){
              Sounds.playSound("ciordeala");
              switch (merch){
                  case 1:
                      System.out.print("You managed to steal " + qty + " packs of cigarettes.");
                      Inventory.inventory.put("Cigarettes", qty);
                      break;
                  case 2:
                      System.out.print("You managed to steal " + qty + " bags of clothes.");
                      Inventory.inventory.put("Clothes", qty);
                      break;
                  case 3:
                      System.out.print("You managed to steal " + qty + " packs of coffee.");
                      Inventory.inventory.put("Coffee", qty);
                      break;
                  case 4:
                      System.out.print("You managed to steal " + qty + " bags of drugs.");
                      Inventory.inventory.put("Drugs", qty);
                      break;
                  case 5:
                      System.out.print("You managed to steal " + qty + " gold chains.");
                      Inventory.inventory.put("Jewelry", qty);
                      break;
                  case 6:
                      System.out.print("You managed to steal " + qty + " laptops.");
                      Inventory.inventory.put("Laptops", qty);
                      break;
                  case 7:
                      System.out.print("You managed to steal " + qty + " makeup sets.");
                      Inventory.inventory.put("Makeup", qty);
                      break;
                  case 8:
                      System.out.print("You managed to steal " + qty + " bottles of perfume.");
                      Inventory.inventory.put("Perfume", qty);
                      break;
                  case 9:
                      System.out.print("You managed to steal " + qty + " smartphones.");
                      Inventory.inventory.put("Phones", qty);
                      break;
                  case 10:
                      System.out.print("You managed to steal " + qty + " purses.");
                      Inventory.inventory.put("Purses", qty);
                      break;
                  case 11:
                      System.out.print("You managed to steal " + qty + " pairs of shoes.");
                      Inventory.inventory.put("Shoes", qty);
                      break;
                  case 12:
                      System.out.print("You managed to steal " + qty + " watches.");
                      Inventory.inventory.putIfAbsent("Watches", qty);
                      break;
              }
              System.out.println(" You'd better split, someone called the cops! ");
          } else {
             police.chase();
          }
          Sounds.playSound("politia");
        }
    }
}
