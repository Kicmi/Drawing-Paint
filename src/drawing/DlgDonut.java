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

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOkay;
	private JButton cancelButton;
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private JTextField txtRadius;
	private JTextField txtInnerRadius;
	boolean isOk;
	private int donX,donY,rad,innRad;
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
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNewLabel = new JLabel("X coord center:");
		JLabel lblYCoordCenter = new JLabel("Y coord center:");
		JLabel lblRadius = new JLabel("Radius:");
		JLabel lblInnerRadius = new JLabel("Inner radius:");
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
		txtInnerRadius = new JTextField();
		txtInnerRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtInnerRadius.setColumns(10);
		JButton btnEdgeColor = new JButton("Edge color switch");
		btnEdgeColor.addActionListener(new ActionListener() {
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
					.addGap(25)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblYCoordCenter)
						.addComponent(lblRadius)
						.addComponent(lblInnerRadius))
					.addGap(76)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAreaColorSwitch))
							.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
								.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(35)
								.addComponent(btnEdgeColor))))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYCoordCenter)
								.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRadius)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblInnerRadius)
								.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(50)
							.addComponent(btnEdgeColor)
							.addGap(50)
							.addComponent(btnAreaColorSwitch)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOkay = new JButton("Okay");
				btnOkay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXCoord.getText().trim().isEmpty()||txtYCoord.getText().trim().isEmpty()||txtRadius.getText().trim().isEmpty()||txtInnerRadius.getText().trim().isEmpty()) {
							isOk=false;
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						} else {
							if(Integer.parseInt(txtRadius.getText())>Integer.parseInt(txtInnerRadius.getText())) {
							donX = Integer.parseInt(txtXCoord.getText());
							donY = Integer.parseInt(txtYCoord.getText());
							rad = Integer.parseInt(txtRadius.getText());
							innRad = Integer.parseInt(txtInnerRadius.getText());
							for (Shapes shapes : PnlDrawing.shapesarraylist) {
								if(shapes.isSelected()) {
									shapes.move(donX, donY);
									if(isEdgeColorB()==true) {
										shapes.setEdgeColor(edgeColor);
										setEdgeColorB(false);
									}
									if(isShapeColorB()==true) {
										shapes.setShapeColor(shapeColor);
										setShapeColorB(false);
									}
									if(shapes instanceof Donut) {
										((Donut) shapes).setRadius(rad);
										((Donut) shapes).setInnerRadius(innRad);
									}
								}
							}
							
							isOk=true;
							dispose();
							} else {
								isOk=false;
								JOptionPane.showMessageDialog(null, "Spoljasnji poluprecnik mora biti veci od unutrasnjeg poluprecnika!", "Greska", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				});
				btnOkay.setActionCommand("OK");
				getRootPane().setDefaultButton(btnOkay);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(43)
						.addComponent(btnOkay)
						.addGap(220)
						.addComponent(cancelButton)
						.addGap(54))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnOkay)
							.addComponent(cancelButton)))
			);
			buttonPane.setLayout(gl_buttonPane);
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

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
	}

	public int getDonX() {
		return donX;
	}

	public void setDonX(int donX) {
		this.donX = donX;
	}

	public int getDonY() {
		return donY;
	}

	public void setDonY(int donY) {
		this.donY = donY;
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	public int getInnRad() {
		return innRad;
	}

	public void setInnRad(int innRad) {
		this.innRad = innRad;
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
