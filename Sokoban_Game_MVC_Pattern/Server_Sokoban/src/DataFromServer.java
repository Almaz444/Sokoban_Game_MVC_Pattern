public class DataFromServer implements java.io.Serializable {
    private int[][] desktop;

    public DataFromServer(int[][] desktop) {
        this.desktop = desktop;
    }

    public int[][] getDesktop() {
        return  desktop;
    }

}

