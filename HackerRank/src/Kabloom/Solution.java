package Kabloom;

import java.io.*;
import java.util.*;

import static java.lang.Math.max;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cards = 1; //Integer.parseInt(scanner.nextLine().trim());
        while(true){
            cards = Integer.parseInt(scanner.nextLine().trim());
            if(cards == 0) break;
            String[] up = new String[cards];
            String[] down = new String[cards];

            up = scanner.nextLine().trim().split(" ");
            down = scanner.nextLine().trim().split(" ");

            System.out.println(kabloom(up, down, cards));

        }
    }

    private static int kabloom(String[] up, String[] down, int size) {

        int[][] temp = new int[size+1][size+1]; //check

        /*for (int i = 0; i <= size; i++) {
            temp[i][0]=0;
            temp[0][i]=0;
        }
*/
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                temp[i][j] = max(temp[i-1][j], temp[i][j-1]);
                if(up[i-1].equals(down[j-1]) || up[i-1].equals("R") || down [j-1].equals("R")){
                    temp[i][j] = max(temp[i][j], temp[i-1][j-1]+val(up[i-1],down[j-1]));
                }
            }
        }

        return temp[size][size];
    }

    private static int val(String up, String down) {
        if(up.equals("R")){
            if(down.equals("R")) return 100;
            if(down.equals("A")) return 40;
            if(down.equals("K") || (down.equals("Q")) || (down.equals("J"))) return 30;
            if(down.equals("T")) return 20;
            return ((int) down.charAt(0) - (int) '0') * 2;
        }
        if(up.equals("A")) return 40;
        if((up.equals("K")) || (up.equals("Q")) || (up.equals("J"))) return 30;
        if(up.equals("T")) return 20;
        return ((int) up.charAt(0) - (int) '0') * 2;

    }
}