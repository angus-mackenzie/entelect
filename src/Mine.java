public class Mine extends Factory{
    public int resources;

    public Mine(int index, String tag, int x, int y, int resources) {
        super(index, index, x, y);
        this.resources = resources;
    }
}
