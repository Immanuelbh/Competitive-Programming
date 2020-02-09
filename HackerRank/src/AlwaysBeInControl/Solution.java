package AlwaysBeInControl;

import java.io.*;
import java.util.*;

/*
url:
https://www.hackerrank.com/contests/ieeextreme-challenges/challenges/always-be-in-control

 */
public class Solution{

    public static void main(String[] args) {
        //int[][] mat = new int[test_cases][];

        Scanner scanner = new Scanner(System.in);
        int test_cases = scanner.nextInt();
        //int num_data_points = 0;//, item = 0;
        int total_subgroups = 0, size_subgroup = 0, sum_subgroup = 0, counter_subgroup = 0;
        int[] range_arr_subgroups;
        double[] avg_arr_subgroups;
        double grand_avg_avg = 0.0;
        double grand_range_avg = 0.0;
        double A2;
        double UCL = 0.0, CENTER_LINE = 0.0, LCL = 0.0, sigma = 0.0;
        //int[] group;

        //scan information
        //while scanning - compute and save information
        //calculate all values after scanning
        //print values

        for(int i = 0; i < test_cases; i++){

            int num_data_points = scanner.nextInt(); // per line
            double[] group = new double[num_data_points];

            size_subgroup = scanner.nextInt();
            A2 = getConstant(size_subgroup);


            int size_subgroup_remainder = num_data_points % size_subgroup;

            if(size_subgroup_remainder != 0){
                avg_arr_subgroups = new double[(num_data_points/size_subgroup)+1];//save averages
                range_arr_subgroups = new int[(num_data_points/size_subgroup)+1];
            }
            else{
                avg_arr_subgroups = new double[(num_data_points/size_subgroup)];//save averages
                range_arr_subgroups = new int[(num_data_points/size_subgroup)];//save ranges
            }

            int subgroup_count = 0;
            int subgroup_ind = 0;
            int item_ind = 0;
            int[] subgroup = new int[size_subgroup];
            int[] subgroup_remainder = new int[size_subgroup_remainder];

            for (int j = num_data_points; j > 0 ; j--){ // read line
                int item = scanner.nextInt(); //ERROR on the last or one before last scan ~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
                group[item_ind++] = (double) item;
                //System.out.print(group[item_ind-1] + " ");
                subgroup_count++;

                if(j < size_subgroup && size_subgroup_remainder > 0){  //smaller than the group size
                    subgroup_remainder[subgroup_count-1] = item;

                }else{
                    subgroup[subgroup_count-1] = item;

                }

                if(group.length == item_ind){
                    //System.out.println("End");
                    avg_arr_subgroups[subgroup_ind] = calcAvg(subgroup);//calc rolling avg - returns double
                    range_arr_subgroups[subgroup_ind] = calcRange(subgroup);//calc rolling range - returns int

                    //calculate all needed values
                    grand_avg_avg = calcAvg(avg_arr_subgroups);
                    grand_range_avg = calcAvg(range_arr_subgroups);

                    UCL = grand_avg_avg + (A2*grand_range_avg);
                    CENTER_LINE = grand_avg_avg;
                    LCL = grand_avg_avg - (A2*grand_range_avg);

                    sigma = (UCL-CENTER_LINE)/3;

                    //check if In Control
                    boolean inControl = checkInControl(group, CENTER_LINE, sigma);
                    if(inControl)
                        System.out.println("In Control");
                    else
                        System.out.println("Out of Control");
                }
                else if(subgroup_count == size_subgroup){
                    avg_arr_subgroups[subgroup_ind] = calcAvg(subgroup);//calc rolling avg
                    range_arr_subgroups[subgroup_ind] = calcRange(subgroup);//calc rolling range


                    subgroup_count = 0;
                    subgroup_ind++;
                }
                //else if(subgroup_count == size_subgroup_remainder){ // end of input


            }

        }

        scanner.close();
    }

