import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc= new Scanner(System.in);

    public static void main(String args[]){
        ArrayList<Station> systemRoutes = initializeSystemRoutes();
        Station[] suggestionStations = initializeSuggestionRoutes();
        for (Station station :suggestionStations) {
            System.out.println(station.getStationName() + " " + calculateMinimumDistance(station, systemRoutes));
        }
    }

    public static ArrayList<Station> initializeSystemRoutes(){
        ArrayList<Station> systemRoutes = new ArrayList<>();
        int numberOfRoutesInSystem = sc.nextInt();
        char stationName;
        int x,y;
        for (int i = 0; i < numberOfRoutesInSystem; i++) {
            int numberOfPointsInSystemRoute = sc.nextInt();
            for (int j = 0; j < numberOfPointsInSystemRoute; j++) {
                stationName = sc.next().charAt(0);
                x = sc.nextInt();
                y = sc.nextInt();
                Station station = new Station(stationName, x, y);
                systemRoutes.add(station);
            }
        }
        return systemRoutes;
    }

    public static Station[] initializeSuggestionRoutes(){
        int numberOfSuggestionStations = sc.nextInt();
        Station[] suggestionStations = new Station[numberOfSuggestionStations];
        for (int i = 0; i < numberOfSuggestionStations; i++) {
            char stationName = sc.next().charAt(0);
            int x = sc.nextInt(), y = sc.nextInt();
            Station station = new Station(stationName, x, y);
            suggestionStations[i] = station;
        }
        return suggestionStations;
    }

    public static Character calculateMinimumDistance(Station station, ArrayList<Station>systemRoutes){
        Character chosenStation = null;
        int minimumDistance = Integer.MAX_VALUE;
        for (Station systemStation: systemRoutes) {
            int xCoordinateDifference = Math.abs(systemStation.getX() - station.getX());
            int yCoordinateDifference = Math.abs(systemStation.getY() - station.getY());
            if (xCoordinateDifference + yCoordinateDifference < minimumDistance) {
                minimumDistance = xCoordinateDifference + yCoordinateDifference;
                chosenStation = systemStation.getStationName();
            }
        }
        return chosenStation;
    }
}
