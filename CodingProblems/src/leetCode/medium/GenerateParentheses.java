package leetCode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     *
     * Example 2:
     *
     * Input: n = 1
     * Output: ["()"]
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        if(n == 0) return list;
        list.add("");
        List<Integer> countList = new LinkedList<>();//store the number of open bracket related to item in list
        countList.add(0);
        for(int i = 1;i <= 2*n;i++){
            while(list.get(0).length() != i){
                String s = list.remove(0);
                int countOpen = countList.remove(0);
                if(countOpen < n){
                    list.add(s+'(');
                    countList.add(countOpen+1);
                }
                if(s.length()-countOpen < countOpen){
                    list.add(s+')');
                    countList.add(countOpen);
                }
            }
        }
        return list;
    }

    public  static void backtrack(List<String> list, String str, int open, int close, int max){


    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
