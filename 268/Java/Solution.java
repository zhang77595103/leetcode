public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum1 = (long)n * (n + 1)  / 2;
        long sum2 = 0;
        for(int each : nums){
            sum2 += each;
        }
        return (int)(sum1 - sum2);
    }
}
