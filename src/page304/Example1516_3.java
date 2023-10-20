package page304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Example1516_3 {

    static int[] inDegree;
    static ArrayList<Integer>[] graph;
    static Queue<Integer> queue = new LinkedList<Integer>();
    static int[] time;
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    static int n;
    static int[] maxtime;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        time = new int[n + 1];
        inDegree = new int[n + 1];
        maxtime = new int[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;

            while (st.hasMoreTokens()) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1)
                    break;
                graph[b].add(i);
                inDegree[i]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        topology();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(time[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void topology() {
        while (!queue.isEmpty()) {
            int s = queue.poll();
            time[s] += maxtime[s]; //이전 경로들에서 들어온 누적값중 최대치와 자기 자신을 짓는 시간을 더한게 최종 결과!

            for (int i : graph[s]) {
                inDegree[i]--;
                maxtime[i] = Math.max(maxtime[i], time[s]);
                /*if (time[s] > maxtime[i]) //다음 누적값에 시도를 한다. 다음 누적값에 있는 값보다 크면 갱신한다.
                    maxtime[i] = time[s];*/
                if (inDegree[i] == 0)
                    queue.add(i);
            }
        }
    }
}