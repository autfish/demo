package com.autfish._designPatterns.lesson06.strategy;

import java.util.Arrays;

public class QuickSorter implements Sorter {
    @Override
    public void sort(int[] numbers) {
        if(numbers == null) return;
        sort(numbers, 0, numbers.length - 1);
        System.out.println("快速排序: " + Arrays.toString(numbers));
    }

    public void sort(int[] numbers, int left, int right) {
        if(left >= right) {
            return;
        }
        int temp = numbers[left];
        int t;
        int i = left;
        int j = right;
        while(i != j) {
            while (numbers[j] >= temp && i < j)
                j--;
            while (numbers[i] <= temp && i < j)
                i++;
            if(i < j) {
                t = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = t;
            }
        }
        numbers[left] = numbers[i];
        numbers[i] = temp;

        sort(numbers, left, i - 1);
        sort(numbers, i + 1, right);
    }
}
