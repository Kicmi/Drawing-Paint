package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

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

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOkay;
	private JButton btnCancel;
	private JTextField txtXCenter;
	private JTextField txtYCenter;
	private JTextField txtRadius;
	boolean isOk;
	private int cirX,cirY,rad;
	private Color edgeColor = Color.BLACK;
	private Color shapeColor = Color.WHITE;
	private Color edgeColorOne = Color.BLACK;
	private boolean edgeColorB;
	private boolean shapeColorB;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblXCenter = new JLabel("X coord center:");
		JLabel lblYCoordCenter = new JLabel("Y Coord center:");
		JLabel lblRadius = new JLabel("Radius:");
		txtXCenter = new JTextField();
		txtXCenter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXCenter.setColumns(10);
		txtYCenter = new JTextField();
		txtYCenter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) { 
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtYCenter.setColumns(10);
		txtRadius = new JTextField();
		txtRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) { 
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtRadius.setColumns(10);
		JButton btnEdgeColorSwitch = new JButton("Edge color switch");
		btnEdgeColorSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor=JColorChooser.showDialog(null, "Color panel", edgeColorOne);
				setEdgeColorB(true);
			}
		});
		JButton btnAreaColorSwitch = new JButton("Area color switch");
		btnAreaColorSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shapeColor=JColorChooser.showDialog(null, "Color panel", edgeColorOne);
				setShapeColorB(true);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblXCenter)
						.addComponent(lblYCoordCenter)
						.addComponent(lblRadius))
					.addGap(60)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(txtYCenter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtXCenter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEdgeColorSwitch)
						.addComponent(btnAreaColorSwitch))
					.addGap(22))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblXCenter)
								.addComponent(txtXCenter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYCoordCenter)
								.addComponent(txtYCenter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRadius)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(49)
							.addComponent(btnEdgeColorSwitch)
							.addGap(18)
							.addComponent(btnAreaColorSwitch)))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOkay = new JButton("Okay");
				btnOkay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXCenter.getText().trim().isEmpty() || txtYCenter.getText().trim().isEmpty() || txtRadius.getText().trim().isEmpty()) {
							isOk=false;
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						} else {
							cirX = Integer.parseInt(txtXCenter.getText());
							cirY = Integer.parseInt(txtYCenter.getText());
							rad = Integer.parseInt(txtRadius.getText());
							for (Shapes shapes : PnlDrawing.shapesarraylist) {
								if(shapes.isSelected()) {
									shapes.move(cirX, cirY);
									if(isEdgeColorB()==true) {
										shapes.setEdgeColor(edgeColor);
										setEdgeColorB(false);
									}
									if(isShapeColorB()==true) {
										shapes.setShapeColor(shapeColor);
										setShapeColorB(false);
									}
									if(shapes instanceof Circle) {
										((Circle) shapes).setRadius(rad);
									}
								}
							}
							isOk=true;
							dispose();
						}
					}
				});
				btnOkay.setActionCommand("OK");
				getRootPane().setDefaultButton(btnOkay);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(66)
						.addComponent(btnOkay)
						.addGap(206)
						.addComponent(btnCancel)
						.addGap(50))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnOkay)
							.addComponent(btnCancel)))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	public JTextField getTxtXCenter() {
		return txtXCenter;
	}

	public void setTxtXCenter(JTextField txtXCenter) {
		this.txtXCenter = txtXCenter;
	}

	public JTextField getTxtYCenter() {
		return txtYCenter;
	}

	public void setTxtYCenter(JTextField txtYCenter) {
		this.txtYCenter = txtYCenter;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public int getCirX() {
		return cirX;
	}

	public void setCirX(int cirX) {
		this.cirX = cirX;
	}

	public int getCirY() {
		return cirY;
	}

	public void setCirY(int cirY) {
		this.cirY = cirY;
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

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

	public boolean isEdgeColorB() {
		return edgeColorB;
	}

	public void setEdgeColorB(boolean edgeColorB) {
		this.edgeColorB = edgeColorB;
	}

	public boolean isShapeColorB() {
		return shapeColorB;
	}

	public void setShapeColorB(boolean shapeColorB) {
		this.shapeColorB = shapeColorB;
	}

}
