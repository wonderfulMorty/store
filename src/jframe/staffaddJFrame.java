package jframe;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entity.staff;
import service.staffService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class staffaddJFrame extends JFrame {

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
					staffaddJFrame frame = new staffaddJFrame(tm,lablecount);
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
	public staffaddJFrame(DefaultTableModel tm, JLabel lablecount) {
		setTitle("\u6DFB\u52A0\u5458\u5DE5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" \u5458\u5DE5\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(36, 34, 96, 21);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  \u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(36, 66, 96, 21);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u771F\u5B9E\u59D3\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(36, 102, 96, 21);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("  \u804C\u4F4D");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(36, 138, 96, 21);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u63D0\u6210\u6BD4\u4F8B");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(36, 174, 96, 21);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("\u5343\u5206\u6BD4");
		lblNewLabel_4_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_4_1.setBounds(329, 174, 96, 21);
		panel_1.add(lblNewLabel_4_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setBounds(166, 33, 147, 27);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(166, 65, 147, 27);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(166, 101, 147, 27);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(166, 137, 147, 27);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(166, 173, 147, 27);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_4_2 = new JLabel("\u6BD4\u59820.05,100\r\n0\u5143\u9500\u552E\u989D\u63D0\u621050\u5143");
		lblNewLabel_4_2.setForeground(Color.RED);
		lblNewLabel_4_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_4_2.setBounds(96, 210, 302, 33);
		panel_1.add(lblNewLabel_4_2);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.setBounds(90, 254, 96, 29);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1 获取文本框的内容
				String id=textField.getText();
				String pass=textField_1.getText();
				String realname=textField_2.getText();
				String iden=textField_3.getText();
				String income=textField_4.getText();
				//2.封装对象
				staff people=new staff(id,pass,realname,iden,income);
				staffService ss=new staffService();
				try {//疑似有异常的对象
					ss.addpeople(people);
			    	tm.addRow(new Object[] {id, pass,realname, iden,income});//添加界面
					lablecount.setText(String.valueOf(tm.getRowCount()));
					 JOptionPane.showMessageDialog(null, "添加成功");
					 setVisible(false);
			        
				} catch(Exception e1){
					 JOptionPane.showMessageDialog(null,e1.getMessage());
	                   //e1.printStackTrace();
			   }
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(226, 254, 96, 29);
		panel_1.add(btnNewButton_1);
	}
}
