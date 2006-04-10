package Interface;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class Launcer 
{
	public static void main (String args[]) 
	{      
		Progress progress = new Progress();
		
    	JWindow window = new JWindow();
    	window.getContentPane().add(
    	new JLabel(new ImageIcon("images/capture1.png")),BorderLayout.CENTER);
    	
    	window.getContentPane().add(progress.getBar(), BorderLayout.SOUTH);
    	window.setBounds(300, 150, 480, 400);
    	window.setLocationRelativeTo(null);
    	window.setVisible(true);
    	
    	try 
    	{
    	    Thread.sleep(10000);
    	} 
    	catch (InterruptedException e) 
    	{
    	    e.printStackTrace();
    	}
    	
    	window.setVisible(false);
    	Fenetre SuperPaint = new Fenetre();
    	window.dispose();
    	
    }
}

