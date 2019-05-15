package Stats;

import Entities.Reader;

public class ReaderStat extends Reader {
    private int booksBorrowed;
    private int overdueBooks;

    public ReaderStat(int readerID, String fullname, String address, String tel, int booksBorrowed) {
        super();

        this.id = readerID;
        this.fullname = fullname;
        this.booksBorrowed = booksBorrowed;
        this.address = address;
        this.tel = tel;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public int getOverdueBooks() {
        return overdueBooks;
    }
}
