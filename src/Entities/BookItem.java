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
}
