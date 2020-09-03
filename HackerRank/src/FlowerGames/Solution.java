package HackerRank.src.FlowerGames;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {

            BigInteger petals = scanner.nextBigInteger();

            petals = petals.clearBit(petals.bitLength()-1).shiftLeft(1);
            petals = petals.add(BigInteger.valueOf(1));
            System.out.println(petals);
        }
    }
}