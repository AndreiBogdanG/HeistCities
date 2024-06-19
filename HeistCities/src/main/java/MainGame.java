
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        Files files = new Files();
        Blackjack blackjack = new Blackjack();
        Merchandise merchandise = new Merchandise();
        Bingo bingo = new Bingo();
        Slots slots = new Slots();
        Casino casino = new Casino();
        Inventory inventory = new Inventory();
        Character character = new Character();
        Scanner scanner = new Scanner(System.in);
        String option;
        City city = new City();
        Bank bank = new Bank();
        Menu menu = new Menu();
        files.readMerch();
        merchandise.initializeMerch();
        inventory.createInventory();
        Sounds.playSound("mafia");
        AnsiSupportChecker.enableAnsiSupportOnWindows();
        character.initCharacter();
        option = menu.cityMenu();

      do {
          switch (option) {
              case "0":
                  option = menu.cityMenu();
                  break;

              case "1":
                  if (Merchandise.justStolen) {
                      System.out.println();
                      System.out.println("Can't go to this market, it's full of cops!");
                      System.out.println("Press ENTER to continue...");
                      scanner.nextLine();
                      option = "0";
                      break;
                  } else {
                      Sounds.playSound("market");
                      option = menu.marketMenu();
                      switch (option) {
                          case "1":
                              merchandise.buyItem();
                              break;
                          case "2":
                              merchandise.sellItem();
                              option = "1";
                              break;
                          case "3":
                              merchandise.printMerch(merchandise.currentMerch);
                              option = "1";
                              System.out.println("Press ENTER to continue...");
                              scanner.nextLine();
                              break;
                          case "4":
                              System.out.println();
                              merchandise.stealFromMarket();
                              option = "0";
                              System.out.println("Press ENTER to continue...");
                              scanner.nextLine();
                              break;
                          case "5":
                              option = "0";
                              break;
                      }
                      break;
                  }

              case "2":
                  Menu.clearScreen();
                  if (Bank.justRobbed) {
                      System.out.println("Can't go to this bank... Police investigation in progress.");
                      System.out.println("Press ENTER to continue...");
                      scanner.nextLine();
                      option = "0";
                      break;
                  } else {

                      option = menu.bankMenu();
                      switch (option) {
                          case "1":
                              bank.deposit();
                              option = "2";
                              break;
                          case "2":
                              bank.withdraw();
                              option = "2";
                              break;
                          case "3":
                              System.out.println("You currently have " + bank.getBankAccount() + " Euro in your bank account.");
                              option = "2";
                              System.out.println("Press ENTER to continue...");
                              scanner.nextLine();
                              break;
                          case "4":
                              System.out.println();
                              System.out.println("You currently have " + Character.getCash() + " Euro in your pockets.");
                              option = "2";
                              System.out.println("Press ENTER to continue...");
                              scanner.nextLine();
                              break;
                          case "5":
                              System.out.println();
                              if (Bank.justRobbed) {
                                  System.out.println("Too soon to retake your chances at this bank... Give it some time...");
                                  option = "0";
                                  System.out.println("Press ENTER to continue...");
                                  scanner.nextLine();
                                  break;
                              } else {
                                  if (bank.robBank() > 0){
                                  option = "0";
                                  System.out.println("Press ENTER to continue...");
                                  scanner.nextLine();

                                  } else {
                                      option = "0";
                                      System.out.println("Press ENTER to continue...");
                                      scanner.nextLine();
                                  }
                                  break;
                              }
                          case "6":
                              option = "0";
                              break;
                      }
                      break;
                  }
// CHEAT: put $ in front of the option to enter the Casino with empty pockets:
              case "$3":
                  System.out.println("Press ENTER to borrow 10 lousy Euro and enter the Casino.");
                  scanner.nextLine();
                  Character.setCash(10);
              case "3":
                  Menu.clearScreen();
                  // Check if you have any money:
                  if (Character.getCash() == 0) {
                      Sounds.playSound("stai");
                      System.out.println(Colors.red() + "Can't enter the Casino with empty pockets!" + Colors.reset());
                      System.out.println("Press ENTER and " + Colors.yellowBright() + "get outta here!");
                      scanner.nextLine();
                          option = "0";
                          break;
                  } else {
                      // if money > 0 -> enter the Casino:

                      Sounds.playSound("lasvegas");
                      option = casino.enterCasino();

                      if (option.equals("2")) {
                          if (Character.getCash() >= 5) {
                              slots.emptySlotMAchine();
                              slots.playSlots();
                              option = "0";
                              break;
                          } else {
                              System.out.println("You don't have 5 Euro for a spin! Get out of here!");
                              System.out.println("Press ENTER to continue...");
                              scanner.nextLine();
                              option = "0";
                              break;
                          }
                      } else if (option.equals("3")) {
                          bingo.bingoIntro();
                          if (Character.getCash() >= 100) {
                              bingo.extractNumbers();
                              option = "0";
                              break;
                          } else {
                              System.out.println("Not enough cash to play, get out!");
                              System.out.println("Press ENTER to continue...");
                              scanner.nextLine();
                              option = "0";
                              break;
                          }
                      } else if (option.equals("1")) {
                          blackjack.blackjackIntro();
                          do {
                              if (blackjack.placeBet()) {
                                  blackjack.newPackOfCards();
                                  blackjack.dealersGame();
                                  blackjack.blackJHand();
                                  System.out.println("Press ENTER...");
                                  scanner.nextLine();
                              } else {
                                  break;
                              }
                          } while (blackjack.bet != 0 || Character.getCash() != 0);
                          option = "0";
                          break;
                      } else if (option.equals("0")){
                          option = "0";
                          break;
                      }
                  }
              case "4":
                  Menu.clearScreen();
                  inventory.showInventory();
                  option = "0";
                  System.out.println("Press ENTER to continue...");
                  scanner.nextLine();
                  break;
              case "5":
                  if (Character.getDays() < Character.getMaxDays() - 1) {
                      System.out.println();
                      System.out.println("You chose to leave " + City.getCity()

                      );
                      character.setCity(city.goToCity());
                      merchandise.modifyAllPrices();
                      option = "0";
                  } else {
                      System.out.println("Can't leave, this is your last day...");
                      System.out.println("Press ENTER to continue...");
                      scanner.nextLine();
                      option = "0";
                  }
                  break;
              case "x", "X":
                  System.out.println();
                  if (Character.getDays() == Character.getMaxDays() - 1) {
                      Menu.clearScreen();
                      System.out.println("Well, nothing lasts forever... But at least it was fun.");
                      System.out.println("At the end of these " + (Character.getMaxDays() - 1) + " days, your total dough is " + (Character.getCash() + bank.getCash()) + " Euro.");
                      System.out.println();
                      System.out.println("See you at my next game!");
                      System.exit(0);
                  }
                  if (Menu.areYouSure("you wanna exit the game")) {
                      System.out.println();
                      System.out.println("You lasted for " + Character.getDays() + " days. You started with " + Character.getStartingCash() + " Euro and finished with " + (Character.getCash() + bank.getCash()) + " Euro.");
                      menu.theEnd();
                      System.exit(0);
                  } else {
                      option = "0";
                      break;
                  }
          }
      } while (bank.getBankAccount() + Character.getCash()  <= 1000000);
        menu.theEnd();
        System.exit(0);
    }
}
