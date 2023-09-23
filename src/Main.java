

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            boolean check = false;
            if (!Two(i)) {
                for (int j = 0; j < m; j++) {
                    if (i % list.get(j) == 0) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    sb.append(i).append(" ");
                    count++;
                    if (count >= 100) {
                        break;
                    }
                }
            }
        }

        if (sb.length() < 1) {
            System.out.println("none");
        } else System.out.print(sb.toString().trim());

    }

    static boolean Two(int i) {
        return (i & (i - 1)) == 0;
    }
}
