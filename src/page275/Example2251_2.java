package page275;

import java.util.*;
import java.io.*;

public class Example2251_2 {

    static int[] cpct = new int[3];
    static boolean[][][] visited;
    static Set<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) throws Exception {
        solution();

    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        cpct[0] = a;
        cpct[1] = b;
        cpct[2] = c;
        visited = new boolean[a + 1][b + 1][c + 1];
        int[] first = new int[]{0, 0, c};
        DFS(first);

        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void DFS(int[] now) {
        if (visited[now[0]][now[1]][now[2]])
            return;

        visited[now[0]][now[1]][now[2]] = true;
        if (now[0] == 0)
            set.add(now[2]);

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (i == j)
                    continue;
                if (canPour(i, j, now))
                    DFS(pour(i, j, now));
            }
        }
    }

    public static boolean canPour(int p, int q, int[] now) {
        if (now[p] != 0) {
            if (cpct[q] != now[q]) {
                return true;
            }
        }
        return false;
    }

    public static int[] pour(int p, int q, int[] now) {
        if (now[p] + now[q] <= cpct[q]) {
            int[] next = Arrays.copyOf(now, now.length);
            next[q] = now[p] + now[q];
            next[p] = 0;
            return next;
        } else {
            int[] next = Arrays.copyOf(now, now.length);
            next[q] = cpct[q];
            next[p] = now[p] - (cpct[q] - now[q]);
            return next;
        }
    }
}
