import java.io.*;
import java.util.StringTokenizer;


public class WordProcessor {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("word.in"));
		PrintWriter pw = new PrintWriter("word.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String[] essay = r.readLine().split(" "); 
		int letter_count = essay[0].length();
		pw.print(essay[0]);
		
		for (int i=1; i<N; i++) {
			if (letter_count + essay[i].length() > K) {
				pw.println();
				pw.print(essay[i]);
				letter_count = 0;
			}
			else {
				pw.print(" "+essay[i]);
			}
			letter_count += essay[i].length();
		}
		
		pw.close();
	}
}
