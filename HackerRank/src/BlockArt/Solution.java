package HackerRank.src.BlockArt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

class Rectangle{
    int row_start;
    int col_start;
    int row_end;
    int col_end;

    public Rectangle(int row_start, int col_start, int row_end, int col_end) {
        this.row_start = row_start;
        this.col_start = col_start;
        this.row_end = row_end;
        this.col_end = col_end;
    }
}

public class Solution {

    public static Collection<Rectangle> added = new ArrayList<>();
    public static Collection<Rectangle> removed = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] mat = scanner.nextLine().trim().split(" ");
        int ROW_SIZE = Integer.parseInt(mat[0]);
        int COL_SIZE = Integer.parseInt(mat[1]);

        int test_cases = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < test_cases; i++) {
            String[] query = scanner.nextLine().trim().split(" ");
            String operation = query[0];
            Rectangle rectangle = new Rectangle(
                    Integer.parseInt(query[1]),
                    Integer.parseInt(query[2]),
                    Integer.parseInt(query[3]),
                    Integer.parseInt(query[4])
            );

            if(operation.equals("a")){//add
                added.add(rectangle);
            }
            else if(operation.equals("r")){ //remove
                removed.add(rectangle);
            }
            else if(operation.equals("q")){ //query
                int sum = 0;
                sum = queryCube(rectangle);
                System.out.println(sum);
            }
            else{
                //error
                System.out.println("error");
            }
        }
    }

    private static int queryCube(Rectangle rectangle) {
        int sum = 0;

        for (Rectangle mat:
             added) {
            int width = Math.min(rectangle.col_end, mat.col_end) - Math.max(rectangle.col_start, mat.col_start)+1;
            if(width > 0){
                //overlap
                int length = Math.min(rectangle.row_end, mat.row_end) - Math.max(rectangle.row_start, mat.row_start)+1;

                if(length > 0)
                    sum += width*length;
            }
            else{
                //no overlap
            }
        }

        for (Rectangle mat:
             removed) {
            int width = Math.min(rectangle.col_end, mat.col_end) - Math.max(rectangle.col_start, mat.col_start)+1;
            if(width > 0){
                //overlap
                int length = Math.min(rectangle.row_end, mat.row_end) - Math.max(rectangle.row_start, mat.row_start)+1;

                if(length > 0)
                    sum -= width*length;
            }
            else{
                //no overlap
            }
        }


        return sum;
    }

}
