package CSAcademy.src.MinimumPermutation;

// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.min;

// Please name your class Main
class Main {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        long N = in.nextLong();
        long M = Long.parseLong(in.nextLine().trim());

        Queue<Long> array = new LinkedList<>();
        Queue<Long> set = new PriorityQueue<>();

        String[] line = in.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            array.add(Long.valueOf(line[i]));
        }

        line = in.nextLine().split(" ");
        for (int i = 0; i < M; i++) {
            set.add(Long.valueOf(line[i]));
        }

        for (int i = 0; i < N+M; i++) {
            if(set.isEmpty() && array.isEmpty())
                break;
            else if(array.isEmpty()) {
                System.out.print(set.poll() + " ");
                continue;
            }
            else if(set.isEmpty()){
                System.out.print(array.poll() + " ");
                continue;
            }

            if(array.peek() < set.peek()){
                System.out.print(array.poll() + " ");
            }
            else{
                System.out.print(set.poll() + " ");
            }
        }


    }
}