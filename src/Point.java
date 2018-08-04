public class Point{
    char id;
    int x;
    int y;
    
    public Point(){
        this.x= 0;
        this.y = 0;
    }

    public Point(char id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public char getID(){
        return id;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public String toString(){
        return id+"["+x+","+y+"]";
    }
}