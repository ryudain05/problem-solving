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

            BigInteger fib0 = BigInteger.ONE;
            BigInteger fib1 = BigInteger.ONE;

            BigInteger i = BigInteger.ONE;
            while (fib0.compareTo(a) < 0) {
                BigInteger temp = fib1;
                fib1 = fib1.add(fib0);
                fib0 = temp;
                i = i.add(BigInteger.ONE);
            }

            int result = 0;
            while (fib0.compareTo(b) <= 0) {
                result++;
                BigInteger temp = fib1;
                fib1 = fib1.add(fib0);
                fib0 = temp;
            }

            System.out.println(result);
        }

        scanner.close();
    }
}
