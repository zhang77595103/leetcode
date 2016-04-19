public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while(i < nums.length && j < nums.length){
            while(nums[j] != 0 && ++j < nums.length && nums[j] != 0);
            if(nums[i] != 0 && j < i){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
            i++;
        }
    }

}
