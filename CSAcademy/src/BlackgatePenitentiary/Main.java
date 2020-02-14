package BlackgatePenitentiary;

// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Crew {
    private String name;
    private int height;

    Crew(String name, int height){
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

}
class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine().trim());

        HashMap<String, TreeSet<Crew>> heights = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(" ");
            String name = line[0];
            String height = line[1];

            if(heights.containsKey(height)){
                //add to queue
                heights.get(height).add(new Crew(name, Integer.parseInt(height)));
            }
            else{
                //create new queue
                TreeSet<Crew> ts = new TreeSet<>(new Comparator<Crew>() {
                    @Override
                    public int compare(Crew o1, Crew o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                Crew c = new Crew(name, Integer.parseInt(height));

                ts.add(c);
                heights.put(height, ts);
            }

        }

        //print
        for (int i = 120, j = 0; i <= 250; i++) {
            String check_height = String.valueOf(i);
            if(heights.containsKey(check_height)){

                TreeSet<Crew> ts = heights.get(check_height);
                ts.stream().forEach(s-> System.out.print(s.getName() + " "));

                System.out.print(++j + " ");
                j += ts.size()-1;
                System.out.print(j + "\n");

            }
        }
    }
}