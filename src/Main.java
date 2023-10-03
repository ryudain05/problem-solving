import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean isNumeric(char x) {
        return x >= '0' && x <= '9';
    }

    private static boolean matchExact(String s1, String s2) {
        return s1.equals(s2);
    }

    private static boolean matchNumeric(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            while (i < s1.length() && !isNumeric(s1.charAt(i))) {
                i++;
            }
            while (j < s2.length() && !isNumeric(s2.charAt(j))) {
                j++;
            }
            if (i < s1.length() && j < s2.length() && s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return i >= s1.length() && j >= s2.length();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine().trim());
        int t = 0;

        while (n > 0) {
            StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < n; i++) {
                s1.append(reader.readLine()).append("\n");
            }
            int m = Integer.parseInt(reader.readLine().trim());
            StringBuilder s2 = new StringBuilder();
            for (int i = 0; i < m; i++) {
                s2.append(reader.readLine()).append("\n");
            }
            t++;
            System.out.print("Run #" + t + ": ");
            if (matchExact(s1.toString(), s2.toString())) {
                System.out.println("Accepted");
            } else if (matchNumeric(s1.toString(), s2.toString())) {
                System.out.println("Presentation Error");
            } else {
                System.out.println("Wrong Answer");
            }
            n = Integer.parseInt(reader.readLine().trim());
        }

        reader.close();
    }
}
