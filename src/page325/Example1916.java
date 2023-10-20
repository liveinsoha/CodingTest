package page325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Example1916 {
    static int[] cost;
    static ArrayList<Edge>[] graph;
    static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
        if (e1.cost == e2.cost)
            return e1.v - e2.v;
        return e1.cost - e2.cost;
    });

    static int END;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        cost = new int[V + 1];
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[s].add(new Edge(e, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        END = Integer.parseInt(st.nextToken());

        Dijkstra(start);

        System.out.println(cost[END]);

    }

    public static void Dijkstra(int s) {
        pq.add(new Edge(s, 0));
        cost[s] = 0;
        while (!pq.isEmpty()) {

            Edge now = pq.poll();

            if (now.cost > cost[now.v])
                continue;

            if(now.v == END)
                return;
            //cost[now.v] = now.cost;

            for (Edge next : graph[now.v]) {
                if (cost[next.v] > cost[now.v] + next.cost) {
                    cost[next.v] = cost[now.v] + next.cost;
                    pq.add(new Edge(next.v, cost[next.v]));
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
