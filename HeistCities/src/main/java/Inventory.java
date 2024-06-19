import java.util.LinkedHashMap;

public class Inventory {

    static LinkedHashMap<String, Integer> inventory;
    boolean confiscated;

// method to create an empty inventory list:
    public void createInventory() {
        inventory = new LinkedHashMap<>();
    }

// method to check if the inventory is empty:
    public boolean emptyInventory() {
        return inventory.isEmpty();
    }

// method to show (print) your inventory:
    public void showInventory() {
        if (inventory != null) {
            if (!inventory.isEmpty()) {
                System.out.println("Here's your inventory: ");
                System.out.println(Colors.green() + "Cash: " + Character.getCash() + " Euro." + Colors.yellowBright());
                for (String item : inventory.keySet()) {
                    System.out.println(item + ": " + inventory.get(item) + " pcs.");
                }
                System.out.println(Colors.reset());
            } else {
                System.out.println("You have " + Character.getCash() + " Euro in your pockets.");
                System.out.println("You don't have any merchandise at the moment.");
            }
        } else {
            System.out.println(" - nothing - ");
        }
    }

// method to clear the inventory, as when the police catches you:
    public boolean clearInventory() {
        if (inventory != null) {
            if (!inventory.isEmpty()) {
                    inventory.clear();
                System.out.print("Police confiscates all your stuff ");
                confiscated = true;
            } else {
                System.out.print("No merchandise found on you. ");
            }
        } else {
            System.out.println(" No inventory list... ");
        }
    return confiscated;
    }
}


