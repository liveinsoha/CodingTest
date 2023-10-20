package page220소수찾기arraylist숫자자리수;

import java.io.*;
import java.util.*;

public class Example1456_4 {
    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long count = 0;
        ArrayList<Integer> pn = getPn((int)Math.sqrt(m));
        for (long i : pn) {
            long base = i * i;
            while (base <= m) {
                if (base >= n) {
                    count++;
                }
                if (getLength(i) + getLength(base) > 15)
                    break;
                base *= i;
            }
        }
        System.out.println(count);
    }

    public static ArrayList<Integer> getPn(int limit){
        ArrayList<Integer> pn = new ArrayList<>();

        boolean[] notPn = new boolean[(int)limit + 1];
        int sqrt = (int) Math.sqrt(limit);
        for (int i = 3; i <= sqrt; i += 2) { //3부터 홀수만
            if (!notPn[i]) { //소수가 아닌 것을 체크한다. 전체에 대해서 나눈 다음 나누어떨어지는지 확인하는 것보단
                int base = i + i;   //소수의 배수들에 대하여 소수가 아님을 체크한다!
                while (base <= limit) {
                    notPn[base] = true;
                    base += i;
                }
            }
        }
        pn.add(2); //2는 소수니까 List에 추가해주고
        for (int i = 3; i < notPn.length; i += 2) { //홀수중에서만 소수인 것을 찾아 List에 추가한다
            if (!notPn[i])
                pn.add(i);
        }

        return pn;
    }


    public static int getLength(long l) {
        int count = 0;
        while (l != 0) {
            l /= 10;
            count++;
        }
        return count;
    }
}
