package intermediary;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.TextArea;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Textpanelinter extends JPanel{
	private TextArea textArea;
	public Textpanelinter()
	{
		textArea=new TextArea();
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea),BorderLayout.CENTER);
		
	}
public void appendtext(String str)
{
textArea.append(str);

}
	
}
