
public class Solution {
    public boolean canJump(int[] nums) {
        map[0] = true;
        int cur = nums[0];
        for(int i = 0 ; i < nums.length; ++i) {
            if (i > cur) {
                return false;
            }
            if(nums[i] + i >= nums.length - 1){
                return true;
            }
            if(cur < nums[i] + i){
                cur = nums[i] + i;
            }
        }
    }
}


