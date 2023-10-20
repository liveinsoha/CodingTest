package page243;


import java.io.*;
import java.util.*;

public class Example1033_2 {

    static boolean[] visited;
    static long[] value;
    static ArrayList<Node>[] graph;
    static int size;

    public static void main(String[] args) throws Exception {
        solution();
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        visited = new boolean[size];
        value = new long[size];
        long mul = 1;

        graph = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < size - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c, d));
            graph[b].add(new Node(a, d, c));
            mul *= c * d;
        }
        value[0] = mul;
        dfs(0);
        long gcd = getGCD(value);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            value[i] = value[i] / gcd;
            sb.append(value[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int s) {
        if (visited[s])
            return;
        visited[s] = true;
        for (Node node : graph[s]) {
            if (!visited[node.v]) {
                value[node.v] = value[s] * node.n / node.m;
                dfs(node.v);
            }
        }
    }

    static class Node {
        int v;
        int m;
        int n;

        public Node(int v, int m, int n) {
            super();
            this.v = v;
            this.m = m;
            this.n = n;
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static long getGCD(long[] arr) {
        if (arr.length == 1)
            return arr[0];
        long v = gcd(arr[0], arr[1]);
        for (int i = 1; i < arr.length - 1; i++) {
            v = gcd(v, arr[i + 1]);
        }
        return v;
    }
}
