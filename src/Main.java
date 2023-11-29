import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, count = 0;
    static boolean[] visit;
    static Integer[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        memo = new Integer[N + 1];
        memo[0] = 1;

        for (int i = 0; i < K; i++) {
            int j = Integer.parseInt(br.readLine());
            visit[j] = true;
        }

        System.out.println(check(N));
    }

    static int check(int n) {
        if (n < 0) {
            return 0;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        if (!visit[n]) {
            for (int i = 1; i <= M; i++) {
                count += check(n - i);
            }
        }
        return memo[n] = count;
    }
}
