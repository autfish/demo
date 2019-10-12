package com.autfish._designPatterns.lesson05.decorator;

public class CutoutFilter extends Filter {

    public CutoutFilter(Picture picture) {
        super(picture);
    }

    @Override
    public void show() {
        this.picture.show();
        System.out.println("添加木纹滤镜");
    }
}
