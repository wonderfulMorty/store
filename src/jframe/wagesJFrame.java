package jframe;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import entity.saleware;
import service.salewareService;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class wagesJFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textStart;
	private JTextField textEnd;
	DefaultTableModel tm = new DefaultTableModel();
	double countNo = 0;
	int countNonum = tm.getRowCount();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wagesJFrame frame = new wagesJFrame();
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
	public wagesJFrame() {
		setTitle("\u5458\u5DE5\u9500\u552E\u989D\u7EDF\u8BA1\uFF0C\u8BA1\u7B97\u5DE5\u8D44");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("\u5F00\u59CB\u65E5\u671F\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);

		textStart = new JTextField();
		// 设置初始日期
		Date d = new Date();
		textStart.setText(d.getYear() + 1900 + ""
				+ ((d.getMonth() + 1) < 10 ? ("0" + (d.getMonth() + 1)) : (d.getMonth() + 1)) + "" + "01");
		textStart.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(textStart);
		textStart.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("\u7EC8\u6B62\u65E5\u671F\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel_1_1);

		textEnd = new JTextField();
		// 设置终止日期
		textEnd.setText(
				d.getYear() + 1900 + "" + ((d.getMonth() + 1) < 10 ? ("0" + (d.getMonth() + 1)) : (d.getMonth() + 1))
						+ "" + ((d.getDate()) < 10 ? ("0" + (d.getDate())) : (d.getDate())));
		textEnd.setFont(new Font("宋体", Font.PLAIN, 20));
		textEnd.setColumns(10);
		panel.add(textEnd);

		JButton btnNewButton = new JButton("\u67E5\u8BE2\u9500\u552E\u63D0\u6210");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount =table.getRowCount();
				for(int i=0;i<rowCount;i++) {
					tm.removeRow(0);
				}
				salewareService ss=new salewareService();
				List<saleware> list=null;
				try {
						      list=ss.queryAll(textStart.getText(),textEnd.getText());
					for ( saleware s : list) {
					      double wage=Double.parseDouble(s.getSumprize())*Double.parseDouble(s.getStaff().getIncome())*0.1;
						tm.addRow(new Object[] {s.getStaff().getId(),s.getStaff().getRealname(),s.getSumprize(),s.getStaff().getIncome(),String.valueOf(wage)});
						
					}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("\u670D\u52A1\u521B\u9020\u4EF7\u503C");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		// 设置表格模型
				table.setModel(tm);
				tm.addColumn("员工号");
				tm.addColumn("员工姓名");
				tm.addColumn("销售总额");
				tm.addColumn("提成比例");
				tm.addColumn("工资");
		scrollPane.setViewportView(table);
	}

}
