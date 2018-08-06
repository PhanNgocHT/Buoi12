package com.example.laptrinh.buoi12;

/**
 * Created by Lap trinh on 4/23/2017.
 */

public class TabItem {
    private String name;

    public TabItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
