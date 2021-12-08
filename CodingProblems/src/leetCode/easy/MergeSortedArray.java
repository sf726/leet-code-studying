package leetCode.easy;

public final class MergeSortedArray {
    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
     * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
     *
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     *
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
     * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int counter = 0;
        int counter2=0;
        while (counter < m && counter < n){
            if(nums1[counter] >= nums2[counter]){
                shift(nums1,counter,nums2[counter2]);
                counter2++;
            }
            counter++;
        }

    }

    private static void shift(int[] nums1, int counter, int i) {
        for(int j=nums1.length-1;j>counter;j--){
            nums1[j] = nums1[j-1];
        }
        nums1[counter]=i;
    }

    public static void main(String[] args) {
        merge(new int[]{1,2,3},3,new int[]{2,5,6},3);
    }

}
