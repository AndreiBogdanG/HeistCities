import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> pack = new ArrayList<>();
    ArrayList<String> discarded = new ArrayList<>();
    ArrayList<String> playerCards = new ArrayList<>();
    ArrayList<String> dealerCards = new ArrayList<>();
    Menu menu = new Menu();
    Random random = new Random();
    String card;
    String currentCard;
    String option;
    int cardIndex;
    int cardsSum;
    int dealersCardsSum;
    int bet;
    int numberOfAces;
    String value;
    String color;
    String firstCard;
    String secondCard;
    boolean playerWins;
    boolean stopGame;
    boolean placedBet;
    boolean isNumber;
    boolean cheat;

  // Method to take a new pack of cards:

    public void newPackOfCards() {
        // Numbers are from 2 to 9. Ace will be "A", ten will be "T", then J, Q, K. Colors are C, H, S, D.
        // (Clubs, Hearts, Spades, Diamonds). A 2 of clubs will be "2C", a Queen of Spades will be "QS".
        pack.clear();
        playerCards.clear();
        discarded.clear();
        dealerCards.clear();
        cardsSum = 0;
        dealersCardsSum = 0;
        playerWins = false;
        stopGame = false;
        numberOfAces = 0;
        pack.add("AC");
        pack.add("AH");
        pack.add("AS");
        pack.add("AD");

        for (int i = 2; i <= 9; i++) {
            card = i + "C";
            pack.add(card);
            card = i + "H";
            pack.add(card);
            card = i + "S";
            pack.add(card);
            card = i + "D";
            pack.add(card);
        }
        pack.add("TC");
        pack.add("TH");
        pack.add("TS");
        pack.add("TD");
        pack.add("JC");
        pack.add("JH");
        pack.add("JS");
        pack.add("JD");
        pack.add("QC");
        pack.add("QH");
        pack.add("QS");
        pack.add("QD");
        pack.add("KC");
        pack.add("KH");
        pack.add("KS");
        pack.add("KD");
    }

    // Method to deal one card from the pack:
    public String dealCard() {
        cardIndex = random.nextInt(0, pack.size() - 1);
        card = pack.get(cardIndex);
        pack.remove(cardIndex);
        discarded.add(card);
        playerCards.add(card);
        return card;
    }

  // Method to play blackjack:
    public void blackJHand() {

  // First card is dealt by default:

            Menu.clearScreen();
            if (cheat) {
                card = "KS";
                playerCards.add(card);
            } else {
                card = dealCard();
            }
            Sounds.playSound("shuffle");
            printDealersHand();
            System.out.println();
            printPlayersCards();

            switch (card.charAt(0)) {
                case 'A':
                    cardsSum += 11;
                    firstCard = "A";
                    numberOfAces++;
                    break;
                case '2', '3', '4', '5', '6', '7', '8', '9':
                    cardsSum += Integer.parseInt(String.valueOf(card.charAt(0)));
                    firstCard = "X";
                    break;

                case 'T', 'J', 'Q', 'K':
                    cardsSum += 10;
                    firstCard = "10";
                    break;
            }

            // Second card is also dealt by default:
            Menu.clearScreen();
        if (cheat) {
            card = "AS";
            playerCards.add(card);

        } else {
            card = dealCard();
        }
            printDealersHand();
            System.out.println();
            printPlayersCards();
            switch (card.charAt(0)) {
                case 'A':
                    cardsSum += 11;
                    secondCard = "A";
                    numberOfAces++;
                    break;
                case '2', '3', '4', '5', '6', '7', '8', '9':
                    cardsSum += Integer.parseInt(String.valueOf(card.charAt(0)));
                    secondCard = "X";
                    break;

                case 'T', 'J', 'Q', 'K':
                    cardsSum += 10;
                    secondCard = "10";
                    break;
            }

    // If first two cards are both aces or it's blackjack:
        if (cardsSum == 22) {
            System.out.println("You have 12");
        } else  if (cardsSum == 21) {

        } else {
                System.out.println(" You have " + cardsSum);
        }

        if (isItBlackjack()) {
            stopGame = true;
        } else {
            do {
                if (Menu.doYouWant("get another card")) {
                    Menu.clearScreen();
                    card = dealCard();
                    printDealersHand();
                    System.out.println();
                    printPlayersCards();

                    switch (card.charAt(0)) {
                        case 'A':
                                cardsSum += 11;
                            numberOfAces ++;
                            break;
                        case '2', '3', '4', '5', '6', '7', '8', '9':
                            cardsSum += Integer.parseInt(String.valueOf(card.charAt(0)));
                            break;

                        case 'T', 'J', 'Q', 'K':
                            cardsSum += 10;
                            break;
                    }
// cardsSum - check if bust:
                    cardsSum = isItBust();
                    if (cardsSum < 21) {
                        System.out.println(" You have " + cardsSum);
                    } else if (cardsSum == 21) {
                        System.out.println("You have 21!");
                        stopGame = true;
                    } else {

                        System.out.print("You have " + cardsSum + ". Bust! ");
                        stopGame = true;
                    }
                } else {
                    System.out.print("You stopped at " + cardsSum + ". ");
                    stopGame = true;
                }
            }
            while (!stopGame);
        }
            winner();
    }
    // Method to print multiple cards:
    public void printPlayersCards() {
        System.out.println("   YOUR CARDS:");
    // print first row of all the cards:
        for (int i = 1; i <= playerCards.size(); i++) {
            System.out.print(" ____    ");
        }
        System.out.println();
    // print second row of all the cards:
        for (int i = 1; i <= playerCards.size(); i++) {
            currentCard = playerCards.get(i - 1);
            // get the cards values - number and color - for each i variable, then print them:
            if (currentCard.charAt(0) == 'T') {
                value = "10";
            } else {
                value = String.valueOf(currentCard.charAt(0));
            }
            switch (currentCard.charAt(1)) {
                case 'C':
                    color = Colors.blue() + "♣" + Colors.reset();
                    break;
                case 'H':
                    color = Colors.red() + "♥" + Colors.reset();
                    break;
                case 'D':
                    color = Colors.red() + "♦" + Colors.reset();
                    break;
                case 'S':
                    color = Colors.blue() + "♠" + Colors.reset();
                    break;
            }

            if (Objects.equals(value, "10")) {
                System.out.print("|" + value + " " + color + "|   ");
            } else {
                System.out.print("|" + value + "  " + color + "|   ");
            }
        }
        System.out.println();

    // print third row of the cards:
        for (int i = 1; i <= playerCards.size(); i++) {
            System.out.print("|    |   ");
        }
        System.out.println();

    // print fourth row of the cards:
        for (int i = 1; i <= playerCards.size(); i++) {
            currentCard = playerCards.get(i - 1);
            // get the cards values - number and color - for each i variable, then print them:
            if (currentCard.charAt(0) == 'T') {
                value = "10";
            } else {
                value = String.valueOf(currentCard.charAt(0));
            }

            switch (currentCard.charAt(1)) {
                case 'C':
                    color = Colors.blue() + "♣" + Colors.reset();
                    break;
                case 'H':
                    color = Colors.red() + "♥" + Colors.reset();
                    break;
                case 'D':
                    color = Colors.red() + "♦" + Colors.reset();
                    break;
                case 'S':
                    color = Colors.blue() + "♠" + Colors.reset();
                    break;
            }

            if (Objects.equals(value, "10")) {
                System.out.print("|" + color + "_" + value + "|   ");
            } else {
                System.out.print("|" + color + "__" + value + "|   ");
            }
        }
        System.out.println();
    }

    // Method to deal all the cards for the dealer:
    public String dealDealerCard() {
        cardIndex = random.nextInt(0, pack.size() - 1);
        card = pack.get(cardIndex);
        pack.remove(cardIndex);
        discarded.add(card);
        dealerCards.add(card);
        return card;
    }

