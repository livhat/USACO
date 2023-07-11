
import java.util.*;
import java.io.*;

public class dec2015_speedingTicket {

	final public static int DISTANCE = 100;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new FileReader("speeding.in"));
		FileWriter out = new FileWriter(new File("speeding.out"));
		StringTokenizer x = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(x.nextToken());
		int m = Integer.parseInt(x.nextToken());

		int[] limits = new int[DISTANCE];
		int mile = 0;

		for (int i = 0; i < n; i++) {
			x = new StringTokenizer(in.readLine());
			int dist = Integer.parseInt(x.nextToken());
			int speed = Integer.parseInt(x.nextToken());
			for (int j = 0; j < dist; j++)
				limits[mile++] = speed;
		}

		int[] bessie = new int[DISTANCE];
		mile = 0;
		for (int i = 0; i < m; i++) {
			x = new StringTokenizer(in.readLine());
			int dist = Integer.parseInt(x.nextToken());
			int speed = Integer.parseInt(x.nextToken());
			for (int j = 0; j < dist; j++)
				bessie[mile++] = speed;
		}

		int res = 0;
		for (int i = 0; i < DISTANCE; i++)
			res = Math.max(res, bessie[i] - limits[i]);

		out.write(res + "\n");
		out.close();
	}
}
