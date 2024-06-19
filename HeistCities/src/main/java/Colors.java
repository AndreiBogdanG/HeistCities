public class Colors {

// method to check if the system supports ansi code.
    public static boolean supportsAnsi() {
        return !(System.console() != null && System.getenv().get("TERM") != null);
    }

    //  Colors:

    public static String black(){
        String color;
        if (supportsAnsi()) {
            color = "\033[0;30m";   // Black
        }
            else{
                color = "";
            }
        return color;
    }

    public static String red(){
        String color;
        if (supportsAnsi()) {
            color = "\033[0;31m";   // Red;
        }
        else{
            color = "";
        }
        return color;
    }

    public static String green(){
        String color;
        if (supportsAnsi()) {
            color = "\033[0;32m";   // Green;
        }
        else{
            color = "";
        }
        return color;
    }

    public static String yellow(){
        String color;
        if (supportsAnsi()) {
            color = "\033[0;33m";   // Yellow;
        }
        else{
            color = "";
        }
        return color;
    }


    public static String blue(){
        String color;
        if (supportsAnsi()) {
            color = "\033[0;34m";   // Blue;
        }
        else{
            color = "";
        }
        return color;
    }

    public static String yellowBright(){
        String color;
        if (supportsAnsi()) {
            color = "\033[0;93m";   // Bright Yellow;
        }
        else{
            color = "";
        }
        return color;
    }

    // Reset colors:
    public static String reset(){
        String color;
        if (supportsAnsi()) {
            color = "\033[0m";   // Reset colors;
        }
        else{
            color = "";
        }
        return color;
    }
}









