public class A {
    public static void main(String[] args) {
        CaveRun cave = new CaveRun();
        System.out.println(System.getProperty("user.dir"));
        String cave_data = cave.cave_read("data.txt");
        System.out.println(cave_data);

        cave = cave.cave_parse(cave_data);
        System.out.println("Cave rarity: " + cave.rarity);
        System.out.println("Tiles traveled: " + cave.tilesTraveled);
        System.out.println("Tiles cleared: " + cave.tilesCleared);
        System.out.println("Bosses killed: " + cave.bossesKilled);
        System.out.println("Monsters killed: " + cave.monstersKilled);
        System.out.println("Tiles looted: " + cave.tilesLooted);
        System.out.println("Treasures found: " + cave.treasuresFound);
        System.out.println();
        System.out.println("Rewards: ");
    }

}