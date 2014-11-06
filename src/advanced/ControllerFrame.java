package advanced;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
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
	private JFileChooser filechooser;
	private Controller controller;
	
	public ControllerFrame ()
	{
		super("Advanced");
		controller=new Controller();
	formpanel=new FormPanel();
	display=new Display();
	filechooser=new JFileChooser();
	 //adding filters to filechoosers//
	filechooser.addChoosableFileFilter(new PersonFileFilter());
	
	setTitle("Frame Icon Example");
	
    
	
	setLayout(new BorderLayout());
	add(formpanel,BorderLayout.EAST);
	add(display,BorderLayout.WEST);
	
	
	Dimension dim=getPreferredSize();
	dim.width=600;
	dim.height=500;
	formpanel.formEventlistener(new EventListener() //pass in anonymous class interface eventlistener
	
	{
		
		public void eventOccured(FormEvent e) //Override the eventOccured method , call appropriate getters methods to pass parameters to display panel
		
		{
			Integer inte=new Integer(e.getId());
		display.displayText(e.getName()+"\n ");
		display.displayText(e.getOccupation()+ "\n ");
		display.displayText(inte.toString()+"\n ");
		display.displayText(e.getComboselection()+ "\n");
		display.displayText(e.getRadioButtonSelection()+ "\n");
		controller.addPerson(e);	
		}
	});
	
	
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
/////////CreatingJMenu that will be added to JmenuBar//////// 
  
  JMenu fileMenu=new JMenu("File Menu");
  
  JMenuItem jMenuItemExport =new JMenuItem("Export Item...");
  JMenuItem jMenuItemImport =new JMenuItem("Import Item...");
  ///defining a filechooser swing componet ///
  jMenuItemExport.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		if(filechooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{  System.out.println(filechooser.getSelectedFile());                                            }
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
			 //we used ControllerFrame.this as the component because we are referring to the running component and also so that the joptionpane knows where its parent is and where to open using this new controllerframe() would mean we are creating a new  componet
				   if(res==JOptionPane.OK_OPTION)
				   {System.exit(0);}
			}
		});
  
  /////////CreatingJMenu with JCheckBoxmemuItem that will be added to JmenuBar////////   
  JMenu WindowMenu=new JMenu("With CheckBox");
  JMenuItem jMenuZoomItem=new JMenuItem("Zoom");
 final JCheckBoxMenuItem jCheckBoxMenuItem1 =new JCheckBoxMenuItem("Show Person Form");
  JCheckBoxMenuItem jCheckBoxMenuItem2 =new JCheckBoxMenuItem("Always Zoom Out");
  jCheckBoxMenuItem1.setSelected(true);
  WindowMenu.add(jMenuZoomItem);
  WindowMenu.add(jCheckBoxMenuItem1);
  WindowMenu.add(jCheckBoxMenuItem2);
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
  jmenubar.add(WindowMenu);
  jmenubar.add(jMenuParent);
  jmenubar.add(jMenuRadioButton);
  
	
  return jmenubar;
}
}
