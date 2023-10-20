package page304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Example1516 {

    static int[] inDegree;
    static ArrayList<Integer>[] graph;
    static Queue<Integer> queue = new LinkedList<Integer>();
    static long[] time;
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        time = new long[n + 1];
        inDegree = new int[n + 1];
        visited = new boolean[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long t = Long.parseLong(st.nextToken());
            time[i] = t;

            while (st.hasMoreTokens()) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1)
                    break;
                graph[b].add(i);
                inDegree[i]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        topology();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(time[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void topology() {
        while (!queue.isEmpty()) {
            int k = queue.poll();
            DFS(k);

            for (int i : graph[k]) {
                inDegree[i]--;
                if (!set.contains(i))
                    time[i] += time[k];

                if (inDegree[i] == 0)
                    queue.add(i);
            }
            set.clear();
            visited = new boolean[n+1];
        }
    }

    public static void DFS(int s) {
        visited[s] = true;
        for (int i : graph[s]) {
            if (!visited[i]) {
                DFS(i);
            } else {
                set.add(i);
            }
        }
    }
}
