package io.haicheng;

/**
 * <p>Title: Sort</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2019-11-18 15:08
 */
public class Sort {

    private int[] arr;

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }

        }
    }

    /**
     * 插入排序 分成左右两个序列，一边有序一边无序 将无序选择插入到有序的位置
     */
    public void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序 简单选择排序 每次选择一个最小的放到前边
     */
    public void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[min] > arr[j]) {
                    min = j;
                }

                if (min != i) {
                    int tmp = arr[min];
                    arr[min] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    /**
     * 快速排序
     * 分治思想
     */
    public int[] quickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j++;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }

            if (arr[i] == arr[j] && i < j) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        if (i - 1 > start) {
            arr = quickSort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = quickSort(arr, j + 1, end);
        }

        return arr;
    }

    /**
     * 归并排序 
     * 分治思想，分解为多个子序列，合并相邻子序列
     */
    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h) {
            return new int[]{nums[l]};
        }

        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) {
            newNum[m++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            newNum[m++] = rightArr[j++];
        }
        return newNum;
    }

    /**
     * 希尔排序 分治 + 插入排序
     */
    public static void main(String[] args) {
        int[] array = {49,
                38,
                65,
                97,
                76,
                13,
                27,
                49,
                78,
                34,
                12,
                64,
                1};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        //希尔排序
        int gap = array.length;
        while (true) {
            gap /= 2;   //步长每次减半
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < array.length; j += gap) {//这个循环里其实就是一个插入排序
                    int temp = array[j];
                    int k = j - gap;
                    while (k >= 0 && array[k] > temp) {
                        array[k + gap] = array[k];
                        k -= gap;
                    }
                    array[k + gap] = temp;
                }
            }
            if (gap == 1) {
                break;
            }
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
