public class majorityElement {
    public static int findMajorityElement(int[] arr) {
        int count = 0;
        int candidate = -1;

        // Phase 1: Find a candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verify the candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }

        return (count > arr.length / 2) ? candidate : -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + findMajorityElement(arr));
    }
}
