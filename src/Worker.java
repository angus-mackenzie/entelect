public class Worker{
    
    int distanceTravelled;
    Point currentPoint;
    String pathTravelled;
    String workerName ="";
    public Worker(String name, Point start){
        workerName = name;
        distanceTravelled = 0;
        currentPoint = start;
        pathTravelled = "";
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
    
    public String printPath(){
        return pathTravelled.substring(0, pathTravelled.length()-1);
    }
    
}