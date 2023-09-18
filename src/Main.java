import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] arr = input.split(" ");

        Stack<Integer> stack = new Stack<>();

        for (String s : arr) {
            if (s.equals("*") && !stack.isEmpty()) {
                stack.pop();
            } else if (stack.isEmpty()) {
                if (!s.equals("*"))
                    stack.push(Integer.valueOf(s));
            } else {
                int coin = stack.peek();
                if (coin >= Integer.valueOf(s)) {
                    stack.push(Integer.valueOf(s));
                }
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}