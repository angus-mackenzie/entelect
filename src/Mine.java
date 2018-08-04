public class Mine extends Factory{
    public int resources;

    public Mine(int index, String tag, int x, int y, int resources) {
        super(index, tag, x, y);
        this.resources = resources;
    }
}
