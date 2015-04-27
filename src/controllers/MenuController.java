package controllers;

import views.*;
import views.frame.Frame;
import views.menu.Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {

    public static void link(Menu menu) {
        menu.getExit().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });

        menu.getLogoff().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new LoginView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getFindByTitle().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new BookFindView(Menu.isAdmin).getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getFindByAuthor().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new BookFindView(Menu.isAdmin).getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getFindById().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new BookFindView(Menu.isAdmin).getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getFindLess().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new BookFindView(Menu.isAdmin).getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getFindMore().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new BookFindView(Menu.isAdmin).getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getFindAllBooks().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new BookListView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getFindAllEmployees().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new UserListView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getEmployeeAddBook().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new BookAddView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getEmployeeDeleteBook().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new BookDeleteView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getEmployeeSellBook().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new BookSellView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getEmployeeUpdateBook().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new BookUpdateView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getAdminAddEmployee().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new UserAddView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getAdminDeleteEmployee().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new UserDeleteView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getAdminGenerateReport().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new GenerateReportView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getAdminRestockBook().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new BookRestockView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

        menu.getAdminUpdateEmployee().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Container container = Frame.getFrame().getContentPane();
                container.removeAll();
                container.add(new UserUpdateView().getPanel());
                container.repaint();
                container.revalidate();
            }
        });

    }
}
