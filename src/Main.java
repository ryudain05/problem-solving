import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        boolean Jolly, sort;
        int curr, diff;


        String s;


        while((s = br.readLine()) != null) {
            st = new StringTokenizer(s);

            Jolly = true;
            sort = true;

            if (!st.hasMoreTokens()) {
                Jolly = false;
                break;
            }


            int N = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());
            int[] res = new int[N + 1];



            for (int i = 1; i < N; i++) {
                curr = Integer.parseInt(st.nextToken());
                diff = Math.abs(curr - prev);


                if (diff <= 0 || diff >= N || res[diff] == 1) {
                    Jolly = false;
                    break;
                }

                if(curr <= prev) {
                    sort = false;
                }

                res[diff] = 1;
                prev = curr;
            }
            if(Jolly) {
                if(sort)System.out.println("Jolly");
                else System.out.println("Little Jolly");
            } else System.out.println("Not Jolly");
        }
    }
}