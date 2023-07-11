import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class jan2019_shellGame {
  public static void main(String[] args) throws IOException {
	  try(Scanner in = new Scanner(new File("shell.in"));
	  PrintWriter out = new PrintWriter(new File("shell.out"));) {
		  
      int[] result = new int[4];
      int[] shells = new int[] {0, 1, 2, 3};
      
      int count = in.nextInt();
      
      for (int i = 1; i <= count; i++) {
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int temp = shells[x];
        
        shells[x] = shells[y];
        shells[y] = temp; 
        
        result[shells[z]]++;                           
      }
      int max = Math.max(result[1], result[2]);
      out.println(Math.max(max, result[3]));
    }

  }

}
