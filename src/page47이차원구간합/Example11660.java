package page47이차원구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Example11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(tokenizer.nextToken());
        int times = Integer.parseInt(tokenizer.nextToken());

        int[][] intArr = new int[size + 1][size + 1];
        long[][] sumArr = new long[size + 1][size + 1];

        for (int i = 1; i < size + 1; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 1; j < size + 1; j++) {
                intArr[i][j] = Integer.parseInt(tokenizer.nextToken());
                sumArr[i][j] = sumArr[i][j - 1] + sumArr[i - 1][j] + - sumArr[i-1][j-1]+ intArr[i][j];
            }
        } //최대 크기 10^3이므로 중첩반복문을 돌면서 2차원 배열을 생성하는 건 10^6괜찮다. 인덱스 0은 비워둔다
        //질문의 개수가 10^6이므로 주어진 범위마다 합을 구하는 건 안된다.
        //2차원 합 배열을 정의하자! 2차원 구간 합 배열은 D[x][y]는 원본 배열의 (0,0)부터 (X,Y)까지의 합을 의미

        for (int i = 0; i < size + 1; i++) { //검증을 위한 출력
            for (int j = 0; j < size + 1; j++) {
                System.out.print(intArr[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size + 1; j++) {
                System.out.print(sumArr[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < times; i++) {

            tokenizer = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(tokenizer.nextToken());
            int q = Integer.parseInt(tokenizer.nextToken());
            int r = Integer.parseInt(tokenizer.nextToken());
            int s = Integer.parseInt(tokenizer.nextToken());

            System.out.println(sumArr[r][s] - sumArr[r][q - 1] - sumArr[p - 1][s] + sumArr[p - 1][q - 1]);
        }
    }
}
