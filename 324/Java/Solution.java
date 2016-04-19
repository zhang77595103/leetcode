/*
    After analyse the question, we can find that a really easy solution is sort first
    then insert the part of the bigger part into the smaller the part. But unfortunately
    the time complexity will be at least O(nlog(n)) in this way.

    So there is one way to optimize it, first we divide the question into two part :

    1. find the median

    2. put the num bigger than the median into the odd position, and else nums into the
    even position.
    ( since we find that the nums in the even postion should be smaller than the odd
    position. )

 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return;
        }


        /*
            how to find the median in O(n) is also a big problem.
            I will show a way that is a little tricky. But it's really O(n)
         */
        int median = findMedian(nums, (n + 1)/ 2);


        /*
            Another key point of this quetion is how to make use of median to
            sort those nums.
         */

        int i = 0;
        // start from the first odd num after use cv() to change the index
        int j = nums.length - 1;
        // start to record from the last even num after use cv() to change the index
        int mid = 0;
        //will be useful if the value equals median exist.

        while(i <= j){
            if(nums[cv(n, i)] > median){
                /*
                    when the number bigger than median, if we haven't found any
                    num equals to median so far, we can just think it's already
                     the proper position for it. Otherwise, we just swap the two
                     position.
                 */
                if(i != mid){
                    swap(nums, cv(n, i), cv(n, mid));
                }
                i++;
                mid++;
            }
            else if(nums[cv(n, i)] < median){
                /*
                    when the number smaller than median, we just let it change with the
                    last even position we haven't sorted.
                 */
                swap(nums, cv(n, i), cv(n, j--));
            }

            else{
                /*
                    when we find the number that is equal to median, just use median to
                    record it and continue traversal.
                 */
                i++;
            }
        }


    }

    private int findMedian(int[] nums, int kth){
        int median = 0;
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;

        while(left <= right){
            /*
                counter the number of the right of the median and the number of
                the left of the median, if too much nums at the left or right,
                which means the median is improper.
             */

//            median = (left + right) / 2;
            /*
                the reason why we can not write like line 89 is that
                 it's possible for the right number to go out of boundary
                 of int.
             */
            median = (right > 0 && left < 0) ? (left +right) / 2 : left + (right - left) / 2;

            int lm = 0, rm = 0, flag = 0;
            for(int each : nums){
                if(each < median) {
                    if (++lm > kth - 1) {
                        flag = 1;
                        break;
                    }
                }
                else if(each > median){
                    if(++rm > nums.length - kth){
                        flag = -1;
                        break;
                    }
                }
            }

            if(flag == 0){
                return median;
            }
            else if(flag == 1){
                right = median - 1;
            }
            else{
                left = median + 1;
            }
        }


        return median;
    }

    /*
        this is the power of cv( change value ) function.
            (if the length of the nums is 10)
             cv(0) actually accesses nums[1].
             cv(1) actually accesses nums[3].
             cv(2) actually accesses nums[5].
             cv(3) actually accesses nums[7].
             cv(4) actually accesses nums[9].
             cv(5) actually accesses nums[0].
             cv(6) actually accesses nums[2].
             cv(7) actually accesses nums[4].
             cv(8) actually accesses nums[6].
             cv(9) actually accesses nums[8].
     */
    private int cv(int length, int i){
        return (i * 2 + 1 ) % (length | 1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
