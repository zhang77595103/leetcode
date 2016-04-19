public class NumArray {
    int[] ints;
    public NumArray(int[] nums) {
        ints = new int[nums.length + 1];
        for(int i = 1; i < nums.length + 1; ++i){
            int j = i;
            while(j < nums.length + 1){
                ints[j] += nums[i - 1];
                j += (j & -j);
            }
        }
    }

    public int sumRange(int i, int j) {
        int re1 = 0;
        int re2 = 0;
        j++;
        while(j > 0){
            re1 += ints[j];
            j -= (j & -j);
        }
        while(i > 0){
            re2 += ints[i];
            i -= (i & -i);
        }
        return re1 - re2;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
