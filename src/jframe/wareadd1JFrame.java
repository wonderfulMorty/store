package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.ware;
import service.wareService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class wareadd1JFrame extends JFrame {

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wareadd1JFrame frame = new wareadd1JFrame();
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
	public wareadd1JFrame() {
		setTitle("\u5546\u54C1\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u6761\u7801");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(62, 55, 111, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(62, 91, 111, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("  \u8D27\u53F7");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(62, 127, 111, 21);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("  \u989C\u8272");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_2.setBounds(62, 163, 111, 21);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("  \u5C3A\u7801");
		lblNewLabel_1_2_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_2_1.setBounds(60, 195, 111, 21);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("  \u8FDB\u4EF7");
		lblNewLabel_1_2_1_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_2_1_1.setBounds(60, 227, 111, 21);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("  \u552E\u4EF7");
		lblNewLabel_1_2_1_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_2_1_2.setBounds(62, 259, 111, 21);
		panel.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("\u6DFB\u52A0\u6570\u91CF");
		lblNewLabel_1_2_1_2_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_2_1_2_1.setBounds(63, 293, 111, 21);
		panel.add(lblNewLabel_1_2_1_2_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setColumns(10);
		textField.setBounds(195, 52, 138, 27);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(194, 88, 138, 27);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(195, 122, 138, 27);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(195, 159, 138, 27);
		panel.add(textField_3);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u5E93\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.setBounds(59, 343, 138, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u5546\u54C1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1 获取文本框的内容
				String wareid=textField.getText();
				String warename=textField_1.getText();
				String waredd=textField_2.getText();
				String color=textField_3.getText();
				String size=textField_4.getText();
				String inprize=textField_5.getText();
				String outprize=textField_6.getText();
				String num=textField_7.getText();
		
				//2.封装对象
				ware ware=new ware(wareid,warename,waredd,color,size,inprize,outprize,num);
				wareService ss=new wareService();
				try {//疑似有异常的对象
					ss.addware(ware);
					 JOptionPane.showMessageDialog(null, "添加成功");
					 setVisible(false);
			        
				} catch(Exception e1){
					 JOptionPane.showMessageDialog(null,e1.getMessage());
	                   //e1.printStackTrace();
			   }
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(214, 344, 138, 29);
		panel.add(btnNewButton_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(195, 191, 138, 27);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_5.setColumns(10);
		textField_5.setBounds(196, 224, 138, 27);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_6.setColumns(10);
		textField_6.setBounds(196, 258, 138, 27);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_7.setColumns(10);
		textField_7.setBounds(197, 292, 138, 27);
		panel.add(textField_7);
	}

}
