package com.bootcamp.functional.examples;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private Integer id;
    private String name;
    private Integer birthYear;
    private List<Book> books;

    public Author(Integer id, String name, Integer birthYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.books = new ArrayList<>();
    }

    public void addBook(Integer id, String title, Integer publishYear) {
        this.books.add(new Book(id, title, publishYear));
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", books=" + books +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
