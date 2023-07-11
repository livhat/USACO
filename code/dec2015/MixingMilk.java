import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class dec2015_mixingMilk {
	final public static int NUMBUCKETS = 3;
	final public static int NUMPOURS = 100;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("mixmilk.in"));
		PrintWriter out = new PrintWriter(new FileWriter("mixmilk.out"));
		int[] x = new int[NUMBUCKETS];
		int[] y = new int[NUMBUCKETS];

		for (int i = 0; i < NUMBUCKETS; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}

		for (int i = 0; i < NUMPOURS; i++) {
			int from = i % NUMBUCKETS;
			int to = (i + 1) % NUMBUCKETS;
			int transfer = Math.min(y[from], x[to] - y[to]);
			y[from] -= transfer;
			y[to] += transfer;
		}

		
		for (int i = 0; i < NUMBUCKETS; i++)
			out.println(y[i]);
		out.close();
		in.close();
	}
}
