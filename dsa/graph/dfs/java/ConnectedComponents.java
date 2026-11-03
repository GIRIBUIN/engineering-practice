import java.util.List;

public class ConnectedComponents {
    static List<List<Integer>> graph;
    static boolean[] visited;
    
    static void dfs(int node) {
        if (visited[node]) return;

        visited[node] = true;

        for (int adj : graph.get(node)) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }
    public static void main(String[] args) {
        graph = List.of(
            List.of(1),
            List.of(0, 2),
            List.of(1),
            List.of(4),
            List.of(3),
            List.of()
        );

        visited = new boolean[graph.size()];
        int count = 0;
        for(int i=0; i<visited.length; i++){
            if (visited[i]) continue;

            dfs(i);
            count++;
        }
        System.out.println(count);
    }
}