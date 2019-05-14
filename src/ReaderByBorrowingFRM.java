import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

        Object[] columnNames = {"TT", "IDCard", "Reader Name", "Address", "Phone", "BooksBorrowed", "Details"};

        selectButtons = new ArrayList<>();
        txtStartDate = new JTextField("mm/dd//yyyy");
        txtEndDate = new JTextField("mm/dd//yyyy");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnBack)){
            this.dispose();
        }
        else if(btnClicked.equals(btnSearch)){

        }
        else{

        }
    }
}
