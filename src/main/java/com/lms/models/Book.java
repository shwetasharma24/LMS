package com.lms.models;

import javax.persistence.*;
import java.util.Date;



//Database name= lmsdb

@Entity( name="lms_tbl")
public class Book {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name= "book_name")
    private String bookName;

    @Column(name="author")
    private String authorName;

    @Column(name="purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

}
