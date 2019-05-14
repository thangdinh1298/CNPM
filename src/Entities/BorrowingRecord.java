package Entities;

public class BorrowingRecord {
    private int id;
    private Reader reader;
    private BookItem bookItem;
    private boolean paidDeposit;
    private float billAmount;

    public BorrowingRecord(int id, Reader reader, BookItem bookItem, boolean paidDeposit, float billAmount) {
        this.id = id;
        this.reader = reader;
        this.bookItem = bookItem;
        this.paidDeposit = paidDeposit;
        this.billAmount = billAmount;
    }
}
