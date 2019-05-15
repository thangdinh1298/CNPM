package Entities;

import java.util.Date;

public class BookItem {
    private int id;
    private String namee;
    private String genre;
    private String description;
    private String publisher;
    private Date publishDate;
    private String edition;
    private float depositAmount;

    public BookItem(int id, String namee, String genre, String description, String publisher, Date publishDate,
                    String edition, float depositAmount) {
        this.id = id;
        this.namee = namee;
        this.genre = genre;
        this.description = description;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.edition = edition;
        this.depositAmount = depositAmount;
    }

    public int getId() {
        return id;
    }

    public String getNamee() {
        return namee;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getPublisher() {
        return publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getEdition() {
        return edition;
    }

    public float getDepositAmount() {
        return depositAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDepositAmount(float depositAmount) {
        this.depositAmount = depositAmount;
    }
}
