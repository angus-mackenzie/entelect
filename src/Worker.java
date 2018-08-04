
import java.util.ArrayList;


public class Worker{
    
    int distanceTravelled;
    Point currentPoint;
    String pathTravelled;
    String workerName ="";
    int capacity;
    ArrayList<String> elementsCarrying;

    public Worker(String name, Point start, int carryCapacity){
        workerName = name;
        distanceTravelled = 0;
        currentPoint = start;
        pathTravelled = "";
        capacity = carryCapacity;

        elementsCarrying = new ArrayList<String>();
    }

    public void moveToPoint(Point dest){
        System.out.println(workerName+": "+currentPoint.id+"->"+dest.id+"  "+distanceTravelled);
        distanceTravelled += calculateDistance(currentPoint, dest);
        currentPoint = dest;
        pathTravelled += dest.id + ",";
    }
    
    public int calculateDistance (Point origin, Point dest){
        int dist = (int)(Math.abs(origin.getX() - dest.getX()) + Math.abs(origin.getY() - dest.getY()));
        return dist;
    }

    public void addElement(String tag){
        elementsCarrying.add(tag);
    }

    public void removeElement(String tag){
        elementsCarrying.remove(tag);
    }
    
    public boolean hasElement(String tag){
        return elementsCarrying.contains(tag);
    }
    
    public String printPath(){
        return pathTravelled.substring(0, pathTravelled.length()-1);
    }
    
}