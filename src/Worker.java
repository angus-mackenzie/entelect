public class Worker{
    
    int distanceTravelled;
    Point currentPoint;
    String pathTravelled;
    
    public Worker(Point start){
        distanceTravelled = 0;
        currentPoint = start;
        pathTravelled = "";
    }
    
    public void moveToPoint(Point dest){
        distanceTravelled += calculateDistance(currentPoint, dest);
        currentPoint = dest;
        pathTravelled += Point.id + ",";
    }
    
    public int calculateDistance (Point origin, Point dest){

        int dist = (int)(Math.abs(origin.getX() - dest.getX()) + Math.abs(origin.getY() - dest.getY()));
        return dist;

    }
    
    public String printPath(){
        return pathTravelled.substring(0, pathTravelled.length()-1);
    }
    
}