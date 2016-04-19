
/*
 * the basic idea is continuous delete the leaf node, then when the the num of the node is less than 3 (1 or 2), all of those 
 * node are what we need.
 */

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        boolean[] exist = new boolean[n];
        int counter = n;
        List<Integer> re = new LinkedList<>();
    
        while(true) {
            int[] counts = new int[n];
            if(counter <= 2){
                for (int i = 0; i < n; i++) {
                    if(!exist[i]){
                        re.add(i);
                    }
                }
                break;
            }
            for (int[] each1 : edges) {
                if(!exist[each1[0]] && !exist[each1[1]]){
                    counts[each1[0]]++;
                    counts[each1[1]]++;
                }
            }
            for (int i = 0; i < n; i++) {
                if(counts[i] == 1){
                    exist[i] = true;
                    counter--;
                }
            }
            
        }
        return re;
    }
}
