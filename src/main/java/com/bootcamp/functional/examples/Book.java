package com.bootcamp.functional.examples;

public class Book {
    private Integer id;
    private String title;
    private Integer publishYear;

    public Book(Integer id, String title, Integer publishYear) {
        this.id = id;
        this.title = title;
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }
}
