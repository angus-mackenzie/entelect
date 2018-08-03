public class driver{
    public static void main(String[] args){
        try{
            MapReader mr = new MapReader("../maps/map_1.input");
            int [][] vals = new int[4][];
            vals[0] = mr.getDimension();
            vals[1] = mr.getMines();
            vals[2] = mr.getFactories();
            vals[3] = mr.getWorkers();

        }catch(Exception e){
            System.out.println("No file");
            e.printStackTrace();
        }
       
    }
}