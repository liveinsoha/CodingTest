package page283;

import java.util.*;
import java.io.*;

public class Example1717 {

    static int[] unf;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            unf[i] = i;
        }

        boolean flag;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                flag = find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken()));
                if (flag)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }


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
