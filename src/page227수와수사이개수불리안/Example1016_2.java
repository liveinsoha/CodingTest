package page227수와수사이개수불리안;

import java.io.*;
import java.util.*;

public class Example1016_2 {
    public static void main(String[] args) throws Exception {
        solution();

    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        System.out.println(getCount(min, max));
    }

    public static long getCount(long min, long max) {
        long count = 0;
        boolean[] notjnn = new boolean[(int) (max - min + 1)];

        for (int i = 2; (long)i * i <= max; i++) { //for문의 사용 활용하자
            long pow = (long)i * i;
            long startj = min / pow; //나눈 몫부터 시작!
            if (min % pow != 0)
                startj++;
            for (long j = startj; j * pow <= max; j++) {
                notjnn[(int) (pow * j - min)] = true;
            }
        }
        for (int i = 0; i < notjnn.length; i++) {
            if (!notjnn[i])
                count++;
        }
        return count;
    }
}
