package page133버블소트swap머지소트;

/*버블소트에서 swap이 일어난 총 횟수는 각 숫자가 제 자리로 가기 위해 움직이는데,
 * 각 숫자들에 대해 자신의 뒤에 있는 수들 중 자신보다 작은 숫자 개수의 합만큼 swap이 일어난다.
 * 거꾸로 말하면
 * 각 숫자에 대해 자신의 앞에 있는 수들 중 자신보다 큰 숫자 개수의 합만큼 swap이 일어난다
 *
 * 다만 이걸 세는 경우의 수도 중첩 반복문이므로 n^2의 시간복잡도로 크다.
 * 머지소트에서 발생하는 뒤에서 앞으로 인덱스 이동의 수를 모두 더해준다.
 * merge시에 rIdx 정렬 시점에서 왼쪽 배열에 정렬되지 않은 수가 몇개 남았는지가 뒤에서 앞으로의 인덱스 이동수와 같다.
 * result += (mid - lIdx)+1 */

//같을 떈 swap안 함. result의 범위가 21억이 넘어갈 수 있으므로 long타입으로 지정
import java.io.*;
import java.util.*;

public class Example1517 {

    static int[] sorted;
    static int[] arr;
    static long result = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        sorted = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        sort();

        System.out.println(Arrays.toString(arr));

        System.out.println(result);
    }

    public static void sort() {
        mergeSort(0, arr.length - 1);
    }

    public static void mergeSort(int left, int right) {

        if (left == right)
            return;

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    public static void merge(int left, int mid, int right) {
        int lIdx = left;
        int rIdx = mid + 1;
        int idx = left;

        while (lIdx <= mid && rIdx <= right) {

            if (arr[lIdx] <= arr[rIdx]) {
                sorted[idx] = arr[lIdx];
                idx++;
                lIdx++;
            } else {
                sorted[idx] = arr[rIdx];
                idx++;
                rIdx++;
                result += (mid - lIdx) + 1;
            }
        }

        if (lIdx > mid) {
            while (rIdx <= right) {
                sorted[idx] = arr[rIdx];
                idx++;
                rIdx++;
            }
        } else {
            while (lIdx <= mid) {
                sorted[idx] = arr[lIdx];
                idx++;
                lIdx++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}
