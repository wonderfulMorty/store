package jframe;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Users;
import entity.staff;
import service.UsersService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class loginJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	static Users user=new Users();
	static String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginJFrame frame = new loginJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
//					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginJFrame() {
		setBackground(Color.WHITE);
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(50, 52, 81, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" \u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(50, 100, 81, 21);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setBounds(156, 49, 154, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 24));
		passwordField.setBounds(156, 99, 154, 27);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.setBounds(35, 171, 96, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerJFrame register=new registerJFrame();
				register.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(143, 171, 97, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u767B\u5F55");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id=textField.getText();
				String pass=passwordField.getText();
				UsersService service=new UsersService();
				try{
					service.login(id, pass);
					user=service.login(id, pass);
//					user=service.login1(id, pass);
					JOptionPane.showMessageDialog(null, "登陆成功");
					//点击登录我们的主界面显示
					StoreJFrame storejframe=new StoreJFrame();
					storejframe.setVisible(true);
					setVisible(false);
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
//					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_2.setBounds(255, 171, 96, 29);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u5F55\u9047\u5230\u95EE\u9898");
		lblNewLabel_2.setBounds(205, 135, 126, 21);
		panel.add(lblNewLabel_2);
	}
}
