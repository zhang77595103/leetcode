/*
    so this is the final version
 */
public class Solution {
    public int singleNumber(int[] A) {
        int zeros=0, ones=0;
        for (int i=0; i<A.length; i++){  // 00 -> 01 -> 10 -> 00
            zeros = (zeros^A[i]) & ~ones;  // if bit1 is 1 we should put bit0 as 0, otherwise just count
            ones = (ones^A[i]) & ~zeros;  // if bit0 is 1 we should put bit1 as 0, otherwise just count
        }
        return zeros|ones;
    }
}


