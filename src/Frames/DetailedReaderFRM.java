package Frames;

import javax.swing.*;

public class DetailedReaderFRM extends  {
    private JLabel startDate;
    private JLabel endDate;
    private JLabel readerName;
    private JButton btnBack;

    public DetailedReaderFRM(JLabel startDate, JLabel endDate, JLabel readerName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.readerName = readerName;

        btnBack = new JButton("Back");

    }
}
