import java.util.*;

public class driver{
    public static void main(String[] args){
        try{
            Controller cont = new Controller();
            MapReader mr = new MapReader("../maps/map_1.input");
            ArrayList<Point> mines = mr.getMines();
            ArrayList<Point> depots = mr.getDepots();
            ArrayList<Integer> distances = distanceList(cont, mines, depots);
            Point start = new Point();
            Worker worker1 = new Worker("Worker1",start);
            Worker worker2 = new Worker("Worker2",start);
            Worker worker3 = new Worker("Worker3",start);
            Worker worker4 = new Worker("Worker4",start);
            Random rand = new Random();

            /**
             * Dummy method that just moves workers to different depos
             * We would need a better allocation that would construct a graph out of the distances between different points,
             * And then from that there would be an optimization based solution where deploying the workers in a specific
             * rotation would allow for the greatest amount of success.
             */
            while(true){
                worker1.moveToPoint(depots.get(rand.nextInt(depots.size())));
                worker2.moveToPoint(depots.get(rand.nextInt(depots.size())));
                worker3.moveToPoint(depots.get(rand.nextInt(depots.size())));
                worker4.moveToPoint(depots.get(rand.nextInt(depots.size())));
            }
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