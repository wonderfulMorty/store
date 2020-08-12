package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.UsersService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class registerJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerJFrame frame = new registerJFrame();
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
	public registerJFrame() {
		setTitle("\u6CE8\u518C\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(66, 39, 81, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" \u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(66, 75, 81, 21);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setBounds(162, 36, 154, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 24));
		passwordField.setBounds(162, 72, 154, 27);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				loginJFrame login=new loginJFrame();
				login.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.setBounds(51, 163, 96, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1 获取用户名和密码
				String id=textField.getText();
				String pass=passwordField.getText();
				String lable=textField_1.getText();
				//2 注册
				UsersService service=new UsersService();
				try {
					service.register(id,pass,lable);
					JOptionPane.showMessageDialog(null, "注册成功");
					setVisible(false);
					loginJFrame login=new loginJFrame();
					login.setVisible(true);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
//					e1.printStackTrace();
				}
//				if(userName==null||"".equals(userName)) {
//					JOptionPane.showMessageDialog(null, "用户名不能为空");
//					textField.setText(null);
//					passwordField.setText(null);
//					return;
//				}
//				if(pass==null||"".equals(pass)) {
//					JOptionPane.showMessageDialog(null, "密码不能为空");
//					textField.setText(null);
//					passwordField.setText(null);
//					return;
//				}
//				
//				//3 唯一性判断
//				if(userName.equals("admin")) {
//					JOptionPane.showMessageDialog(null, "该用户已被注册");
//					textField.setText(null);
//					passwordField.setText(null);
//					return;
//				}
//				//4.添加
//				//保存
//				JOptionPane.showMessageDialog(null, "注册成功，请先登录");
//				System.out.println(userName+pass);
//				setVisible(false);
//				loginJFrame login=new loginJFrame();
//				login.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(195, 163, 96, 29);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(" \u8EAB\u4EFD");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(66, 113, 81, 21);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(162, 110, 154, 27);
		panel.add(textField_1);
	}
}
