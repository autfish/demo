package com.autfish._designPatterns.lesson05.decorator;

public class Client {

    public static void main(String[] args) {

        Filter waveFilter = new WaveFilter(new Painting());
        Filter blurFilter = new BlurFilter(waveFilter);
        Filter cutoutFilter = new CutoutFilter(blurFilter);

        cutoutFilter.show();
    }
}
