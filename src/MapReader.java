import java.util.Scanner;
import java.io.*;
/**
 * Takes in the path to a map, and reads it in. 
 * Allocating coordinates to each char in the map
 */
public class MapReader{
    int numberOfLines = 0;
    int numberOfWorkers = 0;
    /**
     * @param String the filename of the map
     */
    public MapReader(String mapFileName) throws Exception{
        Scanner mapReader = new Scanner(new File(mapFileName));
        while(mapReader.hasNext()){
            if(numberOfLines==0){
                //first line
                numberOfWorkers = mapReader.nextInt();
            }
            //otherwise we read the line in
            Scanner lineReader = new Scanner(mapReader.nextLine());
            while(lineReader.next()){
                System.out.println("This is a char: "+lineReader.next());
            }
            
            numberOfLines++;
        }
    }
}