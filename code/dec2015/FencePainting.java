
import java.util.*;
import java.io.*;
public class dec2015_fencePainting {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(new File("paint.in"));
		PrintWriter out = new PrintWriter("paint.out");
		
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		int d = s.nextInt();
		
		int temp = a;
		if(c < a) {
			a = c;
			c = temp;
			temp = b;
			b = d;
			d = temp;
		}
		
		int count = 0;
		
		if(c >= b) {
			count = (b-a) + (d-c);
		}
		else {
			if(d > b) {
				count = d - a;
			}
			else {
				count = b - a;
			}
		}
			
		
		out.println(count);
		
		out.close();
		
		
	}
}
