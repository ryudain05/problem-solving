import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s;

        //입력이 없을때 까지 반복
        while ((s = br.readLine()) != null) {
            st = new StringTokenizer(s);

            //StringTokenizer Exception 방지 token이 비었으면 종료
            if (!st.hasMoreTokens()) {
                break;
            }

            //첫번째 인자 입력받음
            int N = Integer.parseInt(st.nextToken());
            //중복확인 배열선언 배열의 크기는 N+1
            int[] res = new int[N + 1];

            //다음 토큰 저장 (두번째 인자)
            int prev = Integer.parseInt(st.nextToken());
            //처음 jolly는 true
            boolean jolly = true;


            //1부터 N-1까지 반복
            for (int i = 1; i < N; i++) {
                //다음 토큰 저장(세번째 인자)
                int curr = Integer.parseInt(st.nextToken());
                //절대값 저장 (두번째인자 - 세번째인자), 절대값 양수 반환으로 순서는 상관없음
                int diff = Math.abs(curr - prev);

                //절대값이 0보다 작거나 N보다 크고, res[diff] == 1 (중복) 일땐 유쾌한점퍼가 아님. jolly = false하고 바로 빠져나감
                if (diff <= 0 || diff >= N || res[diff] == 1) {
                    jolly = false;
                    break;
                }

                //위에 조건문에 걸리지 않는 다면 res[diff] = 1 값 처리
                res[diff] = 1;
                //현재 인자를 기본인자로 저장
                prev = curr;
            }

            //jolly가 true면 유쾌한 점퍼, 아니면 유쾌한 점퍼가 아님
            System.out.println(jolly ? "Jolly" : "Not jolly");

        }
    }
}