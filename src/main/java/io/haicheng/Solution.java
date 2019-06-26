package io.haicheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/6/24 10:06
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        //s.generateParenthesis(2);

        //        System.out.println(s.mySqrt(5));
        //
        //        s.countBits(2);

        System.out.println(s.climbStairs(44));
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, min + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }


    public int climbStairs(int n) {

        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n - 1];

        //        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //        return _climb(n, map);
    }

    private int _climb(int n, Map<Integer, Integer> map) {
        if (n <= 2) {
            return n;
        } else if (map.containsKey(n)) {
            return map.get(n);
        }

        return _climb(n - 1, map) + _climb(n - 2, map);
    }

    public int[] countBits(int num) {
        int[] ret = new int[num];
        for (int i = 0; i <= num; i++) {
            int tmp = 0;
            int current = i;
            for (int j = 0; j < 32; j++) {
                tmp += current & 1;
                current = current >>> 2;
            }
            ret[i] = tmp;
        }
        return ret;
    }

    public int hammingWeight(int n) {

        String str = Integer.toBinaryString(n);
        int ret = 0;
        for (char c : str.toCharArray()) {
            ret = c == '1' ? ++ret : ret;
        }
        return ret;
    }

    public int mySqrt(int x) {

        long l = 1L, r = x / 2 + 1;
        while (l <= r) {
            long mid = (r + l) / 2;
            long sq = mid * mid;
            if (sq == x) {
                return (int) mid;
            } else if (sq < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) r;
    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        _gen("", result, n, n);
        return result;
    }

    private void _gen(String s, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
            System.out.println(s);
            return;
        }

        if (left > 0) {
            _gen(s + "(", result, left - 1, right);
        }
        if (right > left) {
            _gen(s + ")", result, left, right - 1);
        }
    }

    //    public int maxDepth(TreeNode root) {
    //        if(root == null)
    //            return 0;
    //        int left = minDepth(root.left);
    //        int right = minDepth(root.right);
    //
    //        if(){
    //
    //        }
    //
    //        //        return (root == null) ? 0 : Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    //        if (root == null) {
    //            return 0;
    //        }
    //        int deep = 0;
    //        Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //        queue.add(root);
    //
    //        List<TreeNode> level = null;
    //        while (!queue.isEmpty()) {
    //            int count = queue.size();
    //            deep++;
    //            while (count-- > 0) {
    //
    //                TreeNode node = queue.poll();
    //
    //                if (node.left != null) {
    //                    queue.add(node.left);
    //                }
    //                if (node.right != null) {
    //                    queue.add(node.right);
    //                }
    //            }
    //        }
    //        return deep;
    //    }
    //
    //
    //    public boolean isSymmetric(TreeNode root) {
    //
    //        //        Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //        //        //        Set<TreeNode> visited = new HashSet<TreeNode>();
    //        //        List<List<Integer>> ret = new ArrayList<List<Integer>>();
    //        //
    //        //        queue.add(root);
    //        //        //        visited.add(root);
    //        //
    //        //        List<TreeNode> level = null;
    //        //        while (!queue.isEmpty()) {
    //        //           int count = queue.size();
    //        //
    //        //           List<Integer> list = new ArrayList<Integer>();
    //        //           while(count-- > 0){
    //        //
    //        //               TreeNode node = queue.poll();
    //        //               list.add(node.val);
    //        //               if(node.left != null){
    //        //                    queue.add(node.left);
    //        //               }else if(node.right != null){
    //        //                   queue.add(node.right);
    //        //               }
    //        //           }
    //        //           ret.add(list);
    //        //        }
    //        //        return ret;
    //        //        return isMirroTree(root, root);
    //    }
    //
    //    //    private boolean isMirroTree(TreeNode p, TreeNode q) {
    //    //        if (p == null) {
    //    //            return q == null;
    //    //        } else if (q == null) {
    //    //            return p == null;
    //    //        }
    //    //        return isMirroTree(p.left, q.right) && isMirroTree(p.right, q.left);
    //    //    }
    //
    //    private Queue<TreeNode> getChildren(Queue<TreeNode> queue) {
    //        Queue<TreeNode> ret = new LinkedList<TreeNode>();
    //        for (TreeNode n : queue) {
    //            ret.offer(n.left);
    //            ret.offer(n.right);
    //        }
    //        return ret;
    //    }
    //
    //
    //    private boolean _isSymmetric(Queue<TreeNode> queue) {
    //        if (queue.size() == 1) {
    //            return true;
    //        }
    //        //todo 巴拉巴拉
    //        return false;
    //
    //    }
    //
    //    public static void main(String[] args) {
    //        Solution s = new Solution();
    //        int[] a = {1,
    //                2};
    //        int p = s.maxProfit(a);
    //        System.out.println("===> " + p);
    //    }
    //
    //    public int maxProfit(int[] prices) {
    //
    //        int profit = 0;
    //        for (int i = 0; i < prices.length - 1; i++) {
    //            for (int j = 1 + i; j < prices.length; j++) {
    //
    //                int tmpProfit = prices[j] - prices[i];
    //                if (tmpProfit > profit) {
    //                    profit = tmpProfit;
    //                }
    //            }
    //        }
    //        return profit;
    //    }
    //
    //    public int majorityElement(int[] nums) {
    //
    //        int count = 1;
    //        int current = nums[0];
    //        for (int i = 1; i < nums.length; i++) {
    //            if (count == 0) {
    //                current = nums[i];
    //            }
    //            if (current == nums[i]) {
    //                count++;
    //            } else {
    //                count--;
    //            }
    //        }
    //
    //        return current;
    //        //        int ret = 0;
    //        //
    //        //        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    //        //        for (int i = 0; i < nums.length; i++) {
    //        //            if(map.containsKey(nums[i])){
    //        //                map.put(nums[i], map.get(nums[i]) + 1);
    //        //            }else {
    //        //                map.put(nums[i], 1);
    //        //            }
    //        //        }
    //        //
    //        //
    //        //        return ret;
    //    }
    //
    //    public double myPow(double x, int n) {
    //
    //        if (n == 0) {
    //            return 1;
    //        } else if (n == Integer.MIN_VALUE) {
    //            return 1 / x * myPow(x, n + 1);
    //        } else if (n < 0) {
    //            n = -n;
    //            x = 1 / x;
    //        }
    //
    //        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    //    }
    //
    //    public class TreeNode {
    //
    //        int val;
    //        TreeNode left;
    //        TreeNode right;
    //
    //        TreeNode(int x) {
    //            this.val = x;
    //        }
    //    }
    //
    //    /**
    //     * Definition for a binary tree node.
    //     * public class TreeNode {
    //     * int val;
    //     * TreeNode left;
    //     * TreeNode right;
    //     * TreeNode(int x) { val = x; }
    //     * }
    //     */
    //    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //
    //        if (root == null || p == root || q == root) {
    //            return root;
    //        }
    //        if (p.val < root.val && q.val < root.val) {
    //            return lowestCommonAncestor(root.left, p, q);
    //        } else if (p.val > root.val && q.val > root.val) {
    //            return lowestCommonAncestor(root.right, p, q);
    //        }
    //
    //        return root;
    //    }
}
