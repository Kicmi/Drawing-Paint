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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOkay;
	private JButton btnCancel;
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private int recX,recY,width,height;
	boolean isOk;
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
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblXCoord = new JLabel("X coord:");
		
		JLabel lblYCoord = new JLabel("Y coord:");
		
		JLabel lblWidth = new JLabel("Width:");
		
		JLabel lblHeight = new JLabel("Height:");
		
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
		
		txtWidth = new JTextField();
		txtWidth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtWidth.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtHeight.setColumns(10);
		
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
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblXCoord)
							.addGap(18)
							.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYCoord)
								.addComponent(lblWidth)
								.addComponent(lblHeight))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(79)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAreaColorSwitch)
						.addComponent(btnEdgeColorSwitch))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoord)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEdgeColorSwitch))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoord)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAreaColorSwitch))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty() || txtWidth.getText().trim().isEmpty() || txtHeight.getText().trim().isEmpty()) {
							
							isOk=false;
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
							dispose();
						} else {
							recX=Integer.parseInt(txtXCoord.getText());
							recY=Integer.parseInt(txtYCoord.getText());
							width=Integer.parseInt(txtWidth.getText());
							height=Integer.parseInt(txtHeight.getText());
							for (Shapes shapes : PnlDrawing.shapesarraylist) {
								if(shapes.isSelected()) {
									shapes.move(recX, recY);
									if(isEdgeColorB()==true) {
										shapes.setEdgeColor(edgeColor);
										setEdgeColorB(false);
									}
									if(isShapeColorB()==true) {
										shapes.setShapeColor(shapeColor);
										setShapeColorB(false);
									}
									if(shapes instanceof Rectangle) {
										((Rectangle)shapes).setWidth(width);
										((Rectangle)shapes).setHeight(height);
									}
								}
							}
							isOk=true;
							dispose();
						}
					}
					
				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
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

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
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
