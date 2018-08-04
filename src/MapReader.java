import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * @author Angus Mackenzie
 * @version 19:30PM
 * Takes in the path to a map, and reads it in. 
 * Allocating coordinates to each char in the map
 */
public class MapReader {
    public boolean first = true;
    public int mapHeight = 0;
    public int mapWidth = 0;

    public ArrayList<Worker> workers = new ArrayList<>();

    public int mines = 0;
    public int facts = 0;
    public long budget = 0;

    public ArrayList<Mine> minesList = new ArrayList<>();
    public ArrayList<Factory> factoryList = new ArrayList<>();

    public MapReader(String mapFileName) throws Exception {
        Scanner mapScanner = new Scanner(new File(mapFileName));
        Factory startFactory = new Factory();
        while (mapScanner.hasNext()) {
            if (first) {
                //first line
                String[] firstLine = mapScanner.nextLine().split(" ");
                mapHeight = Integer.parseInt(firstLine[0]);
                mapWidth = Integer.parseInt(firstLine[1]);
                //minerCount = Integer.parseInt(firstLine[2]);
                for (int i = 0; i < Integer.parseInt(firstLine[2]); i++) {
                    workers.add(new Worker("Miner", startFactory, 1));
                }
                //excavatorCount = Integer.parseInt(firstLine[3]);
                for (int i = 0; i < Integer.parseInt(firstLine[3]); i++) {
                    workers.add(new Worker("Excavator", startFactory, 3));
                }
                //haulerCount = Integer.parseInt(firstLine[4]);
                for (int i = 0; i < Integer.parseInt(firstLine[4]); i++) {
                    workers.add(new Worker("Hauler", startFactory, 5));
                }
                mines = Integer.parseInt(firstLine[5]);
                facts = Integer.parseInt(firstLine[6]);
                budget = Long.parseLong(firstLine[7]);
                first = false;
            } else {
                String[] line = mapScanner.nextLine().split(" ");
                if (line.length == 5) {
                    // Mine
                    minesList.add(new Mine(line[0], line[1], line[2], line[3], line[4]));
                } else {
                    // Factory
                    factoryList.add(new Factory(line[0], line[1], line[2], line[3]));
                }
            }
        }
    }

    public boolean workersHaveResources() {
        for (Worker work : workers) {
            if (work.elementsCarrying.size() != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean resourcesAvailable() {
        boolean avail = true;
        if (minesList.size() == 0 && factoryList.size() == 0) {
            avail = false;
        }
        return avail;
    }
}