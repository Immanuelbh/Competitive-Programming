package DogWalking;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < t; i++) {

            String[] line = scanner.nextLine().split(" ");
            int k = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);

            int[] dogs = new int[k];
            for (int j = 0; j < k; j++) {
                dogs[j] = Integer.parseInt(scanner.nextLine().trim());
            }

            Arrays.sort(dogs);

            int[] difference = new int[k-1];
            for (int j = 0; j < k-1; j++) {
                difference[j] = dogs[j+1] - dogs[j];
            }

            Arrays.sort(difference);

            int sum = dogs[k-1] - dogs[0];
            for (int j = k-2; j >= k-n; j--) {
                sum -= difference[j];
            }
            System.out.println(sum);
        }
    }
}