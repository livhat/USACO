import java.io.*;
import java.util.*;

public class feb2016_milkPails {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("pails.in"));
		PrintWriter out = new PrintWriter("pails.out");
		StringTokenizer input = new StringTokenizer(in.readLine());
		in.close();

		int x = Integer.parseInt(input.nextToken());
		int y = Integer.parseInt(input.nextToken());
		int z = Integer.parseInt(input.nextToken());

		int temp = 0;
		
		for (int first = 0; first <= z; first++) {
			if (x * first > z) { break; }
			for (int second = 0; second <= z; second++) {
				int n = (x * first) + (y * second);
				if (n > z) { break; }
				temp = Math.max(temp, n);
			}
		}

		out.println(temp);
		out.close();
	}
}
