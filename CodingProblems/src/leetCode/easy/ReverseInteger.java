package leetCode.easy;

import static leetCode.helperClasses.Utility.print;

public final class ReverseInteger {
    /**
     * Given a signed 32-bit integer x, return x with its digits reversed.
     * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
     *
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     *
     * Constraints:
     * -2^31 <= x <= 2^31 - 1
     * @param x
     * @return
     */
    public int reverse(int x) {
        int answer = 0;
        while (x !=0){
            // handle overflow and underflow scenarios
            if(answer > 0 && Integer.MAX_VALUE / answer < 10){
                return 0;
            }
            if(answer<-1  &&  Integer.MIN_VALUE / answer < 10){
                return 0;
            }
            answer*=10;
            answer += (x%10);
            x = x/10;
        }
        return answer;
    }

    /**
     * https://leetcode.com/problems/reverse-integer/discuss/4060/My-accepted-15-lines-of-code-for-Java
     *
     * this makes use of int overflow and the fact the result will not match up with new result if that happens.
     * @param x
     * @return
     */

    public int betterReverse(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;

            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[]args){
        ReverseInteger reverseInteger = new ReverseInteger();
        print(reverseInteger.reverse(-90100));
        print(Integer.MAX_VALUE-1534236469);
        print((float)-5/-20);
    }
}
