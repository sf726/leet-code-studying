package leetCode.easy;


import java.util.Arrays;

public final class RotateArray {
    public static void rotate(int[] nums, int k){

        int length = nums.length;
        if(k % length ==0){
            return;
        }
        int[] newArray = new int[nums.length];
        for(int i =0;i<length;i++){
            int newIndex = (i + k) % length;
            System.out.println(newIndex);
            newArray[newIndex] = nums[i];
            //int swappingValue = 5
           // nums[i] =
        }
        nums = newArray;
        System.out.println(Arrays.toString(newArray));
        System.out.println(Arrays.toString(nums));
    }

    public static void rotateNoNewList(int[] nums, int k){

        if(nums == null || nums.length < 2){
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    private static void reverse(int[] nums, int i, int j){
        int tmp = 0;
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
