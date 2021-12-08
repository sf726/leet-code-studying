package leetCode.easy;

public final class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != nums[i+1]){
                k++;
            } else {
                if(k+1 == nums.length){
                    return k;
                } else {
                    nums[k+1] = nums[i];
                }
            }
        }
        return k+1;
    }
    public static void main(String[] args) {


    }
}
