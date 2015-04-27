package views.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.MenuController;

public class Menu {

	private JMenuBar menuBar;
	private JMenu employee, admin, find, exit;
	private JMenuItem employeeAddBook, employeeDeleteBook, employeeUpdateBook,
			employeeSellBook, adminAddEmployee, adminDeleteEmployee,
			adminUpdateEmployee, adminRestockSupply, adminRestockBook,
			adminGenerateReport, findById, findByAuthor, findByTitle,
			findAllBooks, findAllEmployees, findLess, findMore;

	private static final String ADD = "Add";
	private static final String UPDATE = "Update";
	private static final String DELETE = "Delete";
	private static final String LIST = "List all";
	private static final String REPORT = "Generate report";
	private static final String ID = "Find by ID";
	private static final String AUTHOR = "Find by author";
	private static final String TITLE = "Find by title";
	private static final String LESS = "Find books with less copies than..";
	private static final String MORE = "Find books with more copies that..";
	private static final String RESTOCK = "Restock book supply";
	private static final String SELL = "Sell books";

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
		this.adminRestockBook = new JMenuItem();
		this.adminGenerateReport = new JMenuItem();
		this.findById = new JMenuItem();
		this.findByAuthor = new JMenuItem();
		this.findByTitle = new JMenuItem();
		this.findAllBooks = new JMenuItem();
		this.findAllEmployees = new JMenuItem();
		this.findLess = new JMenuItem();
		this.findMore = new JMenuItem();

		menuBar.add(employee);
		menuBar.add(admin);
		menuBar.add(find);
		menuBar.add(exit);

		exit.setText("Exit");

		employee.setText("Books");
		employee.add(employeeAddBook);
		employeeAddBook.setText(ADD);
		employee.add(employeeDeleteBook);
		employeeDeleteBook.setText(DELETE);
		employee.add(employeeUpdateBook);
		employeeUpdateBook.setText(UPDATE);
		employee.add(employeeSellBook);
		employeeSellBook.setText(SELL);

		admin.setText("Admin area");
		admin.add(adminAddEmployee);
		adminAddEmployee.setText(ADD);
		admin.add(adminDeleteEmployee);
		adminDeleteEmployee.setText(DELETE);
		admin.add(adminUpdateEmployee);
		adminUpdateEmployee.setText(UPDATE);
		admin.add(adminRestockBook);
		adminRestockBook.setText(RESTOCK);
		admin.add(adminGenerateReport);
		adminGenerateReport.setText(REPORT);

		find.setText("Search");
		find.add(findAllBooks);
		findAllBooks.setText(LIST);
		find.add(findAllEmployees);
		findAllEmployees.setText(LIST);
		find.add(findByAuthor);
		findByAuthor.setText(AUTHOR);
		find.add(findById);
		findById.setText(ID);
		find.add(findByTitle);
		findByTitle.setText(TITLE);
		find.add(findLess);
		findLess.setText(LESS);
		find.add(findMore);
		findMore.setText(MORE);
		if (isUserAdmin) {
			findByAuthor.setEnabled(false);
			findById.setEnabled(false);
			findByTitle.setEnabled(false);
			admin.setEnabled(true);
			findAllEmployees.setEnabled(true);
		} else {
			findByAuthor.setEnabled(true);
			findById.setEnabled(true);
			findByTitle.setEnabled(true);
			admin.setEnabled(false);
			findAllEmployees.setEnabled(false);
		}
		MenuController.link(this);
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

	public JMenuItem getAdminGenerateReport() {
		return adminGenerateReport;
	}

	public void setAdminGenerateReport(JMenuItem adminGenerateReportXml) {
		this.adminGenerateReport = adminGenerateReportXml;
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

	public JMenuItem getFindAllBooks() {
		return findAllBooks;
	}

	public void setFindAllBooks(JMenuItem findAllBooks) {
		this.findAllBooks = findAllBooks;
	}

	public JMenuItem getFindAllEmployees() {
		return findAllEmployees;
	}

	public void setFindAllEmployees(JMenuItem findAllEmployees) {
		this.findAllEmployees = findAllEmployees;
	}

	public JMenuItem getFindLess() {
		return findLess;
	}

	public void setFindLess(JMenuItem findLess) {
		this.findLess = findLess;
	}

	public JMenuItem getFindMore() {
		return findMore;
	}

	public void setFindMore(JMenuItem findMore) {
		this.findMore = findMore;
	}

}
