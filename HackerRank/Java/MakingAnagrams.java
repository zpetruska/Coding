import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        // initalize count and maps for string chars
        int count = 0;
        Map<String, Integer> amap = new HashMap<>();
        Map<String, Integer> bmap = new HashMap<>();
        for (String i : a.split("")) {
            amap.merge(i, 1, Integer::sum);
        }
        for (String i : b.split("")) {
            bmap.merge(i, 1, Integer::sum);
        }
        // count deletions for string b
        for (String i : b.split("")) {
            if (amap.get(i) == null || amap.get(i) < 1) {
                count++;
            } else {
                amap.merge(i, -1, Integer::sum);
            }
        }
        // count deletions for string a
        for (String i : a.split("")) {
            if (bmap.get(i) == null || bmap.get(i) < 1) {
                count++;
            } else {
                bmap.merge(i, -1, Integer::sum);
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
