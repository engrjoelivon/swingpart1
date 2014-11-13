package advanced;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import advanced_controller.Controller;




public class ControllerFrame extends JFrame {
	private FormPanel formpanel;
	private Display display;
	private TablePanel tablePanel;
	private JFileChooser filechooser;
	private Controller controller;
	private PrefsDialog prefDialog;
	private Preferences prefs;
	
	public ControllerFrame ()
	{
		super("Advanced");
		
		prefDialog=new PrefsDialog(this);
		prefs=Preferences.userRoot().node(getClass().getName());//just a string to serve as the preference name when stored on the system
		controller=new Controller();
	formpanel=new FormPanel();
	display=new Display();
	tablePanel=new TablePanel();
//pass datas to the table modal//
	tablePanel.settablemodel( controller.getPerson());
	filechooser=new JFileChooser();
	 //adding filters to filechoosers//
	filechooser.addChoosableFileFilter(new PersonFileFilter());
	
	
	
    
	
	
	
	
	formpanel.formEventlistener(new EventListener() {
	//pass in anonymous class interface eventlistener
	
		
		public void eventOccured(FormEvent e) //Override the eventOccured method , call appropriate getters methods to pass parameters to display panel
		
		{
			Integer inte=new Integer(e.getId());
		display.displayText(e.getName()+"\n ");
		display.displayText(e.getOccupation()+ "\n ");
		display.displayText(inte.toString()+"\n ");
		display.displayText(e.getComboselection()+ "\n");
		display.displayText(e.getRadioButtonSelection()+ "\n");
		controller.addPerson(e);//passes the formevent object to the controller class
		tablePanel.refresh();
		}
	});
	 ////setting preference to save keys using the preference listener interface/////
	prefDialog.setpreferencelistener(new PreferenceListener() {
		
		@Override
		public void preferences(String username, String Password, int port) {
			System.out.println(username +","+ ":"+ Password + ":" + port);
			prefs.put("username", username);
			prefs.put("password", Password);
			prefs.putInt("port", port);
		}
	});

	
	prefDialog.setDefaultKeys(prefs.get("username", ""), prefs.get("password", ""), prefs.getInt("port", 3306));
	
	tablePanel.setTableDeletedListener(new TableDeleteListener() {
		
		
		public void deletedRow(int row) {
		controller.deleteRow(row);	
		System.out.println(row);	
		}
		
		@Override
		public void deletedColumn(int col, int row) {
			
			
		}
	});
	
	setTitle("Frame Icon Example");
	setLayout(new BorderLayout());
	add(formpanel,BorderLayout.EAST);
	add(tablePanel,BorderLayout.WEST);
	Dimension dim=getPreferredSize();
	dim.width=750;
	dim.height=500;
    setJMenuBar(createMenuBar());
	setMinimumSize(dim);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	public static void main(String [] args)
	{
		new ControllerFrame();
	}

	
private JMenuBar createMenuBar(){
  JMenuBar jmenubar=new JMenuBar();	
/////////CreatingJMenu that will be added to JmenuBar/////////// 
  
  JMenu fileMenu=new JMenu("File Menu");
  
  JMenuItem jMenuItemExport =new JMenuItem("Export Item...");
  jMenuItemExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.SHIFT_MASK));
  JMenuItem jMenuItemImport =new JMenuItem("Import Item...");
  jMenuItemImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.SHIFT_MASK));
     //    defining the jMenuItem export                  //
  jMenuItemExport.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		///defining a filechooser swing componet ///
		if(filechooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{   try {
			controller.WriteFile(filechooser.getSelectedFile());
		} catch (IOException e1) {
			
			JOptionPane.showMessageDialog(ControllerFrame.this, "files can not be saved", "Error", JOptionPane.OK_OPTION);
		}
			
			System.out.println(filechooser.getSelectedFile());                                            }
	}
});    //setting the jMenuItem import//
  jMenuItemImport.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			if(filechooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
			{   try {
				controller.ReadFile(filechooser.getSelectedFile());
				tablePanel.settablemodel(controller.getPerson());
				tablePanel.refresh();
			} catch (IOException e1) {
				
				JOptionPane.showMessageDialog(ControllerFrame.this, "Cannot find file", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
				
				System.out.println(filechooser.getSelectedFile());                                            }
		}
	});
  
  
  
  JMenuItem jMenuItemExit=new  JMenuItem("Exit");
  //adding menu item to menu//
  fileMenu.add(jMenuItemImport);
  fileMenu.add(jMenuItemExport);
  fileMenu.addSeparator();
  fileMenu.add(jMenuItemExit);
  
   //adding mnemonics and accelerators/////////////////
  
  fileMenu.setMnemonic(KeyEvent.VK_F);//dont know why it is not working so far
  jMenuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.SHIFT_MASK));
      //adding Listener to jMenuItemExit////
        jMenuItemExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
	/*			
        //using joption pane to request input from a client during confirmation//
				
	String input=JOptionPane.showInputDialog(ControllerFrame.this, "Your name and password pls","need verification", 
			JOptionPane.WARNING_MESSAGE); 
  System.out.println(input);*/
				
				
				
				
			
				
				//Adding JoptionPane to the exit MenuItem to confirm exit//
				ImageIcon image=new ImageIcon("/Users/macbook/Documents/icons/nameicon.png");
				int res=JOptionPane.showConfirmDialog(ControllerFrame.this, "Do you really want to close", "Close page ", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, image);
			 //we used ControllerFrame.this as the component because we are referring to the running component and also so that the joptionpane knows where its parent is and where to open using this new controllerframe() would mean we are creating a new  component
				   if(res==JOptionPane.OK_OPTION)
				   {System.exit(0);}
			}
		});
  
  /////////CreatingJMenu with JDialog and JCheckBoxmemuItem that will be added to JmenuBar////////   
  JMenu windowMenu=new JMenu("With CheckBox");
  JMenuItem prefrence=new JMenuItem("preference....");//by standard menus with dialogs ends with elipes .....
  prefrence.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
	  ///defining the JDialog component//
		
		
		
		
		prefDialog.setVisible(true);
		
	
	}
});
  JMenuItem jMenuZoomItem=new JMenuItem("Zoom");
 final JCheckBoxMenuItem jCheckBoxMenuItem1 =new JCheckBoxMenuItem("Show Person Form");
  JCheckBoxMenuItem jCheckBoxMenuItem2 =new JCheckBoxMenuItem("Always Zoom Out");
  jCheckBoxMenuItem1.setSelected(true);
  windowMenu.add(jMenuZoomItem);
  windowMenu.add(jCheckBoxMenuItem1);
  windowMenu.add(jCheckBoxMenuItem2);
  windowMenu.addSeparator();
  windowMenu.add(prefrence);
  ///setting a listener for the checkbox//////////////
    jCheckBoxMenuItem1.addActionListener(new ActionListener() {
	
	  public void actionPerformed(ActionEvent e) {
		
		formpanel.setVisible(jCheckBoxMenuItem1.isSelected());
	 }
   });

    
 /////////CreatingJMenu with jMenuRadioButton that will be added to JmenuBar//////// 
    JMenu jMenuRadioButton=new JMenu("With Radio Buttons");
    JRadioButtonMenuItem  JRadioButtonMenuItem1=new JRadioButtonMenuItem("RadioButton1");
    JRadioButtonMenuItem  JRadioButtonMenuItem2=new JRadioButtonMenuItem("RadioButton2");
    JRadioButtonMenuItem  JRadioButtonMenuItem3=new JRadioButtonMenuItem("RadioButton3");
    JRadioButtonMenuItem  JRadioButtonMenuItem4=new JRadioButtonMenuItem("RadioButton4");
    JRadioButtonMenuItem1.setActionCommand("RadioButton1");
    JRadioButtonMenuItem1.setActionCommand("RadioButton2");
    JRadioButtonMenuItem1.setActionCommand("RadioButton3");
    JRadioButtonMenuItem1.setActionCommand("RadioButton4");
    jMenuRadioButton.setBackground(Color.orange);
    ButtonGroup bG=new ButtonGroup();
    bG.add(JRadioButtonMenuItem1);
    bG.add(JRadioButtonMenuItem2);
     bG.add(JRadioButtonMenuItem3);
      bG.add(JRadioButtonMenuItem4);
    
    jMenuRadioButton.add(JRadioButtonMenuItem1);
    jMenuRadioButton.add(JRadioButtonMenuItem2);
    jMenuRadioButton.add(JRadioButtonMenuItem3);
    jMenuRadioButton.add(JRadioButtonMenuItem4);
    
    
    
    

 /////////Creating submenu that will be added to Jmenu////////  
  JMenu jMenuParent =new JMenu("Contains Sub");
  JMenu jMenuSub =new JMenu("Sub Menu");
  JMenuItem jSubmenutItem1=new JMenuItem("	Submenu Item1");
  JMenuItem jSubmenutItem2=new JMenuItem("Submenu Item2");
  jMenuSub.add(jSubmenutItem1);
  jMenuSub.add(jSubmenutItem2);
  jMenuParent.add(jMenuSub);
  
/////////adding menu JMenu to JMenubar////////   
  jmenubar.add(fileMenu);
  jmenubar.add(windowMenu);
  jmenubar.add(jMenuParent);
  jmenubar.add(jMenuRadioButton);
  
	
  return jmenubar;
}
}
