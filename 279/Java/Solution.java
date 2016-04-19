public class Solution {
    public int numSquares(int n) {
        /*
            question require the input should be positive integer
            so ignore the case when n == 0
         */
        for(int i = 1; i <= n; ++i) {
            if(helper(n, i))    return i;
        }
        return -1;
    }

    private boolean helper(int n, int limit){
        if(1 == limit)  return isSquare(n);

        for (int i = 1; i * i <= (double)n / 2; i++) {
            if(helper(n - i * i, limit - 1))   return true;
        }
        return false;
    }

    private boolean isSquare(int n){
        double temp = Math.sqrt(n);
        return temp - (int)temp == 0.0;
    }
}
