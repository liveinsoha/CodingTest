package page291;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Example1043 {

    static int[] unf;
    static int[][] come;
    static List<Integer> list = new ArrayList<>();
    static int truth;
    static int party;

    public static void main(String[] args) throws Exception {
        solution();
        System.out.println(party - truth); //거짓말 하는 경우 : 전체 파티 - 진실 말한 수
    }

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        party = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken()); //진실 아는 사람 수

        while (st.hasMoreTokens()) //진실을 알고 있는 사람 번호 리스트에 저장
            list.add(Integer.parseInt(st.nextToken()));

        come = new int[party][n + 1];
        for (int i = 0; i < party; i++) { //m개의 파티에 대해서

            st = new StringTokenizer(br.readLine());
            come[i][0] = Integer.parseInt(st.nextToken()); //파티 온 사람 수 그 줄 0 인덱스에 저장

            int s = Integer.parseInt(st.nextToken()); //처음 온 사람
            come[i][s] = 1; //온 사람은 1로 표기

            while (st.hasMoreTokens()) {
                int p = Integer.parseInt(st.nextToken());
                come[i][p] = 1; //온 사람은 1로 표기
                union(s, p); //처음 온 사람 기준으로 모두 합집합하기. 대표번호가 다르다면 같게한다.
            } // 같은 곳을 바라보게 한다.
        }

        if (!list.isEmpty()) { //진실을 아는 사람들 합집합
            int s = list.get(0);
            for (int i : list) {
                union(s, i);
            }
        }
        int key;
        if (!list.isEmpty()) //IndexOutOfBound 조심. 진실 아는 자가 0명일 수 있다.
            key = find(list.get(0)); //진실을 아는 사람은 모두 합집합 되었고 대표반호 key값을 얻는다
        else {
            truth = 0;
            return;
        }
        for (int i = 0; i < party; i++) { //모든 파티에 대해서
            int j = 1;
            int count = 0;
            while (count < come[i][0]) { //파티 온 사람들 세면서 모두 조사할 때까지.
                if (come[i][j] == 1) {
                    if (find(j) == key) { //key값과 대표번호가 같으면 진싷을 아는 사람이므로 거짓말 못 함.
                        truth++;
                        break;
                    } else {
                        count++;
                    }
                }
                j++;
            }
        }
    }

    public static int find(int x) {
        if (x == unf[x])
            return unf[x];
        else
            return unf[x] = find(unf[x]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb)
            unf[fa] = fb;
    }
}
