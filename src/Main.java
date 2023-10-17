import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("1");
        String[] tmp = sb.toString().split("");

        ArrayList<String> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            res.add(sb.toString()); //[1, 11, 12, 1121, ...]
            tmp = sb.toString().split("");
            String tk = tmp[0];

            sb = new StringBuilder();
            int count = 0;
            for(int j = 0; j < tmp.length; j++) {
                if(tk.equals(tmp[j])) count++;
                else {
                    sb.append(tk + "" + count);
                    tk = tmp[j];
                    count=1;
                }

            }
            if(count>=1) {
                sb.append(tk+""+count);
                count=1;
            }
        }
        System.out.println(res.get(n-1));
    }

}
