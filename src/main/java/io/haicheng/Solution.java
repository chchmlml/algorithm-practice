package io.haicheng;

import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

        //        System.out.println(s.climbStairs(44));

        //        System.out.println("ab".substring(0));
        //        System.out.println(s.longestPalindrome("ccc"));
        //        System.out.println(s.reverse(-2147483648));

        //        int a = 1;
        //        System.out.println(a);
        //        a = a << 2;
        //        System.out.println(a);
        //        System.out.println(s.myAtoi("-123"));

        //        int[] height = {1,
        //                8,
        //                6,
        //                2,
        //                5,
        //                4,
        //                8,
        //                3,
        //                7};
        //        System.out.println(s.maxArea(height));
        //        System.out.println(s.romanToInt("III"));
        //        System.out.println(s.romanToInt("IV"));
        //        System.out.println(s.romanToInt("IX"));
        //        System.out.println(s.romanToInt("LVIII"));
        //        System.out.println(s.romanToInt("MCMXCIV"));

        //        System.out.println(s.strStr("hello", "ll"));
        //        System.out.println(s.strStr("", ""));
        //        System.out.println(s.strStr("aaaaa", "bba"));
        //        System.out.println(s.strStr("aaa", "aaaa"));

        //        System.out.println(s.divide(5, 2));
        //        System.out.println(s.divide(10, 3));
        //        System.out.println(s.divide(7, -3));

        int[] nums = {1};
        System.out.println(s.searchRange(nums, 1));
    }

    public int[] searchRange(int[] nums, int target) {

        int[] ret = {-1,
                -1};

        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target == nums[mid]) {
                index = mid;
                break;
            }
        }

        if (index == -1) {
            return ret;
        }

        ret[0] = index;
        ret[1] = index;

        int pre = index > 0 ? index - 1 : 0;
        while (pre >= 0) {
            if (nums[pre] == target) {
                ret[0] = pre;
                pre--;
            } else {
                break;
            }
        }
        int next = index < nums.length -1 ? index + 1 : index;
        while (next < nums.length) {
            if (nums[next] == target) {
                ret[1] = next;
                next++;
            } else {
                break;
            }
        }

        return ret;
    }

    /**
     * 33搜索旋转排序数组
     */
    public int search(int[] nums, int target) {

        //        int left = 0;
        //        int right = nums.length - 1;
        //
        //        while (left < right) {
        //            int mid = (left + right) / 2;
        //            if (nums[mid] < nums[right]) {
        //
        //                if (target > nums[mid] && target < nums[right]) {
        //                    left = mid + 1;
        //                } else {
        //                    right = mid - 1;
        //                }
        //
        //            } else if (nums[mid] > nums[right]) {
        //                if (target > nums[left] && target < nums[mid]) {
        //                    right = mid - 1;
        //                } else {
        //                    left = mid + 1;
        //                }
        //            } else {
        //                return mid;
        //            }
        //        }
        return -1;
    }

    /**
     * 29 两数相除
     */
    public int divide(int dividend, int divisor) {

        int dend = Math.abs(dividend);
        int sor = Math.abs(divisor);

        if (dividend * divisor == 0 || dend < sor) {
            return 0;
        }
        // plante of sayounala

        //this is ok
        // ojbk

        int n = 0;
        while (true) {
            ++n;
            if (Math.pow(sor, n) >= dend) {
                n--;
                break;
            }
        }
        if (dividend * divisor > 0) {
            return n;
        } else {
            return -n;
        }
    }

    /**
     * 28. 实现strStr()
     */
    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return -1;
        }

        char[] charsHaystack = haystack.toCharArray();
        char[] charsneedle = needle.toCharArray();
        if (charsneedle.length == 0) {
            return 0;
        }

        int ret = -1;
        for (int i = 0; i < charsHaystack.length; i++) {
            int indexH = i;
            int indexN = 0;
            while (indexN < charsneedle.length) {
                if (indexH >= charsHaystack.length) {
                    return -1;
                }
                if (charsHaystack[indexH] != charsneedle[indexN]) {
                    ret = -1;
                    break;
                } else {
                    ret = i;
                }
                indexH++;
                indexN++;
            }
            if (ret != -1) {

                return ret;
            }
        }

        return ret;
    }

    /**
     * 21 合并有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode current = new ListNode(-1);
        ListNode head = current;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = new ListNode(l1.val);
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                current = current.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            current.next = new ListNode(l1.val);
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            current.next = new ListNode(l2.val);
            current = current.next;
            l2 = l2.next;
        }

        return head.next;
    }

    /**
     * 20 删除倒数n个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode iterator = new ListNode(-1);
        iterator.next = head;
        List<Integer> list = new ArrayList<Integer>();
        while (iterator.next != null) {
            list.add(iterator.next.val);
            iterator.next = iterator.next.next;
        }

        int search = list.size() - n;

        ListNode current = new ListNode(-1);
        int find = 0;
        if (find == search) {
            current.next = head.next;
            return current.next;
        }
        find++;
        current.next = head;
        while (head.next != null) {
            if (find == search) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
            find++;
        }
        return current.next;
    }

    public String longestCommonPrefix(String[] strs) {

        return null;

    }

    /**
     * 13 罗马数字转整数
     */
    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        char[] chars = s.toCharArray();
        int ret = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            int current = map.get(chars[i]);
            int next = map.get(chars[i + 1]);
            if (current >= next) {
                ret += map.get(chars[i]);
            } else {
                ret -= map.get(chars[i]);
            }
        }
        ret += map.get(chars[chars.length - 1]);
        return ret;
    }


    public int maxArea(int[] height) {
        //        int area = 0;
        //        int i = 0;
        //        int j = height.length - 1;
        //
        //        while (i < j){
        //            int h = Math.min(height[i], height[j]);
        //            int w = j - i;
        //            area = Math.max(area, h * w);
        //            i++;
        //            j--;
        //        }
        //        return area;

        int area = 0;
        for (int i = 1; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {

                int h = Math.min(height[i], height[j]);
                int w = j - i;
                area = Math.max(area, h * w);
            }
        }
        return area;
    }

    public int myAtoi(String str) {
        if (null == str || "" == str) {
            return 0;
        }

        str = str.trim();
        Queue<Integer> queue = new LinkedList<Integer>();
        char[] chars = str.toCharArray();

        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('0', 0);
            put('1', 1);
            put('2', 2);
            put('3', 3);
            put('4', 4);
            put('5', 5);
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
        }};
        boolean isNegtive = false;
        int isOut = 1;
        for (char c : chars) {

            if (queue.size() == 0 && '+' == c) {
                if (--isOut < 0) {
                    return 0;
                }
                continue;
            }
            if (queue.size() == 0 && '-' == c) {
                isNegtive = true;
                if (--isOut < 0) {
                    return 0;
                }
                continue;
            }

            if (!map.containsKey(c)) {
                break;
            }
            queue.offer(map.get(c));
        }

        long ret = 0;
        while (queue.size() > 0) {
            int level = queue.size() - 1;
            ret += Math.pow(10, level) * queue.poll();
        }

        ret = isNegtive ? -ret : ret;
        final int MAX = (int) (Math.pow(2, 31) - 1);
        final int MIN = (int) (Math.pow(-2, 31));
        if (ret > MAX) {
            return MAX;
        }
        if (ret < MIN) {
            return MIN;
        }
        return (int) ret;
    }

    public int reverse(int x) {

        final int MAX = (int) (Math.pow(2, 31) - 1);
        final int MIN = (int) (-Math.pow(2, 31) - 1);
        long current = (long) x;

        current = Long.parseLong(new StringBuffer(valueOf(Math.abs(current))).reverse().toString());

        if (current > MAX || current < MIN) {
            return 0;
        }

        return (int) ((x > 0) ? current : -current);

        //        int news = Math.abs(x);
        //        Stack<Integer> stack = new Stack<Integer>();
        //
        //        while (news > 0) {
        //            int current = news % 10;
        //            if (current > 0 || !stack.empty()) {
        //                stack.push(current);
        //            }
        //            news = news / 10;
        //        }
        //
        //        long ret = 0;
        //        long level = 0;
        //        long MAX = (int) (Math.pow(2, 31) -1);
        //        while (stack.size() > 0) {
        //            if (level > 0) {
        //                ret += stack.pop() * level;
        //                level *= 10;
        //            } else {
        //                ret += stack.pop();
        //                level = 10;
        //            }
        //
        //            if(ret > MAX){
        //                return 0;
        //            }
        //        }
        //
        //        return (int) ((x > 0) ? ret : ret * -1);
    }

    public String longestPalindrome(String s) {
        if (null == s || "" == s) {
            return s;
        }
        if (s.length() <= 1) {
            return s.substring(0);
        }
        String ret = s.substring(0, 1);

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {

                if (chars[i] == chars[j]) {

                    int start = i;
                    int end = j;
                    boolean ok = true;
                    while (start != end && start < end) {
                        if (chars[start++] != chars[end--]) {
                            ok = false;
                            break;
                        }
                    }

                    if (ok && ret.length() < s.substring(i, j + 1).length()) {
                        ret = s.substring(i, j + 1);
                    }
                }

            }
        }

        return ret;
    }

    /**
     * 无重复的最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        if (null == s) {
            return 0;
        }
        int ret = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int current = 1;
            for (int j = i + 1; j < chars.length; j++) {

                if (chars[i] == chars[j] || j == chars.length - 1) {
                    ret = Math.max(ret, current);
                    break;
                }
                current++;
            }
        }
        return ret;
    }

    /**
     * 两数相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode current = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int foo = 0;
            if (l1 != null) {
                foo += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                foo += l2.val;
                l2 = l2.next;
            }
            foo += carry;

            carry = foo / 10;
            ListNode node = new ListNode(foo % 10);

            current.next = node;
            current = current.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
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

