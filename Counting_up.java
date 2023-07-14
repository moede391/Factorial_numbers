import java.math.BigDecimal;
import java.util.Scanner;

public class Counting_up {
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

            BigDecimal result = calculateBinomialCoefficient(n, k);
            System.out.println(result.toPlainString());
        }
        sc.close();
    }

    public static BigDecimal calculateBinomialCoefficient(long n, long k) {
        if (k > n - k) {
            k = n - k;
        }

        if (k == 0 || k == n) {
            return BigDecimal.ONE;
        }

        BigDecimal numerator = BigDecimal.ONE;
        BigDecimal denominator = BigDecimal.ONE;

        for (long i = 1; i <= k; i++) {
            numerator = numerator.multiply(BigDecimal.valueOf(n - i + 1));
            denominator = denominator.multiply(BigDecimal.valueOf(i));
        }

        return numerator.divide(denominator);
    }
}


