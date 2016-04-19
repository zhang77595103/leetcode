/*
    there is a much more clever solution, but also
    much more tricky.
    The basic idea is using three ternary system to record the
    occurrence of every bit.

    reference : http://www.1point3acres.com/bbs/thread-111563-1-1.html
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        for(int each : nums){
            /*
                the one is zero, then the result must be zero,
                if one get some bits with the value the same as
                each, then we just record it into two.
             */
            two |= one & each;
            /*
                clear the bit that are the same,
                which has been countered into next
                bit in the previous step.
             */
            one ^= each;
            /*
                when both one and two is 1 in some bit, the bit must
                countered into next bit again (ternary system), the only
                difference is that in line 18, use |= is because we don't
                want to clear it before it count to 3, but here once it
                count to 3, we just clear it in the next loop because we
                don't want it influence the following count. For example,
                if some bit occur 4 times, and after three times, the three
                should be clear otherwise in next loop it will clear the one
                in line 40 which influences the result.
             */
            three = one & two;
            /*
                clear the bit, like line 24.
             */
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
