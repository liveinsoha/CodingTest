package page183이진탐색;

import java.io.*;
import java.util.*;

public class Example1920_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
//이진 탐색은 찾는 대상 배열이 정렬되어 있을 때만 시행할 수 있다.
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            int lo = 0; //찾는 대상 배열의 인덱스
            int hi = n - 1;

           sb.append(BinarySearch(arr,0,n-1,key)).append("\n");
        } //중간값의 value와 키값을 비교해서 작으면 왼쪽을, 크면 오른쪽을 재귀적으로 탐색한다.
        System.out.println(sb);
    }

    public static int BinarySearch(int[] arr, int lo, int hi, int key){
        while (lo <= hi) {

            int mid = (lo + hi) / 2;
            if (arr[mid] == key) {
                return 1;
            }
            else if (arr[mid] < key)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return 0;
    }
}
