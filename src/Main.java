
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static String FILE = "Countries.txt";



    public static void readFile(Scanner fileScanner, HashMap<String, ArrayList<Countries>> map) {
        String line = fileScanner.nextLine();
        String[] columns = line.split("\\|");
        Countries country = new Countries(columns[0], columns[1]);
        String firstLetter = String.valueOf(columns[1].charAt(0));
        String letter = firstLetter.toUpperCase();

        if (!map.containsKey(letter)) map.put(letter, new ArrayList<>());

        ArrayList<Countries> aL = map.get(letter);
        aL.add(country);
    }


    public static void createList(String finalQuery, HashMap<String, ArrayList<Countries>> map) throws IOException {

        File file = new File(finalQuery + "_countries.txt");
        FileWriter fw = new FileWriter(file);

        ArrayList<Countries> aL = map.get(finalQuery);
        for (Countries country : aL) {
            String line = String.format("%s\n", country.name);
            fw.append(line);
        }
        fw.close();
    }


    public static void main(String[] args) throws Exception {

        HashMap<String, ArrayList<Countries>> map = new HashMap<>();

        File f = new File(FILE);



        Scanner fileScanner = new Scanner(f);
        Scanner scanner = new Scanner(System.in);


        while (fileScanner.hasNext()) {
            readFile(fileScanner, map);
        }

        System.out.println("Type the first letter of a country");
        String entry = (scanner.nextLine());
        String finalEntry = entry.toUpperCase();
        createList(finalEntry, map);
        System.out.println("List Created");
        }
    }
