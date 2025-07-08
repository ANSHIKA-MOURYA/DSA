import java.util.*;

public class subarrayWithEqual0_1_2 {
    public static int countEqual012(int[] arr) {
        int c0 = 0, c1 = 0, c2 = 0;
        int count = 0;

        // Map to store key as "diff1#diff2" → frequency
        Map<String, Integer> freqMap = new HashMap<>();
        freqMap.put("0#0", 1); // Base case: prefix before start

        for (int num : arr) {
            // Update counts
            if (num == 0) c0++;
            else if (num == 1) c1++;
            else if (num == 2) c2++;

            // Calculate differences
            int diff10 = c1 - c0;
            int diff21 = c2 - c1;
            String key = diff10 + "#" + diff21;

            // If key seen before, add its frequency to result
            count += freqMap.getOrDefault(key, 0);

            // Update map
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 0, 1, 0};
        System.out.println("Total Subarrays: " + countEqual012(arr)); // Output: 2
    }
}
