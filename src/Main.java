import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 버퍼 입력을 처리합니다.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 주어진 암호화 텍스트
        String pltxt = "the quick brown fox jumps over the lazy dog";

        // 입력된 라인을 저장할 2차원 문자 배열
        char[][] line = new char[100][100];

        // 문자 매핑을 저장할 배열
        char[] map = new char[256];
        char[] inv = new char[256];

        // 테스트 케이스의 수를 읽어옵니다.
        int num_cases = Integer.parseInt(reader.readLine().trim());
        reader.readLine(); // 빈 줄 skip

        // 각 테스트 케이스를 처리합니다.
        while (num_cases-- > 0) {
            int num_lines = 0;
            String inputLine;

            // 빈 줄이 나올 때까지 라인을 읽어옵니다.
            while (!(inputLine = reader.readLine()).isEmpty()) {
                line[num_lines] = inputLine.toCharArray();
                num_lines++;
            }

            // 가능한 매핑이 있는지 확인하는 플래그
            boolean possible = false;

            // 각 라인에 대해 매핑을 시도합니다.
            for (int i = 0; i < num_lines; i++) {
                // 암호화 텍스트와 길이가 같은 경우에만 확인합니다.
                if (pltxt.length() != line[i].length) {
                    continue;
                }

                // 매핑을 초기화합니다.
                for (int c = 'a'; c <= 'z'; c++) {
                    map[c] = '\0';
                    inv[c] = '\0';
                }
                map[' '] = ' ';

                // 현재 라인에 대해 유효한 매핑이 가능한지 확인합니다.
                boolean validMapping = true;
                for (int j = 0; j < line[i].length; j++) {
                    if ((map[line[i][j]] != '\0' && map[line[i][j]] != pltxt.charAt(j))
                            || (inv[pltxt.charAt(j)] != '\0' && inv[pltxt.charAt(j)] != line[i][j])) {
                        // 매핑이 유효하지 않으면 루프를 빠져나갑니다.
                        validMapping = false;
                        break;
                    } else {
                        // 매핑이 유효하면 매핑 정보를 저장합니다.
                        map[line[i][j]] = pltxt.charAt(j);
                        inv[pltxt.charAt(j)] = line[i][j];
                    }
                }

                // 유효한 매핑이면 가능한 플래그를 설정하고 루프를 빠져나갑니다.
                if (validMapping) {
                    possible = true;
                    break;
                }
            }

            // 가능한 매핑이 있으면 결과를 출력합니다.
            if (possible) {
                for (int i = 0; i < num_lines; i++) {
                    for (int j = 0; j < line[i].length; j++) {
                        System.out.print(map[line[i][j]]);
                    }
                    System.out.println();
                }
            } else {
                // 가능한 매핑이 없으면 "No solution."을 출력합니다.
                System.out.println("No solution.");
            }

            // 더 많은 테스트 케이스가 있는지 확인하고, 있다면 빈 줄을 출력합니다.
            if (num_cases > 0) {
                System.out.println();
            }
        }

        // 입력 스트림을 닫습니다.
        reader.close();
    }
}
