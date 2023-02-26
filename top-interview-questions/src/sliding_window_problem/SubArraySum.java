package sliding_window_problem;


//Given an array of positive integers nums and a positive integer target, return the minimal length of a
//        subarray
//        whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
public class SubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int currSum = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < nums.length){
            currSum += nums[right];
            while(currSum >= target){
                minLen = Math.min(minLen, right-left+1);
                currSum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2,3,1,2,4,3};
        System.out.println(new SubArraySum().minSubArrayLen(7, arr));
    }
}
