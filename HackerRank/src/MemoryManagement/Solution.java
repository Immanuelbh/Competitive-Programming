package HackerRank.src.MemoryManagement;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < t; i++) {
            String[] data = scanner.nextLine().trim().split(" ");
            int p = Integer.parseInt(data[0]); //number of pages present in the OS for a program
            int s = Integer.parseInt(data[1]); // size of each page
            int n = Integer.parseInt(data[2]); // number of memory accesses

            List<Integer> addresses = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                addresses.add(Integer.parseInt(scanner.nextLine().trim()));
            }

            calculate(p,s,n,addresses);
        }
    }

    public static void calculate(int p, int s, int n, List<Integer> addresses) {

        Deque<Integer> lru = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        int lruPr = 0;
        int fifoPr = 0;

        for (int i = 0; i < n; i++) {
            int index = addresses.get(i)/s;

            //lru
            if(lru.contains(index)){
                lru.remove(index);
            }
            else{
                if(lru.size() == p){
                    lru.removeLast();
                    lruPr++;
                }
            }
            lru.addFirst(index);

            //fifo
            if(!queue.contains(index)){
                if(queue.size() == p){ // if not full then add to queue
                    queue.remove();
                    fifoPr++;
                }
                queue.add(index);

            }
        }


        System.out.print(fifoPr>lruPr?"yes":"no");
        System.out.println(" " + fifoPr + " " + lruPr);
    }

    private static int lru(int p, int s, int n, List<Integer> addresses) {

        List<Integer> lru = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int index = addresses.get(i)/s;
            if(lru.contains(index)){
                lru.remove(index);
            }
            else{
                if(lru.size() == p){
                    lru.remove(lru.get(0));
                    count++;
                }
            }
            lru.add(index);
        }

        return count;
    }

    private static int fifo(int p, int s, int n, List<Integer> addresses) {

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int index = addresses.get(i)/s;
            if(!queue.contains(index)){
                if(queue.size() == p){ // if not full then add to queue
                    queue.poll();
                    count++;
                }
                queue.add(index);

            }
        }

        return count;
    }
}