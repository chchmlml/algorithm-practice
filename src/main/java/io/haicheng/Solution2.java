package io.haicheng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/6/24 10:06
 */
public class Solution2 {

    public static void main(String[] args) {

        Solution2 s = new Solution2();

        //        int[] nums = {1,
        //                2,
        //                3};
        //        s.permute(nums);

        //        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
        //                { 13, 14, 15, 16 } };
        //        printMatrix(matrix);
        //        s.rotate(matrix);
        //        System.out.println("=========");
        //        printMatrix(matrix);

        //        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //        System.out.println("=========" + s.groupAnagrams(strs));
        //        int[] nums = {2,
        //                7,
        //                11,
        //                15};
        //        System.out.println(s.twoSum(nums, 9));
        //        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        int[] candidates = {2,
                3,
                6,
                7};
        System.out.println(s.combinationSum(candidates, 7));

        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.candidates = candidates;
        this.len = candidates.length;
        this._findCombinationSum(target, 0, new Stack<Integer>());

        return ret;
    }

    List<List<Integer>> ret = new ArrayList<>();
    int[] candidates;
    private int len;

    private void _findCombinationSum(int find, int start, Stack<Integer> pre) {

        if (find < 0) {
            return;
        }

        if (find == 0) {
            ret.add(new ArrayList<Integer>(pre));
            return;
        }

        for (int i = start; i < this.len; i++) {
            pre.add(this.candidates[i]);
            _findCombinationSum(find - this.candidates[i], i, pre);
            pre.pop();
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public String longestPalindrome(String s) {

        if (null == s || "" == s) {
            return null;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            int len1 = getLengthByExpore(chars, i, i);
            int len2 = getLengthByExpore(chars, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int getLengthByExpore(char[] chars, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < chars.length && chars[L] == chars[R]) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (i < chars.length && j < chars.length) {
            if (!set.contains(chars[j])) {
                set.add(chars[j++]);
                ans = Math.max(ans, set.size());
            } else {
                set.remove(chars[i++]);
            }
        }
        return ans;
    }


    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == (nums[i] + nums[j])) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return ret;
    }


    public int maxSubArray(int[] nums) {
        int ret = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ret = Math.max(sum, ret);
        }
        return ret;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }


    public void rotate(int[][] matrix) {

        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;

        while (a < c) {
            rotateMatrix(matrix, a++, b++, c--, d--);
        }

    }

    private void rotateMatrix(int[][] matrix, int a, int b, int c, int d) {

        int step = c - a;
        int tmp = 0;
        for (int i = 0; i < step; i++) {
            tmp = matrix[a][b + i];
            matrix[a][b + i] = matrix[c - i][b]; //左上
            matrix[c - i][b] = matrix[c][d - i];
            matrix[c][d - i] = matrix[a + i][d];
            matrix[a + i][d] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    List<List<Integer>> listList;

    public List<List<Integer>> permute(int[] nums) {
        listList = new ArrayList<List<Integer>>();
        permute(nums, new ArrayList<Integer>());
        return listList;

    }

    private void permute(int[] nums, List<Integer> list) {

        int n = nums.length;
        if (list.size() == n) {
            listList.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (list.contains(nums[i])) {
                continue;
            }

            list.add(nums[i]);
            permute(nums, list);
            list.remove(list.size() - 1);
        }
    }

    public String countAndSay(int n) {

        StringBuilder ret = new StringBuilder();

        char[] chars = String.valueOf(n).toCharArray();
        char num = chars[0];
        int count = 1;
        for (int i = 0; i < chars.length; i++) {

            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                ret.append(count);
                ret.append(num);

                if (i != chars.length - 1) {
                    num = chars[i + 1];
                    count = 1;
                }
            } else {
                count++;
            }

        }
        return ret.toString();
    }

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if ('.' == board[i][j]) {
                    continue;
                }

                for (int k = 8; k > 0 && k != i; k--) {
                    if (board[i][j] == board[k][j]) {
                        return false;
                    }
                }

                for (int k = 8; k > 0 && k != j; k--) {
                    if (board[i][j] == board[i][k]) {
                        return false;
                    }
                }
                for (int k = i + 1; k % 3 != 0; k++) {
                    for (int h = j / 3 * 3; h < j / 3 * 3 + 3; h++) {
                        if (board[i][j] == board[k][h]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

