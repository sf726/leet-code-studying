package leetCode.deprecated;

import leetCode.helperClasses.ListNode;
import leetCode.helperClasses.TreeNode;
@Deprecated
public class MediumProblems {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     */
    // TODO Rough draft come back to this
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        int carry =0;
        while (l1 !=null && l2 !=null){
            int temp = l1.val + l2.val+carry;
            if(temp > 9){
                answer.val = temp % 10;
                carry = 1;
            } else {
                answer.val = temp;
                carry=0;
            }
            l1 = l1.next;
            l2 =l2.next;
            answer.next = new ListNode();
            answer = answer.next;
        }
        if(l1 !=null){
            while (carry !=0){
                int nodeValue = l1 == null ? 0 : l1.val;
                int temp = nodeValue + carry;
                if(temp > 9){
                    answer.val = temp % 10;
                    carry = 1;
                } else {
                    answer.val = temp;
                    carry = 0;
                }
                if(l1 !=null) {
                    l1 = l1.next;
                }
                answer.next = new ListNode();
                answer = answer.next;

            }
        }  else if (l2 !=null){
            while (carry !=0){
                int nodeValue = l2 == null ? 0 : l2.val;
                int temp = nodeValue + carry;
                if(temp > 9){
                    answer.val = temp % 10;
                    carry = 1;
                } else {
                    answer.val = temp;
                    carry = 0;
                }
                if(l2 !=null) {
                    l2 = l2.next;
                }
                answer.next = new ListNode();
                answer = answer.next;

            }
        }
        else {
            if(carry !=0){
                answer.next = new ListNode();
                answer = answer.next;
                answer.val = 1;
            }
        }
        return answer;
    }

    /**
     *
     * you can divide by two to make it go quicker
     *   public double myPow(double x, int n) {
     *         long m = n > 0 ? n : -(long)n;
     *         double ans = 1.0;
     *         while (m != 0) {
     *             if (m % 2 != 0) // check if m is odd number
     *                 ans *= x;
     *             x *= x;
     *             m /= 2;
     *         }
     *         return n >= 0 ? ans : 1 / ans;
     *     }
     * @param x
     * @param n
     * @return
     */

    public static double myPow(double x, int n) {
        if(n == 0 || x == 1.0){
            return 1;
        }
        if(n < 0){
            x = 1/ x;
            n = n * -1;
        }
        double temp = x;
        while (n !=1){
            x = (x*temp);
            n --;
        }
        return x;
    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
     *
     * NEED TO COME BACK TO THIS
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = head;
        while (head.next !=null && head.next.next !=null){
            ListNode temp = head.next;
            head.next = head.next.next;
            head = temp;
            head.next = temp;


        }
        return dummy;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = root;
        TreeNode[] foundNodes = findTreeNode(root,key);
        TreeNode parent = foundNodes[0];
        TreeNode match = foundNodes[1];
        //need parent of node and node
        if(match !=null){
            if(matches(parent.right,match)){
                if(match.left != null){
                    
                }
            }
        }
        return null;
    }
    private boolean matches(TreeNode t1,TreeNode t2){
        return t1 !=null && t2.val == t1.val;
    }

    private TreeNode[] findTreeNode(TreeNode treeNode,int key){
        TreeNode previous = null;
        while (treeNode !=null && treeNode.val != key){
            previous = treeNode;
            if(treeNode.val > key){
                treeNode = treeNode.right;
            } else {
                treeNode = treeNode.left;
            }
        }
        return new TreeNode[]{previous,treeNode};
    }

    public static void main(String[] args) {
     System.out.println( myPow(2.000,-2147483648));
    }


}
