package leetCode.easy;

import java.util.Arrays;

public final class NextGreatestInteger {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int numToCheck = nums1[i];
            boolean canLook = false;
            for(int j=-0; j<nums2.length;j++){
                if(j == nums2.length -1 && !canLook){
                    answer[i] = -1;
                    break;
                }
                if(numToCheck == nums2[j] && !canLook){
                    canLook = true;
                    continue;
                }
                if(numToCheck <nums2[j] && canLook){
                    answer[i] = nums2[j];
                    break;
                }
                else if(j == nums2.length -1){
                    answer[i] = -1;
                }

            }
        }
        return answer;
    }
    public static void main(String[] args) {
      System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2})));
    }
}
