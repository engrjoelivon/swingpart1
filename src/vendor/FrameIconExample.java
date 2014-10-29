package vendor;



	import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.apple.eawt.Application;

import java.awt.Dimension;
	 
	public class FrameIconExample extends JFrame {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public static void main(String[] args) {
	        FrameIconExample frame = new FrameIconExample();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //
	        // Set the window size and its title
	        //
	        frame.setSize(new Dimension(300, 200));
	        frame.setTitle("Frame Icon Example");
	        
	 
	       
	        
	        Application.getApplication().setDockIconImage(new ImageIcon("/Users/macbook/Documents/icons/nameicon.png").getImage());
	 
	        // Display the form
	        frame.setVisible(true);
	    }
	}


