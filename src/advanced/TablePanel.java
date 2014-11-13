package advanced;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

import advanced_controller.Controller;
import advancedmodals.Person;

public class TablePanel extends JPanel {
	
	private JTable table;
	private JPopupMenu popmenu;
	private TableDeleteListener tDL;
	private int row;
	private int column;
	
	private PersonTablemodal tablemodal;//another way this can be done is to instantiate the Defaulttablemodal class
	public TablePanel()
	{
		tablemodal=new PersonTablemodal();
	table=new JTable(tablemodal);


	popmenu=new JPopupMenu();//
	JMenuItem deleteitem=new JMenuItem("Delete");
	deleteitem.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e) {
		row=table.getSelectedRow();
		if(tDL != null)
		{ tDL.deletedRow(row);
		  tablemodal.fireTableRowsDeleted(row, row);
		}
			
		}
	});
	popmenu.add(deleteitem);
	  //jtable listening for mouse events//
	table.addMouseListener(new MouseAdapter() {

		@Override
		public void mousePressed(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON3)	
		{  popmenu.show(table, e.getX(), e.getY()) ;                            }
			
		}
		
	});
	setLayout(new BorderLayout());
	Dimension dim=new Dimension();
	dim.width=300;
	dim.height=500;
	setSize(dim);
	add(new JScrollPane(table), BorderLayout.CENTER);
	settablemodel(new Controller().getPerson());
	
	
		
	
		
	}
	public void settablemodel(List<Person> person)
	{
		tablemodal.setDb(person);
		
	}	
	
	public void refresh()//used to refresh the table
	{
		tablemodal.fireTableDataChanged();
		
	}
	public void setTableDeletedListener(TableDeleteListener tDL) {
		this.tDL=tDL;
		
	}

}
