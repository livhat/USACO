import java.io.*;
import java.util.*;

public class Jan2017_Last {
    static class Cow implements Comparable<Cow> {
        String name;
        int milk;

        public int compareTo(Cow c) {
            return this.milk - c.milk;
        } 
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("notlast.in"));
        PrintWriter out = new PrintWriter("notlast.out");

        int N = s.nextInt();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Bessie", 0);
        map.put("Elsie", 0);
        map.put("Daisy", 0);
        map.put("Gertie", 0);
        map.put("Annabelle", 0);
        map.put("Maggie", 0);
        map.put("Henrietta", 0);

        for (int i = 0; i < N; i++) {
            String name = s.next();
            int milk = s.nextInt();

            int cow = map.get(name);
            cow += milk;
            map.put(name, cow);
        }
        Cow[] cows = new Cow[7];

        int i = 0;
        for (String key : map.keySet()) {
            int milk = map.get(key);

            Cow cow = new Cow();
            cow.name = key;
            cow.milk = milk;

            cows[i++] = cow;
        }

        Collections.sort(cows);

        int lowestMilk = cows[0].milk;
        for (int i = 1; i < 7; i++) {
            if (cows[i].milk != lowestMilk) {
                if (i != 6 && cows[i + 1].milk == cows[i].milk)
                    System.out.println("Tie");
                else
                    System.out.println(cows[i].name);
                break;
            }
        }
    }
}
