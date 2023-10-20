package page171BFS는한단계씩;

import java.io.*;
import java.util.*;
/*dfs로 해보고 bfs로 해보았다.
* bfs가  모든 가능성에 대해 하나의 단계씩 한 번에 수행하기 때문에 먼저 목적지에 도달할 경우
* 바로 끝낼 수 있어 시간복잡도 면에서 유리하다.
* bfs함수는 모든 방향에 대해서 행렬 내의 범위이고, 방문할 수 있고, 방문하지 않았으면 방문한다.
* 이떄 Queue에 add되는 객체는 현재 위치 정보와 깊이 정보를 담고 있어야 하므로 Queue<int[]>로 구현하였다
* Q에서 poll했을 때 위치정보가 목적지와 같으면 즉시 리턴하고, 깊이정보를 출력한다
* dfs로 시행하는 것은 여러 가능성을 모두 시행해보고 최소인 경우를 채택해야 하므로 시간적 낭비가 심할 수 있다 -> 시간초과*/
public class Example2178 {
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static int M;
    static int min = 0;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j + 1] = c[j] - '0';
            }
        }
        dfs(1, 1, 1); //(1,1)에서 깊이 1에서 시작
        System.out.println(min);
        bfs(new int[]{1,1,1});
    }

    public static void dfs(int n, int m, int d) {
        if (n == N && m == M) {
            if (min == 0) { //처음엔 최솟값보다 클 수 밖에 없으므로 처음 도달 값을 최솟값으로 설정
                min = d;
                visited = new boolean[N + 1][M + 1];
                return;
            } else {
                if (d < min) { //도달 했는데 최솟값보다 작을 시 최솟값을 변경
                    min = d;
                    visited = new boolean[N + 1][M + 1];
                    return;
                }//모두 리턴하기 전에 방문노드를 초기화 하는데 틀린 것 같다.
            }
        }

        if (min != 0 && d >= min) {
            visited = new boolean[N + 1][M + 1];
            return;
        }
        visited[n][m] = true;

        if (n + 1 <= N && arr[n + 1][m] == 1 && !visited[n + 1][m])
            dfs(n + 1, m, d + 1);
        if (n - 1 >= 1 && arr[n - 1][m] == 1 && !visited[n - 1][m])
            dfs(n - 1, m, d + 1);
        if (m + 1 <= M && arr[n][m + 1] == 1 && !visited[n][m + 1])
            dfs(n, m + 1, d + 1);
        if (m - 1 >= 1 && arr[n][m - 1] == 1 && !visited[n][m - 1])
            dfs(n, m - 1, d + 1);
    }

    public static void bfs(int[] brr) {
        q.add(brr);

        while (true) { //계속해서 반복
            int[] drr = q.poll();
            int n = drr[0];
            int m = drr[1];
            int d = drr[2];

            if (!visited[n][m]) { //꺼냈는데 방문했던 노드일 경우 아무 것도 하지 않는다
                visited[n][m] = true;

                if (n == N && m == M) { //현재 방문 노드가 목적지이면 깊이를 출력하고 즉시 리턴.
                    System.out.println(d);
                    return;
                }
                //4개의 방향에 대해 조건을 만족하면 q에 add한다
                if (n + 1 <= N && arr[n + 1][m] == 1 && !visited[n + 1][m])
                    q.add(new int[]{n + 1, m, d + 1});
                if (n - 1 >= 1 && arr[n - 1][m] == 1 && !visited[n - 1][m])
                    q.add(new int[]{n - 1, m, d + 1});
                if (m + 1 <= M && arr[n][m + 1] == 1 && !visited[n][m + 1])
                    q.add(new int[]{n, m + 1, d + 1});
                if (m - 1 >= 1 && arr[n][m - 1] == 1 && !visited[n][m - 1])
                    q.add(new int[]{n, m - 1, d + 1});
            }
        }
    }
}
