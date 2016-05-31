    import java.io.File;
    import java.io.FileNotFoundException;
    import java.util.ArrayList;
    import java.util.Scanner;

    //used class template
    public class Main {

        public static ArrayList<Countries> parseCountryList(String fileName) throws FileNotFoundException {
            ArrayList<Countries> CountryList = new ArrayList<>();
            File f = new File(fileName);
            Scanner fileScanner = new Scanner(f);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] columns = line.split("\\|");
                Countries countries = new Countries(Integer.valueOf(columns[0]), columns[1], columns[2]);
                CountryList.add(countries);
            }
            return CountryList;

        }

        public static void printCountryList(ArrayList<Countries> countryList, int currentCountry) {
            int countryId = 0;
            for (Countries countries : countryList) {
                if (countries.number == currentCountry) {
                    System.out.printf("[%s] %s by %s\n", countryId, countries.name, countries.abbreviation);
                }
                countryId++;
            }

        }
        public static void main(String[] args) throws FileNotFoundException {
            //parse file
            ArrayList<Countries> CountryList = parseCountryList("CountryList.txt");

            //start loop
            Scanner consoleScanner = new Scanner(System.in);
            int currentPost = -1;
            while (true) {

                //print out replies to current post
                printCountryList(CountryList, currentPost);

                //ask for new id
                System.out.println(" Type the first letter a country ");
                currentPost = Integer.valueOf(consoleScanner.nextLine());


            }
        }
    }


