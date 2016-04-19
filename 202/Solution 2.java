/*
    if we do not use the queue, it will be much faster.
*/
public class Solution {
    public boolean isHappy(int n) {
        int remainer = 0;
        int sum = 0;
        while(n > 0) {
            sum = 0;
            while (n > 0) {
                remainer = n % 10;
                n = n / 10;
                sum += Math.pow(remainer,2);
            }
            if(sum < 10){
                break;
            }
            n = sum;
        }
        return sum == 1;
    }
}
