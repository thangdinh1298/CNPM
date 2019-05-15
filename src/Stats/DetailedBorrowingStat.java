package Stats;

import java.sql.Date;

public class DetailedBorrowingStat {
    private int bookID;
    private String bookName;
    private Date borrowDate;
    private Date returnDate;

    public DetailedBorrowingStat(int bookID, String bookName, Date borrowDate, Date returnDate) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
