package views.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {

	private JMenuBar menuBar;
	private JMenu employee, admin, find, exit;
	private JMenuItem employeeAddBook, employeeDeleteBook, employeeUpdateBook,
			employeeSellBook, adminAddEmployee, adminDeleteEmployee,
			adminUpdateEmployee, adminRestockSupply, adminRestockBook,
			adminGenerateReportTxt, adminGenerateReportXml, findById,
			findByAuthor, findByTitle;

	public Menu(boolean isUserAdmin) {
		super();
		this.menuBar = new JMenuBar();
		this.employee = new JMenu();
		this.admin = new JMenu();
		this.find = new JMenu();
		this.exit = new JMenu();
		this.employeeAddBook = new JMenuItem();
		this.employeeDeleteBook = new JMenuItem();
		this.employeeUpdateBook = new JMenuItem();
		this.employeeSellBook = new JMenuItem();
		this.adminAddEmployee = new JMenuItem();
		this.adminDeleteEmployee = new JMenuItem();
		this.adminUpdateEmployee = new JMenuItem();
		this.adminRestockSupply = new JMenuItem();
		this.adminRestockBook = new JMenuItem();
		this.adminGenerateReportTxt = new JMenuItem();
		this.adminGenerateReportXml = new JMenuItem();
		this.findById = new JMenuItem();
		this.findByAuthor = new JMenuItem();
		this.findByTitle = new JMenuItem();
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getEmployee() {
		return employee;
	}

	public void setEmployee(JMenu employee) {
		this.employee = employee;
	}

	public JMenu getAdmin() {
		return admin;
	}

	public void setAdmin(JMenu admin) {
		this.admin = admin;
	}

	public JMenu getFind() {
		return find;
	}

	public void setFind(JMenu find) {
		this.find = find;
	}

	public JMenu getExit() {
		return exit;
	}

	public void setExit(JMenu exit) {
		this.exit = exit;
	}

	public JMenuItem getEmployeeAddBook() {
		return employeeAddBook;
	}

	public void setEmployeeAddBook(JMenuItem employeeAddBook) {
		this.employeeAddBook = employeeAddBook;
	}

	public JMenuItem getEmployeeDeleteBook() {
		return employeeDeleteBook;
	}

	public void setEmployeeDeleteBook(JMenuItem employeeDeleteBook) {
		this.employeeDeleteBook = employeeDeleteBook;
	}

	public JMenuItem getEmployeeUpdateBook() {
		return employeeUpdateBook;
	}

	public void setEmployeeUpdateBook(JMenuItem employeeUpdateBook) {
		this.employeeUpdateBook = employeeUpdateBook;
	}

	public JMenuItem getEmployeeSellBook() {
		return employeeSellBook;
	}

	public void setEmployeeSellBook(JMenuItem employeeSellBook) {
		this.employeeSellBook = employeeSellBook;
	}

	public JMenuItem getAdminAddEmployee() {
		return adminAddEmployee;
	}

	public void setAdminAddEmployee(JMenuItem adminAddEmployee) {
		this.adminAddEmployee = adminAddEmployee;
	}

	public JMenuItem getAdminDeleteEmployee() {
		return adminDeleteEmployee;
	}

	public void setAdminDeleteEmployee(JMenuItem adminDeleteEmployee) {
		this.adminDeleteEmployee = adminDeleteEmployee;
	}

	public JMenuItem getAdminUpdateEmployee() {
		return adminUpdateEmployee;
	}

	public void setAdminUpdateEmployee(JMenuItem adminUpdateEmployee) {
		this.adminUpdateEmployee = adminUpdateEmployee;
	}

	public JMenuItem getAdminRestockSupply() {
		return adminRestockSupply;
	}

	public void setAdminRestockSupply(JMenuItem adminRestockSupply) {
		this.adminRestockSupply = adminRestockSupply;
	}

	public JMenuItem getAdminRestockBook() {
		return adminRestockBook;
	}

	public void setAdminRestockBook(JMenuItem adminRestockBook) {
		this.adminRestockBook = adminRestockBook;
	}

	public JMenuItem getAdminGenerateReportTxt() {
		return adminGenerateReportTxt;
	}

	public void setAdminGenerateReportTxt(JMenuItem adminGenerateReportTxt) {
		this.adminGenerateReportTxt = adminGenerateReportTxt;
	}

	public JMenuItem getAdminGenerateReportXml() {
		return adminGenerateReportXml;
	}

	public void setAdminGenerateReportXml(JMenuItem adminGenerateReportXml) {
		this.adminGenerateReportXml = adminGenerateReportXml;
	}

	public JMenuItem getFindById() {
		return findById;
	}

	public void setFindById(JMenuItem findById) {
		this.findById = findById;
	}

	public JMenuItem getFindByAuthor() {
		return findByAuthor;
	}

	public void setFindByAuthor(JMenuItem findByAuthor) {
		this.findByAuthor = findByAuthor;
	}

	public JMenuItem getFindByTitle() {
		return findByTitle;
	}

	public void setFindByTitle(JMenuItem findByTitle) {
		this.findByTitle = findByTitle;
	}

}
