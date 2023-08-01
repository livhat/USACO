import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
 
public class ReverseEngineering {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int t = in.nextInt(); t > 0; t--) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            List<String> instances = new ArrayList<>();
            for (; m > 0; m--) {
                instances.add(in.nextLine());
            }
            while (true) {
                int oldSize = instances.size();
                for (int k = 0; k < n; k++) {
                    for (char bit = '0'; bit <= '1'; bit++) {
                        int pos = 0;
                        for (String instance : instances) {
                            if (instance.charAt(k) == bit) {
                                pos |= 1 << (instance.charAt(n + 1) - '0');
                            }
                        }
                        if (pos != 3) {
                            int finalK = k;
                            char finalBit = bit;
                            instances.removeIf(instance -> instance.charAt(finalK) == finalBit);
                        }
                    }
                }
                int newSize = instances.size();
                if (newSize == oldSize) {
                    break;
                }
            }
            if (new HashSet<>(instances).isEmpty()) {
                System.out.println("OK");
            } else {
                System.out.println("LIE");
            }
        }
    }
}
