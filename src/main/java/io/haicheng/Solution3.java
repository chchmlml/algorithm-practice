package io.haicheng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/6/24 10:06
 */
public class Solution3 {

    public static void main(String[] args) {

        Solution3 s = new Solution3();
        int[] candidates = {2,
                3,
                1,
                1,
                4};
        System.out.println(s.canJump(candidates));

        s.lengthOfLastWord(" ");
        s.lengthOfLastWord("hello world");
        return;
    }

    /**
     * 94 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode<Integer> root) {

        List<Integer> result = new LinkedList<>();
        inOrder(root, result);
        return result;
    }

    public void inOrder(TreeNode<Integer> root, List<Integer> result) {
        if (root != null) {
            inOrder(root.left, result);
            result.add(root.data);
            inOrder(root.right, result);
        }

    }



    private boolean[][] marked;

    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;
    private String word;
    private char[][] board;

    /**
     * 79 单词搜索
     */
    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 77 组合
     */
    public List<List<Integer>> combine(int n, int k) {
        if (n < 0 || k < 0 || n < k) {
            return res;
        }

        _combine(n, k, 1, new Stack<Integer>());
        return res;
    }

    private void _combine(int n, int k, int begin, Stack<Integer> pre) {
        if (pre.size() == k) {
            res.add(new ArrayList<Integer>(pre));
            return;
        }

        for (int i = begin; i <= n; i++) {
            pre.add(i);
            _combine(n, k, i + 1, pre);
            pre.pop();
        }
    }

    /**
     * 75 颜色分类
     */
    public void sortColors(int[] nums) {

        if (nums.length < 3) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    /**
     * 64 最小路径和
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 63 最短路径
     */
    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        //dp的意义
        int[][] dp = new int[m + 1][n + 1];

        //初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //dp关系式
        //dp[i][j] = dp[i][j -1] + dp[i-1][j];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 58 最后一个单词长度
     */
    public int lengthOfLastWord(String s) {

        if (null == s) {
            return 0;
        }

        char[] chars = s.trim().toCharArray();
        int    ret   = 0;

        int index = chars.length - 1;
        for (int i = index; i >= 0; i--) {
            if (' ' == chars[i]) {
                break;
            }
            ret++;
        }
        return ret;

        //        //分割单词
        //        String[] sList = s.split(" ");
        //        if (sList.length == 0) {
        //            return 0;
        //        }
        //        String lastWord = sList[sList.length - 1];
        //        return lastWord.toCharArray().length;
    }

    /**
     * 56 合并区间
     */
    public int[][] merge(int[][] intervals) {

        List<int[]> ret = new ArrayList<>();

        //临界判断
        if (null == intervals || intervals.length == 0) {
            return ret.toArray(new int[0][]);
        }

        //根据每个区间第一个值进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //判断、区间合并
        int i = 0;
        while (i < intervals.length) {

            int left  = intervals[i][0];
            int right = intervals[i][1];

            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {

                i++;
                right = Math.max(intervals[i][1], right);
            }
            ret.add(new int[]{left,
                    right});
            i++;
        }

        return ret.toArray(new int[0][]);
    }

    public boolean canJump(int[] nums) {
        int     position = nums.length - 1; //要找的位置
        boolean isUpdate = false;
        while (position != 0) { //是否到了第 0 个位置
            isUpdate = false;
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    isUpdate = true;
                    break;
                }
            }
            //如果没有进入 for 循环中的 if 语句，就返回 false
            if (!isUpdate) {
                return false;
            }
        }
        return true;
    }
}

