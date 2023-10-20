package page269;

import java.io.*;
import java.util.*;

public class Example1707 {

    static ArrayList<Integer>[] graph;
    static Queue<Node> queue = new LinkedList<>();
    static boolean[] visited;
    static boolean[] colored;
    static boolean Bi;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            for (int j = 1; j <= v; j++) {
                graph[j] = new ArrayList<Integer>();
            }

            for (int j = 1; j <= e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            Bi = true;
            queue.clear();
            visited = new boolean[v + 1];
            colored = new boolean[v + 1];

            for (int j = 1; j <= v; j++) {
                if (!visited[j]) {
                    if (!Bi)
                        break;
                    BFS(j);
                }
            }

            if (Bi)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    public static void BFS(int s) {
        Node node = new Node(s, true);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int v = n.v;
            boolean color = n.color;
            if (visited[v]) {
                if (checkColor(v, color))
                    continue;
                else {
                    Bi = false;
                    return;
                }
            }

            visited[v] = true;
            colored[v] = color;
            for (int i : graph[v]) {
                if (visited[i]) {
                    if (checkColor(i, !color))
                        continue;
                    else {
                        Bi = false;
                        return;
                    }
                }
                queue.add(new Node(i, !color));
            }
        }
    }

    public static boolean checkColor(int v, boolean color) {
        if (colored[v] == color)
            return true;
        else
            return false;
    }

    public static class Node {
        int v;
        boolean color;

        public Node(int v, boolean color) {
            this.v = v;
            this.color = color;
        }
    }
}
