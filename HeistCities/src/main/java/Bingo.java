import java.util.*;

public class Bingo {
    Random random = new Random();
    Character character = new Character();
    Menu menu = new Menu();
    int number;
    String color;
    HashMap<Integer, Boolean> extracted = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    String option;
    ArrayList<Integer> ticketNumbers = new ArrayList<>();
    ArrayList<Integer> finalTicketNumbers = new ArrayList<>();
    ArrayList<Integer> listOf30Numbers = new ArrayList<>();
    ArrayList<Integer> extractedNumbers = new ArrayList<>();
    ArrayList<Integer> lista = get30Numbers();       // list of the 15 numbers for the ticket
    ArrayList<String> no1_30 = new ArrayList<>();
    String no1;
    String no2;
    String no3;
    String no4;
    String no5;
    String no6;
    String no7;
    String no8;
    String no9;
    String no10;
    String no11;
    String no12;
    String no13;
    String no14;
    String no15;
    String no16;
    String no17;
    String no18;
    String no19;
    String no20;
    String no21;
    String no22;
    String no23;
    String no24;
    String no25;
    String no26;
    String no27;
    String no28;
    String no29;
    String no30;

// Method to randomly get 3 numbers for the Bingo card, from a specified range:
    // also add them to the final ticket numbers list
    public ArrayList<Integer> getThreeNumbers(int start, int end) {
        ticketNumbers.clear();
        for (int i = 1; i <= 3; i++) {
            do {
                number = random.nextInt(start, end);
            } while (ticketNumbers.contains(number));
                ticketNumbers.add(number);
            finalTicketNumbers.add(number);
        }
      return ticketNumbers;
    }

 // Method to check if extracted and prepare the colored String:

    public String checkNumber(int number){
        if (extracted.get(number)){

            color = Colors.yellowBright();
        } else {
            color = Colors.green();
        }
        return color;
    }

  // Method to print two Bingo card:

