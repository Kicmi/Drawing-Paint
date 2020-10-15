package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shapes {
	private int x;
	private int y;
	private boolean selected;
	
	public Point() {
		
	}
	
	public Point (int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	
	public Point (int x, int y, boolean selected) {
		this(x,y);
		this.selected = selected;
	}
	
	
	public int getX() {
		return x;
	}
	
	
	public void setX(int x) { 
		this.x= x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isSelected() { 
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String toString() {
		return " ( " + x + " , " + y + " , " + isSelected() + " ) ";
	}

	@Override
	public int compareTo(Object o) { 
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getEdgeColor());
		g.drawLine(this.getX()-2, this.getY(), this.getX()+2, this.getY()); 
		g.drawLine(this.getX(), this.getY()-2, this.getX(), this.getY()+2);
		if (isSelected()==true) {
			g.setColor(Color.BLACK);
			g.drawRect(this.getX()-3, this.getY()-3, 6, 6);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		if(this.distance(x, y)<=3) {
			return true;
		}
		else return false;
	}
	
	public double distance(int x2, int y2) {
		double dx=this.x-x2;
		double dy=this.y-y2;
		double d = Math.sqrt(dx*dx+dy*dy);
		return d;
	}

	@Override
	public void dialog() {
		DlgPoint drwdlgPoint = new DlgPoint();
		for (Shapes shapes : PnlDrawing.shapesarraylist) {
			if(shapes.isSelected()) {
				String[] split=shapes.toString().split(" ");
				drwdlgPoint.getTxtXCoord().setText(split[2]);
				drwdlgPoint.getTxtYCoord().setText(split[4]);
			}
		}
		drwdlgPoint.setVisible(true);
			}

	@Override
	public void move(int newX, int newY) {
		this.x=newX;
		this.y=newY;
	}

	@Override
	public void shapeColor(Graphics g) {
		
		
	}
}
	
	

