

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PromotionCounting 
{
	public static void main (String args[]) throws IOException
	{
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
		BufferedReader br = new BufferedReader(new FileReader("promote.in"));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		int bronzebefore = Integer.parseInt(st.nextToken());
		int bronzeafter = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int silverbefore = Integer.parseInt(st.nextToken());
		int silverafter = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int goldbefore = Integer.parseInt(st.nextToken());
		int goldafter = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int platbefore = Integer.parseInt(st.nextToken());
		int platafter = Integer.parseInt(st.nextToken());
		int goldpromo = platafter - platbefore;
		int silverpromo = goldafter - goldbefore + goldpromo;
		int bronzepromo = silverafter - silverbefore + goldafter - goldbefore + platafter - platbefore;
		pw.println(bronzepromo);
		pw.println(silverpromo);
		pw.println(goldpromo);
		pw.close();
	}
}