    public void printTWOCards(){

        if(lista.get(0)<10){
          no1 = checkNumber(lista.getFirst()) + lista.getFirst().toString() +" " + Colors.reset();
        }
        if(lista.get(1)<10){
            no2 =checkNumber(lista.get(1)) + lista.get(1).toString()+" "+ Colors.reset();
        }
        if(lista.get(2)<10){
            no3 = checkNumber(lista.get(2)) + lista.get(2).toString()+" "+ Colors.reset();
        }

        no4 = checkNumber(lista.get(3))+ lista.get(3).toString()+ Colors.reset();
        no5 = checkNumber(lista.get(4)) + lista.get(4).toString()+ Colors.reset();
        no6 = checkNumber(lista.get(5)) + lista.get(5).toString()+ Colors.reset();
        no7 = checkNumber(lista.get(6)) + lista.get(6).toString()+ Colors.reset();
        no8 = checkNumber(lista.get(7)) + lista.get(7).toString()+ Colors.reset();
        no9 = checkNumber(lista.get(8)) + lista.get(8).toString()+ Colors.reset();
        no10 = checkNumber(lista.get(9)) + lista.get(9).toString()+ Colors.reset();
        no11 = checkNumber(lista.get(10)) + lista.get(10).toString()+ Colors.reset();
        no12 = checkNumber(lista.get(11)) + lista.get(11).toString()+ Colors.reset();
        no13 = checkNumber(lista.get(12)) + lista.get(12).toString()+ Colors.reset();
        no14 = checkNumber(lista.get(13)) + lista.get(13).toString()+ Colors.reset();
        no15 = checkNumber(lista.get(14)) + lista.get(14).toString()+ Colors.reset();

        if(lista.get(15)<10){
            no16 = checkNumber(lista.get(15)) + lista.get(15).toString() +" " + Colors.reset();
        }
        if(lista.get(16)<10){
            no17 =checkNumber(lista.get(16)) + lista.get(16).toString()+" "+ Colors.reset();
        }
        if(lista.get(17)<10){
            no18 = checkNumber(lista.get(17)) + lista.get(17).toString()+" "+ Colors.reset();
        }

        no19 = checkNumber(lista.get(18)) + lista.get(18).toString()+ Colors.reset();
        no20 = checkNumber(lista.get(19)) + lista.get(19).toString()+ Colors.reset();
        no21 = checkNumber(lista.get(20)) + lista.get(20).toString()+ Colors.reset();
        no22 = checkNumber(lista.get(21)) + lista.get(21).toString()+ Colors.reset();
        no23 = checkNumber(lista.get(22)) + lista.get(22).toString()+ Colors.reset();
        no24 = checkNumber(lista.get(23)) + lista.get(23).toString()+ Colors.reset();
        no25 = checkNumber(lista.get(24)) + lista.get(24).toString()+ Colors.reset();
        no26 = checkNumber(lista.get(25)) + lista.get(25).toString()+ Colors.reset();
        no27 = checkNumber(lista.get(26)) + lista.get(26).toString()+ Colors.reset();
        no28 = checkNumber(lista.get(27)) + lista.get(27).toString()+ Colors.reset();
        no29 = checkNumber(lista.get(28)) + lista.get(28).toString()+ Colors.reset();
        no30 = checkNumber(lista.get(29)) + lista.get(29).toString()+ Colors.reset();
        Menu.clearScreen();
        System.out.println("         " + character.getName()+"                                Another player"           );
        System.out.println(" ________________________                  ________________________");
        System.out.println("| " + no1 + " | " + no4 + " | " + no7 + " | " + no10 + " | " + no13 + " |                | " + no16 + " | " + no19 + " | " + no22 + " | " + no25 + " | " + no28 + " |");
        System.out.println("|----|----|----|----|----|                |----|----|----|----|----|");
        System.out.println("| " + no2 + " | " + no5 + " | " + no8 + " | " + no11 + " | " + no14 + " |                | " + no17 + " | " + no20 + " | " + no23 + " | " + no26 + " | " + no29 + " |");
        System.out.println("|----|----|----|----|----|                |----|----|----|----|----|");
        System.out.println("| " + no3 + " | " + no6 + " | " + no9 + " | " + no12 + " | " + no15 + " |                | " + no18 + " | " + no21 + " | " + no24 + " | " + no27 + " | " + no30 + " |");
        System.out.println("|__ _|____|____|____|____|                |__ _|____|____|____|____|");
    }

// Method to make a big list from all the small 3 numbers list:
    public ArrayList<Integer> get30Numbers(){

        lista = getThreeNumbers(1,10);
        for (int i=0; i<=2; i++){ listOf30Numbers.add(lista.get(i));}
        lista = getThreeNumbers(11,20);
        for (int i=0; i<=2; i++){ listOf30Numbers.add(lista.get(i));}
        lista = getThreeNumbers(21,30);
        for (int i=0; i<=2; i++){ listOf30Numbers.add(lista.get(i));}
        lista = getThreeNumbers(31,40);
        for (int i=0; i<=2; i++){ listOf30Numbers.add(lista.get(i));}
        lista = getThreeNumbers(41,50);
        for (int i=0; i<=2; i++){ listOf30Numbers.add(lista.get(i));}

        lista = getThreeNumbers(1,10);
        for (int i=0; i<=2; i++){ listOf30Numbers.add(lista.get(i));}
        lista = getThreeNumbers(11,20);
        for (int i=0; i<=2; i++){ listOf30Numbers.add(lista.get(i));}
        lista = getThreeNumbers(21,30);
        for (int i=0; i<=2; i++){ listOf30Numbers.add(lista.get(i));}
        lista = getThreeNumbers(31,40);
        for (int i=0; i<=2; i++){ listOf30Numbers.add(lista.get(i));}
        lista = getThreeNumbers(41,50);
        for (int i=0; i<=2; i++){ listOf30Numbers.add(lista.get(i));}
        return listOf30Numbers;
    }

// Method to extract random numbers from 1 to 50 and put them in an extractedNumbers list:
    public void extractNumbers() {

        // Make all 50 numbers in the extracted map false:
        for (int i=1;i<=50; i++){
            extracted.put(i,false);
        }

        // Pay for the ticket:
        Character.setCash(Character.getCash()-100);

        int extractedNo;
        do {
            System.out.println("Press ENTER to draw a number, type 'exit' to exit.");
            option = scanner.nextLine();
            System.out.println();
            System.out.println("PLEASE WAIT... ");
            Sounds.playSound("slots");
            if (!option.equalsIgnoreCase("exit")) {
                do {
                    extractedNo = random.nextInt(1, 50);
                } while (extractedNumbers.contains(extractedNo));

                extractedNumbers.add(extractedNo);
                extracted.put(extractedNo, true);
                printTWOCards();
                System.out.println("Extracted number: " + extractedNo);
                System.out.println(extractedNumbers);
               if( win()){
                   break;
               }
            }
        } while (!option.equalsIgnoreCase("exit"));
    }

