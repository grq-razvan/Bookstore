package views;

import controllers.BookController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookFindView extends Window {

    private static final Object[] TABLE_HEADERS = {"ID", "TITLE", "AUTHOR",
            "GENRE", "COPIES"};
    private static final Integer OFFSET_HEIGHT = 100;
    private JTable table;
    private JButton findId, findAuthor, findTitle, findMore, findLess, findGenre, clear;
    private JTextField searchBox;

    public BookFindView(boolean isAdmin) {
        findId = new JButton("ID");
        findAuthor = new JButton("Author");
        findTitle = new JButton("Title");
        findMore = new JButton("More copies than");
        findLess = new JButton("Less copies than");
        findGenre = new JButton("Genre");
        clear = new JButton("Clear");
        searchBox = new JTextField();
        DefaultTableModel model = new DefaultTableModel(TABLE_HEADERS, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(400, 200, 480, 240);

        findId.setBounds(145, 60 + OFFSET_HEIGHT, 80, 30);
        findTitle.setBounds(145, 100 + OFFSET_HEIGHT, 80, 30);
        findAuthor.setBounds(60, 100 + OFFSET_HEIGHT, 80, 30);
        findMore.setBounds(195, 140 + OFFSET_HEIGHT, 160, 30);
        findLess.setBounds(25, 140 + OFFSET_HEIGHT, 160, 30);
        findGenre.setBounds(230, 100 + OFFSET_HEIGHT, 80, 30);

        searchBox.setBounds(80, 100, 220, 30);
        clear.setBounds(320, 100, 80, 30);

        panel.add(findId);
        panel.add(findAuthor);
        panel.add(findTitle);
        panel.add(findMore);
        panel.add(findLess);
        panel.add(findGenre);
        panel.add(searchBox);
        panel.add(scroll);
        panel.add(clear);

        if (isAdmin) {
            findId.setEnabled(false);
            findTitle.setEnabled(false);
            findAuthor.setEnabled(false);
            findGenre.setEnabled(false);
            findMore.setEnabled(true);
            findLess.setEnabled(true);
        } else {
            findId.setEnabled(true);
            findTitle.setEnabled(true);
            findAuthor.setEnabled(true);
            findGenre.setEnabled(true);
            findMore.setEnabled(false);
            findLess.setEnabled(false);
        }

        BookController.find(this);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JButton getFindId() {
        return findId;
    }

    public void setFindId(JButton findId) {
        this.findId = findId;
    }

    public JButton getFindAuthor() {
        return findAuthor;
    }

    public void setFindAuthor(JButton findAuthor) {
        this.findAuthor = findAuthor;
    }

    public JButton getFindTitle() {
        return findTitle;
    }

    public void setFindTitle(JButton findTitle) {
        this.findTitle = findTitle;
    }

    public JButton getFindMore() {
        return findMore;
    }

    public void setFindMore(JButton findMore) {
        this.findMore = findMore;
    }

    public JButton getFindLess() {
        return findLess;
    }

    public void setFindLess(JButton findLess) {
        this.findLess = findLess;
    }

    public JTextField getSearchBox() {
        return searchBox;
    }

    public void setSearchBox(JTextField searchBox) {
        this.searchBox = searchBox;
    }

    public JButton getFindGenre() {
        return findGenre;
    }

    public void setFindGenre(JButton findGenre) {
        this.findGenre = findGenre;
    }

    public JButton getClear() {
        return clear;
    }

    public void setClear(JButton clear) {
        this.clear = clear;
    }

}
