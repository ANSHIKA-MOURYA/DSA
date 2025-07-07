// longest substring with k distinct characters
// Given a string, find the length of the longest substring that contains at most k distinct characters.

import java.util.*;

public class LongestSubstringKDistinct {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k == 0) return 0;

        int start = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Shrink the window if too many distinct characters
            while (map.size() > k) {
                char leftChar = s.charAt(start);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Longest Substring Length: " + lengthOfLongestSubstringKDistinct(s, k));
    }
}
