import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String tempa = scanner.next();
            String tempb = scanner.next();

            if (tempa.equals("0") && tempb.equals("0")) {
                break;
            }

            BigInteger a = new BigInteger(tempa);
            BigInteger b = new BigInteger(tempb);
            BigInteger fib1 = BigInteger.ONE;
            BigInteger fib2 = BigInteger.ONE;
            BigInteger fib = fib1.add(fib2);

            int count = 0;

            while (fib.compareTo(b) <= 0) {
                if (fib.compareTo(a) >= 0) {
                    count++;
                }

                fib1 = fib2;
                fib2 = fib;
                fib = fib1.add(fib2);
            }

            System.out.println(count);
        }
    }
}
