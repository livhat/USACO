import java.io.*;
import java.util.*;
public class feb2019_sleepyCowHerding {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("herding.in"));
		PrintWriter out = new PrintWriter(new File("herding.out"));
		int[] cows = new int[3];
		cows[0] = in.nextInt();
		cows[1] = in.nextInt();
		cows[2] = in.nextInt();
		Arrays.sort(cows);
		if (cows[2] == cows[0] + 2) {
			out.println(0);
		} else if (cows[1] == cows[0] + 2 || cows[2] == cows[1] + 2) {
			out.println(1);
		} else {
			out.println(2);
		}
		out.println(Math.max(cows[1] - cows[0], cows[2] - cows[1]) - 1);
		out.close();
	}
}
