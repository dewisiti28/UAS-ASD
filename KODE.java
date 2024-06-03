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
private int dfs(int city, Set<Integer> visited, int currentTicket) {
            visited.add(city);
            int count = 1;

            for (int neighbor : adjList.get(city)) {
                if (!visited.contains(neighbor)) {
                    Set<Integer> neighborTickets = cityAlliances.get(neighbor);
                    for (int ticket : neighborTickets) {
                        if (ticket != currentTicket) {
                            count += dfs(neighbor, visited, ticket);
                        }
                    }
                }
            }
            return count;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int numCities = scanner.nextInt();
            int numAlliances = scanner.nextInt();
            if (numCities == 0 && numAlliances == 0) break;

            Graph graph = new Graph(numCities);

            for (int i = 0; i < numAlliances; i++) {
                int numCitiesInAlliance = scanner.nextInt();
                List<Integer> cities = new ArrayList<>();
                for (int j = 0; j < numCitiesInAlliance; j++) {
                    cities.add(scanner.nextInt());
                }
                graph.addAlliance(i, cities);
            }

            int startCity = -1;
            for (int i = 0; i < numCities; i++) {
                if (graph.canVisitAllCitiesFrom(i)) {
                    startCity = i;
                    break;
                }
            }

            System.out.println(startCity);
        }
        scanner.close();
    }
}
