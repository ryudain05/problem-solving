import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[] arr;
    static boolean check = false;

    public static void solve(int idx, int sum, String str) {
        if (sum > M) return;
        if (idx == N) {
            if (sum == M) {
                System.out.println(str.trim());
                check = true;
            }
            return;
        }
        solve(idx + 1, sum + arr[idx], str + arr[idx] + " ");
        solve(idx + 1, sum, str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solve(0, 0, "");

        if (!check)
            System.out.println("NONE");
    }
}
