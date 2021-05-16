package com.kg.idiomknowledgegraph.bean;

public class Daodejing {
    private int chapter;
    private String original;
    private String translation;
    private String annotation;

    public Daodejing(int chapter, String original, String translation, String annotation) {
        this.chapter = chapter;
        this.original = original;
        this.translation = translation;
        this.annotation = annotation;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    @Override
    public String toString() {
        return "Daodejing{" +
                "chapter=" + chapter +
                ", original='" + original + '\'' +
                ", translation='" + translation + '\'' +
                ", annotation='" + annotation + '\'' +
                '}';
    }
}
