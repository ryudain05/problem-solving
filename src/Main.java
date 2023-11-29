import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Cell {
    int cost;
    int parent;

    Cell(int cost, int parent) {
        this.cost = cost;
        this.parent = parent;
    }
}

public class Main {
    static int DELETE = 1, INSERT = 2, REPLACE = 3;
    static int N, min, minCost, parent, delCost, insCost, rep;
    static String s, str, minS = "";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        s = br.readLine();

        minS = "";
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            int dist = editDistance(s, str);

            if (dist < min) {
                min = dist;
                minS = str;
            }
        }

        System.out.println(minS);
    }


    static int editDistance(String s1, String s2) {
        Cell[][] m = new Cell[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            m[i][0] = new Cell(i, i > 0 ? DELETE : -1);
        }

        for (int j = 0; j <= s2.length(); j++) {
            m[0][j] = new Cell(j, j > 0 ? INSERT : -1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int repCost = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;

                delCost = m[i - 1][j].cost + DELETE;
                insCost = m[i][j - 1].cost + INSERT;
                rep = m[i - 1][j - 1].cost + repCost;

                minCost = Math.min(Math.min(delCost, insCost), rep);

                if (minCost == rep) {
                    parent = REPLACE;
                } else if (minCost == delCost) {
                    parent = DELETE;
                } else {
                    parent = INSERT;
                }

                m[i][j] = new Cell(minCost, parent);
            }
        }

        return m[s1.length()][s2.length()].cost;
    }

}
