package ZoneDessin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class ZoneDessin extends JPanel 
{
	private boolean bgChanging = false; 
	public int mPointerTaille = 5;
	private String mFormeType="Style";
	private Color mCouleurPointer = Color.black;
	private Color mCouleurBackground = Color.white;
	public Color mCouleurPoint =  Color.black;
	private int oldX,oldY;
	private Graphics2D g2;
	private Image image;
	Point x1 = new Point(0,0);
	Point x2 = new Point(0,0);
	
	public ZoneDessin()
	{
		this.setPreferredSize(new Dimension(700, 512));
		this.setBackground(Color.WHITE);
		this.addMouseMotionListener(new MouseMotionListener() 
		{
		 public void mouseMoved(MouseEvent souris) 
			{		
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			} 
		public void mouseDragged(MouseEvent e) 
			{	
			 oldX = e.getX();
			 oldY = e.getY();	 
			 Graphics g = getGraphics ();
			   if(getmFormeType().equals("Style")){
				g.setColor( mCouleurPointer);
				g2.setColor( mCouleurPointer);
				g.fillOval(oldX, oldY, mPointerTaille, mPointerTaille);
				repaint();
				g2.fillOval(oldX, oldY, mPointerTaille, mPointerTaille);
				}
		}
		});	
	
		this.addMouseListener(new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e) 
			{
				x1.setLocation(0,0);
				x2.setLocation(0, 0);
				x1.setLocation(e.getX(), e.getY());		
			}
			public void mouseReleased(MouseEvent e) 
		    {
					x2.setLocation(e.getX(), e.getY());
					repaint();
					Graphics g = getGraphics ();
						if(getmFormeType().equals("Ligne")){
					    g.setColor( mCouleurPointer);
					    g2.setColor( mCouleurPointer);
						g.drawLine(x1.x, x1.y, x2.x, x2.y);
						g2.drawLine(x1.x, x1.y, x2.x, x2.y);
					}
					else
						if(getmFormeType().equals("Rectangle")){
					    g.setColor( mCouleurPointer);
					    g2.setColor(mCouleurPointer);
						int width = Math.abs(x2.x-x1.x);
						int height = Math.abs(x2.y-x1.y);
						g.drawRect(x1.x, x1.y, width, height);
						g2.drawRect(x1.x, x1.y, width, height);
						
					    }
					else 
						if(getmFormeType().equals("RectangleP")){
							g.setColor( mCouleurPointer);
							g2.setColor( mCouleurPointer);
							int width = Math.abs(x2.x-x1.x);
							int height = Math.abs(x2.y-x1.y);
							g.fillRect(x1.x, x1.y, width, height);
							g2.fillRect(x1.x, x1.y, width, height);
					    }
					else	
						if(getmFormeType().equals("Ovale")){
							g.setColor( mCouleurPointer);
							g2.setColor( mCouleurPointer);
							int width = Math.abs(x2.x-x1.x);
							int height = Math.abs(x2.y-x1.y);
							g.drawOval(x1.x, x1.y, width, height);
							g2.drawOval(x1.x, x1.y, width, height);
						}
					else
						if(getmFormeType().equals("OvaleP")){
							g.setColor( mCouleurPointer);
							g2.setColor( mCouleurPointer);
							int width = Math.abs(x2.x-x1.x);
							int height = Math.abs(x2.y-x1.y);
							g.fillOval(x1.x, x1.y, width, height);
							g2.fillOval(x1.x, x1.y, width, height);
						}	
     		}
		});		
	}
	protected void paintComponent(Graphics g) 
	{	
		g.setColor(Color.BLACK);
		
		if(image == null){
			if(!bgChanging){
			image = createImage(getSize().width, getSize().height);
			Graphics2D g2 = (Graphics2D) image.getGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
			}else{
				image = createImage(getSize().width, getSize().height);
				g2 = (Graphics2D) image.getGraphics();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.drawImage(image, 0, 0, null);
				changeBackground();
			}
			
		}
			g.drawImage(image, 0, 0, null);	
	}
	public void clear() {
		g2.setPaint(mCouleurBackground);
		g2.fillRect(0, 0, getSize().width, getSize().height);
		g2.setPaint(Color.black);
		
	}
	
	public void changeBackground() {
		g2.setPaint(mCouleurBackground);
		g2.fillRect(0, 0, getSize().width, getSize().height);	
	}
	
	//*****************************
	
	public void setmFormeType(String mFormeType) 
	{
		this.mFormeType = mFormeType;
	}
	
	public String getmFormeType()
	{
		return mFormeType;
	}
	
	//*****************************

	public void setmCouleurPointer(Color mCouleurPointer) 
	{
		this.mCouleurPointer = mCouleurPointer;
	}
	public int getmPointerTaille() 
	{
		return mPointerTaille;
	}
	public void setmPointerTaille(int mPointerTaille) 
	{
		this.mPointerTaille = mPointerTaille;
	}
	public Color getmCouleurBackground() 
	{
		return mCouleurBackground;
	}
	
	public void setmCouleurBackground(Color mCouleurBackground) 
	{
		this.mCouleurBackground = mCouleurBackground;
	}
	
	public boolean isBgChanging() 
	{
		return bgChanging;
	}

	public void setBgChanging(boolean bgChanging) 
	{
		this.bgChanging = bgChanging;
	}

	public Color getmCouleurPoint() 
	{
		return mCouleurPoint;
	}

	public void setmCouleurPoint(Color mCouleurPoint) 
	{
		this.mCouleurPoint = mCouleurPoint;
	}
	
		
}
