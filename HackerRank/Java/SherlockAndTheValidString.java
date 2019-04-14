import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SherlockAndTheValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        //map the chars in the string to int counts
        boolean ret = false;

        Map<String, Integer> chars = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        for (String i : s.split("")) {
            chars.merge(i, 1, Integer::sum);
        }
        //iterate over the chars counts and map them
        for (int i : chars.values()) {
            counts.merge(i, 1, Integer::sum);
        }
        //if map size > 2 ->no <2 yes
        if (counts.size() > 2) {
            return "NO";
        } else if (counts.size() < 2) {
            return "YES";
        } else {
            //if 2 and values contain 1 and logic ->yes else ->no
            List<Integer> keys = new ArrayList(counts.keySet());
            List<Integer> values = new ArrayList(counts.values());
            if (counts.values().contains(1)) {
                //key zero has the 1
                if (counts.get(keys.get(0)) == 1) {
                    ret = keys.get(0) == 1 || keys.get(0) == keys.get(1) + 1;
                } else {
                    ret = keys.get(1) == 1 || keys.get(1) == keys.get(0) + 1;
                }
            }
        }
        return ret ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
