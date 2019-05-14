package Entities;

public class Library {
    private int id;
    private String name;
    private String address;
    private String description;
    private BookItem[] bookItems;

    public Library(int id, String name, String address, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
    }
}
