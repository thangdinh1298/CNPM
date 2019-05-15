package Frames;

import DAOs.ReaderStatDAO;
import Stats.ReaderStat;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class ReaderByBorrowingFRM extends JFrame implements ActionListener {
    private JTextField txtStartDate;
    private JTextField txtEndDate;
    private JButton btnSearch;
    private JButton btnBack;
    private JButton btnResult;
    private JTable tblResult;
    private JLabel lblStartDate;
    private JLabel lblEndDate;
    private ArrayList<JButton> selectButtons;

    private static final int WIDTH = 600;
    private static final int HEIGHT = 300;

    public ReaderByBorrowingFRM() throws HeadlessException {
        selectButtons = new ArrayList<>();
        txtStartDate = new JTextField("yyyy/mm/dd");
        txtEndDate = new JTextField("yyyy/mm/dd");
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        btnResult = new JButton("Result");
        btnResult.addActionListener(this);
        tblResult = new JTable(new DefaultTableModel(null, columnNames));
        lblStartDate = new JLabel("Start date");
        lblEndDate = new JLabel("End date");
        txtStartDate.setSize(80, 20);
        txtEndDate.setSize(80, 20);

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        tblResult.getColumn("Details").setCellRenderer(buttonRenderer);


        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);
        JScrollPane pane = new JScrollPane(tblResult);

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
        ReaderStatDAO rdao = new ReaderStatDAO();
        String sDate = txtStartDate.getText();
        String eDate = txtEndDate.getText();

        Date sd = Date.valueOf(sDate);
        Date ed = Date.valueOf(eDate);

        ArrayList<ReaderStat> stats = rdao.getReaderStat(sd, ed);

        DefaultTableModel data = (DefaultTableModel) tblResult.getModel();
        data.setRowCount(0);

        System.out.println("Stat size is: " + stats.size());

        int count = 1;
        for(ReaderStat stat: stats) {
            Object[] row = new Object[6];
            row[0] = String.valueOf(count);
            row[1] = stat.getFullname();
            row[2] = stat.getAddress();
            row[3] = stat.getTel();
            row[4] = stat.getBooksBorrowed();
            row[5] = new JButton("Select");
            data.addRow(row);
        }

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
        else{

        }
    }

    private static class JTableButtonRenderer implements TableCellRenderer {
        @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            return button;
        }
    }

    public static class JTableModel extends AbstractTableModel {
        private static final long serialVersionUID = 1L;
        private static final String[] COLUMN_NAMES = new String[] {"Id", "Stuff", "Button1", "Button2"};
        private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {Integer.class, String.class, JButton.class,  JButton.class};

        @Override public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        @Override public int getRowCount() {
            return 4;
        }

        @Override public String getColumnName(int columnIndex) {
            return COLUMN_NAMES[columnIndex];
        }

        @Override public Class<?> getColumnClass(int columnIndex) {
            return COLUMN_TYPES[columnIndex];
        }

        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
            /*Adding components*/
            switch (columnIndex) {
                case 0: return rowIndex;
                case 1: return "Text for "+rowIndex;
                case 2: // fall through
                    /*Adding button and creating click listener*/
                case 3: final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button),
                                    "Button clicked for row "+rowIndex);
                        }
                    });
                    return button;
                default: return "Error";
            }
        }
    }
}
