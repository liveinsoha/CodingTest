package page44구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example11659_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer tokenizer = new StringTokenizer(str);

        int size = Integer.parseInt(tokenizer.nextToken());
        int times = Integer.parseInt(tokenizer.nextToken());

        long[] sumArr = new long[size + 1];

        str = br.readLine();
        tokenizer = new StringTokenizer(str);

        for (int i = 1; i < size + 1; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(tokenizer.nextToken());
        }


        for (int i = 0; i < times; i++) {
            str = br.readLine();
            tokenizer = new StringTokenizer(str);
            int startIdx = Integer.parseInt(tokenizer.nextToken());
            int endIdx = Integer.parseInt(tokenizer.nextToken());
            System.out.println(sumArr[endIdx]-sumArr[startIdx-1]);
        }

    }
}

/*수의 개수도 10^5이고 합 구하는 횟수도 10^5이므로 주어진 구간마다 매번 합을 계산하면 O(n^2)으로 끝낼 수 없다.
구간합 배열을 이용한다. S[i] = S[i-1] + a[i]
구간합 배열을 이용하면 시간복잡도 O(n)선(처음 구간합 배열 구하기 반복문)에서 연산을 끝낼 수 있다.
주어진 구간의 인덱스만 가지고 차를 구하면 되기 때문에
인덱스를 잘 다루기 위해 i번쨰 숫자 까지의 합을 S[i]라고 정의
0번쨰 인덱스는 비워두자*/
