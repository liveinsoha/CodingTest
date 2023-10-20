package page300;

import java.io.*;
import java.util.*;

public class Example2252 {

    static int[] inDegree;
    static ArrayList<Integer>[] graph;
    static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        inDegree = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            inDegree[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {

            int k = queue.poll();
            sb.append(k).append(" ");

            for (int i : graph[k]) {
                inDegree[i]--;
                if (inDegree[i] == 0)
                    queue.add(i);
            }
        }
        System.out.println(sb);
    }
}
