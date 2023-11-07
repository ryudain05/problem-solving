

import java.io.*;
import java.util.*;

public class Main {

    static void solve(int n, int w_sum, int[] weights, int DP[][]) {
        for (int i = 1; i < weights.length; i++) {
            DP[i][weights[i]] = 1;
            for (int j = 1; j <= w_sum; j++) {
                if ((j - weights[i] > 0) && DP[i - 1][j - weights[i]] > 0) {
                    if (DP[i - 1][j - weights[i]] + 1 <= (n / 2) + 1)
                        DP[i][j] = DP[i - 1][j - weights[i]] + 1;
                } else if ((j - weights[i]) < 0 && DP[i - 1][j] != 0)
                    DP[i][j] = DP[i - 1][j];
                else if (DP[i - 1][j] != 0)
                    DP[i][j] = DP[i - 1][j];
            }
        }

    }

    static void getAnswer(int n, int w_sum, int DP[][]) {
        ArrayList<Integer> li = new ArrayList<>();
        for (int i = 0; i < w_sum; i++) {
            if (DP[n][i] == (n / 2) + 1 || DP[n][i] == (n / 2))
                li.add(i);
        }
        int max = Integer.MAX_VALUE;
        int s1 = 0;
        int s2 = 0;
        for (int what : li) {
            int diff = Math.abs((w_sum - what) - what);
            if (diff < max) {
                s1 = what;
                s2 = w_sum - what;
                max = diff;
            }
        }
        if (s1 < s2) System.out.printf(s1 + " " + s2);
        else System.out.println(s2 + " " + s1);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int tcN = 0; tcN < tc; tcN++) {
            String blank = br.readLine(); //����
            int n = Integer.parseInt(br.readLine());
            int w_sum = 0;
            int weights[] = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                weights[i] = Integer.parseInt(br.readLine());
                w_sum += weights[i];
            }

            int DP[][] = new int[n + 1][w_sum + 1];
            solve(n, w_sum, weights, DP);

            getAnswer(n, w_sum, DP);
            System.out.println();
        }

    }

}
