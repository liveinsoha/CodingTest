package page220소수찾기arraylist숫자자리수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Example1456_3 {

    //어떤 제한 숫자 아래에 있느느 모든 소수를 ArrayList를 반환. 소수는 많이 없고 듬성듬성 있어서 Arraylist가 적합하다
    private ArrayList<Integer> getPn(int LIMIT) {
        ArrayList<Integer> pn = new ArrayList<>();
        boolean[] isPn = new boolean[LIMIT+1];
        int sqrtN = (int)Math.sqrt(LIMIT);
        for (int i = 3; i <= sqrtN; i+=2) {
            if (isPn[i]) continue;
            int base = i+i;
            while (base <= LIMIT) {
                isPn[base] = true;
                base+=i;
            }
        }
        pn.add(2);
        for (int i = 3; i <= LIMIT; i+=2) {
            if (!isPn[i]) pn.add(i);
        }
        return pn;
    }

    private int getLength(long num) { //그 숫자가 몇자리인지 확인한는 메소드
        int cnt = 0;
        while (num!=0) {
            cnt++;
            num/=10;
        }
        return cnt;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        ArrayList<Integer> pn = getPn((int)Math.sqrt(b));
        int cnt = 0;
        for (int i = 0; i < pn.size(); i++) {
            long cur = pn.get(i); //소수를 하나씩 꺼내어
            int curCnt = getLength(cur);
            long tmp = cur;
            while ((tmp*=cur)<=b) { //제곱해보면서 주어진 범위 사이에 있는지
                if (a<=tmp)
                    cnt++;
                int tmpCnt = getLength(tmp);
                if (curCnt + tmpCnt > 15) //다음에 올 자리수 체크 : 각 자리수의 합이 15보다 크면 곱해서 15자리가 넘어간다
                    break;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Example1456_3().solution();
    }
}