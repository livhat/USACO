import java.util.*;

public class AirCownditioning_Jan2023 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(), 
			M = s.nextInt();
		
		int[] si = new int[N], ti = new int[N], ci = new int[N];
		
		for (int i = 0; i < N; i++) {
			si[i] = s.nextInt();
			ti[i] = s.nextInt();
			ci[i] = s.nextInt();
		}
		
		int[] ai = new int[M], bi = new int[M], pi = new int[M], mi = new int[M];
		for (int i = 0; i < M; i++) {
			ai[i] = s.nextInt();
			bi[i] = s.nextInt();
			pi[i] = s.nextInt();
			mi[i] = s.nextInt();
		}
		
		int max = 1 << M;
		int lowestCost = 1000000000;
		top: for (int i = 0; i < max; i++) {
			int[] stalls = new int[101];
			int totalCost = 0;
			for (int j = 0; j < M; j++) {
				if ((i & (1 << j)) != 0) { 
					for (int k = ai[j]; k <= bi[j]; k++) {
						stalls[k] += pi[j];
					}
					totalCost += mi[j];
				}
			}

			for (int j = 0; j < N; j++) {

				for (int k = si[j]; k <= ti[j]; k++) { 
					if (stalls[k] < ci[j])
						continue top;
				}
			}
			
			lowestCost = Math.min(lowestCost, totalCost);
		}
		
		System.out.println(lowestCost);
	}
}
