package page104버블소트정렬끝;

import java.io.*;
import java.util.*;

public class Example1377_1 {

    public static void main(String[] args) throws Exception {
        //실제 값과 초기 인덱스를 map컬렉션으로 저장하려 했으나 값이 같은 경우 키가 같아지므로 구현하지 못한다.
        //필드로 실제값과 초기 인덱스를 가지는 클래스를 정의하고 값에 대해서 오름차순 정렬하고 제일 많이 왼쪽으로 이동한'
        //곳을 찾는다. 그 이후부터는 버블 소트가 일어나지 않는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] idxDiff = new int[n];
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], i);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            idxDiff[i] = map.get(arr[i]) - i;
            if (max <= idxDiff[i]) {
                max = idxDiff[i];
            }
        }

        System.out.println(max+1);
    }
}