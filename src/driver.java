import java.util.*;

public class driver{
    public static void main(String[] args){
        try{
            MapReader mr = new MapReader("maps/map_1.input");


        }catch(Exception e){
            System.out.println("No file");
            e.printStackTrace();
        }
    }

    public static int calculateDistance (Factory origin, Factory dest){
        int dist = (int)(Math.abs(origin.x - dest.x) + Math.abs(origin.y - dest.y));
        return dist;
    }

    private static Factory nearestValid(Worker worker, ArrayList<Mine> mines, ArrayList<Factory> factories)
    {
        Factory nearest = null;
        int distance = 1000;
        if (worker.hasCapacity()) {
            for (Mine mine: mines) {
                if (nearest == null) {
                    nearest = mine;
                    distance = calculateDistance(worker.currentFactory, mine);
                    continue;
                }
                int newDistance = calculateDistance(worker.currentFactory, mine);
                if (newDistance < distance) {
                    nearest = mine;
                    distance = newDistance;
                }
            }
        }

        for (Factory factory : factories) {
            if (worker.hasElement(factory.tag.toUpperCase())) {
                if (nearest == null) {
                    nearest = factory;
                    distance = calculateDistance(worker.currentFactory, factory);
                    continue;
                }
                int newDistance = calculateDistance(worker.currentFactory, factory);
                if (newDistance < distance) {
                    nearest = factory;
                    distance = newDistance;
                }
            }
        }

        if (nearest == null) {
            System.out.println("Ya dun goofed");
        }
        return nearest;
    }
}