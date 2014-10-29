package basic;


import java.awt.*;
import java.util.Scanner;

import javax.swing.*;

public class Basic {
	private static TextArea textarea;
	private static JButton jButton;
	

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
	
	SwingUtilities.invokeLater(new Runnable() {
		
		public void run() {
			
			JFrame jframe=new JFrame("hello world");
			jframe.setLayout(new BorderLayout());
			textarea=new TextArea();
			jButton=new JButton("click me");
			jframe. add(textarea, BorderLayout.CENTER);
			jframe. add(jButton, BorderLayout.SOUTH);
			jframe.	setVisible(true);
			jframe.	setSize(600, 800);
			jframe.	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	});
	

	}

}
