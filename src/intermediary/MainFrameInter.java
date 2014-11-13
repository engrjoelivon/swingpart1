package intermediary;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/*This class contains two constructor the first constructor does not accept any parameter.
It defines a swing application thats simple but not very effective.I say it is not effective because
it sends an instance of the the TextPanel class to the ToolBar class.Remember to have a good GUI application
all the communication between panels should be handled only at the controller level,unless as the application grows 
it get tangled resulting in an error prone application.

The second constructor eliminates the problem mentioned in the first controller
It does this by introducing an interface,this interface act as a pipe to channel datas from the formPanel class to the controller class
 * 
 * 
 * */

public class MainFrameInter extends JFrame {
	private static final long serialVersionUID = 6751427954659386896L;
	private static Textpanelinter textPanelinter;
	private static ToolBarInter  toolBarinter;
	private static ToolBarInter2  toolBarinter2;
	private static FormPanelInter formPanel;
	
////////////For small and simple swing applications can quickly get messy in large applications//////////////////////////
public   MainFrameInter(){
	super("Intermediary");
    setLayout(new BorderLayout());
    textPanelinter=new Textpanelinter();//handles the displaying of text
    toolBarinter=new ToolBarInter();//contains buttons just to display text on the screen when clicked 
   
    toolBarinter. setTextPanel(textPanelinter);//passes a textpanel object to the toolbar class so that the toolbar class can have a way to display its text
    add(textPanelinter, BorderLayout.CENTER);
    add(toolBarinter, BorderLayout.NORTH);
    
   
	this.setSize(400, 500);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	 
	}
////////////////////////For Medium Swing Applications///////////////////////////////////////
public   MainFrameInter(String a){
	super("Intermediary2");
    setLayout(new BorderLayout());
    textPanelinter=new Textpanelinter();//for displaying text
    formPanel =new FormPanelInter();//contains a form to accept inputs from user
   
    formPanel.stringListener(new TextControllerInterface() 
    {
		
		public void textEmitted(String text) {
			textPanelinter.appendtext(text);
			
		}
	});
    
    
    
    add(textPanelinter, BorderLayout.CENTER);
    add(formPanel,BorderLayout.WEST);
    this.setSize(800, 800);//sets size of the frame
    this.setVisible(true);//sets the visible to true
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the frame from the close sign at the top left corner
	
	 
	}



public static void main(String arg[])
{
	new MainFrameInter();
	
	
	
	
	//new MainFrameInter("a");
	
	
	 
}	
	

}

