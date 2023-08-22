import java.util.*;
import java.io.*;

public class april2016silv_fieldReduction {

	public static void main(String[] args) throws Exception {
		BufferedReader stdin = new BufferedReader(new FileReader("reduce.in"));
		StringTokenizer tok = new StringTokenizer(stdin.readLine());
		int n = Integer.parseInt(tok.nextToken());
        pt[] pts = new pt[n];
        for (int i = 0; i < n; i++) {
            tok = new StringTokenizer(stdin.readLine());
            int x = Integer.parseInt(tok.nextToken());
            int y = Integer.parseInt(tok.nextToken());
            pts[i] = new pt(x,y);
        }

		Arrays.sort(pts);
		for (int i = 0; i < 3; i++)
			pts[i].canRemove = true;
		for (int i = n - 3; i < n; i++)
			pts[i].canRemove = true;

		Arrays.sort(pts, new ptCmpY());
		for (int i=0; i<3; i++)
			pts[i].canRemove = true;
		for (int i = n - 3; i < n; i++)
			pts[i].canRemove = true;

		ArrayList<Integer> removable = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			if (pts[i].canRemove)
				removable.add(i);

		int res = 2000000000;
		for (int mask=0; mask<(1<<(removable.size())); mask++) {

			if (Integer.bitCount(mask) != 3) continue;

			ArrayList<Integer> exclude = new ArrayList<Integer>();
			for (int i=0; i<removable.size(); i++)
				if ((mask & (1<<i)) > 0)
					exclude.add(removable.get(i));
			res = Math.min(res, area(pts, exclude));
		}
		PrintWriter out = new PrintWriter(new FileWriter("reduce.out"));
		out.println(res);
		out.close();
		stdin.close();
	}

	public static int area(pt[] pts, ArrayList<Integer> exclude) {

        int minX = 100000, maxX = 0;
        int minY = 100000, maxY = 0;

        for (int i=0; i<pts.length; i++) {
            if (exclude.contains(i)) continue;
            minX = Math.min(minX, pts[i].x);
            maxX = Math.max(maxX, pts[i].x);
            minY = Math.min(minY, pts[i].y);
            maxY = Math.max(maxY, pts[i].y);
        }

        return (maxX-minX)*(maxY-minY);
	}
}

class pt implements Comparable<pt> {

    public int x;
    public int y;
	public boolean canRemove;

    public pt(int myx, int myy) {
        x = myx;
        y = myy;
    	canRemove = false;
    }

    public int compareTo(pt other) {
        return this.x - other.x;
    }
}

class ptCmpY implements Comparator<pt> {
	public int compare(pt a, pt b) {
		return a.y - b.y;
	}
}
