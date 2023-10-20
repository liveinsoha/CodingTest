package page220소수찾기arraylist숫자자리수;

import java.util.*;

public class Example1456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        int[] arr = new int[(int) Math.sqrt(m) + 1];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] % i == 0)
                        arr[j] = 0;
                }
            }
        }
        long count = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0) {
                for (long j = n; j <= m; j++) {
                    if (j != i && jegob(j,i))
                        count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean jegob(long n, int i) {
        if (n % i == 0){
            if(n/i == 1)
                return true;
            else
                return jegob(n/i,i);
        }else
            return false;
    }

}
