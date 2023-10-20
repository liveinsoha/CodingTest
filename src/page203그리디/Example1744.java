package page203그리디;

import java.io.*;
import java.util.*;
//우선순위 큐는 기본적으로 오름차순으로 정렬한다.poll하면 가장 작은 값부터 나온다.
public class Example1744 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean zero = false;
        int sum = 0;
        int one = 0;
        PriorityQueue<Integer> ppq = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> mpq = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) //0이 있는 경우 없는 겨우에 따라 마지막 1개 남은 애매한 음수를 처리할 수도 있다
                zero = true;
            else if (a == 1) //1은 곱하면 더 손해이다
                one++;
            else if (a > 0)
                ppq.add(a);
            else
                mpq.add(a);
        }

        while (ppq.size() > 1) {
            sum += (ppq.poll() * ppq.poll());
        }
        while (mpq.size() > 1) {
            sum += (mpq.poll() * mpq.poll());
        }
        if (!ppq.isEmpty())
            sum += ppq.poll();
        if (mpq.isEmpty()) //음수 다 비욵경우
            System.out.println(sum + one);
        else { //음수 하나 남은 경우
            if (zero)
                System.out.println(sum + one);
            else
                System.out.println(sum + one + mpq.poll());
        }

    }
}
