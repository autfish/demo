package com.autfish._designPatterns.lesson06.strategy;

public class Context {

    private Sorter sorter;

    public Context(Sorter sorter) {
        this.sorter = sorter;
    }

    public void sort(int[] numbers) {
        this.sorter.sort(numbers);
    }

    public static void main(String[] args) {
        int[] numbers = new int[] { 7, 3, 5, 8, 1, 9, 4, 5, 6, 2, 10};
        Context context = new Context(new BubbleSorter());
        context.sort(numbers);

        context = new Context(new MergeSorter());
        context.sort(numbers);

        context = new Context(new QuickSorter());
        context.sort(numbers);
    }
}
