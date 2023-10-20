package page186이진탐색최대담기;

import java.io.*;
import java.util.*;
/*각 레슨의 길이 중 최대 길이보다 작은값으로 블루레이 길이를 설정하면 그 블루레이에 아에 강의를 못 담는 상황이 발생한다
* 총 48시간의 강의를 4개의 블루레이를 담고 싶다면 블루레이 개당 길이는 최소 12가 되어야하는 건 맞지만, 레슨 길이중 16시간짜리가 있으면
* 블루레이 탐색의 최소값은 16시간이 되어야 맞다. 탐색의 최댓값은 강의 시간의 총합으로 한다. 1개의 블루레이에 담을 수 있는 경우.
* 두 최소 탐색 값과 최대 탐색 값에서 재귀를 이용한 이진 탐색을 시행하여 최적의 길이를 찾는다.
* 원하는 블루레이 개수를 맞추면서 블루레이 size를 줄일 수 있을 때 까지 이진 탐색을 시행한다.  .*/
public class Example2343 {
    static int[] arr;
    static int key;
    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        key = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        int total = 0;
        for(int i = 0; i<n; i++){ //각 레슨 중에서 최대값을 찾고, 레슨 시간의 총합을 구한다
            total += arr[i];
            if(max < arr[i])
                max = arr[i];
        }

       System.out.println(BinaryS(max ,total));
    }

    public static int BinaryS(int lo, int hi) { //이진 탐색으로 최소의 블루레이 길이를 구하는 메소드.
        if (lo > hi)
            return lo;
        int mid = (lo + hi) / 2;
        int count = getCount(mid);

        if (count > key) //원하는 블루레이 수보다 더 많이 나오면 블루레이 size를 늘리기 위해 우측 탐색
            return BinaryS(mid + 1, hi);
        else //원하는 key값 보다 작거나 같으면 블루레이 size를 줄이기 위해 좌측 탐색
            return BinaryS(lo, mid - 1);
    }

    public static int getCount(int size) { //해당 사이즈로 레슨 영상을 받았을 때 몇 개의 블루레이가 필요한지 세는 메소드
        int count = 0;
        int sum = 0;
        int i = 0;
        while (i < n) {
            if (sum + arr[i] <= size) {
                sum += arr[i];
                i++;
            } else {
                sum = 0;
                count++;
            }
        }
        count++;
        return count;
    }
}
