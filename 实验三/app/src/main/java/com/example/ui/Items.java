package com.example.ui;

/**
 * Created by Lenovo on 2020-03-27.
 */

public class Items {
    private String text;
    private boolean choose;

    //构造函数
    public Items() {
        super();
    }

    public Items(String text, boolean choose) {
        super();
        this.text = text;
        this.choose = choose;
    }

    public String getName() {
        return text;
    }

    public void setName(String name) {
        this.text = text;
    }

    public boolean isChoose() {
        return choose;
    }

    public void setChoose(boolean choose) {
        this.choose = choose;
    }

    @Override
    public String toString() {
        return "Item{" +
                "text='" + text + '\'' +
                ",choose=" + choose+
                '}';
    }
}
