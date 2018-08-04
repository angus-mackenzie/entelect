import java.util.*;

public class driver{
    public static void main(String[] args){
        try{
            MapReader mr = new MapReader("maps/map_1.input");
            System.out.println(mr.excavatorCount);

        }catch(Exception e){
            System.out.println("No file");
            e.printStackTrace();
        }
       
    }
}