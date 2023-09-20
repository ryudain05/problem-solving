

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;

        PriorityQueue<String> q = new PriorityQueue<>(Comparator.reverseOrder());

        while (true) {

            s = br.readLine();

            if (s == null || s.isEmpty()) {
                break;
            }

            if (!q.isEmpty() && s.equals("*")) {
                q.poll();
            } else q.offer(s);


        }

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
