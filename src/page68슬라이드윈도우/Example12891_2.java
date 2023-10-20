package page68슬라이드윈도우;

import java.util.*;
import java.io.*;

public class Example12891_2 {

    /*슬라이드 윈도우 윈도우를 밀면서 윈도우에 잡힌 값들이 조건에 맞는지 탐색한다.
    * 배열 S의 길이 만큼만 탐색을 진행하면 되므로 O(n)의 시간 복잡도로 문제를 해결할 수 있다.
    *
    * ^^ 현재 상태 배열을 업데이트 할 때 는 빠지는 문자열, 들어오는 문자열만 보고 업데이트하는 방식으로 진행한다 (핵심)
    * */
    static int[] myArr = new int[4]; //정적 필드는 이 클래스 내에서 계속 공유되고 있다. 오직 하나
    static int[] checkArr = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int count = 0;

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        char[] charArr = br.readLine().toCharArray();

        tokenizer = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        int g = Integer.parseInt(tokenizer.nextToken());
        int t = Integer.parseInt(tokenizer.nextToken());

        checkArr[0] = a;
        checkArr[1] = c;
        checkArr[2] = g;
        checkArr[3] = t;

        for (int i = 0; i < m; i++) {
            cplus(charArr[i]);
        }

        if (check())
            count++;



        for(int i =m; i<n; i++){
            int j = i-m; //for문의 반복 변수가 2개인데 2개를 동시에 증가시키지 못하므로 j와 i를 엮었다
            cminus(charArr[j]);
            cplus(charArr[i]);

           if(check())
               count++;
        }

        System.out.println(count);
    }

    static boolean check() {
        if (myArr[0] >= checkArr[0] && myArr[1] >= checkArr[1] && myArr[2] >= checkArr[2] && myArr[3] >= checkArr[3])
            return true;
        else
            return false;
    }

    static void cplus(char c){ //함수 정의 static main에서 바로 쓰려면 정적 메소드로 선언
        switch (c) {
            case 'A':
                myArr[0]++;
                break;
            case 'C':
                myArr[1]++;
                break;
            case 'G':
                myArr[2]++;
                break;
            case 'T':
                myArr[3]++;
                break;
        }
    }

    static void cminus(char c){
        switch (c) {
            case 'A':
                myArr[0]--;
                break;
            case 'C':
                myArr[1]--;
                break;
            case 'G':
                myArr[2]--;
                break;
            case 'T':
                myArr[3]--;
                break;
        }
    }
}
