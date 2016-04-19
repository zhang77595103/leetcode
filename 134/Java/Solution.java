public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int i = 0;
        int index_now = 0;
        int index_best = 0;
        int now = 0;
        int best = 0;
        int first = -1;
        boolean cont = false;
        int sum = 0;
        int cur = 0;

        while(i <= gas.length){
            if(i == gas.length){
                if(sum < 0){
                    return -1;
                }
                if(first != -1 && cont && first > 0 && first + now > best) {
                    return index_now;
                }
                return index_best;
            }
            cur = gas[i] - cost[i];
            sum += cur;
            if(now + cur >= 0){
                if(!cont){
                    index_now = i;
                    cont = true;
                }
                now = now + cur;
            }
            else{
                if(cont){
                    now = 0;
                    index_now = -1;
                    cont = false;
                }
            }
            if(now > best){
                if(index_best == 0 && i != 0){
                    first = best;
                }
                best = now;
                index_best = index_now;
            }
            i++;
        }
        return 0;
    }
}
