package HackerRank.src.GameOfStones;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test_cases = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < test_cases; i++) {
            int parallel_games = Integer.parseInt(scanner.nextLine().trim());
            int sum = 0;
            for (int j = 0; j < parallel_games; j++) {
                int num_piles = Integer.parseInt(scanner.nextLine().trim());
                String[] pile = scanner.nextLine().split(" ");

                //calculation : n = (x-1)/2
                for (int k = 0; k < pile.length; k++) {
                    sum += calcSteps(Integer.parseInt(pile[k]));
                }
            }
            if(sum % 2 == 0)
                System.out.println("Bob");
            else
                System.out.println("Alice");
        }
    }

    private static int calcSteps(int s) {
        return (s-1)/2;
    }
}