import java.util.*;

public class UndirectedCycle {
    static List<List<Integer>> graph;
    static boolean[] visited;

    static boolean dfs(int node, int parent) {
        visited[node] = true;
        
        for (int adj : graph.get(node)) {
            if (visited[adj]) {

                if (adj != parent) {
                    return true;
                }

                continue;
            }
            
            if (dfs(adj, node)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        graph = List.of(
            List.of(1),
            List.of(0, 2, 4),
            List.of(1, 3),
            List.of(2, 4),
            List.of(1, 3, 5),
            List.of(4)
        );

        visited = new boolean[graph.size()];

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
        
            if (dfs(i, -1)) {
                System.out.println("cycle existed");
                return;
            }
        }
        
        System.out.println("cycle not existed");
    }
}