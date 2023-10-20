package page217소수찾기홀수에대해서만배수지우기;

import java.util.*;

public class Example1929 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m + 1];

        for (int i = 2; i <= m; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (arr[i] != 0) {
                for (int j = i + 1; j <= m; j++) {
                    if (arr[j] % i == 0)
                        arr[j] = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n; i <= m; i++) {
            if (arr[i] != 0)
                sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
