package CSAcademy.src.RunningUpStairs;

// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            int stairs = Integer.parseInt(in.nextLine());

            System.out.println(fib(stairs+1));


        }

    }

    private static long fib(int stairs) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (long) Math.round(Math.pow(phi, stairs) / Math.sqrt(5));
    }
}