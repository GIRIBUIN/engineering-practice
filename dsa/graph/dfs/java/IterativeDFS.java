import java.util.List;
import java.util.Stack;

public class IterativeDFS {
    static List<List<Integer>> graph;
    static boolean[] visited;
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

        Stack<Integer> s = new Stack<>();
        
        s.push(0);
        visited[0] = true;

        while(!s.empty()) {
            int node = s.pop();

            System.out.print(node+" ");

            for (int adj : graph.get(node).reversed()) {
                if (!visited[adj]){
                    visited[adj] = true;
                    s.push(adj);
                }
            }
        }
    }
}