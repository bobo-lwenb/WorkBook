package com.workbook.liuwb.mylibrary.utils;

import java.util.Arrays;

public class AlgoriUtil {

    public AlgoriUtil() {
    }

    /**
     * 冒泡排序，从小到大
     *
     * @param target 需要排序的数组
     */
    public void bubblingUp(int[] target) {
        for (int i = 1; i < target.length; i++) {// 外部for用于确定未冒泡的排序范围
            for (int j = 0; j < target.length - i; j++) {// 内部for用于在外部范围内进行排序
                if (target[j] > target[j + 1]) {
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }
        System.out.println("aaabbb bubblingUp:  " + Arrays.toString(target));
    }

    /**
     * 冒泡排序，从大到小
     * 还是从数组的左边开始
     *
     * @param target
     */
    public void bubblingDown(int[] target) {
        for (int i = 1; i < target.length; i++) {
            for (int j = 0; j < target.length - i; j++) {
                if (target[j] < target[j + 1]) {
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }
        System.out.println("aaabbb bubblingDown:  " + Arrays.toString(target));
    }

    /**
     * 冒泡排序，从大到小
     * 从数组的右边开始
     *
     * @param target
     */
    public void bubblingDown1(int[] target) {
        if (target.length == 0) return;
        for (int i = target.length - 1; i >= 0; --i) {
            for (int j = target.length - 1; j >= target.length - i; j--) {
                if (target[j - 1] < target[j]) {
                    int temp = target[j];
                    target[j] = target[j - 1];
                    target[j - 1] = temp;
                }
            }
        }
        System.out.println("aaabbb bubblingDown1:  " + Arrays.toString(target));
    }

    /**
     * 选择排序，从小到大
     *
     * @param target
     */
    public void selectUp(int[] target) {
        for (int i = 0; i < target.length; i++) {// 外部for用于缩小未排序范围
            int min = i;// 用于存放最小数的下标
            for (int j = i; j < target.length; j++) {// 内部for用于在外部范围内循环选择最小数的下标
                if (target[j] < target[min]) {
                    min = j;
                }
            }
            if (min != i) {// 更新最小数
                int temp = target[min];
                target[min] = target[i];
                target[i] = temp;
            }
        }
        System.out.println("aaabbb selectUp:  " + Arrays.toString(target));
    }

    /**
     * 插入排序方法
     */
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {//外层向右的index，即作为比较对象的数据的index
            int temp = arr[i];//用作比较的数据
            int j = i - 1;
            while (arr[j] > temp) {//当比到最左边或者遇到比temp小的数据时，结束循环
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;//把temp放到空位上
        }
        System.out.println("aaabbb doInsertSort:  " + Arrays.toString(arr));
    }

    /**
     * 不使用递归的二分查找
     *
     * @param target
     * @param aims
     */
    public void binarySearch(int[] target, int aims) {
        int down = 0, top = target.length - 1;// 查找的范围
        int middle;// 每次查找范围的中间下标
        while (down <= top) {
            middle = (down + top) / 2;
            if (target[middle] < aims) {
                down = middle + 1;// 如果中值小于目标，则说明中值位于右部，这样范围的左值就可以往右收缩，从而达到缩小范围的目的
            } else if (target[middle] > aims) {
                top = middle - 1;// 同理
            } else {
                System.out.println("aaabbb binarySearch:  " + middle);
                return;
            }
        }
    }

    /**
     * 使用递归的二分查找
     *
     * @param target
     * @param aims
     * @param down
     * @param top
     */
    public void binarySearchRecursive(int[] target, int aims, int down, int top) {
        int middle = (down + top) / 2;
        if (target[middle] < aims) {
            binarySearchRecursive(target, aims, middle + 1, top);
        } else if (target[middle] > aims) {
            binarySearchRecursive(target, aims, down, middle - 1);
        } else {
            System.out.println("aaabbb binarySearchRecursive:  " + middle);
        }
    }

}
