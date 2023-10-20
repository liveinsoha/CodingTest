package page261;

import java.io.*;
import java.util.*;

public class Example18352 {
    static int k;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static List<Integer> list = new LinkedList<Integer>();

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        BFS(s);

        if (list.isEmpty())
            System.out.println(-1);
        else {
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (int i : list) {
                sb.append(i).append("\n");
            }
            System.out.println(sb);
        }

    }

    public static void BFS(int s) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(s,0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int v = node.v;
            int d = node.d;

            if(visited[v])
                continue;

            visited[v] = true;
            if(d == k){
                list.add(v);
                continue;
            }

            for(int i : graph[v]){
                if(!visited[i])
                    queue.add(new Node(i, d+1));
            }
        }
    }

    public static class Node {
        int v;
        int d;

        public Node(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }

}
