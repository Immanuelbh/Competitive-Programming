package HackerRank.src.CarSpark;

import java.io.*;
import java.util.*;

import static java.lang.Math.max;

public class Solution {

    static class Order implements Comparable<Order>{
        private int startT;
        private int endT;
        private int pay;

        public Order(int s, int e, int p){
            this.startT = s;
            this.endT = e;
            this.pay = p;
        }

        public int getStartT() {
            return startT;
        }

        public int getEndT() {
            return endT;
        }

        public int getPay() {
            return pay;
        }


        @Override
        public int compareTo(Order o) {
            return this.getEndT() > o.getEndT() ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Order> orders;

        while (n > 0){

            int num_bookings = Integer.parseInt(scanner.nextLine().trim());
            orders = new ArrayList<>();

            while (num_bookings > 0){

                String[] line = scanner.nextLine().split(" ");
                int startT = Integer.parseInt(line[0]);
                int endT = Integer.parseInt(line[1]);
                int pay = Integer.parseInt(line[2]);

                orders.add(new Order(startT, endT, pay));

                num_bookings--;
            }

            Collections.sort(orders);

            findMaxRev(orders);

            n--;
        }
    }

    private static void findMaxRev(List<Order> orders) {

        int[] arr = new int[50];

        for (int i = 0; i < orders.size(); i++) {
            Order current = orders.get(i);
            for (int j = current.getStartT() ; j >= 0 ; j--) {
                arr[current.getEndT()] = max(arr[current.endT], arr[j] + current.getPay());
            }
        }

        int max = 0;
        for (int i = 0; i < 50; i++) {
            max = max(max, arr[i]);
        }

        System.out.println(max);

    }
}