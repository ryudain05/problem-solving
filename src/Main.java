

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int r;//행
    static int c;//열
    static char[][] teemo;
    static char[][] cteemo;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        c = input.nextInt();
        char[] tn = {'t', 'e', 'e', 'm', 'o'};//일단 때려 박아야겠죠?
        ArrayList<Integer> xy = new ArrayList<>();
        teemo = new char[r][c];
        cteemo = new char[r][c];
        int count = 0;
        for (int i = 0; i < r; i++) {
            String str = input.next();
            for (int j = 0; j < c; j++) {
                cteemo[i][j] = str.charAt(j);
            }
            str = str.toLowerCase();
            for (int j = 0; j < c; j++) {
                teemo[i][j] = str.charAt(j);
            }
        }
        input.close();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ArrayList<Integer> keys = find_teemo(tn, i, j);
                if (!keys.isEmpty()) {
                    while (!keys.isEmpty()) {
                        xy.add(keys.get(0));
                        xy.add(keys.get(1));
                        xy.add(keys.get(2));
                        keys.remove(0);
                        keys.remove(0);
                        keys.remove(0);
                    }
                }
            }
        }
        while (!xy.isEmpty()) {
            int i = xy.get(0);
            int j = xy.get(1);
            int type = xy.get(2);
            kill_teemo(i, j, type);
            xy.remove(0);
            xy.remove(0);
            xy.remove(0);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print(cteemo[i][j]);
            System.out.println();
        }

    }

    static ArrayList<Integer> find_teemo(char[] tn, int start_i, int start_j) {
        ArrayList<Integer> list = new ArrayList<>();
        int di[] = {-1, -1, -1, 0, 1, 1, 1, 0};//i증가분
        int dj[] = {-1, 0, 1, 1, 1, 0, -1, -1};//y증가분
        int i, j, t, dir;
        for (dir = 0; dir < 8; dir++) {
            i = start_i;
            j = start_j;
            int ignore = 0;//무시하는거
            boolean done = false;//인접하는 애들은 다르면 무시가 불가능 합니다.
            t = 0;//dir방식으로 일단 때려박고
            int cc = 0;
            while (i >= 0 && i < r && j >= 0 && j < c && t != 5 && ignore <= 2) {
                if (tn[t] == teemo[i][j]) {//그냥 맞을때
                    i += di[dir];
                    j += dj[dir];
                    t++;
                    cc++;
                    done = false;
                } else if (tn[t] != teemo[i][j] && !done) {//다른데 무시가 가능할때 ignore<=2 done=false;
                    ignore++;
                    if (ignore == 3) {
                        break;
                    }
                    i += di[dir];
                    j += dj[dir];
                    t++;
                    done = true;//다음에는 무시가 안됨
                    cc++;

                } else
                    ignore++;
            }
            if (cc == tn.length)//다찾았다는 거를 의미를 하겠죠?
            {
                list.add(start_i);
                list.add(start_j);
                list.add(dir);
            }

        }
        return list;
    }

    static void kill_teemo(int start_i, int start_j, int type) {//티확찍
        int di[] = {-1, -1, -1, 0, 1, 1, 1, 0};//i증가분
        int dj[] = {-1, 0, 1, 1, 1, 0, -1, -1};//y증가분
        int i = start_i;
        int j = start_j;
        for (int k = 0; k < 5; k++) {
            cteemo[i][j] = '#';
            i += di[type];
            j += dj[type];

        }
    }
}
