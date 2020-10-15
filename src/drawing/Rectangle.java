package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shapes { 
	private Point upperLeftPoint;
	private int width;
	private int height;
	private boolean selected;
	

	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint= upperLeftPoint;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected ) {
		this(upperLeftPoint, width, height);
	    this.selected = selected;
	}

	public int area() {
		return width*height;
	}
	
	
	
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return (int)(this.area()-((Rectangle)o).area());
		}
		return 0;
	}
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String toString() {
		return " ( " + upperLeftPoint + " , " + width + " , " + height + " , " + selected + " ) ";
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getEdgeColor());
		g.drawRect(this.getUpperLeftPoint().getX(), this.getUpperLeftPoint().getY(), this.getWidth(), this.getHeight());
		if(isSelected()==true) {
			g.setColor(Color.BLACK);
			g.drawRect(this.getUpperLeftPoint().getX() - 3, this.getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() + this.getWidth() - 3, this.getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() - 3, this.getUpperLeftPoint().getY() + this.getHeight() - 3, 6 , 6);
			g.drawRect(this.getUpperLeftPoint().getX() + this.getWidth() - 3, this.getUpperLeftPoint().getY() + this.getHeight() - 3, 6, 6);
		}
		
	}

	@Override
	public boolean contains(int x, int y) {
		if(this.getUpperLeftPoint().getX() <= x && 
			(this.getUpperLeftPoint().getX() + this.getWidth() >= x) &&
		  (this.getUpperLeftPoint().getY() <= y) &&
			(this.getUpperLeftPoint().getY() + this.getHeight() >= y)) {
				return true;
			} else {
				return false;
		}
	}

	@Override
	public void dialog() {
		DlgRectangle drwdlgRect = new DlgRectangle();
		for (Shapes shapes : PnlDrawing.shapesarraylist) {
			if(shapes.isSelected()) {
				String[] split=shapes.toString().split(" ");
				drwdlgRect.getTxtXCoord().setText(split[4]);
				drwdlgRect.getTxtYCoord().setText(split[6]);
				drwdlgRect.getTxtWidth().setText(split[12]);
				drwdlgRect.getTxtHeight().setText(split[14]);
			}
		}
		drwdlgRect.setVisible(true);
	}

	@Override
	public void move(int newX, int newY) {
		
		
	}

	@Override
	public void shapeColor(Graphics g) {
		g.setColor(getShapeColor()); 
		g.fillRect(this.getUpperLeftPoint().getX()+1, this.getUpperLeftPoint().getY()+1, this.getWidth()-1, this.getHeight()-1);
		
	}
	
}
