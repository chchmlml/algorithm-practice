package io.haicheng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
     * 58 最后一个单词长度
     */
    public int lengthOfLastWord(String s) {

        if (null == s) {
            return 0;
        }

        char[] chars = s.trim().toCharArray();
        int ret = 0;

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

            int left = intervals[i][0];
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
            if (!isUpdate) {
                return false;
            }
        }
        return true;
    }
}

