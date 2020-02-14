package LexicalAddition;

// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        String[] line = in.nextLine().split(" ");
        long n = Long.parseLong(line[0]);
        long a = Long.parseLong(line[1]);
        long b = Long.parseLong(line[2]);




        long min_elements = n / b;
        if(n%b != 0) min_elements++;
        long max_elements = n / a;
        if(n%a != 0) max_elements++;

        //100 49 49
        //100 48 49
        if(a > n || a*min_elements > n){
            System.out.println("NO");
            return;
        }
        else System.out.println("YES");

        long[] result = new long[Math.toIntExact(min_elements)];

        for (int i = 0; i < result.length; i++) {
            result[i] = a;
        }

        long min_number = a*min_elements;

        if(min_number != n){
            long distance = n - min_number;
            long gap = b - a;

            for (long i = result.length-1; i >=0 ; i--) {
                long difference = distance - gap;

                if(difference == 0){
                    result[Math.toIntExact(i)] = b;
                    break;
                }
                else if (difference > 0){
                    result[Math.toIntExact(i)] = b;
                }
                else if (difference < 0){ //found the break point
                    result[Math.toIntExact(i)] = b + difference;
                    break;
                }
                distance -= gap;
            }
        }

        //print
        Arrays.stream(result).forEach(s-> System.out.print(s + " "));
    }

}