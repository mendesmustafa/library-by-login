package com.mendes.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mendesmustafa on 09.02.2021.
 */

@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "BOOK_ID_SEQ")
    @SequenceGenerator(name = "BOOK_ID_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @Column(name = "SERIAL_NUMBER", unique = true)
    private String serialNumber;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
