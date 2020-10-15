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

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOkay;
	private JButton btnCancel;
	private JTextField txtXStart;
	private JTextField txtYStart;
	private JTextField txtXEnd;
	private JTextField textYEnd;
	private int startX,startY,endX,endY;
	private Color edgeColor = Color.BLACK;
	private Color edgeColorOne = Color.BLACK;
	boolean edgeColorB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblXCoordStarting = new JLabel("X coord starting point:");
		
		JLabel lblYCoordStarting = new JLabel("Y coord starting point:");
		
		JLabel lblXCoordEnding = new JLabel("X Coord ending point:");
		
		JLabel lblYCoordEnding = new JLabel("Y Coord ending point:");
		
		txtXStart = new JTextField();
		txtXStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXStart.setColumns(10);
		
		txtYStart = new JTextField();
		txtYStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtYStart.setColumns(10);
		
		txtXEnd = new JTextField();
		txtXEnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) { 
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXEnd.setColumns(10);
		
		textYEnd = new JTextField();
		textYEnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); 
				if (!((c>='0') && (c<='9')) || (c==KeyEvent.VK_BACK_SPACE)) { 
					e.consume();
					getToolkit().beep();
				}
			}
		});
		textYEnd.setColumns(10);
		
		JButton btnColorSwitch = new JButton("Color switch:");
		btnColorSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Color panel", edgeColorOne);
				edgeColorB = true;
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblXCoordStarting)
						.addComponent(lblYCoordStarting)
						.addComponent(lblXCoordEnding)
						.addComponent(lblYCoordEnding))
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(textYEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtXEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnColorSwitch))
						.addComponent(txtXStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblXCoordStarting)
								.addComponent(txtXStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYCoordStarting)
								.addComponent(txtYStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblXCoordEnding)
								.addComponent(txtXEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYCoordEnding)
								.addComponent(textYEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(87)
							.addComponent(btnColorSwitch)))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOkay = new JButton("Okay");
				btnOkay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXStart.getText().trim().isEmpty()||txtXEnd.getText().trim().isEmpty()||txtYStart.getText().trim().isEmpty()||textYEnd.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena!", "Greska", JOptionPane.ERROR_MESSAGE);
						dispose();
						}else {
							startX=Integer.parseInt(txtXStart.getText());
							startY=Integer.parseInt(txtYStart.getText());
							endX=Integer.parseInt(txtXEnd.getText());
							endY=Integer.parseInt(textYEnd.getText());
						for (Shapes shapes : PnlDrawing.shapesarraylist) {
							if(shapes.isSelected()) {
								if(shapes instanceof Line) {
									((Line)shapes).setStart(new Point(startX,startY));
									((Line)shapes).setEnd(new Point(endX,endY));
									if(edgeColorB==true) {
										shapes.setEdgeColor(edgeColor);
										edgeColorB=false;
									}
								}
							}
						}
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
						.addGap(54)
						.addComponent(btnOkay)
						.addGap(210)
						.addComponent(btnCancel)
						.addGap(53))
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

	public JTextField getTxtXStart() {
		return txtXStart;
	}

	public void setTxtXStart(JTextField txtXStart) {
		this.txtXStart = txtXStart;
	}

	public JTextField getTxtYStart() {
		return txtYStart;
	}

	public void setTxtYStart(JTextField txtYStart) {
		this.txtYStart = txtYStart;
	}

	public JTextField getTxtXEnd() {
		return txtXEnd;
	}

	public void setTxtXEnd(JTextField txtXEnd) {
		this.txtXEnd = txtXEnd;
	}

	public JTextField getTextYEnd() {
		return textYEnd;
	}

	public void setTextYEnd(JTextField textYEnd) {
		this.textYEnd = textYEnd;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}
}
