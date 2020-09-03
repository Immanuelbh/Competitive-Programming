package HackerRank.src.MagicSquare;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int count_row = 0, count_col = 0, count_ad = 0;
        int magicNumber = 0;

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] mat = new int[1001][1001];

        for(int i = 1 ; i <= size ; i++){
            for(int j = 1 ; j <= size ; j++){
                mat[i][j] = scanner.nextInt();
            }
        }

        for(int i = 1 ; i <= size; i++){
            magicNumber += mat[i][i];
        }

        List<Integer> list = new ArrayList<>();
        for(int i = size; i >= 1; i--){
            count_col = 0;
            for(int j = 1; j <= size; j++){
                count_col += mat[j][i];
            }
            if(count_col != magicNumber){
                list.add(-i);
            }
        }

        for(int i = 1; i <= size; i++){
            count_ad += mat[i][size-i+1];
        }

        if(count_ad != magicNumber){
            list.add(0);
        }

        for(int i = 1; i <= size ; i++){
            count_row = 0;
            for(int j = 1; j <= size; j++){
                count_row += mat[i][j];
            }
            if(count_row != magicNumber){
                list.add(i);
            }
        }

        System.out.println(list.size());

        for(int i = 0 ; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
