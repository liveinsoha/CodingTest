package page68슬라이드윈도우;

import java.util.*;

public class Example12891 {

    static public class S {
        int a;
        int c;
        int g;
        int t;

        public S(int a, int c, int g, int t) {
            this.a = a;
            this.c = c;
            this.g = g;
            this.t = t;
        }
    }

    static S scan(S s, char c) {

        S nextS = new S(s.a, s.c, s.g, s.t);
        switch (c) {
            case 'A':
                nextS.a++;
                break;
            case 'C':
                nextS.c++;
                break;
            case 'G':
                nextS.g++;
                break;
            case 'T':
                nextS.t++;
                break;
        }

        return nextS;
    }

    static int check(S[] arrS, int m, int a, int c, int g, int t) {
        int count = 0;
        for (int i = 0; i <= arrS.length -1 - m; i++) {
            if(arrS[i+m].a - arrS[i].a >= a && arrS[i+m].c - arrS[i].c >= c
            &&arrS[i+m].g - arrS[i].g >= g  &&arrS[i+m].t - arrS[i].t >= t ) count++;
        }

        return count;

    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        S[] arrS = new S[n + 1];

        sc.nextLine();

        String str = sc.nextLine();
        char[] charArr = str.toCharArray();

        int A = sc.nextInt();
        int C = sc.nextInt();
        int G = sc.nextInt();
        int T = sc.nextInt();

        arrS[0] = new S(0,0,0,0);

        for (int i = 1; i <= n; i++) {
            arrS[i] = scan(arrS[i - 1], charArr[i - 1]);
        }

        int result = check(arrS, m, A, G ,C, T);
        System.out.println(result);

    }
}

