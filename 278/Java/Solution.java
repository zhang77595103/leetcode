/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid;
        while(left < right){
            /*
                here is the tricky point, since left + right
                may go out of bound of int, so you must be
                carefully when you do calculation.
                I have saw a better way is
                mid = left + (right - left) >> 1;
             */
            mid = (int)(((long)left + right) / 2);
            if(isBadVersion(mid))   right = mid-1;
            /*
                and here the better way is just
                let left = mid;
             */
            else left = mid+1;

        }
        return isBadVersion(left) ? left : left + 1;
    }
}
