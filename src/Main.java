import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine().toUpperCase();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') {
                sb.append(" ");
            }
            else if(N > 26) {
                N = N % 26;
                char ch = (char) (s.charAt(i) + N);
                sb.append(ch);
            }
            else {
                char ch = (char) (s.charAt(i) + N);
                if(ch > 'Z') {
                    ch = (char) (ch - 26);
                    sb.append(ch);
                } else sb.append(ch);
            }
        }

        System.out.println(sb.toString());
    }
}