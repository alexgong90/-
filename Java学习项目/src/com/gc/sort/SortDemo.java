package com.gc.sort;

import java.util.Arrays;

/**
 * 总结:
 * 树形结构排序一般都涉及到 分治法 和 递归的思想, 时间复杂度一般都是O(n*lgn),树节点数量m = 2^h-1,h是树的高度(深度)
 * <p>
 * 递归是一个栈的结构,函数调用栈的结构,每次递归调用都不会直接结束, 一直到触发递归终止条件,此时从栈顶开始弹栈,返回,一层一层返回给下一层调用栈.
 * <p>
 * 分治法主要是  递归终止条件, 递归式,  整合算法, 在理解了递归的复杂拆分成简单,最后究极简单在处理的思想后, 往往整和算法是比较难写的步骤.
 * <p>
 * 涉及到数组下标越界的问题, if判断下标越界,不如直接使用while循环,  谁可能越界,就对谁while遍历, 时刻注意分治,拆解.
 */
public class SortDemo {
    public static void main(String[] args) {

        int[] testArr = {9, 2, 8, 1, 3, 2, 9, 5, 6, 5};
        /*##################################归并排序############################################*/
//        mergeSort(testArr, 0, testArr.length - 1);
        quickSortSwipe(testArr, 0, testArr.length - 1);

        /*##################################快速排序############################################*/
        System.out.println(Arrays.toString(testArr));
        int index = binarySearch(testArr, 0, testArr.length - 1, 2);
        System.out.println("index = " + index);
    }



    /*##################################归并排序############################################*/

    /**
     * 归并排序
     * 分治的思想,使用递归,不断拆分, 在栈顶开始整合弹栈
     * 拆分
     * 整合
     * 时间复杂度为  树形结构的高度为h, 子节点个数为 n = 2^h -1, h = log2^n, 时间复杂度为 宽度cn * lgn = nlgn
     */
    public static void mergeSort(int[] arr, int left, int right) {
        //递归终止条件
        if (left >= right) {
            return;
        }

        //分离点
        int pivot = (left + right) / 2;
//        System.out.println("pivot = "+ pivot);

        //左侧数组递归
        mergeSort(arr, left, pivot);
        //右侧数组递归
        mergeSort(arr, pivot + 1, right);

        //整合两个子数组,排序为一个有序数组
        merge(arr, left, pivot + 1, right);
    }

    /**
     * @param arr      arr是两个排序好的子数组, 经过这个函数,要成为一个拍好虚的数组 arr -> merged arr
     * @param minIndex minIndex代表小数组的起始位置,
     * @param maxIndex minIndex代表大数组的起始位置,
     * @param endIndex endIndex,代表最后一个元素的index
     */
    private static void merge(int[] arr, int minIndex, int maxIndex, int endIndex) {
        //定义两个数组
        int minArrSize = maxIndex - minIndex;
        int maxArrSize = endIndex - maxIndex + 1;
        int[] minArr = new int[minArrSize];
        int[] maxArr = new int[maxArrSize];

        //填充两个子数组
        for (int i = 0; i < minArrSize; i++) {
            minArr[i] = arr[i + minIndex];
        }

        for (int i = 0; i < maxArrSize; i++) {
            maxArr[i] = arr[i + maxIndex];
        }

        //根据排序,重新填充arr数组
        int i = 0, j = 0;
        int k = minIndex;

        while (i < minArrSize && j < maxArrSize) {
            if (minArr[i] < maxArr[j]) {
                arr[k] = minArr[i];
                i++;
            } else {
                arr[k] = maxArr[j];
                j++;
            }
            k++;
        }

        //处理长的数组,赋值到arr剩下的位置
        while (i < minArrSize) {
            arr[k] = minArr[i];
            i++;
            k++;
        }

        while (j < maxArrSize) {
            arr[k] = maxArr[j];
            j++;
            k++;
        }
    }
    /*##################################快速排序############################################*/

    /**
     * 快排和归并的唯一区别就在于 整合算法, 归并是合并两个有序子数组, 而快排是 选择排序的 交换 思想, 让pivot左边比他小, 右边比他大
     */

    private static void quickSortSwipe(int[] arr, int start, int end) {
        //递归终止条件
        if (start >= end) {
            return;
        }
        //递归式,找出pivot并且两个大小排序数组,让小数组内的元素都小于pivot,大数组都大于
        int pivot = qsOne(arr, start, end);
        quickSortSwipe(arr, start, pivot - 1);
        quickSortSwipe(arr, pivot + 1, end);
    }

    private static int qsOne(int[] arr, int start, int end) {
        //就把最后一个元素作为pivot吧
        int pivotVal = arr[end];
        //使用选择排序的方式,把小的放前面,大的放后面
        int i, j = start;
        for (i = start; i < end; i++) {
            if (arr[i] < pivotVal) {
                //小的要交换到前面
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                //维持大小数组分界线的位置.j是大数组第一个元素的索引
                j++;
            }
        }
        //交换pivot和大小临界点的位置
        arr[end] = arr[j];
        arr[j] = pivotVal;
        System.out.println("pivotVal = "+pivotVal+" arrs: "+Arrays.toString(arr));
        return j;
    }


    /*##################################二分查找############################################*/

    /**
     * 二分查找的先决条件是 数组必须是有序的, 一个有序数组, 查找一个元素,返回他的索引值.
     * 也是使用了分治的思想
     */

    private static int binarySearch(int[] arr, int left, int right, int value) {
        //种植条件
        if (left >= right) {
            return -1;
        }
        int pivotIndex = (left + right) / 2;
        int arrValue = arr[pivotIndex];


        if (value > arrValue) {
            //向右侧递归
            return binarySearch(arr, pivotIndex + 1, right, value);
        } else if (value < arrValue) {
            //向左侧递归
            return binarySearch(arr, left, pivotIndex, value);

        } else {
            return arrValue;
        }


    }
}
