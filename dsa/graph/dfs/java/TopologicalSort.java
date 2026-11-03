import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopologicalSort {
    static List<List<Integer>> graph;
    static int[] visited;
    static List<Integer> result = new ArrayList<>();

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
        result.add(node);
        return false;
    }
    public static void main(String[] args) {
        graph = List.of(
            List.of(1, 2),
            List.of(3),
            List.of(3, 4),
            List.of(5),
            List.of(5),
            List.of()
        );

        visited = new int[graph.size()];

        for (int i=0; i<visited.length; i++){
            if (visited[i] != 0) continue;
            if (dfs(i)) {
                System.out.println("cycle existed");
                return ;
            }
        }

        Collections.reverse(result);
        System.out.println(result);
    }


}