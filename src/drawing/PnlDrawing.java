package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class PnlDrawing extends JPanel implements MouseListener { 
	

	static int object = 0; 
	int mousex, mousey, width, height, radius, innerradius, radiusdonut, startlinex, startliney, endlinex, endliney, click=1; 
	boolean pointtrue, linestarttrue, lineendtrue, recttrue, circletrue, donuttrue; 
	static ArrayList <Shapes> shapesarraylist= new ArrayList<Shapes>(); 
	private Color out = Color.BLACK;		
	private Color fill = Color.BLACK;
	
	public PnlDrawing() {
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mousex=e.getX();
		mousey=e.getY();
		
		switch(object) {
		case 1:
			pointtrue=true;
			out=DrawingFrm.edgeColor;
			break;
			
		case 2:
			if(click%2==0) {
				startlinex=e.getX();
				startliney=e.getY();
				linestarttrue=true;
			} else {
				endlinex=e.getX();
				endliney=e.getY();
				out=DrawingFrm.edgeColor;
				lineendtrue=true;
			} break;
			
		case 3:
			DlgRectangle dlgRect= new DlgRectangle();
			dlgRect.getTxtXCoord().setText(String.valueOf(mousex));
			dlgRect.getTxtYCoord().setText(String.valueOf(mousey));
			dlgRect.getTxtXCoord().setEditable(false);
			dlgRect.getTxtYCoord().setEditable(false);
			dlgRect.setVisible(true);
			if(dlgRect.isOk==true) {
				width=Integer.parseInt(dlgRect.getTxtWidth().getText());
				height=Integer.parseInt(dlgRect.getTxtHeight().getText());
				fill=dlgRect.getShapeColor();
				out=dlgRect.getEdgeColor();
				if((dlgRect.isEdgeColorB()==false)&&(dlgRect.isShapeColorB()==false)) {
					out=DrawingFrm.edgeColor;
					fill=DrawingFrm.shapeColor;
				}
				recttrue=true;
			} break;
			
		case 4:
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.getTxtXCenter().setText(String.valueOf(mousex));
			dlgCircle.getTxtYCenter().setText(String.valueOf(mousey));
			dlgCircle.getTxtXCenter().setEditable(false);
			dlgCircle.getTxtYCenter().setEditable(false);
			dlgCircle.setVisible(true);
		    if(dlgCircle.isOk==true) {
		    	radius=Integer.parseInt(dlgCircle.getTxtRadius().getText());
		    	fill=dlgCircle.getShapeColor();
		    	out=dlgCircle.getEdgeColor();
		    	if((dlgCircle.isEdgeColorB()==false)&&(dlgCircle.isEdgeColorB()==false)){
		    		out=DrawingFrm.edgeColor;
					fill=DrawingFrm.shapeColor;
		    	}
		    	circletrue=true;
		    } break;
		 
		case 5:
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.getTxtXCoord().setText(String.valueOf(mousex));
			dlgDonut.getTxtYCoord().setText(String.valueOf(mousey));
			dlgDonut.getTxtXCoord().setEditable(false);
			dlgDonut.getTxtYCoord().setEditable(false);
			dlgDonut.setVisible(true);
			if(dlgDonut.isOk==true) {
				radiusdonut=Integer.parseInt(dlgDonut.getTxtRadius().getText());
				innerradius=Integer.parseInt(dlgDonut.getTxtInnerRadius().getText());
				fill=dlgDonut.getShapeColor();
				out=dlgDonut.getEdgeColor();
				if((dlgDonut.isEdgeColorB()==false)&&(dlgDonut.isEdgeColorB()==false)){
		    		out=DrawingFrm.edgeColor;
					fill=DrawingFrm.shapeColor;
		    	}
				donuttrue=true;
			} break;
		
		case 6:
			boolean matchFound=false;
			Collections.reverse(shapesarraylist);
			for (Shapes shapes : shapesarraylist) {
					shapes.setSelected(false);
				if(matchFound==false) {
					if(shapes.contains(mousex, mousey)) {
					shapes.setSelected(true);
					matchFound=true;
					}
				}
			}
			Collections.reverse(shapesarraylist);
			break;
		}	
		
	} 

	public void paint(Graphics g) {
		super.paint(g);
		switch(object){
			case 1:
				if(pointtrue==true) {
					Point p = new Point(mousex, mousey, false);
					p.setEdgeColor(out);
					shapesarraylist.add(p);
					System.out.println(shapesarraylist);
					pointtrue=false;
				} 
				break;
				
			case 2:
				if(linestarttrue==true && lineendtrue==true) {
					Line l = new Line(new Point(startlinex,startliney), new Point(endlinex,endliney), false);
					l.setEdgeColor(out);
					shapesarraylist.add(l);
					System.out.println(shapesarraylist);
					linestarttrue=false;
					lineendtrue=false;
				}break;
			
			case 3:
				if(recttrue==true) {
					Rectangle r = new Rectangle(new Point(mousex, mousey), width, height, false);
					r.setEdgeColor(out);
					r.setShapeColor(fill);
					shapesarraylist.add(r);
					System.out.println(shapesarraylist);
					recttrue=false;
				}break;
			
			case 4:
				if(circletrue==true) {
					Circle c = new Circle(new Point(mousex,  mousey), radius, false);
					c.setEdgeColor(out);
					c.setShapeColor(fill);
					shapesarraylist.add(c);
					System.out.println(shapesarraylist);
					circletrue=false;
				} break;
			case 5:
				if(donuttrue==true) {
					Donut d = new Donut(new Point(mousex, mousey), radiusdonut, innerradius, false);
					d.setEdgeColor(out);
					d.setShapeColor(fill);
					shapesarraylist.add(d);
					System.out.println(shapesarraylist);
					donuttrue=false;
				} break;
		}	
		for (Shapes shapes : shapesarraylist) {
			shapes.shapeColor(g);
			shapes.draw(g);
		}
		
		
		repaint();
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {	
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
		switch (object) {
		case 2:
			click++;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}

}
