package page304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Example1516_2 {

    static int[] inDegree;
    static ArrayList<Integer>[] graph;
    static Queue<Integer> queue = new LinkedList<Integer>();
    static int[] time;
    static boolean[] visited;
    static int n;
    static int[] result;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        time = new int[n + 1];
        inDegree = new int[n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;

            while (st.hasMoreTokens()) {
                int k = Integer.parseInt(st.nextToken());
                if (k == -1)
                    break;
                graph[i].add(k);
                inDegree[k]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        topology();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void topology() {
        while (!queue.isEmpty()) {
            int s = queue.poll();
            visited = new boolean[n+1];
            DFS(s, time[s], s);

            for (int i : graph[s]) {
                inDegree[i]--;
                if (inDegree[i] == 0)
                    queue.add(i);
            }
        }
    }

    public static void DFS(int s, int w, int v) {
        visited[s] = true;
        if (!graph[s].isEmpty()) {
            for (int i : graph[s]) {
                if (!visited[i]) {
                    DFS(i, w + time[i], v);
                }
            }
        } else {
            if (w > result[v])
                result[v] = w;
        }
        visited[s] = false;
    }
}
