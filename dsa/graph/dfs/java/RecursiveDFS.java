import java.util.List;

public class RecursiveDFS {
    static List<List<Integer>> graph;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;

        System.out.print(node+" ");

        for (int adj : graph.get(node)) {
            if (visited[adj]) continue;
            dfs(adj);
        }

    }
    public static void main(String[] args) {
        graph = List.of(
            List.of(1, 2),
            List.of(0, 3, 4),
            List.of(0, 5),
            List.of(1),
            List.of(1),
            List.of(2)
        );

        visited = new boolean[graph.size()];

        for (int i=0; i<visited.length; i++){
            if (visited[i]) continue;
            dfs(i);
        }
    }
}