    // Method to check for winnings:
        public boolean win(){
        int player1lines=0;
        int player2lines=0;
        boolean winningLine1;
        boolean winningLine2;
        boolean winningLine3;
        boolean winningLine4;
        boolean winningLine5;
        boolean winningLine6;
        boolean gameOver = false;

        winningLine1 = extracted.get(lista.get(0)) && extracted.get(lista.get(3)) && extracted.get(lista.get(6)) && extracted.get(lista.get(9)) && extracted.get(lista.get(12));
        winningLine2 = extracted.get(lista.get(1)) && extracted.get(lista.get(4)) && extracted.get(lista.get(7)) && extracted.get(lista.get(10)) && extracted.get(lista.get(13));
        winningLine3 = extracted.get(lista.get(2)) && extracted.get(lista.get(5)) && extracted.get(lista.get(8)) && extracted.get(lista.get(11)) && extracted.get(lista.get(14));
        winningLine4 = extracted.get(lista.get(15)) && extracted.get(lista.get(18)) && extracted.get(lista.get(21)) && extracted.get(lista.get(24)) && extracted.get(lista.get(27));
        winningLine5 = extracted.get(lista.get(16)) && extracted.get(lista.get(19)) && extracted.get(lista.get(22)) && extracted.get(lista.get(25)) && extracted.get(lista.get(28));
        winningLine6 = extracted.get(lista.get(17)) && extracted.get(lista.get(20)) && extracted.get(lista.get(23)) && extracted.get(lista.get(26)) && extracted.get(lista.get(29));

        if (winningLine1){
            player1lines++;

        }
        if (winningLine2){
            player1lines++;

        }
        if (winningLine3){
            player1lines++;

        }
        if (winningLine4){
            player2lines++;

        }
        if (winningLine5){
            player2lines++;
        }
        if (winningLine6){
            player2lines++;
        }

        if (player1lines==1 && player2lines<1){
            System.out.println(character.getName() + " has one line and won 100 Euro!");
            // Get 100 Euro for a line:
            Character.setCash(Character.getCash()+100);
        }
        if (player1lines==2 && player2lines < 2){
            System.out.println(character.getName() + " has two lines and won 500 Euro!");
            // Get 500 Euro for two lines:
            Character.setCash(Character.getCash()+500);
        }
        if (player1lines==3 && player2lines<3){
            System.out.println(character.getName() + " called BINGO! He won 1000 Euro! Game over!");
            // Get 1000 Euro for Bingo:
            Character.setCash(Character.getCash()+1000);
            gameOver=true;
            System.out.println("Press ENTER to exit...");
            scanner.nextLine();
        }
        if (player2lines==1 && player1lines<1){
            Sounds.playSound("applause");
            System.out.println("Other player has one line and won 100 Euro!");
        }
        if (player2lines==2 && player1lines<2){
            System.out.println("Other player has two lines and won 500 Euro!");
        }
        if (player2lines==3 && player1lines<3){
            System.out.println("Other player called BINGO! He won 1000 Euro! Game over!");
            System.out.println("Press ENTER to exit...");
            scanner.nextLine();
            gameOver=true;
        }
return gameOver;
    }

// Method to print the Bingo intro:

