package page196그리디;

import java.util.*;

public class Example11047 {
    //그리디 탐욕 알고리즘. 현재 가장 최선에만 집중한다.동전 수를 줄이기 위해 가장 가치가 큰 것부터 개수를 세기 시작한다.
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        int rest = k;
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = sc.nextInt();
        }
        for(int i =0; i<n;i++){
            if(arr[i] <= rest) {
                count += rest / arr[i];
                rest %= arr[i];
            }
        }
        System.out.println(count);
    }
}
