package HackerRank.src.ShorteningInTheRealWorld;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String base = scanner.nextLine().trim();
        int n = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String url = scanner.nextLine().trim();

            byte[] en_base = base.getBytes(StandardCharsets.UTF_8);
            byte[] en_url = url.getBytes(StandardCharsets.UTF_8);

            byte[] corrected_url = new byte[en_url.length];
            if(en_base.length != en_url.length) {

                if (en_base.length > en_url.length) {
                    //truncate base url
                    for (int j = 0; j < corrected_url.length; j++) {
                        corrected_url[j] = en_base[j];

                    }
                } else {
                    //repeat base url
                    for (int j = 0; j < en_url.length; j++) {
                        corrected_url[j] = en_base[j % en_base.length];
                    }
                }
            }
            else {
                corrected_url = en_base;
            }

            byte[] xor_result = xor(corrected_url, en_url);

            byte[] xor_last8 = new byte[8];
            for (int j = xor_last8.length-1, k = xor_result.length-1; j >= 0; j--, k--) {
                xor_last8[j] = xor_result[k];
            }

            long last8 = ByteBuffer.wrap(xor_last8).getLong();

            String encoded = Base62.encode(last8);


            System.out.println(base + "/" + encoded);



        }
    }

    public static byte[] xor(byte[] b1, byte[] b2) {
        byte[] oneAndTwo = new byte[Math.max(b1.length, b2.length)];
        for (int i = 0; i < b1.length && i < b2.length; i++)
            oneAndTwo[i] = (byte) (b1[i] ^ b2[i]);
        for (int i = b2.length; i < b1.length; i++)
            oneAndTwo[i] = b1[i];
        for (int i = b1.length; i < b2.length; i++)
            oneAndTwo[i] = b2[i];
        int length = oneAndTwo.length;
        while (length > 0 && oneAndTwo[length - 1] == 0)
            length--;
        if (length < oneAndTwo.length)
            return Arrays.copyOf(oneAndTwo, length);
        return oneAndTwo;
    }

    public static long getUnsignedInt(byte[] data) {
        long result = 0;

        for (int i = 0; i < data.length; i++) {
            result += data[i] << 8 * (data.length - 1 - i);
        }
        return result;
    }
}

class Base62 {

    private static final char[] digitsChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int BASE = digitsChar.length;
    private static final int FAST_SIZE = 'z';
    private static final int[] digitsIndex = new int[FAST_SIZE + 1];


    static {
        for (int i = 0; i < FAST_SIZE; i++) {
            digitsIndex[i] = -1;
        }
        for (int i = 0; i < BASE; i++) {
            digitsIndex[digitsChar[i]] = i;
        }
    }

    public static String encode(long number) {
        if (number < 0) throw new IllegalArgumentException("Number(Base62) must be positive: " + number);
        if (number == 0) return "0";
        StringBuilder buf = new StringBuilder();
        while (number != 0) {
            buf.append(digitsChar[(int) (number % BASE)]);
            number /= BASE;
        }
        return buf.reverse().toString();
    }

}