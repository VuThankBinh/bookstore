package com.bnpstudio.bookstore;

public class Book {
    private int id;
    private String bookname;

    public Book() {

    }

    public Book(int id, String bookname) {
        this.id = id;
        this.bookname = bookname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", bookname=" + bookname + "]";
    }
}