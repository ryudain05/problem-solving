import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        System.out.println(result(s, N));
    }

    public static String result(String s, int max) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); ) {
            String str = null;
            int num = 0;
            int len = 1;

            for (; len <= max && i + len <= s.length(); ++len) {
                String substr = s.substring(i, i + len);
                int count = countRe(s, substr, i);

                if (count > num || (count == num && len > str.length())) {
                    str = substr;
                    num = count;
                }
            }

            if (str.length() > 1)
                result.append(str.toUpperCase()).append(num);
            else
                result.append(str).append(num);

            i += str.length() * num;
        }

        return result.toString();
    }

    private static int countRe(String s, String str, int start) {
        int count;

        for (count = 0; start + str.length() * (count + 1) <= s.length(); ++count)
            if (!str.equals(s.substring(start + str.length() * count,
                    start + str.length() * (count + 1))))
                break;

        return count;
    }
}