import java.io.*;

public class Teleportation {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter pw = new PrintWriter("teleport.out");

		String[] input = r.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int x = Integer.parseInt(input[2]);
		int y = Integer.parseInt(input[3]);

		int result = Math.abs(a - b);

		result = Math.min(result, Math.abs(a - x) + Math.abs(b - y));
		result = Math.min(result, Math.abs(a - y) + Math.abs(b - x));
		pw.println(result);
		pw.close();
	}
}
