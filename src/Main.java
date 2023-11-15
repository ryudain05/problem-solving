import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int[][] edge;
    static int N, M, K;
    static boolean search = false;
    static ArrayList<ArrayList<Integer>> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        edge = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            edge[X - 1][Y - 1] = 1;
            edge[Y - 1][X - 1] = 1;
        }

        DFS(edge, K, new ArrayList<>(Arrays.asList(K)));

        if (!search) {
            System.out.println("NONE");
        } else {
            path.sort((a, b) -> {
                int size = Math.min(a.size(), b.size());
                for (int i = 0; i < size; i++) {
                    if (a.get(i) != b.get(i)) {
                        return a.get(i) - b.get(i);
                    }
                }
                return a.size() - b.size();
            });

            for (ArrayList<Integer> list : path) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i));
                    if (i != list.size() - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void DFS(int[][] edge, int current, ArrayList<Integer> list) {
        if (list.size() == edge.length + 1 && current == K && Back(current, edge)) {
            search = true;
            path.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < edge.length; i++) {
            if (edge[current - 1][i] == 1 && !visit[i]) {
                visit[i] = true;
                list.add(i + 1);
                DFS(edge, i + 1, list);
                visit[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    static boolean Back(int current, int[][] edge) {
        for (int i = 0; i < edge.length; i++) {
            if (edge[current - 1][i] == 1 && !visit[i]) {
                return false;
            }
        }
        return true;
    }
}
