package com.autfish._designPatterns.lesson09.prototype;

public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {

        BladeMaster bladeMaster = new BladeMaster(5, 55, 80, 30, 100);
        System.out.println(bladeMaster.toString());

        BladeMaster mirror1 = (BladeMaster)bladeMaster.clone();
        mirror1.setAttack(0);
        System.out.println(mirror1.toString());

        BladeMaster mirror2 = (BladeMaster)bladeMaster.clone();
        mirror2.setAttack(0);
        System.out.println(mirror2.toString());
    }
}
