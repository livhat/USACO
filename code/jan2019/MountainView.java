import java.io.*;
import java.util.*;

public class Jan2019_MountainView {
    public static void main(String[] args) { throws Exception {
        Scanner s = new Scanner(new File("mountains.in"));
        PrintWriter out = new PrintWriter("mountains.out");

        int N = s.nextInt();
        int[] coords = new int[N * 2];

        for (int i = 0; i < N; i++) {
            int x = s.nextInt(), 
                y = s.nextInt();
            
            coords[i * 2] = x;
            coords[i * 2 + 1] = y;
        }

        int total = 0;
        top: for (int i = 0; i < N; i++) {
            int i_coords = i * 2;

            int x_i = coords[i_coords],
                y_i = coords[i_coords + 1];
            for (int j = 0; j < N; j++) {
                int j_coords = j * 2;
                int x_j = coords[j_coords],
                    y_j = coords[j_coords + 1];

                if (i == j)
                    continue;


                int x_distance = Math.abs(x_i - x_j),
                    y_distance = y_j - y_i;
                
                if (x_distance <= y_distance)
                    continue top;
            }

            total++;
        }

        out.close();
    }
}
