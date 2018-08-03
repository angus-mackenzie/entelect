public class Controller{
	
	public Controller(){

	}

	public int calculateDistance (Point origin, Point dest){

            int dist = (int)(Math.abs(origin.getX() - dest.getX()) + Math.abs(origin.getY() - dest.getY()));
            return dist;

    }

}