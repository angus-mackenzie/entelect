import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class driver{
    private static HashMap<String, List<Factory>> factHash;
    public static void main(String[] args){
        int budget = 0;

        try{
            MapReader mr = new MapReader("maps/map_1.input");
            budget -= mr.workers.size();
            factHash = new HashMap<>();
            for (Factory fact :  mr.factoryList) {
                List<Factory> list = factHash.get(fact.tag);
                if (list == null) {list = new ArrayList<>();}
                list.add(fact);
                factHash.put(fact.tag, list);
            }

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
                            System.out.println(mr.minesList);
                            System.out.println(mr.workers);
                            System.out.println("moving " + mr.workers.indexOf(worker) + " to " + fact.index);
                            worker.moveToFactory(fact);
                        }
                        worker.path--;
                    }
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("map1_result.txt"));
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
        Factory one = null;
        int oneToFac = -1;
        Factory two = null;
        int twoToFac = -1;
        Factory three = null;
        int threeToFac = -1;

        // Valid mines
        if (worker.hasCapacity()) {
            for (Mine mine: mines) {
                if (! worker.hasElement(mine.tag) && mine.resources > 0) {
                    // first thing
                    if (one == null) {
                        one = mine;
                        continue;
                    }

                    if (two == null) {
                        two = mine;
                        continue;
                    }

                    if (three == null) {
                        three = mine;
                        continue;
                    }

                    if (calculateDistance(worker.currentFactory, mine) < calculateDistance(worker.currentFactory, one)) {
                        one = mine;
                        break;
                    }
                    if (calculateDistance(worker.currentFactory, mine) < calculateDistance(worker.currentFactory, two)) {
                        two = mine;
                        break;
                    }
                    if (calculateDistance(worker.currentFactory, mine) < calculateDistance(worker.currentFactory, three)) {
                        three = mine;
                    }
                }
            }
        }

        for (Factory factory : factories) {
            if (worker.hasElement(factory.tag.toUpperCase())) {
                // first thing
                if (one == null) {
                    one = factory;
                    continue;
                }

                if (two == null) {
                    two = factory;
                    continue;
                }

                if (three == null) {
                    three = factory;
                    continue;
                }

                if (calculateDistance(worker.currentFactory, factory) < calculateDistance(worker.currentFactory, one)) {
                    one = factory;
                    break;
                }
                if (calculateDistance(worker.currentFactory, factory) < calculateDistance(worker.currentFactory, two)) {
                    two = factory;
                    break;
                }
                if (calculateDistance(worker.currentFactory, factory) < calculateDistance(worker.currentFactory, three)) {
                    three = factory;
                }
            }
        }

        if (one.getClass().getSimpleName().equals("Factory")) {
            List<Factory> list= factHash.get(one.tag);
            for (Factory fac : list) {
                if (oneToFac == -1) {
                    oneToFac = calculateDistance(one, fac);
                }

                if (calculateDistance(one, fac) < oneToFac) {
                    oneToFac = calculateDistance(one, fac);
                }
            }
        }

        if (two != null && two.getClass().getSimpleName().equals("Factory")) {
            List<Factory> list= factHash.get(two.tag);
            for (Factory fac : list) {
                if (twoToFac == -1) {
                    twoToFac = calculateDistance(two, fac);
                }

                if (calculateDistance(two, fac) < twoToFac) {
                    twoToFac = calculateDistance(two, fac);
                }
            }
        }

        if (three != null && three.getClass().getSimpleName().equals("Factory")) {
            List<Factory> list= factHash.get(three.tag);
            for (Factory fac : list) {
                if (threeToFac == -1) {
                    threeToFac = calculateDistance(three, fac);
                }

                if (calculateDistance(three, fac) < threeToFac) {
                    threeToFac = calculateDistance(three, fac);
                }
            }
        }

        if (oneToFac == -1) {
            return one;
        }

        if ((oneToFac < twoToFac && twoToFac != -1) && (oneToFac < threeToFac && threeToFac != -1)) {
            return one;
        }

        if ((twoToFac < oneToFac) && (twoToFac < threeToFac && threeToFac != -1)) {
            return two;
        }

        if ((threeToFac < oneToFac) && (threeToFac < twoToFac && twoToFac != -1)) {
            return three;
        }

        return one;
    }

    static boolean lowercase(String tag){
        return tag.equals(tag.toLowerCase());
    }
    static boolean uppercase(String tag){
        return tag.equals(tag.toUpperCase());
    }
}