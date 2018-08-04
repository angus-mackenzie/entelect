import java.util.*;

public class driver{
    public static void main(String[] args){
        try{
            MapReader mr = new MapReader("maps/map_1.input");


        }catch(Exception e){
            System.out.println("No file");
            e.printStackTrace();
        }
    }

    public int calculateDistance (Factory origin, Factory dest){
        int dist = (int)(Math.abs(origin.x - dest.x) + Math.abs(origin.y - dest.y));
        return dist;
    }
}