import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class driver{
    public static void main(String[] args){
        int budget = 0;
        try{
            MapReader mr = new MapReader("maps/map_5.input");
            budget -= mr.workers.size();
            while(mr.minesList.size() != 0 || mr.workersHaveResources()){
                for(Worker worker: mr.workers){
                    if (worker.active) {
                        budget++;
                        if (worker.path <= 0) {//need to move to a factory
                            String tag = worker.currentFactory.tag;

                            // Drop off or pick up
                            if (tag != null) {
                                if (lowercase(tag)) {
                                    worker.removeElement(tag);
                                } else {
                                    worker.addElement(tag);
                                }
                            }

                            // See where to go
                            Factory fact = nearestValid(worker, mr.minesList, mr.factoryList, mr);
                            if (fact == null) {
                                worker.active = false;
                                continue;
                            }

                            // Claim resource
                            if (fact.getClass().getSimpleName().equals("Mine")) {
                                ((Mine) fact).resources--;
                                if (((Mine) fact).resources == 0) {
                                    mr.minesList.remove(fact);
                                }
                            }

                            // Sets destination
                            worker.moveToFactory(fact);
                        }
                        worker.path--;
                    }
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("map5_result.txt"));
            for (Worker worker :
                    mr.workers) {
                writer.write(worker.printPath() + "\n");
            }
            writer.close();
            System.out.println(mr.budget - budget);

        }catch(Exception e){
            System.out.println("No file");
            e.printStackTrace();
        }
    }

    private static boolean minesHaveResources(ArrayList<Mine> minesList) {
        for (Mine mine :
                minesList) {
            if (mine.resources > 0) {
                return true;
            }
        }
        return false;
    }

    public static int calculateDistance (Factory origin, Factory dest){
        int dist = (int)(Math.abs(origin.x - dest.x) + Math.abs(origin.y - dest.y));
        return dist;
    }

    private static Factory nearestValid(Worker worker, ArrayList<Mine> mines, ArrayList<Factory> factories, MapReader mr)
    {
        Factory nearest = null;
        int distance = 1000;
        if (worker.hasCapacity()) {
            for (Mine mine: mines) {
                if (! worker.hasElement(mine.tag) && mine.resources > 0) {
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

        return nearest;
    }

    static boolean lowercase(String tag){
        return tag.equals(tag.toLowerCase());
    }
    static boolean uppercase(String tag){
        return tag.equals(tag.toUpperCase());
    }
}