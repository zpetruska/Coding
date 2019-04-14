import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountingTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> myBum, long r) {
        long count = 0;
        Map<Long, Integer> left = new HashMap<>();
        Map<Long, Integer> right = new HashMap<>();
        for (long pp : myBum) {
            left.put(pp, 0);
            // increase the count in right map
            right.merge(pp, 1, Integer::sum);
        }
        for (long pp : myBum) {
            long lCount = 0, rCount = 0;
            // divisble by common ratio
            if (pp % r == 0 && left.get(pp / r) != null) {
                lCount = left.get(pp / r);
            }
            // decrease the count in right map
            right.merge(pp, -1, Integer::sum);
            // increase the count in left map
            left.merge(pp, 1, Integer::sum);
            // number of right elements
            if (right.get(pp * r) != null) {
                rCount = right.get(pp * r);
            }
            // calculate the answer
            count += lCount * rCount;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
