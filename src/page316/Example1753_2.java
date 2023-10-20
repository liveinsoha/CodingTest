package page316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Example1753_2 {
    static int[] distance;
    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    static int V;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];
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

        distance[s] = 0;
        while (true) {
            int min = Integer.MAX_VALUE;
            int idx = 0;

            for (int i = 1; i <= V; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    idx = i;
                }
            }
            if (idx == 0)
                break;

            visited[idx] = true;

            for (Edge next : graph[idx]) {
                if (distance[next.v] > distance[idx] + next.cost)
                    distance[next.v] = distance[idx] + next.cost;
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
