
import java.util.*;
import java.io.*;

public class dec2019_whereAmI {

	public static void main(String[] args) throws Exception {
		Scanner stdin = new Scanner(new File("whereami.in"));
		PrintWriter out = new PrintWriter(new FileWriter("whereami.out"));
		int n = stdin.nextInt();
		String s = stdin.next();
		
		int res = -1;

		for (int i=1; i<=n; i++) {
			boolean ok = true;
			HashSet<String> set = new HashSet<String>();
			for (int j=0; j<n-i+1; j++) {
				String tmp = s.substring(j, j+i);
				if (set.contains(tmp)) {
					ok = false;
					break;
				}
				set.add(tmp);
			}
			if (ok) {
				res = i;
				break;
			}
		}
		
		out.println(res);
		out.close();		
		stdin.close();
	}
}
