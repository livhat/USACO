import java.io.*;
import java.util.*;
public class dec2015_contaminatedMilk {
	static int[] personDrinkCount;
	static int[] milkDrinkCount;
	static int[] timeDrinkCount;
	static int[] pSick;
	static int[] tSick;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("badmilk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		personDrinkCount = new int[d];
		milkDrinkCount = new int[d];
		timeDrinkCount = new int[d];
		
		for(int i = 0; i < d; i++) {
			st = new StringTokenizer(in.readLine());
			personDrinkCount[i] = Integer.parseInt(st.nextToken());
			milkDrinkCount[i] = Integer.parseInt(st.nextToken());
			timeDrinkCount[i] = Integer.parseInt(st.nextToken());
		}
		
		pSick = new int[s];
		tSick = new int[s];
		for(int i = 0; i < s; i++) {
			st = new StringTokenizer(in.readLine());
			pSick[i] = Integer.parseInt(st.nextToken());
			tSick[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxCanGetSick = 0;
		
		for(int i = 1; i <= m; i++) {
			if(milkTypeCanBeBad(i)) {
				int numDrank = numPeopleDrink(i);
				if(numDrank > maxCanGetSick) {
					maxCanGetSick = numDrank;
				}
			}
		}
		
		out.println(maxCanGetSick);

		out.close();
	}

	private static boolean milkTypeCanBeBad(int milkType) {
		for(int i = 0; i < pSick.length; i++) {	
			if(!personDrankMilkBefore(pSick[i], milkType, tSick[i])) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean personDrankMilkBefore(int person, int milkType, int time) {
		for(int i = 0; i < personDrinkCount.length; i++) {
			if(personDrinkCount[i] == person && milkDrinkCount[i] == milkType && timeDrinkCount[i] < time) {
				return true;
			}
		}
		return false;
	}

	private static int numPeopleDrink(int milkType) {
		boolean[] didDrink = new boolean[51];
		for(int i = 0; i < personDrinkCount.length; i++) {
			if(milkDrinkCount[i] == milkType) {
				didDrink[personDrinkCount[i]] = true;
			}
		}
		int numPeopleDrink = 0;
		for(int i = 1; i < didDrink.length; i++) {
			if(didDrink[i]) {
				numPeopleDrink++;
			}
		}
		return numPeopleDrink;
	}
	
}
