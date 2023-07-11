import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Photoshoot {
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(in.readLine());
        char[] arr = in.readLine().toCharArray();
        int prt = 0;
        for (int j = x - 2; j >= 0; j -= 2) {
            if (arr[j] != arr[j + 1] && (arr[j] == 'G') == (prt % 2 == 0)) {
                prt++;
            }
        }
        System.out.println(prt);
    }
}
