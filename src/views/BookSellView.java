package views;

import controllers.BookController;

import javax.swing.*;
import java.awt.*;

public class BookSellView extends Window {
    private JButton sell, clear;
    private JTextField bookId, amount;

    public BookSellView() {
        sell = new JButton("Sell");
        clear = new JButton("Clear");
        bookId = new JTextField();
        amount = new JTextField();

        JLabel operation = new JLabel("<html><font size=5 color='white'>Sell books</font></html>");
        JLabel idLabel = new JLabel("ID: ");
        JLabel amountLabel = new JLabel("Amount: ");
        idLabel.setForeground(Color.WHITE);
        idLabel.setBounds(400, 160, 50, 30);
        bookId.setBounds(460, 160, 120, 30);
        amountLabel.setForeground(Color.WHITE);
        amountLabel.setBounds(400, 200, 50, 30);
        amount.setBounds(460, 200, 120, 30);

        sell.setBounds(400, 250, 80, 30);
        clear.setBounds(505, 250, 80, 30);
        operation.setBounds(420, 90, 140, 50);

        panel.add(sell);
        panel.add(amount);
        panel.add(clear);
        panel.add(bookId);
        panel.add(operation);
        panel.add(amountLabel);
        panel.add(idLabel);

        BookController.sell(this);
    }

    public JButton getSell() {
        return sell;
    }

    public void setSell(JButton sell) {
        this.sell = sell;
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
