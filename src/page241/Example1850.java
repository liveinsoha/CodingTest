package page241;

import java.io.*;
import java.util.*;

public class Example1850 {

    public static void main(String[] args) throws Exception{
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long n = gcd(a, b);

        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < n; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
