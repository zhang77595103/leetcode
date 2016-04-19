
/*
    The first solution I provide is counter while merge sort.
    I will explain why the runtime complexity is O(nlog(n)) with comments
    in the code.
 */
public class Solution {
    int mergesort(long[] sums, int start, int end, int lower, int upper){
        if(end - start == 0){
            return 0;
        }
        if(end - start == 1){
            //for those just sums is already meet the boundary, we should
            //calculate first
            if(sums[start] >= lower && sums[start] <= upper ){
                return 1;
            }

            return 0;
        }
        int re = 0;
        int length = end - start;
        int left1 = start;
        int left2 = start + length / 2;
        re += mergesort(sums, left1, left2, lower, upper);
        int right1 = left2;
        int right2 = end;
        re += mergesort(sums, right1, right2, lower, upper);


        /*
            here is the key point.
            because the both of they are sorted array (from left to right)
            so i and j will increase continually, either k or j will meet
            the boundary, and in both case, the runtime complexity here is
            just O(n);
         */
        int i = 0, j = 0, k = start;
        while(k < left2){

            while(i + right1 < right2 && sums[i + right1] - sums[k] < lower) i++;
            while(j + right1 < right2 && sums[j + right1] - sums[k] <= upper) j++;

            re += j - i;
            k++;
        }

        //start to merge two sorted subarray
        long[] temp = new long[length];
        i = left1;
        j = right1;
        k = 0;
        while(k < length && i < left2 && j < right2){
            if(sums[i] > sums[j]){
                temp[k++] = sums[j++];
            }
            else{
                temp[k++] = sums[i++];
            }
        }

        while(k < length && i < left2){
            temp[k++] = sums[i++];
        }
        while(k < length && j < right2){
            temp[k++] = sums[j++];
        }

        i = 0;
        while(i < length){
            sums[i + start] = temp[i];
            i++;
        }

        return re;
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        /*
            first we can just convert the nums into sum
            if so we just need to judge if sum[n] - sum[n - 1]
            is between the lower and upper range
         */

        long[] sum = new long[nums.length];
        int i = 0;
        long j = 0;
        for (; i < nums.length; ++i) {
            j += nums[i];
            sum[i] = j;
        }

        //start !
        return mergesort(sum, 0, nums.length, lower, upper);

    }
}
