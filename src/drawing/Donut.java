package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius); 
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this (center, radius, innerRadius);
		this.selected = selected;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString () {
		return super.toString() + " , innerRadius= " + innerRadius +  " " + isSelected();
	}
	
	public void draw(Graphics g) {
		g.setColor(getEdgeColor());
		super.draw(g); 
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.getInnerRadius()*2);
		
	}
	
	public boolean contains(int x, int y) {
		double dFromDistance = this.getCenter().distance(x, y);
		return super.contains(x, y) && dFromDistance>innerRadius;
	}
	
	public void dialog() {
		DlgDonut drwdlgDonut=new DlgDonut();
		for (Shapes shapes : PnlDrawing.shapesarraylist) {
			if(shapes.isSelected()) {
				String[] split=shapes.toString().split(" ");
				drwdlgDonut.getTxtXCoord().setText(split[2]);
				drwdlgDonut.getTxtYCoord().setText(split[4]);
				drwdlgDonut.getTxtRadius().setText(split[9]);
				drwdlgDonut.getTxtInnerRadius().setText(split[14]);
			}
		}
		drwdlgDonut.setVisible(true);
	}
	
	public void shapeColor (Graphics g) {
		super.shapeColor(g);
		g.setColor(getShapeColor());
		g.drawOval(this.getCenter().getX()-this.getInnerRadius(), this.getCenter().getY()-this.getInnerRadius(), this.getInnerRadius()*2, this.getInnerRadius()*2);
		g.setColor(Color.WHITE);
		g.fillOval(this.getCenter().getX()-this.getInnerRadius(), this.getCenter().getY()-this.getInnerRadius(), this.getInnerRadius()*2, this.getInnerRadius()*2);
	}
	
}

