package jframe;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import service.menberService;
import service.wareService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class wareupdateJFrame extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;


	/**
	 * Create the frame.
	 * @param indexRow 
	 * @param tm 
	 */
	public wareupdateJFrame(final DefaultTableModel tm, final int indexRow) {
		setTitle("\u5546\u54C1\u4FEE\u6539\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改
				  //1获取文本框的内容
				  String wareid=textField.getText();
				  String warename=textField_1.getText();
				  String waredd=textField_2.getText();
				  String color=textField_3.getText();
				  String size=textField_4.getText();
				  String inprize=textField_5.getText();
				  String outprize=textField_6.getText();
				  String num=textField_7.getText();
				  //连接service
				  wareService ss=new wareService();
				  int no=0;
				  try {
					  ss.update(wareid,warename,waredd,color,size,inprize,outprize,num);
					  JOptionPane.showMessageDialog(null,"修改成功");
					  //2修改
					  tm.setValueAt(wareid,indexRow,0);
					  tm.setValueAt(warename,indexRow,1);
					  tm.setValueAt(waredd,indexRow,2);
					  tm.setValueAt(color,indexRow,3);
					  tm.setValueAt(size,indexRow,4);
					  tm.setValueAt(inprize,indexRow,5);
					  tm.setValueAt(outprize,indexRow,6);
					  tm.setValueAt(num,indexRow,7);
					  setVisible(false);
					  
				} catch (Exception e1) {
					  JOptionPane.showMessageDialog(null,e1.getMessage());
					//e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(215, 334, 104, 29);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u6761\u7801");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(34, 27, 111, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(34, 63, 111, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  \u8D27\u53F7");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(34, 99, 111, 21);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("  \u989C\u8272");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(34, 135, 111, 21);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("  \u5C3A\u7801");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(34, 171, 111, 21);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("  \u8FDB\u4EF7");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_5.setBounds(34, 207, 111, 21);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("  \u552E\u4EF7");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_6.setBounds(34, 243, 111, 21);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("  \u6570\u91CF");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_7.setBounds(34, 279, 111, 21);
		panel.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(tm.getValueAt(indexRow, 0).toString());
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setBounds(170, 26, 162, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(tm.getValueAt(indexRow, 1).toString());
		textField_1.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(170, 62, 162, 27);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText(tm.getValueAt(indexRow, 2).toString());
		textField_2.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(170, 98, 162, 27);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText(tm.getValueAt(indexRow, 3).toString());
		textField_3.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(170, 134, 162, 27);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText(tm.getValueAt(indexRow, 4).toString());
		textField_4.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(170, 170, 162, 27);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText(tm.getValueAt(indexRow, 5).toString());
		textField_5.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_5.setColumns(10);
		textField_5.setBounds(170, 206, 162, 27);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText(tm.getValueAt(indexRow, 6).toString());
		textField_6.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_6.setColumns(10);
		textField_6.setBounds(170, 242, 162, 27);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText(tm.getValueAt(indexRow, 7).toString());
		textField_7.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_7.setColumns(10);
		textField_7.setBounds(170, 278, 162, 27);
		panel.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(74, 334, 104, 29);
		panel.add(btnNewButton_1);
	}
}
