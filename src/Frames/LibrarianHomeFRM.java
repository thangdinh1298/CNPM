package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibrarianHomeFRM extends JFrame implements ActionListener {
    private JButton btnManageBook;
    private JButton btnManageReader;
    private JButton btnManageBorrowing;
    private JButton btnViewReport;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private ArrayList<JButton> buttons;


    public LibrarianHomeFRM() throws HeadlessException {
        super("Librarian Home");
        btnManageBook = new JButton("Manage Book");
        btnManageReader = new JButton("Manage Reader");
        btnManageBorrowing = new JButton("Manage Borrowing");
        btnViewReport = new JButton("View Report");
        buttons = new ArrayList<>();
        buttons.add(btnManageBook);
        buttons.add(btnManageReader);
        buttons.add(btnManageBorrowing);
        buttons.add(btnViewReport);

        JPanel mainPanel = new JPanel();
        mainPanel.setSize(WIDTH, HEIGHT);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        for(JButton button: buttons){
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(this);
            mainPanel.add(button);
        }

        mainPanel.setVisible(true);
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnManageBook)){
            btnManageBookClicked();
        }
        else if(btnClicked.equals(btnManageReader)){
            btnManageReaderClicked();
        }
        else if(btnClicked.equals(btnManageBorrowing)){
            btnManageBorrowingClicked();
        }
        else {
            btnViewReportClicked();
        }
    }

    private void btnViewReportClicked() {
        new ReportHomeFRM();
    }

    private void btnManageBorrowingClicked() {

    }

    private void btnManageReaderClicked() {

    }

    private void btnManageBookClicked() {
    }

    public static void main(String[] args) {
        LibrarianHomeFRM myFrame = new LibrarianHomeFRM();
        myFrame.setSize(300,150);
        myFrame.setVisible(true);
        myFrame.setLocation(200,10);
    }

}
