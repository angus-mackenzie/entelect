import java.util.*;

public class driver{
    public static void main(String[] args){
        try{
            MapReader mr = new MapReader("maps/map_1.input");
            while(mr.minesList.size() != 0 || mr.workersHaveResources()){
                System.out.println(mr.minesList);
                for(Worker worker: mr.workers){
                    if (worker.active) {
                        if (worker.path == 0) {//need to move to a factory
                            Factory fact = nearestValid(worker, mr.minesList, mr.factoryList, mr);
                            if (fact.getClass().getSimpleName().equals("Mine")) {
                                ((Mine) fact).resources--;
                                if (((Mine) fact).resources == 0) {
                                    mr.minesList.remove(fact);
                                }
                            }
                            worker.moveToFactory(fact);
                        }
                        if (worker.path == 1) {//arrived at a factory
                            String tag = worker.currentFactory.tag;
                            if (lowercase(tag)) {
                                worker.removeElement(tag);
                            } else {
                                worker.addElement(tag);
                            }
                        }
                        worker.path--;
                    }
                }
            }

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

        if (nearest == null) {
            worker.active = false;
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