import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
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
    ArrayList[][] mines;// = new ArrayList[][]();
    ArrayList[][] depots;// = new ArrayList[][]();
    public MapReader(String mapFileName) throws Exception{
        Scanner mapScanner = new Scanner(new File(mapFileName));
        while(mapScanner.hasNext()){
            if(first){
                //first line
                numberOfWorkers = mapScanner.nextInt();
                first = false;
            }else{
                lines.add(mapScanner.nextLine());
                dimensions++;
                
            }
        }
        mines = new ArrayList[dimensions][dimensions];
        depots = new ArrayList[dimensions][dimensions];
        for(int i = 0; i < lines.size(); i++){
            char[] line = lines.get(i).toCharArray();
            for(int j = 0; j < line.length;j++){
                if(Character.isUpperCase(line[j])){
                    //mines
                    mines[i][j].add("Mine");
                }else if(Character.isLowerCase(line[j])){
                    depots[i][j].add("depots");
                }
            }

        }
    }

    public int getSize(){
        return dimensions;
    }
    public ArrayList[][] getMines(){
        return mines;
    }

    public ArrayList[][] getDepots(){
        return depots;
    }
    public int getNumberOfWorkers(){
        return numberOfWorkers;
    }
}