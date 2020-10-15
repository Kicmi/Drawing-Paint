package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shapes {
	private Point start;
	private Point end;
	private boolean selected;
	
	public Line() {
		
	}
	
	public Line(Point start,Point end) {
		this.start=start;
		this.end=end;
	}
	
	public Line(Point start, Point end, boolean selected) {
		this(start,end);
		this.selected=selected;
	}
	
	public Point middleOfLine () {
		int middleByX = (this.getStart().getX() + this.getEnd().getX())/2;
		int middleByY = (this.getStart().getY() + this.getEnd().getY())/2;
		Point p = new Point (middleByX, middleByY);
		return p;
	}
	
	public Point getStart() {
		return start;
	}
	
	public void setStart(Point start) {
		this.start=start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String toString () {
		return "( " + start + ", " + end + ", " + selected + ")";
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getEdgeColor());
		g.drawLine(this.getStart().getX(), this.getStart().getY(), this.getEnd().getX(), this.getEnd().getY());
		if (isSelected()==true) {
			g.setColor(Color.BLACK);
			g.drawRect(this.getStart().getX() - 3, this.getStart().getY() - 3, 6, 6);
			g.drawRect(this.getEnd().getX() - 3, this.getEnd().getY() - 3, 6, 6);
			g.drawRect(this.middleOfLine().getX() - 3, this.middleOfLine().getY() - 3, 6, 6);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		if ((start.distance(x, y)+ end.distance(x, y)) - length()<=0.05) {
			return true;
		} else return false;
	}
	
	public double length() {
		return start.distance(end.getX(), end.getY()); 
	}

	
	@Override
	public void dialog() {
		DlgLine drwdlgLine = new DlgLine();
		for (Shapes shapes : PnlDrawing.shapesarraylist) {
			if(shapes.isSelected()) {
				String[] split=shapes.toString().split(" ");
				drwdlgLine.getTxtXStart().setText(split[3]);
				drwdlgLine.getTxtYStart().setText(split[5]);
				drwdlgLine.getTxtXEnd().setText(split[12]);
				drwdlgLine.getTextYEnd().setText(split[14]);
			}
		}
		drwdlgLine.setVisible(true);
		
	}

	@Override
	public void move(int newX, int newY) {
		
		
	}

	@Override
	public void shapeColor(Graphics g) {
		
		
	}
	
	
}
