
/*
    an easy answer from Internet
 */
public class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            left[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i > -1; i--){
            if(ratings[i] > ratings[i + 1]){
                left[i] = left[i] < left[i + 1] + 1 ? left[i + 1] + 1 : left[i];
            }
        }

        int sum = 0;
        for(int each : left){
            sum += each;
        }
        return sum;
    }
}
