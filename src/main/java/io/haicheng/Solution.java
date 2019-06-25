package io.haicheng;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/6/24 10:06
 */
public class Solution {

    public static void main(String[] args){
        Solution s = new Solution();
        int[] a = {1,2};
        int p = s.maxProfit(a);
        System.out.println("===> " + p);
    }

    public int maxProfit(int[] prices) {

        int profit = 0;
        for (int i = 0; i < prices.length -1; i++) {
            for (int j = 1 + i; j < prices.length; j++) {

                int tmpProfit = prices[j] - prices[i];
                if (tmpProfit > profit) {
                    profit = tmpProfit;
                }
            }
        }
        return profit;
    }

    public int majorityElement(int[] nums) {

        int count = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                current = nums[i];
            }
            if (current == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return current;
        //        int ret = 0;
        //
        //        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //        for (int i = 0; i < nums.length; i++) {
        //            if(map.containsKey(nums[i])){
        //                map.put(nums[i], map.get(nums[i]) + 1);
        //            }else {
        //                map.put(nums[i], 1);
        //            }
        //        }
        //
        //
        //        return ret;
    }

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        } else if (n == Integer.MIN_VALUE) {
            return 1 / x * myPow(x, n + 1);
        } else if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == root || q == root) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
