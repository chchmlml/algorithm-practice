package io.haicheng;

/**
 * <p>Title: CommonAlgorithmDemo</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019-10-30 15:49
 */
public class CommonAlgorithmDemo {

    public static void main(String[] args) {

        CommonAlgorithmDemo c = new CommonAlgorithmDemo();
        int[] nums = new int[]{1,
                5,
                8,
                2,
                3,
                9,
                4};
        System.out.println(nums);

        // 冒泡
        int[] ret = c.BubbleSort(nums);

        System.out.println("" + ret);
    }


    public int[] BubbleSort(int[] nums) {

        int i, j;
        for (i = 0; i < nums.length; i++) {
            for (j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return nums;
    }

}
