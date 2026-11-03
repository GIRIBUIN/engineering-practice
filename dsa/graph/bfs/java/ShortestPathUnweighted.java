import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ShortestPathUnweighted {
    public static void main(String[] args) {
        List<List<Integer>> graph = List.of(
            List.of(1, 2),
            List.of(0, 3, 4),
            List.of(0, 5),
            List.of(1),
            List.of(1),
            List.of(2)
        );

        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, -1);
        
        int start = 3;
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adj : graph.get(node)) {
                if (dist[adj] != -1) continue;
                q.add(adj);
                dist[adj] = dist[node] + 1;
            }
        }

        for (int i=0; i<dist.length; i++) {
            System.out.println(start+" - "+i+": "+ dist[i]);
        }

    }
}
