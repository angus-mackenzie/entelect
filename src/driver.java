import java.util.*;

public class driver{
    public static void main(String[] args){
        try{
            MapReader mr = new MapReader("maps/map_1.input");
            while(mr.minesList.size()!=0 && mr.workersHaveResources()){
                for(Worker worker: mr.workers){
                    if(worker.==0) {
                        Factory fact = nearestValue(worker, mr.minesList,mr.factoryList);
                        worker.moveToFactory(fact);
                    }else if(worker.path==1){
                        if(worker.currentFactory){
                            worker.
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println("No file");
            e.printStackTrace();

            worker.path--;   }
       
    }
}