// Method for the dealer's game:
    public ArrayList<String> dealersGame() {
        boolean enough = false;
        dealersCardsSum = 0;
        do {
            currentCard = dealDealerCard();
            switch (currentCard.charAt(0)) {
                case 'A':
                    if (dealersCardsSum + 11 > 21) {
                        dealersCardsSum += 1;
                    } else {
                        dealersCardsSum += 11;
                    }
                    break;
                case '2', '3', '4', '5', '6', '7', '8', '9':
                    dealersCardsSum += Integer.parseInt(String.valueOf(card.charAt(0)));
                    break;

                case 'T', 'J', 'Q', 'K':
                    dealersCardsSum += 10;
                    break;
            }
            if (dealersCardsSum >= 17) {
                enough = true;
            }
        } while (!enough);
        return dealerCards;
    }
// Method to print dealer's hand:
    public void printDealersHand() {
        System.out.println("   DEALER'S HAND: ");
// print first row of all the cards:
        for (int i = 1; i <= dealerCards.size(); i++) {
            System.out.print(" ____    ");
        }
        System.out.println();
// print second row of all the cards:
        for (int i = 1; i <= dealerCards.size(); i++) {
            // if it's the first card, print it face down:
            if (i == 1) {
                System.out.print("|▓▓▓▓|   ");
            } else {

                currentCard = dealerCards.get(i - 1);
                // get the cards values - number and color - for each i variable, then print them:
                if (currentCard.charAt(0) == 'T') {
                    value = "10";
                } else {
                    value = String.valueOf(currentCard.charAt(0));
                }

                switch (currentCard.charAt(1)) {
                    case 'C':
                        color = Colors.blue() + "♣" + Colors.reset();
                        break;
                    case 'H':
                        color = Colors.red() + "♥" + Colors.reset();
                        break;
                    case 'D':
                        color = Colors.red() + "♦" + Colors.reset();
                        break;
                    case 'S':
                        color = Colors.blue() + "♠" + Colors.reset();
                        break;
                }

                if (Objects.equals(value, "10")) {
                    System.out.print("|" + value + " " + color + "|   ");
                } else {
                    System.out.print("|" + value + "  " + color + "|   ");
                }
            }
        }
        System.out.println();
// print third row of the cards:
        for (int i = 1; i <= dealerCards.size(); i++) {
            if (i == 1){
                System.out.print("|▓██▓|   ");
            } else {
                System.out.print("|    |   ");
            }
        }
        System.out.println();

// print fourth row of the cards:
        for (int i = 1; i <= dealerCards.size(); i++) {
            if (i == 1) {
                System.out.print("|▓▓▓▓|   ");
            } else {
                currentCard = dealerCards.get(i - 1);
                // get the cards values - number and color - for each i variable, then print them:
                if (currentCard.charAt(0) == 'T') {
                    value = "10";
                } else {
                    value = String.valueOf(currentCard.charAt(0));
                }
                switch (currentCard.charAt(1)) {
                    case 'C':
                        color = Colors.blue() + "♣" + Colors.reset();
                        break;
                    case 'H':
                        color = Colors.red() + "♥" + Colors.reset();
                        break;
                    case 'D':
                        color = Colors.red() + "♦" + Colors.reset();
                        break;
                    case 'S':
                        color = Colors.blue() + "♠" + Colors.reset();
                        break;
                }

                if (Objects.equals(value, "10")) {
                    System.out.print("|" + color + "_" + value + "|   ");
                } else {
                    System.out.print("|" + color + "__" + value + "|   ");
                }

            }
        }
        System.out.println();
    }

