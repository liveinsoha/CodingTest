package page237;

import java.io.*;
import java.util.*;

public class Example1934 {
    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lcm(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) { //n과 0의 최대공약수는 n이다. 0은 모든 수의 배수이므로.
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);

    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
