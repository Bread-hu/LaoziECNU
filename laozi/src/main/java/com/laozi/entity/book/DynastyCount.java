package com.laozi.entity.book;

public class DynastyCount {
    private String author_dynasty;

    public String getDynasty() {
        return author_dynasty;
    }

    public void setDynasty(String dynasty) {
        this.author_dynasty = dynasty;
    }

    public int getCount() {
        return author_count;
    }

    public void setCount(int count) {
        this.author_count = count;
    }

    private int author_count;
}
