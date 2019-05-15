package Frames;

import DAOs.DetailedBorrowingDAO;
import Entities.Borrowing;
import Entities.BorrowingRecord;
import Stats.DetailedBorrowingStat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class DetailedReaderFRM extends JFrame implements ActionListener {
    private JLabel lblStartDate;
    private JLabel lblEndDate;
    private JLabel lblReaderName;
    private JButton btnBack;
    private JTable tblResult;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 300;
    private ArrayList<DetailedBorrowingStat> stats;

    public DetailedReaderFRM(String startDate, String endDate, String readerName, int readerId) {
        this.lblStartDate = new JLabel("Start date: " +startDate);
        this.lblEndDate = new JLabel("End date: " + endDate);
        this.lblReaderName = new JLabel("Reader name: " + readerName);
        stats = new ArrayList<>();

        btnBack = new JButton("Back");
        btnBack.addActionListener(this);

        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);
        tblResult = new JTable(new ReaderDetailedStatTableModel());
        JScrollPane pane = new JScrollPane(tblResult);

        mainPanel.add(lblStartDate);
        mainPanel.add(lblEndDate);
        mainPanel.add(lblReaderName);
        mainPanel.add(pane);
        mainPanel.add(btnBack);

        layout.putConstraint(SpringLayout.NORTH, lblStartDate, 30, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, lblStartDate, 20, SpringLayout.WEST, mainPanel);

        layout.putConstraint(SpringLayout.NORTH, lblEndDate, 30, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, lblEndDate, 20, SpringLayout.EAST, lblStartDate);

        layout.putConstraint(SpringLayout.NORTH, lblReaderName, 30, SpringLayout.SOUTH, lblStartDate);
        layout.putConstraint(SpringLayout.WEST, lblReaderName, 20, SpringLayout.WEST, mainPanel);

        layout.putConstraint(SpringLayout.NORTH, pane, 20, SpringLayout.SOUTH, lblReaderName);
        layout.putConstraint(SpringLayout.WEST, pane, 20, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST, pane, -20, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, pane, -50, SpringLayout.SOUTH, btnBack);

        layout.putConstraint(SpringLayout.WEST, btnBack, WIDTH/2 - 30, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, mainPanel);

        DetailedBorrowingDAO dbao = new DetailedBorrowingDAO();
        Date d1 = Date.valueOf(startDate);
        Date d2 = Date.valueOf(endDate);
        stats = dbao.getReaderDetailedStat(d1, d2, readerId);


        this.add(mainPanel);
        this.setSize(WIDTH,HEIGHT);
        this.setVisible(true);
        this.setLocation(200,10);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    class ReaderDetailedStatTableModel extends DefaultTableModel {
        private String[] columnNames = {"TT",  "Book ID", "Book Name", "Borrow Date", "Return Date"};
        private final Class<?>[] columnTypes = new  Class<?>[] {Integer.class, Integer.class, String.class,
                                                                Date.class, Date.class};

        @Override public int getColumnCount() {
            return columnNames.length;
        }

        @Override public int getRowCount() {
            return stats.size();
        }

        @Override public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override public Class<?> getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }

        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
            /*Adding components*/
            switch (columnIndex) {
                case 0:
                    return rowIndex;
                case 1:
                    return stats.get(rowIndex).getBookID();
                case 2:
                    return stats.get(rowIndex).getBookName();
                case 3:
                    return stats.get(rowIndex).getBorrowDate();
                case 4:
                    return stats.get(rowIndex).getReturnDate();
                default: return "Error";
            }
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