// Method to see the winner:
    public boolean winner() {
        // Blackjack:
        if (
                playerCards.size()==2 && (firstCard.equals("A") && secondCard.equals("10"))   ||
                playerCards.size()==2 && (firstCard.equals("10") && secondCard.equals("A"))
        ){
         //   blackjack; win is 2X bet
            playerWins = true;
            System.out.println("You won " + 2*bet);
            Sounds.playSound("yeah");
            Character.setCash(Character.getCash()+(2*bet));
        }
        // Not blackjack:

        if (cardsSum==21 && !playerWins){
                System.out.println("You won " + bet);
                Sounds.playSound("yeah");
                playerWins = true;
            Character.setCash(Character.getCash()+bet);
        } else if (cardsSum>21) {
            System.out.println("You lost " + bet);
            Sounds.playSound("lost");
            playerWins = false;
            Character.setCash(Character.getCash()-bet);
        }else if (dealersCardsSum > 21 && cardsSum<21) {
            System.out.println("You won!");
            Sounds.playSound("yeah");
            playerWins = true;
            Character.setCash(Character.getCash()+bet);
        } else if (dealersCardsSum>cardsSum && !playerWins){

            if (dealerCards.size()==2 && dealersCardsSum==21){
                System.out.println("Dealer wins with Blackjack!");
                Sounds.playSound("lost");
            } else {
                System.out.println("Dealer wins with " + dealersCardsSum);
                Sounds.playSound("lost");
            }
            playerWins = false;
            Character.setCash(Character.getCash()-bet);
        } else {
            if (!playerWins){
            System.out.println("You won!");
            Sounds.playSound("yeah");
            playerWins=true;
            Character.setCash(Character.getCash()+bet);}
        }
        return playerWins;
    }

