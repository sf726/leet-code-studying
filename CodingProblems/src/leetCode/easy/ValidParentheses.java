package leetCode.easy;

import java.util.Map;
import java.util.Stack;

public final class ValidParentheses {
    private final static Map<Character,Character> map1 = Map.of('{','}','(',')','[',']');
    private final static Map<Character,Character> map = Map.of('}','{',')','(',']','[');
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     *     Open brackets must be closed by the same type of brackets.
     *     Open brackets must be closed in the correct order.
     * @param s
     * @return
     */
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()){
            if(map1.get(c) !=null){
                stack.push(c);
            } else {
                if(stack.pop() !=map.get(c)){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {

    }
}
