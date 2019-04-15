// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class NailingPlanks {
    public int solution(int[] A, int[] B, int[] C) {
        /// find the minimum number of nails that must be used until all the planks are nailed
        // return -1 of all planks cant be nailed
        //store nails index and position in array
        int[][] nails = new int[C.length][2];
        for (int i = 0; i < C.length; i++) {
            nails[i][0] = C[i];
            nails[i][1] = i;//store original index before sorting
        }
        Arrays.sort(nails, (x, y) -> Integer.compare(x[0], y[0]));
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            //find the earlist position that can nail each plank, and the max value for all planks is the result
            result = getMinIndex(A[i], B[i], nails, result);
            if (result == -1)
                return -1;
        }
        return result + 1;
    }
    // Use binary search to get the left most index of the nails
    public int getMinIndex(int startPlank, int endPlank, int[][] nails, int preIndex) {
        int min = 0;
        int max = nails.length - 1;
        int left = -1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (nails[mid][0] < startPlank) {
                min = mid + 1;
            } else if (nails[mid][0] > endPlank) {
                max = mid - 1;
            } else {
                max = mid - 1;
                left = mid;
            }
        }
        //nails couldn't find the plank
        if (left == -1) {
            return -1;
        }
        int minIndex = nails[left][1];
        //find the left most nail for the plank
        for (int i = left; i < nails.length; i++) {
            if (nails[i][0] > endPlank) {
                break;
            }
            minIndex = Math.min(minIndex, nails[i][1]);//compare to orginal index
            if (minIndex <= preIndex) {
                return preIndex;
            }
        }
        return minIndex;
    }
}