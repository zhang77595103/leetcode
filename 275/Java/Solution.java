public class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        if(length == 0) return 0;

        int left = 0;
        /*
            the reason why i choose length not length - 1 is
            because I must make sure when length == 1 it can
            get into the loop.
         */
        int right = length;
        int mid;
        while(left < right){
            //avoid go out of the bound of int
            mid = left + (right - left) / 2;
            if(citations[mid] >= length - mid)   right = mid;
            else    left = mid + 1;
        }
        return length - left;
    }
}
