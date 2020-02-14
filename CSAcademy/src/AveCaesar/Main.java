package AveCaesar;

// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {

    static HashMap<String, Boolean> hashMap = new HashMap<>();

    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        long n = Long.parseLong(in.nextLine().trim());

        for (long i = 0; i < n; i++) {

           String line = in.nextLine().trim();
            System.out.print(isValid(line));

        }
    }

    private static int isValid(String line) {
        int length = line.length();

        List<String> substrings = new ArrayList<>();

        int start_i = 0;
        char prev = line.charAt(start_i);

        for (int i = 0; i < length; i++) {
            if(line.charAt(i) >= prev){
                prev = line.charAt(i);
            }
            else{
                substrings.add(line.substring(start_i, i));
                prev = line.charAt(i);
                start_i = i;
            }
        }
        substrings.add(line.substring(start_i));


        for (int i = 0; i < substrings.size()-1; i++) {
            if (substrings.get(i).compareTo(substrings.get(i+1)) > 0)
                return 0;
        }
        return 1;

    }
}