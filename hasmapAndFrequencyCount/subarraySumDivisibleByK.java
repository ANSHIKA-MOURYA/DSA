import java.util.*;

public class subarraySumDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderFreq = new HashMap<>();
        remainderFreq.put(0, 1); 

        int prefixSum = 0, count = 0;

        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;

            // Handle negative remainder (Java can give -ve mod)
            if (remainder < 0) remainder += k;

            // If we've seen this remainder before, add its count
            count += remainderFreq.getOrDefault(remainder, 0);

            // Update remainder count
            remainderFreq.put(remainder, remainderFreq.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println("Count: " + subarraysDivByK(nums, k)); // Output: 7
    }
}
