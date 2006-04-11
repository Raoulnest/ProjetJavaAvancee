package ZoneDessin;

import java.awt.Color;

public class FormeGeo {
	
	
	protected double x,y,lastX,lastY;
	protected double width = 0, height =0;
	protected int strokeWidth = 2;
	public String typeForme;
	protected Color countourColor;
    protected Color insideColor;
    
	public FormeGeo(int x, int y, int taille, Color c, String typeForme) {
		this.x = x;
		this.y = y;
		this.strokeWidth = taille;
		this.countourColor = c;
		this.typeForme = typeForme;
	}
	public String getTypeForme() {
		return typeForme;
	}
	public void setTypeForme(String typeForme) {
		this.typeForme = typeForme;
	}
	public Color getCountourColor() {
		return countourColor;
	}
	public void setCountourColor(Color countourColor) {
		this.countourColor = countourColor;
	}
	public Color getInsideColor() {
		return insideColor;
	}
	public void setInsideColor(Color insideColor) {
		this.insideColor = insideColor;
	}
	public void setRefForme(String refForme) {
	        this.typeForme = (String) refForme;
	    }

	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getLastX() {
		return lastX;
	}
	public void setLastX(double lastX) {
		this.lastX = lastX;
	}
	public double getLastY() {
		return lastY;
	}
	public void setLastY(double lastY) {
		this.lastY = lastY;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getStrokeWidth() {
		return strokeWidth;
	}
	public void setStrokeWidth(int s) {
		this.strokeWidth=s;
	}
}
