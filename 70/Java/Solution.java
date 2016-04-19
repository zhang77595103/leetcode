public class Solution {
    public int climbStairs(int n) {
        if(n < 2){
            return 1;
        }
        int a1 = 1;
        int a2 = 2;
        int counter = 2;
        int sum = 0;

        while(counter < n){
            sum = a1 + a2;
            a1 = a2;
            a2 = sum;
            counter++;
        }
        return a2;
    }
}

//152a
