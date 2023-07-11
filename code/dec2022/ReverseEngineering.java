import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
 
public class ReverseEngineering{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = in.nextInt(); i > 0; t--) {
            int yo = in.nextInt();
            int wo = in.nextInt();
            in.nextLine();
            List<String> x = new ArrayList<>();
            for (; wo > 0; wo--) {
                x.add(in.nextLine());
            }
            while (true) {
                int oldSize = x.size();
                for (int k = 0; k < yo; k++) {
                    for (char bit = '0'; bit <= '1'; bit++) {
                        int pos = 0;
                        for (String count : x) {
                            if (count.charAt(k) == bit) {
                                pos |= 1 << (count.charAt(yo + 1) - '0');
                            }
                        }
                        if (pos != 3) {
                            int finalK = k;
                            char finalBit = bit;
                            x.removeIf(count -> count.charAt(finalK) == finalBit);
                        }
                    }
                }
                int newSize = x.size();
                if (newSize == oldSize) {
                    break;
                }
            }
            if (new HashSet<>(x).isEmpty()) {
                System.out.println("OK");
            } else {
                System.out.println("LIE");
            }
        }
    }
}
