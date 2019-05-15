package Frames;

import Frames.ReaderByBorrowingFRM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReportHomeFRM extends JFrame implements ActionListener {
    private JButton btnBook;
    private JButton btnReaderByBorrowing;
    private JButton btnReaderOverdueBook;
    private JButton btnBack;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private ArrayList<JButton> buttons;

    public ReportHomeFRM() {
        btnBook = new JButton("Book");
        btnReaderByBorrowing = new JButton("Reader by borrowing");
        btnReaderOverdueBook = new JButton("Reader by overdue books");
        btnBack = new JButton("Back");
        buttons = new ArrayList<>();

        buttons.add(btnBook);
        buttons.add(btnReaderByBorrowing);
        buttons.add(btnReaderOverdueBook);
        buttons.add(btnBack);

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
        this.setSize(300,150);
        this.setVisible(true);
        this.setLocation(200,10);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnBook)){

        }
        else if(btnClicked.equals(btnReaderByBorrowing)){
            new ReaderByBorrowingFRM();
        }
        else if (btnClicked.equals(btnBack)){
            this.dispose();
        }

    }
}
