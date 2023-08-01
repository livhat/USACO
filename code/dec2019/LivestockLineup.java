import java.util.*;
import java.io.*;

public class LivestockLineup {
	public static int x;
	public static int[][] arr;
	final public static String[] cows = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};

	
	public static void main(String[] args) throws Exception {
		HashMap<String,Integer> temp = new HashMap<String,Integer>();
		for (int i = 0; i < cows.length; i++) temp.put(cows[i], i);
		Scanner in = new Scanner(new File("lineup.in"));
		x = in.nextInt();

		arr = new int[x][2];
		
		for (int i = 0; i < x; i++) {
			arr[i][0] = temp.get(in.next());
			for (int j = 0; j < 4; j++) in.next();
			arr[i][1] = temp.get(in.next());
		}
		
		int[] y = new int[cows.length];
		boolean[] z = new boolean[cows.length];
		go(y, z, 0);
		
		PrintWriter out = new PrintWriter(new FileWriter("lineup.out"));
		for (int i = 0; i < cows.length; i++)
			out.println(cows[y[i]]);
		out.close();		
		in.close();
	}
	
	public static boolean go(int[] y, boolean[] z, int x) {
		if (x == y.length) return verify(y);
		for (int i = 0; i < y.length; i++) {
			if (!z[i]) {
				y[x] = i;
				z[i] = true;
				boolean temp = go(y, z, x+1);
				if (temp) return true;
				z[i] = false;
			}
		}
		return false;
	}
	
	public static boolean verify(int[] y) {
		int[] indexOf = new int[y.length];
		for (int i = 0; i < y.length; i++)
			indexOf[y[i]] = i; 
		for (int i = 0; i < x; i++) 
			if (Math.abs(indexOf[arr[i][0]] - indexOf[arr[i][1]]) != 1)
				return false;
		return true;
	}
}
