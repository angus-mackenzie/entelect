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
    int dimensions = 0;
    int numberOfWorkers = 0;
    String map ="";
    boolean first = true;
    int mapHeight =         0;
    int mapWidth = 0;
    int minerCount = 0;
    int excavatorCount = 0;
    int haulerCount = 0;
    int mines = 0;
    int facts = 0;
    int budget = 0;
    /**
     * @param String the filename of the map
     */
    ArrayList<String> lines = new ArrayList<String>();
    ArrayList<Factory> mines;// = new ArrayList[][]();
    ArrayList<Factory> depots;// = new ArrayList[][]();
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
                //otherwise add it to the array of lines
                lines.add(mapScanner.nextLine());
                dimensions++;
                
            }
        }
        //create arrays for mines and epots
        mines = new ArrayList<Factory>();
        depots = new ArrayList<Factory>();

        //Populate them with data from 0,0
        for(int i = lines.size()-1; i >0; i--){
            char[] line = lines.get(i).toCharArray();
            for(int j = 0; j < line.length;j++){
                if(Character.isUpperCase(line[j])){
                    mines.add(new Point(line[j],Math.abs(i-10),j));
                }else if(Character.isLowerCase(line[j])){
                    depots.add(new Point(line[j],Math.abs(i-10),j));
                }
            }
        }
    }

    /**
     * return the dimensions of the map
     */
    public int getDimensions(){
        return dimensions;
    }
    /**
     * returns the mines in an arrayList
     */
    public ArrayList<Factory> getMines(){
        return mines;
    }

    /**
     * returns the depots 
     */
    public ArrayList<Factory> getDepots(){
        return depots;
    }

    /**
     * return the number of workers specified
     */
    public int getNumberOfWorkers(){
        return numberOfWorkers;
    }
}