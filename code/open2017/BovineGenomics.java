import java.util.*;
import java.io.*;

public class Open2017_BovineGenomics {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("paint.in"));
        PrintWriter out = new PrintWriter("paint.out");

        int N = s.nextInt(), 
            M = s.nextInt(); 
        
        int[][] spotty = new int[N][M];
        int[][] plain = new int[N][M];

        boolean[] set = new boolean[4];

        for (int i = 0; i < N; i++) {
            String s = s.next();
            for (int j = 0; j < s.length(); j++)
                switch (s.charAt(j)) {
                    case 'A': spotty[i][j] = 0; break;
                    case 'C': spotty[i][j] = 1; break;
                    case 'G': spotty[i][j] = 2; break;
                    case 'T': spotty[i][j] = 3; break;
                }
        }
        for (int i = 0; i < N; i++) {
            String s = s.next();
            for (int j = 0; j < s.length(); j++)
                switch (s.charAt(j)) {
                    case 'A': plain[i][j] = 0; break;
                    case 'C': plain[i][j] = 1; break;
                    case 'G': plain[i][j] = 2; break;
                    case 'T': plain[i][j] = 3; break;
                }
        }

        int uniquePositions = 0;
        outer: for (int i = 0; i < M; i++) {
            set[0] = set[1] = set[2] = set[3] = false;
            for (int j = 0; j < N; j++)
                set[spotty[j][i]] = true;
            

            for (int j = 0; j < N; j++)
                if(plain[j][i] == true)
                    continue outer;

            uniquePositions++;
        }

        System.out.println(uniquePositions);

        out.close();
    }
}
