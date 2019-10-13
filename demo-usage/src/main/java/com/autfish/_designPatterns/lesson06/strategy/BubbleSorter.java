package com.autfish._designPatterns.lesson06.strategy;

import java.util.Arrays;

public class BubbleSorter implements Sorter {
    @Override
    public void sort(int[] numbers) {
        if(numbers == null) return;
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println("冒泡排序: " + Arrays.toString(numbers));
    }
}
