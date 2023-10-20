package page139기수정렬;

import java.io.*;

public class Example10989_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        radixSort(arr, max); //최댓값을 넘겨주고 메소드 안에서 최대값의 자리수를 판단

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void radixSort(int[] arr, int max) {

        int k = (int) Math.log10(max) + 1;
        int[] output = new int[arr.length];
        int[] bucket = new int[10];

        for (int i = 0; i < k; i++) {
            int jrs = (int) Math.pow(10, i);

            for (int j = 0; j < arr.length; j++) {
                int bIdx = (arr[j] / jrs) % 10;
                bucket[bIdx]++;
            }
            //각 버킷의 데이터 개수를 이용해서(합을 이용) output배열의 인덱스 처리
            for (int j = 1; j < 10; j++) {
                bucket[j] += bucket[j - 1];
            }
            for (int j = arr.length - 1; j >= 0; j--) { //outputIdx를 이용한 정렬. 뒤에서 부터 하는 이유는 인덱스를 하나씩 작게하며 출력하므로,뒤에서 부터 처리해야 크기순을 지킬 수 있다.
                int outputIdx = bucket[(arr[j] / jrs) % 10] - 1;
                output[outputIdx] = arr[j];
                bucket[(arr[j] / jrs) % 10]--;
            }
            for (int j = 0; j < arr.length; j++) {
                arr[j] = output[j];
            }

            for (int j = 0; j < 10; j++) {
                bucket[j] = 0;
            }
        }
    }
}
