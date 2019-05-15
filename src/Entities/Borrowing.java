package Entities;

import java.util.Date;

public class Borrowing {
    private int id;
    private Date borrowDate;
    private Date returnDate;
    private BorrowingRecord[] borrowingRecords;

    public Borrowing(int id, Date borrowDate, Date returnDate, BorrowingRecord[] borrowingRecords) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.borrowingRecords = borrowingRecords;
    }

    public int getId() {
        return id;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public BorrowingRecord[] getBorrowingRecords() {
        return borrowingRecords;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setBorrowingRecords(BorrowingRecord[] borrowingRecords) {
        this.borrowingRecords = borrowingRecords;
    }
}
