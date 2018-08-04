
import java.util.ArrayList;


public class Worker{
    
    int distanceTravelled;
    int carryCapacity;
    int path;
    boolean active = true;
    Factory currentFactory;
    String pathTravelled;
    String workerName ="";
    ArrayList<String> elementsCarrying;

    public Worker(String name, Factory start, int capacity){
        workerName = name;
        distanceTravelled = 0;
        currentFactory = start;
        pathTravelled = "";
        carryCapacity = capacity;

        elementsCarrying = new ArrayList<String>();
    }

    public void moveToFactory(Factory dest){
        //System.out.println(workerName+": "+currentFactory.id+"->"+dest.id+"  "+distanceTravelled)
        distanceTravelled += calculateDistance(currentFactory, dest);
        path = calculateDistance(currentFactory, dest);
        currentFactory = dest;
        pathTravelled += dest.index + ",";
    }
    
    public int calculateDistance (Factory origin, Factory dest){
        int dist = (int)(Math.abs(origin.x - dest.x) + Math.abs(origin.y - dest.y));
        return dist;
    }

    public void addElement(String tag){
        elementsCarrying.add(tag);
    }

    public void removeElement(String tag){
        elementsCarrying.remove(tag.toUpperCase());
    }
    
    public boolean hasElement(String tag){
        return elementsCarrying.contains(tag);
    }
    
    public String printPath(){
        return pathTravelled.substring(0, pathTravelled.length()-1);
    }

    public boolean hasCapacity()
    {
        return carryCapacity > elementsCarrying.size();
    }
}