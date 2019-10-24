package com.autfish._designPatterns.lesson17.memento;

public class Client {

    public static void main(String[] args) {

        XiaoMing  xiaoMing = new XiaoMing(1000000, 35);
        Memento memento = xiaoMing.createMemento();
        Immortal immortal = new Immortal();
        immortal.setMemento(memento);
        System.out.println("现在的状态: 年龄 " + xiaoMing.getAge() + " 存款 " + xiaoMing.getMoney());

        xiaoMing.setMoney(-100000);
        xiaoMing.setAge(40);
        System.out.println("5年后餐厅亏损: 年龄 " + xiaoMing.getAge() + " 存款 " + xiaoMing.getMoney());

        xiaoMing.restoreMemento(immortal.getMemento());
        System.out.println("神仙帮小明恢复到从前: 年龄 " + xiaoMing.getAge() + " 存款 " + xiaoMing.getMoney());
    }
}
