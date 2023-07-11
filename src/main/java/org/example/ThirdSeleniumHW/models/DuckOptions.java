package org.example.ThirdSeleniumHW.models;

public class DuckOptions {
    int numberOfItems;
    String size;

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public String getSize() {
        return size;
    }

    public DuckOptions(int numberOfItems, String size) {
        this.numberOfItems = numberOfItems;
        this.size = size;
    }

    public DuckOptions(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}