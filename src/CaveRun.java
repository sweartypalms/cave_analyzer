// import java.util.Date;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CaveRun {
    int starting_depth;
    int ending_depth;
    String rarity;
    // String result;
    // Date date;
    int tilesTraveled;
    int tilesCleared;
    int bossesKilled;
    int monstersKilled;
    int monstersTotal;
    int tilesLooted;
    int treasuresFound;
    // int fighterGold;
    // int diamonds;
    // int recipePets;
    // int recipeFighter;
    // int recipeLock;
    // int recipeMerge;
    // int recipeEnhance;
    // int recipeSanctum;
    // int recipeUpgrade;
    // int recipeImplicit;
    // int recipeSculpture;
    // int strength;
    // int health;
    // int dexterity;
    // int agility;
    // int wootz;
        /**
     * Reads data and saves it to a string
     * @param data the cave data pasted into a raw text file
     * @return string from data provided
     */
    String cave_read(String data) {
        StringBuilder contents = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(data))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                contents.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found.");
            e.printStackTrace();
        }
        return contents.toString();
    }

    /**
     * Parses the cave data read from the text file.
     * @param data the data read from data.txt 
     * @return cave object built using the parsed data
     */
    CaveRun cave_parse(String data) {
        String[] rarities = {
            "scrap",
            "normal",
            "uncommon",
            "rare",
            "epic",
            "magical",
            "unique",
            "relic"
        };
        Scanner scanner = new Scanner(data);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Parse depth
            if(line.startsWith("Depth")) {
                String[] depth_range = line.substring(5).trim().split("–");
                starting_depth = Integer.parseInt(depth_range[0]);
                ending_depth = Integer.parseInt(depth_range[1]);
                System.out.println("Starting depth: " + starting_depth);
                System.out.println("Ending depth: " + ending_depth);
            }

            // Parse rarity
            String lowerLine = line.toLowerCase();
            for (String rarity : rarities) {
                if(lowerLine.contains(rarity)) {
                    this.rarity = rarity;
                    break;
                }
            }

            // Parse tiles traveled and tiles cleared
            if(line.startsWith("Tiles traveled")) {
                this.tilesTraveled = Integer.parseInt(scanner.nextLine().trim());
            }
            if(line.startsWith("Tiles cleared")) {
                this.tilesCleared = Integer.parseInt(scanner.nextLine().trim());
            }
            // Parse bosses and monsters cleared
            if(line.startsWith("Bosses killed")) {
                String[] bosses = scanner.nextLine().trim().split("/");
                this.bossesKilled = Integer.parseInt(bosses[0].trim());
            }
            if(line.startsWith("Monsters killed")) {
                String[] monsters = scanner.nextLine().trim().split("/");
                this.monstersKilled = Integer.parseInt(monsters[0].trim());
                this.monstersTotal = Integer.parseInt(monsters[1].trim());
            }
            if(line.startsWith("Tiles looted")) {
                String[] tiles = scanner.nextLine().trim().split("/");
                this.tilesLooted = Integer.parseInt(tiles[0].trim());
            }
            if(line.startsWith("Treasures found")) {
                String[] treasures = scanner.nextLine().trim().split("/");
                this.treasuresFound = Integer.parseInt(treasures[0].trim());    
            }
        }
        scanner.close();
        return this;
    }

    

    

    static String cave_analyze(String data) {
        return null;
    }



}
