package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entity.menber;
import entity.ware;
import service.menberService;
import service.wareService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menberaddJFrame extends JFrame {


	private static DefaultTableModel tm=new DefaultTableModel();
	private static JLabel lablecount=new JLabel();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menberaddJFrame frame = new menberaddJFrame(tm,lablecount);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param lb_sum 
	 * @param tm 
	 */
	public menberaddJFrame(DefaultTableModel tm, JLabel lb_sum) {
		setTitle("\u4F1A\u5458\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" \u4F1A\u5458\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(36, 41, 102, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F1A\u5458\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(36, 77, 102, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  \u6027\u522B");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(36, 113, 102, 21);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("  \u7535\u8BDD");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(36, 149, 102, 21);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" \u6298\u6263\u7387");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(36, 185, 102, 21);
		panel.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setBounds(153, 40, 164, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(153, 76, 164, 27);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(153, 112, 164, 27);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(153, 148, 164, 27);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(153, 184, 164, 27);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.setBounds(70, 243, 102, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1 获取文本框的内容
				String mid=textField.getText();
				String mname=textField_1.getText();
				String msex=textField_2.getText();
				String mtel=textField_3.getText();
				String mcount=textField_4.getText();
		
				//2.封装对象
				menber menber=new menber(mid,mname,msex,mtel,mcount);
				menberService ss=new menberService();
				try {//疑似有异常的对象
					ss.addmenber(menber);
			    	tm.addRow(new Object[] {mid,mname,msex,mtel,mcount});//添加界面
					lb_sum.setText(String.valueOf(tm.getRowCount()));
					 JOptionPane.showMessageDialog(null, "添加成功");
					 setVisible(false);
			        
				} catch(Exception e1){
					 JOptionPane.showMessageDialog(null,e1.getMessage());
	                   //e1.printStackTrace();
			   }
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(201, 243, 102, 29);
		panel.add(btnNewButton_1);
	}
}
