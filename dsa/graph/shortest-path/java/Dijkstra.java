import java.util.*;

public class Dijkstra {
    
    record Edge(int to, int weight) {}
    record State(int node, int dist) {}
    /*
    record State(int node, int dist) implements Comparable<State> {

        @Override
        public int compareTo(State other) {
            return Integer.compare(this.dist, other.dist);
        }
    }
    */
    public static void main(String[] args) {    
        List<List<Edge>> graph = List.of(
            List.of(new Edge(1, 4), new Edge(2, 1)),
            List.of(new Edge(0, 4), new Edge(2, 2), new Edge(3, 5), new Edge(4, 1)),
            List.of(new Edge(0, 1), new Edge(1, 2), new Edge(4, 4)),
            List.of(new Edge(1, 5), new Edge(5, 3)),
            List.of(new Edge(1, 1), new Edge(2, 4), new Edge(5, 1)),
            List.of(new Edge(3, 3), new Edge(4, 1))
        );

        Queue<State> q = new PriorityQueue<>(
            Comparator.comparingInt(State::dist)
        );
        
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        int start = 0;
        q.add(new State(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            State cur = q.poll();
            int node = cur.node();
            int curDist = cur.dist();

            if (curDist != dist[node]) continue; // 해당 노드의 dist 후보가 여러 개 들어가는데 제일 작은 거 빼고 무시

            for (Edge edge : graph.get(node)) {
                int nxt = edge.to();
                int nxtDist = curDist + edge.weight();

                if (nxtDist >= dist[nxt]) continue;

                dist[nxt] = nxtDist;
                q.add(new State(nxt, nxtDist));
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(start + " -> " + i + ": " + dist[i]);
        }

    }
}
