import java.util.*;

public class driver{
    public static void main(String[] args){
        try{
            Controller cont = new Controller();
            MapReader mr = new MapReader("../maps/map_1.input");
            ArrayList<Point> mines = mr.getMines();
            ArrayList<Point> depots = mr.getDepots();
            ArrayList<Integer> distances = distanceList(cont, mines, depots);
        }catch(Exception e){
            System.out.println("No file");
            e.printStackTrace();
        }
       
    }
    public static ArrayList<Integer> distanceList(Controller cont, ArrayList<Point> mines, ArrayList<Point> depots){
        ArrayList<Integer> values = new ArrayList<Integer>();
        for(int i = 0; i<mines.size(); i++){
            values.add(cont.calculateDistance(mines.get(i), depots.get(i)));
        }
        return values;
    }
}