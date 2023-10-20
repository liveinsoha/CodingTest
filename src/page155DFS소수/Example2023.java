package page155DFS소수;

import java.io.*;

/*신기한 숫자를 찾는다.
* 숫자를 붙여나가며 소수이면 계속해서 dfs를 시행하고 일정 깊이가 되면 출력하며 카운팅한다.
* dfs 해나가면서 소수가 아니면 return하여 재귀를 끝낸다.
* dfs함수에는 매개값으로 숫자와 깊이의 정보가 있어야 한다.*/
public class Example2023 {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);


    }

    public static void dfs(int n, int jrs) {
        if (jrs == N) {
            System.out.println(n);
            return;
        }
        for (int i = 0; i < 5; i++) {
            int d = 2 * i + 1; //뒤에 자리에 홀수가 붙어야 소수가 될 가능성이 있다
            if (sosu(n * 10 + d)) //소수인 경우 dfs를 시행한다.
                dfs(n*10+d, jrs+1); //자리수는 하나 더하며 시행
        }
        return;
    }

    public static boolean sosu(int n) {//소수인지 판별하는 함수
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
