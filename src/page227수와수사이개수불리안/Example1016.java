package page227수와수사이개수불리안;

import java.util.*;
import java.io.*;

public class Example1016 {

    public static void main(String[] args) throws Exception {
        solution();
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        System.out.println(countJnn(min, max));

    }

    public static long countJnn(long min, long max) {
        long count =0;
        boolean[] notJnn = new boolean[(int)(max-min+1)];

        int limit = (int) Math.sqrt(max);
        ArrayList<Long> pnsq = getPnSq(limit);

        for (long l : pnsq) {
            long base = l;
            while (base <= max) {
                if (base >= min) {
                    notJnn[(int)(base-min)] = true;
                }
                base += l;
            }
        }
        for(boolean b : notJnn){
            if(!b)
                count++;
        }
        return count;
    }

    public static ArrayList<Long> getPnSq(int limit) {
        ArrayList<Long> pnsq = new ArrayList<>();
        boolean[] notPn = new boolean[limit + 1];
        int sqrt = (int) Math.sqrt(limit);
        for (int i = 3; i <= sqrt; i += 2) {
            if (!notPn[i]) {
                int base = i + i;
                while (base <= limit) {
                    notPn[base] = true;
                    base += i;
                }
            }
        }

        if (limit >= 2)
            pnsq.add((long) 2 * 2);
        for (int i = 3; i <= limit; i += 2) {
            if (!notPn[i]) {
                pnsq.add((long) i * i);
            }
        }
        return pnsq;
    }
}
