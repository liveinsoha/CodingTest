package page265;

import java.io.*;
import java.util.*;


public class Example1325_2 {
    static int n;
    static boolean[] visited;
    static int[] done; //해킹할 수 있는 컴퓨터 개수를 카운팅 하는 배열.
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        done = new int[n + 1];
        visited = new boolean[n + 1];
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
            if (done[i] == 0) { //센적 없는 정점에 대해서만 DFS수행
                DFS(i);
            }
            visited = new boolean[n + 1]; //방문 배열은 리셋
        }

        int max = done[1];
        for (int i = 1; i <= n; i++) { //최대값을 가지는 정점 찾기.
            if (done[i] > max)
                max = done[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) { //최댓값과 같은 정점 출력하기
            if (max == done[i])
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }


    public static void DFS(int s) {
        if (visited[s])
            return;

        visited[s] = true;

        if (done[s] == 0) { //첫 방문인 경우 카운팅을 수행한다.
            done[s]++; //내거 하나 해킹 가능 +1
            for (int i : graph[s]) {
                DFS(i); //내가 해킹할 수 있는 컴퓨터들 개수 추가 +
                done[s] += done[i];
            }
        } else { //이미 센 적이 있는 정점이라면 다른 정점으로 부터 다시 접근하였을 때 방문을 표시하기 위해 DFS만 수행한다.
            for (int i : graph[s]) {
                DFS(i);
            }
        }
    }
}