// Method to check for blackjack:
    public boolean isItBlackjack(){
        if (
                playerCards.size()==2 && (firstCard.equals("A") && secondCard.equals("10"))   ||
                        playerCards.size()==2 && (firstCard.equals("10") && secondCard.equals("A"))
        ){
            if (cheat){
                System.out.println("You pull some cards from your sleeve and get Blackjack! ");
                cheat = false;
            } else {
                System.out.print("Blackjack! ");
            }
            playerWins = true;
        }
    return playerWins;
    }

 // Method to place the bets:
    public boolean placeBet(){
        if (Character.getCash() <= 0){
            Sounds.playSound("prost");
            System.out.println();
            System.out.println(Colors.red() + "You've got no money left."+ Colors.reset());

            System.out.println("Press ENTER to "+Colors.yellowBright()+"get your sorry ass out of here!" + Colors.reset());
            String option = scanner.nextLine();
            if (!option.contains("insist")) {
                placedBet = false;
                stopGame = true;
            } else {
                System.out.println("You find a 10 Euro bill on the ground. Press ENTER to play it on your next hand.");
                scanner.nextLine();
                Character.setCash(10);
                bet=10;
            }
        } else {
           do {
               do {
                   Menu.clearScreen();
                   Sounds.playSound("sume");
                   System.out.print("Place your bet (1 - " + Character.getCash() + "), or 0 to exit: ");
                   try {
                       option = scanner.nextLine();
                       if (option.startsWith("$")){
                           option = option.substring(1);
                           cheat=true;
                       }
                       bet = Integer.parseInt(option);
                       isNumber = true;
                       placedBet = true;

                   } catch (NumberFormatException nfe) {
                       isNumber = false;
                   }
               } while (!isNumber);

                if (bet==0 || bet>Character.getCash()){
                    placedBet=false;
                }

           } while (bet>Character.getCash());

        }
        return placedBet;
    }

// Method to check if really bust, calculating aces:

    public int isItBust (){
        if (cardsSum>21){
            switch (numberOfAces){
                case 0 :
                  //  cardsSum = += c
                    break;
                case 1:
                    cardsSum -=10;
                    numberOfAces =0;
                    break;
                case 2:
                    if (cardsSum - 10 <= 21){
                        cardsSum -=10;
                        numberOfAces = 0;
                    } else {
                        cardsSum -= 20;
                        numberOfAces -= 2;
                    }
                    break;
                case 3:
                    if (cardsSum - 10 <= 21){
                        cardsSum -=10;
                        numberOfAces = 0;
                    } else if (cardsSum - 20 <= 21){
                        cardsSum -= 20;
                        numberOfAces -= 2;
                    } else {
                        cardsSum -= 30;
                        numberOfAces -= 3;
                    }
                    break;
                case 4:
                    if (cardsSum - 10 <= 21){
                        cardsSum -=10;
                        numberOfAces  = 0;
                    } else if (cardsSum - 20 <= 21){
                        cardsSum -= 20;
                        numberOfAces -= 2;
                    } else if (cardsSum - 30 <= 21){
                        cardsSum -= 30;
                        numberOfAces -= 3;
                    } else {
                        cardsSum -= 40;
                        numberOfAces -= 4;
                    }
                    break;
            }
        }
        return cardsSum;
    }

