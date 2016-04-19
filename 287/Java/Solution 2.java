/*
    the solution seems a little tricky but hold a O(n) time
    complexity, which is really nice.
    Here is the idea : http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int quick = 0;
        do{
            slow = nums[slow];
            quick = nums[nums[quick]];
        }while(slow != quick);

        int finder = 0;
        do{
            slow = nums[slow];
            finder = nums[finder];
        }while(finder != slow);
        return slow;
    }
}
