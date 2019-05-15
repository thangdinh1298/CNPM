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

    public void setId(int id) {
        this.id = id;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setBookItem(BookItem bookItem) {
        this.bookItem = bookItem;
    }

    public void setPaidDeposit(boolean paidDeposit) {
        this.paidDeposit = paidDeposit;
    }

    public void setBillAmount(float billAmount) {
        this.billAmount = billAmount;
    }
}
