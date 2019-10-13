package com.autfish._designPatterns.lesson06.strategy;

import java.util.Arrays;

public class MergeSorter implements Sorter {
    @Override
    public void sort(int[] numbers) {
        if(numbers == null) return;
        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println("归并排序: " + Arrays.toString(numbers));
    }

    public void mergeSort(int[] numbers, int from, int to) {
        int middle = (from + to) / 2;
        if (from < to) {
            mergeSort(numbers, from, middle);
            mergeSort(numbers, middle + 1, to);
            if(numbers[middle] < numbers[middle + 1])
                return;
            merge(numbers, from, middle, to);
        }
    }

    private void merge(int[] numbers, int from, int middle, int to) {
        int[] temp = new int[to - from + 1];
        int left = from;
        int right = middle + 1;
        int i = 0;
        while (left <= middle && right <= to) {
            if (numbers[left] < numbers[right]) {
                temp[i++] = numbers[left++];
            } else {
                temp[i++] = numbers[right++];
            }
        }
        while (left <= middle) {
            temp[i++] = numbers[left++];
        }
        while (right <= to) {
            temp[i++] = numbers[right++];
        }

        System.arraycopy(temp, 0, numbers, from, temp.length);
    }
}
