package page175트리의지름;

import java.util.*;
import java.io.*;

/*트리는 사이클이 존재하지 않는 그래프. 모든 노드가 시선에 따라 루트노드가 될 수 있다*/
public class Example1167_2 {

    static LinkedList<int[]>[] Arr;
    static boolean[] visited;
    static int node;
    static int maxlen = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Arr = new LinkedList[n + 1];
        visited = new boolean[n + 1];
        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            Arr[i] = new LinkedList<int[]>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while (st.countTokens() != 1) { //토큰이 1개일 경우 입력 그만 받는다.
                Arr[v].add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
        }

        dfs(1, 0);
        visited = new boolean[n + 1];

        dfs(node, 0);
        System.out.println(maxlen);

    }


    public static void dfs(int s, int w) {

        if (visited[s])
            return;

        visited[s] = true;

        int child = 0;
        for (int[] arr : Arr[s]) {
            if (!visited[arr[0]]) {
                dfs(arr[0], w + arr[1]);
                child++; //자식 노드의 개수 카운팅
            }
        }
        if (child == 0 && w > maxlen) { //자식노드가 없을 경우 말단 노드이다
            maxlen = w; //단말노드에 도착했을 때 마다 가중치를 최대값과 비교히여 크다면 갱신한다.
            node = s;
        } //가장 멀리있는 말단노드는 트리의 지름 양끝 노드 중 하나이다.
        //장 큰 값을 가지는 말단노드로 지정된 이유는 이는 어느 특정 지점에서 모든 말단노드까지 거리 조사를 한경우
        //해당 노드가 가장 큰 결과를 가졌기 떄문이다.
    }
}

