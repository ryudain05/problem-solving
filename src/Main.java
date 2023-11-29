import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String s1, s2;
    static int[][] dp;
    static String s = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();

        dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        int i = s1.length();
        int j = s2.length();

        for (; i > 0 && j > 0; ) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                s += s1.charAt(i - 1);
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        String reverse = "";
        for (int n = s.length() - 1; n >= 0; n--) {
            reverse = reverse + s.charAt(n);
        }


        if (s.length() == 0) {
            System.out.println("NONE");
        } else {
            System.out.println(reverse.toString());
        }
    }
}
