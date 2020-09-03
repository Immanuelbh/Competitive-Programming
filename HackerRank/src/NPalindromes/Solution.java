package HackerRank.src.NPalindromes;

import java.util.*;

public class Solution {

    private static final long MAX_N = 1000000007;
    private static final int MAX_LENGTH = 510;

    static long[][][] cube = new long[MAX_LENGTH][MAX_LENGTH/2][MAX_LENGTH/2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());

        while (n > 0){
            String[] line = scanner.nextLine().split(" ");

            System.out.println(countPal(line[1], Integer.parseInt(line[0])));


            n--;
        }
    }

    private static long countPal(String line, int N) {
        int length = line.length();
        int num_group = (length + 1) / 2;
        int num_mismatch = 0;

        for (int i = 0; i < num_group; i++) {
            if(line.charAt(i) != line.charAt(length -i -1)){
                num_mismatch++;
            }
        }

        cube[0][0][0] = 1;
        for (int n = 0; n <= N; n++) {
            for (int k = 1; k <= num_group ; k++) {
                for (int b = 0; b <= num_mismatch ; b++) {
                    if(k-1 == length-k){
                        cube[n][k][b] = cube[n][k-1][b];
                        if(n>=1)
                            cube[n][k][b] = (cube[n][k][b] + 25*cube[n-1][k-1][b]) % MAX_N;
                    }
                    else if (line.charAt(k-1) == line.charAt(length-k)){
                        cube[n][k][b] = cube[n][k-1][b];
                        if(n>=2)
                            cube[n][k][b] = (cube[n][k][b] + 25*cube[n-2][k-1][b]) % MAX_N;
                    }
                    else if (line.charAt(k-1) != line.charAt(length-k)){
                        if(b>=1 && n>=1)
                            cube[n][k][b] = 2* cube[n-1][k-1][b-1];
                        if (n>=2){
                            if(b>0){
                                cube[n][k][b] = (cube[n][k][b] + 24 * cube[n-2][k-1][b-1]) % MAX_N;
                            }
                            else{
                                cube[n][k][b] = cube[n][k][b] % MAX_N;
                            }
                        }

                    }
                }
            }
            
        }

        return cube[N][num_group][num_mismatch];
    }
}