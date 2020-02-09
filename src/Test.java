import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        int n = scanner.nextInt();
        for(int i = 0 ; i < n ; i++){

            list.add(scanner.nextInt());
        }

        for (Integer num:
             list) {
            System.out.println(num);

        }
        /*
        int test_cases = scanner.nextInt();
        for(int i = 0; i < test_cases; i++) {
            int num_data_points = scanner.nextInt(); // per line
            int[] group = new int[num_data_points];
            int item_ind = 0;
            int size_subgroup = scanner.nextInt();
            for (int j = 0; j < num_data_points ; j++) { // read line
                int item = scanner.nextInt(); //ERROR on the last or one before last scan ~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
                group[item_ind++] = item;
                System.out.print(group[item_ind-1] + " ");


            }
*/
/*
            for (int j = 0; j < group.length; j++){
                System.out.println(group[j]);
            }*/
        //}


    }
}
