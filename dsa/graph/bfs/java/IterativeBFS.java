import java.util.*;

public class IterativeBFS {
    
    public record State(int node, int dist) {}
    
    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(
            List.of(1, 2),
            List.of(0, 3, 4),
            List.of(0, 5),
            List.of(1),
            List.of(1),
            List.of(2)
        );

        Queue<State> q = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.size()];

        q.add(new State(0, 0));
        visited[0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int node = cur.node();
            int dist = cur.dist();

            visited[node] = true;
            System.out.println("Dist " +dist+ ": " + node);

            for (int adj : graph.get(node)) {
                if (visited[adj]) continue;
                visited[adj] = true;
                q.add(new State(adj, dist+1));
            }
        }
    }
}
