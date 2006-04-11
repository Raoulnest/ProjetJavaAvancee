package ZoneDessin;

import java.awt.BasicStroke;
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
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ZoneDessin extends JPanel 
{
	private boolean bgChanging = false; 
	public int mPointerTaille =3;
	private String mFormeType="Styles";
	private Color mCouleurPointer = Color.black;
	private Color mCouleurBackground = Color.white;
	public Color mCouleurPoint =  Color.black;
	private int oldX,oldY;
	private Graphics2D g2;
	private Cursor curs = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
	private Image image;
	
	private JButton resize = new JButton();
	private int Xmove, Ymove, resizeX = -50, resizeY = -50;
	
	private ArrayList<FormeGeo> formeList = new ArrayList<FormeGeo>();
	private ArrayList<FormeGeo> formeListRedo = new ArrayList<FormeGeo>();
	FormeGeo forme;
	LigneBase d2,eraser;
	
	
	public ZoneDessin()
	{	
		
		 	this.setmCouleurPointer(Color.BLACK);
	        this.resize.setContentAreaFilled(false);
	        this.resize.setOpaque(true);
	        this.resize.setBackground(Color.RED);
	        add(resize);
	        this.resize.setLocation(-50, -50);
	        this.resize.setPreferredSize(new Dimension(5, 5));
	        //resizebut.setVisible(true);
	        this.resize.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
		
	        this.setPreferredSize(new Dimension(700, 512));
		//this.setBackground(Color.blue);
		this.addMouseMotionListener(new MouseMotionListener() 
		{
		 public void mouseMoved(MouseEvent souris) 
			{		
			 if (forme instanceof FormeGeo) {
                 if (forme.getTypeForme() == "Ligne") {
                     Rectangle2D lin = new Rectangle2D.Double(forme.getX(), forme.getY(), forme.getLastX() - forme.getX(), forme.getLastY() - forme.getY());
                     if (lin.contains(souris.getX(), souris.getY())) {
                         setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                     } else {
                         setCursor(curs);
                     }
                 } else {
                     Rectangle2D r = new Rectangle2D.Double(forme.getX(), forme.getY(), forme.getWidth(), forme.getHeight());
                     if (r.contains(souris.getX(), souris.getY())) {
                         setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                     } else {
                         setCursor(curs);
                     }
                 }
             }
			} 
		public void mouseDragged(MouseEvent e) 
			{
			
			if (getCursor().equals(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR))) {
                forme.setX(e.getXOnScreen() - Xmove);
                forme.setY(e.getYOnScreen() - Ymove);
                forme.setLastX(forme.getX() + forme.getHeight());
                forme.setLastY(forme.getY() + forme.getWidth());
                if (getmFormeType().equals("Ligne")) {
                    resizeX = (int) forme.getLastX();
                    resizeY = (int) forme.getLastY();
                } else {
                    resizeX = (int) (forme.getX() + forme.getWidth());
                    resizeY = (int) (forme.getY() + forme.getHeight());
                }
                resize.setLocation(resizeX, resizeY);
            }else
			switch (mFormeType) {
            case "Styles":
                d2.AddPoint(e.getX(), e.getY());
                break;
            case "Ligne":
            	if (forme != null) {
                    forme.setLastX(e.getX());
                    forme.setLastY(e.getY());
                }
                break;
            case "Rectangle":
            	if (forme != null) {
                    forme.setWidth(e.getX() - forme.getX());
                    forme.setHeight(e.getY() - forme.getY());
                }
                break;
            case "RectangleP":
            	if (forme != null) {
                    forme.setWidth(e.getX() - forme.getX());
                    forme.setHeight(e.getY() - forme.getY());
                }
                break;
			}
			
			/*
			if(getmFormeType().equals("Ligne")) {
				if (forme != null) {
                    forme.setLastX(e.getX());
                    forme.setLastY(e.getY());
                }
			}else if(getmFormeType().equals("Rectangle")) {
				
					if (forme != null) {
                        forme.setWidth(e.getX() - forme.getX());
                        forme.setHeight(e.getY() - forme.getY());
                    }
			} 
			
			 oldX = e.getX();
			 oldY = e.getY();	 
			 Graphics g = getGraphics ();
			   if(getmFormeType().equals("Style")){
				g.setColor( mCouleurPointer);
				g2.setColor( mCouleurPointer);
				g.fillOval(oldX, oldY, mPointerTaille, mPointerTaille);
				repaint();
				g2.fillOval(oldX, oldY, mPointerTaille, mPointerTaille);
				}*/
			repaint();
		}
		});	
		
		resize.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                resizeX = evt.getXOnScreen() - Xmove;
                resizeY = evt.getYOnScreen() - Ymove;
                resize.setLocation(resizeX, resizeY);
                if (forme instanceof FormeGeo) {
                    if (getmFormeType().equals("Ligne")) {
                        forme.setLastX(resize.getLocation().x);
                        forme.setLastY(resize.getLocation().y);
                    } else {
                        forme.setWidth(resize.getLocation().x - forme.getX());
                        forme.setHeight(resize.getLocation().y - forme.getY());
                    }repaint();
                }
                
            }

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
            
		});
		
		resize.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                Xmove = evt.getXOnScreen() - resize.getLocation().x;
                Ymove = evt.getYOnScreen() - resize.getLocation().y;
                resize.setLocation(Xmove, Ymove);
                if (forme instanceof FormeGeo) {
                    if (getmFormeType().equals("Ligne")) {
                        forme.setLastX(resize.getLocation().x);
                        forme.setLastY(resize.getLocation().y);
                    } else {
                        forme.setWidth(resize.getLocation().x - forme.getX());
                        forme.setHeight(resize.getLocation().y - forme.getY());
                    }
                }
                repaint();
            }
        });
		this.addMouseListener(new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e) 
			{	
				if (getCursor().equals(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR))) {
                    Xmove = e.getXOnScreen() - (int) forme.getX();
                    Ymove = e.getYOnScreen() - (int) forme.getY();
                    if (forme.getTypeForme()=="Ligne")
                    {
                        forme.setWidth(forme.getLastX() - forme.getX());
                        forme.setHeight(forme.getLastY() - forme.getY());
                    }
                }else {
                	 resizeX = -25;
                     resizeY = -25;
                     resize.setLocation(resizeX, resizeY);
                     switch(mFormeType) {
                     case "Styles":
                    	 d2 = new LigneBase(e.getX(), e.getY(), mPointerTaille, mCouleurPointer,mFormeType);
                         formeList.add(d2);
                         break;
                     case "Ligne":
                    	 forme = new FormeGeo(e.getX(),e.getY(),mPointerTaille,mCouleurPointer,mFormeType);
     					forme.setLastX(e.getX());
                         forme.setLastY(e.getY());
     					formeList.add(forme);
                         break;
                     case "Rectangle":
                    	 forme = new FormeGeo(e.getX(),e.getY(),mPointerTaille,mCouleurPointer,mFormeType);
                         formeList.add(forme);
                         break;
                     case "RectangleP":
                    	 forme = new FormeGeo(e.getX(),e.getY(),mPointerTaille,mCouleurPointer,mFormeType);
                         formeList.add(forme);
                         break;
                     default:break;
                     }
                     repaint();
     				formeListRedo.clear();
                }
               /* if(getmFormeType().equals("Styles")) {
                	d2 = new LigneBase(e.getX(), e.getY(), mPointerTaille, mCouleurPointer,mFormeType);
                    formeList.add(d2);
                }else
				
				if(getmFormeType().equals("Ligne")){
				    /*g.setColor( mCouleurPointer);
				    g2.setColor( mCouleurPointer);
					g.drawLine(x1.x, x1.y, x2.x, x2.y);
					g2.drawLine(x1.x, x1.y, x2.x, x2.y);
					d2 = new LigneBase(e.getX(), e.getY(),mPointerTaille,mCouleurPointer, mFormeType);
					formeList.add(d2);
					forme = new FormeGeo(e.getX(),e.getY(),mPointerTaille,mCouleurPointer,mFormeType);
					forme.setLastX(e.getX());
                    forme.setLastY(e.getY());
					formeList.add(forme);
					}
				else
					if(getmFormeType().equals("Rectangle")){
				   /* g.setColor( mCouleurPointer);
				    g2.setColor(mCouleurPointer);
				    int width = Math.abs(x2.x-x1.x);
					int height = Math.abs(x2.y-x1.y);
					g.drawRect(x1.x, x1.y, width, height);
					g2.drawRect(x1.x, x1.y, width, height);
					
						forme = new FormeGeo(e.getX(),e.getY(),mPointerTaille,mCouleurPointer,mFormeType);
                        formeList.add(forme);
				    }
				else 
					if(getmFormeType().equals("RectangleP")){
						/*g.setColor( mCouleurPointer);
						g2.setColor( mCouleurPointer);
						int width = Math.abs(x2.x-x1.x);
						int height = Math.abs(x2.y-x1.y);
						g.fillRect(x1.x, x1.y, width, height);
						g2.fillRect(x1.x, x1.y, width, height);
						
						forme = new FormeGeo(e.getX(),e.getY(),mPointerTaille,mCouleurPointer,mFormeType);
                        formeList.add(forme);
				    }
				repaint();
				formeListRedo.clear();
				
                */
			}
			public void mouseReleased(MouseEvent e) 
		    {
				
					//x2.setLocation(e.getX(), e.getY());
					//repaint();
					Graphics g = getGraphics ();
				
				if (getCursor().equals(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR))) {

                } else {
                    if (forme instanceof FormeGeo) {
                        resize.setLocation(e.getX(), e.getY());
                    }
                    resizeX = e.getX();
                    resizeY = e.getY();
                }                     
						/*if(getmFormeType().equals("Ligne")){
					    g.setColor( mCouleurPointer);
					    g2.setColor( mCouleurPointer);
						g.drawLine(x1.x, x1.y, x2.x, x2.y);
						g2.drawLine(x1.x, x1.y, x2.x, x2.y);
						d2 = new LigneBase(e.getX(), e.getY(),mPointerTaille,mCouleurPointer, mFormeType);
						formeList.add(d2);
						}
					else
						if(getmFormeType().equals("Rectangle")){
					   /* g.setColor( mCouleurPointer);
					    g2.setColor(mCouleurPointer);
					    int width = Math.abs(x2.x-x1.x);
						int height = Math.abs(x2.y-x1.y);
						g.drawRect(x1.x, x1.y, width, height);
						g2.drawRect(x1.x, x1.y, width, height);
						
						forme = new FormeGeo(e.getX(),e.getY(),mPointerTaille,mCouleurPointer,mFormeType);
						forme.setLastX(e.getX());
                        forme.setLastY(e.getY());
						formeList.add(forme);
					    }
					else 
						if(getmFormeType().equals("RectangleP")){
							/*g.setColor( mCouleurPointer);
							g2.setColor( mCouleurPointer);
							int width = Math.abs(x2.x-x1.x);
							int height = Math.abs(x2.y-x1.y);
							g.fillRect(x1.x, x1.y, width, height);
							g2.fillRect(x1.x, x1.y, width, height);
							
							
							forme = new FormeGeo(e.getX(),e.getY(),mPointerTaille,mCouleurPointer,mFormeType);
							forme.setLastX(e.getX());
	                        forme.setLastY(e.getY());
							formeList.add(forme);
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
						}*/	
     		}
		});		
	}

	protected void paintComponent(Graphics graph) 
	{	
		 Graphics2D graph2 = (Graphics2D) graph;
	        graph2.setColor(Color.WHITE);
	        graph2.fillRect(0, 0, this.getWidth(), this.getHeight());
	        if(image!=null){
	            graph.drawImage(image, 0, 0, null);
	        }			
			 for(FormeGeo list: formeList ) {
            graph2.setColor(getmCouleurPointer());
            graph2.setStroke(new BasicStroke(list.getStrokeWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
          switch(list.typeForme) {
          case "Styles":
              LigneBase tsipika = (LigneBase) list;
              for (Line2D l : tsipika.getMikajTsipika()) {
                  graph2.draw(l);
              }
              break;
          case "Ligne":
        	  Line2D ligne2d = new Line2D.Double(list.getX(), list.getY(), list.getLastX(), list.getLastY());
              graph2.draw(ligne2d);
              break;
          case "Rectangle":
        	  Rectangle2D rectangle = new Rectangle2D.Double(list.getX(), list.getY(), list.getWidth(), list.getHeight());
              graph2.setStroke(new BasicStroke(list.getStrokeWidth(), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
              
				graph2.setPaint(list.countourColor);
				graph2.draw(rectangle);
				
                  
              break;
          case "RectangleP":
        	  Rectangle2D rectangleP = new Rectangle2D.Double(list.getX(), list.getY(), list.getWidth(), list.getHeight());
              graph2.setStroke(new BasicStroke(list.getStrokeWidth(), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
              
              graph2.setPaint(list.getInsideColor());
                  graph2.fill(rectangleP);
              break;
          
          }/*
            if(getmFormeType().equals("Ligne")){
				Line2D ligne2d = new Line2D.Double(list.getX(), list.getY(), list.getLastX(), list.getLastY());
                graph2.draw(ligne2d);
				
			}else if(getmFormeType().equals("Rectangle")){
				Rectangle2D rectangle = new Rectangle2D.Double(list.getX(), list.getY(), list.getWidth(), list.getHeight());
                graph2.setStroke(new BasicStroke(list.getStrokeWidth(), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
                
				graph2.setPaint(list.countourColor);
                graph2.draw(rectangle);
				
				}*/
			 }
			 resize.setLocation(resizeX, resizeY);
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
	public ArrayList<FormeGeo> getFormeList() {
		return formeList;
	}
	public void setFormeList(ArrayList<FormeGeo> formeList) {
		this.formeList = formeList;
	}
	public ArrayList<FormeGeo> getFormeListRedo() {
		return formeListRedo;
	}
	public void setFormeListRedo(ArrayList<FormeGeo> formeListRedo) {
		this.formeListRedo = formeListRedo;
	}
	public int getOldX() {
		return oldX;
	}
	public void setOldX(int oldX) {
		this.oldX = oldX;
	}
	public int getOldY() {
		return oldY;
	}
	public void setOldY(int oldY) {
		this.oldY = oldY;
	}
	public Graphics2D getG2() {
		return g2;
	}
	public void setG2(Graphics2D g2) {
		this.g2 = g2;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Point getX1() {
		return x1;
	}
	public void setX1(Point x1) {
		this.x1 = x1;
	}
	public Point getX2() {
		return x2;
	}
	public void setX2(Point x2) {
		this.x2 = x2;
	}
	public Color getmCouleurPointer() {
		return mCouleurPointer;
	}		
}
