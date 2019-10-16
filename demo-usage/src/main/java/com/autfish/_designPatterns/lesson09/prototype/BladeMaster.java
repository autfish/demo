package com.autfish._designPatterns.lesson09.prototype;

public class BladeMaster implements Cloneable {

    private int level;
    private int str;
    private int dex;
    private int intelligence;
    private int attack;

    public BladeMaster() {
    }

    public BladeMaster(int level, int str, int dex, int intelligence, int attack) {
        this.level = level;
        this.str = str;
        this.dex = dex;
        this.intelligence = intelligence;
        this.attack = attack;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("[lvl: %d, str: %d, dex: %d, int: %d, atk: %d]", level, str, dex, intelligence, attack);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