// Method to make the blackjack intro and rules:
    public void blackjackIntro(){
        Menu.clearScreen();
        System.out.println();
        System.out.println(Colors.red() + " /" + Colors.yellowBright() +"$$$$$$$" + Colors.red() + "  /" + Colors.yellowBright() +"$$" + Colors.red() + "        /" + Colors.yellowBright() +"$$$$$$" + Colors.red() + "   /" + Colors.yellowBright() +"$$$$$$" + Colors.red() + "  /" + Colors.yellowBright() +"$$" + Colors.red() + "   /" + Colors.yellowBright() +"$$" + Colors.red() + "    /" + Colors.yellowBright() +"$$$$$" + Colors.red() + "  /" + Colors.yellowBright() +"$$$$$$" + Colors.red() + "   /" + Colors.yellowBright() +"$$$$$$" + Colors.red() + "  /" + Colors.yellowBright() +"$$" + Colors.red() + "   /" + Colors.yellowBright() +"$$" + Colors.red());
        System.out.println("| " + Colors.yellowBright() +"$$" + Colors.red() + "__  " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "       /" + Colors.yellowBright() +"$$" + Colors.red() + "__  " + Colors.yellowBright() +"$$" + Colors.red() + " /" + Colors.yellowBright() +"$$" + Colors.red() + "__  " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "  /" + Colors.yellowBright() +"$$" + Colors.red() + "/   |__  " + Colors.yellowBright() +"$$" + Colors.red() + " /" + Colors.yellowBright() +"$$" + Colors.red() + "__  " + Colors.yellowBright() +"$$" + Colors.red() + " /" + Colors.yellowBright() +"$$" + Colors.red() + "__  " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "  /" + Colors.yellowBright() +"$$" + Colors.red() + "/");
        System.out.println("| " + Colors.yellowBright() +"$$" + Colors.red() + "  \\ " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "      | " + Colors.yellowBright() +"$$" + Colors.red() + "  \\ " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "  \\__/| " + Colors.yellowBright() +"$$" + Colors.red() + " /" + Colors.yellowBright() +"$$" + Colors.red() + "/       | " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "  \\ " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "  \\__/| " + Colors.yellowBright() +"$$" + Colors.red() + " /" + Colors.yellowBright() +"$$" + Colors.red() + "/");
        System.out.println("| " + Colors.yellowBright() +"$$$$$$$" + Colors.red() + " | " + Colors.yellowBright() +"$$" + Colors.red() + "      | " + Colors.yellowBright() +"$$$$$$$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "      | " + Colors.yellowBright() +"$$$$$" + Colors.red() + "/        | " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$$$$$$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "      | " + Colors.yellowBright() +"$$$$$" + Colors.red() + "/");
        System.out.println("| " + Colors.yellowBright() +"$$" + Colors.red() + "__  " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "      | " + Colors.yellowBright() +"$$" + Colors.red() + "__  " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "      | " + Colors.yellowBright() +"$$" + Colors.red() + "  " + Colors.yellowBright() +"$$" + Colors.red() + "   /" + Colors.yellowBright() +"$$" + Colors.red() + "  | " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "__  " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "      | " + Colors.yellowBright() +"$$  $$" + Colors.red());
        System.out.println("| " + Colors.yellowBright() +"$$" + Colors.red() + "  \\ " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "      | " + Colors.yellowBright() +"$$" + Colors.red() + "  | " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$    $$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "\\  " + Colors.yellowBright() +"$$" + Colors.red() + " | " + Colors.yellowBright() +"$$" + Colors.red() + "  | " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "  | " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "    " + Colors.yellowBright() +"$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "\\  " + Colors.yellowBright() +"$$" + Colors.red());
        System.out.println("| " + Colors.yellowBright() +"$$$$$$$" + Colors.red() + "/| " + Colors.yellowBright() +"$$$$$$$$" + Colors.red() + "| " + Colors.yellowBright() +"$$" + Colors.red() + "  | " + Colors.yellowBright() +"$$" + Colors.red() + "|  " + Colors.yellowBright() +"$$$$$$" + Colors.red() + "/| " + Colors.yellowBright() +"$$" + Colors.red() + " \\  " + Colors.yellowBright() +"$$" + Colors.red() + "|  " + Colors.yellowBright() +"$$$$$$" + Colors.red() + "/| " + Colors.yellowBright() +"$$" + Colors.red() + "  | " + Colors.yellowBright() +"$$" + Colors.red() + "|  " + Colors.yellowBright() +"$$$$$$" + Colors.red() + "/| " + Colors.yellowBright() +"$$" + Colors.red() + " \\  " + Colors.yellowBright() +"$$" + Colors.red());
        System.out.println("|_______/ |________/|__/  |__/ \\______/ |__/  \\__/ \\______/ |__/  |__/ \\______/ |__/  \\__/");

        System.out.println();
        System.out.println(Colors.yellowBright() + "Objective:"+ Colors.reset() + " Beat the dealer's hand without exceeding 21. The game is played with standard decks of cards.You start by placing a bet before each hand.");
        System.out.println(Colors.yellowBright() + "Dealing Cards: "+ Colors.reset() + "Both you and the dealer are dealt two cards each. One of the dealer’s cards remains face down until the dealer reveals their hand.");
        System.out.println(Colors.yellowBright() + "Player's Turn:"+ Colors.reset() + " You can choose to \"Hit\" (draw a card) as many times as you like. If your hand exceeds 21, you bust and lose the bet immediately. If you choose to \"Stand\" (stop drawing cards), your turn ends.");
        System.out.println(Colors.yellowBright() + "Dealer's Turn:"+ Colors.reset() + " The dealer reveals their face-down card. The dealer must draw cards until their total is at least 17. The dealer stands on all totals of 17 or higher.");
        System.out.println(Colors.yellowBright() + "Winning the Hand:"+ Colors.reset() +" If you stand without busting and your total is higher than the dealer's or the dealer busts, you win the bet. If you get exactly 21 with your initial two cards (blackjack), you win twice your bet. If the dealer's hand is higher than yours without busting, you lose the bet.");
        System.out.println("There are no options to double down or split pairs in this game variant.");
        System.out.println(Colors.yellowBright() + "Enjoy the game and may the odds be in your favor!"+ Colors.reset());
        System.out.println();
        System.out.println("Press ENTER to begin game...");
        scanner.nextLine();
    }
}