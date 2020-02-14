package Rumour;

// Don't place your source in a package
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int TWO = 2;

        int n = Integer.parseInt(in.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(" ");
            //BigInteger start = in.nextBigInteger();
            //BigInteger end = in.nextBigInteger();
            //in.nextLine();
            long start = Long.parseLong(line[0]);
            long end = Long.parseLong(line[1]);

            if(start == end){
                System.out.println(0);
                continue;
            }
            /*
            if (start.equals(end)){
                System.out.println(0);
                continue;
            }
*/
            int distance = 0;
            while(start != end){
            //while(!start.equals(end)){
                if(start < end){
                //if(start.compareTo(end) < 0){
                    //end = end.shiftRight(1);
                    //end = end.divide(BigInteger.valueOf(TWO));
                    //end /= 2;
                    end >>= 1;
                }
                else{
                    //start = start.shiftRight(1);
                    //start = start.divide(BigInteger.valueOf(TWO));
                    //start /= 2;
                    start >>= 1;

                }

                ++distance;
            }
            System.out.println(distance);
        }
    }
}