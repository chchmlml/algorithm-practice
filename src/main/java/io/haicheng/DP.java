package io.haicheng;

/**
 * <p>Title: DP</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019/7/15 10:55
 */
public class DP {

    public static void main(String[] args) {

        DP dp = new DP();
        int[] nums = {4,1,1,9,1};
        System.out.println(dp.LargetSumInArray(nums));
    }

    /**
     * 选出数组中不相邻的数最大和
     */
    public int LargetSumInArray(int[] nums) {

        //非递归
        int[] opt = new int[nums.length];
        opt[0] = nums[0];
        opt[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < opt.length; i++) {
            int a = opt(nums, i - 2) + nums[i];
            int b = opt(nums, i - 1);
            opt[i] = Math.max(a, b);
        }
        return opt[nums.length - 1];

        //递归
        //        return opt(nums, nums.length - 1);
    }

    private int opt(int[] nums, int i) {
        if (0 == i) {
            return nums[0];
        }
        if (1 == i) {
            return Math.max(nums[0], nums[1]);
        }

        int a = opt(nums, i - 2) + nums[i];
        int b = opt(nums, i - 1);
        return Math.max(a, b);
    }
}
