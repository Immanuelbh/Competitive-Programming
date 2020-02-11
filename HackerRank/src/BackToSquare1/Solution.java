package BackToSquare1;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        while (N != 0){
            double sum = 1.0;
            for (int i = 0; i < N-1; i++) {
                double p = scanner.nextDouble();
                sum = (double)((sum*(1.0/p)) + 1);
            }

            System.out.println((int) Math.round(sum));

            N = scanner.nextInt();
        }

    }
}