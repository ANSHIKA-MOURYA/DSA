// longest subarray with equal number of 0s and 1s

import java.util.*;

public class equal0and1 {
    public static int longestSubaaray(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for(int i =0; i < arr.length; i++){
            sum += (arr[i] == 0) ? -1 : 1; // Treat 0 as -1 and 1 as +1

            if (sum == 0) {
                maxLen = i + 1; // If sum is zero, we found a subarray from start to i
            } else if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum)); // Update max length if this sum was seen before
            } else {
                map.put(sum, i); // Store the first occurrence of this sum
            }
        }
        return maxLen; // Return the length of the longest subarray with equal 0s and 1s
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0, 0, 1};
        System.out.println("Length of the longest subarray with equal number of 0s and 1s: " + longestSubaaray(arr));
    }
}