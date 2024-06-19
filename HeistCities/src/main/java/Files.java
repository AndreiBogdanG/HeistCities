import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;

public class Files {

    LinkedHashMap<String, String> cities = new LinkedHashMap<>();
    LinkedHashMap<String, Integer> merch = new LinkedHashMap<>();

// Method to read the places file and put it all in LinkedHashMaps:
    public LinkedHashMap<String,String> readCities() {
        List<String> placeList;

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Places1.txt")) {
            if (inputStream == null) {
                System.out.println("Could not find the file Places.txt");
                System.out.println("Can't play the game without it!");
                System.exit(0);
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    placeList = List.of(line.split(";"));
                    cities.put(placeList.get(1), placeList.getLast());
                }
            }

        } catch (IOException e) {
            System.out.println("Could not find the file \"Places.txt\" :(");
            System.out.println("Sorry, can't play the game without it.");
            System.exit(0);
        }
        return cities;
    }

 // Method to read merch:
 public LinkedHashMap<String,Integer> readMerch() {
     List<String> merchList;
     try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Merch.txt")) {
         if (inputStream == null) {
             System.out.println("Could not find the file Merch.txt");
             System.out.println("Can't play the game without it!");
             System.exit(0);
            }

         BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
         String line;
         while ((line = reader.readLine()) != null) {
             if (!line.isEmpty()) {
                 merchList = List.of(line.split(";"));
                 this.merch.put(merchList.getFirst(), Integer.parseInt(merchList.getLast()));
             }
         }
     } catch (Exception e) {
             System.out.println("Error with Merch.txt");
     }
     return this.merch;
 }
}
