package leetCode.easy;

import java.util.HashSet;
import java.util.Set;

public final class BinarySearch {
    public static int search(int[] nums, int target){
       int high = nums.length -1;
       int low =0;

        while (low < high){
            int half = low +(high - low+1) / 2;
            int test = (high+1) / 2;
            System.out.println("half is "+half);
            System.out.println("test is "+test);
            int mid = nums[half];
            if(mid == target){
                return half;
            }
            if(target < mid){
                high = half -1;
            } else {
                low = half;
            }
        }
        return 0;
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int j=0;
        int i=0;
        int max=0;

        while(i<= j && j < s.length()-1){
            if(set.add(s.charAt(j))){
                j++;
            } else{
               max = Math.max(max,j-i+1);
               set.remove(s.charAt(i));
               i++;

            }
        }
        return max;
    }
    public static void main(String[] args) {

        //System.out.println(search(new int[]{1,2,3,4,5,6},6));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
