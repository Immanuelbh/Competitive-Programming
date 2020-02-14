package QuipuFunction;

// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        String[] line = in.nextLine().split(" ");
        int t = Integer.parseInt(line[0]);
        long a = Long.parseLong(line[1]);
        long b = Long.parseLong(line[2]);

        for (int k = 0; k < t; k++) {
            long d = Long.parseLong(in.nextLine().trim());

            long sum = 0;
            long s = (long) (Math.sqrt(b) + 1e-6);
            for (int i = 1; i <= s; i++) {
                long j = (Math.max(a, i*i) + i -1) / i * i;
                while(j <= b){
                    if(i % d != 0) ++sum;
                    if(i*i != j && j/i % d != 0) ++sum;
                    j+=i;
                }
            }
/*
            for (long j = a; j <= b; j++) {



                //sum += q(j, d);

            }
*/
            System.out.println(sum);
        }
    }

    private static long q(long j, long d) {

        long count = 0;

        long sq = (long) Math.sqrt(j);

        for (int i = 1; i <= sq; i++) {
            if(j % i == 0){

                if(i % d != 0){
                    count++;
                }

                if(j/i == i){

                }
                else{
                    if(j/i % d != 0){
                        count++;
                    }
                }


            }
        }

        return count;

    }
}