package OctopusesWithWatches;

import java.util.Scanner;

import static java.lang.Math.max;

public class Main {

    private static final int MAX_N = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] mat = new int[MAX_N+1][MAX_N+1];

        String[] line = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt() % 3;
                /*
                String[] row = scanner.nextLine().split(" ");
                for (int k = 0; k < row.length; k++) {
                    mat[i][j] = row[k] % 3;
                }*/
            }
        }

        int ans = 0, bound = 1;
        //10^3
        for (int i = 1; i <= m; i++) {
            bound *= 3;
        }

        for (int num = 0; num < bound; num++) {
            int res = 0;
            int[][] mat2 = new int[MAX_N+1][MAX_N+1];
            int[] add = new int[MAX_N+1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat2[i][j] = mat[i][j];
                }
            }

            int num2 = num;
            for (int i = 0; i < m; i++) {
                add[i] = num2 %3;
                num2 /= 3;
            }

            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    mat2[i][j] = (mat2[i][j] + add[j]) %3;
                }
            }

            for (int i = 0; i < n; i++) {
                int[] cl = new int[3];
                for (int j = 0; j < m; j++) {
                    cl[mat2[i][j]]++;
                }
                res += max( max( cl[0], cl[1]), cl[2]);
            }
            ans = max(ans, res);
        }

        System.out.println(ans);

    }
}
