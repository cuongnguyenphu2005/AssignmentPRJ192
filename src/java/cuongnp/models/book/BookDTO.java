/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cuongnp.models.book;

import java.io.Serializable;

/**
 *
 * @author Cuong
 */
public class BookDTO implements Serializable{
    private String bookId;
    private String bookName;
    private String author;
    private String category;
    private String publisher;
    private int publishYear;
    private int quantity;
    private int price;
    private int totalPrice;
    private boolean status;
    private String description;
    private String imageUrl;

    public BookDTO() {
    }

    public BookDTO(String bookId, String bookName, String author, String category, int publishYear, int price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.publishYear = publishYear;
        this.price = price;
    }

    public BookDTO(String bookId, String bookName,int price, int quantity,int totalPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice ;
    }
    
    
    public BookDTO(String bookId, String bookName, String author, String category, String publisher, int publishYear, int quantity, int price, boolean status, String description, String imageUrl) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public BookDTO(String bookId, String bookName, String author, String category, String publisher, int publishYear, int price, String description, String imageUrl) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
