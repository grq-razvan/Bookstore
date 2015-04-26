package views;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookListView extends Window implements View{

	private static final Object[] TABLE_HEADERS = {"ID","TITLE","AUTHOR","GENRE","COPIES"};
	private JTable table;
	
	
	public BookListView(){
		DefaultTableModel model = new DefaultTableModel(TABLE_HEADERS,TABLE_HEADERS.length);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(200,100,480,240);
		panel.add(scroll);
	}


	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		
	}
	
	
}
