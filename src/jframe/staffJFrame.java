package jframe;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.staffDao;
import entity.staff;
import entity.ware;
import service.staffService;
import service.wareService;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class staffJFrame extends JInternalFrame {
	private JTable table;
	private JTextField textField;
	DefaultTableModel tm = new DefaultTableModel();
	int countNo = tm.getRowCount();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffJFrame frame = new staffJFrame();
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
	public staffJFrame() {
		setTitle("\u5458\u5DE5\u7BA1\u7406");
		setBounds(100, 100, 719, 420);
		setClosable(true);
		// 设置窗口关闭
		setMaximizable(true);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel, BorderLayout.NORTH);


		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JLabel lblNewLabel_1 = new JLabel("\u5458\u5DE5\u8BB0\u5F55\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1);

		JLabel lb_sum = new JLabel("0");
		lb_sum.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(lb_sum);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u5458\u5DE5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffaddJFrame people = new staffaddJFrame(tm, lb_sum);
				people.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u4FEE\u6539\u5458\u5DE5\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = table.getSelectedRowCount();
				if (rowCount == 0) {
					// 提示请选择需要修改的行
					JOptionPane.showMessageDialog(null, "请选择需要修改的行");
					return;
				}
				if (rowCount > 1) {
					// 提示一次只能修改一行
					JOptionPane.showMessageDialog(null, "请选择需要修改的一行");
					return;
				}
				if (rowCount == 1) {
					// 修改 显示修改界面
					// 获取选中的行以及该行的初始值
					int indexRow = table.getSelectedRow();
					staffupdateJFrame update = new staffupdateJFrame(tm, indexRow);
					update.setVisible(true);
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u5220\u9664\u5458\u5DE5\u4FE1\u606F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = table.getSelectedRowCount();
				if (rowCount == 0) {
					// 提示请选择需要删除的行
					JOptionPane.showMessageDialog(null, "请选择需要删除的行");
					return;
				}
				if (rowCount > 1) {
					// 提示一次只能删除一行
					JOptionPane.showMessageDialog(null, "请选择需要删除的一行");
					return;
				}
				if (rowCount == 1) {
					// 删除
					// 获取选中的行的索引
					int confirmAnswer= JOptionPane.showConfirmDialog(null, "是否确定删除？");
					if(confirmAnswer==0) {
						int indexRow=table.getSelectedRow();
						String delid=tm.getValueAt(indexRow, 0).toString();
						staffService ss=new staffService();
						try {
							ss.delByid(delid);
							tm.removeRow(indexRow);
							lb_sum.setText(String.valueOf(tm.getRowCount()));
							JOptionPane.showMessageDialog(null, "删除成功");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1.1 获取文本框----搜索字符串
				String id = textField.getText();
				staffService ss1 = new staffService();
				try {
					List<staff> list1 = ss1.queryId(id);
					for (staff staff : list1) {
						int rowCount = tm.getRowCount();// 行的总数
						for (int i = 0; i < rowCount; i++) {
							tm.removeRow(0);
						}
						tm.addRow(
								new Object[] { staff.getId(),staff.getPass(),staff.getRealname(),staff.getIden(),staff.getIncome() });
						countNo = tm.getRowCount();
						lb_sum.setText(String.valueOf(countNo));// 设置值
						JOptionPane.showMessageDialog(null, "查询成功");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
//					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(btnNewButton_3);


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
//								System.out.println(ware.getwareid()+ware.getwarename()+ware.getwaredd()+ware.getcolor()+ware.getsize()+"ware.getinprize()"+"ware.getoutprize()"+"ware.getnum()");
			}
			countNo = tm.getRowCount();
			lb_sum.setText(String.valueOf(countNo));// 设置值
		} catch (Exception e1) {
//							e1.printStackTrace();
		}
		scrollPane.setViewportView(table);

	}

}
