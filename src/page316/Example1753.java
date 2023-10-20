package page316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Example1753 {
    static int[] distance;
    static ArrayList<Edge>[] graph;
    static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
        if (e1.cost == e2.cost)
            return e1.v - e2.v;
        return e1.cost - e2.cost;
    });

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, w));
        }

        Dijkstra(S);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(distance[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void Dijkstra(int s) {
        pq.add(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.cost > distance[now.v])
                continue;

            distance[now.v] = now.cost;


            for (Edge next : graph[now.v]) {
                if (distance[next.v] > distance[now.v] + next.cost) {
                    distance[next.v] = distance[now.v] + next.cost;
                    pq.add(new Edge(next.v, distance[next.v]));
                }
            }
        }
    }

    public static class Edge {
        int v;
        int cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
