package io.haicheng;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/6/24 10:06
 */
public class Solution4 {

    public static void main(String[] args) {

    }


    /**
     * 96 不同的二叉搜索树
     */
    public int numTrees(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}

