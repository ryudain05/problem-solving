import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        StringBuilder sb;

        while ((s = br.readLine()) != null){
            Stack<String> stack = new Stack<>();
            String[] arr = s.split("");

            for (int i = 0; i < s.length(); i++) {


                if(!arr[i].equals("*")) {
                    stack.push(arr[i]);
                }

                else if(arr[i].equals("*") && !stack.isEmpty()) {
                    stack.pop();
                }

                if(stack.size() > 10) {
                    if(!arr[i].equals("*")) {
                        stack.pop();
                    }
                }
            }

            sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            sb.reverse();


            System.out.print(sb);
            System.out.println();
        }
    }
}