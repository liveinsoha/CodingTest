package page74슬라이드윈도우덱;

import java.util.*;
import java.io.*;

/*일반적으로 정렬은 nlog(n)의 시간복잡도를 가지므로 최대범위가 5*10^6인 이 문제에서 정렬을 사용할 수 없다
 * 시간 복잡도 O(n)으로 해결해야 한다. 슬라이딩 윈도우를 덱으로 구현하여 정렬효과도 동시에 볼 수 있다
 * 덱에 노드를 넣을 땨 값을 비교하여 정렬이 되도록 할 수 있다*/

public class Example11003 {
    public static void main(String[] args) throws Exception {
        Deque<int []> deque = new ArrayDeque<int []>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer t = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(t.nextToken());
        int m = Integer.parseInt(t.nextToken());
        t = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(t.nextToken());
            while (!deque.isEmpty() && (deque.getLast()[1] > v)) deque.removeLast();
            deque.addLast(new int[] {i, v});
            if (deque.getFirst()[0] <= i - m) deque.removeFirst();
            bw.write(deque.getFirst()[1] + " ");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}


