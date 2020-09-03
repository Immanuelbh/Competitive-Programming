package HackerRank.src.DigitFun;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while(!line.equals("END")){

            int i = 1;
            while (i < 100){

                String length = String.valueOf(line.length());
                if(line.equals(length)){
                    System.out.println(i);
                    break;
                }
                else{
                    line = length;
                    i++;
                }
            }
            line = scanner.nextLine();
        }
    }
}