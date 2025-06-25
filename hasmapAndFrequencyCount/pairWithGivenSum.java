// check if pair with given sum exists in the array

import java.util.*;

public class pairWithGivenSum{
       public static List<int[]> findPairs(int[] arr, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> pairs = new ArrayList<>();

        for (int num : arr) {
            int complement = m - num;

            if (map.containsKey(complement)) {
                int freq = map.get(complement);
                for (int i = 0; i < freq; i++) {                  // to print all pairs
                    pairs.add(new int[]{complement, num});
                }
            }

            
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int m = 6;

        List<int[]> result = findPairs(arr, m);

        System.out.println("Pairs with sum " + m + ":");
        for (int[] p : result) {
            System.out.println(Arrays.toString(p));
        }
    }
}

