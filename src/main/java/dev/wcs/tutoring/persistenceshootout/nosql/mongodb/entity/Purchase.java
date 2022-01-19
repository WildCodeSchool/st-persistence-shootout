package dev.wcs.tutoring.persistenceshootout.nosql.mongodb.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Purchase {

    private String article;
    private LocalDate purchaseDate;
    private BigDecimal price;

    public Purchase() {}

    public Purchase(String article, LocalDate purchaseDate, BigDecimal price) {
        this.article = article;
        this.purchaseDate = purchaseDate;
        this.price = price;
    }


    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
