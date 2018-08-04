public class Factory{
    public int index;
    public String tag;
    public int x;
    public int y;
    
    public Factory(){
        this.index =0;
        this.x= 0;
        this.y = 0;
    }

    public Factory(String index, String tag, String x, String y){
        this.index = Integer.parseInt(index);
        this.tag = tag;
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
    }

    @Override
    public String toString(){
        return "Index "+index+", Tag "+tag+", coordinates ["+x+","+y+"]";
    }
}