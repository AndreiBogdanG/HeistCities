import java.util.Random;

public class Actions {
   Random random = new Random();

//Method to check probability to succeed in something; the percent of chance will be given;
    public boolean doYouFeelLuckyToday(int percent) {
        boolean myLuck;
        int rndNumber;
        rndNumber = random.nextInt(0, 100);
        myLuck= rndNumber <= percent;
        return myLuck;
    }
}
