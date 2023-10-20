package page265;

import java.io.*;
import java.util.*;

public class Example1325_3 {
    static int n;
    static int[] counting;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        counting = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            DFS(i);
            visited = new boolean[n + 1];
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (max < counting[i])
                max = counting[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (counting[i] == max)
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }


    public static void DFS(int s) {
        int count = 0;
        if (visited[s])
            return;
        visited[s] = true;
        counting[s]++;
        for (int i : graph[s]) {
            if (!visited[i])
                DFS(i);
        }
    }
}