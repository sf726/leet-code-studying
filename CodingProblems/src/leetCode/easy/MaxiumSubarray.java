package leetCode.easy;

import java.util.ArrayList;
import java.util.List;

public final class MaxiumSubarray {
    public static int maxSubArray(int[] nums) {
        int answer = 0;
        int temp =0;
        int maxSum = nums[0];
        int currSum = 0;

        for (int num : nums){
            if (currSum < 0) currSum = 0;
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;

    }

    class MinStack {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MIN_VALUE;
        int[] x = new int[30];
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        public MinStack() {

        }

        public void push(int val) {
            arrayList.add(val);
            min = Math.min(val,min);
        }

        public void pop() {
           arrayList.remove(0);
        }

        public int top() {
           return arrayList.get(0);
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
    }
}
