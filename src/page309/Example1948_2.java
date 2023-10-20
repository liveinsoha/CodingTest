package page309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Example1948_2 {

    static ArrayList<Edge>[] graph;
    static ArrayList<Edge>[] Rgraph;
    static int[] inDegree; //진입차수 배열
    static Queue<Integer> queue = new LinkedList<>();
    static int[] maxTime; // 내개 진입하는 경로중 최대 시간(가중치)를 가진 경로를 표시하기 위함(누적된 시간 표기)
    //static Set<Edge> set = new HashSet<>();
    static boolean[][] visited; //역그래프 최장시간 경로 추출할 때 중복 카운팅 방지를 위한 배열
    static int count;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        Rgraph = new ArrayList[V + 1];
        inDegree = new int[V + 1];
        maxTime = new int[V + 1];
        visited = new boolean[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            Rgraph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            inDegree[e]++;
            graph[s].add(new Edge(s, e, w));  //그래프를 나타내는 인접 리스트 배열을 채워준다
            Rgraph[e].add(new Edge(e, s, w)); //역방향 그래프도 만들어준다 역으로 돌아가며 빨리 달려야만 하는 엣지를 찾기 위해.
        }
        //역방향그래프는 모든 경로를 탐색하는 것이 아닌, 빠르게 지니야만 하는, 즉, 시간이 오래 걸리는 경로만을 찾기 위한 것이다.
        //역방향 그래프는 진입차수 배열이 필요없다.

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        queue.add(start);
        topology();
        System.out.println(maxTime[end]);

        queue.add(end);
        countRun();
        System.out.println(count);
    }


    public static void topology() {
        while (!queue.isEmpty()) {
            int s = queue.poll();

            for (Edge e : graph[s]) {
                inDegree[e.e]--;
                if (e.w + maxTime[s] > maxTime[e.e]) {
                    maxTime[e.e] = e.w + maxTime[s]; //직전 정점은 거꾸로 돌아가면서 탐색 할 것이므로, 이전 정점 정보 저장x
                } //걸리는 시간을 기반으로 거꾸로 돌아가며 최장시간 소요되는 특정 경로를 찾을 것이다.

                if (inDegree[e.e] == 0)
                    queue.add(e.e);
            }
        }
    }

    public static void countRun() {
        while (!queue.isEmpty()) {
            int s = queue.poll();

            for (Edge e : Rgraph[s]) {
                if (maxTime[s] - e.w == maxTime[e.e] && !visited[s][e.e]) {
                    visited[s][e.e] = true; //세기만 하고 q에 넣지 않는 방법도 있다 (일차원 방문배열)
                    queue.add(e.e);
                    count++;
                }
            }

        }
    }

    public static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

    }
}
