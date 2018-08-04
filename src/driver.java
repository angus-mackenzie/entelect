import java.util.*;

public class driver{
    public static void main(String[] args){
        try{
            MapReader mr = new MapReader("maps/map_1.input");
            while(mr.)
            for(Worker worker: mr.workers){
                if(worker.path==0) {
                    Factory fact = nearestValue(worker, mr.minesList,mr.factoryList);
                    worker.moveToFactory(fact);
                }else if(worker.path==1){
                    worker.path--;
                    if(worker.currentFactory){
                        worker.
                    }
                }
            }
        }catch(Exception e){
            System.out.println("No file");
            e.printStackTrace();
        }
       
    }
}