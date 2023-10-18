import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            List<Integer> list = fibo(M);
            System.out.println(sum(list, M));
        }
    }

    static List<Integer> fibo(int m) {
        List<Integer> list = new ArrayList<>();

        int a = 1;
        int b = 2;
        int c;

        list.add(a);
        list.add(b);

        while (true) {
            c = a + b;
            if (c <= m) {
                list.add(c);
            } else {
                break;
            }
            a = b;
            b = c;
        }

        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    static int sum(List<Integer> fibo, int m) {
        int sum = 0;

        for (int num : fibo) {
            if (num <= m) {
                sum += num * num;
                m -= num;
            }
            if (m == 0) {
                break;
            }
        }
        return sum;
    }
}
