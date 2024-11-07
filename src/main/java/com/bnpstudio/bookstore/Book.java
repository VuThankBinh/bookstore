package com.bnpstudio.bookstore;

public class Book {
    private int id_sach;
    private String bookname;

    public Book() {

    }

    public Book(int id, String bookname) {
        this.id_sach = id;
        this.bookname = bookname;
    }

    public int getId() {
        return id_sach;
    }

    public void setId(int id) {
        this.id_sach = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public String toString() {
        return "Book [id=" + id_sach + ", bookname=" + bookname + "]";
    }
}