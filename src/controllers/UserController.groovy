package controllers

import models.User
import services.GenerateBookReportService
import services.UserService
import views.*

import javax.swing.*
import javax.swing.table.DefaultTableModel
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class UserController {

    private static UserService userService
    private static GenerateBookReportService bookReportService

    public static void list(UserListView userView) {
        JButton button = userView.getButton();
        boolean processed = false;
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (processed == false) {
                    userService = new UserService();
                    List<User> booksToList = userService.getUsers();
                    JTable table = userView.getTable();
                    DefaultTableModel model = (DefaultTableModel) table.getModel()
                    for (User user in booksToList) {
                        Object[] row = [user.id.toString(), user.username, user.role == 0 ? "Employee" : "Administrator"];
                        model.addRow(row);
                        processed = true;
                    }
                }
            }
        })
    }

    public static void add(UserAddView userView) {
        JButton submit = userView.getSubmit()
        JButton clear = userView.getClear()
        JTextField id = userView.id
        JTextField username = userView.username
        JPasswordField pass = userView.password
        JCheckBox role = userView.role

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id.setText("")
                username.setText("")
                pass.setText('')
                role.setSelected(false)
            }
        })

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userService = new UserService();
                List<String> properties = [id.getText(), username.getText(), pass.getText(), role.isSelected() ? "1" : "0"]
                userService.append(properties)
                id.setText("")
                username.setText("")
                pass.setText('')
                role.setSelected(false)
            }
        })
    }

    public static void delete(UserDeleteView userView) {
        JButton delete = userView.submit
        JButton clear = userView.clear
        JTextField id = userView.id

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id.setText("")
            }
        })

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userService = new UserService();
                userService.delete(Integer.valueOf(id.getText()))
                id.setText("")
            }
        })
    }

    public static void update(UserUpdateView userView) {
        JButton submit = userView.getSubmit()
        JButton clear = userView.getClear()
        JTextField id = userView.id
        JTextField username = userView.username
        JPasswordField pass = userView.password
        JCheckBox role = userView.role

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id.setText("")
                username.setText("")
                pass.setText('')
                role.setSelected(false)
            }
        })

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userService = new UserService();
                List<String> properties = [id.getText(), username.getText(), pass.getText(), role.isSelected() ? "1" : "0"]
                userService.modify(Integer.valueOf(id.getText()), properties)
                id.setText("")
                username.setText("")
                pass.setText('')
                role.setSelected(false)
            }
        })
    }

    public static void report(GenerateReportView generateReportView) {
        JButton text = generateReportView.getText();
        JButton xml = generateReportView.getXml();
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookReportService = new GenerateBookReportService()
                bookReportService.generateReport(GenerateBookReportService.TXT)
                JOptionPane.showMessageDialog(null, "Report generated!");
            }
        })
        xml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookReportService = new GenerateBookReportService()
                bookReportService.generateReport(GenerateBookReportService.XML)
                JOptionPane.showMessageDialog(null, "Report generated!");
            }
        })
    }

    public static void find(UserFindView userView) {
    }
}
