/*
    This problem has no value for us to explore, but the idea of some solutions opened my eye.
    since the boundary of the input will be int, so we can use the biggest num which is the
    power of three to be divided by the input.
 */



public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }

        if(1162261467 % n == 0){
            return true;
        }
        else{
            return false;
        }
    }
}


