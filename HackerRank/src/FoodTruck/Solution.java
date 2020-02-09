package FoodTruck;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
src: https://www.hackerrank.com/contests/ieeextreme-challenges/challenges/food-truck
 */

class Location implements Comparable<Location>{
     double lat;
     double lon;
     Date date;
     String phone;

    public Location(double lat, double lon, Date date, String phone) {
        this.lat = lat;
        this.lon = lon;
        this.date = date;
        this.phone = phone;
    }

    @Override
    public int compareTo(Location o) {
        return phone.compareTo(o.phone);
    }

    public String getPhone() {
        return phone;
    }
}
public class Solution {

    final static double E_RADIUS = 6378.137;
    private static SimpleDateFormat dateNTime = new SimpleDateFormat("MM/dd/yyyy HH:mm");


    public static void main(String[] args) throws ParseException {
        ArrayList<Location> locations = new ArrayList<>();
        HashMap<String, Date> phoneMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
                //.useDelimiter("[,/:\\s\\n]");

        String[] latlon = scanner.nextLine().trim().split(",");
        double LAT = Double.parseDouble(latlon[0]);
        double LONG = Double.parseDouble(latlon[1]);
        //double LONG = scanner.nextDouble();
        double RADIUS = Double.parseDouble(scanner.nextLine().trim());//scanner.nextDouble();
        //String line = scanner.nextLine(); // header of the following table
        //String line2 = scanner.nextLine(); // header of the following table

        scanner.nextLine();
        List<Long> p_numbers = new ArrayList<>();
        //HashMap<Long, Integer> hoursMap = new HashMap<>();
        //HashMap<Long, Integer> minutesMap = new HashMap<>();

        while(scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(","); //trim?
            if (data[0].equals("")) break;
            Date date = dateNTime.parse(data[0]);

            //lat & long
            double cur_lat = Double.parseDouble(data[1]); //lat2
            double cur_long = Double.parseDouble(data[2]); //long2

            //phone number
            String phoneNum = data[3];
            //long phone = Long.parseLong(data[3]);

            Location location = new Location(cur_lat, cur_long, date, phoneNum);
            phoneMap.put(phoneNum, date);
            if (phoneMap.get(phoneNum).getTime() > date.getTime()) {
                location.date = phoneMap.get(phoneNum);
            }

            locations.add(location);

        }

        List<Location> closeLocations = new ArrayList<>();

        for (Location location:
             locations) {
            if(haversine(location.lat, LAT, location.lon, LONG) <= RADIUS){
                closeLocations.add(location);
            }
        }

        Collections.sort(closeLocations);
        ArrayList<String> toPrint = closeLocations.stream().map(loc->loc.phone).distinct().collect(Collectors.toCollection(ArrayList<String>::new));

        for (int i = 0; i < toPrint.size(); i++) {
            System.out.print(toPrint.get(i));
            if(i != toPrint.size()-1)
                System.out.print(",");
        }
        System.out.println();


            /*
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int year = scanner.nextInt();
            int hour = scanner.nextInt();
            int minutes = scanner.nextInt();

            //lat & long
            double cur_lat = scanner.nextDouble(); //lat2
            double cur_long = scanner.nextDouble(); //long2

            //phone number
            long phone = scanner.nextLong();

            String check = scanner.nextLine();
            if(check == null) break;
            */
            //d = 2 × r × arcsin (sqrt (sin2((lat1 - lat2)/2) + cos(lat1) × cos(lat2) × sin2((long1 - long2)/2)))
            //double d = 2 * E_RADIUS * Math.asin(Math.sqrt(Math.pow(Math.sin((lat1 - lat2)/2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin((long1 - long2)/2), 2)));
            //double d = 2 * E_RADIUS * Math.asin(Math.sqrt(Math.pow(Math.sin((LAT - cur_lat)/2), 2) + Math.cos(LAT) * Math.cos(cur_lat) * Math.pow(Math.sin((LONG - cur_long)/2), 2)));

            /*
            double d = haversine(LAT, cur_lat, LONG, cur_long);

            if(d < RADIUS){
                if(!p_numbers.contains(phone)){ //if doesn't contain - add phone number to list; add minutes and hours to appropriate hashmaps
                    p_numbers.add(phone);
                    phoneMap.put(phone, date);
                    //hoursMap.put(phone, hour);
                    //minutesMap.put(phone, minutes);
                }
                else{   //if contains - check which is more recent
                    if(date.after(phoneMap.get(phone))){
                        p_numbers.remove(phone);
                        p_numbers.add(phone);
                        phoneMap.put(phone, date);
                    }

             */
                    /*
                    if(hour > hoursMap.get(phone) ||
                            (hour == hoursMap.get(phone) && minutes > minutesMap.get(phone))){
                        p_numbers.remove(phone);
                        p_numbers.add(phone);
                        hoursMap.put(phone, hour);
                        minutesMap.put(phone, minutes);
                    }

                     */
/*
                }
            }
        }




        Collections.sort(p_numbers);
        for (int i = 0; i < p_numbers.size(); i++) {
            System.out.print(p_numbers.get(i));
            if(i != p_numbers.size()-1)
                System.out.print(",");
        }
*/
    }

    private static double haversine(double lat1, double lat2, double long1, double long2) {
        double lat = Math.toRadians(lat2 - lat1);
        double lon = Math.toRadians(long2 - long1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(lat / 2), 2)
                + Math.pow(Math.sin(lon / 2), 2)
                * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return E_RADIUS * c;

    }
}