package Entities;

public class BorrowingRecord {
    private int id;
    private Reader reader;
    private BookItem bookItem;
    private boolean paidDeposit;
    private float billAmount;

    public BorrowingRecord(int id, Reader reader, BookItem bookItem, boolean paidDeposit, float billAmount) {
        this.id = id;
        this.bookItem = bookItem;
        this.paidDeposit = paidDeposit;
        this.billAmount = billAmount;
    }

    public int getId() {
        return id;
    }

    public Reader getReader() {
        return reader;
    }

    public BookItem getBookItem() {
        return bookItem;
    }

    public boolean isPaidDeposit() {
        return paidDeposit;
    }

    public float getBillAmount() {
        return billAmount;
    }
}
