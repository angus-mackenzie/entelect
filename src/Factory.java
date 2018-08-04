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

    public Factory(int index, String tag, int x, int y){
        this.index = index;
        this.tag = tag;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "Index "+index+", Tag "+tag+", coordinates ["+x+","+y+"]";
    }
}