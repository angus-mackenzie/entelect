import java.util.*;

public class driver{
    public static void main(String[] args){
        try{
            MapReader mr = new MapReader("../maps/map_1.input");
            ArrayList<Point> mines = mr.getMines();
            ArrayList<Point> depots = mr.getDepots();
        }catch(Exception e){
            System.out.println("No file");
            e.printStackTrace();
        }
       
    }
}