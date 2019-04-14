import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        //count init and map strings
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            int start = 0, end = i;
            List<String> temp = new ArrayList<String>();
            while (end <= s.length()) {
                //check for anagrams in temp
                //anagrams must be connected and the sorted char array must equal
                String gram = s.substring(start, end);
                for (String j : temp) {
                    char str1[] = j.toCharArray();
                    char str2[] = gram.toCharArray();
                    // Sort both strings
                    Arrays.sort(str1);
                    Arrays.sort(str2);
                    Boolean equals = true;
                    // Compare sorted strings
                    for (int k = 0; k < str1.length; k++) {
                        if (str1[k] != str2[k]) {
                            equals = false;
                        }
                    }
                    if (equals) {
                        count++;
                    }
                }
                temp.add(gram);
                start++;
                end++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
