package io.haicheng;

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

        return;
    }

    public boolean canJump(int[] nums) {
        int position = nums.length - 1; //要找的位置
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
            if(!isUpdate){
                return false;
            }
        }
        return true;
    }
}

