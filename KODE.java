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
