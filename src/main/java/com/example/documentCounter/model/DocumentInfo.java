package com.example.documentCounter.model;

public class DocumentInfo {

    private String filename;
    private int pages;
    private double cost;

    public DocumentInfo(String filename, int pages, double cost) {
        this.filename = filename;
        this.pages = pages;
        this.cost = cost;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
