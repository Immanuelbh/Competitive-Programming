package CSAcademy.src.VangelisTheBatbearAndTheBubblesChallange;

// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {

    static int[] vertices;

    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        //find cycle in graph

        int t = Integer.parseInt(in.nextLine());

        for (int i = 0; i < t; i++) {
            String[] line = in.nextLine().split(" ");
            int num_vertices = Integer.parseInt(line[0]);
            int num_edges = Integer.parseInt(line[1]);


            if(num_edges >= num_vertices || num_edges < 3){
                System.out.println(1);
                in.nextLine();
                continue;
            }

            vertices = new int[num_vertices];
            for (int j = 0; j < num_vertices; j++) {
                vertices[j] = j;
            }

            line = in.nextLine().split(" ");
            int found = 0;
            for (int j = 0; j < line.length; j+=2) {

                found = 0;
                int root1 = findRoot(Integer.parseInt(line[j]));
                int root2 = findRoot(Integer.parseInt(line[j+1]));
                if(root1 == root2){
                    found = 1;
                    break;
                }
                else vertices[root1] = root2;
            }
            System.out.println(found);


        }

    }

    private static int findRoot(int vertex) {
        if(vertices[vertex] == vertex) return vertex;
        else return vertices[vertex] = findRoot(vertices[vertex]);
    }
}