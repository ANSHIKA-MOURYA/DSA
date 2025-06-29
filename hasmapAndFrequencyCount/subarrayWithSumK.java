// ============ BRUTE FORCE

// public class subarrayWithSumK{
//     public class subarraySmallest(int[] arr, int k){
        
//         int minLen = Integer.Max_Value;

//         for(int i = 0; i < arr.length; i++){
//            int sum = 0;
//             for(int j =i; j<  arr.length; j++){
//                 sum += arr[j];

//                 if(sum >= k){
//                     minLen = Math.min(minLen, j-1+1);
//                     break;
//                 }
//             }

// return (minLen == )
//         }
//     }
// }


//=================== Optimal 

public class subarrayWithSumK{
    public static int minSubArrayLen(int k, int[] nums) {
        int start = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= k) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start++];
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int k = 7;
        System.out.println("Optimal Min Length: " + minSubArrayLen(k, arr)); // Output: 2
    }
}