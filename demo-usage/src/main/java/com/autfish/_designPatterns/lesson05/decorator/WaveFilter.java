package com.autfish._designPatterns.lesson05.decorator;

public class WaveFilter extends Filter {

    public WaveFilter(Picture picture) {
        super(picture);
    }

    @Override
    public void show() {
        this.picture.show();
        System.out.println("添加波浪滤镜");
    }
}
