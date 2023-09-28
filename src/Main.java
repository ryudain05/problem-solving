import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        StringBuilder answer = new StringBuilder();

        int num = 0, start = 0, end = 1;


        while (num < str.length()) {
            String[] arr = new String[N];

            for (int i = 0; i < N; i++) {

                if (num + i >= str.length())
                    break;

                arr[i] = str.substring(num, num + i + 1);
            }

            ArrayList<String> tempList = new ArrayList<>(Arrays.asList(arr));
            tempList.removeAll(Arrays.asList((Object) null));
            arr = tempList.toArray(new String[tempList.size()]);

            int[] repeat = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                start = num + i + 1;
                end = start + arr[i].length();
                while (end <= str.length()) {
                    if (str.substring(start, end).equals(arr[i])) {
                        repeat[i]++;
                        start += arr[i].length();
                        end += arr[i].length();
                    } else {
                        break;
                    }
                }
            }

            int max = 0;
            int maxToken = 0;

            for (int i = 0; i < repeat.length; i++) {
                if (max <= repeat[i]) {
                    max = repeat[i];
                    maxToken = i;
                }
            }

            if (max == 0) {
                answer.append(str.charAt(num)).append('1');
                num++;
            } else {
                if (maxToken == 0) {
                    answer.append(arr[0]).append(max + 1);
                } else {
                    answer.append(arr[maxToken].toUpperCase()).append(max + 1);
                }
                num += (max + 1) * (maxToken + 1);
            }
        }

        System.out.println(answer);
    }
}
