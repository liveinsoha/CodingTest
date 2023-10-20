package page309;

import java.util.*;
import java.io.*;

public class Example1948 {
    static Set<String> set = new HashSet<>();
    static ArrayList<Edge>[] graph;
    static int[] inDegree;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] maxtime;
    static List<Integer>[] maxback;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList[V + 1];
        inDegree = new int[V + 1];
        maxtime = new int[V + 1];
        maxback = new List[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            maxback[i] = new ArrayList<>();
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s].add(new Edge(e, w));
            inDegree[e]++;
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        queue.add(s);
        topology();

        queue.add(e);
        countRun();

        System.out.println(maxtime[e]);
        System.out.println(set.size());
    }

    public static void topology() {
        while (!queue.isEmpty()) {
            int s = queue.poll();

            for (Edge e : graph[s]) {

                inDegree[e.v]--;
                if (maxtime[s] + e.w > maxtime[e.v]) {
                    maxback[e.v].clear();
                    maxtime[e.v] = maxtime[s] + e.w;
                    maxback[e.v].add(s);
                } else if (maxtime[s] + e.w == maxtime[e.v]) {
                    maxback[e.v].add(s);
                }

                if (inDegree[e.v] == 0)
                    queue.add(e.v);
            }
        }
    }

    public static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void countRun() {
        while (!queue.isEmpty()) {
            int b = queue.poll();
            for (int bb : maxback[b]) {
                queue.add(bb);
                set.add(Arrays.toString(new int[]{b, bb}));
            }
        }
    }

}
