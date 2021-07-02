public class Station {
    private char stationName;
    private int x;
    private int y;

    public Station(){
    }

    public Station(char stationName, int x, int y) {
        this.stationName = stationName;
        this.x = x;
        this.y = y;
    }

    public char getStationName() {
        return stationName;
    }

    public void setStationName(char stationName) {
        this.stationName = stationName;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationName=" + stationName +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
