package page157DFS한길로만나올때FALSE;

import java.io.*;
import java.util.*;

public class Example13023 {
    /*5연속 친구들이 존재하면 1을 아니면 0을 반환한다.
    * exist 불리안 flag을 활용하여 발견 즉시 반환하여 시간복잡도를 낮춘다.
    * 방문후 목표에 도달하지 못하고 리턴할 경우 vistied = false로 바꾸면서
    * 이쪽으로 파고드는 경우는 아님을 나타냄(반환)과 동시에 다른 쪽으로 파고들었을 경우 다시 방문할 수 있도록 한다*/
    static ArrayList<Integer>[] Arr;
    static int count;
    // static Set<Brr> set = new HashSet<Brr>();
    static boolean exist = false;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        Arr = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            Arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            ;
            int v2 = Integer.parseInt(st.nextToken());
            Arr[v1].add(v2);
            Arr[v2].add(v1);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 0);
        }

        /*if(!set.isEmpty()) {
            System.out.println(1);
            return;
        }
        System.out.println(0);*/

        if (exist) {
            System.out.println(1);
            return;
        }
        System.out.println(0);

    }

    public static void dfs(int n, int depth) {//매개값에 현재 방문 숫자 정보와 깊이를 표시
        visited[n] = true;

        if (depth == 4) { //깊이가 4에 다다를 경우 카운팅을 하고 다른 쪽으로 다시 파고들 수 있도록 visted를 false로 바꾸고 return한다.
            exist = true;
            count++;
            visited[n] = false;
            return;
        }

        for (int i : Arr[n]) { //현재 노드에 연결된 노드 중 방문하지 않았으면 dfs시행.
            if (!visited[i])
                dfs(i, depth + 1);
        }
        visited[n] = false; //나올 떄 false
    }

    /*public static class Brr { //연결된 친구가 같은 경우 1개로 처리를 해야하므로 집합을 이용해봤다
        boolean[] arr;

        public Brr(boolean[] visited) {
            this.arr = visited;
        }

        @Override //재정의 하기 위해서 배열을 필드로 갖도록 클래스를 만들어 재정의 함.
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass())
                return false;
            Brr brr = (Brr)o;
            return Arrays.equals(arr, brr.arr); //두 배열 요소가 같으면 같은 객체 취급하겠다
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }*/

}
