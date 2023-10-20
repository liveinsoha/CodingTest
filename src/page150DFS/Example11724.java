package page150DFS;

import java.util.*;
import java.io.*;

public class Example11724 {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<Integer>();
/*연결요소는 그래프를 그림으로 나타내었을 때, 한 번에 연결되어있는 조각을 의미한다.
* 1부터 시작하여 각 숫자를 루프를 돌면서 방문하지 않았으면 dfs를 시행한다.
* dfs 시헹횟수가 곧 연결 요소의 개수와 같다.'
* 그래프가 조각나서 떨어져 있으면 한번의 dfs로 모든 숫자를 방문할 수 없다.*/
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int count = 0;
        A = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<Integer>();
            visited = new boolean[n + 1];
        }
        for (int i = 1; i <= m; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(tokenizer.nextToken());
            int v2 = Integer.parseInt(tokenizer.nextToken());
            A[v1].add(v2);
            A[v2].add(v1);
        }

        for (int i = 1; i <= n; i++){ //루프를 돌며 숫자에 방문화지 않았으면 dfs를 시행
            if(!visited[i]) {
                dfs2(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs1(int s) { //stack을 이용한 dfs 후입선출의 구조로 계속해서 마지막에 들어온 노드 먼저 방문한다.
        StringBuilder sb = new StringBuilder();
        stack.push(s);

        while (!stack.isEmpty()) {
            int k = stack.pop();
            if (visited[k]) //꺼내어서 방문된 적이 있으면 다시 꺼낸다
                continue;
            visited[k] = true;
            sb.append(k).append("->");

            for (int i : A[k]) { //방문한 노드의 인접노드 중 방문하지 않는 노드는 모두 stack에 push한다
                if (!visited[i])
                    stack.push(i);
            }
        }
        System.out.println(sb);
    }


    public static void dfs2(int s) { //재귀를 이용한 dfs

        if (visited[s]) //있으면 더 효율적. 없어도 틀린 건 아니다.
            return;

        visited[s] = true; //방문을 표시

        for (int i : A[s]) { //방문 노드의 인접노드에 대해 dfs를 시행한다. 재귀적으로 동작하므로 가장 먼저 호출된 dfs가 반환되어야 다음 dfs가 호출된다.
            if (!visited[i])
                dfs2(i);
        }
    }
}
