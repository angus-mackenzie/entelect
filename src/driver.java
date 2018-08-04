import java.util.*;

public class driver{
    public static void main(String[] args){
        try{
            MapReader mr = new MapReader("maps/map_1.input");
            while(minesHaveResources(mr.minesList) || mr.workersHaveResources()){
                for(Worker worker: mr.workers){
                    if(worker.path==0) {//need to move to a factory
                        Factory fact = nearestValid(worker, mr.minesList,mr.factoryList, mr);
                        if (fact.getClass().getSimpleName().equals("Mine")) {
                            ((Mine)fact).resources--;
                        }
                        worker.moveToFactory(fact);
                    }else if(worker.path==1){//arrived at a factory
                        String tag = worker.currentFactory.tag;
                        if(lowercase(tag)){
                            worker.removeElement(tag);
                        }else{
                            worker.addElement(tag);
                        }
                    }
                    worker.path--;
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
            System.out.println("Ya dun goofed");
            System.exit(1);
        }
        if (nearest.equals(worker.currentFactory)) {
            System.out.println("stuck at: " + nearest);
            System.out.println(worker.pathTravelled + ", " + mr.minesList);
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