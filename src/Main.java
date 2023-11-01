import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] miro = new int[4][4];
    static boolean[][] path = new boolean[4][4];
    static int[] dx = {0, 1}; // 오른쪽, 아래쪽
    static int[] dy = {1, 0}; // 오른쪽, 아래쪽

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                miro[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(0, 0);
        printPath();
        System.out.println(sb);
    }

    static void BFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        path[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];


            if (y + 1 < 4 && miro[x][y + 1] == 1 && !path[x][y + 1]) {
                queue.offer(new int[]{x, y + 1});
                path[x][y + 1] = true;
            }

            else if (x + 1 < 4 && miro[x + 1][y] == 1 && !path[x + 1][y]) {
                queue.offer(new int[]{x + 1, y});
                path[x + 1][y] = true;
            }
        }
    }

    static void printPath() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (path[i][j]) {
                    sb.append("1").append(" ");
                } else {
                    sb.append("0").append(" ");
                }
            }
            sb.append("\n");
        }
    }
}
