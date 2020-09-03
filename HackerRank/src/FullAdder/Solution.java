package HackerRank.src.FullAdder;

import java.io.*;
import java.util.*;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String[] line = firstLine.split(" ");
        int base = Integer.parseInt(line[0]);
        char[] symbols = line[1].toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Character> toChar = new HashMap<>();

        for (int i = 0; i < base; i++) {
            hashMap.put(symbols[i], i);
            toChar.put(i, symbols[i]);
        }

        String secondLine = scanner.nextLine();
        String e1 = secondLine.trim();
        //
        //long num_e1 = convert(e1, hashMap);

        String thirdLine = scanner.nextLine();
        String e2 = thirdLine.substring(1).trim();
        //long num_e2 = convert(e2, hashMap);

        if (e1.length() > e2.length()) {
            //flip
            String temp = e1;
            e1 = e2;
            e2 = temp;
        }

        int maxLength = max(e1.length(), e2.length());
        int minLength = min(e1.length(), e2.length());
        char[] temp_result = new char[maxLength];
        int carry = 0;
        for (int i = 0; i < minLength; i++) {
            int temp_sum = hashMap.get(e1.charAt(e1.length() - 1 - i)) +
                    hashMap.get(e2.charAt(e2.length() - 1 - i)) + carry;
            temp_result[i] = toChar.get(temp_sum % base);
            carry = (int) (temp_sum / base);
        }
        for (int i = minLength; i < maxLength; i++) {
            int temp_sum = hashMap.get(e2.charAt(e2.length() - 1 - i)) + carry;
            temp_result[i] = toChar.get(temp_sum % base);
            carry = (int) (temp_sum / base);
        }


        String dashline = scanner.nextLine();

        //long num_result = num_e1 + num_e2;
        //String result = deconvert(num_result, toChar);

        //printing

        StringBuilder r_str = new StringBuilder();
        if (carry > 0) {
            r_str.append(toChar.get(carry));
        }
        for (int i = 0; i < maxLength; i++) {
            r_str.append(temp_result[maxLength - 1 - i]);
        }
        //System.out.println();

        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println(thirdLine);
        System.out.println(dashline);
        System.out.printf("%" + (maxLength + 1) + "s\n", r_str.toString());

    }

}
/*

    private static String deconvert(long num_result, HashMap<Integer, Character> toChar) {

        int base = toChar.size();
        StringBuilder result = new StringBuilder();

        while(num_result > 0){
            int num = (int) (num_result % base);
            num_result /= base;

            Character c = toChar.get(num);
            result.append(c);
        }


        return result.reverse().toString();
    }

    private static long convert(String e1, HashMap<Character, Integer> hashMap) {

        int base = hashMap.size();
        int length = e1.length();
        long multi = 1;
        if(length != 1){
            multi = (int) Math.pow(base, length-1);
        }

        long result = 0;
        if(length >= 10){
            long carry = 0;
            multi = 1;
            for (int i = length-1; i >= 0; i--) {
                Character c = e1.charAt(i);

                long temp_result = hashMap.get(c) * multi + carry;
                result += temp_result;
                multi *= base;
                carry = temp_result/base;
            }
        }
        else{
            for (int i = 0; i < length; i++) {
                Character c = e1.charAt(i);

                result += hashMap.get(c) * multi;
                multi /= base;
            }
        }

        return result;
    }
}*/
