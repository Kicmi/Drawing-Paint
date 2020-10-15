package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Shape;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPoint extends JDialog {

	private final JPanel PnlCenter = new JPanel();
	private JButton btnOkay;
	private JButton btnCancel;
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private int xMovePoint, yMovePoint;
	private Color edgeColor = Color.BLACK;
	private Color edgeColorOne = Color.BLACK;
	boolean edgeColorB;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		PnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(PnlCenter, BorderLayout.CENTER);
		
		JLabel lblXCoord = new JLabel("X coord:");
		
		JLabel lblYCoord = new JLabel("Y coord:");
		
		txtXCoord = new JTextField();
		txtXCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				char c = e.getKeyChar(); 
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXCoord.setColumns(10);
		
		txtYCoord = new JTextField();
		txtYCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtYCoord.setColumns(10);
		
		JButton btnColorSwitch = new JButton("Color switch");
		btnColorSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Color panel", edgeColorOne);
				edgeColorB = true;
			}
		});
		GroupLayout gl_PnlCenter = new GroupLayout(PnlCenter);
		gl_PnlCenter.setHorizontalGroup(
			gl_PnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PnlCenter.createSequentialGroup()
					.addGroup(gl_PnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_PnlCenter.createSequentialGroup()
							.addGap(52)
							.addGroup(gl_PnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblXCoord)
								.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(62)
							.addGroup(gl_PnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblYCoord)))
						.addGroup(gl_PnlCenter.createSequentialGroup()
							.addGap(125)
							.addComponent(btnColorSwitch)))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		gl_PnlCenter.setVerticalGroup(
			gl_PnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PnlCenter.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoord)
						.addComponent(lblYCoord))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(btnColorSwitch)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		PnlCenter.setLayout(gl_PnlCenter);
		{
			JPanel PnlDole = new JPanel();
			getContentPane().add(PnlDole, BorderLayout.SOUTH);
			{
				btnOkay = new JButton("Okay");
				btnOkay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXCoord.getText().trim().isEmpty()|| txtYCoord.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena!", "Greska", JOptionPane.ERROR_MESSAGE);
						dispose();
						} else {
							xMovePoint=Integer.parseInt(txtXCoord.getText());
							yMovePoint=Integer.parseInt(txtYCoord.getText());
							for (Shapes shapes : PnlDrawing.shapesarraylist) {
								if(shapes.isSelected()) {
									shapes.move(xMovePoint, yMovePoint);
									if(edgeColorB==true) {
										shapes.setEdgeColor(edgeColor);
										edgeColorB=false;
									}
								}
							}
							dispose();
							return;
						}
					}
				});
				btnOkay.setActionCommand("OK");
				getRootPane().setDefaultButton(btnOkay);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
			}
			GroupLayout gl_PnlDole = new GroupLayout(PnlDole);
			gl_PnlDole.setHorizontalGroup(
				gl_PnlDole.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlDole.createSequentialGroup()
						.addGap(123)
						.addComponent(btnOkay)
						.addGap(51)
						.addComponent(btnCancel)
						.addGap(148))
			);
			gl_PnlDole.setVerticalGroup(
				gl_PnlDole.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlDole.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_PnlDole.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCancel)
							.addComponent(btnOkay))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			PnlDole.setLayout(gl_PnlDole);
		}
	}

	public JTextField getTxtXCoord() {
		return txtXCoord;
	}

	public void setTxtXCoord(JTextField txtXCoord) {
		this.txtXCoord = txtXCoord;
	}

	public JTextField getTxtYCoord() {
		return txtYCoord;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.txtYCoord = txtYCoord;
	}

	public int getxMovePoint() {
		return xMovePoint;
	}

	public void setxMovePoint(int xMovePoint) {
		this.xMovePoint = xMovePoint;
	}

	public int getyMovePoint() {
		return yMovePoint;
	}

	public void setyMovePoint(int yMovePoint) {
		this.yMovePoint = yMovePoint;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}
}
