import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Slots {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> fruitList = new ArrayList<>();
    Random random= new Random();
    Menu menu = new Menu();
    String option;
    int nrRotiri;
    int castig50;
    String symbols;
    String tempSymbol;
    char symbol1;
    char symbol2;
    char symbol3;
    char symbol4;
    char symbol5;
    char symbol6;
    char symbol7;
    char symbol8;
    char symbol9;
    String fruit1;
    String fruit2;
    String fruit3;
    String fruit4;
    String fruit5;
    String fruit6;
    String fruit7;
    String fruit8;
    String fruit9;
    String tempFruit;
    int combinationCounter;

    // Method to draw the slot machine when entering the casino:
    public void emptySlotMAchine(){
        System.out.println("              .------------.        ");
        System.out.println("           oO{ " + Colors.yellowBright() + "- PACANELE - " + Colors.reset() +" }Oo     ");
        System.out.println("            .=================.   ");
        System.out.println("            | [  ] [  ] [  ] |");
        System.out.println("            | [  ] [  ] [  ] |");
        System.out.println("            | [  ] [  ] [  ] |");
        System.out.println("            |  ::        ::  |   ");
        System.out.println("            |  " + Colors.blue()+"5 Euro /Spin"+Colors.reset()+"  |   ");
        System.out.println("            |_____/---__\\____|     ");
        System.out.println("           /##################\\   ");
        System.out.println("          |####################|  ");

    }

// Method to draw the slots machine using 9 characters:

    public void slotMachine(String fruit1, String fruit2, String fruit3, String fruit4, String fruit5, String fruit6, String fruit7, String fruit8, String fruit9){
        Sounds.playSound("slots");
        System.out.println("              .------------.        ");
        System.out.println("           oO{ " + Colors.yellowBright() + "- PACANELE - " + Colors.reset() +" }Oo     ");
        System.out.println("            .=================.   ");
        System.out.println("            | [" + fruit4 + "] [" + fruit5 + "] [" + fruit6 + "] |");
        System.out.println("            | [" + fruit1 + "] [" + fruit2 + "] [" + fruit3 + "] |");
        System.out.println("            | [" + fruit7 + "] [" + fruit8 + "] [" + fruit9 + "] |");
        System.out.println("            |  ::        ::  |   ");
        System.out.println("            |  " + Colors.blue()+"5 Euro /Spin"+Colors.reset()+"  |   ");
        System.out.println("            |_____/---__\\____|     ");
        System.out.println("           /##################\\   ");
        System.out.println("          |####################|  ");

    }

    // method to play slots
    public void playSlots (){
        do {
            fruitList.clear();
            combinationCounter = 0;
            System.out.println(" Press ENTER to spin, type \"EXIT\" to exit");
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("exit")){
                System.out.println("   Ok, you chose to exit, have a great day!");
            } else {
                // Spin the wheel and take money for every spin
                symbols=" ";
                if (Character.getCash() >=5){

                    //graphics:
                    Menu.clearScreen();
                    for (int i=1;i<10;i++){
                        int spin = random.nextInt(0,4);

                        if (option.contains("gimme")){
                            tempFruit = "\uD83C\uDF52";
                            tempSymbol = "0";
                        } else {
                            switch (spin) {
                                case 0:
                                    tempSymbol = "0";
                                    tempFruit = "\uD83C\uDF52";
                                    break;
                                case 1:
                                    tempSymbol = "1";
                                    tempFruit = "\uD83C\uDF4B";
                                    break;
                                case 2:
                                    tempSymbol = "2";
                                    tempFruit = "\uD83C\uDF4A";
                                    break;
                                case 3:
                                    tempSymbol = "3";
                                    tempFruit = "\uD83C\uDF4C";
                                    break;
                                case 4:
                                    tempSymbol = "4";
                                    tempFruit = "7\uFE0F⃣";
                                    break;
                            }
                        }
                        symbols = symbols.concat(tempSymbol);
                        fruitList.add(tempFruit);
                    }
                    fruit1 = fruitList.get(0);
                    fruit2 = fruitList.get(1);
                    fruit3 = fruitList.get(2);
                    fruit4 = fruitList.get(3);
                    fruit5 = fruitList.get(4);
                    fruit6 = fruitList.get(5);
                    fruit7 = fruitList.get(6);
                    fruit8 = fruitList.get(7);
                    fruit9 = fruitList.get(8);

                    slotMachine(fruit1, fruit2, fruit3, fruit4, fruit5, fruit6, fruit7, fruit8, fruit9);
                    System.out.println();
                    nrRotiri ++;

                    //win using the same symbol method:
                    symbol1 = symbols.charAt(1);
                    symbol2 = symbols.charAt(2);
                    symbol3 = symbols.charAt(3);
                    symbol4 = symbols.charAt(4);
                    symbol5 = symbols.charAt(5);
                    symbol6 = symbols.charAt(6);
                    symbol7 = symbols.charAt(7);
                    symbol8 = symbols.charAt(8);
                    symbol9 = symbols.charAt(9);

                    // check horizontals, then verticals then diagonals. For every good combination get one win point
                    if (symbol1==symbol2 && symbol1==symbol3) {
                        combinationCounter++;
                    }
                    if (symbol4==symbol5 && symbol4==symbol6) {
                        combinationCounter++;
                    }
                    if (symbol7==symbol8 && symbol7==symbol9) {
                        combinationCounter++;
                    }
                    if (symbol4==symbol1 && symbol1==symbol7) {
                        combinationCounter++;
                    }
                    if (symbol5==symbol2 && symbol2==symbol8) {
                        combinationCounter++;
                    }
                    if (symbol6==symbol3 && symbol9==symbol3) {
                        combinationCounter++;
                    }
                    if (symbol4==symbol2 && symbol4==symbol9) {
                        combinationCounter++;
                    }
                    if (symbol6==symbol2 && symbol2==symbol7) {
                        combinationCounter++;
                    }

                    // Jackpot:
                    if (symbol1==symbol2 && symbol2==symbol3 && symbol3==symbol4 && symbol4==symbol5 && symbol5==symbol6 && symbol6==symbol7 && symbol7==symbol8 && symbol8==symbol9){
                        combinationCounter = 100;
                    }

                    if (combinationCounter > 50) {
                        Sounds.playSound("jackpot");
                        System.out.print(Colors.green() +"JACKPOT!!! You won " + combinationCounter*15 + " Euro! " + Colors.reset());
                        castig50++;
                        Character.setCash(Character.getCash() + (combinationCounter*15));
                    } else

                    if (combinationCounter>0)
                    {
                        Sounds.playSound("cashreg");
                        System.out.print(Colors.green() +"    You won " + combinationCounter*15 + " Euro! " + Colors.reset());
                        castig50++;
                        Character.setCash(Character.getCash() + (combinationCounter*15));
                    }
                    else {
                        System.out.print(Colors.red() + "        Bad luck. " + Colors.reset());
                    }

                    Character.setCash(Character.getCash() -5);
                    System.out.println("Left cash: " + Character.getCash() + ".");

                } else {
                    // not enough money to spin
                    System.out.println(" Not enough cash to spin. Have a great day!");
                    System.out.println(" Press ENTER to continue...");
                    scanner.nextLine();
                    option = "exit";
                }
            }
        } while (!option.equalsIgnoreCase("exit"));
    }
}
