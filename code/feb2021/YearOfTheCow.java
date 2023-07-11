import java.util.*;

public class feb2021_yearOfTheCow {

	final public static String[] ANIMALS = {"Ox", "Tiger", "Rabbit", "Dragon",
	"Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};

	public static HashMap<String,Integer> map;
	public static HashMap<String,Integer> yearMap;
	
	public static void main(String[] args) {

		map = new HashMap<String,Integer>();
		for (int i=0; i<ANIMALS.length; i++)
			map.put(ANIMALS[i], i);

		yearMap = new HashMap<String,Integer>();
		yearMap.put("Bessie", 0);
	
		Scanner stdin = new Scanner(System.in);
		int nLines = stdin.nextInt();
		for (int loop=0; loop<nLines; loop++) {
			String[] line = new String[8];
			for (int  i=0; i<8; i++) line[i] = stdin.next();
			
			int secondYear = yearMap.get(line[7]);
			
			int mod12Year = (12000+secondYear)%12;
			
			int yearOffset = map.get(line[4]);
			
			int sign = line[3].equals("next") ? 1 : -1;
			
			if (mod12Year == yearOffset) 
				yearMap.put(line[0], secondYear + 12*sign);
			
			else {

				if (yearOffset > mod12Year) {
					if (sign == 1)	yearMap.put(line[0], secondYear + yearOffset - mod12Year);
					else			yearMap.put(line[0], secondYear + yearOffset - mod12Year-12);
				}

				else {
					if (sign == 1)	yearMap.put(line[0], secondYear + yearOffset - mod12Year+12);
					else			yearMap.put(line[0], secondYear + yearOffset - mod12Year);				
				}
			}
		}

		System.out.println(Math.abs(yearMap.get("Elsie")));
	}
}
