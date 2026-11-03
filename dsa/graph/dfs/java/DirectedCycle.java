import java.util.List;

public class DirectedCycle {
    static List<List<Integer>> graph;
    static int[] visited;

    static boolean dfs(int node) {
        visited[node] = 1;

        for (int adj : graph.get(node)) {
            if (visited[adj] == 1) {
                return true;
            } else if (visited[adj] == 2) {
                continue;
            }

            if (dfs(adj)) {
                return true;
            }
        }

        visited[node] = 2;

        return false;
    }
    public static void main(String[] args) {
        graph = List.of(
            List.of(1),
            List.of(2),
            List.of(3),
            List.of(1, 4),
            List.of(5),
            List.of(),
            List.of(7),
            List.of(8),
            List.of()
        );

        visited = new int[graph.size()];

        for (int i=0; i<visited.length; i++) {
            if (visited[i] != 0) continue;

            if (dfs(i)) {
                System.out.println("cycle existed");
                return;
            }
        }

        System.out.println("cycle not existed");
    }
}