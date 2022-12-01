package com.book_order.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer quantity;
    private Integer  stock;

    @OneToMany(mappedBy = "book")
    private Set<BookOder> bookOders;

    public Book() {
    }

    public Book(Integer id, String title, Integer quantity, Integer stock, Set<BookOder> bookOders) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.stock = stock;
        this.bookOders = bookOders;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Set<BookOder> getBookOders() {
        return bookOders;
    }

    public void setBookOders(Set<BookOder> bookOders) {
        this.bookOders = bookOders;
    }
}
