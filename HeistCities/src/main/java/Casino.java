import java.util.Scanner;

public class Casino {
    Character character = new Character();
    Scanner scanner = new Scanner(System.in);
    String option;

    public String enterCasino(){
        Menu.clearScreen();
        System.out.println(Colors.green() + "                WELCOME TO " + character.getCity().toUpperCase() + "'S FINEST " + Colors.reset());
        System.out.println();
        System.out.println(Colors.red() + "  /" + Colors.yellowBright() + "$$$$$$" + Colors.red() + "    /" + Colors.yellowBright() + "$$$$$$" + Colors.red() + "    /" + Colors.yellowBright() + "$$$$$$" + Colors.red() + "   /" + Colors.yellowBright() + "$$$$$$" + Colors.red() + "  /" + Colors.yellowBright() + "$$" + Colors.red() + "   /" + Colors.yellowBright() + "$$" + Colors.red() + "   /" + Colors.yellowBright() + "$$$$$$" + Colors.red() );
        System.out.println(" /" + Colors.yellowBright() + "$$" + Colors.red() + "__" + Colors.yellowBright() +"  $$" + Colors.red() + "  /" + Colors.yellowBright() + "$$" + Colors.red() + "__  " + Colors.yellowBright() + "$$" + Colors.red() + "  /" + Colors.yellowBright() + "$$" + Colors.red() + "__  " + Colors.yellowBright() + "$$" + Colors.red() + " |_  " + Colors.yellowBright() + "$$" + Colors.red() + "_/ | " + Colors.yellowBright() + "$$$" + Colors.red() + " | " + Colors.yellowBright() + "$$  /" + Colors.yellowBright() + "$$__  " + Colors.yellowBright() + "$$" + Colors.red());
        System.out.println("|" + Colors.yellowBright() + " $$" + Colors.red() + "  \\__/ | " + Colors.yellowBright() + "$$" + Colors.red() + "  \\ " + Colors.yellowBright() + "$$" + Colors.red() + " | " + Colors.yellowBright() + "$$" + Colors.red() + "  \\__/   | " + Colors.yellowBright() + "$$" + Colors.red() + "   | " + Colors.yellowBright() + "$$$$" + Colors.red() + "| " + Colors.yellowBright() + "$$" + Colors.red() + " | " + Colors.yellowBright() + "$$" + Colors.red() + "  \\ " + Colors.yellowBright() + "$$" + Colors.red());
        System.out.println("|" + Colors.yellowBright() + " $$" + Colors.red() + "       | " + Colors.yellowBright() + "$$$$$$$$" + Colors.red() + " |  " + Colors.yellowBright() + "$$$$$$" + Colors.red() + "    | " + Colors.yellowBright() + "$$" + Colors.red() + "   | " + Colors.yellowBright() + "$$ $$ $$" + Colors.red() + " | " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$" + Colors.red() );
        System.out.println("|" + Colors.yellowBright() + " $$" + Colors.red() + "       | " + Colors.yellowBright() + "$$" + Colors.red() + "__  " + Colors.yellowBright() + "$$" + Colors.red() + "  \\____  " + Colors.yellowBright() + "$$" + Colors.red() + "   | " + Colors.yellowBright() + "$$" + Colors.red() + "   | " + Colors.yellowBright() + "$$  $$$$" + Colors.red() + " | " + Colors.yellowBright() + "$$  | " + Colors.yellowBright() + "$$" + Colors.red() );
        System.out.println("|" + Colors.yellowBright() + " $$    $$" + Colors.red() + " | " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$" + Colors.red() + "  /" + Colors.yellowBright() + "$$" + Colors.red() + "  \\ " + Colors.yellowBright() + "$$" + Colors.red() + "   | " + Colors.yellowBright() + "$$" + Colors.red() + "   | " + Colors.yellowBright() + "$$" + Colors.red() + "\\  " + Colors.yellowBright() + "$$$" + Colors.red() + " | " + Colors.yellowBright() + "$$  | " + Colors.yellowBright() + "$$" + Colors.red());
        System.out.println("|" + Colors.yellowBright() + "  $$$$$$" + Colors.red() + "/ | " + Colors.yellowBright() + "$$" + Colors.red() + "  | " + Colors.yellowBright() + "$$" + Colors.red() + " |  " + Colors.yellowBright() + "$$$$$$" + Colors.red() + "/  /" + Colors.yellowBright() + "$$$$$$" + Colors.red() + " | " + Colors.yellowBright() + "$$" + Colors.red() + " \\  " + Colors.yellowBright() + "$$" + Colors.red() + " |  " + Colors.yellowBright() + "$$$$$$" + Colors.red() + "/");
        System.out.println(" \\______/  |__/  |__/  \\______/  |______/ |__/  \\__/  \\______/");
        System.out.println();
        System.out.println(Colors.red() + "              What " + Colors.yellowBright() + "game" + Colors.red() +" are you up for today?");
        System.out.println(Colors.yellowBright() + "                       1. " + Colors.red() +"Blackjack");
        System.out.println(Colors.yellowBright() + "                       2. " + Colors.red() +"Slots");
        System.out.println(Colors.yellowBright() + "                       3. " + Colors.red() +"Bingo" + Colors.green());
        System.out.println(Colors.yellowBright() + "                       0. " + Colors.red() +"EXIT" + Colors.green());
        System.out.print(                        "                          - " + Colors.reset());

        do {
          option = scanner.nextLine();
        } while (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("0"));
        Menu.clearScreen();
        return option;
    }
}
