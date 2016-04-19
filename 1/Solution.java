public class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] re = new int[2];
		HashMap map = new HashMap();
		for (int i = 0; i < nums.length ; i++) {
			try {
				map.put(nums[i], i);
			} catch (Exception e) {
			}
		}
		for (int i = 0; i < nums.length ; i++) {
			if(map.containsKey(target - nums[i])){
				if ((int)map.get(target - nums[i]) != i) {
					re[0] = i;
					re[1] = (int)map.get(target - nums[i]);
					return re;
				}
			}
		}
		int t = target / 2;
		int counter = 0;
		int i = 0;
		while(i < nums.length){
			if(nums[i] == t){
				re[counter++] = i;
				if(counter == 2){
					return re;
				}
			}
			i++;
		}
		return re;
	}
}
