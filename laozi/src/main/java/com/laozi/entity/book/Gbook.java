package com.laozi.entity.book;

public class Gbook {
    private String book_id;
    private String book_name;
    private String is_dir;
    private String parbook_name;
    private String book_path;

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getIs_dir() {
        return is_dir;
    }

    public void setIs_dir(String is_dir) {
        this.is_dir = is_dir;
    }

    public String getParbook_name() {
        return parbook_name;
    }

    public void setParbook_name(String parbook_name) {
        this.parbook_name = parbook_name;
    }

    public String getBook_path() {
        return book_path;
    }

    public void setBook_path(String book_path) {
        this.book_path = book_path;
    }
}
