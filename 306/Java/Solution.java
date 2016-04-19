import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        int sum = 2;
        while(len - sum > 0){
            int i = 1;
            int j;
            while((j = sum - i) > 0) {
                if (i <= len - sum && j <= len - sum) {
                    if (test(num, i, j)) return true;
                }
                i++;
            }
            sum++;
        }
        return false;
    }
    private boolean test(String num, int i, int j){
        if(i + j == num.length())   return true;
        String t1 = num.substring(0, i);
        String t2 = num.substring(i, i+j);
        if((t1.startsWith("0") && t1.length() != 1) || (t2.startsWith("0") && t2.length() != 1))    return false;
        BigInteger bi1 = new BigInteger(t1);
        BigInteger bi2 = new BigInteger(t2);
        BigInteger bi3 = bi1.add(bi2);
        String temp = bi3.toString();
        if(num.substring(i+j).startsWith(temp)) { return test(num.substring(i), j, temp.length()); }
        else{ return false; }
    }
}
