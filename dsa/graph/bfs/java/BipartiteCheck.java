import java.util.*;

public class BipartiteCheck {
    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(
            List.of(1, 3),
            List.of(0, 2, 4),
            List.of(1, 5),
            List.of(0, 4),
            List.of(1, 3, 5),
            List.of(2, 4),

            List.of(7, 8),
            List.of(6, 8),
            List.of(6, 7)
        );

        int[] color = new int[graph.size()];
        Arrays.fill(color, -1);

        Queue<Integer> q = new ArrayDeque<>();

        for (int start = 0; start < graph.size(); start++) {
            if (color[start] != -1) continue;

            color[start] = 0;
            q.offer(start);

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int adj : graph.get(node)) {
                    if (color[adj] == -1) {
                        color[adj] = 1 - color[node];
                        q.offer(adj);
                    } else if (color[adj] == color[node]) {
                        System.out.println("not bipartite");
                        return;
                    }
                }
            }
        }

        System.out.println("bipartite");
    }
}