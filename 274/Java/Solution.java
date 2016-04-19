//274
public class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        if(length == 0) return 0;
        Arrays.sort(citations);

        for(int i = 1; i <= length; ++i){
            if(citations[length - i] < i){
                return i-1;
            }
        }
        return length;
    }
}
