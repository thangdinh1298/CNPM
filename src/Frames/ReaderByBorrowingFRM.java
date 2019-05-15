package Frames;

import DAOs.ReaderStatDAO;
import Stats.ReaderStat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;

public class ReaderByBorrowingFRM extends JFrame implements ActionListener {
    private JTextField txtStartDate;
    private JTextField txtEndDate;
    private JButton btnSearch;
    private JButton btnBack;
//    private JButton btnResult;
    private JTable tblResult;
    private JLabel lblStartDate;
    private JLabel lblEndDate;
     ArrayList<ReaderStat> stats;
    private ArrayList<JButton> listSelect;

    private static final int WIDTH = 600;
    private static final int HEIGHT = 300;

    public ReaderByBorrowingFRM() throws HeadlessException {

        listSelect = new ArrayList<>();
        stats = new ArrayList<>();
        txtStartDate = new JTextField("yyyy/mm/dd");
        txtEndDate = new JTextField("yyyy/mm/dd");
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
//        btnResult = new JButton("Result");
//        btnResult.addActionListener(this);
        tblResult = new JTable(new ReaderStatTableModel());
        lblStartDate = new JLabel("Start date");
        lblEndDate = new JLabel("End date");
        txtStartDate.setSize(80, 20);
        txtEndDate.setSize(80, 20);

        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);
        JScrollPane pane = new JScrollPane(tblResult);

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        tblResult.getColumn("Detail").setCellRenderer(buttonRenderer);
        pane.addMouseListener(new JTableButtonMouseListener(tblResult));

        // adding
        mainPanel.add(txtStartDate);
        mainPanel.add(txtEndDate);
        mainPanel.add(btnBack);
        mainPanel.add(btnSearch);
//        mainPanel.add(btnResult);
        mainPanel.add(pane);
        mainPanel.add(lblStartDate);
        mainPanel.add(lblEndDate);

        //set constraint
        layout.putConstraint(SpringLayout.NORTH, lblStartDate, 30, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, lblStartDate, 60, SpringLayout.WEST, mainPanel);

        layout.putConstraint(SpringLayout.NORTH, txtStartDate, 30, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, txtStartDate, 5, SpringLayout.EAST, lblStartDate);

        layout.putConstraint(SpringLayout.NORTH, lblEndDate, 30, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, lblEndDate, 20, SpringLayout.EAST, txtStartDate);

        layout.putConstraint(SpringLayout.NORTH, txtEndDate, 30, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, txtEndDate, 5, SpringLayout.EAST, lblEndDate);

        layout.putConstraint(SpringLayout.NORTH, btnSearch, 30, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST, btnSearch, 20, SpringLayout.EAST, txtEndDate);

        layout.putConstraint(SpringLayout.NORTH, pane, 40, SpringLayout.SOUTH, lblStartDate);
        layout.putConstraint(SpringLayout.WEST, pane, 20, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST, pane, -20, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, pane, -50, SpringLayout.NORTH, btnBack);

        layout.putConstraint(SpringLayout.WEST, btnBack, WIDTH/2 - 30, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, btnBack, -30, SpringLayout.SOUTH, mainPanel);


        this.add(mainPanel);
        this.setSize(WIDTH,HEIGHT);
        this.setVisible(true);
        this.setLocation(200,10);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void btnSearchClicked() throws ParseException {
        stats.clear();
        listSelect.clear();
        ReaderStatDAO rdao = new ReaderStatDAO();
        String sDate = txtStartDate.getText();
        String eDate = txtEndDate.getText();

        Date sd = Date.valueOf(sDate);
        Date ed = Date.valueOf(eDate);

        stats = rdao.getReaderStat(sd, ed);

        for(ReaderStat stat: stats){
            JButton btn = new JButton("Select");
            btn.addActionListener(this);
            listSelect.add(btn);
        }
        ((DefaultTableModel) tblResult.getModel()).fireTableDataChanged();
        System.out.println(stats.size());
        System.out.println(listSelect.size());

//        System.out.println("Stat size is: " + stats.size());

//        int count = 1;
//        for(ReaderStat stat: stats) {
//            Object[] row = new Object[6];
//            row[0] = String.valueOf(count);
//            row[1] = stat.getFullname();
//            row[2] = stat.getAddress();
//            row[3] = stat.getTel();
//            row[4] = stat.getBooksBorrowed();
//            row[5] = new JButton("Select");
//            data.addRow(row);
//        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnBack)){
            this.dispose();
        }
        else if(btnClicked.equals(btnSearch)){
            try {
                btnSearchClicked();
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
        for(int i=0; i<listSelect.size(); i++)
            if(btnClicked.equals(listSelect.get(i))){
                btnSelectClick(i);
                return;
            }
    }

    private void btnSelectClick(int i) {
        ReaderStat stat = stats.get(i);
        new DetailedReaderFRM( txtStartDate.getText(),
                txtEndDate.getText(),
                stat.getFullname(), stat.getId());
    }

    class JTableButtonRenderer implements TableCellRenderer {
        @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                                 boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            return button;
        }
    }

    class ReaderStatTableModel extends DefaultTableModel {
        private String[] columnNames = {"TT", "ReaderName", "Address", "Tel", "BooksBorrowed", "Detail"};
        private final Class<?>[] columnTypes = new  Class<?>[] {Integer.class, String.class, String.class,  String.class,
                Integer.class, JButton.class};

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
                    return stats.get(rowIndex).getFullname();
                case 2:
                    return stats.get(rowIndex).getAddress();
                case 3:
                    return stats.get(rowIndex).getTel();
                case 4:
                    return stats.get(rowIndex).getBooksBorrowed();
                case 5:
                    return listSelect.get(rowIndex);
                default: return "Error";
            }
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
    class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
            int row    = e.getY()/table.getRowHeight(); //get the row of the button

            //*Checking the row or column is valid or not
            if (row < table.getRowCount() && row >= 0  && column < table.getColumnCount() && column >= 0)  {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {
                    //perform a click event
                    ((JButton)value).doClick();
                }
            }
        }
    }
}
