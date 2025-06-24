import java.util.*;

public class firstKoccurence {
    public static int firstElementKTimes(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            if (freq.get(num) == k) {
                return num;
            }
        }

        return -1; // No element occurs k times
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 4, 3, 4, 8, 7};
        int k = 2;
        System.out.println(firstElementKTimes(arr, k)); // Output: 4
    }
}
