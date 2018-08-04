import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * @author Angus Mackenzie
 * @version 19:30PM
 * Takes in the path to a map, and reads it in. 
 * Allocating coordinates to each char in the map
 */
public class MapReader{
    public int dimensions = 0;
    public int numberOfWorkers = 0;
    public boolean first = true;
    public int mapHeight = 0;
    public int mapWidth = 0;
    public int minerCount = 0;
    public int excavatorCount = 0;
    public int haulerCount = 0;
    public int mines = 0;
    public int facts = 0;
    public int budget = 0;

    public ArrayList<Mine> minesList = new ArrayList<>();
    public ArrayList<Factory> factoryList = new ArrayList<>();

    public MapReader(String mapFileName) throws Exception{
        Scanner mapScanner = new Scanner(new File(mapFileName));
        while(mapScanner.hasNext()){
            if(first){
                //first line
                String[] firstLine = mapScanner.nextLine().split(" ");
                mapHeight = Integer.parseInt(firstLine[0]);
                mapWidth = Integer.parseInt(firstLine[1]);
                minerCount = Integer.parseInt(firstLine[2]);
                excavatorCount = Integer.parseInt(firstLine[3]);
                haulerCount = Integer.parseInt(firstLine[4]);
                mines = Integer.parseInt(firstLine[5]);
                facts = Integer.parseInt(firstLine[6]);
                budget = Integer.parseInt(firstLine[7]);
                first = false;
            }else{
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
}