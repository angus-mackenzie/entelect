public class Controller{
	
	public Controller(){

	}

	public int calculateDistance (Factory origin, Factory dest){

            int dist = (int)(Math.abs(origin.x - dest.x) + Math.abs(origin.y - dest.y));
            return dist;

        }

}