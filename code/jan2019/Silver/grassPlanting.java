import java.io.*;
import java.util.*;

public class jan2019silv_grassPlanting {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader stdin = new BufferedReader(new FileReader("planting.in"));
		int n = Integer.parseInt(stdin.readLine().trim());
		int[] deg = new int[n];
		
		for (int i=0; i<n-1; i++) {
			StringTokenizer tok = new StringTokenizer(stdin.readLine());
			int v1 = Integer.parseInt(tok.nextToken())-1;
			int v2 = Integer.parseInt(tok.nextToken())-1;
			deg[v1]++;
			deg[v2]++;
		}
		int res = deg[0]+1;
		for (int i=1; i<n; i++) res = Math.max(res, deg[i]+1);
		
		PrintWriter out = new PrintWriter(new FileWriter("planting.out"));
		out.println(res);
		out.close();
		stdin.close();		
	}

}
