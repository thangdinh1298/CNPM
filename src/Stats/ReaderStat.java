package Stats;

import Entities.Reader;

public class ReaderStat extends Reader {
    private int id;
    private int booksBorrowed;
    private int overdueBooks;

    public ReaderStat(int id, String sername, String password, String fullname, String role, String idcard,
                      String address, String tel, int id1, int booksBorrowed, int overdueBooks) {
        super(id, sername, password, fullname, role, idcard, address, tel);
        this.id = id1;
        this.booksBorrowed = booksBorrowed;
        this.overdueBooks = overdueBooks;
    }
}
