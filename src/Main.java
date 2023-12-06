import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] memo = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        if (N != 1) {
            memo[0] = arr[0];
            memo[1] = arr[1];

            for (int i = 2; i < N; i++) {
                int a = memo[i - 2];
                int b = memo[i - 1];
                int c = Math.min(a, b);

                memo[i] = c + arr[i];
            }

            System.out.println(Math.min(memo[N - 1], memo[N - 2]));
        } else {
            System.out.println(0);
        }
    }
}