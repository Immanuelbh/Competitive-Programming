package ConcentrationGame;

// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        HashMap<Integer, String> hashMap = new HashMap<>();

        long N = Long.parseLong(in.nextLine().trim());
        long moves = 2*N;

        if(N == 1){
            System.out.println(1 + " " + 2);
            System.out.flush();
            System.out.println("-1");
            System.out.flush();
        }
        for (int i = 1; i <= moves; i+=2) {
            System.out.println(i + " " + (i+1) );
            System.out.flush();

            //in.nextLine();
            String line = in.nextLine().trim();//.split(" ");
            int a;
            int b;
            if(line.equals("MATCH"))
                continue;
            else{
                String[] data = line.split(" ");
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }


            if(hashMap.containsKey(a))
                hashMap.put(a, hashMap.get(a) + " " + String.valueOf(i));
            else
                hashMap.put(a, String.valueOf(i));

            if(hashMap.containsKey(b))
                hashMap.put(b, hashMap.get(b) + " " + String.valueOf(i+1));
            else
                hashMap.put(b, String.valueOf(i+1));
        }

        for (String str:
             hashMap.values()) {
            System.out.println(str);
            in.nextLine();
            System.out.flush();
        }
        System.out.println(-1);
        System.out.flush();


    }
}