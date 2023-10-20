package page287;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example1976 {

    static int[] unf;
    static boolean[][] connected;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        unf = new int[n + 1];
        connected = new boolean[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                connected[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (connected[i][j])
                    union(i, j);
            }
        }

        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        int f1 = find(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < m - 1; i++) {
            if (f1 != find(Integer.parseInt(st.nextToken()))) {
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static int find(int x) {
        if (x == unf[x])
            return unf[x];
        else
            return unf[x] = find(unf[x]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb)
            unf[fa] = fb;
    }
}
