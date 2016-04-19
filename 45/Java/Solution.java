public class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        if(nums[0] > nums.length - 2){
            return 1;
        }

        int now = nums[0];
        int next = 0;
        int counter = 1;
        for(int i = 1; i < nums.length; ++i){
            if(i > now){
                now = next;
                next = 0;
                counter++;
            }
            if(i + nums[i] > next){
                next = i + nums[i];
            }
            if(next > nums.length - 2){
                break;
            }
        }
        return counter + 1;
    }
}
