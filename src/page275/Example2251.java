package page275;

import java.util.*;
import java.io.*;

public class Example2251 {

    static Set<List<Node>> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Node> first = new ArrayList<>(List.of(new Node(a, 0), new Node(b, 0), new Node(c, c)));

        nextState(first);

        List<Integer> answer = new ArrayList<>();
        for (List<Node> n : set) {
            if (n.get(0).now == 0)
                answer.add(n.get(2).now);
        }
        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        for(int i : answer){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void nextState(List<Node> state) {
        if (set.contains(state))
            return;

        set.add(state);
        List<Node> copy;

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (i == j)
                    continue;
                if (canPour(state.get(i), state.get(j))) {
                    copy = copy(state);
                    pour(copy.get(i), copy.get(j));
                    nextState(copy);
                }
            }
        }

    }

    public static List<Node> copy(List<Node> origin) {
        return new ArrayList<Node>(List.of(new Node(origin.get(0)), new Node(origin.get(1)), new Node(origin.get(2))));
    }

    public static boolean canPour(Node p, Node q) {
        if (p.now != 0) {
            if (q.now != q.cpct) {
                return true;
            }
        }
        return false;
    }

    public static void pour(Node p, Node q) {
        if (p.now + q.now <= q.cpct) {
            q.now += p.now;
            p.now = 0;
        } else {
            p.now -= (q.cpct - q.now);
            q.now = q.cpct;
        }
    }

    static class Node {
        int cpct;
        int now;

        public Node(int cpct, int now) {
            this.cpct = cpct;
            this.now = now;
        }

        public Node(Node o) {
            this.cpct = o.cpct;
            this.now = o.now;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            else if (o == null || getClass() != o.getClass())
                return false;
            else {
                Node node = (Node) o;
                return this.cpct == node.cpct && this.now == node.now;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(cpct, now);
        }
    }
}
