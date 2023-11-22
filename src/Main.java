import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        int total = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(from, to, cost));
            graph[to].add(new Edge(to, from, cost));
            total += cost;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];

        // start from the node 1
        for(Edge e : graph[1]) {
            pq.offer(e);
        }
        visited[1] = true;

        int mst = 0;
        while(!pq.isEmpty()) {
            Edge e = pq.poll();

            if(visited[e.to]) continue;
            visited[e.to] = true;

            mst += e.cost;

            for(Edge ne : graph[e.to]) {
                if(!visited[ne.to]) {
                    pq.offer(ne);
                }
            }
        }

        System.out.println(total - mst);
    }
}
