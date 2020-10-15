package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shapes {
	private Point center;
	private int radius;
	boolean selected;


	public Circle () {
		
	}
	
	
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}



	public Circle(Point center, int radius, boolean selected) {
		this(center,radius);
		this.selected = selected;
	}


	public Point getCenter() {
		return center;
	}


	public void setCenter(Point center) {
		this.center = center;
	}


	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}


	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String toString() {
		return "(" + center + ", " + radius + " , " + selected + ")";
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}



	@Override
	public void draw(Graphics g) {
		g.setColor(getEdgeColor());
		g.drawOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), this.getRadius()*2, this.getRadius()*2);
		if(isSelected()==true) {
			g.setColor(Color.BLACK);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - this.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
		}
		
	}



	@Override
	public boolean contains(int x, int y) {
		return this.getCenter().distance(x, y) <= this.getRadius();
	}



	@Override
	public void dialog() {
		DlgCircle drwdlgCircle=new DlgCircle();
		for (Shapes shapes : PnlDrawing.shapesarraylist) {
			if(shapes.isSelected()) {
				String[] split=shapes.toString().split(" ");
				drwdlgCircle.getTxtXCenter().setText(split[2]);
				drwdlgCircle.getTxtYCenter().setText(split[4]);
				drwdlgCircle.getTxtRadius().setText(split[9]);
			}
		}
		drwdlgCircle.setVisible(true);
	}



	@Override
	public void move(int newX, int newY) {
		center.move(newX, newY);
	}



	@Override
	public void shapeColor(Graphics g) {
		g.setColor(getShapeColor());
		g.fillOval(this.getCenter().getX()-this.getRadius(), this.getCenter().getY()-this.getRadius(), this.getRadius()*2, this.getRadius()*2);
		
	}
}
	
