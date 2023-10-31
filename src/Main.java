import java.util.Scanner;

public class Main {

    static int count = 0;
    static int n;
    static int[] board;

    // 유망한지 판단하는 함수
    static boolean promising(int cdx) {
        // 같은 열이면 안되고, 대각선상에 있어서도 안 된다.
        for (int i = 0; i < cdx; i++) {
            if (board[cdx] == board[i] || cdx - i == Math.abs(board[cdx] - board[i])) {
                return false;
            }
        }
        return true;
    }

    // nqueen 알고리즘 수행
    static void nqueen(int cdx) {
        // cdx가 마지막 행까지 수행하고 여기까지 오면, 찾기 완료
        if (cdx == n) {
            count++;
            printBoard(); // 현재 퀸의 배치를 출력
            return;
        }

        for (int i = 0; i < n; i++) {
            board[cdx] = i; // cdx번째 행, i번째 열에 queen을 놓아본다.
            // 이후 그 행에 둔 것에 대한 유망성을 판단한다.
            if (promising(cdx)) { // 그 자리에 두어도 괜찮았다면,
                nqueen(cdx + 1); // 그 다음 행에 대해 퀸을 놓는 것을 해 본다.
            }
        }
    }

    // 현재 퀸의 배치를 출력하는 함수
    static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        board = new int[n];
        nqueen(0);
        System.out.println("Total solutions: " + count);
    }
}
