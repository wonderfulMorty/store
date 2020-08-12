package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import service.menberService;
import service.wareService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menberupdateJFrame extends JFrame {


	private static DefaultTableModel tm=new DefaultTableModel();
	private static int indexRow;
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
					menberupdateJFrame frame = new menberupdateJFrame(tm,indexRow);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param indexRow 
	 * @param tm 
	 */
	public menberupdateJFrame(DefaultTableModel tm, int indexRow) {
		setTitle("\u4F1A\u5458\u4FE1\u606F\u4FEE\u6539");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" \u4F1A\u5458\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(44, 37, 106, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F1A\u5458\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(44, 73, 106, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("  \u6027\u522B");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(44, 109, 106, 21);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("  \u7535\u8BDD");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_1_1.setBounds(44, 145, 106, 21);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(" \u6298\u6263\u7387");
		lblNewLabel_1_1_1_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1_1_1_1.setBounds(44, 181, 106, 21);
		panel.add(lblNewLabel_1_1_1_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(tm.getValueAt(indexRow, 0).toString());
		textField.setFont(new Font("宋体", Font.PLAIN, 24));
		textField.setBounds(166, 36, 170, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(tm.getValueAt(indexRow, 1).toString());
		textField_1.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(165, 72, 170, 27);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText(tm.getValueAt(indexRow, 2).toString());
		textField_2.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(165, 108, 170, 27);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText(tm.getValueAt(indexRow, 3).toString());
		textField_3.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(166, 144, 170, 27);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText(tm.getValueAt(indexRow, 4).toString());
		textField_4.setFont(new Font("宋体", Font.PLAIN, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(165, 180, 170, 27);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.setBounds(95, 232, 97, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//修改
				//1 获取文本框内容
				String mid=textField.getText();
				String mname=textField_1.getText();
				//Object--String--int
				String msex=textField_2.getText();
				String mtel=textField_3.getText();
				String mcount=textField_4.getText();
				
//				System.out.println(wareid+warename+waredd+color+size+inprize+outprize+num);
				  //连接service
				  menberService ss=new menberService();
				  int no=0;
				  try {
					  ss.update(mid,mname,msex,mtel,mcount);
					  JOptionPane.showMessageDialog(null,"修改成功");
					  setVisible(false);
					//2完成界面同步修改
					  tm.setValueAt(mid,indexRow,0);
					  tm.setValueAt(mname,indexRow,1);
					  tm.setValueAt(msex,indexRow,2);
					  tm.setValueAt(mtel,indexRow,3);
					  tm.setValueAt(mcount,indexRow,4);
					  
				} catch (Exception e1) {
					  JOptionPane.showMessageDialog(null,e1.getMessage());
					//e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.setBounds(207, 232, 97, 29);
		panel.add(btnNewButton_1);
	}
}