    private static boolean checkInControl(double[] group, double center_line, double sigma) {

        boolean sigma_two = false, sigma_one = false, eight_val = false;
        int sigma_two_counter = 0, sigma_one_counter = 0, same_side_counter = 0;
        double pos_sigmaThree = center_line+(sigma*3);
        double pos_sigmaTwo = center_line+(sigma*2);
        double pos_sigmaOne = center_line+sigma;
        double neg_sigmaThree = center_line-(sigma*3);
        double neg_sigmaTwo = center_line-(sigma*2);
        double neg_sigmaOne = center_line-sigma;
        int cnt_pos_sigma_two = 0;
        int cnt_pos_sigma_one = 0;
        int cnt_pos = 0;
        int cnt_neg = 0;
        int cnt_neg_sigma_one = 0;
        int cnt_neg_sigma_two = 0;

        for(int i = 0 ; i < group.length; i++){

            if(group[i] > pos_sigmaThree || group[i] < neg_sigmaThree){
                return false; //Out of Control
            }

            ///plus
            //positive
            if(group[i] > pos_sigmaTwo)
                cnt_pos_sigma_two++;
            if(group[i] > pos_sigmaOne)
                cnt_pos_sigma_one++;
            if(group[i] > center_line)
                cnt_pos++;

            //negative
            if(group[i] < neg_sigmaTwo)
                cnt_neg_sigma_two++;
            if(group[i] < neg_sigmaOne)
                cnt_neg_sigma_one++;
            if(group[i] < center_line)
                cnt_neg++;


            ///minus
            if(i >= 3){
                //positive
                if(group[i-3] > pos_sigmaTwo)
                    cnt_pos_sigma_two--;

                //negative
                if(group[i-3] < neg_sigmaTwo)
                    cnt_neg_sigma_two--;
            }

            if(i >= 5){
                //positive
                if(group[i-5] > pos_sigmaOne)
                    cnt_pos_sigma_one--;

                //negative
                if(group[i-5] < neg_sigmaOne)
                    cnt_neg_sigma_one--;
            }

            if(i >= 8){
                //positive
                if(group[i-8] > center_line)
                    cnt_pos--;

                //negative
                if(group[i-8] < center_line)
                    cnt_neg--;
            }


            //check if out of control
            if((cnt_pos_sigma_two >= 2)
                    || (cnt_pos_sigma_one >= 4)
                    || (cnt_pos >= 8)
                    || (cnt_neg_sigma_two >= 2)
                    || (cnt_neg_sigma_one >= 4)
                    || (cnt_neg >= 8)
            ) {//can also be only equals
                return false; //Out of Control
            }

        }

        return true; //In Control
    }

    private static double getConstant(int size_subgroup) {

        double value = 0.0;
        switch (size_subgroup){
            case 2:
                value = 1.880;
                break;
            case 3:
                value =  1.023;
                break;
            case 4:
                value =  0.729;
                break;
            case 5:
                value =  0.577;
                break;
            case 6:
                value =  0.483;
                break;
            case 7:
                value =  0.419;
                break;
            case 8:
                value =  0.373;
                break;
            case 9:
                value =  0.337;
                break;
            case 10:
                value =  0.308;
                break;

            default:
                System.out.println("Invalid size of subgroup");
        }

        return value;

    }

    private static int calcRange(int[] subgroup) {
        int max_val = Integer.MIN_VALUE;
        int min_val = Integer.MAX_VALUE;

        for(int i = 0 ; i < subgroup.length; i++){
            if(max_val < subgroup[i]){
                max_val = subgroup[i];
            }
            else if(min_val > subgroup[i]){
                min_val = subgroup[i];
            }
        }

        return Math.abs(max_val - min_val);
    }

    private static double calcAvg(int[] subgroup) {
        //double average = 0.0;
        double sum = 0;
        for(int i = 0; i < subgroup.length; i++){
            sum += subgroup[i];
        }

        return sum/subgroup.length;
    }
    private static double calcAvg(double[] subgroup) {
        double sum = 0;
        for(int i = 0; i < subgroup.length; i++){
            sum += subgroup[i];
        }

        return sum/subgroup.length;
    }
}