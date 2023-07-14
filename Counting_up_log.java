import java.util.Scanner;

public class Counting_up_log {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            String[] sl = input.split(" ");
            long n = Long.parseLong(sl[0]);
            long k = Long.parseLong(sl[1]);

            if (n < 0 || k < 0 || k > n) {
                throw new IllegalArgumentException("Invalid input");
            }

            long result = calculateBinomialCoefficient(n, k);
            System.out.println(result);
        }
        sc.close();
    }

    public static long calculateBinomialCoefficient(long n, long k) {
        if (k > n - k) {
            k = n - k;
        }

        if (k == 0 || k == n) {
            return 1;
        }

        double logResult = 0;

        for (long i = 1; i <= k; i++) {
            logResult += Math.log(n - i + 1) - Math.log(i);
        }

        return Math.round(Math.exp(logResult));
    }
}