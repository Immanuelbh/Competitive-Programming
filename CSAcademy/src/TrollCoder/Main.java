package CSAcademy.src.TrollCoder;

// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine().trim());
        int capacity = N*2 +1;

        StringBuilder q = new StringBuilder();
        q.append("Q ");
        for (int i = 0; i < N; i++) {
            q.append(0 + " ");
        }
        System.out.println(q.toString());
        System.out.flush();


        int ans = Integer.parseInt(in.nextLine().trim());

        int ind = 2;
        while (ind <= N*2){
            if(ans == N) break;

            StringBuilder new_q = new StringBuilder(q);
            if(new_q.charAt(ind) == '1'){
                new_q.replace(ind, ind+1, 0+"");
            }
            else{
                new_q.replace(ind, ind+1, 1+"");
            }

            System.out.println(new_q.toString());
            System.out.flush();

            int new_ans = Integer.parseInt(in.nextLine().trim());

            if(new_ans > ans){
                q = new_q;
                ans = new_ans;
            }

            ind+=2;
        }

        //q = new StringBuilder(capacity);
        q.replace(0, 1, "A");
        System.out.println(q.toString());
        System.out.flush();

    }
}