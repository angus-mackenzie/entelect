public class Mine extends Factory{
    public int resources;

    public Mine(String index, String tag, String x, String y, String resources) {
        super(index, tag, x, y);
        this.resources = Integer.parseInt(resources);
    }
}
