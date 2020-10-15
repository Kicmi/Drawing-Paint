package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;

import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackFrm extends JFrame {

	private JPanel contentPane;
	DefaultListModel dlm=new DefaultListModel();
	Stack<Rectangle> stack = new Stack<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrm frame = new StackFrm();
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
	public StackFrm() {
		setTitle("II53-2015 Mikic Vladimir; Stack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList lstRect = new JList();
		scrollPane.setViewportView(lstRect);
		pnlCenter.setLayout(gl_pnlCenter);
		
		lstRect.setModel(dlm); 
		
		JPanel pnlDown = new JPanel();
		contentPane.add(pnlDown, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StackDlg stackdlg = new StackDlg();
				stackdlg.setVisible(true);
				if(stackdlg.isOk==true) {
				Rectangle rect = new Rectangle(new Point(Integer.parseInt(stackdlg.getTxtXCoord().getText()),
						 (Integer.parseInt(stackdlg.getTxtYCoord().getText()))),
						 (Integer.parseInt(stackdlg.getTxtWidth().getText())),
						 (Integer.parseInt(stackdlg.getTxtHeight().getText())));
				
				stack.push(rect); 
				dlm.add(0, "X coord: " + rect.getUpperLeftPoint().getX() + " , Y coord: " + rect.getUpperLeftPoint().getY()
						+ " , Width: " + rect.getWidth() + " , Height: " + rect.getHeight());
				System.out.println(stack);
				}
			}
		});
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "NEMA OBJEKATA ZA BRISANJE, LISTA JE PRAZNA!", "GRESKA", JOptionPane.ERROR_MESSAGE);
					} else {
					StackDlg stackdelete = new StackDlg(); 
					
					String[] split = dlm.firstElement().toString().split(" "); 
					stackdelete.getTxtXCoord().setText(split [2]);
					stackdelete.getTxtYCoord().setText(split [6]);
					stackdelete.getTxtWidth().setText(split [9]);
					stackdelete.getTxtHeight().setText(split [12]);
					stackdelete.setVisible(true);
					if(stackdelete.isDelete()==true) {
						stack.pop();
						dlm.removeElementAt(0);
					}
				}
				
				
			}
		});
		GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
		gl_pnlDown.setHorizontalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlDown.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
					.addComponent(btnRemove)
					.addContainerGap())
		);
		gl_pnlDown.setVerticalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addGroup(gl_pnlDown.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemove))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlDown.setLayout(gl_pnlDown);
	}
}
