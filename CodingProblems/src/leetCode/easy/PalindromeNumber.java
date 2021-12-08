package leetCode.easy;

public final class PalindromeNumber {
    /**
     * Given an integer x, return true if x is palindrome integer.
     *
     * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
     * @param x int to check
     * @return is the number a palindrome
     *
     * Runtime: 6 ms, faster than 99.96% of Java online submissions for Palindrome Number.
     * Memory Usage: 38.6 MB, less than 40.32% of Java online submissions for Palindrome Number.
     */
    public static boolean isPalindrome(int x){
        int y = 0;
        int og = x;
        if(x < 0){
            return false;
        }
        while (x != 0){
            y =(10 * y)+ (x % 10);
            x = x/ 10;
        }
        return og == y;
    }

    public static void main(String[] args){
      System.out.println(isPalindrome(7));
    }
}
