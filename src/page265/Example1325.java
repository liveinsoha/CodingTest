package page265;

import java.io.*;
import java.util.*;

public class Example1325 {
    static int n;
    static int max = 0;
    static int count;
    static boolean[] visited;
    static boolean[] done;
    static ArrayList<Integer>[] graph;
    static List<Integer> answer = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        done = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!done[i]) {
                work(i);
            }
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void work(int i) {
        count = 0;
        DFS(i);
        if (count > max) {
            max = count;
            answer.clear();
            answer.add(i);
        } else if (count == max) {
            answer.add(i);
        }
        renew();
        visited = new boolean[n + 1];
    }

    public static void renew() {
        for (int i = 1; i <= n; i++) {
            if (!done[i])
                done[i] = visited[i];
        }
    }

    public static void DFS(int s) {
        if (visited[s])
            return;
        visited[s] = true;
        count++;
        for (int i : graph[s]) {
            if (!visited[i])
                DFS(i);
        }
    }
}
