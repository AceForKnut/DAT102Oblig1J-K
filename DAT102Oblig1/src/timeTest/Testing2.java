package timeTest;
import java.time.Duration;
import java.time.Instant;

public class Testing2 {

    public static int AlgA(int n) {
        int sum = 0;
        for(int i = 1; i<= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Instant start = Instant.now(); // Record the start time

        System.out.print(AlgA(100000000));

        Instant end = Instant.now(); // Record the end time
        Duration duration = Duration.between(start, end); // Calculate the duration
        System.out.println("\nTime taken: " + duration.toMillis() + " milliseconds");
    }
}

