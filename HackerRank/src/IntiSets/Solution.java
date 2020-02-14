package IntiSets;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    final static long  MODULO = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n > 0){

            long inti = scanner.nextInt();
            long a = scanner.nextInt();
            long b = Long.parseLong(scanner.nextLine().trim());

            List<Long> primes = findPrimes(inti);
            long sum = inclExcl(a,b,1,primes) % MODULO;
            if (sum < 0){
                sum += MODULO;
            }

            System.out.println(sum);

            n--;
        }
    }

    private static List<Long> findPrimes(long n) {
        List<Long> factors = new ArrayList<Long>();
        long md = 2;
        while (n % md == 0) {
            factors.add(md);
            n /= md;
        }
        md = 3;
        while (md <= java.lang.Math.sqrt(n) + 1) {
            while (n % md == 0) {
                factors.add(md);
                n /= md;
            }
            md += 2;
        }
        if (n > 1) {
            factors.add(n);
        }

        return factors.stream().distinct().collect(Collectors.toList());
    }

    private static long sumUpTo(long k) {
        k = k % MODULO;
        long sum = k * (k+1) / 2;
        return sum % MODULO;
    }

    private static long inclExcl(long a, long b, long k, List<Long> primes) {

        long s1 = sumUpTo(b / k) * k;

        long s2 = sumUpTo((a-1) / k) * k;

        long sum = (s1 - s2) % MODULO;

        for (int idx = 0; idx < primes.size(); idx++) {

            sum = (sum - inclExcl(a, b, k * primes.get(idx), primes.subList(idx + 1, primes.size()))) % MODULO;
        }

        return sum;
    }

}