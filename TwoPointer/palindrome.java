public class palindrome {
    public static boolean palindromeArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1; 

        while (left < right) {
            if (arr[left] != arr[right]) { 
                return false;
            }
            left++;
            right--;
        }

        return true; 
    }

    public static void main(String[] args) {
        int[] num1 = {1, 0, 1, 0, 1};     
        int[] num2 = {1, 0, 0, 1, 0, 1};  
        int[] num3 = {1, 2, 3, 2, 1};     

        System.out.println(palindromeArray(num1));
        System.out.println(palindromeArray(num2));
        System.out.println(palindromeArray(num3));
    }
}
