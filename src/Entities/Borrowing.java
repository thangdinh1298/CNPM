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
}
