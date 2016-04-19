/*
    137
    original version
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int[] record = new int[32];
        for(int each : nums){
            for (int i = 0; i < 32; i++) {
                if((1 << i & each) != 0){
                    record[i]++;
                }
            }
        }

        int re = 0;
        for (int i = 0; i < 32; i++) {
            if(record[i] % 3 != 0)  re |= 1 << i;
        }
        return re;
    }
}
