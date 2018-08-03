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
    /**
     * @param String the filename of the map
     */
    ArrayList<String> lines = new ArrayList<String>();
    ArrayList<Point> mines;// = new ArrayList[][]();
    ArrayList<Point> depots;// = new ArrayList[][]();
    public MapReader(String mapFileName) throws Exception{
        Scanner mapScanner = new Scanner(new File(mapFileName));
        while(mapScanner.hasNext()){
            if(first){
                //first line
                numberOfWorkers = mapScanner.nextInt();
                first = false;
            }else{
                //otherwise add it to the array of lines
                lines.add(mapScanner.nextLine());
                dimensions++;
                
            }
        }
        //create arrays for mines and epots
        mines = new ArrayList<Point>();
        depots = new ArrayList<Point>();

        //Populate them with data from 0,0
        for(int i = lines.size()-1; i >0; i--){
            char[] line = lines.get(i).toCharArray();
            for(int j = 0; j < line.length;j++){
                if(Character.isUpperCase(line[j])){
                    mines.add(new Point(Math.abs(i-10),j));
                }else if(Character.isLowerCase(line[j])){
                    depots.add(new Point(Math.abs(i-10),j));
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
    public ArrayList<Point> getMines(){
        return mines;
    }

    /**
     * returns the depots 
     */
    public ArrayList<Point> getDepots(){
        return depots;
    }

    /**
     * return the number of workers specified
     */
    public int getNumberOfWorkers(){
        return numberOfWorkers;
    }
}