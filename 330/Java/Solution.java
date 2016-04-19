/*
    often those kinds of question that tell you to find the best solution is either use greedy or use dp.
    in this question we use greedy.

 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        int i = 0, counter = 0;
        // why i set cover to int is because the question may set n to the biggest int num, in that case,
        // it's obvious for you to get a long int num to hold cover!
        long cover = 0;
        //counter is use to calculate the patching we have add.
        // i is use to traversal the numbers that have been given to you
        // cover represents where max position you have covered.

        for(;cover < n;){
            if(i >= nums.length || cover + 1 < nums[i]){
                /*
                    there are two situations that need to add patching

                    1. when we have traversal all the given num, but we still can't reach
                    n, for example : {1,2,3}  n = 50, when you run out of your num the cover
                    is only 6, but you need to get 50, so you start to add patching;

                    2. when what you reach is too small but the next given num is too big
                    for example : {1,8} n = 10, after you visit 1, you get you cover value
                    as 1, but the next num is 8, so you need to patch to cover the value
                    between 1 and 8;
                 */
                counter++;
                cover += cover + 1;
            }
            else{
                /*
                    when your cover reach 4, which means if you get a num less than five, (for example , you get 5)
                    you can change your cover to 9, because you can use the new num (5) add these combinations respectively.
                 */
                cover += nums[i];
                i++;
            }
        }

        return counter;
    }
}