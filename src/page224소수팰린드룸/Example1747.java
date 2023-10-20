package page224소수팰린드룸;

import java.util.*;
import java.io.*;

public class Example1747 {
    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> pn = getPn(n);

        int i = 0;
        while (true) {
            int sosu = pn.get(i);
            if (palin(sosu)) {
                System.out.println(sosu);
                break;
            }
            i++;
        }
    }

    public static ArrayList<Integer> getPn(int limit) {
        ArrayList<Integer> pn = new ArrayList<>();
        int boundary = limit * 10;
        boolean[] notPn = new boolean[boundary + 1];
        int sqrt = (int) Math.sqrt(boundary);
        for (int i = 3; i <= sqrt; i += 2) {
            if (!notPn[i]) {
                int base = i + i;
                while (base <= boundary) {
                    notPn[base] = true;
                    base += i;
                }
            }
        }
        if (2 >= limit)
            pn.add(2);
        for (int i = 3; i <= boundary; i += 2) {
            if (!notPn[i] && i >= limit)
                pn.add(i);
        }
        return pn;
    }

    public static boolean palin(int n) {
        char[] cArr = String.valueOf(n).toCharArray();//숫자를 ->문자열 -> charArray순으로 바꾸어 index 비교한다.
        for (int i = 0; i < cArr.length / 2; i++) {
            if (cArr[i] != cArr[cArr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
