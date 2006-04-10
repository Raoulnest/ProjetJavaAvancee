package Interface;
import java.awt.Color;
import javax.swing.JProgressBar;

public class Progress 
{
	private Thread t;
	private JProgressBar bar;
	
	public Progress()
	{
		t = new Thread(new Traitement());
		bar = new JProgressBar();
		bar.setMaximum(100);
		bar.setMinimum(0);
		bar.setStringPainted(true);
		bar.setBackground(new Color(51,153,204));
		bar.setForeground(new Color(102,0,102));
		
		t.start();
	}
	
	class Traitement implements Runnable
	{
		public void run()
		{
			for(int val = 0; val <= 500; val++)
			{
				bar.setValue(val);
				try 
				{
					t.sleep(100);
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @return the bar
	 */
	public JProgressBar getBar() 
	{
		return bar;
	}

	/**
	 * @param bar the bar to set
	 */
	public void setBar(JProgressBar bar) 
	{
		this.bar = bar;
	}

}
