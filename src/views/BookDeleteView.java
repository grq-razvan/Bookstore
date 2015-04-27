package views;

import controllers.BookController;

import javax.swing.*;
import java.awt.*;

public class BookDeleteView extends Window {

    private JButton delete, clear;
    private JTextField bookId;

    public BookDeleteView() {
        delete = new JButton("Delete");
        clear = new JButton("Clear");
        bookId = new JTextField();
        JLabel operation = new JLabel("<html><font size=5 color='white'>Delete book</font></html>");
        JLabel idLabel = new JLabel("ID: ");
        idLabel.setForeground(Color.WHITE);
        idLabel.setBounds(400, 160, 50, 30);
        bookId.setBounds(450, 160, 80, 30);
        delete.setBounds(400, 210, 80, 30);
        clear.setBounds(505, 210, 80, 30);
        operation.setBounds(420, 90, 140, 50);
        panel.add(idLabel);
        panel.add(delete);
        panel.add(clear);
        panel.add(bookId);
        panel.add(operation);

        BookController.delete(this);
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public JButton getClear() {
        return clear;
    }

    public void setClear(JButton clear) {
        this.clear = clear;
    }

    public JTextField getBookId() {
        return bookId;
    }

    public void setBookId(JTextField bookId) {
        this.bookId = bookId;
    }

}
