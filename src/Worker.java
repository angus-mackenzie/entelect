
import java.util.ArrayList;


public class Worker{
    
    int distanceTravelled;
    Factory currentFactory;
    String pathTravelled;
    String workerName ="";

    ArrayList<String> elementsCarrying;

    public Worker(String name, Factory start){
        workerName = name;
        distanceTravelled = 0;
        currentFactory = start;
        pathTravelled = "";
        capacity = carryCapacity;

        elementsCarrying = new ArrayList<String>();
    }

    public void moveToFactory(Factory dest){
        System.out.println(workerName+": "+currentFactory.id+"->"+dest.id+"  "+distanceTravelled);
        distanceTravelled += calculateDistance(currentFactory, dest);
        currentFactory = dest;
        pathTravelled += dest.id + ",";
    }
    
    public int calculateDistance (Factory origin, Factory dest){
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