package Stats;

import Entities.Reader;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ReaderStat extends JFrame implements ActionListener {
    private int booksBorrowed;
    private int overdueBooks;

    public ReaderStat(String fullname, String address, String tel, int booksBorrowed) {
        super();

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
