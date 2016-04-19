//287
/*
    The basic idea is that if from 1 to n there has a repeat number, then
    we just calculate the numbers that not bigger than mid, if the count
    is bigger than mid, the repeat number must sit in range [1, mid]
    (normal case the count should be equal to the mid).
    The time complexity is nlgn.
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int mid = 0;
        while(low < high){
            int count = 0;
            mid = (low + high) / 2;
            for(int each : nums)    if(each <= mid) count++;
            if(count > mid) high = mid;
            else    low = mid + 1;
        }
        return high;
    }
}

