import java.util.*;

public class longestCommonSpan {
    public static int longestCommonSum(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] diff = new int[n];

        // Step 1: Create difference array
        for (int i = 0; i < n; i++) {
            diff[i] = arr1[i] - arr2[i];
        }

        // Step 2: Find longest subarray with sum = 0
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int prefixSum = 0;
        map.put(0, -1); // Base case

        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];

            if (map.containsKey(prefixSum)) {
                int len = i - map.get(prefixSum);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 1, 1, 1, 1};
        int[] arr2 = {1, 1, 1, 0, 0, 1, 0};

        int result = longestCommonSum(arr1, arr2);
        System.out.println("Longest Span with Same Sum: " + result);  // Output: 6
    }
}
