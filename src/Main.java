import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr;

        int c, n, p, lost, count;

        c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            n = Integer.parseInt(br.readLine());
            p = Integer.parseInt(br.readLine());

            arr = new int[p];
            List<String> list = new ArrayList<>();

            for (int j = 0; j < p; j++) {
                arr[j] = Integer.parseInt(br.readLine()); //휴업지수
            }

            lost = 0;
            for (int day = 1; day <= n; day++) {
                count = 0;
                if(day%7==0||day%7==1) continue;

                for (int N : arr) {
                    if (day % N == 0) {
                        count++;
                    }
                }

                int num = (int) Math.round((double) p / 2);//과반수를 의미하는 것
                if (count >= num) {//과반수를 넘었으면 얘는 공동휴일로 지정이 된거야
                    String str = "";
                    lost++;
                    if (day % 7 == 2) {//월
                        str += "Mon: ";
                        str += String.valueOf(day);
                    } else if (day % 7 == 3) {//화

                        str += "Tue: ";
                        str += String.valueOf(day);

                    } else if (day % 7 == 5) {//목

                        str += "Thu: ";
                        str += String.valueOf(day);

                    } else if (day % 7 == 6) {//금

                        str += "Fri: ";
                        str += String.valueOf(day);

                    }
                    if (!str.equals(""))
                        list.add(str);
                }
            }

            System.out.println("Lost: " + lost);
            for (String s : list)
                System.out.println(s);

            System.out.println();
        }
    }
}