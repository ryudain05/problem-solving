
import java.io.*;
import java.util.*;

public class Main {
    static int grid[][];
    static boolean visited[];
    static int n;

    static boolean isEven() { //¦�� üũ
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(grid[i][j] > 0)
                    cnt += grid[i][j];
            }
            if(cnt %2 == 1)
                return false;
        }
        return true;
    }


    static boolean isOdd() {
        int tmp = 0;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    cnt += 1;
            }
            if(cnt%2 == 1)
                tmp++;
            if (tmp > 2)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(isEven()) System.out.println("O");
        else {
            if(isOdd()) System.out.println("O");
            else System.out.println("X");
        }
    }

}
