import java.util.*;

public class uasSem2 {

    static class Graph {
        int numCities;
        List<Set<Integer>> adjList;
        Map<Integer, Set<Integer>> cityAlliances;

        Graph(int numCities) {
            this.numCities = numCities;
            adjList = new ArrayList<>(numCities);
            for (int i = 0; i < numCities; i++) {
                adjList.add(new HashSet<>());
            }
            cityAlliances = new HashMap<>();
        }
        void addAlliance(int color, List<Integer> cities) {
            for (int city : cities) {
                cityAlliances.putIfAbsent(city, new HashSet<>());
                cityAlliances.get(city).add(color);
            }
            for (int city : cities) {
                for (int otherCity : cities) {
                    if (city != otherCity) {
                        adjList.get(city).add(otherCity);
                    }
                }
            }
        }

        boolean canVisitAllCitiesFrom(int startCity) {
            Set<Integer> initialTickets = cityAlliances.get(startCity);
            for (int ticket : initialTickets) {
                Set<Integer> visited = new HashSet<>();
                if (dfs(startCity, visited, ticket) == numCities) {
                    return true;
                }
            }
            return false;
        }

