import helperClasses.ListNode;
import helperClasses.TreeNode;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class EasyProblems {


    /**
     * two sum
     * <p>
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * You can return the answer in any order.
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> composites = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (composites.get(nums[i]) != null) {
                return new int[]{composites.get(nums[i]), i};
            }
            composites.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("solution not found");
    }

    /**
     * Given a signed 32-bit integer x,
     * return x with its digits reversed. I
     * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     *
     * @param x
     * @return
     */

    // didn't solve missed the part about multiplying by 10
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * Given an integer x, return true if x is palindrome integer.
     * <p>
     * An integer is a palindrome when it reads the same backward as forward.
     * For example, 121 is palindrome while 123 is not.
     *
     * @param x
     * @return
     */

    public boolean isPalindrome(int x) {
        int copy = x;
        if (x < 0) {
            return false;
        }
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev == copy;
    }

    /**
     * convert roman numeral to int
     *
     * @param s
     * @return
     */
    // Runtime: 10 ms, faster than 14.86% of Java online submissions for Roman to Integer.
    //Memory Usage: 39.7 MB, less than 24.90% of Java online submissions for Roman to Integer.
    public static int romanToInt_firstRightAttempt(String s) {

        int answer = 0;
        Map<String, Integer> valuesCache = Map.ofEntries(
                Map.entry("I", 1),
                Map.entry("V", 5),
                Map.entry("X", 10),
                Map.entry("L", 50),
                Map.entry("C", 100),
                Map.entry("D", 500),
                Map.entry("M", 1000),
                Map.entry("IV", 4),
                Map.entry("IX", 9),
                Map.entry("XL", 40),
                Map.entry("XC", 90),
                Map.entry("CD", 400),
                Map.entry("CM", 900));
        int i = 0;
        while (i < s.length()) {
            if (i + 1 == s.length()) {
                return answer + valuesCache.get(s.substring(i));
            }
            String initialSubstring = s.substring(i, i + 2);

            if (valuesCache.get(initialSubstring) != null) {
                answer += valuesCache.get(initialSubstring);
                i = i + 2;
            } else {
                answer += valuesCache.get(initialSubstring.substring(0, 1));
                i++;
            }
        }
        return answer;
    }

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * If there is no common prefix, return an empty string "".
     *
     * // probably not optimal need to look into improving
     * @param strs
     * @return
     */
    // loop through list
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length ==0){
            return "";
        }
        boolean isNotFinished = true;
        int position =0;
        char current;
        StringBuilder stringBuilder = new StringBuilder();
        while (isNotFinished){
            if(position > strs[0].length() - 1){
                break;
            }
            current = strs[0].charAt(position);
            for(String str: strs){
                if(str.isEmpty()){
                    stringBuilder = new StringBuilder();
                    isNotFinished = false;
                    break;
                }
                if(position > str.length() - 1){
                    isNotFinished = false;
                    break;
                }
                char c = str.charAt(position);
                if(c != current){
                    isNotFinished = false;
                    break;
                }

            }
            if(isNotFinished) {
                stringBuilder.append(current);
            }
            position++;
        }
       return stringBuilder.toString();
    }

    public int maxDepth(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        while (!treeNodeStack.empty()){
            if(root.left !=null) {
                treeNodeStack.push(root);
                root = root.left;
            }

        }
        return 0;
    }
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

     Open brackets must be closed by the same type of brackets.
     Open brackets must be closed in the correct order.

     **/

    public boolean isValid(String s) {
        final List<Character> openings = List.of('{','(','[');
        final List<Character> closings = List.of('}',')',']');
        final Map<Character,Character> map = Map.of('}','{',')','(',']','[');

        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(openings.contains(c)){
                stack.push(c);
                continue;
            }
            if(closings.contains(c)){
                if(stack.empty() || stack.pop() != map.get(c)){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    /**
     * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val  == l2.val){
            l1.next.next =l1.next;
            l1.next = l2;
            l2 = l2.next;
        }



        return null;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * Implement strStr().
     *
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
     * @param haystack
     * @param needle
     * @return
     */

    public static int strStr(String haystack, String needle) {
        if(haystack.equals(needle)){
            return 0;
        }
        if(haystack.isEmpty()){
            return -1;
        }
        if(needle.isEmpty()){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        int needlePointer = 0;
        int start =0;
        int wordPointer = 0;

        while (needle.length() - needlePointer <= haystack.length() - wordPointer){
            if(needle.charAt(needlePointer) == haystack.charAt(wordPointer)){
                if(needlePointer == needle.length() -1){
                    return start;
                }
                needlePointer++;
                wordPointer++;
            } else {
                start++;
                wordPointer =start;
                needlePointer =0;
            }

        }
        return -1;
    }

    /**
     * Given a string s consists of some words separated by spaces,
     * return the length of the last word in the string. If the last word does not exist, return 0.
     * @param s
     * @return
     */

    public static int lengthOfLastWord(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        s = s.trim();
       int lastSpace = s.lastIndexOf(" ");
        if(lastSpace < 0){
            return s.length();
        }
       int possibleReturn = s.substring(lastSpace).length()-1;
       return Math.max(possibleReturn, 0);
    }

    /**
     * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
     *
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
     *
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     *
     *
     * better solution than what I did
     *
     *
     *
     * int n = digits.length;
     *     for(int i=n-1; i>=0; i--) {
     *         if(digits[i] < 9) {
     *             digits[i]++;
     *             return digits;
     *         }
     *
     *         digits[i] = 0;
     *     }
     *
     *     int[] newNumber = new int [n+1];
     *     newNumber[0] = 1;
     *
     *     return newNumber;
     *
     */

    public int[] plusOne(int[] digits) {
        if(digits.length ==0){
            return digits;
        }
        int lastDigit = digits[digits.length-1];
        if(lastDigit < 9){
            digits[digits.length-1]++;
            return digits;
        }
        int carry = 1;
        digits[digits.length-1]=0;
        for(int i=digits.length-2;i>-1;i--){
            digits[i]+=carry;
            if(digits[i]==10){
                digits[i] =0;
            } else {
                carry=0;
            }
        }

        if(digits[0] == 0){
            int[] carryOver = new int[digits.length+1];
            carryOver[0]++;
            return carryOver;
        } else {
            return digits;
        }
    }

    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     * BEST SOLUTION
     * use XOR
     * int singleNumber(int A[], int n) {
     *     int result = 0;
     *     for (int i = 0; i<n; i++)
     *     {
     * 		result ^=A[i];
     *     }
     * 	return result;
     * }
     *
     * @param nums
     * @return
     */

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if(nums.length == 1){
            return nums[0];
        }
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.stream().findFirst().get();
    }

    /**
     * Write an algorithm to determine if a number n is happy.
     *
     * A happy number is a number defined by the following process:
     *
     *     Starting with any positive integer, replace the number by the sum of the squares of its digits.
     *     Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     *     Those numbers for which this process ends in 1 are happy.
     *
     * Return true if n is a happy number, and false if not.
     *
     *
     * answer: main thing was I forgot to check the loop
     *
     * public boolean isHappy(int n) {
     *     Set<Integer> inLoop = new HashSet<Integer>();
     *     int squareSum,remain;
     * 	while (inLoop.add(n)) {
     * 		squareSum = 0;
     * 		while (n > 0) {
     * 		    remain = n%10;
     * 			squareSum += remain*remain;
     * 			n /= 10;
     *                }
     * 		if (squareSum == 1)
     * 			return true;
     * 		else
     * 			n = squareSum;
     ** 	}
     * 	return false;
     *
     * }
     * @param n
     * @return
     */

    public static boolean isHappy(int n) {
        while (n < Integer.MAX_VALUE){
          int temp = 0;
           int temp2 = n;
           while (temp2 !=0) {
               temp += (temp2 % 10) * (temp2 % 10);
               temp2 /= 10;
           }

           if (temp == 1) {
                   return true;
               }
           n = temp;
        }
        return false;
    }

    /**
     * Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
     *
     * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
     *
     * The tests are generated such that there is exactly one solution. You may not use the same element twice.
     *
     *
     * since it is sorted this would probably be the better solution
     * public int[] twoSum(int[] num, int target) {
     *     int[] indice = new int[2];
     *     if (num == null || num.length < 2) return indice;
     *     int left = 0, right = num.length - 1;
     *     while (left < right) {
     *         int v = num[left] + num[right];
     *         if (v == target) {
     *             indice[0] = left + 1;
     *             indice[1] = right + 1;
     *             break;
     *         } else if (v > target) {
     *             right --;
     *         } else {
     *             left ++;
     *         }
     *     }
     *     return indice;
     * }
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int x=0;x<numbers.length;x++){
            if(hashMap.containsKey(numbers[x])){
                return new int[]{hashMap.get(numbers[x])+1,x+1};
            }
            hashMap.put(target-numbers[x],x);
        }
        throw  new IllegalArgumentException("");
    }

    /**
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     *
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
     * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
     * Note that pos is not passed as a parameter.
     *
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     *
     * solution with constant space
     * Floyd's Cycle Finding Algorithm
     *  public boolean hasCycle(ListNode head) {
     *         if (head == null) {
     *             return false;
     *         }
     *
     *         ListNode slow = head;
     *         ListNode fast = head.next;
     *         while (slow != fast) {
     *             if (fast == null || fast.next == null) {
     *                 return false;
     *             }
     *             slow = slow.next;
     *             fast = fast.next.next;
     *         }
     *         return true;
     *     }
     * @param head
     * @return
     */

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head !=null){
            System.out.println("in loop");
            if(!seen.add(head)){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * Given the head of a sorted linked list,
     * delete all duplicates such that each element appears only once. Return the linked list sorted as well.
     *
     *
     * LETS GO
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
     * Memory Usage: 38.4 MB, less than 43.28% of Java online submissions for Remove Duplicates from Sorted List.
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = head;
        if(head == null){
            return head;
        }
        //we have reached the end of the list we can stop
        while (head.next !=null){
            // the values are equal lets remove it
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else {
                // the values are not equal we can move the pointer up one
                head = head.next;
            }

        }
        return start;
    }

    /**
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     * @param nums
     * @return
     */
    public static int majorityElement_passingButBad(int[] nums) {
        int biggest = 0;
        int number = 0;
        if(nums.length==1){
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            if(map.get(i) !=null){
                int x = map.get(i);
                map.put(i, map.get(i) + 1);
                if(biggest < x){
                    biggest = x;
                    number = i;
                }
            }  else {
                map.put(i,1);
            }
        }
        return number;
    }

    /**
     * Given an array nums of size n, return the majority element.
     *
     * Follow-up: Could you solve the problem in linear time and in O(1) space?
     *
     * Approach 6: Boyer-Moore Voting Algorithm
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }




    public static void main(String[] args) {
       majorityElement(new int[]{8,8,7,7,7});
}
}
