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
    boolean first = True;
    /**
     * @param String the filename of the map
     */
    ArrayList<String> lines = new ArrayList<string>();
    ArrayList<Integer,Integer> mines = new ArrayList<Integer,Integer>();
    ArrayList<Integer,Integer> depots = new ArrayList<Integer,Integer>();
    public MapReader(String mapFileName) throws Exception{
        Scanner mapScanner = new Scanner(new File(mapFileName));
        while(mapScanner.hasNext()){
            if(first){
                //first line
                numberOfWorkers = mapScanner.nextInt();
                first = False;
            }else{
                lines.add(mapScanner.nextLine());
                dimensions++;
                
            }
        }

        for(int i = 0; i < lines.size(); i++){
            char[] line = lines.get(i).toCharArray();
            for(int j = 0; j < line.length;j++){
                if(Character.isUpperCase(line[j])){
                    //mines
                    mines.add(i,j);
                }else if(Character.isLowerCase(line[j])){
                    depots.add(i,j);
                }
            }

        }
    }

    public int getSize(){
        return dimensions;
    }
    public ArrayList<Integer,Integer> getMines(){
        return mines;
    }

    public ArrayList<Integer,Integer> getDepots(){
        return depots;
    }
    public int getNumberOfWorkers(){
        return numberOfWorkers;
    }
}