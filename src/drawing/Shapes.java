package drawing;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shapes implements Comparable, Moveable{ 
						
	private boolean selected;
	private Color edgeColor = Color.BLACK;
	private Color shapeColor = Color.WHITE;
	
	public Shapes() {
		
	}
	
	public Shapes(boolean selected) {
		this.selected = selected;
	}

	public abstract void draw (Graphics g);
	public abstract void shapeColor (Graphics g);
	
	public abstract boolean contains (int x, int y); 
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public abstract void dialog();

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Color getShapeColor() {
		return shapeColor;
	}

	public void setShapeColor(Color shapeColor) {
		this.shapeColor = shapeColor;
	}
}
