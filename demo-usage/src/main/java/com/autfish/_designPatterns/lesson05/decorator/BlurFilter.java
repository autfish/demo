package com.autfish._designPatterns.lesson05.decorator;

public class BlurFilter extends Filter {

    public BlurFilter(Picture picture) {
        super(picture);
    }

    @Override
    public void show() {
        this.picture.show();
        System.out.println("添加虚化滤镜");
    }
}
