public class Worker{
    
    int distanceTravelled;
    Factory currentFactory;
    String pathTravelled;
    String workerName ="";
    public Worker(String name, Factory start){
        workerName = name;
        distanceTravelled = 0;
        currentFactory = start;
        pathTravelled = "";
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
    
    public String printPath(){
        return pathTravelled.substring(0, pathTravelled.length()-1);
    }
    
}