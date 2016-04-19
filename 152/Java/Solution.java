
/*
    Idea from internet, Using dp.
    we can hold two array, one to record the max value so far,
    or another to record the minium value. So when can get a
    positive number we can just use the max value to get the
    result and when we meet negative num just use the min value.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];
        int re = nums[0];

        for (int i = 1; i < nums.length; i++) {
            /*
                max[i] means the biggest value we can get if we include nums[i].
                1. when nums[i-1] is 0, then max[i-1] == min[i-1] == 0, 
                nums[i] is the biggest value as long as nums[i] is bigger than 0.
                2. when the nums[i] > 0, then the biggest value must be nums[i] * max[i-1]
                3. when the nums[i] < 0, then the biggest value must be nums[i] * min[i-1]
             */
            max[i] = max(nums[i], max(nums[i] * max[i-1], nums[i] * min[i-1]));
            min[i] = min(nums[i], min(nums[i] * max[i-1], nums[i] * min[i-1]));
            re = max(re, max[i]);
        }
        return re;
    }

    private int min(int i, int i1) {
        if(i <= i1) {
            return i;
        }
        return i1;
    }

    private int max(int i, int i1) {
        if(i >= i1){
            return i;
        }
        return i1;
    }
}
