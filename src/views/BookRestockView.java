package views;

import controllers.BookController;

import javax.swing.*;
import java.awt.*;

public class BookRestockView extends Window {
    private JButton restock, restockAll, clear;
    private JTextField bookId, amount;

    public BookRestockView() {
        restock = new JButton("Restock");
        restockAll = new JButton("Restock all");
        clear = new JButton("Clear");
        bookId = new JTextField();
        amount = new JTextField();

        JLabel operation = new JLabel("<html><font size=5 color='white'>Restock books</font></html>");
        JLabel idLabel = new JLabel("ID: ");
        JLabel amountLabel = new JLabel("Amount: ");
        idLabel.setForeground(Color.WHITE);
        idLabel.setBounds(400, 160, 50, 30);
        bookId.setBounds(460, 160, 120, 30);
        amountLabel.setForeground(Color.WHITE);
        amountLabel.setBounds(400, 200, 50, 30);
        amount.setBounds(460, 200, 120, 30);

        restock.setBounds(390, 250, 90, 30);
        restockAll.setBounds(442, 285, 100, 30);
        clear.setBounds(505, 250, 80, 30);
        operation.setBounds(420, 90, 140, 50);

        panel.add(restock);
        panel.add(restockAll);
        panel.add(amount);
        panel.add(clear);
        panel.add(bookId);
        panel.add(operation);
        panel.add(amountLabel);
        panel.add(idLabel);

        BookController.restock(this);
    }

    public JButton getRestock() {
        return restock;
    }

    public void setRestock(JButton restock) {
        this.restock = restock;
    }

    public JButton getRestockAll() {
        return restockAll;
    }

    public void setRestockAll(JButton restockAll) {
        this.restockAll = restockAll;
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

    public JTextField getAmount() {
        return amount;
    }

    public void setAmount(JTextField amount) {
        this.amount = amount;
    }
}
