/*
    !!!260
    the basic idea is bit operation.
    1. first we must know the property of Xor : if A xor B == C then C xor B == A,
    which means A ^ B ^ B = A.

    2. so we can use ^ to deal with the array (since all the number should be coupled
    except the two that we want to find), so at last we will the a ^ b (imagine a and
    b are two that we want)

    3. r&(~(r-1)) is used to find out the least significant bit that is one in number r, when some
    bit is one, it means the two single number in this bit must be different (one is 1
    another is 0, otherwise after ^ this bit should be 0).

    reference : https://leetcode.com/discuss/80755/share-my-c-solution
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int aorb = 0;
        for(int each : nums){
            aorb ^= each;
        }

        int leastSignificantBit = aorb & (~(aorb-1));
        // in fact you will find it's just (aorb & -aorb)

        int[] re = new int[2];
        for(int each : nums){
            /*
                since all the number should be couble except the two,
                so divided by the least bit, there will be only one
                single number in each group.
             */
            if((leastSignificantBit & each) != 0)   re[0] ^= each;
            else    re[1] ^= each;
        }
        return re;
    }
}
