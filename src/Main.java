import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = {"`1234567890-=", "QWERTYUIOP[]\\", "ASDFGHJKL;", "ZXCVBNM,./"};

        while (true) {
            String input = reader.readLine();
            if (input == null) break;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                boolean decodeOk = false;

                for (String line : lines) {
                    if (line.indexOf(currentChar) != -1) {
                        int index = line.indexOf(currentChar);
                        System.out.print(line.charAt(index - 1));
                        decodeOk = true;
                        break;
                    }
                }

                if (!decodeOk) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
