package page165DFSBFS;

import java.util.*;
import java.io.*;
/*우선순위 큐로 하면 안 됨..
* */
public class Example1260 {

    static boolean[] visited;
    static LinkedList<Integer>[] pqArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        pqArr = new LinkedList[n+1];
        for(int i=1; i<=n; i++){
            pqArr[i] = new LinkedList<Integer>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            pqArr[v1].add(v2);
            pqArr[v2].add(v1);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(pqArr[i]); //각 연결리스트에 대해 오름차순으로 정렬한다.
        }

        visited = new boolean[n+1];
        dfs(s);
        System.out.println();
        visited = new boolean[n+1];
        bfs(s);
    }

    static StringBuilder sb = new StringBuilder();

    public static void dfs(int s) {
        if (visited[s])
            return;
        visited[s] = true;
        System.out.print(s + " ");
        for (int i : pqArr[s]) {
            if (!visited[i])
                dfs(i);
        }
    }

    public static void bfs(int s) {

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        q.add(s);

        while (!q.isEmpty()) {
            int d = q.poll();

            if (visited[d]) //꺼내고 방문하였으면 다시 꺼냄.
                continue;

            visited[d] = true;
            System.out.print(d + " ");

            for (int i : pqArr[d]) {
                if (!visited[i]) //인접노드 중 방문하지 않은 노드를 q에 add한다
                    q.add(i);
            }
        }
    }
}
