package page207그리디회의실;

import java.util.*;

public class Example1931 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int nowE = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            pq.add(new Node(sc.nextInt(), sc.nextInt()));
        }

        while (true) { //앞에서부터 꽉 채워야(하나라도 더 채워야) 뒤에 생각 없이 더 많이 채우기 좋다.
            while (!pq.isEmpty() && pq.peek().s < nowE) { //끝나는 시각이 가장 빠른 것 부터 채움.
                pq.poll();
            }
            if (pq.isEmpty())
                break;
            nowE = pq.poll().e;
            count++;
        }
        System.out.println(count);
    }

    public static class Node implements Comparable<Node> {
        int s;
        int e;

        @Override
        public int compareTo(Node o) {// 뒤에를 기준(주인공) 삼아 반환값이 양수이면 우선순위가 높다!
            if (o.e == this.e) {
                return this.s - o.s; //끝나는 시각이 같으면 시작 시각이 앞선 것을 우선순위가 더 높도록 해야함.
            }                   // 문제에서 시작시각과 끝나는 시각이 같은 길이 0짜리 회의도 취급해야 하므로.
            else
                return this.e - o.e;
            //끝나는 시간이 작을수록 우선순위 앞선다
        }

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
