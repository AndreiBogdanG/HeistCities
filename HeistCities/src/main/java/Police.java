import java.util.Scanner;

public class Police {
    Actions action = new Actions();
    Inventory inventory = new Inventory();
    Scanner scanner = new Scanner(System.in);
    String option;
    String cheat;
    boolean areYouSure;
    boolean isNumber;
    boolean bribedCop;
    int cash;

// Method for tha police to come and try to catch you:
public void chase(){
   boolean escaped = action.doYouFeelLuckyToday(70);
    Sounds.playSound("politia");
    System.out.println("Police started to chase you...");
    if (escaped){
        System.out.println("Count your lucky stars, the cops lost you!");
    } else {
        // Police takes all your merch plus half of your cash;
        Character.setCash(Character.getCash()/2);
        System.out.print("Damn, you were caught! ");
        if (inventory.clearInventory()) {
            System.out.println("and " + (Character.getCash() / 2) + " Euro.");
        } else {
            System.out.println("Police confiscates half of your money.");
        }
        System.out.println("Press ENTER to continue...");
        scanner.nextLine();
    }
}

// Method for random police check:
public void randomPoliceCheck(){
    boolean randomCheck = action.doYouFeelLuckyToday(30);

    if (randomCheck){
    Sounds.playSound("police");
    System.out.println("Police wants to stop you for random check. What do you want to do? (run/stop)");
    do{
        option = scanner.nextLine();
        if (option.equalsIgnoreCase("run")){
            chase();
        } else if (option.equalsIgnoreCase("stop")){
            System.out.println("You stop and the policeman approaches your car.");
            // Try to bribe the policeman only if you have some merch on you:
            if (!inventory.emptyInventory()) {

                areYouSure = Menu.doYouWant("to offer him a bribe");
            }
            // Try to bribe the cop:
            if (areYouSure){
            do {
            System.out.print("How much would you like to offer? ");
            try {
                cash = Integer.parseInt(scanner.nextLine());
                isNumber = true;
            } catch (NumberFormatException nfe) {
                isNumber = false;
            }
        } while (!isNumber);

                if (cash == 0){
                     bribedCop = action.doYouFeelLuckyToday(0);
                } else if (cash < 100) {
                     bribedCop = action.doYouFeelLuckyToday(10);
                } else if (cash <500) {
                     bribedCop = action.doYouFeelLuckyToday(20);
                } else if (cash < 2000){
                     bribedCop = action.doYouFeelLuckyToday(50);
                }else if (cash < 5000) {
                     bribedCop = action.doYouFeelLuckyToday(75);
                } else {
                     bribedCop = action.doYouFeelLuckyToday(90);
                }

                if (bribedCop){
                    System.out.println("Policeman takes your money; you're free to go!");
                    System.out.println("Press ENTER to continue...");
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("You found a clean cop, he doesn't take your money!");
                    System.out.print("Anything else you'd like to ask him? ");
                    cheat = scanner.nextLine();
                    if (cheat.contains("know") || cheat.contains("phone") || cheat.contains("cine") || cheat.contains("telefon")){
                        System.out.println();
                        System.out.println("Policeman says he's sorry and wishes you a great day!");
                        System.out.println("Press ENTER to continue...");
                        scanner.nextLine();
                    } else {
                        if (inventory.clearInventory()) {
                            System.out.println("and half of your money.");
                            Character.setCash(Character.getCash() / 2);
                            System.out.println("Press ENTER to continue...");
                            scanner.nextLine();
                            break;

                        } else {
                            System.out.println("You should get a ticket for running, though...");
                            System.out.println("Press ENTER to continue...");
                            scanner.nextLine();
                            break;
                        }
                    }
                    break;
                }

            } else {
                // Policeman takes all your merch plus half of your cash;

                if (inventory.clearInventory()) {
                    System.out.println("and " + (Character.getCash() / 2) + " Euro.");
                    Character.setCash(Character.getCash() / 2);
                    System.out.println("Press ENTER to continue...");
                    scanner.nextLine();
                    break;
                  } else {
                    System.out.println("You're clean!");
                    System.out.println("Press ENTER to continue...");
                    scanner.nextLine();
                    break;
                }
            }
        }

    } while (!option.equalsIgnoreCase("run") && !option.equalsIgnoreCase("stay"));
    }
  }
}