    public void bingoIntro(){
        Menu.clearScreen();
        System.out.println("                   WELCOME TO");
        System.out.println();
        System.out.println(Colors.red() + " /" + Colors.yellowBright() + "$$$$$$$" + Colors.red() + "  /" + Colors.yellowBright() + "$$$$$$" + Colors.red() + " /" + Colors.yellowBright() + "$$" + Colors.red() + "   /" + Colors.yellowBright() + "$$" + Colors.red() + "  /" + Colors.yellowBright() + "$$$$$$" + Colors.red() + "   /" + Colors.yellowBright() + "$$$$$$" + Colors.red() + "");
        System.out.println("| " + Colors.yellowBright() + "$$" + Colors.red() + "__  " + Colors.yellowBright() + "$$" + Colors.red() + "|_  " + Colors.yellowBright() + "$$" + Colors.red() + "_/| " + Colors.yellowBright() + "$$$" + Colors.red() + " | " + Colors.yellowBright() + "$$" + Colors.red() + " /" + Colors.yellowBright() + "$$" + Colors.red() + "__  " + Colors.yellowBright() + "$$" + Colors.red() + " /" + Colors.yellowBright() + "$$" + Colors.red() + "__  " + Colors.yellowBright() + "$$" + Colors.red() + "");
        System.out.println("| " + Colors.yellowBright() + "$$" + Colors.red() + "  \\ " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$$$" + Colors.red() + "| " + Colors.yellowBright() + "$$" + Colors.red() + "| " + Colors.yellowBright() + "$$" + Colors.red() + "  \\__/| " + Colors.yellowBright() + "$$" + Colors.red() + "  \\ " + Colors.yellowBright() + "$$" + Colors.red() + "");
        System.out.println("| " + Colors.yellowBright() + "$$$$$$$" + Colors.red() + "   | " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$ $$ $$" + Colors.red() + "| " + Colors.yellowBright() + "$$" + Colors.red() + " /" + Colors.yellowBright() + "$$$$" + Colors.red() + "| " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$" + Colors.red() + "");
        System.out.println("| " + Colors.yellowBright() + "$$" + Colors.red() + "__  " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$  $$$$" + Colors.red() + "| " + Colors.yellowBright() + "$$" + Colors.red() + "|_  " + Colors.yellowBright() + "$$" + Colors.red() + "| " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$" + Colors.red() + "");
        System.out.println("| " + Colors.yellowBright() + "$$" + Colors.red() + "  \\ " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$" + Colors.red() + "\\  " + Colors.yellowBright() + "$$$" + Colors.red() + "| " + Colors.yellowBright() + "$$" + Colors.red() + "  \\ " + Colors.yellowBright() + "$$" + Colors.red() + "| " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$" + Colors.red() + "");
        System.out.println("| " + Colors.yellowBright() + "$$$$$$$" + Colors.red() + "/ /" + Colors.yellowBright() + "$$$$$$" + Colors.red() + "| " + Colors.yellowBright() + "$$" + Colors.red() + " \\  " + Colors.yellowBright() + "$$" + Colors.red() + "|  " + Colors.yellowBright() + "$$$$$$" + Colors.red() + "/|  " + Colors.yellowBright() + "$$$$$$" + Colors.red() + "/");
        System.out.println("|_______/ |______/|__/  \\__/ \\______/  \\______/" + Colors.reset());
        System.out.println();
        System.out.println(Colors.green() + "            Ticket price is 100 Euro.");
        System.out.println("One line wins 100, tho lines win 500, Bingo wins 1000." + Colors.reset());
    }
}
