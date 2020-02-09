package CountingMolecules;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long c = scanner.nextLong();
        long h = scanner.nextLong();
        long o = scanner.nextLong();

        /*
        c = cm + 6 *gm
        cm = c - 6 * gm
        o = 2 * cm + wm + 6* gm
        o = 2 * ( c - 6 *gm ) + wm + 6 * gm
        o = 2*c - 12 * gm + wm + 6 gm
        o = 2*c - 6 * gm + wm
        wm = o - 2*c + 6 gm
        h = 2 * wm + 12 * gm
        h = 2 * (o-2*c + 6 * gm) + 12 * gm
        h = 2 * o - 4*c + 24 gm
        gm = (h-2 * o + 4 *c )/24
        */

        long gm = (h - (2*o) + (4*c)) / 24;
        long cm = c - (6 * gm);
        long wm = o - (2*c) + (6*gm);

        long cc = cm + (6*gm);
        long hh = (2*wm) + (12*gm);
        long oo = wm + (2*cm) + (6*gm);

        if(oo != o || cc != c || hh != h)
            System.out.println("Error");
        else{
            System.out.println(wm + " " + cm + " " + gm);
        }


    }
}