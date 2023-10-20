package page52나머지합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example10986_2 {
    /*수의 개수 10^6, 질문 개수 10^3이므로 질문마다 연산을 진행하면 1초가 넘어간다.
    * 시간복잡도 O(n)의 합배열을 정의하고, 까지의 합을 나누는 수로 나눈 나머지로 바꾸는 나머지 합배열로 바꾼다.
    * 나머지 합 배열이 같은 지점 사이는 구간의 합이 나누는 수 M으로 나누어 떨어짐을 의미한다.
    * 그 구간의 개수는 나머지 합이 같은 곳에서 2개를 뽑는 경우의 수와 같다.
    * */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        long count = 0;

        long[] longArr = new long[n + 1];
        long[] sumArr = new long[n + 1];
        long[] rmdCount = new long[m];
        //숫자 개수 10^6, 나누는 수 10^3, 숫자의 최대 크기 10^9
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            longArr[i] = Long.parseLong(tokenizer.nextToken());
            sumArr[i] = sumArr[i - 1] + longArr[i];
        }

        int remainder; //나머지는 10^3보다 작은 수

        for (int i = 1; i <= n; i++) {
            remainder = (int)(sumArr[i] % m); //int로 캐스틍할 떄 나눈 나머지를 캐스팅해야한다. sumArr먼저 캐스팅하면 int에 안 담긴다
            if(remainder == 0 )
                count++;

            rmdCount[remainder]++; //그래서 여기서 ArrayIndexOutofBounds에러가 난다.
        }

        for (int i = 0; i < m; i++) {
            if (rmdCount[i] > 1) {
                count += rmdCount[i] * (rmdCount[i] - 1) / 2;
            }
        }

        System.out.println(count);

    }
}
