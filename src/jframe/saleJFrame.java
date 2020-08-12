package jframe;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entity.saleware;
import entity.saleware1;
import service.saleware1Service;
import service.salewareService;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class saleJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private int count;
	private ButtonGroup buttongroup = new ButtonGroup();
	private JTextField textField_5;
	private JTextField textField_6;
	private static DefaultTableModel tm = new DefaultTableModel();
	private static JLabel lb_sum = new JLabel();
	private static JLabel lb_num = new JLabel();
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saleJFrame frame = new saleJFrame(tm, lb_sum, lb_num);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param lb_num 
	 * @param lb_sum 
	 * @param tm 
	 */
	public saleJFrame(DefaultTableModel tm, JLabel lb_sum, JLabel lb_num) {
		setTitle("\u5546\u54C1\u9500\u552E\uFF0C\u670D\u52A1\u521B\u9020\u4EF7\u503C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("\u9000\u8D27");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.setBounds(15, 15, 93, 29);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u91CD\u65B0\u6253\u5370");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(256, 15, 143, 29);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u6761\u7801");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(62, 82, 111, 21);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(62, 118, 111, 21);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("  \u539F\u4EF7");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(62, 238, 111, 21);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("  \u552E\u4EF7");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(62, 274, 111, 21);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("  \u6570\u91CF");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(62, 310, 111, 21);
		panel.add(lblNewLabel_4);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setBounds(188, 79, 164, 27);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(188, 115, 164, 27);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(188, 235, 164, 27);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(188, 271, 164, 27);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setText("1");
		textField_4.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(236, 307, 64, 27);
		panel.add(textField_4);

		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				count = count - 1;
				if (count < 0) {
					JOptionPane.showMessageDialog(null, "我是有底线的!");
					return;
				}
				textField_4.setText(String.valueOf(count));
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_2.setBounds(188, 306, 50, 29);
		panel.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("+");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // 累加
				   count = Integer.parseInt(textField_4.getText())+1;
				   
				   textField_4.setText(String.valueOf(count));
			}
		});
		btnNewButton_2_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_2_1.setBounds(300, 306, 50, 29);
		panel.add(btnNewButton_2_1);

		JButton btnNewButton_3 = new JButton("\u9500\u552E");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1 获取文本框的内容
				String wareid=textField.getText();
				String warename=textField_1.getText();
				String size=textField_6.getText();
				String color=textField_5.getText();
				String warenum=textField_4.getText();
				String realprize=textField_2.getText();
				String sumprize=textField_3.getText();
				String sname=textField_7.getText();
//				int num=Integer.parseInt(textField_7.getText());
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//				System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

		
				//2.封装对象
				saleware1 saleware=new saleware1(wareid,warename,size,color,warenum,realprize,sumprize,df.format(new Date()),sname);
				saleware1Service ss=new saleware1Service();
				try {//疑似有异常的对象
					ss.addsaleware1(saleware);
			    	tm.addRow(new Object[] {wareid,warename,size,color,warenum,realprize,sumprize,df.format(new Date()),sname});//添加界面
					lb_num.setText(String.valueOf(tm.getRowCount()));
					double sum=Double.parseDouble(lb_sum.getText())+Double.parseDouble(sumprize)*Double.parseDouble(textField_4.getText());
					lb_sum.setText(String.valueOf(sum));
					JOptionPane.showMessageDialog(null, "销售成功");
					setVisible(false);
			        
				} catch(Exception e1){
					 JOptionPane.showMessageDialog(null,e1.getMessage());
	                   //e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_3.setBounds(225, 387, 127, 29);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("\u53D6\u6D88");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_3_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_3_1.setBounds(72, 387, 127, 29);
		panel.add(btnNewButton_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("  \u989C\u8272");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(62, 196, 111, 21);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("  \u5C3A\u7801");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_1_1.setBounds(62, 160, 111, 21);
		panel.add(lblNewLabel_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_5.setColumns(10);
		textField_5.setBounds(188, 193, 164, 27);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_6.setColumns(10);
		textField_6.setBounds(188, 157, 164, 27);
		panel.add(textField_6);
		
		JLabel lblNewLabel_4_1 = new JLabel(" \u9500\u552E\u5458");
		lblNewLabel_4_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_4_1.setBounds(62, 346, 111, 21);
		panel.add(lblNewLabel_4_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_7.setColumns(10);
		textField_7.setBounds(188, 345, 164, 27);
		panel.add(textField_7);
		
		
	}
}
