package jframe;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.staffDao;
import entity.staff;
import entity.ware;
import service.wareService;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class systemJFrame extends JInternalFrame {

	private JTable table;
	DefaultTableModel tm = new DefaultTableModel();
	int countNo = tm.getRowCount();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					systemJFrame frame = new systemJFrame();
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
	public systemJFrame() {
		setTitle("\u7BA1\u7406\u8D26\u53F7\u8BBE\u7F6E\uFF0C\u670D\u52A1\u521B\u9020\u4EF7\u503C");
		setBounds(100, 100, 764, 393);
		setClosable(true);
		// 设置窗口关闭
		setMaximizable(true);
		// 设置窗口最大化

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel, BorderLayout.NORTH);

		JButton btnNewButton_5 = new JButton("\u6298\u6263\u8BBE\u7F6E");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countJFrame count = new countJFrame();
				count.setVisible(true);
			}
		});

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("\u603B\u8BB0\u5F55\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);

		JLabel lb_sum = new JLabel("0");
		lb_sum.setFont(new Font("黑体", Font.PLAIN, 20));
		panel_1.add(lb_sum);

		JButton btnNewButton = new JButton("\u6DFB\u52A0\u5458\u5DE5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				staffaddJFrame people = new staffaddJFrame(tm, lb_sum);
				people.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton);
		
				JButton btnNewButton_1 = new JButton("\u5458\u5DE5\u5DE5\u8D44");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						wagesJFrame wage=new wagesJFrame();
						wage.setVisible(true);
					}
				});
				btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
				panel.add(btnNewButton_1);
		
				JButton btnNewButton_2 = new JButton("\u6570\u636E\u5907\u4EFD");
				btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
				panel.add(btnNewButton_2);
		
				JButton btnNewButton_3 = new JButton("\u8F6F\u4EF6\u8BBE\u7F6E");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						softJFrame soft = new softJFrame();
						soft.setVisible(true);
					}
				});
				btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));
				panel.add(btnNewButton_3);
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton_5);

		JButton btnNewButton_4 = new JButton("\u6253\u5370\u6D4B\u8BD5");
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton_4);
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		// 设置表格模型
		table.setModel(tm);
		tm.addColumn("员工号");
		tm.addColumn("密码");
		tm.addColumn("真实姓名");
		tm.addColumn("职位");
		tm.addColumn("提成比例（千分比）");
		// 连接sevice
		staffDao ss = new staffDao();
		try {
			List<staff> list = ss.queryAll();
			for (staff staff : list) {
				tm.addRow(new Object[] { staff.getId(), staff.getPass(), staff.getRealname(), staff.getIden(),
						staff.getIncome() });
//						System.out.println(ware.getwareid()+ware.getwarename()+ware.getwaredd()+ware.getcolor()+ware.getsize()+"ware.getinprize()"+"ware.getoutprize()"+"ware.getnum()");
			}
			countNo = tm.getRowCount();
			lb_sum.setText(String.valueOf(countNo));// 设置值
		} catch (Exception e1) {
//					e1.printStackTrace();
		}

		scrollPane.setViewportView(table);
	}

}
