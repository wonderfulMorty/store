package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import service.staffService;
import service.wareService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class staffupdateJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	

	/**
	 * Create the frame.
	 * @param indexRow 
	 * @param tm 
	 */
	public staffupdateJFrame(final DefaultTableModel tm,final int indexRow) {
		setTitle("\u5458\u5DE5\u4FE1\u606F\u4FEE\u6539");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" \u5458\u5DE5\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(50, 32, 93, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  \u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(50, 71, 93, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5458\u5DE5\u59D3\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(50, 107, 111, 21);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("  \u804C\u4F4D");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(50, 143, 93, 21);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u63D0\u6210\u6BD4\u4F8B");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(50, 179, 111, 21);
		panel.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(tm.getValueAt(indexRow, 0).toString());
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setBounds(175, 31, 146, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(tm.getValueAt(indexRow, 1).toString());
		textField_1.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(175, 70, 146, 27);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText(tm.getValueAt(indexRow, 2).toString());
		textField_2.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(175, 106, 146, 27);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText(tm.getValueAt(indexRow, 3).toString());
		textField_3.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(175, 142, 146, 27);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText(tm.getValueAt(indexRow, 4).toString());
		textField_4.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(175, 178, 146, 27);
		panel.add(textField_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("\u5343\u5206\u6BD4");
		lblNewLabel_4_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_4_1.setBounds(329, 181, 74, 21);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("\u6BD4\u59820.05,100\r\n0\u5143\u9500\u552E\u989D\u63D0\u621050\u5143");
		lblNewLabel_4_2.setForeground(Color.RED);
		lblNewLabel_4_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_4_2.setBounds(84, 210, 302, 33);
		panel.add(lblNewLabel_4_2);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.setBounds(94, 256, 93, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改
				  //1获取文本框的内容
				  String id=textField.getText();
				  String pass=textField_1.getText();
				  String realname=textField_2.getText();
				  String iden=textField_3.getText();
				  String income=textField_4.getText();
				  //连接service
				  staffService ss=new staffService();
				  int no=0;
				  try {
					  ss.update(id,pass,realname,iden,income);
					  JOptionPane.showMessageDialog(null,"修改成功");
					  //2修改
					  tm.setValueAt(id,indexRow,0);
					  tm.setValueAt(pass,indexRow,1);
					  tm.setValueAt(realname,indexRow,2);
					  tm.setValueAt(iden,indexRow,3);
					  tm.setValueAt(income,indexRow,4);
					  setVisible(false);
					  
				} catch (Exception e1) {
					  JOptionPane.showMessageDialog(null,e1.getMessage());
					//e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(220, 256, 93, 29);
		panel.add(btnNewButton_1);
	}
}
