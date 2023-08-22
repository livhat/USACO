import java.util.*;
import java.io.*;

public class open2018_familyTree {

	public static int n;
	public static String[][] input;
	public static HashMap<String,Integer> map;
	public static node[] cows;

	public static void main(String[] args) throws Exception {
		Scanner stdin = new Scanner(new File("family.in"));
		n = stdin.nextInt();
		map = new HashMap<String,Integer>();
		map.put(stdin.next(), 0);
		map.put(stdin.next(), 1);

		int id = 2;
		input = new String[n][2];
		for (int i=0; i<n; i++) {
			for (int j=0; j<2; j++) {
				input[i][j] = stdin.next();
				if (!map.containsKey(input[i][j]))
					map.put(input[i][j], id++);
			}
		}
		cows = new node[id];
		Arrays.fill(cows, null);
		for (int i=0; i<n; i++)
			for (int j=0; j<2; j++)
				if (cows[map.get(input[i][j])] == null)
					cows[map.get(input[i][j])] = new node(input[i][j]);

		for (int i=0; i<n; i++) {
			int momI = map.get(input[i][0]);
			int kidI = map.get(input[i][1]);
			cows[momI].kids.add(cows[kidI]);
			cows[kidI].mom = cows[momI];
		}
		PrintWriter out = new PrintWriter(new FileWriter("family.out"));
		out.println(solve());
		out.close();
		stdin.close();
	}

	
	public static String solve() {
		ArrayList<node> bList = new ArrayList<node>();
		node bStart = cows[1];
		bList.add(bStart);
		int iter = 0;
		while (true) {
			if (bStart == cows[0]) {
				if (iter == 1) return cows[0]+" is the mother of "+cows[1];
				if (iter == 2) return cows[0]+" is the grand-mother of "+cows[1];
				String ret = "";
				for (int i=2; i<iter; i++) ret = ret + "great-";
				return cows[0]+" is the "+ret+"grand-mother of "+cows[1];
			}
			node tmp = bStart.mom;
			if (tmp == null) break;
			else {
				bStart = tmp;
				bList.add(bStart);
			}
			iter++;
		}
		ArrayList<node> eList = new ArrayList<node>();
		node eStart = cows[0];
		eList.add(eStart);
		int iter2 = 0;
		while (true) {
			if (eStart == cows[1]) {
				if (iter2 == 1) return cows[1]+" is the mother of "+cows[0];
				if (iter2 == 2) return cows[1]+" is the grand-mother of "+cows[0];
				String ret = "";
				for (int i=2; i<iter2; i++) ret = ret + "great-";
				return cows[1]+" is the "+ret+"grand-mother of "+cows[0];
			}
			node tmp = eStart.mom;
			if (tmp == null) break;
			else {
				eStart = tmp;
				eList.add(eStart);
			}
			iter2++;
		}
		if (eStart != bStart) return "NOT RELATED";
		if (cows[0].mom != null && cows[0].mom == cows[1].mom) return "SIBLINGS";

		Collections.reverse(eList);
		Collections.reverse(bList);
		int i = 0;
		while (eList.get(i) == bList.get(i)) i++;
		i--;

		int eDown = eList.size() - i - 1;
		int bDown = bList.size() - i - 1;

		if (eDown == 1) {
			if (bDown == 2) return cows[0]+" is the aunt of "+cows[1];
			String ret = "";
			for (int j=2; j<bDown; j++) ret = ret + "great-";
			return cows[0]+" is the "+ret+"aunt of "+cows[1];
		}
		
		else if (bDown == 1) {
			if (eDown == 2) return cows[1]+" is the aunt of "+cows[0];
			String ret = "";
			for (int j=2; j<eDown; j++) ret = ret + "great-";
			return cows[1]+" is the "+ret+"aunt of "+cows[0];
		}
		
		else return "COUSINS";
	}
}

class node {

	public String name;
	public ArrayList<node> kids;
	public node mom;

	public node(String n) {
		name = n;
		kids = new ArrayList<node>();
		mom = null;
	}

	public String toString() {
		return name;
	}

}
