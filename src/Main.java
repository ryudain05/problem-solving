import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        String M = br.readLine();

        int[] countN = new int[26];
        int[] countM = new int[26];


        for (int i = 0; i < N.length(); i++) {
            countN[N.charAt(i) - 'a']++;
        }

        for (int i = 0; i < M.length(); i++) {
            countM[M.charAt(i) - 'a']++;
        }

        int res = 0;

        for (int i = 0; i < 26; i++) {
            res += Math.abs(countN[i] - countM[i]);
        }

        System.out.println(res);
    }
}
