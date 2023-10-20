package page193이차원배열크기순일차원이진탐색;

import java.util.*;

public class Example1300 {
    static int n;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int min = (int) Math.min(Math.pow(10, 9), Math.pow(n, 2));
        System.out.println(BS(1, min));
    }

    public static int BS(int lo, int hi) {
        if (lo == hi)
            return lo;
        int mid = (lo + hi) / 2;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.min(mid / i, n);
        }
        if (sum >= k) //mid보다 작거나 같은 개수 sum이 원하는 개수 k와 같다고 해서 반드시 mid가 정답은 아니다.
            return BS(lo, mid); //mid값이 배열에 없을 수도 있기 떄문에, hi자리에 mid를 두고 다시 반복
        else
            return BS(mid + 1, hi);
    }
}
