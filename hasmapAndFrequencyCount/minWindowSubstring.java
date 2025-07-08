import java.util.*;

public class minWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int required = targetFreq.size(); // Number of unique characters in t
        int formed = 0; // Unique characters that match required frequency

        Map<Character, Integer> windowFreq = new HashMap<>();

        int left = 0, right = 0;
        int[] ans = {-1, 0, 0}; // {windowLength, left, right}

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // If char frequency matches target's frequency
            if (targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue()) {
                formed++;
            }

            // Contract the window from left if all required chars are formed
            while (left <= right && formed == required) {
                char temp = s.charAt(left);

                // Save the smallest window
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Try to remove left char
                windowFreq.put(temp, windowFreq.get(temp) - 1);
                if (targetFreq.containsKey(temp) && windowFreq.get(temp).intValue() < targetFreq.get(temp).intValue()) {
                    formed--;
                }

                left++; // shrink window
            }

            right++; // expand window
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum Window: " + minWindow(s, t)); // Output: BANC
    }
}
