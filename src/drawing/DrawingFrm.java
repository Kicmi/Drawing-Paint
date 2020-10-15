package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingFrm extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnl = new PnlDrawing();
	static Color edgeColor = Color.BLACK;
	static Color shapeColor = Color.WHITE;
	private Color edgeColorOne = Color.BLACK;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrm frame = new DrawingFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingFrm() {
		setResizable(true);
		setTitle("II53-2015 Mikic Vladimir; Drawing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		pnl.setBackground(Color.WHITE);
		pnl.setBorder(null);
		contentPane.add(pnl, BorderLayout.CENTER);
		
		JPanel pnlLeftButtons = new JPanel();
		contentPane.add(pnlLeftButtons, BorderLayout.WEST);
		
		JButton btnPoint = new JButton("Point");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.object=1;
				for (Shapes shapes : PnlDrawing.shapesarraylist) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.object=2;
				for (Shapes shapes : PnlDrawing.shapesarraylist) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.object=3;
				for (Shapes shapes : PnlDrawing.shapesarraylist) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.object=4;
				for (Shapes shapes : PnlDrawing.shapesarraylist) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnDonut = new JButton("Donut");
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.object=5;
				for (Shapes shapes : PnlDrawing.shapesarraylist) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnSelection = new JButton("Selection");
		btnSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesarraylist.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema objekata za selektovanje.", "OBAVESTENJE", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					PnlDrawing.object=6;
				}
			}
		});
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesarraylist.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema objekata za modifikaciju!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					return;
					}
					for (Shapes shapes : PnlDrawing.shapesarraylist) {
						if(shapes.isSelected()) {
							shapes.dialog();
						return;
						}
					}
					JOptionPane.showMessageDialog(null, "Pre modifikovanja morate selektovati objekat!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesarraylist.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema objekata za brisanje!","Obavestenje", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				for (Shapes shapes : PnlDrawing.shapesarraylist) {
					if(shapes.isSelected()) {
						int answer=JOptionPane.showConfirmDialog(null, "Da li zelite da izbrisete selektovani objekat?", "Upozorenje",JOptionPane.YES_NO_OPTION);
						if(answer==0) {
							PnlDrawing.shapesarraylist.remove(shapes);
						}
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Pre brisanja morate selektovati objekat!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JButton btnClr = new JButton("Body Color");
		btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shapeColor=JColorChooser.showDialog(null, "Color panel", edgeColorOne);
			}
		});
		
		JButton btnEdgeColor = new JButton("Edge Color");
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor=JColorChooser.showDialog(null, "Color panel", edgeColorOne);
			}
		});
		GroupLayout gl_pnlLeftButtons = new GroupLayout(pnlLeftButtons);
		gl_pnlLeftButtons.setHorizontalGroup(
			gl_pnlLeftButtons.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlLeftButtons.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlLeftButtons.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRectangle, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addGroup(gl_pnlLeftButtons.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnCircle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnDonut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSelection, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLine, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPoint, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnClr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnModify, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnRemove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btnEdgeColor))
					.addContainerGap())
		);
		gl_pnlLeftButtons.setVerticalGroup(
			gl_pnlLeftButtons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLeftButtons.createSequentialGroup()
					.addComponent(btnPoint)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRectangle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCircle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDonut)
					.addGap(8)
					.addComponent(btnSelection)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModify)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRemove)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClr)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEdgeColor)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		pnlLeftButtons.setLayout(gl_pnlLeftButtons);
	}
}
