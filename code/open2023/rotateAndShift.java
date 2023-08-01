import java.util.Scanner;

public class RotateAndShift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int T = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int[] output = new int[N];
        for (int i = 0; i < N; i++) {
            output[i] = i;
        }

        for (int t = 0; t < T; t++) {
            A = update_pos(output, A, N, K);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(output[i]);
            if (i != N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static int[] update_pos(int[] output, int[] A, int N, int K) {
        int temp = output[A[K - 1]];
        for (int i = K - 2; i >= 0; i--) {
            int src = A[i];
            int dst = A[i + 1];
            output[dst] = output[src];
        }
        output[A[0]] = temp;
        for (int i = 0; i < N; i++) {
            A[i] = (i + 1) % N;
        }
        return A;
    }
}
