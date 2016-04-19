import java.util.Arrays;
import java.util.LinkedList;

/*
    for me this is question is little hard, the solution is learned from others. The basic idea:
        To create max number of length k from two arrays, you need to create max number of length i
        from array one and max number of length k-i from array two, then combine them together. After
        trying all possible i, you will get the max number created from two arrays.
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(k <= 0 || (nums1.length == 0 && nums2.length == 0)){
            return null;
        }

        //left represents the number we will use from num1;
        int left = 0, right;

        //sava the temp conbination of the num in current loop
        int[] temp = new int[k];
        int[] re = new int[k];

        //calculate and save the max if only choose from only one array.
        LinkedList<Integer>[] cache1 = null;
        LinkedList<Integer>[] cache2 = null;
        cache1 = create(nums1, k);
        cache2 = create(nums2, k);



        while(left <= k){
            right = k - left;

            //when the num we want from num1/num2 is even bigger than the actual size
            if(left > nums1.length || right > nums2.length){
                left++;
                continue;
            }

            merge(cache1[left], cache2[right], temp);
            if(compare(temp, re)){
                re = Arrays.copyOf(temp, temp.length);
            }
            left++;
        }
        return re;
    }


    public LinkedList[] create(int[] nums, int k){
        if(nums.length == 0){
            LinkedList[] re = new LinkedList[1];
            re[0] = new LinkedList();
            return re;
        }
        int counter = nums.length > k ? k : nums.length;
        int len = nums.length;
        LinkedList[] cache = new LinkedList[counter + 1];
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(Integer each : nums){
            list.add(each);
        }

        int flag = 0;
        while(len > 0){
            if(len <= counter){
                cache[len] = (LinkedList<Integer>)list.clone();
            }
            while(flag < list.size() - 1){
                if (list.get(flag) >= list.get(flag+1)) {
                    flag++;
                }
                else{
                    break;
                }
            }
            /*
            if(flag >= list.size()){
                flag = list.size() - 1;
            }
            */
            list.remove(flag);
            flag = flag > 0 ? flag - 1 : 0;
            len--;
        }
        cache[len] = (LinkedList)list.clone();
        return cache;
    }


    private void merge(LinkedList num1, LinkedList num2, int[] temp){
        int left = 0;
        int right = 0;
        int index = 0;
        int len1 = num1.size();
        int len2 = num2.size();

        while(left < len1 && right < len2){
            if((int)num1.get(left) > (int)num2.get(right)){
                temp[index++] = (int)num1.get(left++);
            }
            else if((int)num1.get(left) < (int)num2.get(right)){
                temp[index++] = (int)num2.get(right++);
            }
            else{
                /*
                    if the two num is the same, then
                    there is a long story.
                 */
                int t1 = left++;
                int t2 = right;
                boolean flag = true;
                temp[index++] = (int)num2.get(right++);

                while(left < len1 && right < len2){
                    if((int)num1.get(left) > (int)num2.get(right)){
                        right = t2;
                        left = t1 + 1;
                        flag = false;
                        break;
                    }
                    else if((int)num1.get(left) < (int)num2.get(right)) {
                        left = t1;
                        right = t2 + 1;
                        flag = false;
                        break;
                    }
                    else {
                        left++;
                        right++;
                    }
                }

                if(flag && left == len1){
                    left = t1;
                    right = t2 + 1;
                }
                else if(flag && right == len2){
                    right = t2;
                    left = t1 + 1;
                }
            }
        }

        while(left < len1){
            temp[index++] = (int)num1.get(left++);
        }
        while(right < len2){
            temp[index++] = (int)num2.get(right++);
        }
    }

    //use to compare the num represented by the array .
    private boolean compare(int[] temp, int[] re){
        int i = 0;
        while(i < temp.length){
            if(temp[i] > re[i]){
                return true;
            }
            else if(temp[i] < re[i]){
                break;
            }
            i++;
        }
        return false;
    }
}



